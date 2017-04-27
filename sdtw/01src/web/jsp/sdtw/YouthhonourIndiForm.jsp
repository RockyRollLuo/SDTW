<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--五四评比表彰个人申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(YouthhonourIndi.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	YouthhonourIndi v = (YouthhonourIndi)request.getAttribute("fromBean");
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
List PoliticsNameoptions = (List)request.getAttribute("PoliticsNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List GradeNameoptions = (List)request.getAttribute("GradeNameoptions");
List Identityoptions = (List)request.getAttribute("Identityoptions");
List sexoptions = (List)request.getAttribute("sexoptions");
List NationNameoptions = (List)request.getAttribute("NationNameoptions");
List MajorNameoptions = (List)request.getAttribute("MajorNameoptions");
List ClubTypeNameoptions = (List)request.getAttribute("ClubTypeNameoptions");
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
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
				<div class="browsetitle001">五四评比表彰个人申请表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("五四评比表彰个人申请表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="YouthhonourIndiAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">学年</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SchoolYear" id="SchoolYear" size="45" maxsize="45" value="<%=v.getSchoolYear()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请表类型</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Type" id="Type" value="<%=v.getType()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddAccount" id="AddAccount" size="45" maxsize="45" value="<%=v.getAddAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院审核标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyCheckFlag" id="XyCheckFlag" value="<%=v.getXyCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委审核标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TwCheckFlag" id="TwCheckFlag" value="<%=v.getTwCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否可修改标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyFlag" id="ModifyFlag" value="<%=v.getModifyFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院提交标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyReport" id="XyReport" value="<%=v.getXyReport()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委发布标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TwReport" id="TwReport" value="<%=v.getTwReport()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyCheckDate" id="XyCheckDate" size="0" value="<%=Tool.stringOfDateTime(v.getXyCheckDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TwCheckDate" id="TwCheckDate" size="0" value="<%=Tool.stringOfDateTime(v.getTwCheckDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所属单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getBelongAcademy(), "BelongAcademy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Sno" id="Sno" size="45" maxsize="45" value="<%=v.getSno()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Name" id="Name" size="45" maxsize="45" value="<%=v.getName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">年级</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(GradeNameoptions, v.getGrade(), "Grade", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">专业</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(MajorNameoptions, v.getMajor(), "Major", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, v.getSex(), "Sex", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">民族</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(NationNameoptions, v.getNation(), "Nation", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">籍贯</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SNative" id="SNative" size="45" maxsize="45" value="<%=v.getSNative()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">照片</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Photo" id="Photo" size="45" maxsize="45" value="<%=v.getPhoto()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">出生年月</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Birthday" id="Birthday" size="45" maxsize="45" value="<%=v.getBirthday()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getPolistatu(), "Polistatu", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">联系电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Phone" id="Phone" size="45" maxsize="45" value="<%=v.getPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">支部</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Zhibu" id="Zhibu" size="45" maxsize="45" value="<%=v.getZhibu()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Duty" id="Duty" size="45" maxsize="45" value="<%=v.getDuty()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所在组织（志愿）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="WorkUnit" id="WorkUnit" size="45" maxsize="45" value="<%=v.getWorkUnit()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">何时起参加支援服务（志愿</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="VolstaTime" id="VolstaTime" size="45" maxsize="45" value="<%=v.getVolstaTime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">总时长（志愿、社团</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="VolservTime" id="VolservTime" size="45" maxsize="45" value="<%=v.getVolservTime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团名称（社团）</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, v.getClubName(), "ClubName", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所在社团属于（社团）</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubTypeNameoptions, v.getClubType(), "ClubType", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">参加校级社团活动情况（社团）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="JoinClubInfo1" id="JoinClubInfo1" size="45" maxsize="45" value="<%=v.getJoinClubInfo1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">参加院级社团活动情况（社团）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="JoinClubInfo2" id="JoinClubInfo2" size="45" maxsize="45" value="<%=v.getJoinClubInfo2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团简介（社团）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ClubInfo" id="ClubInfo" cols="40" rows="2"><%=v.getClubInfo()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">教育程度</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(Identityoptions, v.getEducation(), "Education", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">工作经历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="WorkExp" id="WorkExp" cols="40" rows="2"><%=v.getWorkExp()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">个人简历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Resume" id="Resume" cols="40" rows="2"><%=v.getResume()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">获奖情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Award" id="Award" cols="40" rows="2"><%=v.getAward()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
