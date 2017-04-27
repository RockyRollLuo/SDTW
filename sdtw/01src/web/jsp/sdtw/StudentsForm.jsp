<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Students.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Students v = (Students)request.getAttribute("fromBean");
	if (v == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	forms.addAll((List)paras.get(3));
	String url = Tool.join("&", urls);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List PoliticsNameoptions = (List)request.getAttribute("PoliticsNameoptions");
List GradeNameoptions = (List)request.getAttribute("GradeNameoptions");
List LenOfSchooloptions = (List)request.getAttribute("LenOfSchooloptions");
List NationNameoptions = (List)request.getAttribute("NationNameoptions");
List MajorNameoptions = (List)request.getAttribute("MajorNameoptions");
List ClassesNameoptions = (List)request.getAttribute("ClassesNameoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
			}
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">学生表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("学生表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StudentsAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Sno" id="Sno" size="45" maxsize="45" value="<%=v.getSno()%>">
<font color=red>*</font>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SName" id="SName" size="50" maxsize="50" value="<%=v.getSName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SSex" id="SSex" size="2" maxsize="2" value="<%=v.getSSex()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getSacademy(), "Sacademy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">入校时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeToSchool" id="TimeToSchool" size="0" value="<%=Tool.stringOfDateTime(v.getTimeToSchool())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">入团时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeToTuan" id="TimeToTuan" size="0" value="<%=Tool.stringOfDateTime(v.getTimeToTuan())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">生日</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Birthday" id="Birthday" size="0" value="<%=Tool.stringOfDateTime(v.getBirthday())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">支部</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClassesNameoptions, v.getZhiBu(), "ZhiBu", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">民族</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(NationNameoptions, v.getNation(), "Nation", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">专业</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(MajorNameoptions, v.getMajor(), "Major", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学制</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(LenOfSchooloptions, v.getLenOfSchool(), "LenOfSchool", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">年级</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(GradeNameoptions, v.getGrade(), "Grade", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getPolista(), "Polista", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">籍贯</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="NativePlace" id="NativePlace" size="50" maxsize="50" value="<%=v.getNativePlace()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">身份证号码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="IDNum" id="IDNum" size="50" maxsize="50" value="<%=v.getIDNum()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Phone" id="Phone" size="50" maxsize="50" value="<%=v.getPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email" id="Email" size="50" maxsize="50" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">附件</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addfilelist" id="Addfilelist" size="50" maxsize="50" value="<%=v.getAddfilelist()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学年</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="YearToSchool" id="YearToSchool" cols="40" rows="2"><%=v.getYearToSchool()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">毕业时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GraduateTime" id="GraduateTime" size="0" value="<%=Tool.stringOfDateTime(v.getGraduateTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否青年志愿者</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, v.getVolunteerfFag(), "VolunteerfFag", "")%>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
