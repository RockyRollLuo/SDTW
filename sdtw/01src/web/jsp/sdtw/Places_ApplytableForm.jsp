<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--团委场地申请--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Places_Applytable.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Places_Applytable v = (Places_Applytable)request.getAttribute("fromBean");
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
List YesNooptions = (List)request.getAttribute("YesNooptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List ClassesNameoptions = (List)request.getAttribute("ClassesNameoptions");
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
				<div class="browsetitle001">团委场地申请</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("团委场地申请") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="Places_ApplytableAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">用户账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UserAccount" id="UserAccount" size="45" maxsize="45" value="<%=v.getUserAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">场地代码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PlaceApplycode" id="PlaceApplycode" size="45" maxsize="45" value="<%=v.getPlaceApplycode()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="ApplyDate" value="<%=v.getApplyDate()%>">
                    												<tr>
                    													<td align="right" class="form_label">申请时间段</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ApplyTimeRange" id="ApplyTimeRange" size="45" maxsize="45" value="<%=v.getApplyTimeRange()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Applicant" id="Applicant" size="45" maxsize="45" value="<%=v.getApplicant()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getActivityPrincipal(), "ActivityPrincipal", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动负责人职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PrincipalDuty" id="PrincipalDuty" size="45" maxsize="45" value="<%=v.getPrincipalDuty()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动负责人联系电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PrincipalPhone" id="PrincipalPhone" size="45" maxsize="45" value="<%=v.getPrincipalPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityTime" id="ActivityTime" size="0" value="<%=Tool.stringOfDateTime(v.getActivityTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">布场时段</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DistributionPeriod" id="DistributionPeriod" size="45" maxsize="45" value="<%=v.getDistributionPeriod()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">彩排时段</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="RehearsalPeriod" id="RehearsalPeriod" size="45" maxsize="45" value="<%=v.getRehearsalPeriod()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityContents" id="ActivityContents" size="45" maxsize="45" value="<%=v.getActivityContents()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">主讲人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getSpeaker(), "Speaker", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">基本程序简介</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="BasicProcedures" id="BasicProcedures" size="45" maxsize="45" value="<%=v.getBasicProcedures()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">会标内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MeetingMarks" id="MeetingMarks" size="45" maxsize="45" value="<%=v.getMeetingMarks()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">背景内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="BackgroundContents" id="BackgroundContents" size="45" maxsize="45" value="<%=v.getBackgroundContents()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">商业赞助</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Aponsorship" id="Aponsorship" size="45" maxsize="45" value="<%=v.getAponsorship()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">宣传形式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Propaganda" id="Propaganda" size="45" maxsize="45" value="<%=v.getPropaganda()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">会场内其他宣传形式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OtherPropaganda" id="OtherPropaganda" size="45" maxsize="45" value="<%=v.getOtherPropaganda()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">桌子数量</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TableNums" id="TableNums" value="<%=v.getTableNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">椅子数量</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ChairNums" id="ChairNums" value="<%=v.getChairNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">有线话筒</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getWiredmicroPhoneNums(), "WiredmicroPhoneNums", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">无线话筒</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getWirelessmicroPhoneNums(), "WirelessmicroPhoneNums", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">话筒电池</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getBatteryNums(), "BatteryNums", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用发言台</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseFloor(), "UseFloor", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用音响设备</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseAudio(), "UseAudio", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用照明灯光</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseLighting(), "UseLighting", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用舞台灯光</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseStageLight(), "UseStageLight", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用电脑灯</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseComputerLight(), "UseComputerLight", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用投影仪</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseProjector(), "UseProjector", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">使用空调</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseAc(), "UseAc", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">悬挂横幅</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseBanner(), "UseBanner", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">横幅内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="BannerContent" id="BannerContent" size="45" maxsize="45" value="<%=v.getBannerContent()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">张贴海报或展板</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UsePoster" id="UsePoster" size="45" maxsize="45" value="<%=v.getUsePoster()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">海报内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PosterContent" id="PosterContent" size="45" maxsize="45" value="<%=v.getPosterContent()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">参加人员车辆数量</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="VehicleNums" id="VehicleNums" size="45" maxsize="45" value="<%=v.getVehicleNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">承诺人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getPromiser(), "Promiser", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">承诺人联系电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PromiserPhone" id="PromiserPhone" size="45" maxsize="45" value="<%=v.getPromiserPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">承诺人学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getPromiserAcadeMy(), "PromiserAcadeMy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">承诺人班级</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClassesNameoptions, v.getPromiserClass(), "PromiserClass", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getTutor(), "Tutor", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TutorDuty" id="TutorDuty" size="45" maxsize="45" value="<%=v.getTutorDuty()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TutorPhone" id="TutorPhone" size="45" maxsize="45" value="<%=v.getTutorPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TutorAgree" id="TutorAgree" size="45" maxsize="45" value="<%=v.getTutorAgree()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remarks" id="Remarks" size="45" maxsize="45" value="<%=v.getRemarks()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
                    												<tr>
                    													<td align="right" class="form_label">团委审核</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Status" id="Status" size="45" maxsize="45" value="<%=v.getStatus()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院审核</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GuideUnitAgree" id="GuideUnitAgree" size="45" maxsize="45" value="<%=v.getGuideUnitAgree()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
