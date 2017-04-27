<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--志愿活动--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(VolunteerActivity.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerActivity v = (VolunteerActivity)request.getAttribute("fromBean");
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
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List ActivityLeveloptions = (List)request.getAttribute("ActivityLeveloptions");
List ApplicationRangeTypeoptions = (List)request.getAttribute("ApplicationRangeTypeoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List ActivitykindTypeoptions = (List)request.getAttribute("ActivitykindTypeoptions");
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
				<div class="browsetitle001">志愿活动</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("志愿活动") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="VolunteerActivityAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">上传文件列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AddFilelist" id="AddFilelist" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Activityname" id="Activityname" size="45" maxsize="45" value="<%=v.getActivityname()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ActivitykindTypeoptions, v.getActivityKind(), "ActivityKind", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动级别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ActivityLeveloptions, v.getActivityLevel(), "ActivityLevel", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityPrincipal" id="ActivityPrincipal" size="45" maxsize="45" value="<%=v.getActivityPrincipal()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动地点</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityPlace" id="ActivityPlace" size="45" maxsize="45" value="<%=v.getActivityPlace()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动结束日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Endtime" id="Endtime" size="0" value="<%=Tool.stringOfDateTime(v.getEndtime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动开始日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Starttime" id="Starttime" size="0" value="<%=Tool.stringOfDateTime(v.getStarttime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">报名截止日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Deadline" id="Deadline" size="0" value="<%=Tool.stringOfDateTime(v.getDeadline())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所需人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PersonNumber" id="PersonNumber" value="<%=v.getPersonNumber()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Contact" id="Contact" size="45" maxsize="45" value="<%=v.getContact()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导教师</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getGuideTeacher(), "GuideTeacher", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">详细信息</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ActivityExplain" id="ActivityExplain" cols="40" rows="2"><%=v.getActivityExplain()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请范围分类</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ApplicationRangeTypeoptions, v.getApplicationRangeType(), "ApplicationRangeType", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请范围</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ApplicationRange" id="ApplicationRange" cols="40" rows="2"><%=v.getApplicationRange()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申办单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="LaunchAcademy" id="LaunchAcademy" size="45" maxsize="45" value="<%=v.getLaunchAcademy()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">荣誉列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="HonourList" id="HonourList" cols="40" rows="2"><%=v.getHonourList()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addtime" id="Addtime" size="0" value="<%=Tool.stringOfDateTime(v.getAddtime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddAccount" id="AddAccount" size="45" maxsize="45" value="<%=v.getAddAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">修改时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyTime" id="ModifyTime" size="0" value="<%=Tool.stringOfDateTime(v.getModifyTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">修改账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyAccount" id="ModifyAccount" size="45" maxsize="45" value="<%=v.getModifyAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckAccount" id="CheckAccount" size="45" maxsize="45" value="<%=v.getCheckAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所属学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">置顶标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Settop" id="Settop" value="<%=v.getSettop()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>