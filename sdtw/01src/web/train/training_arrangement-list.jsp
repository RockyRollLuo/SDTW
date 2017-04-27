<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.common.PageControl"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.sdtw.db.TrainingParticipate"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.TrainingArrangement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.train.TrainUtil"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	return ;
}
TrainUtil util = new TrainUtil();
List list = new ArrayList();
list = util.getTrainArrangementList(request);
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map AuditMap = util.getAuditMap();
String currpage = ParamUtils.getParameter(request,"page","1"); 
%>  
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src='../js/tablelist.js'></script>
<script src='../js/jquery.min.js'></script>
<script>
function addApply(ProjectId,Id,page) {
	$.ajax({
        type: "post",
        ///sdfz/01src/web
        url: "training_arrangement-save.jsp",
        data: {"cmd":"addApply","ProjectId":ProjectId,Id:Id},
        dataType: "json",
        cache: false,
        success: function(data){
                  if(data.msg=="ok"){
                	  alert("报名成功！")
                	  window.location.href='training_arrangement-list.jsp?active=1&page='+page;
                	  return;
                  }
                  if(data.msg="exist"){
                	  alert("已报名！")
                	  window.location.href='training_arrangement-list.jsp?active=1&page='+page;
                	  return;
                  }
                  if(data.meg=="error"){
                	  alert("申请失败，请重新申请！");
                	  window.location.href='training_arrangement-list.jsp?active=1&page='+page;
                	  return;
                  }
                 },
                 error : function() { 
                             alert( "异常！"); 
				}
    });
}
function AddWorkAndReportFile(Id,page){
	location = "learn-arrange-work.jsp?Id="+Id+"&page="+page;
}
</script>
</head>
<% 
	String strposition = "团校培训管理>>培训项目报名>>";
	String strfunction = "学习项目列表";
	String strhelpwords = "展示学习项目的列表，点击项目名称上时可以显示相应项目说明。";
	
%>
<body>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="content-table">

	<tr>
		<th width="5%">序号</th>
		<th width="30%">学习项目</th>
		<th width="20%">时间安排</th>
		<th width="20%">负责人</th>
		<th width="15%">审核状态</th>
		<th>操作</th>
	</tr>
	<%
	Map<String,TrainingParticipate> map = new HashMap<String,TrainingParticipate> ();
	map = util.getTrainingParticipateMap(userInfo.getId());
	if (list.size()>0) {
		for (int i=0;i<list.size();i++) {
			TrainingArrangement v = new TrainingArrangement();
			v = (TrainingArrangement)list.get(i);%>
	<tr>
		<td><%=i+1 %></td>
		<td><a href="training_arrangement-detail.jsp?id=<%=v.getId()%>&page=<%=currpage %>"><%=v.getProjectName() %></a></td>
		<td><%=Tool.stringOfDate(v.getStartTime())%>~<%=Tool.stringOfDate(v.getEndTime())%></td>
		<td>
		<%-- <%
		if (v.getOtherUniversity()==0) {//校内%>
			<%=UserCnNameMap.get(v.getHostId()+"") %>
		<%}
		if (v.getOtherUniversity()==1) {//校外%>
			<%=v.getHostName() %>
		<%}%> --%>
		<%=v.getHostName() %>
		</td>
		<td>
		<%
		if (map.get(v.getId()+"")!=null) {
			TrainingParticipate item = new TrainingParticipate();
			item = map.get(v.getId()+"");%>
			<%=AuditMap.get(item.getAudit()) %>
		<%}
		%>
		</td>
		<td>
		<%
		if (v.getStartTime().getTime()<=new Date().getTime()&&v.getEndTime().getTime()>=new Date().getTime()) {
			if (map.get(v.getId()+"")!=null) {
				TrainingParticipate item = new TrainingParticipate();
				item = map.get(v.getId()+"");%>
				<%if (item.getAudit()==-1) {%>
				&nbsp;<a href="training_arrangement-detail.jsp?id=<%=v.getId()%>&page=<%=currpage %>">已报名</a>
				<%}%>
				<a href="javascript:;"	onclick="AddWorkAndReportFile(<%=item.getId()%>,<%=currpage %>)">
				<%
				if (item.getAudit()==0){%>
					&nbsp;可上传作业
				<%}
				if (item.getAudit()==2) {%>
					&nbsp;可上传结题报告
				<%}
				%>
				</a> 
			<%} else {%>
				<a href="javascript:;"	onclick="addApply(<%=v.getId()%>,<%=currpage %>)">申请参加</a> 
			<%}
		%>
		<%} else {%>
			已过期
		<%}
		%>
		</td>
	</tr>
		<%
		}
	}
	AuditMap.clear();
	%>

</table>
<%
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	%>
	<%=pagecontrol.getControl_win8_("training_arrangement-list.jsp",  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>

</body>
</html>