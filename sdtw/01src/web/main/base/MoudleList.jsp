<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%!
	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);
%>
<%
	log.debug("List");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "list");
	StringBuffer str = new StringBuffer();
	List rows = (List)request.getAttribute("List");
	if (rows == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	String url = Tool.join("&", urls);
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	if (pagecontrol == null) {
    		pagecontrol = new PageControl(0, 1, 1);
	}
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	//默认值定义
List MoudleNameoptions = (List)request.getAttribute("MoudleNameoptions");
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css">
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction.js"></script>
		<script>
			var curr_orderby = ["<%=HttpTool.getString(extMaps, "orderfield", "")%>", "<%=HttpTool.getString(extMaps, "ordertype", "")%>"];
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var queryfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("queryfields"))%>"];
			var queryvalues = ["<%=Tool.join("\", \"", (List)request.getAttribute("queryvalues"))%>"];
			var rows = [<%=Tool.join(", ", rows)%>];
			var hidefields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("hidefields"))%>"];
			function init() {
    				showList("<%=request.getAttribute("classname")%>", <%=pagecontrol.getCurrPage()%>, url_para);
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="../jqueryui.jsp" flush="true"/> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr><td colspan="3" height="13"></td></tr>
			<tr> 
				<td width="25">&nbsp;</td>
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
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr1.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.submit();">查询</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr2.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr3.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></td>
      											</tr>
    										</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td  class="cxbj">
											<input type="hidden" name="cmd" value="list">
											<%=Tool.join("\n", forms)%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
													<td>
														<div align="right">上级模块</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(MoudleNameoptions, ParamUtils.getParameter(request,"_Pid_",""), "_Pid_", "")%>
													</td>
													<td>
														<div align="right">模块名称</div>
													</td>
													<td>
														<input name="_Name_" value="<%=ParamUtils.getParameter(request, "_Name_", "")%>">
													</td>
													<td>
														<div align="right">编码</div>
													</td>
													<td>
														<input name="_Code_" value="<%=ParamUtils.getParameter(request, "_Code_", "")%>">
													</td>
												</tr>
											</table>
										</td>
									</tr>
									</form>
									<tr>
    									<td valign="top">
      										<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
        										<tr>
          											<td>
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
											 				<tr>
											    				<td height="3" class="topline"></td>
															</tr>
														</table>
            											<table width="100%" border="0" cellspacing="0" cellpadding="0">
              												<tr><td height="2"></td></tr>
            											</table>
														<div id="list">
														</div>
														<%=(("listall".equals(cmd)))? "": pagecontrol.getControl1((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/images/skin/"+userInfo.getSkinId())%>
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
				<td width="25">&nbsp;</td>
			</tr>
			<tr><td colspan="3" height="13"></td></tr>
		</table>
	</body>
</html>
