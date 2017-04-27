<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@page import="com.xietong.software.sdtw.studentUnion.StudentUnionUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%!
	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);
%>
<%
	log.debug("List");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "list");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	StudentUnionUtil util = new StudentUnionUtil();
	List YearOption = util.getYearOption(2016);
	String schoolyear = ParamUtils.getParameter(request,"_schoolyear_",CurrentSemester.getSchoolYear(new Date()));
	String classname = ParamUtils.getParameter(request,"_classname_","");
	String academy = ParamUtils.getParameter(request,"_academy_","-1");
	
	
	List cdt = new ArrayList();
	cdt.add("id="+academy);
	cdt.add("flag=1");
	List AcademyNameOptions = COptionConst.getAcademyNameOptions(userInfo,"",cdt);
	cdt.clear();
	cdt.add("academy="+academy);
	List ClassesNameOptions = util.getClassesNameOptions(cdt);
	%>
<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
<title> <%=request.getAttribute("describe")%> </title>
<script>
function add(page,cmd) {
	var schoolyear = $('#_schoolyear_').val();
	location = "StudentDutyFrom.jsp?page="+page+"&_academy_=<%=academy%>&_schoolyear_="+schoolyear+"&cmd="+cmd;
}
function init() {
	$("#_schoolyear_").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
	$("#_classname_").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
} 
function resetthis(id) {
	$('#'+id).val("");
	$("#"+id).trigger("chosen:updated");
}
function modifyClass(cmd,schoolyear,classname,academy,page) {
	var url= "StudentDutyFrom.jsp?cmd="+cmd+"&_academy_="+academy+"&_schoolyear_="+schoolyear+"&_classname_="+classname+"&page="+page;
	location = url;
}
function showmsg(id,title) {//学生id
	var url = "<%=HeadConst.apache_url%>/main/studentUnion/ShowStudentMsg.jsp?id="+id;
	parent.showDialog (url,500,267,title
            /* ,{ '确定': function(){
                 // parent.checkDate();
            }
  } */);

}
function submitthis() {
	$('#postForm').submit();
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body onload="init()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr> 
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
  									<tr>
    									<td height="26">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                               <tr>
                                   <td>
											            <div class="browsetitle title_css">
												             <div class="browsetitleleft">
													          <div class="browsetitle001">班级列表</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell("班级列表")%></div>
												          </div> 
												          <div class="browsetitleright" style="width: 200px;">
												              <div class="anniulist2">
													           <ul>
														           <%--  <li><a href="StandardupGradeAction.jsp?cmd=list&page=<%=currpage%>&sid=<%=sid %>" >返回</a></li> --%>
														           <%
														           if (userInfo.hasFunPower(Power.UserAdminPower)) {//学院用户
														           %>
														            <li><a href="javascript:add(<%=currpage%>,'insert');">增加</a></li>
														            <%}
														           if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHGZ)) {%>
														        	   <li><a href="AcademyList1.jsp" >返回</a></li> 
														           <%}
														           %>
														            
														            <li><a href="javascript:submitthis();">查询</a></li>
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr>    										</table>
										</td>
  									</tr>
    								<form action="StudentDutyList.jsp" name="query" id="postForm" method="post">
    								<input id="_academy_" name="_academy_" value="<%=academy%>" type="hidden"/>
  									<tr>
    									<table border=0 cellspacing=3 cellpadding=5 width="100%">
    									<tr>
    									<td><div align="right">学年</div></td>
										<td>
										<%=HtmlTool.renderSelect(YearOption, schoolyear, "_schoolyear_", "")%><a href="javascript:resetthis('_schoolyear_');">重置</a></td>
										<td><div align="right">班级</div></td>
										<td><%=HtmlTool.renderSelect(ClassesNameOptions, classname, "_classname_", "")%><a href="javascript:resetthis('_classname_');">重置</a></td>
    									</tr>
    									</table>
										</td>
									</tr>
									</form>
									<tr>
    									<td valign="top">
      										<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
        										<tr>
          											<td>
														<div id="list" class="browsetable">
														</div>
														
														<div id="list" class="browsetable">
														<table cellspacing="1" cellpadding="2" border="0"
															width="100%" align="center">
															<tbody>
																<tr>
																<td onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">编辑</div>
																	</td>
																<td onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">学年</div>
																	</td>
																	<td onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">班级</div>
																	</td>
																	<td onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">班长</div>
																	</td>
																	<td onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">团支书</div>
																	</td>
																	<td onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">其他班委</div>
																	</td>
																</tr>
																
																<%
																Map<String,List<StudentClassDuty>>map = new HashMap<String,List<StudentClassDuty>>();
																map = util.getStudentDutyMap(academy,schoolyear,classname);
																if (map.size()>0) {
																	String d = "odd";
																	int num = 0;
																 for (Iterator it = map.keySet().iterator();it.hasNext();) {
																	 if (num%2==0) {
																			d = "even";
																		}else{
																			d = "odd";
																		}
																	String key = (String)it.next();
																	List valList = map.get(key);
																	List snoList = new ArrayList();
																	List list0 = new ArrayList();
																	List list1 = new ArrayList();
																	List list2 = new ArrayList();
																	if (valList.size()>0) {
																		for (int i=0;i<valList.size();i++) {
																			StudentClassDuty v = new StudentClassDuty();
																			v = (StudentClassDuty)valList.get(i);
																			snoList.add(v.getSno());
																			%>
																		<%}
																		BaseUserCode user = new BaseUserCode();
																		Map<String,BaseUserCode>usermap = new HashMap<String,BaseUserCode>();
																		List cdt1 = new ArrayList();
																		List userlist = new ArrayList();
																		cdt1.add("name in("+XtUtil.getIdsStr(Tool.join(",",snoList))+")");
																		userlist = user.query(cdt1);
																		if (userlist.size()>0) {
																			for (int i=0;i<userlist.size();i++) {
																				user = (BaseUserCode)userlist.get(i);
																				usermap.put(user.getName(),user);
																			}
																		}
																		for (int i=0;i<valList.size();i++) {
																			StudentClassDuty v = new StudentClassDuty();
																			v = (StudentClassDuty)valList.get(i);
																			BaseUserCode u = new BaseUserCode();
																			u = usermap.get(v.getSno())==null?new BaseUserCode():usermap.get(v.getSno());
																			if ("0".equals(v.getDuty())) {//班长
																				list0.add("<a href='javascript:showmsg("+u.getId()+",\"班长信息\")'>"+u.getCnName()+"</a>");
																			}
																			if ("1".equals(v.getDuty())) {//团支书
																				list1.add("<a href='javascript:showmsg("+u.getId()+",\"团支书信息\")'>"+u.getCnName()+"</a>");
																			}
																			if ("2".equals(v.getDuty())) {//其他班委
																				list2.add("<a href='javascript:showmsg("+u.getId()+",\"其他班委信息\")'>"+u.getCnName()+"</a>");
																			}
																		}
																	}
																	%>
																<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"class="data_bgcolor_<%=d %>" style="cursor: pointer;">
																	<%String clas =  (String)(key.split("_")[0]);
																	String year =  (String)(key.split("_")[1]);%>
																	<td class="xxybgx2" onclick="javascript:modifyClass('modify','<%=year %>',<%=clas %>,<%=academy %>,<%=currpage%>)">&nbsp;</td>
																	<td class="browsetable005" align="center"><%=year %></td>
																	<td class="browsetable005" align="center">
																	<%=HtmlTool.renderSelect(ClassesNameOptions, clas , "classname", clas,true)%>
																	</td>
																	<td class="browsetable005" align="center"><%=Tool.join(",",list0) %></td>
																	<td class="browsetable005" align="center"><%=Tool.join(",",list1) %></td>
																	<td class="browsetable005" align="center"><%=Tool.join(",",list2) %></td>
																</tr>
																<%
																num++;
																 }
																} else {%>
																	<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"class="data_bgcolor_odd" style="cursor: pointer;">
																	<td class="browsetable005" align="center" colspan="7">没有记录!</td>
																</tr>
																<%}
																%>
																
															</tbody>
														</table>
													</div> 
													</td>
        										</tr>
      										</table>
			                			</td>
  									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
</body>
</html>