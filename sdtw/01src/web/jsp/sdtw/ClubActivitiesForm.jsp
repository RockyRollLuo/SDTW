<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团活动信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubActivities.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubActivities v = (ClubActivities)request.getAttribute("fromBean");
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
List Moduleoptions = (List)request.getAttribute("Moduleoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List ClubProjectNameoptions = (List)request.getAttribute("ClubProjectNameoptions");
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List ActivityLeveloptions = (List)request.getAttribute("ActivityLeveloptions");
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
				<div class="browsetitle001">社团活动信息</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团活动信息") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubActivitiesAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">活动主题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityName" id="ActivityName" size="45" maxsize="45" value="<%=v.getActivityName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">组织单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getOrgacadeMy(), "OrgacadeMy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, v.getClubName(), "ClubName", "")%>
                    													</td>
													  				</tr>
<input type="hidden" name="ClubId" value="<%=v.getClubId()%>">
                    												<tr>
                    													<td align="right" class="form_label">活动开始时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeStart" id="TimeStart" size="45" maxsize="45" value="<%=v.getTimeStart()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeEnd" id="TimeEnd" size="45" maxsize="45" value="<%=v.getTimeEnd()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动地点</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityPlace" id="ActivityPlace" size="45" maxsize="45" value="<%=v.getActivityPlace()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">组织者</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getOrganizer(), "Organizer", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">预计参加人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PredictNumber" id="PredictNumber" size="10" maxsize="10" value="<%=v.getPredictNumber()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请时是否有赞助</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="IsSupported" id="IsSupported" size="5" maxsize="5" value="<%=v.getIsSupported()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动具体内容及活动经费使用情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Contant" id="Contant" cols="40" rows="2"><%=v.getContant()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">第一负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Contacts" id="Contacts" size="45" maxsize="45" value="<%=v.getContacts()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">第一负责人电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ContactsPhone" id="ContactsPhone" size="45" maxsize="45" value="<%=v.getContactsPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动预告</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Forecast" id="Forecast" cols="40" rows="2"><%=v.getForecast()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导教师意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentTeacher" id="CommentTeacher" cols="40" rows="2"><%=v.getCommentTeacher()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导单位意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentAcademy" id="CommentAcademy" cols="40" rows="2"><%=v.getCommentAcademy()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团联合会意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentShelian" id="CommentShelian" cols="40" rows="2"><%=v.getCommentShelian()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Remark" id="Remark" cols="40" rows="2"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getAddPerson(), "AddPerson", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">修改人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getModiperson(), "Modiperson", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">修改时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动审批老师</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getCheckPerson(), "CheckPerson", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目id</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubProjectNameoptions, v.getProjectId(), "ProjectId", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectName" id="ProjectName" size="45" maxsize="45" value="<%=v.getProjectName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团创立(club)或团委立项(club-project)</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(Moduleoptions, v.getModule(), "Module", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否校内活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="IsatSchool" id="IsatSchool" size="5" maxsize="5" value="<%=v.getIsatSchool()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ApplyTime" id="ApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getApplyTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">立项0为社团创建</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="BelongId" id="BelongId" size="45" maxsize="45" value="<%=v.getBelongId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">预算清单</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="BudgetList" id="BudgetList" cols="40" rows="2"><%=v.getBudgetList()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所有预算</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="BudgetAmountAll" id="BudgetAmountAll" size="45" maxsize="45" value="<%=v.getBudgetAmountAll()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目结题：检查</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ConclusionCheckFlag" id="ConclusionCheckFlag" value="<%=v.getConclusionCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目结题：申请时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ConclusionApplyTime" id="ConclusionApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getConclusionApplyTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionCommentAcademy" id="ConclusionCommentAcademy" cols="40" rows="2"><%=v.getConclusionCommentAcademy()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团的审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionCommentShelian" id="ConclusionCommentShelian" cols="40" rows="2"><%=v.getConclusionCommentShelian()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目结题:活动概要</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionGeneral" id="ConclusionGeneral" cols="40" rows="2"><%=v.getConclusionGeneral()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目结题:稿件情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionManuscript" id="ConclusionManuscript" cols="40" rows="2"><%=v.getConclusionManuscript()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionCommentClub" id="ConclusionCommentClub" cols="40" rows="2"><%=v.getConclusionCommentClub()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionCommentcTuanwei" id="ConclusionCommentcTuanwei" cols="40" rows="2"><%=v.getConclusionCommentcTuanwei()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动前期策划和组织人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ConclusionPlanNums" id="ConclusionPlanNums" size="5" maxsize="5" value="<%=v.getConclusionPlanNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动前期策划和组织参与人员</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionPlanNames" id="ConclusionPlanNames" cols="40" rows="2"><%=v.getConclusionPlanNames()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动材料制作、宣传、表演人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ConclusionBroadcastNums" id="ConclusionBroadcastNums" size="5" maxsize="5" value="<%=v.getConclusionBroadcastNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动材料制作、宣传、表演人参与人员</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionBroadcastNames" id="ConclusionBroadcastNames" cols="40" rows="2"><%=v.getConclusionBroadcastNames()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动其他参与人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ConclusionelseNums" id="ConclusionelseNums" size="5" maxsize="5" value="<%=v.getConclusionelseNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动其他参与人员</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionelseNames" id="ConclusionelseNames" cols="40" rows="2"><%=v.getConclusionelseNames()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动总经费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ConclusionCost" id="ConclusionCost" size="20" maxsize="20" value="<%=v.getConclusionCost()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">结题时是否有赞助</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ConclusionIsSupport" id="ConclusionIsSupport" size="5" maxsize="5" value="<%=v.getConclusionIsSupport()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">赞助情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionSupportDetail" id="ConclusionSupportDetail" cols="40" rows="2"><%=v.getConclusionSupportDetail()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">结题总结</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionSummary" id="ConclusionSummary" cols="40" rows="2"><%=v.getConclusionSummary()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他必要说明人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ConclusionRemark" id="ConclusionRemark" cols="40" rows="2"><%=v.getConclusionRemark()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">立项等级l</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ActivityLeveloptions, v.getActivityLevel(), "ActivityLevel", "")%>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
