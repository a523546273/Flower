<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCustomerUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="style/authority/basic_layout.css" rel="stylesheet"
	type="text/css">

	 <link href="style/authority/add.css" rel="stylesheet" type="text/css">
	 
	 <link href="style/authority/basic_layout.css" rel="stylesheet"
	type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet"
	type="text/css">
	 
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>

<style type="text/css">
table tr td{
border: 1px solid #666;
}

</style>

<script type="text/javascript">

function skipPrev(pageIndex,nickName){
	if(parseInt(pageIndex)==0){
	alert('当前已经是第一页！');
	}else{

	location.href="DingDanServlet?pageIndex="+pageIndex+"&nickName="+nickName;
	}
	}
	
	function skipNext(pageIndex,pageCount,nickName){
	
	if(parseInt(pageIndex)>parseInt(pageCount)){
	alert('当前已经是最后一页！');
	}else{
	
	location.href="DingDanServlet?pageIndex="+pageIndex+"&nickName="+nickName;
	}
	}
	
	function skipPage(pageIndex,nickName){
		
	location.href="DingDanServlet?pageIndex="+pageIndex+"&nickName="+nickName;
	}
	
	function jumpPage(pageCount,nickName){
	
	var pageIndex=document.getElementById("jumpNumTxt").value;
	
	if(pageIndex<=pageCount&&pageIndex>0){
	location.href="DingDanServlet?pageIndex="+pageIndex+"&nickName="+nickName;
	}else if(pageIndex>pageCount||pageIndex<=0){
	alert('跳转页面超出范围!');
	document.getElementById("jumpNumTxt").value="";
	}else{
	alert('页面跳转输入不规范！');
	document.getElementById("jumpNumTxt").value="";
	}
	}

</script>

</head>

<body>
	
		<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							
							<th>昵称</th>
							<th>花的种类</th>
							<th>花的名称</th>
							<th>单价</th>
							<th >数量</th>
							<th>总价</th>
							<th>创建时间</th>
							<th>订单状态</th>
							
						</tr>
		<c:forEach items="${requestScope.orderList}" var="order">
    <tr>
   
      <td>${order.nickName }</td>
      <td>${order.flowerName}</td>
      <td>${order.description}</td>
      <td>${order.price }￥</td>
      <td >${order.buyNumber }</td>
      <td>${order.total }￥</td>
      <td>${order.creationTime }</td>
       <td>${order.state }</td>


    </tr>
    </c:forEach>
							
					</table>
					
								<div class="floatLeft">
共 <span class="blue">${requestScope.orderCount }</span> 条记录，当前显示第 <span class="blue">${requestScope.pageIndex }</span> 页，共 <span class="blue">${requestScope.pageCount }</span> 页
</div>


				<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
						
							<input type="button" value="首页" class="ui_input_btn01"
							onclick="skipPage(1,'${requestScope.nickName}')" />
							<input type="button" value="上一页" class="ui_input_btn01"
							onclick="skipPrev('${requestScope.pageIndex-1 }','${requestScope.nickName}')" />
							<input type="button" value="下一页" class="ui_input_btn01"
							onclick="skipNext('${requestScope.pageIndex+1 }','${requestScope.pageCount }','${requestScope.nickName}')"	 />
							<input type="button" value="尾页" class="ui_input_btn01"
							onclick="skipPage('${requestScope.pageCount }','${requestScope.nickName}')"	 />
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" name="jumpNumTxt"/>页
							 <input type="button" class="ui_input_btn01" value="跳转" 
								onclick="jumpPage('${requestScope.pageCount }','${requestScope.nickName}')" />
					</div>

	
		
</body>
</html>
