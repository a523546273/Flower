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
    	<img src="${requestScope.order.flowerimg1 }" alt="图片加载失败" width="200px" height="250px"/>
    	</div>
    	<div class="mess" >
    	<div class="dash2">
   		订单编号：${requestScope.order.orderNo}
   		<br/>
    	</div>
   		 <div class="dash2">
                  顾客昵称：${requestScope.order.nickName}
                  <br/>
       </div>
       <div class="dash2">
    	花的种类：${requestScope.order.flowerName}
    	<br/>
    	</div>
    	<div class="dash2">
    	花的名称：${requestScope.order.description}
    	<br/>
    	</div>
    	<div class="dash2">
        花的单价：${requestScope.order.price}
        <br/>
        </div>
        <div class="dash2">
        购买数量：${requestScope.order.buyNumber}
        <br/>
        </div>
        <div class="dash2">
        总价：${requestScope.order.total}
        <br/>
       
       </div>
       <div class="dash2">
        电话：${requestScope.order.phone}
        <br/>
       
       </div>
       <div class="dash2">
        地址：${requestScope.order.orderAddress}
        <br/>
       
       </div>
       <div class="dash2">
        创建时间：${requestScope.order.creationTime}
        <br/>
       
       </div>
       <div class="dash2">
        订单状态：${requestScope.order.state}
        <br/>
       
       </div>
        
    </div>
    	
  
    
    
   
   
  </body>
</html>
