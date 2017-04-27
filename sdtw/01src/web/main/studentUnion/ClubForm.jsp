<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生社团基本信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Club.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Club v = (Club)request.getAttribute("fromBean");
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
List UserNameoptions = CEditConst.getUserCnNameOptions(userInfo,"-1");
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map sexMap = CEditConst.getsexMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
Map IdentityMap = CEditConst.getIdentityMap(userInfo);
Map MemberDutyMap = CEditConst.getMemberDutyMap(userInfo);
Map YesNoMap = CEditConst.getYesNoMap(userInfo);
List CancleCheckFlagoptions = (List)request.getAttribute("CancleCheckFlagoptions");
List OrgCityNameoptions = (List)request.getAttribute("OrgCityNameoptions");
List ClubTypeNameoptions = (List)request.getAttribute("ClubTypeNameoptions");
List YesNoOptions = CEditConst.getYesNoOptions(userInfo,"-1");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="../../main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" type="text/javascript" src="../js/jquery.nicescroll.js"></script>
		<script type="text/javascript" src="../js/main.js"></script>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
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
			$(function(){
				initHeight();
				//$(".left").niceScroll({cursorborder:"",cursorcolor:"#e85280",boxzoom:false,autohidemode:false})
				$(".commentFrame").niceScroll({cursorborder:"",cursorcolor:"#00F",cursoropacitymax:0.7,boxzoom:false})
				//屏蔽站内信 setInterval(getShortMsg,1000*30);
			});
			function initHeight(){
				var clienth = document.documentElement.clientHeight+100;
				$('#tabs-7').height(clienth);
				$('#tabs-8').height(clienth);
			}
			function showmsg(uid,cid,checkflag) {//学生id
				if(uid==""||uid=="-1") {
					alert("请选择");
					return;
				}
			//	var checkflag = 1;
				var title = "查看学生信息";
				var clienth = 600;
				var clientw = 1366;
				parent.showDialog('<%=HeadConst.apache_url%>/main/club/EditClubModifySponsor.jsp?uid='+uid+'&cid='+cid+'&checkflag='+checkflag,clientw,clienth,title
						,{
					'确定':function(){
						parent.formsubmit();
					}
					
				});
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">
			社团信息详情表
				</div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
					
						
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">基本信息</a></li>

			<!-- 	<li><a href="#tabs-7" >负责人情况</a></li>
				<li><a href="#tabs-8" >指导教师情况</a></li> -->
			</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" id="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											<div id="tabs-1" style="border: 0px;">
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" style="background-color: #e3e5e8;">
<input type="hidden" name="Id" value="<%=v.getId()%>">
<input type="hidden" id="_flag_" name="_flag_" value="<%=ParamUtils.getParameter(request,"_flag_","")%>"/>
<input type="hidden" name="ClubCode" id="ClubCode" size="45" maxsize="45" value="<%=v.getClubCode()%>">
<%-- <input type="hidden" name="ClubId" id="ClubId" size="20" maxsize="20" value="<%=v.getClubId()%>"> --%>
<input type="hidden" name="ManagerFlag" id="ManagerFlag" value="<%=v.getManagerFlag()%>">
<input type="hidden" name="TeaFlag" id="TeaFlag" value="<%=v.getTeaFlag()%>">
<input type="hidden" name="CheckFlag" id="CheckFlag" size="20" maxsize="20" value="<%=v.getCheckFlag()%>">
<input type="hidden" name="AddPerson" value="<%=v.getAddPerson()%>">
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
<input type="hidden" name="ModiPerson" value="<%=v.getModiPerson()%>">
<input type="hidden" name="ModiTime" value="<%=v.getModiTime()%>">
<input type="hidden" name="CancleCheckFlag" id = "CancleCheckFlag" value="<%=v.getCancleCheckFlag()%>"/>
<input type="hidden" name="ClubTimeSetup" value="<%=v.getClubTimeSetup()%>">
<input type="hidden" name="ClubTimeCheck" value="<%=v.getClubTimeCheck()%>">
<input type="hidden" name="AddPersonName" value="<%=v.getAddPersonName()%>">
<input type="hidden" name="AddFileList" value="<%=v.getAddFileList()%>">
<input type="hidden" name="RecruitmentStart" value="<%=v.getRecruitmentStart()%>">
<input type="hidden" name="RecruitmentStop" value="<%=v.getRecruitmentStop()%>">
<%-- <input type="hidden" name="RecruitmentCheckflag" value="<%=v.getRecruitmentCheckflag()%>"> --%>
<input type="hidden" name="Iscancle" value="<%=v.getIscancle()%>">
<input type="hidden" name="Sponsor" value="<%=v.getSponsor()%>"/>
<input type="hidden" id="TeacherModifyFlag" name="TeacherModifyFlag" value="<%=v.getTeacherModifyFlag()%>"/>
<input type="hidden" id="Teacher" name="Teacher" value="<%=v.getTeacher()%>"/>
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ClubName" id="ClubName" value="<%=v.getClubName()%>">
                    													</td>
                    													<td align="right" class="form_label">社团类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubTypeNameoptions, v.getClubType(), "ClubType", "")%>
                    													</td>
													  				
                    													<td align="right" class="form_label">校区</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(OrgCityNameoptions, v.getCity(), "City", "")%>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				
                    													<%-- <td align="right" class="form_label">指导教师</td>
														    			<td align="left"  bgcolor="#ffffff">
<%//=HtmlTool.renderSelect(UserNameoptions, v.getTeacher(), "Teacher", "",true)%>
                    													</td> --%>
													  				
                    													<td align="right" class="form_label">
                    													<%if(v.getManagerFlag()==1){%>
                    														负责人
                    													<%}else{%>
                    														拟负责人
                    													<%} %>
                    													</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getChairman(), "Chairman", "",true)%>
                    													</td>
                    													
                    													<td align="right" class="form_label" >账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%//=HtmlTool.renderSelect(YesNoOptions,v.getApplyRecruitment()+"","ApplyRecruitment","-1") %>
                    														<input type="hidden" id="ApplyRecruitment" name="ApplyRecruitment" value="<%=v.getApplyRecruitment()%>"/>
                    														<input type="hidden" id="RecruitmentCheckflag" name="RecruitmentCheckflag" value="<%=v.getRecruitmentCheckflag()%>"/>
                    														<input readonly="readonly"  id="ClubId" name="ClubId" value="<%=v.getClubId()%>"/>
                    													</td>
													  				</tr><tr>
                    													<td align="right" class="form_label">联系方式QQ</td>
														    			<td align="left"  bgcolor="#ffffff" >
                    														<input name="Clubqq" id="Clubqq"  value="<%=v.getClubqq()%>">
                    													</td>
													  				
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ClubeMail" id="ClubeMail"  value="<%=v.getClubeMail()%>">
                    													</td>
													  				
                    													<td align="right" class="form_label">公众号</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="ClubPubAccount" id="ClubPubAccount"  value="<%=v.getClubPubAccount()%>">
                    													</td>
													  				
                    													<%--  <td align="right" class="form_label">指导教师是否更换</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(YesNoOptions,v.getTeacherModifyFlag()+"","TeacherModifyFlag","-1") %>
                    													</td> --%>
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">发起人情况</td>
														    			<%-- <td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea name="Sponsor" id="Sponsor" ><%=v.getSponsor()%></textarea>
                    													</td> --%>
                    													<td align="left"  bgcolor="#ffffff" colspan="5">
                    													<%
                    													if(v.getSponsor().trim().length()>0){
                    														ClubUtil util = new ClubUtil();
                    														List list = util.getSponsorList(v.getId());
                    														if(list.size()>0) {
                    															List uidsList = new ArrayList();
                    															for(int i=0;i<list.size();i++) {
                    																ClubMembers m = new ClubMembers();
                    																m = (ClubMembers)list.get(i);
                    																uidsList.add(XtUtil.getIdsStr(m.getMemberName()));
                    															}
                    															Map<String,String>userMap = new HashMap();
                    															userMap = util.getuserMap(Tool.join(",",uidsList));
                    															for(int i=0;i<list.size();i++) {
                    																ClubMembers m = new ClubMembers();
                    																m = (ClubMembers)list.get(i);%>
                    																<%
                    																if (!"1".equals(m.getIdentity())) {
                    																%>
                    																<a style="color: red" title="点击查看" href="javascript:showmsg(<%=m.getMemberName() %>,<%=m.getMemberClubname() %>,'1')">
                    																姓名：<%=userMap.get(m.getMemberName())==null?"":userMap.get(m.getMemberName()) %>&nbsp;&nbsp;
                    																
                    																<%} else {%>
                    																	姓名：<%=m.getMemberName() %>&nbsp;&nbsp;
                    																<%} %>
                    																学号：<%=m.getMemberSno() %>&nbsp;&nbsp;
                    																 学历:<%=IdentityMap.get(m.getIdentity()+"")==null?"":IdentityMap.get(m.getIdentity()+"") %>&nbsp;&nbsp;
                    																性别：<%=sexMap.get(m.getMemberSex())==null?"":sexMap.get(m.getMemberSex()) %>&nbsp;&nbsp;
                    																学院：<%=AcademyNameMap.get(m.getMemberAcademy())==null?"":AcademyNameMap.get(m.getMemberAcademy()) %>&nbsp;&nbsp;
                    																年级：<%=GradeNameMap.get(m.getMemberGrade())==null?"":GradeNameMap.get(m.getMemberGrade()) %>&nbsp;&nbsp;
                    																联系方式：<%=m.getMemberPhone() %>&nbsp;&nbsp; 
                    																职务：<%=MemberDutyMap.get(m.getMemberDuty()) %>
                    																是否负责人：<%=YesNoMap.get(m.getIsManager())==null?"否":YesNoMap.get(m.getIsManager()) %>
                    																<%
                    																if (!"1".equals(m.getIdentity())) {
                    																%>
                    																</a>
                    																<%} %>
                    																<br/>
                    															<%}
                    															userMap.clear();
                    														}
                    													}
                    													%>
                    													</td>
													  				</tr>
                    												<%-- <tr>
                    													<td align="right" class="form_label">是否添加指导教师</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TeaFlag" id="TeaFlag" value="<%=v.getTeaFlag()%>">
                    													</td>
													  				</tr> --%>
                    												<%-- <tr>
                    													<td align="right" class="form_label">社团编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ClubCode" id="ClubCode" size="45" maxsize="45" value="<%=v.getClubCode()%>">
                    													</td>
													  				</tr> --%>
													  				
                    												<%-- <tr>
                    													<td align="right" class="form_label">登录账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ClubId" id="ClubId" size="20" maxsize="20" value="<%=v.getClubId()%>">
                    													</td>
													  				</tr> --%>
                    												<tr>
                    													<td align="right" class="form_label">宗旨</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea name="Tenet" id="Tenet" rows="5"style="width: 100%"><%=v.getTenet()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">简介</td>
														    			<td align="left"  bgcolor="#ffffff"colspan="5">
                    														<textarea name="ClubProfile" id="ClubProfile" rows="5"style="width: 100%"><%=v.getClubProfile()%></textarea>
                    													</td>
													  				</tr>
                    												
                    												<tr>
                    													<td align="right" class="form_label">成立原因</td>
														    			<td align="left"  bgcolor="#ffffff"colspan="5">
                    														<textarea name="Feasibility" id="Feasibility" rows="5"style="width: 100%"><%=v.getFeasibility()%></textarea>
                    													</td>
													  				</tr>
                    												
                    												<%-- <tr>
                    													<td align="right" class="form_label">注销状态</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(CancleCheckFlagoptions, "" + v.getCancleCheckFlag(), "CancleCheckFlag", "-1")%>
                    													</td>
													  				</tr> --%>
                    												<tr>
                    													<td align="right" class="form_label">指导教师意见</td>
														    			<td align="left"  bgcolor="#ffffff"colspan="5">
                    														<textarea name="CommentTea" id="CommentTea" rows="5"style="width: 100%"><%=v.getCommentTea()%></textarea>
                    													</td>
													  				</tr>
                    												
                    			<%-- 									<tr>
                    													<td align="right" class="form_label">审核</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" size="20" maxsize="20" value="<%=v.getCheckFlag()%>">
                    													</td>
													  				</tr> --%>
                    												<%-- <tr>
                    													<td align="right" class="form_label">添加人姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getAddPersonName(), "AddPersonName", "")%>
                    													</td>
													  				</tr> --%>

                    											</table>
                    											</div>
                    										
                    											
													  			
													  											  				
			</form>
			</div>
		</div>
		<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', 0); 
	});
	</script>
	</body>
</html>
