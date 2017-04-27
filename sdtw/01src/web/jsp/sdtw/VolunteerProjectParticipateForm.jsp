<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--志愿竞赛报名表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(VolunteerProjectParticipate.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerProjectParticipate v = (VolunteerProjectParticipate)request.getAttribute("fromBean");
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
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List VolunProjectNameoptions = (List)request.getAttribute("VolunProjectNameoptions");
List AssLeveloptions = (List)request.getAttribute("AssLeveloptions");
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
				<div class="browsetitle001">志愿竞赛报名表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("志愿竞赛报名表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="VolunteerProjectParticipateAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">志愿竞赛项目id</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(VolunProjectNameoptions, "" + v.getProjectId(), "ProjectId", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学生学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Sno" id="Sno" size="20" maxsize="20" value="<%=v.getSno()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">荣誉名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Honour" id="Honour" size="45" maxsize="45" value="<%=v.getHonour()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">提交标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SubmitFlag" id="SubmitFlag" value="<%=v.getSubmitFlag()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="CheckFlag" value="<%=v.getCheckFlag()%>">
<input type="hidden" name="XycheckFalg" value="<%=v.getXycheckFalg()%>">
                    												<tr>
                    													<td align="right" class="form_label">审批意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CheckComments" id="CheckComments" cols="40" rows="2"><%=v.getCheckComments()%></textarea>
                    													</td>
													  				</tr>
<input type="hidden" name="AddAccount" value="<%=v.getAddAccount()%>">
<input type="hidden" name="Addtime" value="<%=v.getAddtime()%>">
<input type="hidden" name="CheckAccount" value="<%=v.getCheckAccount()%>">
<input type="hidden" name="CheckTime" value="<%=v.getCheckTime()%>">
                    												<tr>
                    													<td align="right" class="form_label">所属学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectName" id="ProjectName" size="45" maxsize="45" value="<%=v.getProjectName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeamName" id="TeamName" size="45" maxsize="45" value="<%=v.getTeamName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队主管单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeamUnit" id="TeamUnit" size="45" maxsize="45" value="<%=v.getTeamUnit()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">登记时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="RegisterId" id="RegisterId" size="45" maxsize="45" value="<%=v.getRegisterId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">成立时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SetupTime" id="SetupTime" size="0" value="<%=Tool.stringOfDateTime(v.getSetupTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">邮政编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ZipCode" id="ZipCode" size="45" maxsize="45" value="<%=v.getZipCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">通讯地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ContactAddress" id="ContactAddress" cols="40" rows="2"><%=v.getContactAddress()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">年度年检结论</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="InspectionConclution" id="InspectionConclution" cols="40" rows="2"><%=v.getInspectionConclution()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">评估等级</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AssLeveloptions, v.getAssLevel(), "AssLevel", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">有无免税资格</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DutyFree" id="DutyFree" size="2" maxsize="2" value="<%=v.getDutyFree()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目实施时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="StartTime" id="StartTime" size="0" value="<%=Tool.stringOfDateTime(v.getStartTime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目领域</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectArea" id="ProjectArea" size="45" maxsize="45" value="<%=v.getProjectArea()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">实施领域</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ImpleArea" id="ImpleArea" size="45" maxsize="45" value="<%=v.getImpleArea()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">参与项目运作人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ParticipateNum" id="ParticipateNum" value="<%=v.getParticipateNum()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">专职人员人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="FulltimeNum" id="FulltimeNum" value="<%=v.getFulltimeNum()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">曾获何等奖励</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Award" id="Award" cols="40" rows="2"><%=v.getAward()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Content" id="Content" cols="40" rows="2"><%=v.getContent()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目背景意义</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Meanings" id="Meanings" cols="40" rows="2"><%=v.getMeanings()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目预计效果</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="DisiredResults" id="DisiredResults" cols="40" rows="2"><%=v.getDisiredResults()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目实施地点</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ImplePlace" id="ImplePlace" cols="40" rows="2"><%=v.getImplePlace()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目实施地点</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Promotion" id="Promotion" cols="40" rows="2"><%=v.getPromotion()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目特色</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Specialist" id="Specialist" cols="40" rows="2"><%=v.getSpecialist()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">受益对象</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="BeneFicaiaries" id="BeneFicaiaries" cols="40" rows="2"><%=v.getBeneFicaiaries()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">预计直接受益人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Benenum" id="Benenum" value="<%=v.getBenenum()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MajorName" id="MajorName" size="45" maxsize="45" value="<%=v.getMajorName()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人性别</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MajorSex" id="MajorSex" size="45" maxsize="45" value="<%=v.getMajorSex()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人出生年月</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MajorBirth" id="MajorBirth" size="45" maxsize="45" value="<%=v.getMajorBirth()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人工作单位及职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MajorDuty" id="MajorDuty" size="45" maxsize="45" value="<%=v.getMajorDuty()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getMajorPolista(), "MajorPolista", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MajorPhone" id="MajorPhone" size="45" maxsize="45" value="<%=v.getMajorPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MajorPhone2" id="MajorPhone2" size="45" maxsize="45" value="<%=v.getMajorPhone2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目负责人邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MajorEmail" id="MajorEmail" size="45" maxsize="45" value="<%=v.getMajorEmail()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getGuideTeacherName(), "GuideTeacherName", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师性别</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GuideTeacherSex" id="GuideTeacherSex" size="45" maxsize="45" value="<%=v.getGuideTeacherSex()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师出生年月</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GuideTeacherBirth" id="GuideTeacherBirth" size="45" maxsize="45" value="<%=v.getGuideTeacherBirth()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师工作单位及职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GuideTeacherDuty" id="GuideTeacherDuty" size="45" maxsize="45" value="<%=v.getGuideTeacherDuty()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getGuideTeacherPolista(), "GuideTeacherPolista", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GuideTeacherPhone" id="GuideTeacherPhone" size="45" maxsize="45" value="<%=v.getGuideTeacherPhone()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GuideTeacherPhone2" id="GuideTeacherPhone2" size="45" maxsize="45" value="<%=v.getGuideTeacherPhone2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目指导教师邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GuiderTeacherEmail" id="GuiderTeacherEmail" size="45" maxsize="45" value="<%=v.getGuiderTeacherEmail()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="AddFileList" value="<%=v.getAddFileList()%>">
                    											</table>
			</form>
		</div>
	</body>
</html>
