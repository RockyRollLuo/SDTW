<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--山大志库--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="ueditor" uri="http://sdxietong.com" %>

<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(VolunteerZhiku.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerZhiku v = (VolunteerZhiku)request.getAttribute("fromBean");
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
	BaseUserCode user=userInfo.getUserCode();
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script language="JavaScript"
			src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
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
			function save(){
				document.postForm.submit()
			}
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">山大志库</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("山大志库") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="VolunteerZhikuAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">通知名称</td>
														    			<td colspan="3" align="left"  bgcolor="#ffffff">
                    														<input name="NoticeName" id="NoticeName" size="25" maxsize="25" value="<%=v.getNoticeName()%>">
                    													</td>
                    													
													  				</tr>
													  				<%if(v.getNoticeName()!=""){ %>
                    												<tr>
                    													<td align="right" class="form_label">开始日期</td>
														    			
                    													<td align="left"  bgcolor="#ffffff">
                    												
                    																<input name="Startdate" value="<%=Tool.stringOfDate(v.getStartdate())%>"
																					onclick="WdatePicker({el:'Startdate'})"
																					id="Startdate" size="0"
																					>
																						<img onclick="WdatePicker({el:'Startdate'})"
																						src="<%=HeadConst.apache_url%>/main/images/datePicker.gif"
																						width="16" height="22" align="absmiddle">
                    													</td>
                    													<td align="right" class="form_label">结束日期</td>
														    			
                    															<td align="left"  bgcolor="#ffffff">
                    												
                    																<input name="Enddate" value="<%=Tool.stringOfDate(v.getEnddate())%>"
																					onclick="WdatePicker({el:'Enddate'})"
																					id="Enddate" size="0"
																					>
																						<img onclick="WdatePicker({el:'Enddate'})"
																						src="<%=HeadConst.apache_url%>/main/images/datePicker.gif"
																						width="16" height="22" align="absmiddle">
                    													</td>
                    													
													  				</tr>
													  				<%}else{ %>
                    											<tr>
                    													<td align="right" class="form_label">开始日期</td>
														    			
                    													<td align="left"  bgcolor="#ffffff">
                    												
                    																<input name="Startdate"
																					onclick="WdatePicker({el:'Startdate'})"
																					id="Startdate" size="0"
																					>
																						<img onclick="WdatePicker({el:'Startdate'})"
																						src="<%=HeadConst.apache_url%>/main/images/datePicker.gif"
																						width="16" height="22" align="absmiddle">
                    													</td>
                    													<td align="right" class="form_label">结束日期</td>
														    			
                    															<td align="left"  bgcolor="#ffffff">
                    												
                    																<input name="Enddate" 
																					onclick="WdatePicker({el:'Enddate'})"
																					id="Enddate" size="0"
																					>
																						<img onclick="WdatePicker({el:'Enddate'})"
																						src="<%=HeadConst.apache_url%>/main/images/datePicker.gif"
																						width="16" height="22" align="absmiddle">
                    													</td>
                    													
													  				</tr>
                    											
                    											<%} %>
                    											
													  					<tr>
                    													<td align="right" class="form_label">通知内容</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<%-- <textarea name="Ck3" id="Ck3" cols="140" rows="10"><%=v.getCk3()%></textarea> --%>
                    														<ueditor:editor autoFloat="false" instanceName="NoticeInfo" basePath="/main/js/ueditor" height="400" width="100%" toolbars="toolbar_base" value="<%=v.getNoticeInfo()%>"></ueditor:editor>
                    													</td>
													  				</tr>
													  				
                    											</table>
			</form>
		</div>
	</body>
</html>
