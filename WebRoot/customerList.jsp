<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'customerList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet"
	type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript"
	src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript"
	src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css"
	href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>


 <script type="text/javascript">
	 
	  
	  function showCustomer(customerId) {
		layer.open({
			type : 2,
			title : '顾客信息页',
			shadeClose : true,
			shade : 0.8,
			area : [ '540px', '350px' ],
			content : 'CustomerServlet?customerId='+customerId+'&type=showCustomer'
		});
	}
	
	function skipPrev(pageIndex){
	if(pageIndex==0){
	alert('当前已经是第一页！');
	}else{
	location.href="CustomerListServlet?pageIndex="+pageIndex;
	}
	}
	
	function skipNext(pageIndex,pageCount){
	if(parseInt(pageIndex)>parseInt(pageCount)){
	alert('当前已经是最后一页！');
	}else{
	location.href="CustomerListServlet?pageIndex="+pageIndex;
	}
	}
	
	function skipPage(pageIndex){
	location.href="CustomerListServlet?pageIndex="+pageIndex;
	}
	
	function jumpPage(pageCount){
	var pageIndex=document.getElementById("jumpNumTxt").value;
	if(pageIndex<=pageCount&&pageIndex>0){
	location.href="CustomerListServlet?pageIndex="+pageIndex;
	}else if(pageIndex>pageCount||pageIndex<=0){
	alert('跳转页面超出范围!');
	document.getElementById("jumpNumTxt").value="";
	}else{
	alert('页面跳转输入不规范！');
	document.getElementById("jumpNumTxt").value="";
	}
	}
	

	function searchFont(){
	
	var txtName=document.getElementById("txtName").value;
	var txtAddress=document.getElementById("txtAddress").value;
	
	var reg =/^[\u4e00-\u9fa5\w]*$/;
	
	if(!reg.test(txtName.trim())||txtName.trim().length>8){
	
	layer.tips('顾客昵称须有8位以内字符组成', '#txtName');
	
	 return false;
	}else if(!reg.test(txtAddress.trim())||txtAddress.trim().length>8){
	
	layer.tips('现居住地须有8位以内字符组成', '#txtAddress');
	
	 return false;
	}else{
	
	return true;
	}
	}
	
	function search(){
	
	var isOk=searchFont();
	if(isOk){
	var txtName=document.getElementById("txtName").value;
	var txtAddress=document.getElementById("txtAddress").value;
	location.href="SearchCustomerServlet?txtName="+txtName.trim()+"&txtAddress="+txtAddress.trim()+"&type=search";
	}
	}
	  </script>
  </head>
  
  <body>
   <form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							顾客昵称：<input type="text" name="txtName" id="txtName"/> 
							现居住地：<input type="text" name="txtAddress" id="txtAddress"/> 
						</div>
						<div id="box_bottom">
							<input type="button" value="查询" class="ui_input_btn01" onclick="search()" /> 
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>顾客编号</th>
							<th>顾客昵称</th>
							<th>性别</th>
							<th>顾客姓名</th>
							
							<th>手机号码</th>
							<th>现居住地</th>
							<th>密保问题</th>
							<th>头像</th>
							<th>操作</th>
						</tr>
						 <c:forEach items="${requestScope.customerList}" var="customer">
    <tr>
      <td>${customer.customerId }</td>
      <td>${customer.nickName }</td>
      <td>${customer.gender}</td>
      <td>${customer.cName }</td>
     
      <td>${customer.phone }</td>
      <td>${customer.address }</td>
       <td>${customer.miBao }</td>
      <td><img src="${customer.headimg }" width="20px" height="20px"/></td>

      <td>
      
     <a href="javascript:onclick=showCustomer('${customer.customerId }')">查看</a></td>

    </tr>
    </c:forEach>
							
					</table>
					<div class="floatLeft">
共 <span class="blue">${requestScope.customerCount }</span> 条记录，当前显示第 <span class="blue">${requestScope.pageIndex }</span> 页，共 <span class="blue">${requestScope.pageCount }</span> 页
</div>


				<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
						
							<input type="button" value="首页" class="ui_input_btn01"
							onclick="skipPage(1)" />
							<input type="button" value="上一页" class="ui_input_btn01"
							onclick="skipPrev('${requestScope.pageIndex-1 }')" />
							<input type="button" value="下一页" class="ui_input_btn01"
							onclick="skipNext('${requestScope.pageIndex+1 }','${requestScope.pageCount }')"	 />
							<input type="button" value="尾页" class="ui_input_btn01"
							onclick="skipPage('${requestScope.pageCount }')"	 />
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" name="jumpNumTxt"/>页
							 <input type="button" class="ui_input_btn01" value="跳转" 
								onclick="jumpPage('${requestScope.pageCount }')" />
					</div>
				</div>
			</div>
		</div>
	</form>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
