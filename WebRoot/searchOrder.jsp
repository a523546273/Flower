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
    
    <title>My JSP 'orderList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="style/authority/basic_layout.css" rel="stylesheet"
	type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet"
	type="text/css">
	
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript"
	src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript"
	src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css"
	href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>


<script type="text/javascript">
	  function do_delete(orderNo){
	  var dele=confirm("您确定要删除编号为：【"+orderNo+"】的吗？");
	  if(dele){
	  location.href="DeleteOrderServlet?orderNo="+orderNo;
	  }
	  }
	  
	  function showOrder(orderNo) {
		layer.open({
			type : 2,
			title : '订单信息页',
			shadeClose : true,
			shade : 0.8,
			area : [ '640px', '485px' ],
			content : 'OrderServlet?orderNo='+orderNo+'&type=showOrder'
		});
	}
	
	function skipPrev(pageIndex,txtOrderNo,txtName){
	if(pageIndex==0){
	alert('当前已经是第一页！');
	}else{
	location.href="SearchOrderServlet?txtOrderNo="+txtOrderNo.trim()+"&pageIndex="+pageIndex+"&txtName="+txtName.trim()+"&type=search";
	}
	}
	
	function skipNext(pageIndex,pageCount,txtOrderNo,txtName){
	
	if(parseInt(pageIndex)>parseInt(pageCount)){
	alert('当前已经是最后一页！');
	}else{
	location.href="SearchOrderServlet?txtOrderNo="+txtOrderNo.trim()+"&pageIndex="+pageIndex+"&txtName="+txtName.trim()+"&type=search";
	}
	}
	
	function skipPage(pageIndex,txtOrderNo,txtName){
	location.href="SearchOrderServlet?txtOrderNo="+txtOrderNo.trim()+"&pageIndex="+pageIndex+"&txtName="+txtName.trim()+"&type=search";
	}
	
	function jumpPage(pageCount,txtOrderNo,txtName){
	var pageIndex=document.getElementById("jumpNumTxt").value;
	if(parseInt(pageIndex)<=parseInt(pageCount)&&parseInt(pageIndex)>0){
	location.href="SearchOrderServlet?txtOrderNo="+txtOrderNo.trim()+"&pageIndex="+pageIndex+"&txtName="+txtName.trim()+"&type=search";
	}else if(pageIndex>pageCount||pageIndex<=0){
	alert('跳转页面超出范围!');
	document.getElementById("jumpNumTxt").value="";
	}else{
	alert('页面跳转输入不规范！');
	document.getElementById("jumpNumTxt").value="";
	}
	}
	
	
	function searchFont(){
	
	var txtOrderNo=document.getElementById("txtOrderNo").value;
	var txtName=document.getElementById("txtName").value;
	var reg1 =/^\d*$/
	var reg =/^[\u4e00-\u9fa5\w]*$/;
	
	if(!reg1.test(txtOrderNo.trim())||txtOrderNo.trim().length>8){
	
	layer.tips('订单编号须有8位以内数字组成', '#txtOrderNo');
	
	 return false;
	}else if(!reg.test(txtName.trim())||txtName.trim().length>8){
	
	layer.tips('顾客昵称须由8位以内字符组成', '#txtName');
	
	 return false;
	}else{
	
	return true;
	}
	}
	
	function search(){
	
	var isOk=searchFont();
	if(isOk){
	var txtOrderNo=document.getElementById("txtOrderNo").value;
	var txtName=document.getElementById("txtName").value;
	location.href="SearchOrderServlet?txtOrderNo="+txtOrderNo.trim()+"&txtName="+txtName.trim()+"&type=search";
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
							订单编号：<input type="text" name="txtOrderNo" id="txtOrderNo"/>
							顾客昵称：<input type="text" name="txtName" id="txtName"/> 
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
							<th>订单编号</th>
							<th>顾客昵称</th>
							<th>花的种类</th>
							<th>花的名称</th>
							<th>花的单价</th>
							<th>购买的数量</th>
							<th>总价</th>
							<th>创建时间</th>
							<th>订单状态</th>
							<th>操作</th>
						</tr>
						 <c:forEach items="${requestScope.orderList}" var="order">
    <tr>
      <td>${order.orderNo }</td>
      <td>${order.nickName }</td>
      <td>${order.flowerName}</td>
      <td>${order.description}</td>
      <td>${order.price }</td>
      <td>${order.buyNumber }</td>
      <td>${order.total }</td>
      <td>${order.creationTime }</td>
       <td>${order.state }</td>
     
<td><a href="javascript:onclick=do_delete('${order.orderNo }')">删除</a>
	<a href="OrderServlet?&orderNo=${order.orderNo }&type=updateOrder">更新</a>
	<a href="javascript:onclick=showOrder('${order.orderNo }')">查看</a></td>

    </tr>
    </c:forEach>
							
					</table>
					<div class="floatLeft">
共 <span class="blue">${requestScope.orderCount }</span> 条记录，当前显示第 <span class="blue">${requestScope.pageIndex }</span> 页，共 <span class="blue">${requestScope.pageCount }</span> 页
</div>


				<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
						
							<input type="button" value="首页" class="ui_input_btn01"
							onclick="skipPage(1,'<%=request.getAttribute("txtOrderNo") %>','<%=request.getAttribute("txtName") %>')" />
							<input type="button" value="上一页" class="ui_input_btn01"
							onclick="skipPrev('${requestScope.pageIndex-1 }','<%=request.getAttribute("txtOrderNo") %>','<%=request.getAttribute("txtName") %>')" />
							<input type="button" value="下一页" class="ui_input_btn01"
							onclick="skipNext('${requestScope.pageIndex+1 }','${requestScope.pageCount }','<%=request.getAttribute("txtOrderNo") %>','<%=request.getAttribute("txtName") %>')"/>
							<input type="button" value="尾页" class="ui_input_btn01"
							onclick="skipPage('${requestScope.pageCount }','<%=request.getAttribute("txtOrderNo") %>','<%=request.getAttribute("txtName") %>')"/>
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" name="jumpNumTxt"/>页
							 <input type="button" class="ui_input_btn01" value="跳转" 
								onclick="jumpPage('${requestScope.pageCount }','<%=request.getAttribute("txtOrderNo") %>','<%=request.getAttribute("txtName") %>')" />
					</div>
				</div>
			</div>
		</div>
	</form>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
