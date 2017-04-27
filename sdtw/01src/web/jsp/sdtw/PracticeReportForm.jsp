<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社会实践结题书表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(PracticeReport.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	PracticeReport v = (PracticeReport)request.getAttribute("fromBean");
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
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List PracticeReportTeamTypeoptions = (List)request.getAttribute("PracticeReportTeamTypeoptions");
List PracticeReportProjectTypeoptions = (List)request.getAttribute("PracticeReportProjectTypeoptions");
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
				<div class="browsetitle001">社会实践结题书表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社会实践结题书表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="PracticeReportAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">立项表id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DeclareId" id="DeclareId" value="<%=v.getDeclareId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">类别</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Type" id="Type" value="<%=v.getType()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeamId" id="TeamId" size="45" maxsize="45" value="<%=v.getTeamId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">成员id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Memberid" id="Memberid" size="45" maxsize="45" value="<%=v.getMemberid()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="PracticeId" value="<%=v.getPracticeId()%>">
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加文件列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AddFilelist" id="AddFilelist" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院审核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyCheckFlag" id="XyCheckFlag" value="<%=v.getXyCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委审核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TwCheckFlag" id="TwCheckFlag" value="<%=v.getTwCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">提交状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SubmitFlag" id="SubmitFlag" value="<%=v.getSubmitFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院设置荣誉</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyHonour" id="XyHonour" size="45" maxsize="45" value="<%=v.getXyHonour()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report1" id="Report1" size="45" maxsize="45" value="<%=v.getReport1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所属学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getReport2(), "Report2", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">课题名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report3" id="Report3" size="45" maxsize="45" value="<%=v.getReport3()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PracticeReportTeamTypeoptions, v.getReport4(), "Report4", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">实践主题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report5" id="Report5" size="45" maxsize="45" value="<%=v.getReport5()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">立项类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PracticeReportProjectTypeoptions, v.getReport6(), "Report6", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动地点、路线</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report12" id="Report12" size="45" maxsize="45" value="<%=v.getReport12()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">本科学生</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report13" id="Report13" size="45" maxsize="45" value="<%=v.getReport13()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">硕士研究生</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report14" id="Report14" size="45" maxsize="45" value="<%=v.getReport14()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">博士研究生</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report15" id="Report15" size="45" maxsize="45" value="<%=v.getReport15()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动开始时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="StartTime" id="StartTime" size="45" maxsize="45" value="<%=v.getStartTime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="EndTime" id="EndTime" size="45" maxsize="45" value="<%=v.getEndTime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动天数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report17" id="Report17" size="45" maxsize="45" value="<%=v.getReport17()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">接收单位对团队活动的评价</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report18" id="Report18" size="45" maxsize="45" value="<%=v.getReport18()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">回访联系人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Report19" id="Report19" cols="40" rows="2"><%=v.getReport19()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">回访电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report20" id="Report20" size="45" maxsize="45" value="<%=v.getReport20()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">报告题目</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report23" id="Report23" size="45" maxsize="45" value="<%=v.getReport23()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">报告类别</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report24" id="Report24" size="45" maxsize="45" value="<%=v.getReport24()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">报告字数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report25" id="Report25" size="45" maxsize="45" value="<%=v.getReport25()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">对地方经济、社会和文化发展或企业成长的实际作用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Report26" id="Report26" cols="40" rows="2"><%=v.getReport26()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导教师工作总结</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Report27" id="Report27" cols="40" rows="2"><%=v.getReport27()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">主要宣传报道情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Report28" id="Report28" cols="40" rows="2"><%=v.getReport28()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">宣传报道数量</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Report29" id="Report29" size="45" maxsize="45" value="<%=v.getReport29()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">安全工作落实情况总结</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Report30" id="Report30" cols="40" rows="2"><%=v.getReport30()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addaccount" id="Addaccount" size="45" maxsize="45" value="<%=v.getAddaccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addtime" id="Addtime" size="45" maxsize="45" value="<%=v.getAddtime()%>">
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
