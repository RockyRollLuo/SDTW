<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团活动信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
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
List ActivityLeveloptions = (List)request.getAttribute("ActivityLeveloptions");
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
List YesNoOptions = CEditConst.getYesNoOptions(userInfo,"-1");
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);

List cdt = new ArrayList();
List list = new ArrayList();
Club club = new Club();
if(userInfo.hasFunPower(Power.STUSER))
cdt.add("ClubId='"+userInfo.getName()+"'");
else{
	cdt.add("id='"+v.getClubName()+"'");
}
list = club.query(cdt);
if(list.size()>0)
	club = (Club)list.get(0);


ClubUtil util = new ClubUtil();	
Map<String,Object>numMap = new HashMap<String,Object>();
numMap = util.getClubmimbers(club.getId());	
List allList = new ArrayList();
allList = (List)numMap.get("All_");
List cdt1 = new ArrayList();
cdt1.add("id in("+Tool.join(",",allList)+")");
List UserNameoptions = COptionConst.getUserCnNameOptions(userInfo,"-1",cdt1); 
numMap.clear();

String type="text";
String ClubId = "";
String ActivityName= "";
String ContactsPhone = "";
String ActivityPlace = "";
String TimeStart = "";
String TimeEnd = "";
String PredictNumber = "";
String Contant = "";
String Forecast = "";
String CommentTeacher = "";
String Remark = "";
String dis = "";
if(!userInfo.hasFunPower(Power.STUSER)){
	type = "hidden";
	dis = "display:none;";
	ClubId = club.getClubId();
	ActivityName = v.getActivityName();
	ContactsPhone = v.getContactsPhone();
	ActivityPlace = v.getActivityPlace();
	TimeStart = v.getTimeStart()+"~";
	TimeEnd = v.getTimeEnd();
	PredictNumber = v.getPredictNumber();
	Contant = v.getContant();
	Forecast = v.getForecast();
	CommentTeacher = v.getCommentTeacher();
	Remark = v.getRemark();
}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<script language="JavaScript" src="../../main/js/ajaxfileupload.js"></script>
		<script language="JavaScript" src="js/upload.js"></script>
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
			function submitthis(flag){
				var IsatSchool = $('#IsatSchool').val();
				if (IsatSchool=="0") {
					var BelongId = $('#BelongId').val();
					if (BelongId=="") {
						alert("请上传附件");
						return;
					}
				} else {
					$('#BelongId').val("");
				}
				$('#CheckFlag').val(flag);
				document.postForm.submit();
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团活动信息</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团活动信息") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubActivitiesAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%
						if(userInfo.hasFunPower(Power.STUSER)){//社团用户
							if(v.getCheckFlag()==-1||SdtwConst.CHECKFLAG_XYWTG.equals(v.getCheckFlag()+"")){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ submitthis(<%=SdtwConst.CHECKFLAG_SB%>);}">提交</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis(-1);}">保存</a></li>
						<%
							}
						}
						if(userInfo.hasFunPower(Power.UserAdminPower)){//指导单位用户
							if(SdtwConst.CHECKFLAG_SB.equals(v.getCheckFlag()+"")){
						%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('update_activities'); $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XYWTG%>);}">审核未通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('update_activities'); $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XYTG%>);}">审核通过</a></li>
						<%}
						}
						%>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
		<div id="tabs">
			<ul>
					<li><a href="#tabs-1">基本信息</a></li>
					<%
					if(userInfo.hasFunPower(Power.STUSER)){
						//社团用户
						if(v.getCheckFlag()!=-1){
					%>
					<li><a href="#tabs-2">指导单位意见</a></li>
					<%}
					}%>
					<%
					if(userInfo.hasFunPower(Power.UserAdminPower)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){%>
						<li><a href="#tabs-2">指导单位意见</a></li>
					<%}
					%>
					<%if(v.getCheckFlag()==1){%>
							<li><a href="#tabs-3">审核活动参加人员</a></li>
					<%}%>
			</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" id="cmd" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden"name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
				<input type="hidden"id="AddPerson" name="AddPerson" value="<%=v.getAddPerson().equals("")?userInfo.getId()+"":v.getAddPerson()%>"/>
				<input type="hidden"name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
				<input type="hidden"id="Modiperson" name="Modiperson" value="<%=v.getModiperson()%>"/>
				<input type="hidden"name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
				<input type="hidden"id="CheckPerson" name="CheckPerson" value="<%=v.getCheckPerson()%>"/>
				<input type="hidden"id="ProjectId" name="ProjectId" value="<%=v.getProjectId()%>"/>
				<input type="hidden"id="ProjectName" name="ProjectName" value="<%=v.getProjectName()%>"/>
				<input type="hidden"id="Module" name="Module" value="<%=v.getModule().equals("")?"club":v.getModule()%>"/>
				<input type="hidden"name="ApplyTime" id="ApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getApplyTime())%>">
				<input type="hidden"name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
				<input type="hidden"id="BudgetList" name="BudgetList" value="<%=v.getBudgetList()%>"/>
				<input type="hidden"name="BudgetAmountAll" id="BudgetAmountAll" size="45" maxsize="45" value="<%=v.getBudgetAmountAll()%>">
				<input type="hidden"name="ConclusionCheckFlag" id="ConclusionCheckFlag" value="<%=v.getConclusionCheckFlag()%>">
				<input type="hidden"name="ConclusionApplyTime" id="ConclusionApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getConclusionApplyTime())%>">
				<input type="hidden"id="ConclusionCommentAcademy" name="ConclusionCommentAcademy" value="<%=v.getConclusionCommentAcademy()%>"/>
				<input type="hidden"id="ConclusionCommentShelian" name="ConclusionCommentShelian" value="<%=v.getConclusionCommentShelian()%>"/>
				<input type="hidden"id="ConclusionPlanNums" name="ConclusionPlanNums" value="<%=v.getConclusionPlanNums()%>"/>
				<input type="hidden"id="ConclusionPlanNames" name="ConclusionPlanNames" value="<%=v.getConclusionPlanNames()%>"/>
				<input type="hidden"id="ConclusionBroadcastNums" name="ConclusionBroadcastNums" value="<%=v.getConclusionBroadcastNums()%>"/>
				<input type="hidden"id="ConclusionBroadcastNames" name="ConclusionBroadcastNames" value="<%=v.getConclusionBroadcastNames()%>"/>
				<input type="hidden"id="ConclusionelseNums" name="ConclusionelseNums" value="<%=v.getConclusionelseNums()%>"/>
				<input type="hidden"id="ConclusionelseNames" name="ConclusionelseNames" value="<%=v.getConclusionelseNames()%>"/>
				<input type="hidden"id="ConclusionCost" name="ConclusionCost" value="<%=v.getConclusionCost()%>"/>
				<input type="hidden"id="ConclusionIsSupport" name="ConclusionIsSupport" value="<%=v.getConclusionIsSupport()%>"/>
				<input type="hidden"id="ConclusionSupportDetail" name="ConclusionSupportDetail" value="<%=v.getConclusionSupportDetail()%>"/>
				<input type="hidden"id="ConclusionSummary" name="ConclusionSummary" value="<%=v.getConclusionSummary()%>"/>
				<input type="hidden"id="ConclusionRemark" name="ConclusionRemark" value="<%=v.getConclusionRemark()%>"/>
				<input type="hidden"id="ActivityLevel" name="ActivityLevel" value="<%=v.getActivityLevel()%>"/>
				<input type="hidden" id="CommentShelian" name="CommentShelian" value="<%=v.getCommentShelian()%>"/>
				<input type="hidden" id="ConclusionGeneral" name="ConclusionGeneral" value="<%=v.getConclusionGeneral()%>"/>
				<input type="hidden" id="ConclusionManuscript" name="ConclusionManuscript" value="<%=v.getConclusionManuscript()%>"/>
				<input type="hidden" id='ConclusionCommentClub' name='ConclusionCommentClub' value="<%=v.getConclusionCommentClub()%>"/>
				<input type="hidden" id='ConclusionCommentcTuanwei' name="ConclusionCommentcTuanwei" value="<%=v.getConclusionCommentcTuanwei()%>"/>
				<input type="hidden" id="ProjectId" name="ProjectId"  value="<%=v.getId()%>"/>
				<input type="hidden" id="Module" name="Module"  value="club-project"/>
				
				<%=Tool.join("\n", forms)%>
                    											<div id="tabs-1" style="border: 0px;">
                    											<table width="100%" style="background-color: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, v.getClubName(), "ClubName", ""+club.getId(),true)%>
                    													</td>
													  				
                    													<td align="right" class="form_label">社团编码</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=ClubId %>
													  				<input type="<%=type%>" readonly="readonly" style="width: 100%;" id="ClubId" name="ClubId" value="<%=club.getClubId()%>">
                    													</td>
                    													<td align="right" class="form_label">组织单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getOrgacadeMy(), "OrgacadeMy", ""+club.getAcademy(),true)%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动主题</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=ActivityName %>
                    														<input type="<%=type%>" style="width: 100%;" name="ActivityName" id="ActivityName"  maxsize="45" value="<%=v.getActivityName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">组织者</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
																		<%=HtmlTool.renderSelect(UserNameoptions, v.getOrganizer(), "Organizer", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(UserNameoptions, v.getOrganizer(), "Organizer", "")%>
														    			<%} %>
                    													</td>													  				
                    													<td align="right" class="form_label">第一负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
														    			<%=HtmlTool.renderSelect(UserNameoptions, v.getContacts(), "Contacts", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(UserNameoptions, v.getContacts(), "Contacts", "")%>
														    			<%} %>
                    													</td>
													  				
                    													<td align="right" class="form_label">第一负责人电话</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=ContactsPhone %>
                    														<input type="<%=type%>" style="width: 100%;" name="ContactsPhone" id="ContactsPhone"  maxsize="45" value="<%=v.getContactsPhone()%>">
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">活动地点</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=ActivityPlace %>
                    														<input type="<%=type%>" style="width: 100%;" name="ActivityPlace" id="ActivityPlace" maxsize="45" value="<%=v.getActivityPlace()%>">
                    													</td>
                    													<td align="right" class="form_label">活动开始时间</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%=TimeStart %>  <%=TimeEnd %>
														    			<input type="<%=type%>" class="date" name="TimeStart" id="TimeStart" onfocus="WdatePicker({el:'TimeStart',dateFmt:'yyyy-MM-dd'})"  size="0" value="<%=Tool.stringOfDate(Tool.stringToDate(v.getTimeStart()))%>"/>
														    			<input type="<%=type%>" class="date" name="TimeEnd" id="TimeEnd" onfocus="WdatePicker({el:'TimeEnd',dateFmt:'yyyy-MM-dd'})"  size="0" value="<%=Tool.stringOfDate(Tool.stringToDate(v.getTimeEnd()))%>"/>
                    													</td>
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">预计参加人数</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=PredictNumber %>
                    														<input type="<%=type%>" style="width: 100%;" name="PredictNumber" id="PredictNumber"  maxsize="10" value="<%=v.getPredictNumber()%>">
                    													</td>
													  				<td align="right" class="form_label">是否校内活动</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
														    			<%=HtmlTool.renderSelect(YesNoOptions, v.getIsatSchool(), "IsatSchool", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(YesNoOptions, v.getIsatSchool(), "IsatSchool", "","onchange='checkClientAttach()'")%>
														    			<%} %>
                    													</td>
													  				
                    													<td align="right" class="form_label">是否有赞助</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
														    			<%=HtmlTool.renderSelect(YesNoOptions, v.getIsatSchool(), "IsSupported", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(YesNoOptions, v.getIsatSchool(), "IsSupported", "")%>
														    			<%} %>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动具体内容及活动经费使用情况</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=Contant %>
                    														<textarea style="width: 100%;<%=dis %>" name="Contant" id="Contant" cols="40" rows="2"><%=v.getContant()%></textarea>
                    													</td>
													  				</tr>
                    												
                    												<tr>
                    													<td align="right" class="form_label">活动预告</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=Forecast %>
                    														<textarea style="width: 100%;<%=dis %>" name="Forecast" id="Forecast" cols="40" rows="2"><%=v.getForecast()%></textarea>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">指导教师意见</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=CommentTeacher %>
                    														<textarea style="width: 100%;<%=dis %>" name="CommentTeacher" id="CommentTeacher" cols="40" rows="2"><%=v.getCommentTeacher()%></textarea>
                    													</td>
													  				</tr>
													  				<input type="hidden" id="BelongId" name="BelongId" value="<%=v.getBelongId()%>"/>
													  				<%
																	//if (v.getId()!=-1&&"0".equals(v.getIsatSchool())){%>
													  				<tr id="ClientAttach">
													  				<td align="right" class="form_label">附件</td>
													  				<td bgcolor="#ffffff" colspan="5" align="left">
																	<table width="100%" border="0" cellspacing="0" id="ShowFiles">
																				<%
																				int caid = -1;
																				if (!"".equals(v.getBelongId().trim())) {
																					String caids[] = v.getBelongId().split(",");
																					for(int i=0;i<caids.length;i++){
																						caid = Tool.StrToInt(caids[i]);
																						ClientAttach ca = new ClientAttach();
																						//社团校外活动会长（带队队长）承诺书
																						if (caid!=-1&&ca.getById(caid)!=null) {
																							ca = ca.getById(caid);
																				%>
																			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
																				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
																				<%
																				if(v.getCheckFlag()!=1){%>
																				<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
																				<%} %>
																				</tr>
																					<%}
																					}
																				}
																				%>
																	</table>
																	<%
																	//if(v.getCheckFlag()!=1){%>
																	<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
																	<input type="button" value="上传" id="btn_up"  onclick="checkFileType(3,'clubactivities');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
																	<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
																	<%//}
																	%>
																    <div style="color:red">说明：请上传【社团校外活动会长（带队队长）承诺书】和【社团校外活动校外活动安全指导书】<br/>格式为:doc、docx格式文件，文件最大5M</div>
																</td>
													  				</tr>
													  				<%//} %>
													  				<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=Remark %>
                    														<textarea style="width: 100%;<%=dis %>" name="Remark" id="Remark" cols="40" rows="2"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
													  				<div id="tabs-2" style="border: 0px;">
													  				<table width="100%" style="background-color: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
													  				<%
													  				if(userInfo.hasFunPower(Power.STUSER))//社团用户
		                    											if(v.getCheckFlag()!=-1){
													  				%>
                    												<tr>
                    													<td align="right" class="form_label">指导单位意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea style="width: 100%;" name="CommentAcademy" id="CommentAcademy" cols="40" rows="5"><%=v.getCommentAcademy()%></textarea>
                    													</td>
													  				</tr>
													  				<%} %>
													  					<%
													  				if(userInfo.hasFunPower(Power.UserAdminPower)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST))
													  				{//指导单位  团委
													  				%>
                    												<tr>
                    													<td align="right" class="form_label">指导单位意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea style="width: 100%;" name="CommentAcademy" id="CommentAcademy" cols="40" rows="5"><%=v.getCommentAcademy()%></textarea>
                    													</td>
													  				</tr>
													  				<%}else{%>
													  					<input id="CommentAcademy"name="CommentAcademy" value="<%=v.getCommentAcademy()%>" type="hidden"/>
													  				<%} %>
													  				</table>
													  				</div>
													  				<%
													  				if(v.getCheckFlag()==1){%>
													  					<div id="tabs-3" style="border: 0px;">
															  						<iframe class="commentFrame" name="commentFrame1" id="commentFrame1" src="ClubActivityParticipateAction.jsp?_Activityid_=<%=v.getId() %>" frameborder='0' marginheight="0" marginwidth="0"  width="100%" scrolling="auto" style="min-height: 200px;" ></iframe>
															  			</div>
													  				<%}
													  				%>
													  				
			</form>
			</div>
		</div>
		<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', 0); 
	});
	</script>
	</body>
</html>
