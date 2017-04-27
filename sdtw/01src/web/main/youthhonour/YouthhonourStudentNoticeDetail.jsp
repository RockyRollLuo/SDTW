<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--五四评比表彰申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	
	int noticeid=ParamUtils.getIntParameter(request, "noticeid", -1);
	YouthhonourUtil yhUtil=new YouthhonourUtil();
	Youthhonour_notice yhNotice=new Youthhonour_notice();
	yhNotice=yhNotice.getById(noticeid);

%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="../css/common-student.css">
		<script src="../../js/tablelist.js"></script> 
		<script src="../js/jquery.min.js"></script> 
	</head>
	<body>
	<%
	String strposition = "组织建设>>五四评比表彰>>";
	String strfunction ="五四评比表彰表彰通知";
	String strhelpwords = "通知。";
	%>
	<%@ include file="/student/pagetop-positionandhelp.jsp" %>
	
	<table class="command-table">
	<tr>
		<td><a href="YouthhonourStudentNoticeList.jsp?noticeid=<%=noticeid%>" >返回</a></td>
	</tr>    
	</table>
	<table class="content-table">
	<tr>
		<th colspan="2" align="left">五四评比表彰表彰通知</th>
	</tr>
    <tr>
    	<td align="right" class="form_label" width="30%">通知</td>
  		<td align="left"  bgcolor="#ffffff"><%=yhNotice.getNotice()%></td>
	</tr>
    <tr>
    	<td align="right" class="form_label">添加时间</td>
  		<td align="left"  bgcolor="#ffffff"><%=Tool.stringOfCnDate(yhNotice.getAddTime())%></td>
	</tr>
    <tr>
    	<td align="right" class="form_label">内容</td>
  		<td align="left"  bgcolor="#ffffff"><%=yhNotice.getBrief()%></td>
	</tr>
    <tr>
    	<th colspan="2"></th>
	</tr>

	</table>

	</body>
</html>
