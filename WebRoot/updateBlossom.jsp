<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateBlossom.jsp' starting page</title>
    
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
function $(element) {
	return document.getElementById(element);
}

function checkPrice(){
	var price = $("price");
	var reg = /^[1-9]\d*(\.\d{1,2})?$/;
	if (price.value.trim().length != 0) {
		if (!reg.test(price.value.trim())) {
		layer.tips('Blossom只能为数字，可保留两位小数！', '#price');
			return false;
		} else {
			return true;
		}
	} else {
	layer.tips('Blossom价格不能为空！', '#price');
		return false;
	}

}
function checkSold(){
var sold = $("sold");
	var reg = /^[1-9]\d*|0$/;
	if (sold.value.trim().length != 0) {
		if (!reg.test(sold.value.trim())) {
		layer.tips('已售数只能为正整数！', '#sold');
			return false;
		} else {
			return true;
		}
	} else {
	layer.tips('已售数不能为空！', '#sold');
		return false;
	}
}

function checkStock(){
var stock = $("stock");
	var reg = /^[1-9]\d*$/;
	if (stock.value.trim().length != 0) {
		if (!reg.test(stock.value.trim())) {
		layer.tips('库存只能为正整数！', '#stock');
			return false;
		} else {
			return true;
		}
	} else {
	layer.tips('库存不能为空！', '#stock');
		return false;
	}

}


function to_submit(){
if(checkPrice()&&checkSold()&&checkStock()){
		document.forms[0].submit();
	}
}
</script>
  </head>
  
  <body>
  <div>
		<form method="post" action="UpdateFlowerServlet?type=updateFlower" >
			<table class="mytab w600">
				<tr>
					
					<th colspan="2">更 新  Blossom</th>
				</tr>
				<tr>
				
					<td><label for="flowerName">花的品种</label></td>
					<td><input type="text" name="flowerName" id="flowerName" readonly="readonly" value="${requestScope.flower.flowerName }"></td>
				</tr>
				<input type="hidden"  name="flowerId" id="flowerId" value="${requestScope.flower.flowerId }"/>
				
				
				<tr>
					<td><label for="description">花名： </label></td>
					<td><input type="text" name="description" id="description" readonly="readonly" value="${requestScope.flower.description }"
						/></td>
				</tr>
				<tr>
					<td><label for="price">单价：</label></td>
					<td><input type="text" name="price" id="price" value="${requestScope.flower.price }"
						onblur="checkPrice()"></td>
				</tr>
					<tr>
					<td><label for="sold">已售数：</label></td>
					<td><input type="text" name="sold" id="sold" value="${requestScope.flower.sold }"
						onblur="checkSold()"></td>
				</tr>
				<tr>
					<td><label for="stock">库存：</label></td>
					<td><input type="text" name="stock" id="stock" value="${requestScope.flower.stock }"
						onblur="checkStock()"></td>
				</tr>
				
				
				<tr>

				<td><label for="imglab">小图：</label></td>
                <td> <div class="c">
					<label id="imglab" title="点击'+'号上传头像" class="loadfile"
						for="uploadfile"><img src="${requestScope.flower.flowerimg1 }" width="170px" height="170px" /></label> <input type="file" id="uploadfile"
						style="display:none;" name="flowerimg1" />
				</div>
				</td>
        </tr>
        
       <tr>
          <td><label for="imglab2">大图：</label></td>
          <td><div class="c2">
					<label id="imglab2"  class="loadfile2" 
						for="uploadfile2"><img src="${requestScope.flower.flowerimg2 }" width="170px" height="170px" /></label> <input type="file" id="uploadfile2"
						style="display:none;" name="flowerimg2" />
				</div>
          </td>
        
				</tr>


				<tr>
					<td colspan="2"><input type="button" onclick="to_submit()"
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
		
		$(function() {
			$("#uploadfile2")
					.on(
							"change",
							function(e) {
								var fr = new FileReader();
								fr.readAsDataURL(document
										.getElementById("uploadfile2").files[0]);
								fr.onload = function(e) {
									$("#imglab2").addClass("bg_size");
									$("#imglab2").css("background-image",
											"url(" + e.target.result + ")");
									/* $("#imglab").css("width","");
									$("#imglab").css("width",""); */

									$("#imglab2").html('');
								};

							});
		});

		
	</script>
  </body>
</html>
