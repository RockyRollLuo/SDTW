<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社会实践项目团委立项表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
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
	PracticeUtil util = new PracticeUtil();
	List CheckTypeOptions = util.getCheckTypeOptions();
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
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<style>
		#form td {padding: 2px;}
		</style>
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
			function Jump(f){
				if (f==2) {
					$('#commentFrame-'+f).attr("src","AcademyMoneyNums.jsp?_Remark_=<%=v.getId()%>") 
				}
				if (f==3) {
					$('#commentFrame-'+f).attr("src","PracticeReportAction.jsp?_DeclareId_=<%=v.getId()%>") 
				}
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社会实践项目团委立项表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社会实践项目团委立项表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="PracticeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%
						if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHSJ)) {
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) alert('保存成功！');document.postForm.submit();">保存</a></li>
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
				<%=Tool.join("\n", forms)%>
                    											<div id="tabs-1" style="border: 0px; padding: 0px;height: 100%" >
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
<input type="hidden" name="PracticeCode" id="PracticeCode" size="45" maxsize="45" value="<%=v.getPracticeCode()%>">
<input type="hidden" name="Addtime" id="Addtime" size="45" maxsize="45" value="<%="save".equals(cmd)?Tool.stringOfDateTime(new Date()):v.getAddtime()%>">
<input type="hidden" name="AddAccount" id="AddAccount" size="45" maxsize="45" value="<%="save".equals(cmd)?userInfo.getId():v.getAddAccount()%>">
<input type="hidden" name="AddUserrole" id="AddUserrole" size="45" maxsize="45" value="<%="save".equals(cmd)?userInfo.getUserCode().getRoles():v.getAddUserrole()%>">
<input type="hidden" name="AddAcademy" id="AddAcademy" size="45" maxsize="45" value="<%="save".equals(cmd)?userInfo.getUserCode().getDeptId():v.getAddAcademy()%>">
                    												<tr>
                    													<td align="right" class="form_label">项目名</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="PracticeName" id="PracticeName" size="45" maxsize="45" value="<%=v.getPracticeName()%>">
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">项目开始时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%-- <input name="Starttime" id="Starttime" size="45" maxsize="45" value="<%=v.getStarttime()%>"> --%>
                    														<input class="date" name="Starttime" id="Starttime" onfocus="WdatePicker({el:'Starttime',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  size="0" value="<%="save".equals(cmd)?"":Tool.stringOfDate(Tool.stringToDateTime(v.getStarttime()))%>"/>
                    													</td>
													  				
                    													<td align="right" class="form_label">项目结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%-- <input name="Endtime" id="Endtime" size="45" maxsize="45" value="<%=v.getEndtime()%>"> --%>
                    														<input class="date" name="Endtime"  id="Endtime" size="0" value="<%="save".equals(cmd)?"":Tool.stringOfDate(Tool.stringToDateTime(v.getEndtime()))%>" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'Starttime\')}',onpicked:function(){}})" >
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目实践主题</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="PracticeSubject" id="PracticeSubject" cols="150" rows="3"><%=v.getPracticeSubject()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">经费资助</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="Funding" id="Funding" cols="150" rows="3"><%=v.getFunding()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队组织要求</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="TeamDemand" id="TeamDemand" cols="150" rows="3"><%=v.getTeamDemand()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">立项程序及日程</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="Schedule" id="Schedule" cols="150" rows="3"><%=v.getSchedule()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">工作要求</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="WorkDemand" id="WorkDemand" cols="150" rows="3"><%=v.getWorkDemand()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他说明</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea name="OtherExplain" id="OtherExplain" cols="150" rows="3"><%=v.getOtherExplain()%></textarea>
                    													</td>
													  				</tr>
                    												
                    												<input type="hidden" id="AddFilelist" name="AddFilelist" value="<%=v.getAddFilelist()%>"/>
                    											</table>
                    											</div>
                    											<!-- <div id="tabs-2" style="border: 0px; padding: 0px;background: #e3e5e8;height: 100%;" >
												         			报名经费
												         			<iframe  class="commentFrame-2" name="commentFrame-2" id="commentFrame-2" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
												         		</div> -->
												         		<!-- <div id="tabs-3" style="border: 0px; padding: 0px;background: #e3e5e8" >
												         			报名审核
												         			<iframe  class="commentFrame-3" name="commentFrame-3" id="commentFrame-3" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="600px"></iframe>
												         		</div> -->
												         		<!-- <div id="tabs-4" style="border: 0px; padding: 0px;background: #e3e5e8" >
												         			结题审核
												         			<iframe  class="commentFrame-4" name="commentFrame-4" id="commentFrame-4" frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
												         		</div> -->
			</form>
		</div>
		<!-- <script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', 0); 
	});
	</script> -->
	</body>
</html>
