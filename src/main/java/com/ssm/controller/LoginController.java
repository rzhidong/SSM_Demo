package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.model.User;
import com.ssm.service.UserService;
import com.ssm.util.JsonMsg;
import com.ssm.util.MD5CryptUtil;

@Controller
@RequestMapping("/ssm")
public class LoginController {

	@Autowired
	private UserService UserService;

	/**
	 * 登录：跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			return "main";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * 对登录页面输入的用户名和密码做简单的判断
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg dologin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = UserService.findUserByUserName(username);

		if (user == null) {
			return JsonMsg.fail().addInfo("login_error", "无此帐号，请重新输入！");
		} else {
			System.out.println("IP: " + request.getRemoteHost() + "\tusername: " + username + "\tpassword: " + password);
			
			if (!MD5CryptUtil.pwdValidate(password, user.getPassword())) {
				return JsonMsg.fail().addInfo("login_error", "输入账号用户名与密码不匹配，请重新输入！");
			}

			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			return JsonMsg.success();
		}

	}

	/**
	 * 跳转到主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			return "main";
		} else {
			return "redirect:/";
		}

	}

	/**
	 * 退出登录：从主页面跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			System.out.println("IP: " + request.getRemoteHost() + "\t" + username + " logout");
			session.invalidate();
		}
		return "login";
	}
}
