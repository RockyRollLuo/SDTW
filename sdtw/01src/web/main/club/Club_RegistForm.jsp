<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团注册信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Club_Regist.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Club_Regist v = (Club_Regist)request.getAttribute("fromBean");
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
	List cdt = new ArrayList();
	List list = new ArrayList();
	Club club = new Club();
	if(userInfo.hasFunPower(Power.STUSER))
	cdt.add("ClubId='"+userInfo.getName()+"'");
	else{
		cdt.add("id='"+v.getClubName()+"'");
	}
	list = club.query(cdt);
	if(list.size()>0)
		club = (Club)list.get(0);

	ClubUtil util = new ClubUtil();	
	Map<String,Object>numMap = new HashMap<String,Object>();
	numMap = util.getClubmimbers(club.getId());	
	List allList = new ArrayList();
	allList = (List)numMap.get("All_");
List cdt1 = new ArrayList();
cdt1.add("id in("+Tool.join(",",allList)+")");
//List UserNameoptions = COptionConst.getUserCnNameOptions(userInfo,"-1",cdt1); 
	//(List)request.getAttribute("UserNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");

List ClubNameoptions = COptionConst.getClubNameOptions(userInfo,cdt);
list = club.query(cdt);
if(list.size()>0)
	club = (Club)list.get(0);
cdt.clear();
cdt.add("id="+club.getClubType()+"");
List ClubTypeNameoptions = COptionConst.getClubTypeNameOptions(userInfo,cdt);
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map MemberDutyMap = CEditConst.getMemberDutyMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
Map MajorNameMap = CEditConst.getMajorNameMap(userInfo);
Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
Map PoliticsNameMap = CEditConst.getPoliticsNameMap(userInfo);
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<jsp:include page="../jqueryui.jsp" flush="true"/> 
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
			function submitthis(flag){
				$('#CheckFlag').val(flag);
				document.postForm.submit();
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团注册信息</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团注册信息") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="Club_RegistAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%
						if(userInfo.hasFunPower(Power.STUSER)){//社团用户
							if(v.getCheckFlag()==-1||SdtwConst.CHECKFLAG_XYWTG.equals(v.getCheckFlag()+"")){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ submitthis(<%=SdtwConst.CHECKFLAG_SB%>);}">提交</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) {submitthis(-1);}">保存</a></li>
						<%
							}
							if(SdtwConst.CHECKFLAG_XXWTG.equals(v.getCheckFlag()+"")){%>
								<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ submitthis(<%=SdtwConst.CHECKFLAG_XYTG%>);}">提交</a></li>
							<%}
						}
						if(userInfo.hasFunPower(Power.UserAdminPower)){//指导单位用户
							if(SdtwConst.CHECKFLAG_SB.equals(v.getCheckFlag()+"")){
						%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XYWTG%>);}">审核未通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckXy').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XYTG%>);}">审核通过</a></li>
						<%}
						}
						if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){//团委用户
							if(SdtwConst.CHECKFLAG_XYTG.equals(v.getCheckFlag()+"")){
						%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckTw').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XXWTG%>);}">审核未通过</a></li>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')){ $('#CheckTw').val(<%=userInfo.getId() %>);submitthis(<%=SdtwConst.CHECKFLAG_XXTG%>);}">审核通过</a></li>
						<%}
						}
						%>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">社团信息</a></li>
				<li><a href="#tabs-2">注册信息</a></li>
				<%
				if(userInfo.hasFunPower(Power.STUSER))//社团用户
				if(v.getCheckFlag()!=-1){%>
					<li><a href="#tabs-3">学院审核意见</a></li>
				<li><a href="#tabs-4">团委审核意见</a></li>
				<%}
				%>
				<%
				if(userInfo.hasFunPower(Power.UserAdminPower))//指导单位
				{%>
					<li><a href="#tabs-3">学院审核意见</a></li>
				<%}
				%>
				<%
				if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST))//团委
				{%>
					<li><a href="#tabs-3">学院审核意见</a></li>
					<li><a href="#tabs-4">团委审核意见</a></li>
				<%}
				%>
				
			</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden" name="ClubTimeSetup" id="ClubTimeSetup" size="45" maxsize="45" value="<%=club.getClubTimeSetup()%>">
				<input type="hidden" name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">
				<input type="hidden" name="ModiPerson" id="ModiPerson" value="<%=v.getModiPerson()%>"/>
				<input type="hidden" name="AddPerson" id="AddPerson" value="<%=v.getAddPerson()%>"/>
				<input type="hidden" name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
				<input type="hidden" name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
				<input type="hidden" name="CheckXy" id="CheckXy" value="<%=v.getCheckXy()%>">
				<input type="hidden" name="CheckTw" id="CheckTw" value="<%=v.getCheckTw()%>">
				<input type="hidden" name="ClubQQ" id="ClubQQ" size="45" maxsize="45" value="<%=v.getClubQQ().equals("")?club.getClubqq():v.getClubQQ()%>">
				<input type="hidden" name="ClubEmail" id="ClubEmail" size="45" maxsize="45" value="<%=v.getClubEmail().equals("")?club.getClubeMail():v.getClubEmail()%>">
				<input type="hidden" name="ClubPubAccount" id="ClubPubAccount" size="45" maxsize="45" value="<%=v.getClubPubAccount().equals("")?club.getClubPubAccount():v.getClubPubAccount()%>">
				<input type="hidden" name="RegistTime" id="RegistTime" size="0" value="<%=Tool.stringOfDateTime(v.getRegistTime())%>">
				<input type="hidden" id="Tenet" name="Tenet" value="<%=club.getTenet()%>"/>
				<%=Tool.join("\n", forms)%>
                    											<div id="tabs-1" style="border: 0px;">
                    											<table width="100%" style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
<input type="hidden" name="ClubId" value="<%=v.getClubId().equals("")?club.getClubId():v.getClubId()%>">
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, v.getClubName()+"", "ClubName", ""+club.getId(),true)%>
                    													</td>
													  				
                    													<td align="right" class="form_label">社团类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubTypeNameoptions, v.getClubType(), "ClubType", ""+club.getClubType(),true)%>
                    													</td>
													  				
                    													<td align="right" class="form_label">社团成立时间</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=club.getClubTimeSetup()%>
                    													</td>
                    												</tr>
                    												<tr>													  				
                    													<td align="right" class="form_label">指导单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getClubAcademy()+"", "ClubAcademy", ""+club.getAcademy(),true)%>
                    													</td>
                    													<td align="right" class="form_label">QQ</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=v.getClubQQ().equals("")?club.getClubqq():v.getClubQQ()%>
                    													</td>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=v.getClubEmail().equals("")?club.getClubeMail():v.getClubEmail()%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">公众号</td>
														    			<td align="left"  bgcolor="#ffffff" >
                    														<%=v.getClubPubAccount().equals("")?club.getClubPubAccount():v.getClubPubAccount()%>
                    													</td>
                    													<td align="right" class="form_label">账号</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<%=v.getClubId()%>
                    													</td>
													  				</tr>
													  				
													  				<tr>
																	<td align="right" class="form_label" rowspan="2">现有人数</td>
																	<td align="left"  bgcolor="#ffffff" colspan="3">总计:
																	
																	<%=numMap.get("all")==null?"0":numMap.get("all")%>
																	<input type="hidden" name="MemberCount" id="MemberCount" value="<%=numMap.get("all")==null?"0":numMap.get("all")%>"/>
																	</td>
																	<%int nan = (Integer)numMap.get("Sex_0")==null?0:(Integer)numMap.get("Sex_0"); 
													  				  int nv = (Integer)numMap.get("Sex_1")==null?0:(Integer)numMap.get("Sex_1"); 
													  				%>
													  				  <td colspan="3" align="left"  bgcolor="#ffffff">比例:(男/女)<%=nan %>/<%=nv %></td>
													  				  <input type="hidden" id="MemberMale" name="MemberMale" value="<%=nan%>"/>
													  				  <input type="hidden" id="MemberFemale" name="MemberFemale" value="<%=nv%>"/>
																	</tr>
													  				<tr>
													  				  <td  align="left"  bgcolor="#ffffff"> 本科生人数：<%=numMap.get("Identity_0")==null?"0":numMap.get("Identity_0") %> 
													  				  <input type="hidden" name="MemberUndergra" id="MemberUndergra" value="<%=numMap.get("Identity_0")==null?"0":numMap.get("Identity_0") %>">
													  				  </td>
													  				  <td  align="left"  bgcolor="#ffffff"> 研究生人数：<%=numMap.get("Identity_1")==null?"0":numMap.get("Identity_1") %>  
													  				  <input type="hidden" name="MemberGra" id="MemberGra" value="<%=numMap.get("Identity_1")==null?"0":numMap.get("Identity_1") %>">
													  				  </td>
													  				  <td  align="left"  bgcolor="#ffffff"> 党员人数： <%=numMap.get("Politics_01")==null?"0":numMap.get("Politics_01") %>
													  				  <input type="hidden" name="MenberParty" id="MenberParty" value="<%=numMap.get("Politics_01")==null?"0":numMap.get("Politics_01") %>">
													  				  </td>
													  				  <td colspan="3" align="left"  bgcolor="#ffffff">团员人数: <%=numMap.get("Politics_03")==null?"0":numMap.get("Politics_03") %>
													  				  <input type="hidden" name="MenberLeague" id="MenberLeague" value="<%=numMap.get("Politics_03")==null?"0":numMap.get("Politics_03") %>">
													  				  </td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">社团负责人情况</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<table width="100%"  border="0" cellspacing="0" cellpadding="0">
                                                                          <tr>
                                                                            <td>姓名</td>
                                                                            <td>职务</td>
                                                                            <td>手机</td>
                                                                            <td>QQ账号</td>
                                                                            <td>院系</td>
                                                                            <td>专业</td>
                                                                            <td>年级</td>
                                                                          </tr>
                                                                       
                    														<%-- <textarea name="ClubManager" id="ClubManager" cols="40" rows="2"><%=v.getClubManager()%></textarea> --%>
                    														<%
                    														List sponIds = new ArrayList();//社团负责人ids
                    														List sponsorList = new ArrayList();
                    														sponsorList = (List)numMap.get("IsManager_")==null?new ArrayList():(List)numMap.get("IsManager_");
                    														if(sponsorList.size()>0){
                    															for(int i=0;i<sponsorList.size();i++){
                    																ClubMembers members = new ClubMembers();
                    																members = (ClubMembers)sponsorList.get(i);
                    																if ("0".equals(members.getIdentity())) {
	                    																sponIds.add(members.getMemberName());
                    																}
                    																BaseUserCode user = new BaseUserCode();
                    																user = user.getById(Tool.StrToInt(members.getMemberName()));
                    																%>
                    																<tr>
                    																<td><%=user.getCnName() %></td>
                    																<td><%=MemberDutyMap.get(members.getMemberDuty())==null?"":MemberDutyMap.get(members.getMemberDuty()) %></td>
                    																<td><%=members.getMemberPhone() %></td>
                    																<td><%=members.getMemberqq() %></td>
                    																<td><%=AcademyNameMap.get(members.getMemberAcademy())==null?"":AcademyNameMap.get(members.getMemberAcademy()) %></td>
                    																<td><%=MajorNameMap.get(members.getMemberMajor())==null?"":MajorNameMap.get(members.getMemberMajor()) %></td>
                    																<td><%=GradeNameMap.get(members.getMemberGrade())==null?"":GradeNameMap.get(members.getMemberGrade()) %></td>
                    																</tr>
                    															<%}
                    														}
                    														numMap.clear(); %>
                    														<input type="hidden" name="ClubManager" id="ClubManager" value="<%=Tool.join(",",sponIds)%>"/>
                    														 </table>
                    													</td>
													  				</tr>
													  				<tr>
													  				<%
													  				List teacherList = new ArrayList();
													  				teacherList = util.getClubTeacher(club.getId());
													  				%>
                    													<td align="right" class="form_label">社团指导教师情况</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<%-- <textarea name="ClubTea" id="ClubTea" cols="40" rows="2"><%=v.getClubTea()%></<!--  -->textarea> --%>
                    														<table width="100%"  border="0" cellspacing="0" cellpadding="0">
                                                                          <tr>
                                                                            <td>姓名</td>
                                                                            <td>职务</td>
                                                                            <td>联系电话</td>
                                                                            <td>政治面貌</td>
                                                                          </tr>
                                                                          <%
                                                                          List zdList = new ArrayList();
                                                                          if(teacherList.size()>0){
                                                                        	  for(int i=0;i<teacherList.size();i++){
                                                                        		  ClubTeacher teacher = new ClubTeacher();
                                                                        		  teacher = (ClubTeacher)teacherList.get(i);
                                                                        		  zdList.add(teacher.getTeaName());
                                                                        		  %>
                                                                        		  <tr>
                                                                        		  <td><%=teacher.getTeaName() %></td>
                                                                        		  <td><%=teacher.getTeaDuty() %></td>
                                                                        		  <td><%=teacher.getTeaTel() %></td>
                                                                        		  <td><%=PoliticsNameMap.get(teacher.getTeaPolitics())==null?"":PoliticsNameMap.get(teacher.getTeaPolitics()) %></td>
                                                                        		  </tr>
                                                                        	  <%}
                                                                          } %>
                                                                          <input type="hidden" id="ClubTea" name="ClubTea" value="<%=Tool.join(",",zdList)%>"/>
                                                                          </table>
                    													</td>
													  				</tr>
                    												
                    												<tr>
                    													<td align="right" class="form_label">社团宗旨</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<!-- <textarea style="width: 100%" name="Tenet" id="Tenet" cols="40" rows="2"></textarea> -->
                    														<%=club.getTenet()%>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<div id="tabs-2" style="border: 0px;">
                    											<table width="100%"style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
                    													<td align="right" class="form_label">注册联系人</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%
														    			if(userInfo.hasFunPower(Power.STUSER)){%>
														    			
														<%//=HtmlTool.renderSelect(UserNameoptions, v.getRegistSponsor(), "RegistSponsor", "")%>
														    			<%}else{%>
														<%//=HtmlTool.renderSelect(UserNameoptions, v.getRegistSponsor(), "RegistSponsor", "",true)%>
														    			<%}
														    			%>
														    			<input id="RegistSponsor" name="RegistSponsor" value="<%=v.getRegistSponsor()%>"/>
                    													</td>
                    													
													  				</tr>
                    												
                    												<%
														    			if(userInfo.hasFunPower(Power.STUSER)){%>
                    												<tr>
                    													<td align="right" class="form_label">上学期工作总结（要点）</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea style="width: 100%" name="RegistSummary" id="RegistSummary" cols="40" rows="2"><%=v.getRegistSummary()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">本学期工作计划（要点）</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea style="width: 100%" name="RegistPlan" id="RegistPlan" cols="40" rows="2"><%=v.getRegistPlan()%></textarea>
                    													</td>
													  				</tr>
													  				<%}else{%>
													  					<tr>
                    													<td align="right" class="form_label">上学期工作总结（要点）</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=v.getRegistSummary()%>
                    														<textarea style="width: 100%;display: none;" name="RegistSummary" id="RegistSummary" cols="40" rows="2"><%=v.getRegistSummary()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">本学期工作计划（要点）</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<%=v.getRegistPlan()%>
                    														<textarea style="width: 100%;display: none;" name="RegistPlan" id="RegistPlan" cols="40" rows="2"><%=v.getRegistPlan()%></textarea>
                    													</td>
													  				</tr>
													  				<%} %>
                    											</table>
                    											</div>
                    											<%
                    											if(userInfo.hasFunPower(Power.STUSER))//社团用户
                    											if(v.getCheckFlag()!=-1){%>
                    											<div id="tabs-3" style="border: 0px;">
                    											<table style="background: #e3e5e8 ;" width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
                    													<td align="right" class="form_label">学院审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=v.getCommentAcademy()%>
                    														<textarea style="width: 100%;display: none;" name="CommentAcademy" id="CommentAcademy" cols="40" rows="2"><%=v.getCommentAcademy()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<div id="tabs-4" style="border: 0px;">
                    											<table width="100%" style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
                    													<td align="right" class="form_label">团委审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=v.getCommentUnion()%>
                    														<textarea style="width: 100%;display: none;" name="CommentUnion" id="CommentUnion" cols="40" rows="2"><%=v.getCommentUnion()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<%}else{%>
                    												<input type="hidden" id="CommentAcademy" name="CommentAcademy" value="<%=v.getCommentAcademy()%>"/>
                    												<input type="hidden" id="CommentUnion" name="CommentUnion" value="<%=v.getCommentUnion()%>"/>
                    											<%} %>
                    											<%
                    											if(userInfo.hasFunPower(Power.UserAdminPower)){
                    												//指导单位
                    											%>
                    											<div id="tabs-3" style="border: 0px;">
                    											<table style="background: #e3e5e8 ;" width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
                    													<td align="right" class="form_label">学院审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea style="width: 100%" name="CommentAcademy" id="CommentAcademy" cols="40" rows="2"><%=v.getCommentAcademy()%></textarea>
                    														<input type="hidden" id="CommentUnion" name="CommentUnion" value="<%=v.getCommentUnion()%>"/>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<%} %>
                    											<%
                    											if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){
                    												//团委用户
                    											%>
                    											<div id="tabs-3" style="border: 0px;">
                    											<table style="background: #e3e5e8 ;" width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
                    													<td align="right" class="form_label">学院审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%
                    														if(userInfo.hasFunPower(Power.UserAdminPower)){%>
                    															<textarea style="width: 100%" name="CommentAcademy" id="CommentAcademy" cols="40" rows="2"><%=v.getCommentAcademy()%></textarea>
                    														<%}else{%>
                    															<%=v.getCommentAcademy()%>
                    															<input type="hidden" id="CommentAcademy" name="CommentAcademy" value="<%=v.getCommentAcademy()%>"/>
                    														<%}
                    														%>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<div id="tabs-4" style="border: 0px;">
                    											<table style="background: #e3e5e8 ;" width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
                    													<td align="right" class="form_label">团委审核意见</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%
														    			if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)){%>
                    														<textarea style="width: 100%" name="CommentUnion" id="CommentUnion" cols="40" rows="2"><%=v.getCommentUnion()%></textarea>
														    			<%}else{%>
														    			<%=v.getCommentUnion()%>
														    			<input id="CommentUnion" name="CommentUnion" value="<%=v.getCommentUnion()%>" type="hidden"/>
														    			<%}
														    			%>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<%} %>
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
