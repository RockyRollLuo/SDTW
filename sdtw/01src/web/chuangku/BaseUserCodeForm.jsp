<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--人员管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(BaseUserCode.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	BaseUserCode v = (BaseUserCode)request.getAttribute("fromBean");
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
List DeptNameoptions = (List)request.getAttribute("DeptNameoptions");
List OrgNameoptions = (List)request.getAttribute("OrgNameoptions");
List RoleNameoptions = (List)request.getAttribute("RoleNameoptions");
List sexoptions = (List)request.getAttribute("sexoptions");
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
				<div class="browsetitle001">人员管理</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("人员管理") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="BaseUserCodeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(OrgNameoptions, "" + v.getOrgId(), "OrgId", "-1")%>
                    													</td>
													  				</tr>
<input type="hidden" name="OrgCode" value="<%=v.getOrgCode()%>">
                    												<tr>
                    													<td align="right" class="form_label">部门</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(DeptNameoptions, "" + v.getDeptId(), "DeptId", "-1")%>
                    													</td>
													  				</tr>
<input type="hidden" name="DeptCode" value="<%=v.getDeptCode()%>">
                    												<tr>
                    													<td align="right" class="form_label">用户帐号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Name" id="Name" size="50" maxsize="50" value="<%=v.getName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户显示名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CnName" id="CnName" size="50" maxsize="50" value="<%=v.getCnName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Code" id="Code" size="50" maxsize="50" value="<%=v.getCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, "" + v.getGender(), "Gender", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Occupation" id="Occupation" cols="40" rows="2"><%=v.getOccupation()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户职称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Grade" id="Grade" cols="40" rows="2"><%=v.getGrade()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户所属部门</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Dept" id="Dept" cols="40" rows="2"><%=v.getDept()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Orderby" id="Orderby" value="<%=v.getOrderby()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">主管领导</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Principal" id="Principal" size="50" maxsize="50" value="<%=v.getPrincipal()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PhoneNum" id="PhoneNum" size="50" maxsize="50" value="<%=v.getPhoneNum()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机号码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MobilePhone" id="MobilePhone" size="50" maxsize="50" value="<%=v.getMobilePhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">传真号码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Fax" id="Fax" size="50" maxsize="50" value="<%=v.getFax()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户办公室地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="OfficeAddress" id="OfficeAddress" cols="40" rows="2"><%=v.getOfficeAddress()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">电子邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email" id="Email" size="50" maxsize="50" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="Pwd" value="<%=v.getPwd()%>">
                    												<tr>
                    													<td align="right" class="form_label">家庭地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="HomeAddress" id="HomeAddress" cols="40" rows="2"><%=v.getHomeAddress()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">住址邮编</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="HomeZipcode" id="HomeZipcode" size="12" maxsize="12" value="<%=v.getHomeZipcode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">单位邮编</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DeptZipcode" id="DeptZipcode" size="12" maxsize="12" value="<%=v.getDeptZipcode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户Ip电话(代办改变否)</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UserIpphome" id="UserIpphome" size="50" maxsize="50" value="<%=v.getUserIpphome()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">最后访问时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="LastTime" id="LastTime" size="0" value="<%=Tool.stringOfDateTime(v.getLastTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">皮肤Id号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="SkinId" id="SkinId" cols="40" rows="2"><%=v.getSkinId()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">显示的条数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DispNum" id="DispNum" value="<%=v.getDispNum()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">按字段排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OrderbyField" id="OrderbyField" size="20" maxsize="20" value="<%=v.getOrderbyField()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">排序方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">用户角色</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(RoleNameoptions, v.getRoles(), "Roles", "")%>
                    													</td>
													  				</tr>
<input type="hidden" name="Enable" value="<%=v.getEnable()%>">
                    												<tr>
                    													<td align="right" class="form_label">是否初次登录</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="IsFirstLogon" id="IsFirstLogon" value="<%=v.getIsFirstLogon()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="OperTime" value="<%=v.getOperTime()%>">
                    												<tr>
                    													<td align="right" class="form_label">操作日志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="OperLog" id="OperLog" cols="40" rows="2"><%=v.getOperLog()%></textarea>
                    													</td>
													  				</tr>
<input type="hidden" name="OperUser" value="<%=v.getOperUser()%>">
<input type="hidden" name="LocusCode" value="<%=v.getLocusCode()%>">
<input type="hidden" name="LogonNum" value="<%=v.getLogonNum()%>">
<input type="hidden" name="CurIp" value="<%=v.getCurIp()%>">
                    												<tr>
                    													<td align="right" class="form_label">本次登录时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CurTime" id="CurTime" size="0" value="<%=Tool.stringOfDateTime(v.getCurTime())%>">
                    													</td>
													  				</tr>
<input type="hidden" name="Ip" value="<%=v.getIp()%>">
                    											</table>
			</form>
		</div>
	</body>
</html>
