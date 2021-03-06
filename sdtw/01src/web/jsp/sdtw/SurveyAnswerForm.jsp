<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--调查问卷回答items--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(SurveyAnswer.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	SurveyAnswer v = (SurveyAnswer)request.getAttribute("fromBean");
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
				<div class="browsetitle001">调查问卷回答items</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("调查问卷回答items") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="SurveyAnswerAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
<font color=red>*</font>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">问卷编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SurveyCode" id="SurveyCode" size="45" maxsize="45" value="<%=v.getSurveyCode()%>">
<font color=red>*</font>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Head_1ID</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Head_1ID" id="Head_1ID" size="45" maxsize="45" value="<%=v.getHead_1ID()%>">
<font color=red>*</font>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Item_ID</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Item_ID" id="Item_ID" size="45" maxsize="45" value="<%=v.getItem_ID()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Item_Type</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Item_Type" id="Item_Type" size="45" maxsize="45" value="<%=v.getItem_Type()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Item_Submition</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Item_Submition" id="Item_Submition" cols="40" rows="2"><%=v.getItem_Submition()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Item_Score</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Item_Score" id="Item_Score" value="<%=v.getItem_Score()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Submit_Time</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Submit_Time" id="Submit_Time" size="0" value="<%=Tool.stringOfDateTime(v.getSubmit_Time())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Submit_Ip</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Submit_Ip" id="Submit_Ip" size="45" maxsize="45" value="<%=v.getSubmit_Ip()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
