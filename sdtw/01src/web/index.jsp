<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.XtUtil"%>
<%@page import="com.xietong.software.common.StrTool"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.util.AESUtils"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.util.Cemail"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
 <%

String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
Random random = new Random();     
StringBuffer sb = new StringBuffer();     
for (int i = 0; i < 6; i++) {     
    int number = random.nextInt(base.length());     
    sb.append(base.charAt(number));     
}
String EmailCode = sb.toString();
%>   
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
String cookUsername = "";
String coopds="";
boolean f1=false,f2=false;

Cookie cookies[] = request.getCookies();
if(cookies != null) {
    for(int i=0;i<cookies.length;i++) {
        if (cookies[i].getName().equals("SDFZUSERNAME_RE")) {
                cookUsername = cookies[i].getValue();
                f1=true;
        }
        
        if (cookies[i].getName().equals("SDFZEGOVPASWARDS")) {
        	coopds = AESUtils.decrypt("SDFZ_ZHXYabcde12", cookies[i].getValue());
            f2=true;
        }
       
        if(f1==true && f2 == true){
        	break;
        }
    }
}
String ipreq = ParamUtils.getParameter(request, "ip", "");
String ip = StrTool.getIpAddr(request); 
/*if(!ipreq.equals("5961") &&!ip.equals("127.0.0.1")&&!ip.equals("0:0:0:0:0:0:0:1")){
	String ips[] = ip.split("\\.");    
	if(ips.length>2){
		String ip2 =  ips[0] + "." + ips[1] + "." + ips[2] + ".*";
		List cdt = new ArrayList();
		cdt.add("ip='" + ip + "' or ip='" + ip2 + "'");
		cdt.add("enable=1");
		IpLimit  IpL = new IpLimit();
		if (IpL.getCount(cdt) < 1 ){
			out.println("Sorry, Your Ip can't visit the server! If you are our member, please mailing your information  to manager@sdxietong.com . Your Information include  name,department,email of company domain.");
			return;
		}
	}
	else{
		out.println("Sorry, Your Ip can't visit the server! If you are our member, please mailing your information  to manager@sdxietong.com . Your Information include  name,department,email of company domain.");
		return;
	}
}*/

String csrftoken = XtUtil.getRandomString(8);
session.setAttribute("csrftoken",csrftoken);
System.out.println(csrftoken);
String curDate = Tool.stringOfCnDateTime(new Date());
UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(userInfo!=null){
	System.out.println(userInfo.hasFunPower(Power.USERSTUDENTPOWER)+"  ");
	if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
		user = userInfo.getUserCode();
	}
}
Map RoleNameMap = CEditConst.getRoleNameMap(userInfo);
Map DeptNameMap = CEditConst.getAcademyNameMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>山东大学拓展培养计划综合管理系统</title>
<link href="css/index.css" rel="stylesheet"/>
<!-- <script type="text/javascript" src="js/jquery-ui-1.10.2/jquery-1.9.1.js"></script> -->

<title>山东大学拓展培养计划综合管理系统</title>
<jsp:include page="/main/jqueryui.jsp" />
<script type="text/javascript" src="js/jquery.jplaceholder.js"></script>
 <script src="main/js/index.js" type="text/javascript"></script>
<script type="text/javascript">

var EmailCode = '<%=EmailCode%>';
var ok=true;

function checkEmailCode(){
	 var flag = false;
	 
	 var EmailCode2 = $("#emailCode1").val();

	 if(EmailCode==EmailCode2){
		 flag = true;
	 }
	 if(flag==false){
		 ok=false;
		 $(".xinmima").hide();
		$(".cuowu").show();
	 }
	 if(flag!=false){
		 ok=true;
		 $(".cuowu").hide();
		$(".xinmima").show();
	 }
	 
	 return flag;
}
function send(){
	var email=document.getElementById("Email").value;
	 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	//alert(EmailCode);
	if(filter.test(email)){
	 $.ajax({
			url:"emailCheck.jsp?cmd=sendEmail&email="+email+"&EmailCode="+EmailCode,
			type: "post",
			dataType:"json",
			async:false,
			success:function(data){
				
			},
			error: function (error) {
	            alert("信息出错！");
	        }
			
		});
}else{
	alert("邮箱格式不对")
}
	//alert("2222")

}
function xiugaimima(){
	ok=true;
	var mima1=$("#mima1").val();
	var mima2=$("#mima2").val();
	if(!mima1){
		alert("密码不能为空")
		ok=false;
	return;
	}
	if(mima1==mima2){
		ok=true;
		
	}
	else{
		ok=false;
		alert("两次密码输出不一致请重新输入")
		
	}
	if(ok){
	var xinmima=$("#mima1").val();
	var user=$("#useraccount2").val()
	//alert(xinmima);
	//alert(user);
	 $.ajax({
			url:"emailCheck.jsp?cmd=modify&user="+user+"&xinmima="+xinmima,
			type: "post",
			dataType:"json",
			async:false,
			success:function(data){
				if(data.msg=="error"){
					alert("账户不存在");
					$('#useraccount2').focus();
					return;
				}
				if(data.msg=="ok"){
					alert("修改成功")
					$('.loginBoxMask').fadeOut(100);
					$('.pwRetrieveBox').slideUp(200);
				}
				if(data.msg=="no"){
					alert("修改失败")
				}
				
			},
			error: function (error) {
	            alert("信息出错！");
	        }
			
		});
	}
}

//动态显示时间
var currentDate = new Date();   
function run(){       
	currentDate.setSeconds(currentDate.getSeconds() + 1);
	$('#currentTime').html(currentDate.toLocaleString()+"");
}     
window.setInterval("run();", 1000); 
<%

%>
$(function(){
	$('#LoginBoxBtn').click(function(){//登录按钮
		$('.loginBoxMask').fadeIn(100);
		$('.loginBox').slideDown(200);
	});
	$('.loginBoxTop .closeBtn').click(function(){//关闭登录框
		$('.loginBoxMask').fadeOut(100);
		$('.loginBox').slideUp(200);
	});
	
	$('#showPwRetrieveBox').click(function(){
		$('.loginBoxMask').fadeIn(100);
		$('.pwRetrieveBox').slideDown(200);
	});
	$('.pwRetrieveBoxTop .closeBtn').click(function(){
		$('.loginBoxMask').fadeOut(100);
		$('.pwRetrieveBox').slideUp(200);
	});
	
	if("<%=cookUsername %>".length>0){
		document.logon.Username.value="<%=cookUsername%>";
		document.logon.pd.value="<%=coopds%>";
	}
	else{
		document.logon.Username.focus();
	}
	if(!placeholderSupport()){
		$("input[placeholder]").placeholder({isUseSpan:true});
	}
	
//////////////////////////////////////////////////////////////////////////////
	//页面加载函数，没有函数名
	//打开与关闭找回密码框
	//LoginBoxBtn:登录按钮id
	//loginBoxMask:
	
	$("#dlpic").bind("click",function(){
		checkuser();
	});
	$("#czpic").bind("click",function(){
		document.logon.reset();
	});
});
function placeholderSupport() {
    return 'placeholder' in document.createElement('input');
}
if(document.addEventListener){//Firefox
	document.addEventListener("keypress",fireFoxHandler, true);
}else{//IE
	document.attachEvent("onkeypress",ieHandler);
}
function ieHandler(){
	//仅对于IE有效
    ie = (document.all)? true:false
    if (ie){
        if(window.event.keyCode==13){
            checkuser();
        }
    }
}
function fireFoxHandler(evt){//firefox
	if(evt.keyCode==13){
		 checkuser();
	}
}
function setFocus()
{
    if(document.logon.Username.value != ""){
        document.logon.pd.focus();
    }
    else{
        document.logon.Username.focus();
    }
    return;
}
//检查用户输入，无误后提交
function checkuser(type)
{
	 
    if(document.logon.Username.value=="" || $("#Username").val() == $("#Username").attr('placeholder')){
        alert("请输入用户名字！");
        document.logon.Username.focus();
        return;
        //return false;
    }
    		    
    if(document.logon.pd.value=="" || $("#pd").val() == $("#pd").attr('placeholder')){
        alert("请输入用户密码！");
        document.logon.pd.focus();
        return;
        //return false;
    }
    
  
    document.logon.method="post";
    if (type == undefined) {
        type = 0;
    }
    
    document.logon.action="logon/enter.jsp?type=" + type;
    document.logon.submit();
}

<%
String url = "student-menudata.jsp";
if(user.getId()==-1){
url="index-studentmenu.jsp";
}%>
</script>
<style type="text/css">
html,body{
	border:0;
	margin:0;
	padding:0;
}

.topbanner{
	margin:0;
	width:100%;
/* 	min-width:1400px; */
	height:28px;
	background:#630a10;
	color:#fff;
	font:12px Microsoft YaHei;
}

.toptitle{
	margin:0;
	width:100%;
/* 	min-width:1400px; */
	height:120px;
	background:#9c0c15;
}

.topbanner #currentTime{
	float:left;
	margin-left:80px;
	line-height:28px;
}
.topbanner .loginLine{
	float:right;
	margin-right:80px;
}

.menuandcontent{
	position:fixed;
	bottom:30px;
	top:148px;
	margin:0;
	height:90%;
	width:100%;
/* 	min-width:1400px; */
}
.contentframe{
	padding:0;
	margin:0;
	height:100%;
	width:100%;
}


.footer{
	position:fixed;
	bottom:0;
	margin:0;
	width:100%;
/* 	min-width:1400px; */
	height:30px;
}
.footerframe{
	margin:0;
	padding:0;
	width:100%;
	height:30px;
}
.ipt {
	border: solid 1px #d2d2d2;
	border-radius: 2px;
	padding: 4px 6px;
	height: 21px;
	line-height: 21px;
	color: #555;
	width: 180px;
	vertical-align: middle;
}
.ipt:focus {
	border-color: #95C8F1;
	box-shadow: 0 0 4px #95C8F1;
}
/* loginBtn 按钮 */
.loginBtn {
	position: relative;
	cursor: pointer;
	height: 26px;
	line-height: 26px;
	width:60px;
	display: inline-block;
	vertical-align: middle;
	font-size: 12px;
	font-weight:bold;
	text-align: center;
	text-decoration: none;
	border-radius: 4px;
	border: 1px solid #630a10;
	color: #ffffff;
	background-color:#630a10;
	vertical-align:middle;
}
.loginBtn:hover {
	color:#ffffff;
	border: 1px solid #9c0c15;
	background-color:#9c0c15;
}

/* *--------------------登录框的半透明背景------------------------* */
.loginBoxMask {
	z-index: 9998;
	position:fixed;
	top:0;
	left:0;
	width:100%;
	height:100%;
	background:#000;
	opacity:0.4;
	filter:alpha(opacity=40);
	display:none
}
/* *--------------------loginBox------------------------* */
.loginBox,.pwRetrieveBox{
	z-index:9999;
	position:fixed;
	top:50%;
	left:50%;
	width:600px;
	height:350px;
	margin:-150px 0 0 -300px;   /*整个背景是个div*/
	border-radius:5px;
	border:solid 2px #666;
	background-color:#fff;
	display:none;
	box-shadow: 0 0 10px #666;
}
/* *--------------------loginBoxTop------------------------* */
.loginBoxTop,.pwRetrieveBoxTop{
	border-bottom:1px solid #ddd;
	position: relative;
	height:20px;
	padding:12px;
	font:15px Microsoft YaHei;
	color:#444;
}

/* *--登录框关闭红叉--* */
.closeBtn{
	font-size:20px;
	margin-top:-5px;
	float:right;
	color:#444;
	text-decoration: none;
	
}
.closeBtn:hover{
	color:#9c0c15;
	text-decoration: none;
}
/* *--------------------loginBoxContent------------------------* */
.loginBoxContent,.pwRetrieveBoxContent{
	margin-top:40px;  
	margin-left:150px;  
	color:#444;
	height:250px;
	font:14px Microsoft YaHei;
}

.loginFrom {
	text-align:left;
}
/* *--------------------loginBoxBottom------------------------* */
.loginBoxBottom,.pwRetrieveBoxBottom{
	width:100%;
	height:41px;
	background:#DDD;
	font:13px Microsoft YaHei;
	color:#444;
}
.loginBoxBottom p,.pwRetrieveBoxBottom p{
	line-height:41px; /*与上面的height保持一致*/
	padding-left:20px;
}
.leftline{
	line-height:28px;
	float:left;
	display:inline;   /*不占一行 */
	padding-left:5em;

}
</style>
<link type="text/css" href="main/js/jquery-ui-1.10.2/themes/bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
<style>
.ui-dialog .ui-dialog-titlebar-close span{margin: -10px;}
.ui-dialog .ui-dialog-title{font-size: 14px;}
.ui-button-text-only .ui-button-text{font-size: 12px;}
.ui-dialog .ui-dialog-titlebar-close span{text-indent:-1e+7px;}
</style>
</head>
<body>
<%------------------------------整体div------------------------------%>
<div class="topbanner">
	<div id="currentTime"></div>
	<%
	if(user.getId()!=-1){%>
	<div class="leftline">
	    <span class="label">用户账户：</span><%=user.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;
	    <span class="label">角色：</span><%=RoleNameMap.get(user.getRoles()+"")%>(<%=DeptNameMap.get(user.getDeptId()+"")%>)&nbsp;&nbsp;&nbsp;&nbsp;
		<%-- <span class="label">上次登录时间</span>：<%=Tool.stringOfDateTime(user.getLastTime())%>　 --%>
	</div>
	<div class="loginLine">
		<a class="loginBtn" href="myaccount.jsp" target="contentFrame1" >我的账户</a>|
		<a class="loginBtn" href="main/sitemsg-list.jsp" target="contentFrame1" >消息中心</a>
		<a class="loginBtn" href="javascript:;" onclick="{if(confirm('确定要退出系统吗?')){window.location.href='main/logoff.jsp'}}"; id="showPwRetrieveBox">退出</a>
	</div>
	<%}else{%>
	<div class="loginLine">
		<a class="loginBtn" href="javascript:;" id="LoginBoxBtn">登&nbsp;&nbsp;录</a>|
		<a class="loginBtn" href="javascript:;" id="showPwRetrieveBox">找回密码</a>
	</div>
	<%}
	%>
</div>
<div class="toptitle">
   <a href="index.jsp">
	<div style="padding-left:40px"><img src="images/toptitle.jpg"></div>
	</a>
</div>

<div class="menuandcontent">
<iframe class="contentframe" name="contentFrame" id="contentframe" frameborder="0" scrolling=auto src="<%=url%>" ></iframe>
</div>
<%------------------------------login Box------------------------------%>
<div class="loginBox">
	<div class="loginBoxTop">
		<strong>山东大学学生素质拓展培养综合管理系统</strong>
		<a href="javascript:;" title="关闭" class="closeBtn">×</a>
	</div>
	<div class="loginBoxContent">
		<form class="loginFrom" name="logon">
		<input type="hidden" name="csrftoken" value="<%=csrftoken%>"/>
			<p>
				<strong>账&nbsp;&nbsp;户：</strong>
				<!-- <input type="text" name="useraccount" id="useraccount"  onblur="LoginBoxCheck(1);return false;" placeholder="输入账户名" autocomplete="off" size="20" class="ipt"/> -->
				<input name="Username" id="Username" type="text" value="" class="logininput001" placeholder="请输入用户名" autocomplete="off"/>
				<span id="logininfo1"></span>
			</p>
			<p>
				<strong>密&nbsp;&nbsp;码：</strong>
				<!-- <input type="password" name="userpassword" id="password"  onchange="LoginBoxCheck(2);return false;" placeholder="输入密码" autocomplete="off" size="20"  class="ipt"/> -->
				<input name="pd" id="pd" type="password" value="" class="logininput002" placeholder="请输入密码"/>
				<span id="logininfo2"></span>
			</p>
			<p style="padding-left:48px;">
				<input type="button" id="dlpic" value="登&nbsp;&nbsp;录 " class="loginBtn" />
			</p>
		</form>
	</div>
	<div class="loginBoxBottom">
		<p>学生用户首次登录默认密码为身份证号后6位，首次登录后请修改密码。</p>
	</div>
</div>
<div class="loginBoxMask"></div><%--登录框阴影背景--%>



<%------------------------------passwordRecall Box------------------------------%>
<div class="pwRetrieveBox">
	<div class="pwRetrieveBoxTop">
		<strong>找回密码</strong>
		<a href="javascript:;" title="关闭" class="closeBtn">×</a>
	</div>
	<div class="pwRetrieveBoxContent">

			<p>
				<strong>账&nbsp;&nbsp;&nbsp;户：</strong>
				<input type="text" name="useraccount"  id="useraccount2" onchange="LoginBoxCheck(3);return false;"  placeholder="输入账户名" autocomplete="off" size="20" class="ipt"/>
				<span id="logininfo3"></span>
			</p>
			<p>
				<strong>邮&nbsp;&nbsp;&nbsp;箱：</strong>
				<input type="text" name="Email" id="Email" placeholder="输入邮箱" autocomplete="off" size="20" class="ipt" />
				<span id="logininfo4"></span><input type="button" value="发送" onclick="send()" class="loginBtn">
			</p>
			<p>
				<strong>验证码：</strong>
				<input onchange="checkEmailCode()" type="text" name="Answer1" id="emailCode1" placeholder="输入邮箱验证码" autocomplete="off" size="20" class="ipt" />
				<span id="EmailCode"></span>
			</p>
			<p class="cuowu" style="display:none;">
			    <font color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;验证码错误</font>
			</p>
			<p class="xinmima" style="display:none;">
				<strong>新密码：</strong>
				<input type="password" name="Answer1" id="mima1" placeholder="输入新密码" autocomplete="off" size="20" class="ipt" />
				<span id="EmailCode"></span>
			</p>
			<p class="xinmima" style="display:none;">
				<strong>新密码：</strong>
				<input  type="password" name="Answer1" id="mima2" placeholder="确认新密码" autocomplete="off" size="20" class="ipt" />
				<span id="EmailCode"></span>
			</p>
			<p style="padding-left:48px;">
				<input type="button" id="pwRetrieveBtn" value="确&nbsp;&nbsp;定 " onclick="xiugaimima()" class="loginBtn"/>
			</p>
	</div>
	<div class="pwRetrieveBoxBottom">
		<p id="RetrivePW"></p>
	</div>
</div>
<div class="footer">
	<iframe class="footerframe" frameborder="0" scrolling="auto" src="index-footer.jsp"></iframe>
</div>
<div id="top_dialog"></div>
<script>
$("#top_dialog").dialog({
	modal: true,
	autoOpen:false,
	height:0
});
var tmpW = 900 , tmpH = 600;
$('.ui-dialog-title').dblclick(function(){
	var d_h1 = parent.document.documentElement.scrollHeight;
	var d_h2 = parent.document.body.scrollHeight;
	var d_h = Math.max(d_h1, d_h2);
	if($("#top_dialog").dialog('option','width') != $('body').width()){
		$("#top_dialog").dialog('option','width',$('body').width());
		$("#top_dialog").dialog('option','height',d_h);
	}else{
		$("#top_dialog").dialog('option','width',tmpW);
		$("#top_dialog").dialog('option','height',tmpH);
	}
});

</script>
</body>

</html>