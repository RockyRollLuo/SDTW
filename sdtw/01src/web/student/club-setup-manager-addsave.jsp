<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
private synchronized int save(ClubMembers v ,HttpServletRequest request){
	
	int Id = ParamUtils.getIntParameter(request, "Id", -1);
	String MemberClubname = ParamUtils.getParameter(request,"MemberClubname","-1");
	//String ClubId = ParamUtils.getParameter(request,"ClubId","-1");
	String MemberName = ParamUtils.getParameter(request,"MemberName","-1");//学生id（baseusercode表）
	String MemberSno = ParamUtils.getParameter(request,"MemberSno","");
	String MemberAcademy = ParamUtils.getParameter(request,"MemberAcademy","-1");
	String MemberSex = ParamUtils.getParameter(request,"MemberSex","-1");
	String Identity = ParamUtils.getParameter(request,"Identity","-1");
	String MemberPolitics = ParamUtils.getParameter(request,"MemberPolitics","-1");
	String MemberPhone = ParamUtils.getParameter(request,"MemberPhone","-1");
	String Memberqq = ParamUtils.getParameter(request,"Memberqq","-1");
	String Memberwx = ParamUtils.getParameter(request,"Memberwx","-1");
	String MProfile = ParamUtils.getParameter(request,"MProfile","-1");
	String MExperience= ParamUtils.getParameter(request,"MExperience","");
	String Remark = ParamUtils.getParameter(request,"Remark","");
	String MemberBrith = ParamUtils.getParameter(request,"MemberBrith","");
	String MemberBirthplace = ParamUtils.getParameter(request,"MemberBirthplace","");
	int MemberGrade = ParamUtils.getIntParameter(request,"MemberGrade",-1);
	int MemberMajor = ParamUtils.getIntParameter(request,"MemberMajor",-1);
	String MemberEmail = ParamUtils.getParameter(request,"MemberEmail","");
	int MemberDuty = ParamUtils.getIntParameter(request,"MemberDuty",-1);
	List cdt = new ArrayList();
	List list = new ArrayList();
	cdt.add("MemberClubname="+MemberClubname);
	cdt.add("MemberName="+MemberName);
	cdt.add("CheckFlag=1");
	list = v.query(cdt);
	if (list.size()>0) {
		v = v.getById(Id);
	}
	v.setMemberClubname(MemberClubname);
	v.setMemberName(MemberName);
	v.setMemberSno(MemberSno);
	v.setMemberAcademy(MemberAcademy);
	v.setMemberSex(MemberSex);
	v.setIdentity(Identity);
	v.setMemberPolitics(MemberPolitics);
	v.setMemberPhone(MemberPhone);
	v.setMemberqq(Memberqq);
	v.setMemberwx(Memberwx);
	v.setMProfile(MProfile);
	v.setRemark(Remark);
	v.setApplyTime(new Date());
	v.setCheckFlag(1);
	v.setIsManager("1");
	v.setMemberBrith(MemberBrith);
	v.setMemberBirthplace(MemberBirthplace);
	v.setMemberGrade(MemberGrade+"");
	v.setMemberMajor(MemberMajor+"");
	v.setMemberEmail(MemberEmail);
	v.setMemberDuty(MemberDuty+"");
	v.setMExperience(MExperience);
	v.setManagerGeneration(1);
	v.setIdentity("0");//本科
	int num = 0;
	if (list.size()<1) {
		UserInfo ui = Tool.getUserInfo(request);
		UserInfo userInfo =null;
		if(ui.hasFunPower(Power.USERSTUDENTPOWER)){
			userInfo = ui;
		}
		v.setAddPerson(ui.getId()+"");
		num = v.insert();
	}else{
		num = v.update();
	}
	return num;
}
%>
<%
String cmd = ParamUtils.getParameter(request,"cmd","");
if("saveOrUpdate".equals(cmd)){
	ClubMembers members = new ClubMembers();
	int num = save(members,request);
	if(num>0)
		response.sendRedirect(HeadConst.apache_url+"/student/club-setup-list.jsp");
		return;
}

%>