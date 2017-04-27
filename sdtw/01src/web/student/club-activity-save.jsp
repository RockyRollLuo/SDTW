<%@page import="com.xietong.software.sdtw.db.ClubActivities"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivityParticipate"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
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
}%>
<%!
private synchronized int save(ClubActivityParticipate v ,HttpServletRequest request,BaseUserCode user){
	int clubname = ParamUtils.getIntParameter(request,"clubname",-1);
	int activityid = ParamUtils.getIntParameter(request,"activityid",-1);
	String sno = user.getName();
	String sname = user.getId()+"";
	Date applytime = new Date();
	
	List cdt = new ArrayList();
	List list = new ArrayList();
	
	cdt.add("clubname="+clubname);
	cdt.add("activityid="+activityid);
	cdt.add("MemberName="+user.getId());
	if(v.getCount(cdt)>0){
		return -2;
	}
	ClubActivities app = new ClubActivities();
	if(activityid!=-1&&app.getById(activityid)!=null){
		v.setActivityname(app.getActivityName());
	}
	v.setClubname(clubname+"");
	v.setActivityid(activityid+"");
	v.setSno(sno);
	v.setSname(sname);
	v.setApplytime(applytime);
	int num = v.insert();
	return num;
}
private synchronized int save(ClubActivityParticipate v ,HttpServletRequest request){
	String clubid = ParamUtils.getParameter(request,"clubid","");
	String clubname = ParamUtils.getParameter(request,"clubname","");
	int activityid = ParamUtils.getIntParameter(request,"activityid",-1);
	String activityname = ParamUtils.getParameter(request,"activityname","");
	String sno = ParamUtils.getParameter(request,"sno","");
	String sname = ParamUtils.getParameter(request,"sname","");
	Date applytime = new Date();
	String traffictool = ParamUtils.getParameter(request,"traffictool","");
	String activityprocedure = ParamUtils.getParameter(request,"activityprocedure","");
	String activitysecurity = ParamUtils.getParameter(request,"activitysecurity","");
	int istell = ParamUtils.getIntParameter(request,"istell",-1);
	int isbuy = ParamUtils.getIntParameter(request,"isbuy",-1);
	int tellway = ParamUtils.getIntParameter(request,"tellway",-1);
	int iswilling = ParamUtils.getIntParameter(request,"iswilling",-1);
	int isvoluntary = ParamUtils.getIntParameter(request,"isvoluntary",-1);
	int isresponsible = ParamUtils.getIntParameter(request,"isresponsible",-1);
	Date safetime = new Date();
	v.setClubid(clubid);
	v.setClubname(clubname);
	v.setActivityid(activityid+"");
	v.setActivityname(activityname);
	v.setSno(sno);
	v.setSname(sname);
	v.setApplytime(applytime);
	v.setTraffictool(traffictool);
	v.setActivityprocedure(activityprocedure);
	v.setActivitysecurity(activitysecurity);
	v.setIstell(istell+"");
	v.setIsbuy(isbuy+"");
	v.setTellway(tellway+"");
	v.setIswilling(iswilling+"");
	v.setIsvoluntary(isvoluntary+"");
	v.setIsresponsible(isresponsible+"");
	v.setSafetime(safetime);
	int num = v.insert();
	return num;
}
%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","");
if("addApply".equals(cmd)){
	ClubActivityParticipate cap = new ClubActivityParticipate();
	BaseUserCode user = new BaseUserCode();
	user = userInfo.getUserCode();
	int num = save(cap,request,user);
	if(num==-2){//已存在
		out.print("{\"msg\":\"exist\"}");
	}else{
		if(num>0){
			out.print("{\"msg\":\"ok\"}");
		}else{
			out.print("{\"msg\":\"error\"}");
		}
	}
	return;
}
if("save".equals(cmd)){
	int id = ParamUtils.getIntParameter(request,"id",-1);
	if(id!=-1){
		out.println("<script>alert('请勿重复提交!');location.href='club-activity-mylist.jsp';</script>");
	}else{
		ClubActivityParticipate v = new ClubActivityParticipate();
		int num = save(v,request);
		if(num>0){
			response.sendRedirect(HeadConst.apache_url+"/student/club-activity-mylist.jsp");
			return;
		}
	}
}
%>