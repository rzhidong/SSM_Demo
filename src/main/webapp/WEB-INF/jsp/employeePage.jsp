<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工管理页面</title>
</head>
<body>
<div class="ssm_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="ssm_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 中间员工表格信息展示内容 -->
        <div class="emp_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">员工管理</a></li>
                        <li class="active">员工信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="emp_table">
                    <thead>
                    <th>员工编号</th>
                    <th>员工姓名</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>部门</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${employees}" var="emp">
                            <tr>
                                <td>${emp.empId}</td>
                                <td>${emp.empName}</td>
                                <td>${emp.empEmail}</td>
                                <td>${emp.gender == "F"? "女": "男"}</td>
                                <td>${emp.department.deptName}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary emp_edit_btn" data-toggle="modal" data-target=".emp-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger emp_delete_btn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span class="badge">${curPage}</span>页，共有<span class="badge">${totalPages}</span>页，总记录数<span class="badge">${totalItems}</span>条。
                    </div>
                    <nav aria-label="Page navigation" class="pull-right">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=1">首页</a></li>
                            <!-- 上一页  -->
                            <!-- 当当前页码为1时，隐藏上一页按钮  -->
                            <c:if test="${curPage==1}">
                                <li class="disabled">
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <!-- 当当前页码不等于1时，跳转到上一页  -->
                            <c:if test="${curPage!=1}">
                                <li>
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <!-- 上一页  end-->
                            
                             <!-- 页码  -->
                            <!-- 当总页数小于等于7时，显示页码1...7页 -->
                            <c:if test="${totalPages<=7}">
                            	<c:forEach begin="1" end="${totalPages}" step="1" var="itemPage">
                                	<li <c:if test="${curPage == itemPage}">class="active"</c:if>>
                                    	<a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=${itemPage}">${itemPage}</a>
                                    </li>
                            	</c:forEach>
                            </c:if>
                            
                            <!-- 当总页数大于7时 -->
                            <c:if test="${totalPages>7}">
                            	<!-- 当前页数小于等于4时，显示1到5...最后一页 -->
                            	<c:if test="${curPage <=4 }">
                            		<c:forEach begin="1" end="5" step="1" var="itemPage">
                                		<li <c:if test="${curPage == itemPage}">class="active"</c:if>>
                                    		<a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=${itemPage}">${itemPage}</a>
                                    	</li>
                            		</c:forEach>
                            		<li><a href="#">...</a></li>
                            		<li><a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=${totalPages}">${totalPages}</a></li>
                            	</c:if>
                            	<!-- 当前页数小于等于4时，显示1到5...最后一页  end -->
                            	
                            	<!-- 当前页数大于4时，如果当前页小于总页码书-3，则显示1...n-1,n,n+1...最后一页 -->
                            	<c:if test="${curPage > 4 && (curPage < totalPages-4) }">
                            		<li><a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=1">1</a></li>
                            		<li><a href="#">...</a></li>
                            		<c:forEach begin="${curPage-1 }" end="${curPage +1  }" step="1" var="itemPage">
                                		<li <c:if test="${curPage == itemPage}">class="active"</c:if>>
                                    		<a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=${itemPage}">${itemPage}</a>
                                    	</li>
                            		</c:forEach>
                            		<li><a href="#">...</a></li>
                            		<li><a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=${totalPages}">${totalPages}</a></li>
                            	</c:if>
                            	<!-- 当前页数大于4时，如果当前页小于总页码书-3，则显示1...n-1,n,n+1...最后一页 end-->
                            	
                            	<!-- 当前页码小于等于n-4  -->
                            	<c:if test="${curPage >=  totalPages-4}">
                            		<li><a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=1">1</a></li>
                            		<li><a href="#">...</a></li>
                            		<c:forEach begin="${totalPages-5}" end="${totalPages}" step="1" var="itemPage">
                                		<li <c:if test="${curPage == itemPage}">class="active"</c:if>>
                                    		<a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=${itemPage}">${itemPage}</a>
                                    	</li>
                            		</c:forEach>
                            	</c:if>
                            	<!-- 当前页码小于等于n-4 end-->
                            </c:if>
                            
                            
							<!-- 下一页  -->
                             <!-- 当当前页码为最后一页或者最后一页为0时，隐藏下一页按钮-->
                            <c:if test="${curPage==totalPages}">
                                <li class="disabled" class="nextPage">
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <!--  当当前页码不等于总页码时，跳转下一页  -->
                            <c:if test="${curPage!=totalPages}">
                                <li>
                                    <a href="#" aria-label="Next" class="nextPage">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.ssm_body -->
</div><!-- /.container -->

<%@ include file="employeeAdd.jsp"%>
<%@ include file="employeeUpdate.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPage};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo="+pageNo);
            }
        });
    })

    //<!-- ==========================员工删除操作=================================== -->
    $(".emp_delete_btn").click(function () {
        var curPage = ${curPage};
        var delEmpId = $(this).parent().parent().find("td:eq(0)").text();
        var delEmpName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delEmpName+ "】的信息吗？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/ssm/emp/deleteEmp/"+delEmpId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href="${pageContext.request.contextPath}/ssm/emp/getEmpList?pageNo="+curPage;
                    }else {
                        alert(result.extendInfo.emp_del_error);
                    }
                }
            });
        }
    });


</script>
</body>
</html>
