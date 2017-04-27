<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.db.CampusParticipate"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
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
private synchronized int save(CampusParticipate v ,HttpServletRequest request,BaseUserCode user){
	int id = ParamUtils.getIntParameter(request,"id",-1);
	int CampusActivityId = ParamUtils.getIntParameter(request,"CampusActivityId",-1);
	String StudentNo = user.getName();
	String StudentAcademy = user.getDeptId()+"";
	String StudentName = user.getId()+"";
	Date ApplyTime = new Date();
	if(id!=-1&&v.getById(id)!=null){
		v = v.getById(id);
	}
	v.setCampusActivityId(CampusActivityId+"");
	v.setStudentNo(StudentNo);
	v.setStudentAcademy(StudentAcademy);
	v.setApplyTime(ApplyTime);
	v.setStudentName(StudentName);
	v.setFinalRounds(0);
	v.setCheckFlag(-1);
	int num = 0;
	if(id!=-1&&v.getById(id)!=null){
		v = v.getById(id);
		num = -2;
	} else {
		num = v.insert();
	}
	return num;
}
%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","");
if("baomingForm".equals(cmd)){
	CampusParticipate cp  = new CampusParticipate();
	BaseUserCode user = new BaseUserCode();
	user = userInfo.getUserCode();
	int num = save(cp,request,user);
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
/* if("save".equals(cmd)){
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
} */
%>