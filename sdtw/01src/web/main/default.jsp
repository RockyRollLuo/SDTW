<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.base.CNavTree"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo==null){
	out.print("<meta http-equiv='refresh' content='0;url="+ HeadConst.root_url_path + "/main/logon.jsp'>");
    return;
} 

String md = ParamUtils.getParameter(request, "md", "1");
CNavTree tree = new CNavTree();
String wel = "welcome.jsp";
if(md.equals("3") || md.equals("4")||md.equals("5")||md.equals("6")||md.equals("7")||md.equals("8")||md.equals("2")){
	wel = "website/welcome.jsp?md="+md;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title><%=HeadConst.product_name %></title>
<base href="<%=HeadConst.apache_url %>/main/"></base>
<jsp:include page="jqueryui.jsp" />
<link href="js/jquery-ui-1.10.2/themes/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link type="text/css" href="js/jquery-ui-1.10.2/themes/bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
<link type="text/css" href="js/jquery-ui-1.10.2/themes/bootstrap/assets/css/font-awesome.min.css" rel="stylesheet" />


<link href="js/jquery-ui-1.10.2/themes/bootstrap/assets/css/docs.css" rel="stylesheet">
<link href="images/skin/blue/css.css" rel="stylesheet" type="text/css" />
<link href="js/jquery-ui-1.10.2/themes/bootstrap/assets/js/google-code-prettify/prettify.css" rel="stylesheet">

<link rel="stylesheet" href="<%=HeadConst.apache_url%>/main/js/sticky/sticky.css"  />    
<script src="<%=HeadConst.apache_url%>/main/js/sticky/sticky.min.js" ></script>
<script language="JavaScript" type="text/javascript" src="js/tab.js"></script>
<script language="JavaScript" type="text/javascript" src="js/tab1.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.nicescroll.js"></script>
<script src="js/index.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
<script src="<%=userInfo.getRootUrl()%>/main/js/jquery.form.js"></script>
<link href="js/win/corner_win.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/win/corner_win.js"></script>
<script type="text/javascript" src="js/win/index_win.js"></script>
<script>
var md="<%=md%>";
var userId = (<%=userInfo.getId()%>);
function show(id){
	if(id==0){//oa首页
		location="default.jsp";
	}else if(id==1){//修改密码
		mainFrame.location="modifyPwd.jsp";
	}else if(id==11){//个人资料
		mainFrame.location="main/personal/UserCode2Action.jsp?cmd=modify&Id=<%=userInfo.getUserCode().getId() %>";
	}else if(id==12){//安全退出
		location="logoff.jsp";
	}
}
/*
 * 页面高度
 */
function initHeight(){
	var clienth = document.documentElement.clientHeight-154;
	var clientw = document.documentElement.clientWidth-255;
	$('.right').height(clienth);
	$('.right').width(clientw);
	$('.left').height(clienth);
	//alert(clienth)
}
$(function(){
	initHeight();
	$(".left").niceScroll({cursorborder:"",cursorcolor:"#e85280",boxzoom:false,autohidemode:false}); 
	//$(".right").niceScroll("#mainFrame",{cursorcolor:"#00F",cursoropacitymax:0.7,boxzoom:false});
	window.onresize = initHeight;
	//屏蔽站内信 setInterval(getShortMsg,1000*30);
});

/*
 * 菜单展示
 */
function showmenu(cur){
	var tmp = $(cur).next("div");
	if(tmp.hasClass('tree_select')){
		tmp.slideUp();
		tmp.removeClass('tree_select');
	}else{
		$(cur).siblings("div").each(function(){
			if($(this).hasClass('tree_select')){
				$(this).slideUp();
				$(this).removeClass('tree_select');
			}
		});
		tmp.slideDown();
		tmp.addClass('tree_select');
		if($(cur)[0].tagName == 'LI'){
			$(cur).siblings().find('a').removeAttr('style');
			$(cur).find("a").attr('style','color:#fd6500');
		}
		setTimeout(function(){$(".left").getNiceScroll().resize()},500);
	}
}
/*
 * 当前菜单样式
 */
function curMenu(cur){
	$(".left").find('a').each(function(){
		$(this).removeAttr('style');
	})
	$(cur).attr('style','color:#fd6500');
}

	
$(document).ready(function(){ 
    $("#mainFrame").load(function(){ 
    $(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
    var height = $(this).contents().height() + 30; 
    var clienth = document.documentElement.clientHeight-164;
    $(this).height( height < clienth ? clienth : height ); 
  }); 
}); 
document.documentElement.className += 'js';
</script>
<style type="text/css">
iframe{
	width:100%;
}
html{overflow-y:hidden; }
.jstree-closed{display:none;}
</style>
</head>

<body>
<div class="top">
<div style="height: auto;padding-top: 0px;padding-left: 10px;width: 100%; background: #000000;">
<%
Map RoleNameMap = CEditConst.getRoleNameMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
%>
    <span style="color:#EEB422;font-size: 12px;">用户账户：<font style="color: #ffffff"><%=userInfo.getUserCode().getName()%></font></span>
	&nbsp;&nbsp;<span style="color:#EEB422;font-size: 12px;">角色：<font style="color: #ffffff"><%=RoleNameMap.get(userInfo.getUserCode().getRoles())%></font></span>
	    <%
	    if(userInfo.hasFunPower(Power.UserAdminPower)||userInfo.hasFunPower(Power.STUSER)){%>
	    	<span style="color:#EEB422;font-size: 12px;"><font style="color: #ffffff">
	    	(所属单位：<%=AcademyNameMap.get(userInfo.getDeptId()+"") %>)
	    	</font></span>
	    <%}
	    %>
	    <%
	    if(userInfo.hasFunPower(Power.ADMINPOWER)){%>
	    	<span style="color:#EEB422;font-size: 12px;"><font style="color: #ffffff">(团委用户)</font></span>
	    <%}
	    %>
		<%-- <span>上次登录时间</span>：<%=Tool.stringOfDateTime(userInfo.getUserCode().getLastTime())%>　 --%>
    </div>
<div class="area">
	<div id="loading_layer" style="display:none"><img src="images/ajax_loader.gif"  alt="" /></div>
    <div class="logo"><a href="#"><img src="../images/topBanner.png" /></a></div>
    <div class="anbn">
        <a class="mo0099" id="arrowLeft" href="javascript:void(0);"></a>
	    <ul id="ancn">
	        <span>
		    <li class="<%=md.equals("1")? "dangqian001" : "mo001"%>"><a href="default.jsp">山东大学</a></li>
		     
		    </span>
		</ul>
		<a class="mo009" id="arrowRight" href="javascript:void(0);" onclick="gpSwitch('left')"></a>
		<div class="mo010" id="exit"><a href="javascript:show(12);">退出系统</a></div>
		
	</div>
</div>
</div>
<div class="area">
    <div class="left">
		 <%= tree.getMainMenu(userInfo) %>
	</div>
    <div class="right" id="right" class="content">
	    <iframe id="mainFrame" name="mainFrame" frameborder="0" width="100%" src="sitemsg-list.jsp" ></iframe>
	</div>
</div>
<div class="end"><%-- <div class="online">在线 <%=num %> 人</div> --%>————  版权所有  <%=HeadConst.product_copyright %>  ————<div class="back_home"><a href="<%=HeadConst.apache_url%>">网站首页</a></div></div>
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
<script>
setTimeout('$("html").removeClass("js");',1000);
</script>
