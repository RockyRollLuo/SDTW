<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.db.PracticeReport"%>
<%@page import="com.xietong.software.sdtw.db.PracticeDeclare"%>
<%@page import="com.xietong.software.sdtw.db.Practice"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.common.PageControl"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.CampusParticipate"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page pageEncoding="utf-8" %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
PracticeUtil util = new PracticeUtil();
List list = util.getPracticeList(request);
Map<String,PracticeReport>practiceDeclareMap = new HashMap<String,PracticeReport>();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script> 
<script src="../js/tablelist.js"></script>
<script>
function shangbao(id) {
	location = "pratice-project-addsave.jsp?id="+id+"&cmd=shangbao";
}
</script>
</head>

<body>
<%
String strposition = "社会实践>>实践项目>>";
String strfunction = "项目列表";
String strhelpwords = "显示已添加的活动列表。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="content-table">
<tr>
	<th>名称</th>  
	<th>申请日期</th> 
	<th>申请类型</th>
	<th>提交状态</th>
	<th>学院审核</th>
	<th>团委审核</th>
  	<th>评定结果</th>
	<th>操作</th>
</tr>
<%
if(list.size()>0) {
	practiceDeclareMap = util.getPracticeReportMap(userInfo.getId());
	for (int i=0;i<list.size();i++) {
		Practice v = new Practice();
		v = (Practice)list.get(i);
	%>
	<tr>
	<td><%=v.getPracticeName() %></td>
	<td><%=Tool.stringOfDate(Tool.stringToDateTime(v.getStarttime())) %>~<%=Tool.stringOfDate(Tool.stringToDateTime(v.getEndtime())) %></td>
	<td>
	<%PracticeReport pd = new PracticeReport();
	if (practiceDeclareMap.get(v.getId()+"")==null) {%>
	<%} else {
		pd = practiceDeclareMap.get(v.getId()+"");
		 if (pd.getType()==1) {%>
			集体申请 
		 <%}
		 if (pd.getType()==2) {%>
			个人申请 
			 <%}%>
	<%}
	%>
	</td>
	<td>
	<%
	if (practiceDeclareMap.get(v.getId()+"")==null) {%>
	<%} else {
		pd = practiceDeclareMap.get(v.getId()+"");
		Map map = util.getSubmitflagMap();%>
		<%=map.get(pd.getSubmitFlag()+"") %>
	<%}
	%>
	</td>
	<td>
	<%
	if(pd.getId()!=-1) {
		int num = pd.getXyCheckFlag();
		if(num==1){%>
		学院审核通过
	<%}
		if(num==2){%>
			学院审核不通过
		<%}
	}else{%>
		学院未审核
	<%}
	%>
	</td>
	<td>
	<%if(pd.getId()!=-1) {
		int num = pd.getTwCheckFlag();
		if(num==1){%>
		团委审核通过
	<%}
		if(num==2){%>
			团委审核不通过
		<%}
	}else{%>
		团委未审核
	<%}
	%>
	</td>
	<td>
	<%
	if (practiceDeclareMap.get(v.getId()+"")!=null) {
		pd = practiceDeclareMap.get(v.getId()+"");
		if (pd.getTwCheckFlag()==1) {//团委审核通过后查看
	%>
		<a href="honor.jsp?ReportId=<%=pd.getId()%>&DeclareId=<%=v.getId()%>">查看</a>
	<%}
	}
	%>
	</td>
	<td>
	<%
	if (practiceDeclareMap.get(v.getId()+"")==null) {
		if(Tool.stringToDateTime(v.getStarttime()).getTime()<=new Date().getTime() && Tool.stringToDateTime(v.getEndtime()).getTime()>=new Date().getTime()) {%>
			<a href="practice-project-report-team.jsp?DeclareId=<%=v.getId()%>">集体申请</a>&nbsp;&nbsp;
			<a href="practice-project-report-personal.jsp?DeclareId=<%=v.getId()%>">个人申请</a>
		<%} else {%>
			活动未开始，或已结束
		<%}
	%>
		
	<%} else {
		pd = practiceDeclareMap.get(v.getId()+"");
		if(pd.getType()==1) {//集体
	%>
		<a href="practice-project-report-team.jsp?id=<%=pd.getId()%>&DeclareId=<%=v.getId()%>">查看</a>
		<%
		} else {%>
			<a href="practice-project-report-personal.jsp?id=<%=pd.getId()%>&DeclareId=<%=v.getId()%>">查看</a>
		<%}
		if (pd.getSubmitFlag()==-1) {%>
			<a href="javascript:;" onclick="shangbao(<%=pd.getId()%>)">提交</a>
		<%}
	%>
	<%}
	%>
	</td>
	</tr>
	<%}
}
%>
</table>
<%
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	%>
	<%=pagecontrol.getControl_win8_("pratice-activity-list.jsp",  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>

</body>
</html>