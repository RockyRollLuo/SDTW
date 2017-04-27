<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--立项社团活动信息--%>
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
	if(v.getId()==-1){
		cmd="saveProject";
	}else{
		cmd="updateProject";
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
List zyYesNoOptions = CEditConst.getYesNoOptions(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);


Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map ClubNameMap = CEditConst.getClubNameMap(userInfo);

List cdt = new ArrayList();
List list = new ArrayList();
Club club = new Club();
if(userInfo.hasFunPower(Power.STUSER))
cdt.add("ClubId='"+userInfo.getUserCode().getName()+"'");
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
List sponsorList = new ArrayList();
List caiwuList = new ArrayList();
allList = (List)numMap.get("All_");
sponsorList = (List)numMap.get("IsManager_")==null?new ArrayList():(List)numMap.get("IsManager_");
caiwuList = (List)numMap.get("caiwu_")==null?new ArrayList():(List)numMap.get("caiwu_");
List cdt1 = new ArrayList();
cdt1.add("id in("+Tool.join(",",allList)+")");
List UserNameoptions = COptionConst.getUserCnNameOptions(userInfo,"-1",cdt1); 
List UserNameoptions2 = COptionConst.getUserCnNameOptions(userInfo,cdt1); 
numMap.clear();


String type="text";
String number = "number";
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
String CommentAcademy = "";
String CommentShelian = "";
String ConclusionGeneral = "";
String ConclusionManuscript = "";
String ConclusionCommentClub = "";
String ConclusionPlanNums = "";
String ConclusionPlanNames = "";
String ConclusionCost = "";
String ConclusionSummary = "";
String ConclusionRemark = "";
String ConclusionBroadcastNums = "";

String dis = "";
if(!userInfo.hasFunPower(Power.STUSER)){
	type = "hidden";
	number = "hidden";
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
	CommentAcademy = v.getCommentAcademy();
	CommentShelian = v.getCommentShelian();
	ConclusionGeneral = v.getConclusionGeneral();
	ConclusionManuscript = v.getConclusionManuscript();
	ConclusionCommentClub = v.getConclusionCommentClub();
	ConclusionPlanNums = v.getConclusionPlanNums();
	ConclusionPlanNames = v.getConclusionPlanNames();
	ConclusionCost = v.getConclusionCost();
	ConclusionSummary = v.getConclusionSummary();
	ConclusionRemark = v.getConclusionRemark();
	ConclusionBroadcastNums = v.getConclusionBroadcastNums();
}
Date end = Tool.stringToDateTime(v.getTimeEnd());
int ProjectId = ParamUtils.getIntParameter(request,"ProjectId",-1);
String fjshow = "style=\"display: none;\"";
if ("0".equals(v.getIsatSchool())) {//校外需要上传附件
	fjshow = "";
} else if ("1".equals(v.getIsatSchool())){
	fjshow = "style=\"display: none;\"";
}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="../../main/jqueryui.jsp" flush="true"/>
		 <link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css"> 
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("ClubActivities_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
		
		<script type="text/javascript" src="<%=HeadConst.apache_url%>/main/js/jquery.multiselect.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/js/jquery.multiselect.css">
		<script language="JavaScript" src="../../main/js/ajaxfileupload.js"></script>
		<script language="JavaScript" src="js/upload.js"></script>
		<style>
		#tabs-6 td {
    border: 0 none;
    height: auto;
    margin: 0;
    padding: 5px;
}
#tabs-6 .form_label {
    background-color: #ffffff;
    color: #ffffff;
    font-size: 14px;
    text-align: center;
    width: 100px;
}
#tabs-6 .form_label {
    color: #9f9f9f;
    font-size: 14px;
    text-align: center;
    width: 100px;
}
		</style>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("ClubActivities", dic, "<%=userInfo.getPower()%>");
    				$("#example").multiselect({
					    header: false,
					    height: 200,
					    minWidth: 200,
						selectedList: 10,//预设值最多显示10被选中项
						noneSelectedText: '请选择',
					    close: function(){
					      var values= $("#example").val();
						  $("#ConclusionPlanNames").val(values);
						}
				 });
    			$("#example2").multiselect({
					    header: false,
					    height: 200,
					    minWidth: 200,
						selectedList: 10,//预设值最多显示10被选中项
					    //hide: ["explode", 500],
					    noneSelectedText: '请选择',
					    close: function(){
					      var values= $("#example2").val();
						  $("#ConclusionBroadcastNames").val(values);
						}
				 });
    			$("#example3").multiselect({
				    header: false,
				    height: 200,
				    minWidth: 200,
					selectedList: 10,//预设值最多显示10被选中项
				    //hide: ["explode", 500],
				    noneSelectedText: '请选择',
				    close: function(){
				      var values= $("#example3").val();
					  $("#ConclusionelseNames").val(values);
					}
			 });
			}
			
			function addClass(element, className) { 
				if (!this.hasClass(element, className)) 
				{ 
					element.className += " "+className; 
				} 
			}
			function hasClass(element, className) { 
				var reg = new RegExp('(\\s|^)'+className+'(\\s|$)'); 
				return element.className.match(reg); 
			} 
			function removeClass(element, className) { 
				if (hasClass(element, className)) { 
					var reg = new RegExp('(\\s|^)'+className+'(\\s|$)'); 
					element.className = element.className.replace(reg,' '); 
				} 
			} 
			function checkNum(i){
				var Price = $('#Price'+i).val();
				var val = $('#Num'+i).val();
				var Purpose = $('#Purpose'+i).val();
				if(Purpose==""){
					alert("请 录入资金详细用途！");
					$('#Purpose'+i).focus();
					$('#Amount'+i).val("");
					return;
				}
				if(Price==""){
					alert("请 录入金额！");
					$('#Price'+i).focus();
					$('#Amount'+i).val("");
					return;
				}
				if(!isDouble(Price)||Price<=0){
					$('#Price'+i).val("");
					$('#Price'+i).focus();
					$('#Amount'+i).val("");
					return;
				}
				if(val==""){
					alert("请 录入数量！");
					$('#Num'+i).focus();
					$('#Amount'+i).val("");
					return;
				}
				if(!isInteger(val)||val<=0){
					$('#Num'+i).val("");
					$('#Num'+i).focus();
					$('#Amount'+i).val("");
					return;
				}
				$('#Amount'+i).val(Price*val);
				var Amount = $('.Amount');
				var Amountval = 0.0;
				
				$('input[class="Amount"]').each(function(i,n){
				    $this=$(this);
				    if($this.val()!=""){
				    	var v = $this.val();
						if(!isDouble(v)||v<0){
							$('#BudgetAmountAll'+i).val("");
							$('#BudgetAmountAll'+i).focus();
							return;
						}
				    v = parseFloat(v);
					Amountval+=v;
				    }
				});
				 $('#BudgetAmountAll').val(Amountval);
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
				
				var check = true;
				$('.Purpose').each(function(i){		
					if($(this).val()!=""){
						var Price = $('#Price'+i).val();
						if(Price==""){
							$('#Price'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
						var Num = $('#Num'+i).val();
						if(Num==""){
							$('#Num'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
					}
				});
				 $('.Price').each(function(i){		
					if($(this).val()!=""){
						var Price = $('#Purpose'+i).val();
						if(Price==""){
							$('#Purpose'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
						var Num = $('#Num'+i).val();
						if(Num==""){
							$('#Num'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
					}
				});
				$('.Num').each(function(i){		
					if($(this).val()!=""){
						var Price = $('#Purpose'+i).val();
						if(Price==""){
							$('#Purpose'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
						var Num = $('#Price'+i).val();
						if(Num==""){
							$('#Price'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
					}
				});
				$('.Remark').each(function(i){		
					if($(this).val()!=""){
						var Purpose = $('#Purpose'+i).val();
						if(Purpose==""){
							$('#Purpose'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
						var Price = $('#Price'+i).val();
						if(Price==""){
							$('#Price'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
						var Num = $('#Num'+i).val();
						if(Num==""){
							$('#Num'+i).css('background-color','#BFEFFF');
							check = false;
							return;
						}
					}
				});
				if(check == true){
					$('#CheckFlag').val(flag);
					<%
					if(userInfo.hasFunPower(Power.UserAdminPower)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){%>
						$('#cmd').val("checkProject");
					<%}
					%>
					document.postForm.submit();
				}else{
					$('#errorDiv').html('请将社团活动立项经费预算明细填写完整！');
				}
			}
			function submitthis2(flag){
				$('#CheckFlag').val(flag);
				document.postForm.submit();
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团活动立项审批表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团活动立项审批表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
					<%//社团用户
					//int activity = ParamUtils.getIntParameter(request,"activity",-1);//区别社团活动和活动立项页面
					if(userInfo.hasFunPower(Power.STUSER)){
					//if(activity!=1){//未立项%>
						 <li><a href="ClubActivityProjectAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li> 
					<%//}else{%> 
						<%--<li><a href="ClubActivitiesAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>--%>
					<%//}
					%>
					<%} %>
					<%//指导单位 团委用户
					if(userInfo.hasFunPower(Power.UserAdminPower)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){%>
						<li><a href="ClubActivitiesAction.jsp?cmd=clubproject&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
					<%} %>
						<%
						if(userInfo.hasFunPower(Power.STUSER)||SdtwConst.CHECKFLAG_XYWTG.equals(v.getCheckFlag()+"")){//社团用户
							if(v.getCheckFlag()==-1){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ submitthis(<%=SdtwConst.CHECKFLAG_SB%>);}">提交</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis(-1);}">保存</a></li>
						<%
							}
						if(SdtwConst.CHECKFLAG_XXWTG.equals(v.getCheckFlag()+"")){%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ submitthis(<%=SdtwConst.CHECKFLAG_XYTG%>);}">提交</a></li>
						<%}
						}
						if(userInfo.hasFunPower(Power.UserAdminPower)){//指导单位用户
							if(SdtwConst.CHECKFLAG_SB.equals(v.getCheckFlag()+"")){
						%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XYWTG%>);}">审核未通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XYTG%>);}">审核通过</a></li>
						<%}
						}
						if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){//团委用户
							if(SdtwConst.CHECKFLAG_XYTG.equals(v.getCheckFlag()+"")){
						%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XXWTG%>);}">审核未通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XXTG%>);}">审核通过</a></li>
						<%}
						}
						
						//结题
						if(userInfo.hasFunPower(Power.STUSER)){//社团
							if(new Date().getTime()-end.getTime()>0){
						if((SdtwConst.CHECKFLAG_XXTG.equals(v.getCheckFlag()+"")||SdtwConst.CHECKFLAG_WSB_JT.equals(v.getCheckFlag()+""))){%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('updateProject'); submitthis2(<%=SdtwConst.CHECKFLAG_SB_JT%>);}">提交</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('updateProject'); submitthis2(<%=SdtwConst.CHECKFLAG_WSB_JT%>);}">保存</a></li>
						<%}
								if(SdtwConst.CHECKFLAG_XYWTG_JT.equals(v.getCheckFlag()+"")){%>
									<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('updateProject'); submitthis2(<%=SdtwConst.CHECKFLAG_SB_JT%>);}">提交</a></li>
								<%}
								if(SdtwConst.CHECKFLAG_XXWTG_JT.equals(v.getCheckFlag()+"")){%>
									<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('updateProject'); submitthis2(<%=SdtwConst.CHECKFLAG_XYTG_JT%>);}">提交</a></li>
								<%}
							}
						}
						if(userInfo.hasFunPower(Power.UserAdminPower))//指导单位
						if(SdtwConst.CHECKFLAG_SB_JT.equals(v.getCheckFlag()+"")){%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('update_Jt'); submitthis2(<%=SdtwConst.CHECKFLAG_XYWTG_JT%>);}">审核未通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('update_Jt'); submitthis2(<%=SdtwConst.CHECKFLAG_XYTG_JT%>);}">审核通过</a></li>
						<%}
						if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST))//团委
						if(SdtwConst.CHECKFLAG_XYTG_JT.equals(v.getCheckFlag()+"")){%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('update_Jt'); submitthis2(<%=SdtwConst.CHECKFLAG_XXWTG_JT%>);}">审核未通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){$('#cmd').val('update_Jt'); submitthis2(<%=SdtwConst.CHECKFLAG_XXTG_JT%>);}">审核通过</a></li>
						<%}
						%>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold">
		<%
		Map CheckFlagMap = util.getCheckFlagMap();
		if(CheckFlagMap.get(v.getCheckFlag()+"")!=null){%>
			<%=CheckFlagMap.get(v.getCheckFlag()+"") %>
		<%}
		CheckFlagMap.clear();
		%></div>
		<div class="browsetable" id="form">
		<div id="tabs">
			<ul>
					<li><a href="#tabs-1">山东大学学生社团活动立项审批表</a></li>
					<li><a href="#tabs-2">社团活动立项经费预算明细</a></li>
					<%
					if(userInfo.hasFunPower(Power.STUSER)){//社团用户
						if(v.getCheckFlag()!=-1){
					%>
					<li><a href="#tabs-3">指导单位意见</a></li>
					<li><a href="#tabs-4">团委意见</a></li>
					<%} 
					}%>
					<%
					if(userInfo.hasFunPower(Power.UserAdminPower)){%>
						<li><a href="#tabs-3">指导单位意见</a></li>
					<%}
					%>
					<%
					if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){%>
						<li><a href="#tabs-3">指导单位意见</a></li>
						<li><a href="#tabs-4">团委意见</a></li>
					<%}
					//if(activity==1){
						if(v.getCheckFlag()==3||v.getCheckFlag()>=5){
						%>
							<li><a href="#tabs-5">审核活动参加人员</a></li>
							<%
							if(new Date().getTime()-end.getTime()>0){
							
								if ((v.getCheckFlag()==3||v.getCheckFlag()>=5)){
						%>
						<li><a href="#tabs-6"><%=v.getActivityName()%>活动立项结题书</a></li>
						<%}
						}%>
						<%}
						//}
					%>
			</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" id="cmd"name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden"name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
				<input type="hidden"id="AddPerson" name="AddPerson" value="<%=v.getAddPerson().equals("")?userInfo.getId()+"":v.getAddPerson()%>"/>
				<input type="hidden"name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
				<input type="hidden"id="Modiperson" name="Modiperson" value="<%=v.getModiperson()%>"/>
				<input type="hidden"name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
				<input type="hidden"id="CheckPerson" name="CheckPerson" value="<%=v.getCheckPerson()%>"/>
				<input type="hidden"id="ProjectId" name="ProjectId" value="<%=v.getProjectId().equals("")?ProjectId:v.getProjectId()%>"/>
				<input type="hidden"id="ProjectName" name="ProjectName" value="<%=v.getProjectName()%>"/>
				<input type="hidden"id="Module" name="Module" value="<%=v.getModule().equals("")?"club-project":v.getModule()%>"/>
				<input type="hidden"name="ApplyTime" id="ApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getApplyTime())%>">
				<input type="hidden"name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
				<%-- <input type="hidden"name="BelongId" id="BelongId" size="45" maxsize="45" value="<%=v.getBelongId()%>"> --%>
				<input type="hidden"id="BudgetList" name="BudgetList" value="<%=v.getBudgetList()%>"/>
				<input type="hidden"name="ConclusionCheckFlag" id="ConclusionCheckFlag" value="<%=v.getConclusionCheckFlag()%>">
				<input type="hidden"name="ConclusionApplyTime" id="ConclusionApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getConclusionApplyTime())%>">
				<input type="hidden"id="ConclusionCommentAcademy" name="ConclusionCommentAcademy" value="<%=v.getConclusionCommentAcademy()%>"/>
				<input type="hidden"id="ConclusionCommentShelian" name="ConclusionCommentShelian" value="<%=v.getConclusionCommentShelian()%>"/>
				<input type="hidden"id="ConclusionBroadcastNames" name="ConclusionBroadcastNames" value="<%=v.getConclusionBroadcastNames()%>"/>
				<input type="hidden"id="ConclusionelseNames" name="ConclusionelseNames" value="<%=v.getConclusionelseNames()%>"/>
				<input type="hidden"id="ConclusionIsSupport" name="ConclusionIsSupport" value="<%=v.getConclusionIsSupport()%>"/>
				
				<input type="hidden" id="IsSupported" name="IsSupported" value="<%=v.getIsSupported()%>"/>
				<input type="hidden" id="Forecast" name="Forecast" value="<%=v.getForecast()%>"/>
				<input type="hidden" id="CommentTeacher" name="CommentTeacher" value="<%=v.getCommentTeacher()%>"/>
				<%-- <input type="hidden" id="IsatSchool" name="IsatSchool" value="<%=v.getIsatSchool()%>"/> --%>
				<input type="hidden" id="ConclusionCommentcTuanwei" name="ConclusionCommentcTuanwei" value="<%=v.getConclusionCommentcTuanwei()%>"/>
				
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
													  				</tr>
													  				<tr>
                    												<td align="right" class="form_label">组织单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getOrgacadeMy(), "OrgacadeMy", ""+club.getAcademy(),true)%>
                    													</td>
                    													<td align="right" class="form_label">组织者</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
																		<%=HtmlTool.renderSelect(UserNameoptions, v.getOrganizer(), "Organizer", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(UserNameoptions, v.getOrganizer(), "Organizer", "")%>
														    			<%} %>
                    													</td>
                    												</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动主题</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=ActivityName %>
                    														<input type="<%=type%>" style="width: 100%;" name="ActivityName" id="ActivityName"  maxsize="45" value="<%=v.getActivityName()%>">
                    													</td>
													  				
                    													<td align="right" class="form_label">立项等级</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
														    			<%=HtmlTool.renderSelect(ActivityLeveloptions, v.getActivityLevel(), "ActivityLevel", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(ActivityLeveloptions, v.getActivityLevel(), "ActivityLevel", "")%>
														    			<%} %>
                    													</td>
													  				</tr>
                    												
                    												<tr>
                    												<td align="right" class="form_label">活动开始时间</td>
														    			<td align="left"  bgcolor="#ffffff" >
														    			<%=TimeStart %>  <%=TimeEnd %>
														    			<input type="<%=type%>" class="date" name="TimeStart" id="TimeStart" onfocus="WdatePicker({el:'TimeStart',dateFmt:'yyyy-MM-dd'})"  size="0" value="<%=Tool.stringOfDate(Tool.stringToDate(v.getTimeStart()))%>"/>
														    			<input type="<%=type%>" class="date" name="TimeEnd" id="TimeEnd" onfocus="WdatePicker({el:'TimeEnd',dateFmt:'yyyy-MM-dd'})"  size="0" value="<%=Tool.stringOfDate(Tool.stringToDate(v.getTimeEnd()))%>"/>
                    													</td>
                    													<td align="right" class="form_label">是否校内活动</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
														    			<%=HtmlTool.renderSelect(YesNoOptions, v.getIsatSchool(), "IsatSchool", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(YesNoOptions, v.getIsatSchool(), "IsatSchool", "","onchange='checkClientAttach()'")%>
														    			<%} %>
														    			&nbsp;&nbsp;
														    			是否有赞助
														    			<%if(!userInfo.hasFunPower(Power.STUSER)){%>
														    			<%=HtmlTool.renderSelect(YesNoOptions, v.getConclusionIsSupport(), "ConclusionIsSupport", "",true)%>
														    			<%}else{%>
														    				<%=HtmlTool.renderSelect(YesNoOptions, v.getConclusionIsSupport(), "ConclusionIsSupport", "")%>
														    			<%} %>
                    													</td>
                    													</tr>
                    													<tr>
                    													<td align="right" class="form_label">活动地点</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=ActivityPlace %>
                    														<input type="<%=type%>" style="width: 100%;" name="ActivityPlace" id="ActivityPlace" maxsize="45" value="<%=v.getActivityPlace()%>">
                    													</td>
                    												<td align="right" class="form_label">预计参加人数</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=PredictNumber %>
                    														<input type="<%=type%>" style="width: 100%;" name="PredictNumber" id="PredictNumber"  maxsize="10" value="<%=v.getPredictNumber()%>">
                    													</td>
                    												</tr>
                    												<tr>
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
																    <td bgcolor="#ffffff" colspan="5">
																    <%=CommentTeacher %>
                    														<textarea style="width: 100%;<%=dis %>" name="CommentTeacher" id="CommentTeacher" cols="40" rows="2"><%=v.getCommentTeacher()%></textarea>
																</tr>
													  				<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=Remark %>
                    														<textarea style="width: 100%;<%=dis %>" name="Remark" id="Remark" cols="40" rows="2"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
													  				<input type="hidden" id="BelongId" name="BelongId" value="<%=v.getBelongId()%>"/>
													  				<%
																	//if (v.getId()!=-1){%>
													  				<tr id="ClientAttach" <%=fjshow %>>
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
																				if(v.getCheckFlag()!=0&&v.getCheckFlag()!=1&&v.getCheckFlag()!=3&&v.getCheckFlag()!=6&&v.getCheckFlag()!=7&&v.getCheckFlag()!=9){%>
																				<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
																				<%} %>
																				</tr>
																					<%}
																					}
																				}
																				%>
																	</table>
																	<%
																	//if(v.getCheckFlag()!=0&&v.getCheckFlag()!=1&&v.getCheckFlag()!=3&&v.getCheckFlag()!=6&&v.getCheckFlag()!=7&&v.getCheckFlag()!=9){%>
																	<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
																	<input type="button" value="上传" id="btn_up"  onclick="checkFileType(3,'clubactivities');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
																	<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
																	<%//}
																	%>
																    <div style="color:red">说明：请上传【社团校外活动会长（带队队长）承诺书】和【社团校外活动校外活动安全指导书】<br/>格式为:doc、docx格式文件，文件最大5M</div>
																</td>
													  				</tr>
													  				<%//} %>
													  				</table>
													  				</div>
													  				<div id="tabs-2" style="border: 0px;">
													  				<table width="100%" style="background-color: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
													  				<%
													  				if(sponsorList.size()>0){
													  					ClubMembers members = new ClubMembers();
													  					members = (ClubMembers)sponsorList.get(0);%>
													  					<tr>
													  					<td bgcolor="#ffffff" align="right" style="padding: 0px;">会长姓名：</td>
														    			<td bgcolor="#ffffff" align="left" style="padding: 0px;"><%=UserCnNameMap.get(members.getMemberName()) %></td>
                    													<td bgcolor="#ffffff" align="right" style="padding: 0px;">联系电话：</td>
														    			<td bgcolor="#ffffff" align="left" style="padding: 0px;"><%=members.getMemberPhone() %></td>
														    			<td bgcolor="#ffffff"></td>
													  					</tr>
													  				<%}
													  				%>
													  				<%
													  				if(caiwuList.size()>0){
													  					ClubMembers members = new ClubMembers();
													  					members = (ClubMembers)caiwuList.get(0);%>
													  					<tr>
													  					<td bgcolor="#ffffff" align="right" style="padding: 0px;">财务负责人姓名：</td>
														    			<td bgcolor="#ffffff" align="left" style="padding: 0px;"><%=UserCnNameMap.get(members.getMemberName()) %></td>
                    													<td bgcolor="#ffffff" align="right" style="padding: 0px;"> 联系电话：</td>
														    			<td bgcolor="#ffffff" align="left" style="padding: 0px;"><%=members.getMemberPhone() %></td>
														    			<td bgcolor="#ffffff"></td>
													  					</tr>
													  				<%}
													  				%>
													  					<tr bgcolor='#e3e5e8'>
													  					<td style="padding: 0px;"> 资金详细用途</td>
														    			<td style="padding: 0px;">单价（元）</td>
                    													<td style="padding: 0px;">数量</td>
														    			<td style="padding: 0px;">金额（元）</td>
														    			<td style="padding: 0px;">备注</td>
													  					</tr>
													  					<%
													  				//编辑或查看
													  					String bg = "bgcolor='#f7f9fc'";
													  					if(v.getId()!=-1){
													  						List cabList = new ArrayList();
													  						cabList = util.getClubActivityProject(v.getBudgetList());
													  						if(cabList.size()>0){
													  							for(int i=0;i<cabList.size();i++){
													  								ClubActivitiesBudgetAmount cab = new ClubActivitiesBudgetAmount();
													  								cab = (ClubActivitiesBudgetAmount)cabList.get(i); 
													  							%>
													  							<input type="hidden" id="cabaid<%=i%>" name="cabaid<%=i%>" value="<%=cab.getId()%>"/>
													  				<tr <%=bg %> onMouseOver="addClass(this,'data_bgcolor_over');"  onMouseOut="removeClass(this,'data_bgcolor_over');">
													  					<td style="padding: 5px;">【<%=i+1 %>】
													  					<%
													  					if(!userInfo.hasFunPower(Power.STUSER)){%>
														  					<%=cab.getPurpose() %>
														  				<%}%>
													  						<input type="<%=type%>" class="Purpose" style="height: 20px;width: 80%;" id="Purpose<%=i%>" name="Purpose<%=i%>" value="<%=cab.getPurpose()%>"/>
													  					</td>
														    			<td style="padding: 5px;">
														    			<%
													  					if(!userInfo.hasFunPower(Power.STUSER)){%>
														  					<%=cab.getPrice() %>
														  				<%}%>
														    				<input type="<%=type%>" class="Price" style="height: 20px;" id="Price<%=i %>" name="Price<%=i%>" onblur="checkNum(<%=i%>)" value="<%=cab.getPrice()%>"/>
														    			</td>
                    													<td style="padding: 5px;">
                    													<%
													  					if(!userInfo.hasFunPower(Power.STUSER)){%>
														  					<%=cab.getNum() %>
														  				<%}%>
                    														<input type="<%=type%>" class="Num" style="height: 20px;" id="Num<%=i%>" name="Num<%=i%>" onblur="checkNum(<%=i%>)" value="<%=cab.getNum()%>"/>
                    													</td>
														    			<td style="padding: 5px;">
														    			<%
													  					if(!userInfo.hasFunPower(Power.STUSER)){%>
														  					<%=cab.getAmount() %>
														  				<%}%>
														    				<input type="<%=type%>" class="Amount" readonly="readonly" style="height: 20px;" id="Amount<%=i%>" name="Amount<%=i%>" value="<%=cab.getAmount()%>"/>
														    			</td>
														    			<td style="padding: 5px;">
														    			<%
													  					if(!userInfo.hasFunPower(Power.STUSER)){%>
														  					<%=cab.getRemark() %>
														  				<%}%>
														    				<input type="<%=type%>" class="Remark" style="height: 20px;" id="Remark<%=i%>" name="Remark<%=i%>" value="<%=cab.getRemark()%>"/>
														    			</td>
													  				</tr>
													  							<%}
													  						}
													  						int num = cabList.size();
													  						if(userInfo.hasFunPower(Power.STUSER))
													  						if(num<10){
													  							for(int i=num;i<10;i++){%>
													  								<tr <%=bg %> onMouseOver="addClass(this,'data_bgcolor_over');"  onMouseOut="removeClass(this,'data_bgcolor_over');">
																  					<td style="padding: 5px;">【<%=i+1 %>】<input class="Purpose" style="height: 20px;width: 80%;" id="Purpose<%=i%>" name="Purpose<%=i%>"/></td>
																	    			<td style="padding: 5px;"><input class="Price" style="height: 20px;" id="Price<%=i %>" name="Price<%=i%>" onblur="checkNum(<%=i%>)"/></td>
			                    													<td style="padding: 5px;"><input class="Num" style="height: 20px;" id="Num<%=i%>" name="Num<%=i%>" onblur="checkNum(<%=i%>)"/></td>
																	    			<td style="padding: 5px;"><input class="Amount" readonly="readonly" style="height: 20px;" id="Amount<%=i%>" name="Amount<%=i%>"/></td>
																	    			<td style="padding: 5px;"><input class="Remark" style="height: 20px;" id="Remark<%=i%>" name="Remark<%=i%>"/></td>
																  					</tr>
													  							<%}
													  						}
													  					}else{
													  						//首次保存
													  						for(int i=0;i<10;i++){
														  						if(i%2==0){
														  							bg="bgcolor='#ffffff'";
														  						}else{
														  							bg = "bgcolor='#f7f9fc'";
														  						}
														  					%>
														  					<tr <%=bg %> onMouseOver="addClass(this,'data_bgcolor_over');"  onMouseOut="removeClass(this,'data_bgcolor_over');">
														  					<td style="padding: 5px;">【<%=i+1 %>】<input class="Purpose" style="height: 20px;width: 80%;" id="Purpose<%=i%>" name="Purpose<%=i%>"/></td>
															    			<td style="padding: 5px;"><input class="Price" style="height: 20px;" id="Price<%=i %>" name="Price<%=i%>" onblur="checkNum(<%=i%>)"/></td>
	                    													<td style="padding: 5px;"><input class="Num" style="height: 20px;" id="Num<%=i%>" name="Num<%=i%>" onblur="checkNum(<%=i%>)"/></td>
															    			<td style="padding: 5px;"><input class="Amount" readonly="readonly" style="height: 20px;" id="Amount<%=i%>" name="Amount<%=i%>"/></td>
															    			<td style="padding: 5px;"><input class="Remark" style="height: 20px;" id="Remark<%=i%>" name="Remark<%=i%>"/></td>
														  					</tr>
														  					<%}
													  					}%>
													  					<tr>
													  					<td bgcolor="#ffffff">总预算（活动总金额）（元）：</td>
													  					<td bgcolor="#ffffff" colspan="4" style="padding: 5px;">
													  					<input style="height: 20px;" readonly="readonly" id="BudgetAmountAll" name="BudgetAmountAll" value="<%=v.getBudgetAmountAll()%>"/>
													  					</td>
													  					</tr>
													  				</table>
													  				</div>
													  				<%
													  				if(userInfo.hasFunPower(Power.STUSER)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){
													  					//社团用户  团委用户
		                    											if(v.getCheckFlag()!=-1){
													  				%>
													  				<div id="tabs-3" style="border: 0px;">
													  				<table width="100%" style="background-color: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">指导单位意见</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=CommentAcademy %>
                    														<textarea style="width: 100%;<%=dis %>" name="CommentAcademy" id="CommentAcademy" cols="40" rows="5"><%=v.getCommentAcademy()%></textarea>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
													  				<div id="tabs-4" style="border: 0px;">
													  				<table width="100%" style="background-color: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
													  				<tr>
                    													<td align="right" class="form_label">团委意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea style="width: 100%;" name="CommentShelian" id="CommentShelian" cols="40" rows="5"><%=v.getCommentShelian()%></textarea>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
													  				<%} else{%>
													  					<input type="hidden" id="CommentShelian" name="CommentShelian" value="<%=v.getCommentShelian()%>"/>
													  				<%}
													  					
													  			}else{%>
													  				<input type="hidden" id="CommentShelian" name="CommentShelian" value="<%=v.getCommentShelian()%>"/>
													  			<%}%>
													  					<%
													  				if(userInfo.hasFunPower(Power.UserAdminPower))
													  				{//指导单位  团委
													  				%>
													  				<div id="tabs-3" style="border: 0px;">
													  				<table width="100%" style="background-color: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">指导单位意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea style="width: 100%;" name="CommentAcademy" id="CommentAcademy" cols="40" rows="5"><%=v.getCommentAcademy()%></textarea>
                    														<input type="hidden" id="CommentShelian" name="CommentShelian" value="<%=v.getCommentShelian()%>"/>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
													  				<%}else{%>
													  					<input id="CommentAcademy"name="CommentAcademy" value="<%=v.getCommentAcademy()%>" type="hidden"/>
													  				<%} %>
													  					<%
													  					if(v.getCheckFlag()==3||v.getCheckFlag()>=5){%>
													  						<div id="tabs-5" style="border: 0px;">
															  				<iframe class="commentFrame" name="commentFrame" id="commentFrame" src="ClubActivityParticipateAction.jsp?_Activityid_=<%=v.getId() %>&CheckFlag=<%=v.getCheckFlag() %>" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px" ></iframe>
															  				</div>
															  				<%
													  					}
													  				//结题书
													  				if(new Date().getTime()-end.getTime()>0){
													  					if(v.getCheckFlag()==3||v.getCheckFlag()>=5){
													  						if(((userInfo.hasFunPower(Power.UserAdminPower)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST))&&v.getCheckFlag()>=6)||(userInfo.hasFunPower(Power.STUSER))) {
													  				%>
																	<div id="tabs-6" style="border: 0px;">
																	<table width="100%" style="background-color: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
																	<tr>
                    												<td colspan="4" align="center" bgcolor="#e5f1f4" style="color: #000000;font-weight: bold;"><%=v.getActivityName()%>活动立项结题书</td>
                    												</tr>
																	<tr>
                    													<td align="right" class="form_label"> 社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=ClubNameMap.get(v.getClubName()) %>
                    													</td>
                    													<td align="right" class="form_label"> 活动主题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=v.getActivityName() %>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label"> 组织单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=AcademyNameMap.get(v.getOrgacadeMy()) %>
                    													</td>
                    													<td align="right" class="form_label"> 活动时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=v.getTimeStart() %>~<%=v.getTimeEnd() %>
                    													</td>
													  				</tr>
																	<tr>
                    													<td align="right" class="form_label">活动概要</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%=ConclusionGeneral %>
                    														<textarea style="width: 100%;<%=dis %>" name="ConclusionGeneral" id="ConclusionGeneral" cols="40" rows="3"><%=v.getConclusionGeneral()%></textarea>
                    													</td>
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">稿件情况</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%=ConclusionManuscript %>
                    														<textarea style="width: 100%;<%=dis %>" name="ConclusionManuscript" id="ConclusionManuscript" cols="40" rows="3"><%=v.getConclusionManuscript()%></textarea>
                    													</td>
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">社团意见</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%=ConclusionCommentClub %>
                    														<textarea style="width: 100%;<%=dis %>" name="ConclusionCommentClub" id="ConclusionCommentClub" cols="40" rows="3"><%=v.getConclusionCommentClub()%></textarea>
                    													</td>
													  				</tr>
													  				<tr>
													  				<td colspan="4" align="center" bgcolor="#e5f1f4" style="color: #000000;font-weight: bold;">活动后期总结</td>
													  				</tr>
													  				<tr>
													  				<td bgcolor="#ffffff" rowspan="3"> 举办活动主要组织者和参与者</td>
													  				<td bgcolor="#ffffff" colspan="3">
													  				1.活动前期策划和组织人员，共<%=ConclusionPlanNums %><input type="<%=number %>" id="ConclusionPlanNums" name="ConclusionPlanNums" value="<%=v.getConclusionPlanNums()%>" type="hidden"/>人。
													  				 请列举姓名：<input type="hidden" id="ConclusionPlanNames" type="hidden" name="ConclusionPlanNames" value="<%=v.getConclusionPlanNames()%>"/>
													  				 <select id="example" name="example" multiple="multiple" style="width:400px">
																		<%=HtmlTool.renderMulSelectOption(UserNameoptions2,""+v.getConclusionPlanNames(),"") %>
																	</select>
													  				</td>
													  				</tr>
													  				<tr>
													  				<td bgcolor="#ffffff" colspan="3">
													  				2.活动材料制作、宣传、表演人员，共<%=ConclusionBroadcastNums %><input type="<%=number %>" id="ConclusionBroadcastNums" name="ConclusionBroadcastNums" value="<%=v.getConclusionBroadcastNums()%>"/>人。 
													  				请列举姓名：<input type="hidden" id="ConclusionBroadcastNames" name="ConclusionBroadcastNames" value="<%=v.getConclusionBroadcastNames()%>"/>
													  				 <select id="example2" name="example2" multiple="multiple" style="width:400px">
													  				 <%=HtmlTool.renderMulSelectOption(UserNameoptions2,""+v.getConclusionBroadcastNames(),"") %>
																	</select>
													  				</td>
													  				</tr>
													  				<tr>
													  				<td bgcolor="#ffffff" colspan="3">
													  				3.活动其他参与人员，共<input type="<%=number %>" id="ConclusionelseNums" name="ConclusionelseNums" value="<%=v.getConclusionelseNums()%>"/>人。 
													  				请列举姓名：<input type="hidden" type="hidden" id="ConclusionelseNames" name="ConclusionelseNames" value="<%=v.getConclusionelseNames()%>"/>
													  				<select id="example3" name="example3" multiple="multiple" style="width:400px">
																		<%=HtmlTool.renderMulSelectOption(UserNameoptions2,""+v.getConclusionelseNames(),"") %>
																	</select>
													  				</td>
													  				</tr>
													  				<tr>
													  				<td class="form_label">活动总经费</td>
													  				<td bgcolor="#ffffff">￥<%=ConclusionCost %><input type="<%=number %>" id="ConclusionCost" name="ConclusionCost" value="<%=v.getConclusionCost()%>"/></td>
													  				<td class="form_label">赞助情况</td>
													  				<td bgcolor="#ffffff">
													  				<%=HtmlTool.renderRadio(zyYesNoOptions,""+v.getConclusionSupportDetail(),"ConclusionSupportDetail","") %>
													  				</td>
													  				</tr>
													  				<tr>
													  				<td class="form_label">活动整体总结</td>
													  				<td colspan="3" bgcolor="#ffffff" >
													  				<%=ConclusionSummary %>
													  				<textarea style="width: 100%;<%=dis %>" rows="3" cols="40" id="ConclusionSummary" name="ConclusionSummary"><%=v.getConclusionSummary() %></textarea>
													  				</td>
													  				</tr>
													  				<tr>
													  				<td class="form_label">其他必要说明</td>
													  				<td colspan="3" bgcolor="#ffffff">
													  				<%=ConclusionRemark %>
													  				<textarea style="width: 100%;<%=dis %>" rows="3" cols="40" id="ConclusionRemark" name="ConclusionRemark"><%=v.getConclusionRemark() %></textarea>
													  				</td>
													  				</tr>
																	</table>
																	</div>
															<%
													  		}
													  	}
													  	}
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
