<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社会实践项目团委立项表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Practice.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Practice v = (Practice)request.getAttribute("fromBean");
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
				<div class="browsetitle001">社会实践项目团委立项表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社会实践项目团委立项表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="PracticeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">项目编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PracticeCode" id="PracticeCode" size="45" maxsize="45" value="<%=v.getPracticeCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PracticeName" id="PracticeName" size="45" maxsize="45" value="<%=v.getPracticeName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目实践主题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="PracticeSubject" id="PracticeSubject" cols="40" rows="2"><%=v.getPracticeSubject()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目开始实践</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Starttime" id="Starttime" size="45" maxsize="45" value="<%=v.getStarttime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Endtime" id="Endtime" size="45" maxsize="45" value="<%=v.getEndtime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">经费资助</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Funding" id="Funding" cols="40" rows="2"><%=v.getFunding()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队组织要求</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="TeamDemand" id="TeamDemand" cols="40" rows="2"><%=v.getTeamDemand()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">立项程序及日程</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Schedule" id="Schedule" cols="40" rows="2"><%=v.getSchedule()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">工作要求</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="WorkDemand" id="WorkDemand" cols="40" rows="2"><%=v.getWorkDemand()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他说明</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="OtherExplain" id="OtherExplain" cols="40" rows="2"><%=v.getOtherExplain()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addtime" id="Addtime" size="45" maxsize="45" value="<%=v.getAddtime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加用户名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddAccount" id="AddAccount" size="45" maxsize="45" value="<%=v.getAddAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加用户编号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddUserrole" id="AddUserrole" size="45" maxsize="45" value="<%=v.getAddUserrole()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddAcademy" id="AddAcademy" size="45" maxsize="45" value="<%=v.getAddAcademy()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加文件列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AddFilelist" id="AddFilelist" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark" id="Remark" size="45" maxsize="45" value="<%=v.getRemark()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark2" id="Remark2" size="45" maxsize="45" value="<%=v.getRemark2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark3" id="Remark3" size="45" maxsize="45" value="<%=v.getRemark3()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark4" id="Remark4" size="45" maxsize="45" value="<%=v.getRemark4()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark5" id="Remark5" size="45" maxsize="45" value="<%=v.getRemark5()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark6" id="Remark6" size="45" maxsize="45" value="<%=v.getRemark6()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
