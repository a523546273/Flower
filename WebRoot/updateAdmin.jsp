<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="style/authority/add.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
 <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
function $(element) {
	return document.getElementById(element);
}

function checkPhone() {
	var phone = $("phone");
	var reg = /^1\d{10}$/;
	if (phone.value.trim().length != 0) {
		if (!reg.test(phone.value.trim())) {
		layer.tips('手机号码不正确,如：138****4578', '#phone');
			return false;
		} else {
			return true;
		}
	} else {
	layer.tips('手机号码不能为空', '#phone');
		return false;
	}
}

function checkAddress(){
	var address = $("address");
	var reg = /^[\u4e00-\u9fa5\w]+$/;
	if (address.value.trim().length != 0) {
	
		if (!reg.test(address.value.trim())||address.value.trim().length >20) {
	
		layer.tips('地址格式不正确，如：**省**市', '#address');
			
			return false;
		} else {
		
			return true;
		}
	} else {
	layer.tips('地址不能为空', '#address');
		return false;	
	}
}

function checkEmail() {
	var email = $("email");
	var reg = /^\w+@+\w+\.[a-zA-Z]{2,3}([a-zA-Z]{2,3})?$/;
	if (email.value.trim().length != 0) {
		if (!reg.test(email.value.trim())) {
		layer.tips('Email格式不正确，如：sjakshd@126.com', '#email');
			
			return false;
		} else {
			return true;
		}
	} else {
	layer.tips('Email不能为空', '#email');
		
		return false;
	}
}

	function checkMibao(){
	var miBao = $("miBao");
	var reg = /^[\u4e00-\u9fa5\w]+$/;
	if (miBao.value.trim().length != 0) {
		if (!reg.test(miBao.value.trim())||miBao.value.trim().length >16) {
		layer.tips('密保问题须由16字以内字符组成！', '#miBao');
			return false;
		} else {
			return true;
		}
	} else {
	layer.tips('密保问题不能为空', '#miBao');
		
		return false;
	}
	}
	
	function checkAnswer(){
	var answer = $("answer");
	var reg = /^[\u4e00-\u9fa5\w]+$/;
	if (answer.value.trim().length != 0) {
		if (!reg.test(answer.value.trim())||answer.value.trim().length >16) {
		layer.tips('密保答案须由16字以内字符组成！', '#answer');
			
			return false;
		} else {
			return true;
		}
	} else {
	layer.tips('密保答案不能为空', '#answer');
		
		return false;
	}
	}
	
	function to_submit(){
	if(checkPhone()&&checkAddress()&&checkEmail()&&checkMibao()&&checkAnswer()){
		document.forms[0].submit();
	}
	}
</script>
  </head>
  
  <body>
   <div>
		<form method="post" action="AdminServlet?type=updateAdmin2">
	
			<table class="mytab w600">
				<tr>
					<th colspan="2">个人信息更新</th>
					
				</tr>
				<tr>
				<input type="hidden" name="adminId" value="${requestScope.admin.adminId }">
				<input type="hidden" name="loginPwd" value="${requestScope.admin.loginPwd }">
					
					<td><label for="loginName">昵称：</label></td>
					<td><input type="text" readonly="readonly" name="loginName" id="loginName" value="${requestScope.admin.loginName }"></td>
				</tr>
				<tr>
					<td><label for="stock">电话：</label></td>
					<td><input type="text" name="phone" id="phone" value="${requestScope.admin.phone }"
						onblur="checkPhone()"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
       <input type="radio" name="gender" id="man" value="男" <c:if test="${requestScope.admin.gender eq '男' }">checked="checked"</c:if>>男&nbsp;&nbsp;
       &nbsp;&nbsp;
      <input type="radio" name="gender" id="women" value="女" <c:if test="${requestScope.admin.gender eq '女' }">checked="checked"</c:if>>女
     </td>
				</tr>
				<tr>
				<td><label for="birthday">生日：</label></td>
				<td><input type="text" class="Wdate" readonly="readonly" style="height:22px;"
					onFocus="WdatePicker({isShowClear:false,readOnly:true})"
					name="birthday" id="birthday" value="${requestScope.admin.birthday}"/></td>
			</tr>
				<tr>
					<td><label for="price">电子邮箱：</label></td>
					<td><input type="text" name="email" id="email" value="${requestScope.admin.email }"
						onblur="checkEmail()"/></td>
				</tr>
				
				<tr>
					<td><label for="stock">地址：</label></td>
					<td><input type="text" name="address" id="address" value="${requestScope.admin.address }"
						onblur="checkAddress()"></td>
				</tr>
				
				<tr>
					<td><label for="miBao">密保问题：</label></td>
					<td><input type="text" name="miBao" id="miBao" value="${requestScope.admin.miBao }"
						onblur="checkMibao()"></td>
				</tr>
				
				<tr>
					<td><label for="answer">密保答案：</label></td>
					<td><input type="text" name="answer" id="answer" value="${requestScope.admin.answer }"
						onblur="checkAnswer()"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" onclick="to_submit()"
						name="button" id="button" value=" 点击更新 "></td>
				</tr>
			</table>

		</form>
	</div>
  </body>
</html>
