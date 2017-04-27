<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.db.TrainingParticipate"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
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
%>
<%!
private synchronized int save(TrainingParticipate v ,HttpServletRequest request,BaseUserCode user){
	int ProjectId = ParamUtils.getIntParameter(request,"ProjectId",-1);
	int Id = ParamUtils.getIntParameter(request,"Id",-1);
	String HomeWork = ParamUtils.getParameter(request,"HomeWork","");
	String CheckReport = ParamUtils.getParameter(request,"CheckReport","");

	int num = 0;
	List cdt = new ArrayList();
	List list = new ArrayList();
	cdt.add("ProjectId="+ProjectId);
	cdt.add("Sname="+user.getId());
	list = v.query(cdt);
	if (list.size()>0) {
		v = (TrainingParticipate)list.get(0);
	}
	v.setSno(user.getName());
	v.setSname(user.getId()+"");
	v.setProjectId(ProjectId);
	v.setHomeWork(HomeWork);
	v.setCheckReport(CheckReport);
	
	if (list.size()>0) {
		num = -2;
	} else {
		num = v.insert();
	}
	return num;
}
private synchronized int save(TrainingParticipate v ,HttpServletRequest request){
	int Id = ParamUtils.getIntParameter(request,"Id",-1);
	String HomeWork = ParamUtils.getParameter(request,"HomeWork","");
	String CheckReport = ParamUtils.getParameter(request,"CheckReport","");
	String AddFileList = ParamUtils.getParameter(request,"AddFileList","");
	String WorkFileList = ParamUtils.getParameter(request,"WorkFileList","");
	v= v.getById(Id);
	v.setHomeWork(HomeWork);
	v.setCheckReport(CheckReport);
	v.setAddFileList(AddFileList);
	v.setWorkFileList(WorkFileList);
	int num = v.update();
	return num;
}
%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","");
if ("addApply".equals(cmd)) {
	TrainingParticipate v = new TrainingParticipate();
	BaseUserCode user = userInfo.getUserCode();
	int num = save(v,request,user);
	if (num>0) {
		out.print("{\"msg\":\"ok\"}");
	} else if(num==-1){
		out.print("{\"msg\":\"exist\"}");
	} else {
		out.print("{\"msg\":\"no\"}");
	}
	return;
}
if ("uploadFile".equals(cmd)) {
	TrainingParticipate v = new TrainingParticipate();
	int num = save(v,request);
	if (num>0) {
		response.sendRedirect("training_arrangement-list.jsp");
	} 
	return;
}
%>