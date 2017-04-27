<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.common.PageControl"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.sdtw.db.Students"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.xietong.software.sdtw.db.Youthhonour_notice"%>
<%@page import="com.xietong.software.sdtw.db.YouthHonour"%>
<%@page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@ page pageEncoding="utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*" %>
<%@ include file="/main/js/jsheader.jsp"%>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	//out.print(HtmlTool.msgBox(request, "请先登录"));
	return ;
}

YouthhonourUtil yhUtil = new YouthhonourUtil();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<script src="../js/jquery.min.js"></script> 
<script src="../../js/tablelist.js"></script> 
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
</head>
<body>
<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<%
String strposition = "组织建设>>五四评比表彰";
String strfunction = "";
String strhelpwords = "评比表彰列表。";
%>
<%@ include file='/student/pagetop-positionandhelp.jsp' %>
<table class="content-table">
<tr>
	<th width="5%">序号</th>
	<th >五四评比表彰通知</th>
	<th width="20%">通知日期</th>
	<th width="20%">状态</th>
	<th width="10%">操作</th>
</tr>
<%
List noticeList=new ArrayList();
noticeList=yhUtil.getNoticeList();
Map twReportMap=yhUtil.getTwReportMap();

for(int i=0;i<noticeList.size();i++){
	Youthhonour_notice notice=(Youthhonour_notice)noticeList.get(i);
	%>
	<tr>
		<td><%=i+1%></td>
		<td><a href="YouthhonourStudentNoticeDetail.jsp?noticeid=<%=notice.getId()%>"><%=notice.getNotice()%></a></td>
		<td><%=Tool.stringOfCnDate(notice.getAddTime())%></td>
		<td><%=twReportMap.get(notice.getTwReport())%></td>
		<td><a href="YouthhonourStudentList.jsp?noticeid=<%=notice.getId()%>">查看</a></td>
	</tr>
<%
}
if(noticeList.size()==0){
%>
<tr><td colspan="5">无信息</td></tr>
<%}%>
<tr>
	<th colspan="5"></th>
</tr>
</table>
</body>
</html>

