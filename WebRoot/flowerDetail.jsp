<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'flowerDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.left{
	float: left;
	border:1px solid #666;
	width: 170px;
	height: 170px;
	margin-left: 30px;
	}
	.right li{
	list-style: none;
	line-height: 50px;
	border-bottom: 1px dashed #666;
	
	}
	.right{
	float: left;
	}
	
	
	</style>

  </head>
  
  <body>
  <div class="container">
  <div class="left"><img src="${requestScope.flower.flowerimg1 }"></div>
    <div class="right">
    <ul>
    <li>种类:${requestScope.flower.flowerName } </li>
    <li>单价:${requestScope.flower.price }</li>
    <li>库存:${requestScope.flower.stock }</li>
   <li>销售量:${requestScope.flower.sold }</li>
   <li>花名:${requestScope.flower.description }</li>
  
    
    </ul>
    </div>
   </div> 
  </body>
</html>
