<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--团校培训管理资料--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(TrainingParticipate.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	TrainingParticipate v = (TrainingParticipate)request.getAttribute("fromBean");
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
	List UserCnNameOptions = CEditConst.getUserCnNameOptions(userInfo);
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
			<%-- <div class="browsetitleleft">
				<div class="browsetitle001">团校培训管理资料</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("团校培训管理资料") %></div>
			</div> --%>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="TrainingParticipateAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%
						if (v.getAudit()==-1) {//报名审核%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) { $('#Audit').val(1); document.postForm.submit();}">审核不通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) { $('#Audit').val(0); document.postForm.submit();}">审核通过</a></li>
						<%}
						%>
						<%
						if (v.getAudit()==0) {//作业审核%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) { $('#Audit').val(3); document.postForm.submit();}">审核不通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) { $('#Audit').val(2); document.postForm.submit();}">审核通过</a></li>
						<%}
						%>
						<%
						if (v.getAudit()==2) {//结题审核%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) { $('#Audit').val(5); document.postForm.submit();}">审核不通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) { $('#Audit').val(4); document.postForm.submit();}">审核通过</a></li>
						<%}
						%>
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
<input type="hidden" name="ProjectId" id="ProjectId" value="<%=v.getProjectId()%>">
<input type="hidden" name="WorkFileList" id="WorkFileList" value="<%=v.getWorkFileList()%>"/>
<input type="hidden" name="AddFileList" id="AddFileList" value="<%=v.getAddFileList()%>"/>
                    												<tr>
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=v.getSno()%>
                    														<input id="Sno" name="Sno" value="<%=v.getSno()%>" type="hidden"/>
                    													</td>
													  				
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=HtmlTool.renderSelect(UserCnNameOptions,""+v.getSname(),"Sname","",true) %>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">考勤</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="DateRate" id="DateRate" size="45" maxsize="45" value="<%=v.getDateRate()%>">
                    													</td>
													  				</tr>
                    												<tr style="<%=v.getAudit()>=0?"":"display: none;"%>">
                    													<td align="right" class="form_label">作业</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3" >
														    			<%=v.getHomeWork()%>  
                    														<textarea name="HomeWork" id="HomeWork" cols="40" rows="2" style="width: 80%;display: none;"><%=v.getHomeWork()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="<%=v.getAudit()>=0?"":"display: none;"%>">
                    													<td align="right" class="form_label">作业附件</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3" >
                    														<%
																			int caid = v.getId();
																			if (!"".equals(v.getWorkFileList().trim())) {
																				String caids[] = v.getWorkFileList().split(",");
																				for(int i=0;i<caids.length;i++){
																					caid = Tool.StrToInt(caids[i]);
																					ClientAttach ca = new ClientAttach();
																					if (caid!=-1&&ca.getById(caid)!=null) {
																						ca = ca.getById(caid);
																			%>
																		     <a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
																		     <%=ca.getUploadName() %>
																		     </a>
																				<%}
																				}
																			}
																			%>
                    													</td>
													  				</tr>
                    												<tr style="<%=v.getAudit()>=0?"":"display: none;"%>">
                    													<td align="right" class="form_label">作业评价</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3" >
														    			<textarea name="CheckFileEstimate" id="CheckFileEstimate" cols="40" rows="2" style="width: 80%;"><%=v.getCheckFileEstimate()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="<%=v.getAudit()>=1?"":"display: none;"%>">
                    													<td align="right" class="form_label">结题报告</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3" >
														    			<%=v.getCheckReport()%>
                    														<textarea name="CheckReport" id="CheckReport" cols="40" rows="2" style="width: 80%;display: none;"><%=v.getCheckReport()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="<%=v.getAudit()>=1?"":"display: none;"%>">
                    													<td align="right" class="form_label">结题附件</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<%
																			if (!"".equals(v.getAddFileList().trim())) {
																				String caids[] = v.getAddFileList().split(",");
																				for(int i=0;i<caids.length;i++){
																					caid = Tool.StrToInt(caids[i]);
																					ClientAttach ca = new ClientAttach();
																					if (caid!=-1&&ca.getById(caid)!=null) {
																						ca = ca.getById(caid);
																			%>
																		     <a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
																		     <%=ca.getUploadName() %>
																		     </a>
																				<%}
																				}
																			}
                    														%>
                    													</td>
													  				</tr>
                    												<tr style="<%=v.getAudit()>=1?"":"display: none;"%>">
                    													<td align="right" class="form_label">结题报告评价</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3" >
														    			<textarea name="CheckReportEstimate" id="CheckReportEstimate" cols="40" rows="2" style="width: 80%;"><%=v.getCheckReportEstimate()%></textarea>
                    													</td>
													  				</tr>
<input type="hidden" name="CheckId" value="<%=v.getCheckId()%>">
<input type="hidden" id="Audit" name="Audit" value="<%=v.getAudit()%>">
                    											</table>
			</form>
		</div>
	</body>
</html>
