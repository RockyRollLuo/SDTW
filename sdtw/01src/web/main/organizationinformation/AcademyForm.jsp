<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学院表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Academy.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Academy v = (Academy)request.getAttribute("fromBean");
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
List AcademyTypeoptions = (List)request.getAttribute("AcademyTypeoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
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
				<div class="browsetitle001">学院表</div>
				
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="AcademyAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">学院名称</td>
														    			<td align="left"  bgcolor="#ffffff">

<input name="AcademyName" id="AcademyName" size="40" maxsize="40" value="<%=v.getAcademyName()%>">
                    													</td>
                    													<td align="right" class="form_label">学院简称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Academyalias" id="Academyalias" size="40" maxsize="40" value="<%=v.getAcademyalias()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ListOrder" id="ListOrder" value="<%=v.getListOrder()%>">
                    													</td>
                    													<td align="right" class="form_label">添加人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddPerson" id="AddPerson" size="40" maxsize="45" value="<%=v.getAddPerson()%>">
                    													</td>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddTime" id="AddTime" size="45" maxsize="45" value="<%=v.getAddTime()%>">
                    													</td>
                    													<td align="right" class="form_label">修改人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModiPerson" id="ModiPerson" size="45" maxsize="45" value="<%=v.getModiPerson()%>">
                    													</td>
                    													<td align="right" class="form_label">修改时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
                    													</td>
                    													<td align="right" class="form_label">团支部数（班级数）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Leaguecount" id="Leaguecount" size="45" maxsize="45" value="<%=v.getAcadeMySecretary()%>">
                    													</td>
													  				</tr>
                    										
                    												<tr> 
                    												<td align="right" class="form_label">团委书记</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AcadeMySecretary" id="AcadeMySecretary" size="40" maxsize="40" value="<%=v.getAcadeMySecretary()%>">
                    													</td>
                    													<td align="right" class="form_label">团委副书记</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AcadePutySecretary" id="AcadePutySecretary" size="40" maxsize="40" value="<%=v.getAcadePutySecretary()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">组织委员</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AcaorgPerson" id="AcaorgPerson" size="40" maxsize="40" value="<%=v.getAcaorgPerson()%>">
                    													</td>
                    													<td align="right" class="form_label">宣传委员</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Acapublicity" id="Acapublicity" size="40" maxsize="40" value="<%=v.getAcapublicity()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">支部等级</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AcadeMyLevel" id="AcadeMyLevel" size="40" maxsize="40" value="<%=v.getAcadeMyLevel()%>">
                    													</td>
                    													<td align="right" class="form_label">办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AcadeMyPhone" id="AcadeMyPhone" size="40" maxsize="40" value="<%=v.getAcadeMyPhone()%>">
                    													</td>
													  				</tr>
                    												
                    												<tr>
                    													<td align="right" class="form_label">办公地点</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AcadeMyPlace" id="AcadeMyPlace" size="40" maxsize="40" value="<%=v.getAcadeMyPlace()%>">
                    													</td>
                    													<td align="right" class="form_label">办公邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AcadeMyeMail" id="AcadeMyeMail" size="40" maxsize="40" value="<%=v.getAcadeMyeMail()%>">
                    													</td>
													  				</tr>
                    												
                    												<tr  style="display: none;">
                    													<td align="right" class="form_label">54青年表彰提交</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, v.getYouthXyReport(), "YouthXyReport", "")%>
                    													</td>
                    													<td align="right" class="form_label">54青年表彰学院提交时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="YouthXyReportTime" id="YouthXyReportTime" size="0" value="<%=Tool.stringOfDateTime(v.getYouthXyReportTime())%>">
                    													</td>
                    										
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, v.getYouthModifyFlag(), "YouthModifyFlag", "")%>
                    													</td>
                    													<td align="right" class="form_label">54青团表彰修改时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="YouthModifyTime" id="YouthModifyTime" size="0" value="<%=Tool.stringOfDateTime(v.getYouthModifyTime())%>">
                    													</td>
                    														<td align="right" class="form_label">54青年表彰学年</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="YouthSchoolYear" id="YouthSchoolYear" size="45" maxsize="45" value="<%=v.getYouthSchoolYear()%>">
                    													</td>
                    													<td align="right" class="form_label">学院设置54青年表彰周期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="YouthPeriodTime" id="YouthPeriodTime" size="45" maxsize="45" value="<%=v.getYouthPeriodTime()%>">
                    													</td>
                    														<td align="right" class="form_label">标识</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyTypeoptions, v.getFlag(), "Flag", "")%>
                    													</td>
													  				</tr>
                    										
                    											</table>
			</form>
		</div>
	</body>
</html>
