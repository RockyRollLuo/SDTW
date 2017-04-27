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
<%@page import="com.xietong.software.sdtw.db.YouthHonour"%>
<%@page import="com.xietong.software.sdtw.db.Youthhonour_notice"%>
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
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);

Youthhonour_notice yhNotice=new Youthhonour_notice();
YouthhonourUtil yhUtil = new YouthhonourUtil();

//noticeid,userid确定本页内容
String userid=userInfo.getId()+"";
int noticeid=ParamUtils.getIntParameter(request,"noticeid",-1);

yhNotice=yhNotice.getById(noticeid);

//团委是否公布此条notice结果
int twreport=yhNotice.getTwReport();

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
String strposition = "组织建设>>五四评比表彰>>";
String strfunction =yhNotice.getNotice();
String strhelpwords = "评比表彰列表。";
%>
<%@ include file='/student/pagetop-positionandhelp.jsp' %>

<table class="command-table">
<tr>
	<td><a href="YouthhonourStudentNoticeList.jsp">返回</a></td>
</tr>
</table>

<table class="content-table">
<tr>
	<th width="5%">序号</th>
	<th >五四评比表彰内容</th>
	<th width="10%">学院审核情况</th>
	<th width="10%">团委审核情况</th>
	<th width="18%">操作</th>
</tr>
<%
Map<Integer,String> studentHonourMap=new HashMap<Integer,String>();
studentHonourMap=(Map<Integer,String>)yhUtil.getStudentYouthhonourMap();
Map xyCheckMap=yhUtil.getXyCheckMap();
Map twCheckMap=yhUtil.getTwCheckMap();
int i=1;
for(Map.Entry<Integer, String> entry:studentHonourMap.entrySet()){ 

	//获取userid,noticeid,type,下的Youthhonour
	YouthHonour v=yhUtil.getOneYouthhonour(noticeid, entry.getKey(), userid);
	
	int modifyflag=-1;
	int id=-1;	
	if(v!=null){
		modifyflag=v.getModifyFlag();
		id=v.getId();
	}
	%>
	<tr>
		<td><%=i%></td>
		<td><%=entry.getValue()%></td>
		<%if(v!=null&&modifyflag!=SdtwConst.MODIFY_WTJ){%>
		<td><%=xyCheckMap.get(v.getAyCheckFlag())%></td>
		<td><%=twCheckMap.get(v.getTwCheckFlag())%></td>
		<%}else{%>
		<td></td>
		<td></td>
		<%}%>
		<td>
		<%if(v==null){%>
			<%if(twreport!=SdtwConst.TWREPORT_YGB){//已公布%>
				<a href="YouthhonourStudentForm<%=entry.getKey()%>.jsp?cmd=create&noticeid=<%=noticeid%>&type=<%=entry.getKey()%>">申请</a>
		<%}}else if(v!=null&&modifyflag==SdtwConst.MODIFY_WTJ){ //未提交%>
			<a href="YouthhonourStudentForm<%=entry.getKey()%>.jsp?cmd=update&id=<%=id%>&noticeid=<%=noticeid%>&type=<%=entry.getKey()%>">修改</a>&nbsp;&nbsp;&nbsp;
			<a href="YouthhonourStudentForm-save.jsp?cmd=delete&id=<%=id%>&noticeid=<%=noticeid%>&type=<%=entry.getKey()%>">删除</a>&nbsp;&nbsp;&nbsp;
			<a href="YouthhonourStudentForm-save.jsp?cmd=submit&id=<%=id%>&noticeid=<%=noticeid%>&type=<%=entry.getKey()%>">提交</a>
		<%}else if(modifyflag==SdtwConst.MODIFY_YTJ){//已提交%>
			<a href="YouthhonourStudentForm<%=entry.getKey()%>.jsp?cmd=view&id=<%=id%>&noticeid=<%=noticeid%>&type=<%=entry.getKey()%>">查看</a>
			<%if(twreport==SdtwConst.TWREPORT_WGB){%>
			<a href="YouthhonourStudentForm-save.jsp?cmd=applymodify&id=<%=id%>&noticeid=<%=noticeid%>">申请修改</a>
		<%}}else if(modifyflag==SdtwConst.MODIFY_SQXG){//已提交，但是申请修改%>
			<a href="YouthhonourStudentForm<%=entry.getKey()%>.jsp?cmd=view&id=<%=id%>&noticeid=<%=noticeid%>&type=<%=entry.getKey()%>">查看</a>
			<%if(twreport==SdtwConst.TWREPORT_WGB){%>
			<a href="#">申请修改审核中</a>
		<%}}%>			
		</td>
	</tr>
	<%
	i++;
}
	studentHonourMap.clear();
%>
<tr>
	<th colspan="10"></th>
</tr>
</table>
</body>
</html>

