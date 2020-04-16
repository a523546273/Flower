
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
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
.c{
width: 200px;
height: 200px;
float: left;
margin-left: -28px;

}
#imglab{
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
.c2{
width: 200px;
height: 200px;
float: left;
margin-left: -28px;

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
											"url(../images/1.jpg)");
									/* $("#imglab").css("width","");
									$("#imglab").css("width",""); */

									$("#imglab2").html('');
								};

							});
		});




    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 200
					  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>

  </head>
  
  <body>

    <div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="index.html" target="rightFrame">首页</a></li>
    <li><a href="#">新增员工</a></li>
  </ul>
</div>
<div class="formbody">
  <div id="usual1" class="usual">
    <div class="itab">
      <ul>
        <li><a href="#tab1" class="selected">发布通知</a></li>
        <!--<li><a href="#tab2">自定义</a></li> -->
      </ul>
    </div>
    <div id="tab1" class="tabson">
      <div class="formtext">Hi，<b></b>，欢迎您试用信息发布功能！</div>
      
      
      <form action="AddFlower?type=addflower" enctype="multipart/form-data" method="post">
      
      <ul class="forminfo">
      
        <li>
          <label>花名<b>*</b></label>
          <div class="vocation">
          <select name="flowername" class="select1">
									
										<option value="百合">百合</option>
										<option value="粉玫瑰">粉玫瑰</option>
										<option value="扶郎花">扶郎花</option>
										<option value="红玫瑰">红玫瑰</option>
										<option value="康乃馨">康乃馨</option>
										<option value="蓝玫瑰">蓝玫瑰</option>
										<option value="礼盒花">礼盒花</option>
										<option value="马蹄莲">马蹄莲</option>
										<option value="郁金香">郁金香</option>
									
								</select>

</div>

        </li>
        
        <li>
          <label>价格<b>*</b></label>
          <input name="price" type="text" class="dfinput"   style="width:200px;"/>
        </li>
        
        <li>
          <label>库存<b>*</b></label>
          <input name="stock" type="text" class="dfinput" style="width:200px;"/>
        </li>
        
        <li>
          <label>已售量<b>*</b></label>
          <input name="sold" type="text" class="dfinput"   style="width:200px;"/>
        </li>
        
        
        
        <li>
          <label>小图<b>*</b></label>
          <div class="c">
					<label id="imglab" title="点击'+'号上传头像" class="loadfile"
						for="uploadfile">+</label> <input type="file" id="uploadfile"
						style="display:none;" name="flowerimg1" />
				</div>
        </li>
        
        <li>
          <label>大图<b>*</b></label>
          <div class="c2">
					<label id="imglab2" title="点击'+'号上传头像" class="loadfile2"
						for="uploadfile2">+</label> <input type="file" id="uploadfile2"
						style="display:none;" name="flowerimg2" />
				</div>
          
        </li>
        
        <li>
          <label>描述<b>*</b></label>
          <input name="description" type="text" class="dfinput"   style="width:200px;"/>
        </li>
        
        <li> <input name="" type="submit"
							 value="立即提交" /></li>
        
      </ul>
      
      </form>
    </div>
    
    
    
  </div>
  <script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script> 
  <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	</div>
  </body>
</html>
