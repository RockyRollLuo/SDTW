<%@page import="com.xietong.software.base.SdtwConst"%>
<%@ page language="java" %>
<%--学生素质拓展培养认证单类型--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.xietong.software.base.Power"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
%>
<%!
private synchronized int save(StudentRzd v ,HttpServletRequest request){
	int Id=ParamUtils.getIntParameter(request, "Id", -1);
	if(v.getById(Id)!=null){
		v = v.getById(Id);
	}
//     v.setStuid(ParamUtils.getIntParameter(request, "Stuid", -1));
//     v.setDeptid(ParamUtils.getParameter(request, "Deptid", ""));
	UserInfo userInfo = Tool.getUserInfo(request);
	v.setStuid(userInfo.getId());
    v.setDeptid(userInfo.getDeptId()+"");
    
    v.setType(ParamUtils.getIntParameter(request, "Type", -1));
    v.setModifyflag(ParamUtils.getIntParameter(request, "Modifyflag",SdtwConst.RZDMODIFY_WTJ));
    v.setCheckreason(ParamUtils.getParameter(request, "Checkreason", ""));
    v.setCheckflag(ParamUtils.getIntParameter(request, "Checkflag", -1));
    v.setActivityId(ParamUtils.getIntParameter(request, "ActivityId", -1));
    v.setValue1(ParamUtils.getParameter(request, "Value1", ""));
    v.setValue2(ParamUtils.getParameter(request, "Value2", ""));
    v.setValue3(ParamUtils.getParameter(request, "Value3", ""));
    v.setValue4(ParamUtils.getParameter(request, "Value4", ""));
	int num = 0;
	if(v.getById(Id)==null){
		num = v.insert();
	}else{
		num = v.update();
	}
	return num;
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");

String cmd=ParamUtils.getParameter(request, "cmd", "");
int id=ParamUtils.getIntParameter(request, "id", -1);
//新增、修改
if("create".equals(cmd)||"update".equals(cmd)){
	StudentRzd rzd = new StudentRzd();
	int num = save(rzd,request);
	if(num>0)
		response.sendRedirect(HeadConst.apache_url+"/main/studentrzd/StudentRzdStudentList.jsp");
	return;
}
//提交
if("submit".equals(cmd)){
	StudentRzd rzd = new StudentRzd();
	List cdt=new ArrayList();
	cdt.add("id="+id);
	rzd.setModifyflag(SdtwConst.RZDMODIFY_YTJ);
	int num=rzd.updateByCondition(cdt);
	if(num>0) 
		out.print("{\"output\":\"\",\"msg\":\"提交成功\"}");
	return;
}
//删除
if("delete".equals(cmd)){
	StudentRzd rzd = new StudentRzd();
	int num=rzd.delete(id);
	if(num>0)
		out.print("{\"output\":\"\",\"msg\":\"删除成功\"}");
	return;
}
if("print".equals(cmd)){
	//
	String idlist=ParamUtils.getParameter(request, "idlist","");
	String printtime=ParamUtils.getParameter(request, "printtime","");
	String printcode=ParamUtils.getParameter(request, "printcode","");
	
	StudentRzdState srs=new StudentRzdState();
	srs.setStuid(userInfo.getId());
	srs.setPrintid(userInfo.getDeptId());//学院id
	srs.setIdlist(idlist);
	srs.setPrintTime(printtime);//可重新生成printtime,精确到秒
	srs.setPrintcode(printcode);
	int num=srs.insert();
	if(num>0)
		out.println("<script>window.opener=null;window.open('','_self');window.close();</script>");
	return;
	
}
if("deletestate".equals(cmd)){
	int stateid=ParamUtils.getIntParameter(request, "id", -1);
	StudentRzdState srs=new StudentRzdState();
	int num=srs.delete(stateid);
	if(num>0){
		out.print("{\"output\":\"\",\"msg\":\"删除成功\"}");
	}
	return;
}
%>
