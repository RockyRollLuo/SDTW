<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--山大志库--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(VolunteerZhikuDecalre.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerZhikuDecalre v = (VolunteerZhikuDecalre)request.getAttribute("fromBean");
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
				<div class="browsetitle001">山大志库</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("山大志库") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="VolunteerZhikuDecalreAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
<input type="hidden" name="ZhikuId" value="<%=v.getZhikuId()%>">
<input type="hidden" name="AddAccount" value="<%=v.getAddAccount()%>">
<input type="hidden" name="Addtime" value="<%=v.getAddtime()%>">
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													</td>
													  				</tr>
<input type="hidden" name="Checkflag" value="<%=v.getCheckflag()%>">
<input type="hidden" name="Addfilelist" value="<%=v.getAddfilelist()%>">
                    												<tr>
                    													<td align="right" class="form_label">项目名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Name" id="Name" size="45" maxsize="45" value="<%=v.getName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Teamname" id="Teamname" size="45" maxsize="45" value="<%=v.getTeamname()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所属单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Unit" id="Unit" size="45" maxsize="45" value="<%=v.getUnit()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目分组</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目活动背景及目的</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Intention" id="Intention" cols="40" rows="2"><%=v.getIntention()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动流程</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Arrange" id="Arrange" cols="40" rows="2"><%=v.getArrange()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">预期成果</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Process" id="Process" cols="40" rows="2"><%=v.getProcess()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">预期成果</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Expectresults" id="Expectresults" cols="40" rows="2"><%=v.getExpectresults()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">已取得成果</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Results" id="Results" cols="40" rows="2"><%=v.getResults()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（项目情况）交通费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cost1" id="Cost1" size="45" maxsize="45" value="<%=v.getCost1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（项目情况）住宿费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cost2" id="Cost2" size="45" maxsize="45" value="<%=v.getCost2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（项目情况）其他1</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cost3" id="Cost3" size="45" maxsize="45" value="<%=v.getCost3()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（项目情况）其他2</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cost4" id="Cost4" size="45" maxsize="45" value="<%=v.getCost4()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（项目情况）其他3</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cost5" id="Cost5" size="45" maxsize="45" value="<%=v.getCost5()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（项目情况）其他4</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cost6" id="Cost6" size="45" maxsize="45" value="<%=v.getCost6()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（项目情况）总计</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Totalcost" id="Totalcost" size="45" maxsize="45" value="<%=v.getTotalcost()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
