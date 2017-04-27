<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团指导教师--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
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
List UserCnNameOptions = CEditConst.getUserCnNameOptions(userInfo,"-1");
List YesNoOptions = CEditConst.getYesNoOptions(userInfo,"-1");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
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
						<li><a href="ClubTeacherAction.jsp?cmd=list&ClubName=<%=v.getClubName() %>&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
				<input  type="hidden" name="ClubCode" id="ClubCode" size="45" maxsize="45" value="<%=v.getClubCode()%>">
				<input type="hidden" name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
				<input type="hidden" name="ModiPerson" id="ModiPerson" value="<%=v.getModiPerson()%>"/>
				<input type="hidden" id="CommentAcatw" name="CommentAcatw" value="<%=v.getCommentAcatw()%>"/>
				<input type="hidden" id="CommentClubunion" name="CommentClubunion" value="<%=v.getCommentClubunion()%>"/>
				<input type="hidden" id="AddPerson" name="AddPerson" value="<%=v.getAddPerson()%>"/>
                <input type="hidden" name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
                
                <input type="hidden" name="CommentTw" id="CommentTw" size="0" value="<%=v.getCommentTw()%>">
				
				<input type="hidden" name="ApplyDate" id="ApplyDate" size="0" value="<%=Tool.stringOfDateTime(v.getApplyDate())%>">
				<input type="hidden" name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
				<input type="hidden" name="CommentXy" id="CommentXy" size="45" maxsize="45" value="<%=v.getCommentXy()%>">
				<input type="hidden" id="ClubName" name="ClubName" value="<%=v.getClubName()%>"/>
				<input type="hidden" id="_ClubName_" name="_ClubName_" value="<%=v.getClubName()%>"/>
                    													
				
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%-- <%=HtmlTool.renderSelect(UserCnNameOptions,""+v.getTeaName(),"TeaName","") %> --%>
                    														<input id="TeaName" name="TeaName" value="<%=v.getTeaName()%>"/>
                    													</td>
													  				
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, v.getTeaSex(), "TeaSex", "")%>
                    													</td>
                    													<td align="right" class="form_label">年龄</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaAge" id="TeaAge"  value="<%=v.getTeaAge()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">民族</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(NationNameoptions, v.getTeaNation(), "TeaNation", "")%>
                    													</td>
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getTeaPolitics(), "TeaPolitics", "")%>
                    													</td>
													  				
                    													<td align="right" class="form_label">籍贯</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaBirthplace" id="TeaBirthplace"  value="<%=v.getTeaBirthplace()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">职位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaDuty" id="TeaDuty"  value="<%=v.getTeaDuty()%>">
                    													</td>
													  				
                    													<td align="right" class="form_label">所在学院（部门</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getTeaAcademy(), "TeaAcademy", "")%>
                    													</td>
													  				
                    													<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaTel" id="TeaTel"  value="<%=v.getTeaTel()%>">
                    													</td>
													  				<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaPhone" id="TeaPhone"  value="<%=v.getTeaPhone()%>">
                    													</td>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaEmail" id="TeaEmail"  value="<%=v.getTeaEmail()%>">
                    													</td>
                    													<td align="right" class="form_label">元老</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=HtmlTool.renderSelect(YesNoOptions,""+v.getGeneration(),"Generation","-1") %>
                    													</td>
													  				</tr>
													  				<tr>
													  				
													  				<td align="right" class="form_label">开始日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input class= "date" name ="StartDate" id= "StartDate" onfocus="WdatePicker({el:'StartDate',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  size= "0" value="<%=Tool.stringOfDate(v.getStartDate()) %>"/>
                    													</td>
                    													<td align="right" class="form_label">结束日期</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input class= "date" name ="StopDate" id= "StopDate" onfocus="WdatePicker({el:'StopDate',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  size= "0" value="<%=Tool.stringOfDate(v.getStopDate()).equals("0001-01-01")?"":Tool.stringOfDate(v.getStopDate()) %>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">个人情况简介</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea style="width: 100%;" name="TeaAcademic" id="TeaAcademic" cols="40" rows="2"><%=v.getTeaAcademic()%></textarea>
                    													</td>
													  				</tr>
                    												
                    												
                    											</table>
			</form>
		</div>
	</body>
</html>
