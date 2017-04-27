<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivities"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivityParticipate"%>
<%@ page pageEncoding="utf-8" %>
<%
UserInfo ui = Tool.getUserInfo(request);
UserInfo userInfo =null;
if(ui.hasFunPower(Power.USERSTUDENTPOWER)){
	userInfo = ui;
}
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
String clubname = ParamUtils.getParameter(request,"clubname","");
int activityid = ParamUtils.getIntParameter(request,"activityid",-1);
ClubActivities v = new ClubActivities();
if(activityid!=-1&&v.getById(activityid)!=null){
	v = v.getById(activityid);
}
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/common.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.PrintArea.js" type="text/javascript" ></script>
<style type="text/css">
#theObjTable{
	background:#fff;
	font-family:仿宋_GB2312;
	line-height:150%;
}
p{
	font-size:12pt;
}
.title{
	font-size:16pt;
	text-align:center;
	padding-top:-20px;
	padding-bottom:-20px;
	font-weight: bold;
}
.item{
	text-align:justify;
	text-justify:inter-ideograph;
}
</style>
<script type="text/javascript">
function getNowFormatDate() {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var currentdate = date.getFullYear() + "年" + month + "月" + strDate + "日";
    return currentdate;
}

/* function tableToWord(){
	var printtime=getNowFormatDate();

	try{
	    var oWD = new ActiveXObject("Word.Application");
	    var oDC = oWD.Documents.Add("", 0, 1);//不打开模版直接加入内容
	    var oRange = oDC.Range(0, 1);
	    
	    var sel = document.body.createTextRange();
	    sel.moveToElementText(theObjTable);//此处theObjTable是页面div的id 
	    sel.select();
	    sel.execCommand("Copy");
	    
	    oRange.Paste();
	    oWD.Application.Visible = true;
	}catch (e) {
	    alert("您的电脑没有安装Microsoft Word软件！或设置IE工具，安全--启动-对没有标记为安全的Activex的控件进行初始化和脚本运行");
	    return false;
	}
}
*/
function printthis(){
	if(confirm("确定要打印吗？")){
		$(".demo").printArea();
	}
} 
</script>
</head>

<body>
<%
String strposition = "社团数据维护  >>社团活动列表>> ";
String strfunction = "会长（带队队长）承诺书";
String strhelpwords= "会长（带队队长）承诺书。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td style="text-align:left;">
    </td>
    <td>
    	<a href="#" onclick="printthis();"><img src="../images/commandico/print.png" align="absmiddle"></a>
    	<!-- <a href="#" onclick="history.go(-1)"><img src="../images/commandico/back.png" align="absmiddle"></a> -->
    </td>
</tr>
<tr>
</tr>
</table>
<div class="demo">
<style>
.nametable{
	width: 90%;
	border-right:1px solid;
	border-bottom:1px solid;
	margin-left: auto;
	margin-right: auto;
}

.nametable td{
	border-left:1px solid;
	border-top:1px solid;
	height: 30px;
	font-family:仿宋_GB2312;
}
</style>
<div id="theObjTable">
<p align="center"><span class="title">会长（带队队长）承诺书</span></p>
<p class="item">&nbsp;&nbsp;&nbsp;&nbsp;我作为<span style="text-decoration: underline;">&nbsp;&nbsp; <%=clubname %>  &nbsp;&nbsp;</span>协会的主要负责人和本次<span style="text-decoration: underline;">&nbsp;&nbsp; <%=v.getActivityName() %> &nbsp;&nbsp; </span>活动的领队，本着热心为社团同学服务、真诚向协会会员负责的态度，向学校和全体社团会员郑重承诺：<br/>
1、严格遵守学校制定的《山东大学学生社团管理章程》、《山东大学学生社团举办各类出游、社会实践、外出考察等校外活动安全监督实施细则》的有关管理规定；<br/>
2、决不在未经批准及手续办理不全的情况下擅自举办各类出游、社会实践、外出考察等校外活动；<br/>
3、决不允许社团成员在未经批准及手续办理不全的情况下私自召集、组织各类出游、社会实践、外出考察等校外活动；<br/>
4、对于私自召集，组织的各类出游、社会实践、外出考察等校外活动，一经发现，将及时向学校有关部门反映，并对活动相关成员及时予以劝阻；<br/>
5、对于学校批准的各类出游、社会实践、外出考察等校外活动，将本着为社团成员认真负责的态度，细致的办好各项审批工作；<br/>
6、在活动过程中，全心全意为社团同学服务，担负起一个社团干部的光荣职责，通过细致认真的工作，确保活动的成功举行；<br/>
7、在本次活动中，我们只允许以下<span style="text-decoration: underline;" id="countspan"></span>位已经签署了《山东大学学生社团校外活动安全监督书》的同学参加本次活动，决不允许未签署《山东大学学生社团校外活动安全监督书》的同学以及其他无关人员参加本次活动。如不能够履行本承诺，由此在活动中发生的任何意外情况，我愿意承担全部责任。
</p>
<p align="right">
承诺人：<span style="text-decoration: underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（职务<span style="text-decoration: underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>）<br>     
<span style="text-decoration: underline;">&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</span>      
</p>
<p align="center">已签署《山东大学学生社团校外活动安全监督书》的会员名单</p>
<% %>
<p align="left">
<table class="nametable" border="0" cellspacing="0" cellpadding="2">
<tr>
    <td align="center"  width="13%">姓名</td>
    <td align="center"  width="12%">学号</td>
    <td align="center"  width="25%">学院</td>
</tr>
<%
ClubActivityParticipate cap = new ClubActivityParticipate();
List cdt = new ArrayList();
List list = new ArrayList();
cdt.add("activityid="+activityid);
list = cap.query(cdt);
List uidList = new ArrayList();
if(list.size()>0)
	for(int i=0;i<list.size();i++){
		cap = (ClubActivityParticipate)list.get(i);
		uidList.add(cap.getSname());
	}
ClubUtil util = new ClubUtil();
Map<String,BaseUserCode>userMap = new HashMap<String,BaseUserCode>();
userMap = util.getUserMap(Tool.join(",",uidList));

if(list.size()>0)
	for(int i=0;i<list.size();i++){
		cap = (ClubActivityParticipate)list.get(i);
		BaseUserCode u = new BaseUserCode();
		u = userMap.get(cap.getSname())==null?new BaseUserCode():userMap.get(cap.getSname());
		%>
		<tr>
		<td><%=u.getCnName() %></td>
		<td><%=u.getName() %></td>
		<td><%=AcademyNameMap.get(u.getDeptId()+"") %></td>
		</tr>
	<%}
userMap.clear();

%>
</table>
</p>
<p align="right">
打印时间：<%=Tool.stringOfCnDate(new Date()) %></p>
</div>
</div>
</body>
</html>
