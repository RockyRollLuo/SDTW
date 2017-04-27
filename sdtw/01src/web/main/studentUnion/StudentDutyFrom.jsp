<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.studentUnion.StudentUnionUtil"%>
<%@page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--添加班委--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Classes.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	String academy = ParamUtils.getParameter(request,"_academy_","-1");
	if (userInfo.hasFunPower(Power.UserAdminPower)) {
		academy = userInfo.getDeptId()+"";
	}
	List cdt = new ArrayList();
	cdt.add("id="+academy);
	Academy a = new Academy();
	a = a.getById(Tool.StrToInt(academy));
	cdt.clear();
	cdt.add("academy="+academy);
	String nowschoolyear = CurrentSemester.getSchoolYear(new Date());
	//if ("insert".equals(cmd))
	//cdt.add("id not in(select classname from StudentClassDuty where schoolyear='"+nowschoolyear+"' && academy="+academy+")");
	StudentUnionUtil util = new StudentUnionUtil();
	List ClassesNameOptions = util.getClassesNameOptions(cdt);
	List StudentDutyOptions = util.getStudentDutyOptions();
	
	List YearOption = util.getYearOption(2016);
	String schoolyear = ParamUtils.getParameter(request,"_schoolyear_",nowschoolyear);
	String classname = ParamUtils.getParameter(request,"_classname_","-1");
	
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
		<script src="../../main/js/common.js"></script>
		<script>
			
			function init() {
				$("#classname").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到",search_contains: true});
			} 
			function tjbw() {//添加班委
				var Classname = $('#classname').val();
				if (Classname==""||Classname=="-1"){
					alert("请先选择班级！");
					$('#classname').focus();
					return;
				} else {
					addSponsor(Classname)
				}
				
			}
			function addSponsor(Classname){
				openWindow("BaseUserCodeAction.jsp?values="+$("#SId").val()+"&_Zhibu_="+Classname,"703,400");
			}
			function setRole(pName,pId){
				$("#SName").append(pName);
				$("#SId").val(pId);
			}
			function deleteSponsor(trid,id){
				$('#'+trid).remove();
				var files = document.postForm.SId.value;
				//alert(files+" "+id+" "+files.indexOf(id))
				if(files.indexOf(id)!=-1){
					//替换删掉的附件id
					files = ","+files+",";
					files = files.replace(","+id+",",',');
					//没有附件的情况
					if(files.indexOf(",")==files.lastIndexOf(","))
						files = "";
					else{
						files = files.substring(1,files.length-1);
					}
					document.postForm.SId.value = files;
				}
			}
		</script>
	</head>
	<body onload="init();">
		
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001"><%=a.getAcademyName() %> 班委</div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StudentDutyList.jsp?_academy_=<%=academy%>&_schoolyear_=<%=schoolyear %>&page=<%=currpage%>" >返回</a></li>
						<%
						if (userInfo.hasFunPower(Power.UserAdminPower)) {
						%>
						<li><a href="javascript:void(0);" onclick="document.postForm.submit();">保存</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="StudentDutyAction.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    												<td align="right" class="form_label">学年</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(YearOption, schoolyear, "schoolyear", "",true)%>
																		</td>
													  				
                    												<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff" >
														    			<%=a.getAcademyName()%>
														    			<input type="hidden" id="academy" name="academy" value="<%=academy	%>"/>
																		</td>
													  				
                    												<td align="right" class="form_label">班级名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													<%=HtmlTool.renderSelect(ClassesNameOptions, ""+classname , "classname", "-1")%>
                    													</td>
                    												</tr>
                    												<tr>
                    													<td align="right" class="form_label">
                    													
                    													<button onclick="tjbw()" type="button">添加班委</button>
                    													</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<table id="SName">
														    			<%List list = new ArrayList();
                    													String snos = "";
	                    												list = util.getStudentDutyList(academy,schoolyear,classname);
	                    												if (list.size()>0) {
	                    													List snoList = new ArrayList();
	                    													for (int i=0;i<list.size();i++) {
	                    														StudentClassDuty v = new StudentClassDuty();
	                    														v = (StudentClassDuty)list.get(i);
	                    														snoList.add(v.getSno());
	                    													}
	                    													if (snoList.size()>0) {
	                    														snos = Tool.join(",",snoList);
	                    													}
	                    													List cdt1 = new ArrayList();
	                    													cdt1.add("name in("+XtUtil.getIdsStr(snos)+")");
	                    													Map userMap = XtUtil.getBeanMapByCdt(cdt1,"Name",BaseUserCode.class);
	                    													Map sexMap = CEditConst.getsexMap(userInfo);
	                    													Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
	                    													%>
	                    													
	                    													<%
	                    													for (int i=0;i<list.size();i++) {
	                    														StudentClassDuty v = new StudentClassDuty();
	                    														v = (StudentClassDuty)list.get(i);
	                    														BaseUserCode user = new BaseUserCode();
	                    														if (userMap.get(v.getSno())!=null) {
	                    															user = (BaseUserCode)userMap.get(v.getSno());
	                    														}
	                    														%>
	                    														<tr id="deleteSponsor_<%=v.getSno()%>">
	                    														<td>学号：<%=v.getSno() %>&nbsp;&nbsp;&nbsp;<input id="Sno<%=v.getSno() %>" name="Sno<%=v.getSno() %>" value="<%=v.getSno()%>" type="hidden">
	                    														姓名：<%=user.getCnName() %>&nbsp;&nbsp;&nbsp;
	                    														性别：<%=sexMap.get(user.getGender()+"")==null?"":sexMap.get(user.getGender()+"") %>&nbsp;&nbsp;&nbsp;
	                    														学院：<%=a.getAcademyName() %>&nbsp;&nbsp;&nbsp;
	                    														年级：<%=GradeNameMap.get(user.getGrade())==null?"": GradeNameMap.get(user.getGrade())%>&nbsp;&nbsp;&nbsp;
	                    														职务：
	                    														<%=HtmlTool.renderSelect(StudentDutyOptions, ""+v.getDuty() , "Duty"+v.getSno(), "-1")%>
	                    														</td>
	                    														<td><img style="cursor:point;" src="../../main/images/delete.gif" onclick="javascript:deleteSponsor('deleteSponsor_<%=v.getSno() %>','<%=v.getSno() %>')" alt="删除" title="删除" border="0">
	                    														</td></tr>
	                    													<%}
	                    												}
	                    												%>
	                    												<input type="hidden" name="SId" id="SId" value="<%=snos%>"/>
														    			</table>
                    													</td>
                    												</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
