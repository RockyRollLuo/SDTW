<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--团支部达标升级文件--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(StandardupGrade.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	StandardupGrade v = (StandardupGrade)request.getAttribute("fromBean");
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
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="../../main/js/ajaxfileupload.js"></script>
		<script language="JavaScript" src="js/upload.js"></script>
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
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">团支部达标升级文件</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("团支部达标升级文件") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StandardupGradeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%
						if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)) {
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden" name="Addtime" id="Addtime" size="0" value="<%="save".equals(cmd)?new Date():Tool.stringOfDateTime(v.getAddtime())%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td align="right" class="form_label">名称</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="StandardUpGradeName" id="StandardUpGradeName" size="45" maxsize="45" value="<%=v.getStandardUpGradeName()%>">
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">发布单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														山东大学
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">简介</td>
														    			<td align="left"  bgcolor="#ffffff" >
                    														
<textarea name="Desc1" id="Desc1" cols="100" rows="3"><%=v.getDesc1()%></textarea>
                    														<%-- <ueditor:editor autoFloat="false" instanceName="Describe" basePath="/main/js/ueditor" height="100" width="100%" toolbars="toolbar_base" value="<%=v.getDescribe()%>"></ueditor:editor> --%>	
                    													</td>
													  				</tr>
                    												
													  				<input type="hidden" id="Addfilelist" name="Addfilelist" value="<%=v.getAddfilelist()%>"/>
													  				<input type="hidden" name="Principal" id="Principal" size="45" maxsize="45" value="<%="save".equals(cmd)?userInfo.getId():v.getPrincipal()%>">
													  				<tr id="ClientAttach">
													  				<td align="right" class="form_label">附件</td>
													  				<td bgcolor="#ffffff" align="left">
																	<table width="100%" border="0" cellspacing="0" id="ShowFiles">
																				<%
																				int caid = -1;
																				if (!"".equals(v.getAddfilelist().trim())) {
																					String caids[] = v.getAddfilelist().split(",");
																					for(int i=0;i<caids.length;i++){
																						caid = Tool.StrToInt(caids[i]);
																						ClientAttach ca = new ClientAttach();
																						//社团校外活动会长（带队队长）承诺书
																						if (caid!=-1&&ca.getById(caid)!=null) {
																							ca = ca.getById(caid);
																				%>
																			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
																				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
																				<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
																				</tr>
																					<%}
																					}
																				}
																				%>
																	</table>
																	<%
																	//if(v.getCheckFlag()!=1){%>
																	<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
																	<input type="button" value="上传" id="btn_up"  onclick="checkFileType(6,'StandardupGrade');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
																	<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
																	<%//}
																	%>
																    <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div>
																</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
