<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="style/authority/add.css" rel="stylesheet" type="text/css">

  </head>
  
  <body>
   <div>
		<form method="post" action="AddFlowerServlet?type=addFlower" enctype="multipart/form-data">
			<table class="mytab w600">
				<tr>
					
					<th colspan="2">个人信息详情</th>
				</tr>
				
				<tr>
					<td>用户名：</td>
					<td>${requestScope.admin.loginName}</td>
   						
				</tr>
				<tr>
					<td>性别：</td>
					<td>${requestScope.admin.gender}</td>
				</tr>

				<tr>
					<td>生日：</td>
					<td>${requestScope.admin.birthday}</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td>${requestScope.admin.address}</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td>${requestScope.admin.phone}</td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td>${requestScope.admin.email}</td>
				</tr>
				<tr>
					<td>密保问题：</td>
					<td>${requestScope.admin.miBao}</td>
				</tr>
				<tr>
					<td>密保答案：</td>
					<td>${requestScope.admin.answer}</td>
				</tr>
				
				
			</table>

		</form>
	</div>
	
</body>
</html>

