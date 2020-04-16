<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FogetPwd1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.input1 {
	width: 100px;
	height: 30px;
	background-color: #FF94B3;
}
</style>
  </head>
  
  <body>
    <table>
    <tr><td>昵称：</td><td><input type="text" name="nickName" id="nickName"></td></tr>
     <tr><td></td><td><input type="button" onclick="chakanmibao()" value="确认" class="input1"></td></tr>
    
    
    </table>
  </body>
</html>
