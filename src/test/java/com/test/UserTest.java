package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.dao.UserDao;
import com.ssm.util.MD5CryptUtil;

@RunWith(SpringJUnit4ClassRunner.class)//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class UserTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testSelect() {
		System.out.println(userDao.selectByPrimaryKey(1));
		System.out.println(userDao.selectByUsername("admin"));
		System.out.println(MD5CryptUtil.pwdValidate("123456", userDao.selectByUsername("admin").getPassword()));
		System.out.println(userDao.selectByUsername("root"));
	}
	
}
