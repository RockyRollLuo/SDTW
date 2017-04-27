<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团指导教师--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubTeacher.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubTeacher v = (ClubTeacher)request.getAttribute("fromBean");
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
List PoliticsNameoptions = (List)request.getAttribute("PoliticsNameoptions");
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List NationNameoptions = (List)request.getAttribute("NationNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List sexoptions = (List)request.getAttribute("sexoptions");
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
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
				<div class="browsetitle001">社团指导教师</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团指导教师") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubTeacherAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, v.getClubName(), "ClubName", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团code</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ClubCode" id="ClubCode" size="45" maxsize="45" value="<%=v.getClubCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaName" id="TeaName" size="45" maxsize="45" value="<%=v.getTeaName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, v.getTeaSex(), "TeaSex", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">年龄</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaAge" id="TeaAge" size="45" maxsize="45" value="<%=v.getTeaAge()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">民族</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(NationNameoptions, v.getTeaNation(), "TeaNation", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getTeaPolitics(), "TeaPolitics", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">籍贯</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaBirthplace" id="TeaBirthplace" size="45" maxsize="45" value="<%=v.getTeaBirthplace()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">职位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaDuty" id="TeaDuty" size="45" maxsize="45" value="<%=v.getTeaDuty()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所在学院（部门</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getTeaAcademy(), "TeaAcademy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaTel" id="TeaTel" size="45" maxsize="45" value="<%=v.getTeaTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaPhone" id="TeaPhone" size="45" maxsize="45" value="<%=v.getTeaPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaEmail" id="TeaEmail" size="45" maxsize="45" value="<%=v.getTeaEmail()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">个人情况简介</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="TeaAcademic" id="TeaAcademic" cols="40" rows="2"><%=v.getTeaAcademic()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">commentAcatw</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentAcatw" id="CommentAcatw" cols="40" rows="2"><%=v.getCommentAcatw()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">commentClubunion</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentClubunion" id="CommentClubunion" cols="40" rows="2"><%=v.getCommentClubunion()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委评价</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentTw" id="CommentTw" cols="40" rows="2"><%=v.getCommentTw()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getAddPerson(), "AddPerson", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">修改人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getModiPerson(), "ModiPerson", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">修改时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">开始时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="StartDate" id="StartDate" size="0" value="<%=Tool.stringOfDateTime(v.getStartDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="StopDate" id="StopDate" size="0" value="<%=Tool.stringOfDateTime(v.getStopDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">元老</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Generation" id="Generation" value="<%=v.getGeneration()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">提交申请日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ApplyDate" id="ApplyDate" size="0" value="<%=Tool.stringOfDateTime(v.getApplyDate())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否可用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CommentXy" id="CommentXy" size="45" maxsize="45" value="<%=v.getCommentXy()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
