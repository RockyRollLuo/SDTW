<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--部门信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(BaseDeptCode.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	BaseDeptCode v = (BaseDeptCode)request.getAttribute("fromBean");
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
List OrgNameoptions = (List)request.getAttribute("OrgNameoptions");
List DeptNameoptions = (List)request.getAttribute("DeptNameoptions");
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
				<div class="browsetitle001">部门信息</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("部门信息") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="BaseDeptCodeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">所属单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(OrgNameoptions, "" + v.getOrgId(), "OrgId", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">上级部门</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(DeptNameoptions, "" + v.getPid(), "Pid", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Name" id="Name" cols="40" rows="2"><%=v.getName()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门领导</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Leaders" id="Leaders" cols="40" rows="2"><%=v.getLeaders()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门类型</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Style" id="Style" size="1" maxsize="1" value="<%=v.getStyle()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Code" id="Code" size="50" maxsize="50" value="<%=v.getCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Orderby" id="Orderby" value="<%=v.getOrderby()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">上级主管部门</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ReptDept" id="ReptDept" size="50" maxsize="50" value="<%=v.getReptDept()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Address" id="Address" cols="40" rows="2"><%=v.getAddress()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">邮政编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PostCode" id="PostCode" size="50" maxsize="50" value="<%=v.getPostCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Tel" id="Tel" size="50" maxsize="50" value="<%=v.getTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">传真号码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Fax" id="Fax" size="50" maxsize="50" value="<%=v.getFax()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">部门邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email" id="Email" size="50" maxsize="50" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Remark" id="Remark" cols="40" rows="2"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">Enable</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Enable" id="Enable" value="<%=v.getEnable()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
