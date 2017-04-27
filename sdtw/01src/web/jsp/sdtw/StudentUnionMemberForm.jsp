<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生会部门成员--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(StudentUnionMember.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	StudentUnionMember v = (StudentUnionMember)request.getAttribute("fromBean");
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
List StuDeptNameoptions = (List)request.getAttribute("StuDeptNameoptions");
List OrgNameoptions = (List)request.getAttribute("OrgNameoptions");
List StuDutyoptions = (List)request.getAttribute("StuDutyoptions");
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
				<div class="browsetitle001">学生会部门成员</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("学生会部门成员") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StudentUnionMemberAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">校级院级学生会id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Unionid" id="Unionid" value="<%=v.getUnionid()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门学生会id</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(StuDeptNameoptions, "" + v.getDeptid(), "Deptid", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">院级或部门级学生会</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UnionorDept" id="UnionorDept" size="45" maxsize="45" value="<%=v.getUnionorDept()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SNo" id="SNo" size="45" maxsize="45" value="<%=v.getSNo()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">校区</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(OrgNameoptions, v.getCampus(), "Campus", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">主要部门</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(StuDeptNameoptions, v.getChargeDept(), "ChargeDept", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Phone" id="Phone" size="45" maxsize="45" value="<%=v.getPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">职位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(StuDutyoptions, v.getDuty(), "Duty", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark" id="Remark" size="45" maxsize="45" value="<%=v.getRemark()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学年</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SchoolYear" id="SchoolYear" size="45" maxsize="45" value="<%=v.getSchoolYear()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
