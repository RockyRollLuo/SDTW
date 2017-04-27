<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页尾</title>
<style type="text/css">
body{
	margin:0;
	padding:0;
	font-family:微软雅黑,Verdana;
	font-size:13px;
	background:rgb(99,10,16);   /*背景颜色*/
	color:#fff;       /*字体颜色 */
	
}
.wholeline{
	width:100%;
	height:30px;       /*单行 设置实际高度与行高相等，即可实现垂直居中*/
	line-height:30px;
}

.leftline{
	float:left;
	display:inline;   /*不占一行 */
	padding-left:5em;

}

.rightline{
	float:right;
	padding-right:10em;
}

.label{
	font-size:13px;
	color:#FFF;
	padding-left:1em;
}

</style>
</head>
<body>
<div class="wholeline">
	<div class="leftline">
	    <span class="label">地址：中国山东省济南市山大南路27号</span>&nbsp;&nbsp;&nbsp;&nbsp;|
	    <span class="label">邮编：250100</span>&nbsp;&nbsp;&nbsp;&nbsp;|
		<span class="label">电话：(883) 61991</span>
	</div>
	<div class="rightline">
		<span class="label">版权所有：共青团山东大学团委会</span>&nbsp;&nbsp;&nbsp;&nbsp;|
		<span class="label">技术支持：计算机科学与技术学院</span>
	</div>
</div>
</body>
</html>