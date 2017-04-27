<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--用户表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(UserAccounts.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	UserAccounts v = (UserAccounts)request.getAttribute("fromBean");
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
List OrgCityNameoptions = (List)request.getAttribute("OrgCityNameoptions");
List sexoptions = (List)request.getAttribute("sexoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List RoleNameoptions = (List)request.getAttribute("RoleNameoptions");
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
				<div class="browsetitle001">用户表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("用户表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="UserAccountsAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    														<input name="UserAccount" id="UserAccount" value="<%=v.getUserAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">密码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PassWord" id="PassWord" size="45" maxsize="45" value="<%=v.getPassWord()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">真实姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TrueName" id="TrueName" size="45" maxsize="45" value="<%=v.getTrueName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, v.getSex(), "Sex", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">昵称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="NickName" id="NickName" size="45" maxsize="45" value="<%=v.getNickName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户角色</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(RoleNameoptions, v.getUserRole(), "UserRole", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户分组</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UserGroupList" id="UserGroupList" size="45" maxsize="45" value="<%=v.getUserGroupList()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">账号状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AccountState" id="AccountState" size="45" maxsize="45" value="<%=v.getAccountState()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">工作单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="WorkUnit" id="WorkUnit" size="45" maxsize="45" value="<%=v.getWorkUnit()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">最后登录ip</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MyLastLoginIp" id="MyLastLoginIp" size="45" maxsize="45" value="<%=v.getMyLastLoginIp()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="MyLastLoginTime" value="<%=v.getMyLastLoginTime()%>">
                    												<tr>
                    													<td align="right" class="form_label">生日</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Birthday" id="Birthday" size="0" value="<%=Tool.stringOfDateTime(v.getBirthday())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email" id="Email" size="45" maxsize="45" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Mobiltel" id="Mobiltel" size="45" maxsize="45" value="<%=v.getMobiltel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">家庭地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="HomeAddress" id="HomeAddress" size="45" maxsize="45" value="<%=v.getHomeAddress()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">家庭电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="HomeTel" id="HomeTel" size="45" maxsize="45" value="<%=v.getHomeTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OfficeTel" id="OfficeTel" size="45" maxsize="45" value="<%=v.getOfficeTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">传真</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Fax" id="Fax" size="45" maxsize="45" value="<%=v.getFax()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">办公地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OfficeAddress" id="OfficeAddress" size="45" maxsize="45" value="<%=v.getOfficeAddress()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">问题1</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Question1" id="Question1" size="45" maxsize="45" value="<%=v.getQuestion1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">回答1</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Answer1" id="Answer1" size="45" maxsize="45" value="<%=v.getAnswer1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">城市</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(OrgCityNameoptions, v.getCity(), "City", "")%>
                    													</td>
													  				</tr>
<input type="hidden" name="Addperson" value="<%=v.getAddperson()%>">
<input type="hidden" name="Addtime" value="<%=v.getAddtime()%>">
                    											</table>
			</form>
		</div>
	</body>
</html>
