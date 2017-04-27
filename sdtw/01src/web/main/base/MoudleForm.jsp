<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.db.BaseMoudle"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--模块--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(BaseMoudle.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	BaseMoudle v = (BaseMoudle)request.getAttribute("fromBean");
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
List MoudleOrFunoptions = (List)request.getAttribute("MoudleOrFunoptions");
List MoudleNameoptions = (List)request.getAttribute("MoudleNameoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=HeadConst.apache_url%>/main/js/formfunction.js"></script>
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
		<%-- <jsp:include page="../jqueryui.jsp" flush="true"/> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr> 
				<td valign="top">
					<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#33577B">
  	 					<tr>
      						<td bgcolor="#FFFFFF" valign="top">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td height="26" background="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbj.png">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="26"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanl.gif"></div></td>
                									<td width="100"><b class="bt">[模块]</b></td>
                									<td>&nbsp;</td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                									<td width="55" class="bt"><a href="javascript:if (doValidate('postForm')) document.postForm.submit();"">保存</a></td>
                									<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr4.png"></div></td>
                									<td width="55" class="bt"><a href="MoudleAction.jsp?cmd=tree&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>">返回</a></td>
              									</tr>
            								</table>
										</td>
          							</tr>
          							<tr>
            							<td valign="top"> 
              								<table width="100%" border="0" cellspacing="0" cellpadding="6">
                								<tr>
                  									<td>
														<div id="errorDiv" style="color:red;font-weight:bold"></div>
														<div id="form" style="overflow:auto;height:auto">
															<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
																<input type="hidden" name="cmd" value="<%=cmd%>">
																<input type="hidden" name="page" value="<%=currpage%>">
																<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      												<tr>
                        												<td height="2"></td>
                      												</tr>
                    											</table>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#D2D2D2">
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">上级模块</td>
														    			<td bgcolor="#FFFFFF" align="left">
<%=HtmlTool.renderSelect(MoudleNameoptions, "" + v.getPid(), "Pid", "-1")%>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td bgcolor="#FFFFFF" align="right">模块名称</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input type="text" name="Name" value="<%=v.getName()%>"><font color="red">*</font>
                    													</td>
													  				</tr>	
													  				<%
													  					if(cmd.equals("update")){%>
													  					<tr>
                    													<td bgcolor="#FFFFFF" align="right">编码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input type="text" name="Code" value="<%=v.getCode()%>"readonly/><font color="red">*不可改动</font>
                    													</td>
													  				</tr>
													  					<% }%>
													  				
                    												
                    												
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">级别</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="MoudleGrade" value="<%=v.getMoudleGrade()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">类型</td>
														    			<td bgcolor="#FFFFFF" align="left">
<%=HtmlTool.renderSelect(MoudleOrFunoptions, "" + v.getMoudleType(), "MoudleType", "-1")%>
                    													</td>
													  				</tr>
													  				<tr style="display:none;">
                    													<td bgcolor="#FFFFFF" align="right">部门模块</td>
														    			<td bgcolor="#FFFFFF" align="left">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsDept(), "IsDept", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">连接Url</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input type="text" name="ToUrl" value="<%=v.getToUrl()%>" size="60">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">排序</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="OrderNum" value="<%=v.getOrderNum()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">是否可用</td>
														    			<td bgcolor="#FFFFFF" align="left">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "-1")%>
                    													</td>
													  				</tr>
                    												
                    														<input type="hidden" name="OpLog" value="<%=v.getOpLog()%>">
                    													
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
