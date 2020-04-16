<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCustomer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link href="style/authority/add.css" rel="stylesheet" type="text/css">
     
  </head>
  
  <body>
       <div class="headimg" >
    	<img src="${requestScope.customer.headimg }" alt="图片加载失败" width="200px" height="250px"/>
    	</div>
    	<div class="mess" >
    	<div class="dash">
   		顾客编号：${requestScope.customer.customerId}
   		<br/>
   		</div>
   		 <div class="dash">
                  昵称：${requestScope.customer.nickName}
                  <br/>
       </div>
       <div class="dash">
    	性别：${requestScope.customer.gender}
    	<br/>
    	</div>
    	<div class="dash">
        真实姓名：${requestScope.customer.cName}
        <br/>
        </div>
        <div class="dash">
        手机：${requestScope.customer.phone}
        <br/>
       
       </div>
       
        <div class="dash">
        地址：${requestScope.customer.address}
        <br/>
       
       </div>
        
    </div>
    	
  
    
    
   
   
  </body>
</html>
