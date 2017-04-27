<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团成员--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubMembers.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubMembers v = (ClubMembers)request.getAttribute("fromBean");
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
List sexoptions = (List)request.getAttribute("sexoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List MajorNameoptions = (List)request.getAttribute("MajorNameoptions");
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List GradeNameoptions = (List)request.getAttribute("GradeNameoptions");
List PoliticsNameoptions = (List)request.getAttribute("PoliticsNameoptions");
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
				<div class="browsetitle001">社团成员</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团成员") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubMembersAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, v.getMemberName(), "MemberName", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, v.getMemberSex(), "MemberSex", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">生日</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberBrith" id="MemberBrith" size="10" maxsize="10" value="<%=v.getMemberBrith()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getMemberPolitics(), "MemberPolitics", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">籍贯</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberBirthplace" id="MemberBirthplace" size="50" maxsize="50" value="<%=v.getMemberBirthplace()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, v.getMemberClubname(), "MemberClubname", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团code</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Memberclubcode" id="Memberclubcode" size="10" maxsize="10" value="<%=v.getMemberclubcode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">职责</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberDuty" id="MemberDuty" size="50" maxsize="50" value="<%=v.getMemberDuty()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getMemberAcademy(), "MemberAcademy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">专业</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(MajorNameoptions, v.getMemberMajor(), "MemberMajor", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">年级</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(GradeNameoptions, v.getMemberGrade(), "MemberGrade", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberEmail" id="MemberEmail" size="45" maxsize="45" value="<%=v.getMemberEmail()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberPhone" id="MemberPhone" size="45" maxsize="45" value="<%=v.getMemberPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">QQ</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Memberqq" id="Memberqq" size="45" maxsize="45" value="<%=v.getMemberqq()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">微信</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Memberwx" id="Memberwx" size="45" maxsize="45" value="<%=v.getMemberwx()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">个人简介</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="MProfile" id="MProfile" cols="40" rows="2"><%=v.getMProfile()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团工作经历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="MExperience" id="MExperience" cols="40" rows="2"><%=v.getMExperience()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="MCommentAcademy" id="MCommentAcademy" cols="40" rows="2"><%=v.getMCommentAcademy()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="MCommentAcatw" id="MCommentAcatw" cols="40" rows="2"><%=v.getMCommentAcatw()%></textarea>
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
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberSno" id="MemberSno" size="45" maxsize="45" value="<%=v.getMemberSno()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否团长</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="IsManager" id="IsManager" size="45" maxsize="45" value="<%=v.getIsManager()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否审核</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Remark" id="Remark" cols="40" rows="2"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ApplyTime" id="ApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getApplyTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Identity" id="Identity" size="45" maxsize="45" value="<%=v.getIdentity()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">个人简介1</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ApplyContent" id="ApplyContent" cols="40" rows="2"><%=v.getApplyContent()%></textarea>
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
                    													<td align="right" class="form_label">是否元老</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ManagerGeneration" id="ManagerGeneration" value="<%=v.getManagerGeneration()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导单位审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentXy" id="CommentXy" cols="40" rows="2"><%=v.getCommentXy()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
