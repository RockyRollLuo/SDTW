<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团活动--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubActivityProject.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubActivityProject v = (ClubActivityProject)request.getAttribute("fromBean");
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
	List cdt = new ArrayList();
	cdt.add("roles="+SdtwConst.USER_TYPE_STU);
	//List UserNameoptions = COptionConst.getUserCnNameOptions(userInfo,"",cdt);
	List RoleNameOptions = CEditConst.getRoleNameOptions(userInfo,"-1");
	//(List)request.getAttribute("UserNameoptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<%-- <link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script> --%>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
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
			/* $(function(){
				$("#ProjectLeader").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				/* $("#Fbzr").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"}); */
			}); */
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团活动立项</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团活动立项") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubActivityProjectAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
<input type="hidden" id="AddPerson" name="AddPerson" value="<%=v.getAddPerson().equals("")?userInfo.getId():v.getAddPerson()%>"/>
<input type="hidden" name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime()).equals("0001-01-01 00:00:00")?Tool.stringOfDateTime(new Date()):Tool.stringOfDateTime(v.getAddTime())%>">
<input type="hidden" name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
<input type="hidden" id="ModiPerson" name="ModiPerson" value="<%=v.getModiPerson()%>"/>
                    												<tr>
                    													<td align="right" class="form_label">项目名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectName" id="ProjectName" size="45" maxsize="45" value="<%=v.getProjectName()%>">
                    													</td>
                    													<td align="right" class="form_label">发布单位</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(RoleNameOptions, v.getProjectUnit(), "ProjectUnit", ""+userInfo.getUserCode().getRoles(),true)%>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%//=HtmlTool.renderSelect(UserNameoptions, v.getProjectLeader(), "ProjectLeader", "")%>
<input id="ProjectLeader" name="ProjectLeader" value="<%=v.getProjectLeader()%>"/>
                    													</td>
                    													<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectId" id="ProjectId" size="45" maxsize="45" value="<%=v.getProjectId()%>">
                    													</td>
													  				</tr>
													  				
													  				<tr>
                    													<td align="right" class="form_label">开始时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input class="date" readonly="readonly"	onfocus="WdatePicker({el:'TimeStart',dateFmt:'yyyy-MM-dd'})"name="TimeStart" id="TimeStart" value="<%=Tool.stringOfDate(Tool.stringToDate(v.getTimeStart()))%>"/>
                    													</td>
													  				
                    													<td align="right" class="form_label">结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input class="date" readonly="readonly"	onfocus="WdatePicker({el:'TimeEnd',dateFmt:'yyyy-MM-dd'})"name="TimeEnd" id="TimeEnd" value="<%=Tool.stringOfDate(Tool.stringToDate(v.getTimeEnd()))%>"/>
                    													</td>
													  				</tr>
													  				
                    												<tr>
                    													<td align="right" class="form_label">项目详情</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="ProjectDetail" id="ProjectDetail" cols="40" rows="2" style="width: 90%;"><%=v.getProjectDetail()%></textarea>
                    													</td>
													  				</tr>
                    												
                    												
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="Remark" id="Remark" cols="40" rows="2" style="width: 90%;"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
