<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--校园文化活动报名-学生素质拓展培养认证单--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(CampusParticipate.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	CampusParticipate v = (CampusParticipate)request.getAttribute("fromBean");
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
				<div class="browsetitle001">校园文化活动报名-学生素质拓展培养认证单</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("校园文化活动报名-学生素质拓展培养认证单") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="CampusParticipateAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">校园文化活动Id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CampusActivityId" id="CampusActivityId" size="10" maxsize="10" value="<%=v.getCampusActivityId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="StudentNo" id="StudentNo" size="40" maxsize="40" value="<%=v.getStudentNo()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getStudentAcademy(), "StudentAcademy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="StudentName" id="StudentName" size="50" maxsize="50" value="<%=v.getStudentName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ApplyTime" id="ApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getApplyTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">最后一轮</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="FinalRounds" id="FinalRounds" value="<%=v.getFinalRounds()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">荣誉</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Honor" id="Honor" size="45" maxsize="45" value="<%=v.getHonor()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
