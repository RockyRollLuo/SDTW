<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--通讯录成员信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(AddBookPerson.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	AddBookPerson v = (AddBookPerson)request.getAttribute("fromBean");
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
				<div class="browsetitle001">通讯录成员信息</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("通讯录成员信息") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="AddBookPersonAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UserAccount" id="UserAccount" size="45" maxsize="45" value="<%=v.getUserAccount()%>">
<font color=red>*</font>
                    													</td>
													  				</tr>
<input type="hidden" name="Groupid" value="<%=v.getGroupid()%>">
                    												<tr>
                    													<td align="right" class="form_label">成员数目</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MyNums" id="MyNums" size="45" maxsize="45" value="<%=v.getMyNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PersonName" id="PersonName" size="45" maxsize="45" value="<%=v.getPersonName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PersonAccount" id="PersonAccount" size="45" maxsize="45" value="<%=v.getPersonAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PersonId" id="PersonId" size="45" maxsize="45" value="<%=v.getPersonId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">工作单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="WorkDepartment" id="WorkDepartment" size="45" maxsize="45" value="<%=v.getWorkDepartment()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OfficeTel" id="OfficeTel" size="45" maxsize="45" value="<%=v.getOfficeTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MobileTel" id="MobileTel" size="45" maxsize="45" value="<%=v.getMobileTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">家庭电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="HomeTel" id="HomeTel" size="45" maxsize="45" value="<%=v.getHomeTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email" id="Email" size="45" maxsize="45" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他信息</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OthersInfo" id="OthersInfo" size="45" maxsize="45" value="<%=v.getOthersInfo()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
                    											</table>
			</form>
		</div>
	</body>
</html>
