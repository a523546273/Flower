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
    	<img src="${requestScope.flower.flowerimg2 }" alt="图片加载失败" width="200px" height="250px"/>
    	</div>
    	<div class="mess" >
    	<div class="dash">
   		Blossom编号：${requestScope.flower.flowerId}
   		<br/>
   		</div>
   		 <div class="dash">
                  品种：${requestScope.flower.flowerName}
                  <br/>
       </div>
       <div class="dash">
    	名称：${requestScope.flower.description}
    	<br/>
    	</div>
    	<div class="dash">
        单价：${requestScope.flower.price}
        <br/>
        </div>
        <div class="dash">
        库存：${requestScope.flower.stock}
        <br/>
        </div>
        <div class="dash">
        已售数：${requestScope.flower.sold}
        <br/>
       
       </div>
        
    </div>
    	
  
    
    
   
   
  </body>
</html>
