<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生界面头</title>
<link href="css/stumenu.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
function js_method(obj){
	alert("请登录系统");
}
/*css无法知道当前屏幕的高度，只能由js获取浏览器的高度-28-120-40-30得到contentFrame的高度*/
$(function(){
    var MyHeight=document.documentElement.clientHeight-130;  
    $(".contentdiv").height(MyHeight);
});  
</script>
</head>
<body>

<div class="headerbg">
<!--导航-->
<ul id="nav">
<li class="nav-item">
<a href="#" class="nav-link">基本信息</a>
<div class="nav-dropdown" style="display: none">
<ul class="trending">
<li><a href="javascript:js_method(this);" target="contentFrame">账户信息</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">个人信息</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">组织建设</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href='javascript:js_method();'  target='contentFrame'>五四评比表彰</a></li>
<li><a href="javascript:js_method();" target="contentFrame">培训项目报名</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">培训项目考核</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">结题报告上传</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">学生社团</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">社团成立申请</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">学生社团信息</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">社团活动管理</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">社会工作</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">校学生会</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">院学生会</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">社团工作</a></li>
<li><a href="javascript:js_method();" target="contentFrame">班级工作</a></li>  
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">社会实践</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">项目列表</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">项目申报</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">文化活动</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">主题教育</a></li>
<li><a href="javascript:js_method();" target="contentFrame">文化艺术</a></li>  
<li><a href="javascript:js_method();" target="contentFrame">体育健康</a></li>
<li><a href="javascript:js_method();" target="contentFrame">学术论坛</a></li>  
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">创新创业</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">科技创新</a></li>
<li><a href="javascript:js_method();" target="contentFrame">就业创业</a></li>  
<li><a href="javascript:js_method();" target="contentFrame">创业项目</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">山大创库</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">志愿服务</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">志愿活动浏览</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">志愿竞赛项目</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">志愿信息查询</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">场地信息</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">场地列表</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">场地申请</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">申请状态</a></li> 
</ul>
</div>
</li>

<li class="nav-item">
<a href="#" class="nav-link">其他服务</a>
<div class="nav-dropdown" style="display: none;">
<ul class="trending">
<li><a href="javascript:js_method();" target="contentFrame">调查问卷</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">团员证补办</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">公告附件上传</a></li> 
<li><a href="javascript:js_method();" target="contentFrame">学生拓展培养认证单</a></li> 
</ul>
</div>
</li>

</ul>

</div>
<div class="contentdiv">
	<iframe class="contentFrame" name="contentFrame" frameborder="0" scrolling="auto" src="student-contentFrame.jsp"></iframe>
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