<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团变更指导单位--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubModify.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubModify v = (ClubModify)request.getAttribute("fromBean");
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
List ClubModifyTypeoptions = (List)request.getAttribute("ClubModifyTypeoptions");
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
List ClubTypeNameoptions = (List)request.getAttribute("ClubTypeNameoptions");

Club club = new Club();
if ("".equals(v.getClubName())) {
	List cdt = new ArrayList();
	List list = new ArrayList();
	cdt.add("ClubId='"+userInfo.getName()+"'");
	list = club.query(cdt);
	if(list.size()>0){
		club = (Club)list.get(0);
	}
}else{
	club = club.getById(Tool.StrToInt(v.getClubName()));
}
String ModifyReason = "";
String CommentXy = v.getCommentXy();
String CommentXyNew = v.getCommentXyNew();
String CommentTw = v.getCommentTw();
String dis = "";
String distw = "display:none";
String diszd = "display:none";
if(!"".equals(v.getCheckFlag())){
	ModifyReason = v.getModifyReason();
	dis = "display:none";
}
if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){
	CommentTw = "";
	distw = "display:block";
}
if(userInfo.hasFunPower(Power.UserAdminPower)){
	CommentXy = "";
	CommentXyNew = "";
	diszd = "display:block";
}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
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
    				$("#ClubAcadeMyNew").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
			}
			function submitthis(flag){
				$('#CheckFlag').val(flag);
				document.postForm.submit();
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团变更指导单位</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团变更指导单位") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubModifyAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%
						if(userInfo.hasFunPower(Power.STUSER)){
							if("".equals(v.getCheckFlag())||SdtwConst.CHANGE_CLUB_YDWWTG.equals(v.getCheckFlag())){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_TJ%>')}">提交</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('')}">保存</a></li>
						<%} 
							if(SdtwConst.CHANGE_CLUB_XDWBTG.equals(v.getCheckFlag())){%>
								<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_YDWTG%>')}">提交</a></li>
							<%}
							if(SdtwConst.CHANGE_CLUB_TWBTG.equals(v.getCheckFlag())){%>
								<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_XDWTG%>')}">提交</a></li>
							<%}
						}%>
						<%
						if((userInfo.getUserCode().getDeptId()+"").equals(v.getClubAcademy())){
						if(userInfo.hasFunPower(Power.UserAdminPower)&&(SdtwConst.CHANGE_CLUB_TJ.equals(v.getCheckFlag()))){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_YDWWTG%>')}">审核未通过</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_YDWTG%>')}">审核通过</a></li>
						<%}
						}%>
						<%
						if((userInfo.getUserCode().getDeptId()+"").equals(v.getClubAcadeMyNew())){
						if(userInfo.hasFunPower(Power.UserAdminPower)&&(SdtwConst.CHANGE_CLUB_YDWTG.equals(v.getCheckFlag()))){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_XDWBTG%>')}">审核未通过</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_XDWTG%>')}">审核通过</a></li>
						<%}
						}%>
						<%
						if((userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST))&&(SdtwConst.CHANGE_CLUB_XDWTG.equals(v.getCheckFlag()))){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_TWBTG%>')}">审核未通过</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis('<%=SdtwConst.CHANGE_CLUB_TWTG%>')}">审核通过</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<div id="tabs">
			<ul>
				<li><a href="#tabs-1">变更信息</a></li>
				<%
				boolean show = false;
				if(userInfo.hasFunPower(Power.STUSER)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){
					if(!"".equals(v.getCheckFlag())){
						show = true;
				%>
					<li><a href="#tabs-2">原指导单位意见</a></li>
					<li><a href="#tabs-3">新指导单位意见</a></li>
					<li><a href="#tabs-4">团委审核意见</a></li>
				<%}
				}
				%>
				<%
				if(userInfo.hasFunPower(Power.UserAdminPower)) {
				if((userInfo.getUserCode().getDeptId()+"").equals(v.getClubAcademy())){%>
				<li><a href="#tabs-2">原指导单位意见</a></li>
				<%}%>
				<%if((userInfo.getUserCode().getDeptId()+"").equals(v.getClubAcadeMyNew())){%>
				<li><a href="#tabs-3">新指导单位意见</a></li>
				<%} 
				}%>
			</ul>
				<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
					<input type="hidden" name="cmd" value="<%=cmd%>">
					<input type="hidden" name="page" value="<%=currpage%>">
					<%=Tool.join("\n", forms)%>
	                    											<div id="tabs-1" style="border: 0px;">
	                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
	<input type="hidden" name="Id" value="<%=v.getId()%>">
	<input type="hidden" id="AddPerson" name="AddPerson" value="<%=v.getAddPerson()%>"/>
	<input type="hidden" name="ModiPerson" id="ModiPerson" value="<%=v.getModiPerson()%>"/>
	                    												<tr>
	                    													<td align="right" class="form_label">社团名称</td>
															    			<td align="left"  bgcolor="#ffffff">
	<%=HtmlTool.renderSelect(ClubNameoptions, club.getId()+"", "ClubName", "",true)%>
	                    													</td>
	                    													<td align="right" class="form_label">社团账号</td>
															    			<td align="left"  bgcolor="#ffffff">
															    			<%=club.getClubId() %>
															    			<input type="hidden" name="ClubId" value="<%=club.getClubId()%>">
	                    													</td>
														  				</tr>
														  				<tr>
	                    													<td align="right" class="form_label">社团类别</td>
															    			<td align="left"  bgcolor="#ffffff">
	<%=HtmlTool.renderSelect(ClubTypeNameoptions, club.getClubType(), "ClubType", "",true)%>
	                    													</td>
	                    													<td align="right" class="form_label">信息变更类型</td>
															    			<td align="left"  bgcolor="#ffffff">
	<%=HtmlTool.renderSelect(ClubModifyTypeoptions, v.getModifyType(), "ModifyType", "0",true)%>
	                    													</td>
														  				</tr>
	                    												<tr>
	                    													<td align="right" class="form_label">原指导单位</td>
															    			<td align="left"  bgcolor="#ffffff">
	<%=HtmlTool.renderSelect(AcademyNameoptions, v.getClubAcademy(), "ClubAcademy", ""+userInfo.getDeptId(),true)%>
	                    													</td>
														  				
	                    													<td align="right" class="form_label">新指导单位</td>
															    			<td align="left"  bgcolor="#ffffff">
															    			<%
															    			if ("".equals(v.getCheckFlag())) {
															    			%>
	<%=HtmlTool.renderSelect(AcademyNameoptions, v.getClubAcadeMyNew(), "ClubAcadeMyNew", "")%>
																			<%} else {%>
	<%=HtmlTool.renderSelect(AcademyNameoptions, v.getClubAcadeMyNew(), "ClubAcadeMyNew", "",true)%>
																			<%} %>
	                    													</td>
														  				</tr>
	                    												<tr>
	                    													<td align="right" class="form_label">社团信息变更原因</td>
															    			<td align="left"  bgcolor="#ffffff" colspan="3">
															    			<%=ModifyReason %>
	                    														<textarea style="width: 100%;<%=dis %>" id="ModifyReason" name="ModifyReason" cols="40" rows="4"><%=v.getModifyReason()%></textarea>
	                    													</td>
														  				</tr>
	                    												<%-- <tr>
	                    													<td align="right" class="form_label">原指导单位意见</td>
															    			<td align="left"  bgcolor="#ffffff">
	                    														<textarea name="CommentXy" id="CommentXy" cols="40" rows="2"><%=v.getCommentXy()%></textarea>
	                    													</td>
														  				</tr>
	                    												<tr>
	                    													<td align="right" class="form_label">新指导单位意见</td>
															    			<td align="left"  bgcolor="#ffffff">
	                    														<textarea name="CommentXyNew" id="CommentXyNew" cols="40" rows="2"><%=v.getCommentXyNew()%></textarea>
	                    													</td>
														  				</tr>
	                    												<tr>
	                    													<td align="right" class="form_label">团委审核意见</td>
															    			<td align="left"  bgcolor="#ffffff">
	                    														<textarea name="CommentTw" id="CommentTw" cols="40" rows="2"><%=v.getCommentTw()%></textarea>
	                    													</td>
														  				</tr> 
														  				<tr>
	                    													<td align="right" class="form_label">申请人</td>
															    			<td align="left"  bgcolor="#ffffff">
	<%=HtmlTool.renderSelect(UserNameoptions, v.getAddPerson(), "AddPerson", "")%>
	                    													</td>
														  				</tr>
	<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
	                    												<tr>
	                    													<td align="right" class="form_label">修改人</td>
															    			<td align="left"  bgcolor="#ffffff">
	<%=HtmlTool.renderSelect(UserNameoptions, v.getModiPerson(), "ModiPerson", "")%>
	                    													</td>
														  				</tr>
	                    												<tr>
	                    													<td align="right" class="form_label">修改时间</td>
															    			<td align="left"  bgcolor="#ffffff">
	                    														<input name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
	                    													</td>
														  				</tr>
														  				--%>
	<input type="hidden" id="CheckFlag" name="CheckFlag" value="<%=v.getCheckFlag()%>">
	<input type="hidden" name="ApplyDate" value="<%=v.getApplyDate()%>">
	                    												
	                    											</table>
	                    											</div>
	                    											<%
	                    											if (!"".equals(v.getCheckFlag())){
	                    												boolean f = true;
	                    												if(userInfo.hasFunPower(Power.UserAdminPower)){
	                    													if(!(userInfo.getUserCode().getDeptId()+"").equals(v.getClubAcademy())){
	                    														f = false;
	                    													}
	                    												}
	                    												if(f){
	                    											%>
	                    											<div id="tabs-2" style="border: 0px;">
	                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
	                    											<tr>
	                    											<td align="right" class="form_label">原指导单位意见</td>
													    			<td align="left"  bgcolor="#ffffff">
													    			<%=CommentXy %>
                   														<textarea  style="width: 100%;<%=diszd %>" name="CommentXy" id="CommentXy" cols="40" rows="2"><%=v.getCommentXy()%></textarea>
                   													</td>
	                    											</tr>
	                    											</table>
	                    											</div>
	                    											<%
	                    											}else{%>
	                    												<input type="hidden" name="CommentXy" id="CommentXy" value="<%=v.getCommentXy()%>"/>
	                    											<%}
	                    												}else{%>
	                    												<input type="hidden" name="CommentXy" id="CommentXy" value="<%=v.getCommentXy()%>"/>
	                    											<%} %>
	                    											<%
	                    											if (!"".equals(v.getCheckFlag())){
	                    												boolean f = true;
	                    												if(userInfo.hasFunPower(Power.UserAdminPower)){
	                    													if(!(userInfo.getUserCode().getDeptId()+"").equals(v.getClubAcadeMyNew())){
	                    														f = false;
	                    													}
	                    												}
	                    												if(f){
	                    											%>
	                    											<div id="tabs-3" style="border: 0px;">
	                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
	                    											<tr>
	                    											<td align="right" class="form_label">新指导单位意见</td>
													    			<td align="left"  bgcolor="#ffffff">
													    			<%=CommentXyNew %>
                   														<textarea style="width: 100%;<%=diszd %>" name="CommentXyNew" id="CommentXyNew" cols="40" rows="2"><%=v.getCommentXyNew()%></textarea>
                   													</td>
	                    											</tr>
	                    											</table>
	                    											</div>
	                    											<%	}else{%>
	                    												<input type="hidden" name="CommentXyNew" id="CommentXyNew" value="<%=v.getCommentXyNew()%>"/>
	                    											<%
	                    												}
	                    											}else{%>
	                    												<input type="hidden" name="CommentXyNew" id="CommentXyNew" value="<%=v.getCommentXyNew()%>"/>
	                    											<%} %>
	                    											<%
	                    											if(userInfo.hasFunPower(Power.STUSER)||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST))
	                    											if (!"".equals(v.getCheckFlag())){
	                    											%>
	                    											<div id="tabs-4" style="border: 0px;">
	                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
	                    											<tr>
	                    											<td align="right" class="form_label">团委意见</td>
													    			<td align="left"  bgcolor="#ffffff">
													    			<%=CommentTw %>
                   														<textarea style="width: 100%;<%=distw %>" name="CommentTw" id="CommentTw" cols="40" rows="2"><%=v.getCommentTw()%></textarea>
                   													</td>
	                    											</tr>
	                    											</table>
	                    											</div>
	                    											<%}else{%>
	                    												<input type="hidden" name="CommentTw" id="CommentTw" value="<%=v.getCommentTw()%>"/>
	                    											<%} %>
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
