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
	 <link href="style/authority/add.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>

<style type="text/css">
.c {
	width: 200px;
	height: 200px;
	margin-left:50px;
}

.loadfile {
	float: right;
	display: block;
	width: 170px;
	height: 170px;
	font-size: 40px;
	text-align: center;
	line-height: 170px;
	border: 1px solid #ccc;
}
.c2{
width: 200px;
height: 200px;
margin-left: 50px;

}
#imglab2{
    float:right;
	display: block;
    width:170px;
	height: 170px;	
	font-size: 40px;
	text-align: center;	
	line-height:170px;
	border: 1px solid #ccc;
	margin-top: 20px;
	}	

.bg_size {
	background-repeat: no-repeat;
	background-size: 170px 170px;
}
}
</style>
<script type="text/javascript">
	
</script>


</head>

<body>
	<div class="tableList">
		<form method="post" action="UpdateCustomerInfoServlet" enctype="multipart/form-data">
	
			<table class="mytab w600">
				<tr>
					<th colspan="2">用户信息</th>
					
				</tr>
				<tr>
					<input type="hidden" name="customerId" value="${requestScope.cus.customerId }">
					<td><label for="name">昵称：</label></td>
					<td><input type="text" readonly="readonly" name="nickName" id="flowerName" value="${requestScope.cus.nickName }"></td>
				</tr>
				
					
					<input type="hidden" name="cPwd" id="description" value="${requestScope.cus.cPwd  }" onblur="checkFlowerName()">
				
				<tr>
					<td><label for="price">真实姓名：</label></td>
					<td><input type="text" name="cName" id="price" value="${requestScope.cus.cName }"
						onblur="checkPrice()"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
       <input type="radio" name="radio" id="man" value="男" <c:if test="${requestScope.cus.gender eq '男' }">checked="checked"</c:if>>男&nbsp;&nbsp;
       &nbsp;&nbsp;
      <input type="radio" name="radio" id="women" value="女" <c:if test="${requestScope.cus.gender eq '女' }">checked="checked"</c:if>>女
     </td>
				</tr>

				<tr>
					<td><label for="stock">电话：</label></td>
					<td><input type="text" name="phone" id="stock" value="${requestScope.cus.phone }"
						onblur="checkStock()"></td>
				</tr>
				
				<tr>
					<td><label for="stock">地址：</label></td>
					<td><input type="text" name="address" id="stock" value="${requestScope.cus.address }"
						onblur="checkStock()"></td>
				</tr>
				
				<tr>
					<td><label for="stock">密保问题：</label></td>
					<td><input type="text" name="miBao" id="stock" value="${requestScope.cus.miBao}"
						onblur="checkStock()"></td>
				</tr>
				
				<tr>
					<td><label for="stock">密保答案：</label></td>
					<td><input type="text" name="answer" id="stock" value="${requestScope.cus.answer }"
						onblur="checkStock()"></td>
				</tr>
				
				
				<tr>

				<td><label for="imglab">头像：</label></td>
                <td> <div class="c">
                
					<label id="imglab" title="点击'+'号上传头像" class="loadfile"
						for="uploadfile"><img src="${requestScope.cus.headimg } " width="170px" height="170px"/></label> <input type="file" id="uploadfile"
						style="display:none;" name="headimg" value=""/>
				</div>
				</td>
        </tr>
        
				

				<tr>
					<td colspan="2"><input type="submit" 
						name="button" id="button" value=" 点击更新 "></td>
				</tr>
			</table>

		</form>
	</div>
	<script type="text/javascript">
		$(function() {

			$("#uploadfile")
					.on(
							"change",
							function(e) {
								var fr = new FileReader();
								fr.readAsDataURL(document
										.getElementById("uploadfile").files[0]);
								fr.onload = function(e) {
									$("#imglab").addClass("bg_size");
									$("#imglab").css("background-image",
											"url(" + e.target.result + ")");
									/* $("#imglab").css("width","");
									$("#imglab").css("width",""); */

									$("#imglab").html('');
								};

							});
		});
		
		

		
	</script>
</body>
</html>
