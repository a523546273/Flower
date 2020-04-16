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
    
    <title>My JSP 'updateOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link href="style/authority/add.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>

  </head>
  
  <body>
     <div>
		<form method="post" action="UpdateOrderServlet?type=updateOrder" >
			<table class="mytab w600">
				<tr>
					
					<th colspan="2">更 新  订  单</th>
				</tr>
				<tr>
				
					<td><label for="orderNo">订单编号</label></td>
					<td><input type="text" name="orderNo" id="orderNo" readonly="readonly" value="${requestScope.order.orderNo }"></td>
				</tr>
				
				<tr>
					<td><label for="nickName">顾客昵称： </label></td>
					<td><input type="text" name="nickName" id="nickName" readonly="readonly" value="${requestScope.order.nickName }"
						/></td>
				</tr>
				
				<tr>
					<td><label for="flowerName">花的品种： </label></td>
					<td><input type="text" name="flowerName" id="flowerName" readonly="readonly" value="${requestScope.order.flowerName }"
						/></td>
				</tr>
				<tr>
					<td><label for="description">花名：</label></td>
					<td><input type="text" name="description" id="description"  readonly="readonly" value="${requestScope.order.description }"
						/></td>
				</tr>
					<tr>
					<td><label for="price">单价：</label></td>
					<td><input type="text" name="price" id="price" readonly="readonly" value="${requestScope.order.price }"
						/></td>
				</tr>
				<tr>
					<td><label for="buyNumber">购买数量：</label></td>
					<td><input type="text" name="buyNumber" id="buyNumber" readonly="readonly" value="${requestScope.order.buyNumber }"
						/></td>
				</tr>
				<tr>
					<td><label for="total">总价：</label></td>
					<td><input type="text" name="total" id="total" readonly="readonly" value="${requestScope.order.total }"
						/></td>
				</tr>
				<tr>
					<td><label for="phone">电话：</label></td>
					<td><input type="text" name="phone" id="phone" readonly="readonly" value="${requestScope.order.phone }"
						/></td>
				</tr>
				
				<tr>
					<td><label for="orderAddress">地址：</label></td>
					<td><input type="text" name="orderAddress" id="orderAddress" readonly="readonly" value="${requestScope.order.orderAddress }"
						></td>
				</tr>
				<tr>
					<td><label for="creationTime">创建时间：</label></td>
					<td><input type="text" name="creationTime" id="creationTime" readonly="readonly" value="${requestScope.order.creationTime }"
						/></td>
				</tr>
				
				<tr>
					<td><label for="stateId">订单状态：</label></td>
					<td><select name="stateId" id="stateId" >
					
							<option <c:if test="${requestScope.order.stateId  eq 1 }">checked="checked"</c:if> value="1">未发货</option> 
					        <option <c:if test="${requestScope.order.stateId  eq 2  }">checked="checked"</c:if> value="2">发货中</option>
					         <option <c:if test="${requestScope.order.stateId  eq 3 }">checked="checked"</c:if> value="3">买家已签收</option>
					</select>
					</td>
				</tr>
				


				<tr>
					<td colspan="2"><input type="submit" 
						name="button" id="button" value=" 点击更新 "></td>
				</tr>
			</table>

		</form>
	</div>
  </body>
</html>
