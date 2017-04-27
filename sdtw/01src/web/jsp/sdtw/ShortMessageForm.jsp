<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--站内信--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ShortMessage.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ShortMessage v = (ShortMessage)request.getAttribute("fromBean");
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
List MsgGradeoptions = (List)request.getAttribute("MsgGradeoptions");
List MsgPropoptions = (List)request.getAttribute("MsgPropoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
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
				<div class="browsetitle001">站内信</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("站内信") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ShortMessageAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">短消息发送时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SendDate" id="SendDate" size="0" value="<%=Tool.stringOfDateTime(v.getSendDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">短消息标题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Subject" id="Subject" cols="40" rows="2"><%=v.getSubject()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">短消息级别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(MsgGradeoptions, "" + v.getMsgGrade(), "MsgGrade", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">发送人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, "" + v.getSendId(), "SendId", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">接受人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ReceiveIds" id="ReceiveIds" cols="40" rows="2"><%=v.getReceiveIds()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否查看</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIfSee(), "IfSee", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否回执</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getReceipt(), "Receipt", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">短消息收藏时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CollectDate" id="CollectDate" size="0" value="<%=Tool.stringOfDateTime(v.getCollectDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">短消息保存时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SaveDate" id="SaveDate" size="0" value="<%=Tool.stringOfDateTime(v.getSaveDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">短消息级别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(MsgPropoptions, "" + v.getSmsStyle(), "SmsStyle", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">相关附件ids</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAttachIds()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">跳转地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="RemUrl" id="RemUrl" cols="40" rows="2"><%=v.getRemUrl()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">RemindSys</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否可用</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "-1")%>
                    													</td>
													  				</tr>
<input type="hidden" name="RemindType" value="<%=v.getRemindType()%>">
                    											</table>
			</form>
		</div>
	</body>
</html>
