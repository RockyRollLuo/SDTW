<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--创新创业竞赛管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(InnovationCompetition.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	InnovationCompetition v = (InnovationCompetition)request.getAttribute("fromBean");
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
List DeclarerRoleTypeoptions = (List)request.getAttribute("DeclarerRoleTypeoptions");
List ProductionTypeoptions = (List)request.getAttribute("ProductionTypeoptions");
List Auditoptions = (List)request.getAttribute("Auditoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
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
				<div class="browsetitle001">创新创业竞赛管理</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("创新创业竞赛管理") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="InnovationCompetitionAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">作品编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProductionCode" id="ProductionCode" size="20" maxsize="20" value="<%=v.getProductionCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">作品名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ProductionName" id="ProductionName" cols="40" rows="2"><%=v.getProductionName()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院全称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申报者姓名（集体名称）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declarer" id="Declarer" size="45" maxsize="45" value="<%=v.getDeclarer()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">作品类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ProductionTypeoptions, v.getProductionType(), "ProductionType", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申报类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(DeclarerRoleTypeoptions, v.getDeclarerRole(), "DeclarerRole", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Remark" id="Remark" cols="40" rows="2"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加文件列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AddFilelist" id="AddFilelist" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
													  				</tr>
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
<input type="hidden" name="AddPerson" value="<%=v.getAddPerson()%>">
<input type="hidden" name="ModiTime" value="<%=v.getModiTime()%>">
<input type="hidden" name="ModiPerson" value="<%=v.getModiPerson()%>">
                    												<tr>
                    													<td align="right" class="form_label">学院意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CheckCommentXy" id="CheckCommentXy" cols="40" rows="2"><%=v.getCheckCommentXy()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CheckCommentTw" id="CheckCommentTw" cols="40" rows="2"><%=v.getCheckCommentTw()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Leader" id="Leader" size="45" maxsize="45" value="<%=v.getLeader()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人ID</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="LeaderId" id="LeaderId" size="45" maxsize="45" value="<%=v.getLeaderId()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="Team" value="<%=v.getTeam()%>">
                    												<tr>
                    													<td align="right" class="form_label">考核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(Auditoptions, "" + v.getCheckFlagXy(), "CheckFlagXy", "0")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">考核人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckPersonXy" id="CheckPersonXy" size="45" maxsize="45" value="<%=v.getCheckPersonXy()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">考核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(Auditoptions, "" + v.getCheckFlagTw(), "CheckFlagTw", "0")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">考核人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckPersonTw" id="CheckPersonTw" size="45" maxsize="45" value="<%=v.getCheckPersonTw()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">奖励荣誉</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Award" id="Award" size="45" maxsize="45" value="<%=v.getAward()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所属项目</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectName" id="ProjectName" size="45" maxsize="45" value="<%=v.getProjectName()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
