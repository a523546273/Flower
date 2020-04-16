<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shop2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<link href="css/my.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
/**从购买单机事件**/
 	function byFlower(){
 	var flower=document.getElementById("flower").value;
 	alert(flower);
 	}
 	function checkNum(){
 		var num=document.getElementById("num").value;
 		if(num==0){
 			document.getElementById("num").value="";
 		}
 	}
 	function reNum(){
 		var num=document.getElementById("num").value;
 		if(num==null||num==0){
 			document.getElementById("num").value="0";
 		}
 	}
 	function buyf(){
 	var address=document.getElementById("address").value.trim();
 	if(address.length==0){
 		layer.tips('请输入收货地址！','#address');
 	}else{
 		document.forms[0].submit();
 	}
 	}
 	
</script>
<link href="css/my.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="toptop1">
		<div class="divc">
<img alt="暂无图片" src="images01/cxtop.jpg">

		</div>
	</div>
	<div id="top">
		<div class="divc">
			<div class="tleft">
				<img src="images01/blossomlogo.png" />
			</div>
			<div class="tzhong">
				<img src="images01/top_07.jpg" />
			</div>
			<div class="tzhong">
				<img src="images01/top_09.jpg" />
			</div>
			<div class="tzhong">
				<img src="images01/top_11.jpg" />
			</div>
			<div class="tzhong">
				<img src="images01/top_03.jpg" /><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1084872667&site=qq&menu=yes"><img src="images01/top_04.jpg" /></a>
			</div>
			<div class="tzhong">
				<img src="images01/top_16.gif" />
			</div>
		</div>
	</div>

	<!--menu begin-->
	<div id="menu">
		<div class="divc">
			<ul>
				<li class="li1"><a >网站首页</a></li>
				<li class="li2"><a >玫瑰情人</a></li>
				<li class="li1"><a >百合恋人</a></li>
				<li class="li2"><a >蓝色精灵</a></li>
				<li class="li1"><a >爱情测试</a></li>
				<li class="li2"><a >思念亲友</a></li>
				<li class="li1"><a >每日情缘</a></li>
			</ul>
		</div>
	</div>
	
	<div id="top">
		<div class="divc img520">
		<img alt="" src="images01/520.jpg" >
		</div>
		</div>

<div id="top">
	<div class="divc detail">
	
	
	<div class="deleft">
	<img  src="${sessionScope.flower.flowerimg2 }" width="360px" height="360px">
	</div>
	<div class="deright">
	<form action="BuyFlowerServlet?flowerId=${sessionScope.flower.flowerId }" method="post">
	
	<table cellpadding="0" cellspacing="0">
	<tr ><td class="xiahuaxian"><span class="fName">花名:${sessionScope.flower.description }</span></td>
	<td style="text-align: right;" class="xiahuaxian"><span class="fid">产品编号:${sessionScope.flower.flowerId}</span></td></tr>
	<tr ><td class="huise"><span class="shuoming1">&nbsp;&nbsp;说&nbsp;明：</span></td>
	<td class="huise"><span class="shuoming2 ">您至少应提前3小时下订单，我们保证按时送达； 为了能</span></td>
	</tr>
	<tr><td class="xiahuaxian huise"></td><td class="xiahuaxian huise"><span class="shuoming2">够有充分的时间准备，我们建议您尽早预定。</span></td></tr>
	
	<tr><td class="xiahuaxian"><span class="shuoming1">&nbsp;&nbsp;数&nbsp;量：</span></td>
	
	<td class="xiahuaxian"><select class="select" name="select">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="6">7</option>
	<option value="7">8</option>
	</select>&nbsp;<input name="num" id="num" type="text" style="width: 25px;height: 25px;" value="0" onfocus="checkNum()" onblur="reNum()">枝(以填的为主,库存量：${sessionScope.flower.stock})</td>
	</tr>
	<tr ><td style="line-height: 45px;" class="xiahuaxian"><span class="shuoming1">&nbsp;&nbsp;地&nbsp;址：</span></td>
	<td class="xiahuaxian" ><input type="text" style="width: 300px;height: 30px" name="address" id="address"></td>
	</tr>
	<tr>
	</tr>
	</table>
	<div class="topprice">
	<div class="price">
	<p><span class="youhui1">市场价：￥${sessionScope.flower.price+80 }</span></p>
	<p><span class="youhui2">平时价(非节日)：</span><span class="youhui3">￥${sessionScope.flower.price }</span></p>
	</div>
	<div class="price">
	<p><span class="youhui1">情人节当天估价：￥${sessionScope.flower.price+200 }</span></p>
	<p><span class="youhui2">情人节预定价格：</span><span class="youhui3">￥${sessionScope.flower.price+120}</span></p>
	</div>
	</div>
	
	<div class="buy">
	<img src="images01/goorder.jpg" onclick="buyf()" id="image">
	<div id="buyword"><img alt="" src="images01/bot_01.jpg"></div>
	</div>
	</form>
	</div>
</div>
</div>
<div id="top">
	<div class="divc detail1">
	<table id="table1">
	<tr><td colspan="2"><span class="updateOrder">修改订单信息说明</span></td></tr>
	<tr><td>1，</td><td> 客户订单提交后，我们会安排专人配送，在订单送达后我们会第一时间短信通知客户</td></tr>
	<tr><td>2，</td><td> 客户订单安排好后，原则上不允许修改，若需要改动，请至少提前24小时通知客服具体的修改信息。若订单已经在配送</td></tr>
	<tr><td></td><td> 中，客户务必需要修改信息，其中所产生的所有损失由客户自己来承担。</td></tr>
	<tr><td>3，</td><td> 先送货和现场收款的订单，一旦安排配送，不允许取消，若取消需要至少承担订单价格的80%</td></tr>
	<tr><td>4，</td><td>  现场收款订单，客户需要验收货品，若收到的与网上不符，可以当场拒收，一旦签收付款后默认为满意，事后不再接受</td></tr>
	<tr><td></td><td> 投诉处理</td></tr>
	<tr><td>5，</td><td> 若客户有特别需要交代的信息，请在提交订单的时候在特殊要求注明或者告诉客服人员即可。若没有特殊交代，我们会</td></tr>
	<tr><td></td><td> 根据当地配送部门的习俗习惯来具体安排订单。</td></tr>
	</table>
	<br>
	<br>
	<br>
	<table id="table1">
	<tr><td colspan="2"><span class="updateOrder">关于订购</span></td></tr>
	<tr><td>1，</td><td> 请尽量清楚的填写我们的表单。因为您填写的信息不详可能会造成鲜花礼品送不到。</td></tr>
	<tr><td>2，</td><td> 工作时间如下 早上8:00--凌晨1:00. 当天订单请尽早下单，夜里下订单而且要求夜晚配送的订单，请先咨询客</td></tr>
	<tr><td></td><td> 服。夜里1点以后下订单的客户，时间我们会安排在第2天上午处理，麻烦耐心等候。</td></tr>
	<tr><td>3，</td><td> 请您在订购完成后，及时联系我们或者请等待我们的电话确认</td></tr>
	<tr><td>4，</td><td>  我们将按照您下的订单信息进行服务，请您务必认真详细填写。当您收到购物清单邮件时要仔细核查，发现错误</td></tr>
	<tr><td></td><td> 处，请您及时修改订单，若以下情况造成订单延迟或无法配送，我们将不承担责任： 1）顾客提供错误和不详细的</td></tr>
	<tr><td></td><td> 地址； 2）顾客没有提供收货人的联系方式或所提供的"联系方式"有误；</td></tr>
	</table>
	
	
	<br>
	<br>
	<br>
	<table id="table1">
	<tr><td colspan="2"><span class="updateOrder">关于鲜花</span></td></tr>
	<tr><td>1，</td><td> 我们可以保证送到您手中时鲜花是新鲜的，请收花人在收到后务必立刻进行鲜切花的保鲜处理，以免造成花材脱</td></tr>
	<tr><td></td><td> 水，如果收花人已经签收，并且在12小时内，没有提出异议，表明此定单我们已经完成。</td></tr>
	<tr><td>2，</td><td> 由于鲜花的季节性和供货渠道变化性较强，可能您选择的某种花材无法供应，对于非主要花材，我们在尽量不影</td></tr>
	<tr><td></td><td> 响您所选的鲜花效果的情况下，按照寓意相同、类似花材、价值相同替代原则代替，对于主要花材，我们将在征求</td></tr>
	<tr><td></td><td> 您的意见后进行处理,希望您能谅解；</td></tr>
	<tr><td>3，</td><td> 由于鲜花保鲜时间短，如果在您要求送达的时间内，收花人不在您所提供的地址，或者我们根本无法联系，或者</td></tr>
	<tr><td></td><td> 拒收。我们可根据情况决定是否再次递送。</td></tr>
	<tr><td>4，</td><td>  如果您需要送花的城市不在我们的《配送范围》列表，请您与我们的客服人员联系，我们将尽力帮您解决。</td></tr>
	<tr><td>5，</td><td> 通常情况下，我们鲜花产品只负责服务到配送城市市区。如果您在填写订单时：所要送达的地址不在我们的《配</td></tr>
	<tr><td></td><td> 送范围》，或者远远超出了市区，可能需要加收运费，请您能和我们的客服人员联系解决。由于无法及时与您取得</td></tr>
	<tr><td></td><td> 联系，超出配送时间3天，按撤单处理，您所付的货款会自动存入您的虚拟帐户，在于您取得联系后，根据您指定方</td></tr>
	<tr><td></td><td>式退回；</td></tr>
	</table>

	</div>
	</div>


	<script src="zhenqing.js" type="text/javascript"></script>

<div><EMBED height=1 type=audio/mpeg width=1 src="music/lucky.mp3" volume="0" loop="-1" hidden="true" style="FILTER: Invert" ></EMBED></div>
	<div id="top1">
		<div class="divc foot">
			联系客户&nbsp; 联系客户&nbsp; 联系客户&nbsp; 联系客户&nbsp; 联系客户&nbsp; 联系客户&nbsp;
			联系客户&nbsp; 联系客户&nbsp; 联系客户 <br /> <img src="images01/endtel.jpg"
				style="vertical-align:middle" /> 免长途(9~12)<br /> ©2013-2014 版权所有
			皖IPC备124578965号 <img src="images01/gs.jpg"
				style="vertical-align:middle" />
		</div>
	</div>
	<p>&nbsp;</p>
</body>

</html>
