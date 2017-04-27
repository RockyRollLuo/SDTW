<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
    <%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.sdtw.db.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生界面头</title>
<link href="css/stumenu.css" rel="stylesheet"/>
 <script type="text/javascript" src="js/jquery.min.js"></script>
 
<script type="text/javascript">

function js_method(){
	alert("请登录系统");
}


/*css无法知道当前屏幕的高度，只能由js获取浏览器的高度-28-120-40-30得到contentFrame的高度*/
$(function(){
    var MyHeight=document.documentElement.clientHeight-50;  
    $('.contentdiv').height(MyHeight+'px');
    
    var userAgent = navigator.userAgent;
    if (userAgent.indexOf("Firefox") > -1) {
    }
});  
</script>

</head>
<body >

<div class="headerbg">

<!--导航-->
<ul id="nav">

<li class="nav-item">
<a href="#" class="nav-link">基本信息</a>
<div class="nav-dropdown" style="display: none">
<ul class="trending">
<li><a href="myaccount.jsp" target="contentFrame1">账户信息</a></li> 
<li><a href="student-info.jsp" target="contentFrame1">个人信息</a></li> 
<!-- <li><a href="role-student/student-officer.jsp" target="contentFrame">学生干部信息</a></li>  -->
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">组织建设</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href='main/youthhonour/YouthhonourStudentNoticeList.jsp'  target='contentFrame1'>五四评比表彰</a></li>
<li><a href="train/training_arrangement-list.jsp" target="contentFrame1">培训项目</a></li> 
<!-- <li><a href="javascript:js_method();" target="contentFrame1">培训项目考核</a></li> 
<li><a href="javascript:js_method();" target="contentFrame1">结题报告上传</a></li>  -->
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">学生社团</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="student/club-setup-list.jsp" target="contentFrame1">社团成立申请</a></li> 
<li><a href="student/club-all-list.jsp" target="contentFrame1">学生社团信息</a></li> 
<li><a href="student/club-activity-mylist.jsp" target="contentFrame1">社团活动管理</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">社会工作</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="stuUnion/stuorg-studentunion-list.jsp?unionType=1" target="contentFrame1">校学生会</a></li> 
<li><a href="stuUnion/stuorg-studentunion-list.jsp?unionType=2" target="contentFrame1">校研究生会</a></li> 
<li><a href="stuUnion/stuorg-studentunion-list.jsp?unionType=3" target="contentFrame1">院学生会</a></li>
<li><a href="stuUnion/stuorg-studentunion-list.jsp?unionType=4" target="contentFrame1">院研究生会</a></li>  
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">社会实践</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="pratice/pratice-activity-list.jsp" target="contentFrame1">项目信息浏览</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">文化活动</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="campus/campus-activity-list.jsp?flag=whhd" target="contentFrame1">活动信息浏览</a></li>
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">创新创业</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="campus/campus-activity-list.jsp?flag=cxkj" target="contentFrame1">科技创新</a></li>
<li><a href="campus/campus-activity-list.jsp?flag=cyjy" target="contentFrame1">就业创业</a></li>  
<li><a href="chuangku/innovation-competition-project-list.jsp" target="contentFrame1">创业竞赛列表</a></li> 
<li><a href="chuangku/innovation-chuangku-list.jsp" target="contentFrame1">山大创库</a></li> 
</ul>
</div>
</li>



<li class="nav-item">
<a href="#" class="nav-link">志愿服务</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<%
UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}else{
user = userInfo.getUserCode();

}

%>

<li><a href="volunteer\volunteer-activity-list.jsp"  target="contentFrame1">志愿活动浏览</a></li> 
<li><a href="volunteer\volunteer-project-list.jsp" target="contentFrame1">志愿竞赛项目</a></li> 
<li><a href="volunteer\volunteer-activity-indilist.jsp"  target="contentFrame1">志愿履历查询</a></li> 
<li><a href="volunteer\volunteer-zhiku-list.jsp"   target="contentFrame1">山大志库</a></li> 




</ul>
</div>
</li>



<li class="nav-item">
<a href="#" class="nav-link">场地信息</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="places\places-list.jsp" target="contentFrame1">场地列表</a></li> 
<li><a href="places\places-application-list.jsp" target="contentFrame1">场地申请</a></li> 
<li><a href="places\places-applyed-list.jsp" target="contentFrame1">我的申请</a></li> 
</ul>
</div>
</li>


<li class="nav-item">
<a href="#" class="nav-link">其他服务</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="main/studentrzd/StudentRzdStudentList.jsp" target="contentFrame1">学生拓展培养认证单</a></li> 
<!-- <li><a href="student/ImportExcel.jsp" target="contentFrame1">导入信息</a></li>  -->
</ul>
</div>
</li>

</ul>

</div>
<div class="contentdiv" style="height: 100%;">
	<iframe class="contentFrame1" name="contentFrame1" id="contentFrame1" frameborder="0" scrolling="auto" src="main/sitemsg-list.jsp"></iframe>
</div>
<script type="text/javascript">
(function(jq){
	jq.fn.dropdown = function(settings){
	var defaults = {
	dropdownEl: '.dropdown-menu',
	openedClass: 'dropdown-open',
	delayTime: 100
};
var opts = jq.extend(defaults, settings);
return this.each(function(){
	var curObj = null;
	var preObj = null;
	var openedTimer = null;
	var closedTimer = null;
	jq(this).hover(function(){
		if(openedTimer)
			clearTimeout(openedTimer);
		curObj = jq(this);
		openedTimer = setTimeout(function(){
	curObj.addClass(opts.openedClass).find(opts.dropdownEl).show();
},opts.delayTime);
preObj = curObj;
},function(){
if(openedTimer) clearTimeout(openedTimer);
openedTimer = setTimeout(function(){
preObj.removeClass(opts.openedClass).find(opts.dropdownEl).hide();
},opts.delayTime);
});
jq(this).bind('click', function(){
	if(openedTimer) clearTimeout(openedTimer);
	openedTimer = setTimeout(function(){
		preObj.removeClass(opts.openedClass).find(opts.dropdownEl).hide();
	},opts.delayTime);
});
});
};

})(jQuery);
//下拉菜单
(function(jq) {
	jq('#nav .nav-item').dropdown({dropdownEl:'.nav-dropdown',openedClass:'nav-item-open'});
})(jQuery);

</script>

</body>
</html>