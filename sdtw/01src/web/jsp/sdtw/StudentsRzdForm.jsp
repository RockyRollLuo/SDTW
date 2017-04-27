<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生素质拓展培养认证单-不用--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(StudentsRzd.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	StudentsRzd v = (StudentsRzd)request.getAttribute("fromBean");
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
				<div class="browsetitle001">学生素质拓展培养认证单-不用</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("学生素质拓展培养认证单-不用") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StudentsRzdAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Reason" id="Reason" cols="40" rows="2"><%=v.getReason()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否提交</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Submitflag" id="Submitflag" value="<%=v.getSubmitflag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">打印编号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Printcode" id="Printcode" size="20" maxsize="20" value="<%=v.getPrintcode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Sno" id="Sno" size="20" maxsize="20" value="<%=v.getSno()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Academy" id="Academy" size="45" maxsize="45" value="<%=v.getAcademy()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">rowspan</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Rownumstr" id="Rownumstr" cols="40" rows="2"><%=v.getRownumstr()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Value1" id="Value1" size="45" maxsize="45" value="<%=v.getValue1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Value2" id="Value2" size="45" maxsize="45" value="<%=v.getValue2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院下分院</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Value3" id="Value3" size="45" maxsize="45" value="<%=v.getValue3()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">专业</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Value4" id="Value4" size="45" maxsize="45" value="<%=v.getValue4()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">年级</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Value5" id="Value5" size="45" maxsize="45" value="<%=v.getValue5()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">主题教育</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray1" id="Listarray1" cols="40" rows="2"><%=v.getListarray1()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">文化艺术</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray2" id="Listarray2" cols="40" rows="2"><%=v.getListarray2()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">体育健康</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray3" id="Listarray3" cols="40" rows="2"><%=v.getListarray3()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">科技创新</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray4" id="Listarray4" cols="40" rows="2"><%=v.getListarray4()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">实践服务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray5" id="Listarray5" cols="40" rows="2"><%=v.getListarray5()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">就业创业</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray6" id="Listarray6" cols="40" rows="2"><%=v.getListarray6()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">志愿服务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray7" id="Listarray7" cols="40" rows="2"><%=v.getListarray7()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社会工作</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray8" id="Listarray8" cols="40" rows="2"><%=v.getListarray8()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团经历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray9" id="Listarray9" cols="40" rows="2"><%=v.getListarray9()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学术论坛</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Listarray10" id="Listarray10" cols="40" rows="2"><%=v.getListarray10()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">0未审核 ，2 未通过 ，1通过</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Checkflag" id="Checkflag" value="<%=v.getCheckflag()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
