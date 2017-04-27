<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.db.BaseRoleCode"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java"%>
<%--角色表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(BaseRoleCode.class);
	String msg = (String) request.getAttribute("msg");
	if ((msg != null)) {
		out.print(HtmlTool.msgBox(request, msg));
		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	BaseRoleCode v = (BaseRoleCode) request.getAttribute("fromBean");
	if (v == null) {
		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[]) request.getAttribute("dickeys");
	String[][] dicvalues = (String[][]) request
			.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i++) {
		diclist.add("\"" + dickeys[i] + "\": [\""
				+ Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	Map extMaps = (Map) request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List) paras.get(0);
	List forms = (List) paras.get(1);
	urls.addAll((List) paras.get(2));
	forms.addAll((List) paras.get(3));
	String url = Tool.join("&", urls);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if (userInfo == null) {
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
	}
	List YesNooptions = (List) request.getAttribute("YesNooptions");
	String names = (String) request.getAttribute("names");
	String funNames = (String) request.getAttribute("funNames");
%>
<head>
<title><%=request.getAttribute("describe")%></title>
<link rel="stylesheet" type="text/css"
	href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css">
	<script language="JavaScript"
		src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
	<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
	<script src="<%=HeadConst.apache_url%>/main/js/formfunction.js"></script>
	<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
	<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String) request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"",
					(String[]) request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"",
					(String[]) request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
			}
			function choiceMoudlePower(flag){
				//alert("a");
				if(flag==0){
					openWindow("MoudleAction.jsp?cmd=treeSelect&flag="+flag+"&ids=<%=v.getMoudleIds()%>","350,350");
				}else{
					openWindow("MoudleAction.jsp?cmd=treeSelect&flag="+flag+"&ids=<%=v.getFunIds()%>","350,350");
				}
				return false;
			}
		</script>
</head>
<body onload="init();">
	<%-- <jsp:include page="../jqueryui.jsp" flush="true" /> --%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="top">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					bgcolor="#33577B">
					<tr>
						<td bgcolor="#FFFFFF" valign="top">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="26"
										background="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbj.png">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="26"><div align="center">
														<img
															src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanl.gif">
													</div></td>
												<td width="100"><b class="bt">[角色表]</b></td>
												<td>&nbsp;</td>
												<td width="24"><div align="center">
														<img
															src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png">
													</div></td>
												<td width="55" class="bt"><a
													href="javascript:if (doValidate('postForm')) document.postForm.submit();"">保存</a></td>
												<td width="24"><div align="center">
														<img
															src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr4.png">
													</div></td>
												<td width="55" class="bt"><a
													href="RoleCodeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>">返回</a></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td valign="top">
										<table width="100%" border="0" cellspacing="0" cellpadding="6">
											<tr>
												<td>
													<div id="errorDiv" style="color: red; font-weight: bold"></div>
													<div id="form" style="overflow: auto; height: auto">
														<form	action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
															<input type="hidden" name="cmd" value="<%=cmd%>">
															<input type="hidden" name="page" value="<%=currpage%>">
															<input type="hidden" name="Id" value="<%=v.getId()%>">
															<input type="hidden" name="OrderNum" value="<%=v.getOrderNum()%>">
															<input type="hidden" name="OpLog" value="<%=v.getOpLog()%>">
															<%=Tool.join("\n", forms)%>
															<table width="100%" border="0" cellspacing="0" cellpadding="0">
																<tr>
																	<td height="2"></td>
																</tr>
															</table>
															<table border="0" width="100%" cellspacing="0">
																<tr id="postFormName">
																	<td>
																		<div align="right">角色名</div>
																	</td>
																	<td><input type="text" name="Name"
																		value="<%=v.getName()%>" /><font color="red"><b>*</b></font>
																	</td>
																</tr>
																<tr id="postFormCode">
																	<td>
																		<div align="right">角色代码</div>
																	</td>
																	<td><input type="text" name="Code"
																		value="<%=v.getCode()%>" /><font color="red"><b>*</b></font>
																	</td>
																</tr>
																<tr id="postFormMoudleIds">
																	<td>
																		<div align="right">模块权限</div>
																	</td>
																	<td>
																	<textarea name="MoudleNames" cols="50" rows="4"><%=names.equals("null") ? "" : names%></textarea>
																	  <button style="height:25px;width:110px;" type="button" onclick="javascript:choiceMoudlePower(0);" >模块权限定义</button>
																	  <input type="hidden" name="MoudleIds" value="<%=v.getMoudleIds()%>" />
																	</td>
																</tr>
																<tr id="postFormMoudleCode">
																	<td>
																		<div align="right">模块权限代码</div>
																	</td>
																	<td><textarea name="MoudleCode" cols="50" rows="4"><%=v.getMoudleCode()%></textarea>
																	</td>
																</tr>
																<tr id="postFormFunIds">
																	<td>
																		<div align="right">功能点权限</div>
																	</td>
																	<td><textarea name="FunNames" cols="50" rows="4"><%=funNames.equals("null") ? "" : funNames%></textarea>
																	<button style="height:25px;width:120px;" type="button" onclick="javascript:choiceMoudlePower(1);">功能点权限定义</button>
																	<input type="hidden" name="FunIds" value="<%=v.getFunIds()%>">
																	</td>
																</tr>
																<tr id="postFormFunCodes">
																	<td>
																		<div align="right">功能点权限代码</div>
																	</td>
																	<td><textarea name="FunCodes" cols="50" rows="4"><%=v.getFunCodes()%></textarea>
																	</td>
																</tr>
																<tr id="postFormIsEnable">
																	<td>
																		<div align="right">有效标志</div>
																	</td>
																	<td><%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "-1")%>
																	</td>
																</tr>
															</table>
														</form>
													</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
