<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团成员--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
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
ClubUtil util = new ClubUtil();
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List UserCnNameoptions = CEditConst.getUserCnNameOptions(userInfo,"-1");
List cdt1 = new ArrayList();
cdt1.add("academy="+v.getMemberAcademy());
List MajorNameoptions = COptionConst.getMajorNameOptions(userInfo,"",cdt1);
	//(List)request.getAttribute("MajorNameoptions");
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
List sexoptions = (List)request.getAttribute("sexoptions");
List GradeNameoptions = (List)request.getAttribute("GradeNameoptions");
List PoliticsNameoptions = (List)request.getAttribute("PoliticsNameoptions");
Map ClubNameMap = CEditConst.getClubNameMap(userInfo);
List YesNoOptions = CEditConst.getYesNoOptions(userInfo,"-1");
List MemberDutyOptions = util.getMemberDutyOptions();
List IdentityOptions = CEditConst.getIdentityOptions(userInfo,"-1");
String _MemberClubname_= ParamUtils.getParameter(request,"_MemberClubname_","-1");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<jsp:include page="../jqueryui.jsp" flush="true"/> 
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/WdatePicker.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
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
			function getmajor() {
				//alert("dsfdsffd")
				$.ajax({
		            type: "post",
		            url: "<%=HeadConst.apache_url%>/main/base/UserCodeAction.jsp",
		            data: {academy:$('#MemberAcademy').val(),cmd:'getmajor'},
		            dataType: "html",
		            async:false,
		            cache: false,
		            success: function(data){
		                       $( '#MemberMajor').html(data);
		                     },
		                     error : function() { 
		                                 // view("异常！"); 
		                                 alert( "异常！"); 
							}
				});
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
		<div class="browsetitle">
		<%if(userInfo.hasFunPower(Power.STUSER)) { %>
			<div class="browsetitleleft">
				<div class="browsetitle001">
				<%
				String describe = ParamUtils.getAttribute(request,"describe","");
				%>
				<%=ClubNameMap.get(v.getMemberClubname())+"社团"+describe %>
				</div>
				<div class="browsetitle002"><%=XtUtil.getSpell(describe) %></div>
			</div>
			<%} %>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubMembersAction.jsp?cmd=list&MemberClubname=<%=v.getMemberClubname() %>&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<!-- <li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li> -->
						<%
						if(v.getCheckFlag()==0&&userInfo.hasFunPower(Power.STUSER)) {%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm'))submitthis(2);">审核不通过</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(1);">审核通过</a></li>
						<%}
						%>
						<%
						if(userInfo.hasFunPower(Power.STUSER)&&v.getCheckFlag()>0){%>
							<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(1);">修改</a></li>
						<%}
						%>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<div id="tabs">
			<ul>
				<li><a href="#tabs-1">学生基本信息</a></li>
				<li><a href="#tabs-2">社团审核信息</a></li>
			</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="_flag_" id="_flag_" value="<%=ParamUtils.getParameter(request,"_flag_","")%>"/>
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden" name="Memberclubcode" id="Memberclubcode" size="10" maxsize="10" value="<%=v.getMemberclubcode()%>">
				<input type="hidden" id="MCommentAcademy"name="MCommentAcademy" value="<%=v.getMCommentAcademy()%>"/>
				<input type="hidden" id="MCommentAcatw"name="MCommentAcatw" value="<%=v.getMCommentAcademy()%>"/>
				<input type="hidden" id="AddPerson" name="AddPerson" value="<%=v.getAddPerson()%>"/>
				<input type="hidden" name="AddTime" id="AddTime" size="0" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
				<input type="hidden" id="ModiPerson" name="ModiPerson" value="<%=v.getModiPerson()%>"/>
				<input type="hidden" id="ModiTime" name="ModiTime" value="<%=Tool.stringOfDateTime(v.getModiTime())%>"/>  
				<input type="hidden" id="CommentXy" name="CommentXy" value="<%=v.getCommentXy()%>"/>
				<input type="hidden" id="ApplyContent" name="ApplyContent" value="<%=v.getApplyContent()%>"/>
				<input type="hidden" name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
				<input type="hidden" name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
				<input type="hidden" name="Id" value="<%=v.getId()%>">
				<input type="hidden" name="MemberClubname" id="MemberClubname" value="<%=v.getMemberClubname()%>"/>
				<input type="hidden" name="_MemberClubname_" id="_MemberClubname_" value="<%=v.getMemberClubname()%>"/>
				<input type="hidden" name="ApplyTime" id="ApplyTime" size="0" value="<%=Tool.stringOfDateTime(v.getApplyTime())%>">
															<div id="tabs-1" style="border: 0px;">
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">名称</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%
														    			if (!"1".equals(v.getIdentity())) {
														    			%>
																		<%=HtmlTool.renderSelect(UserCnNameoptions, v.getMemberName(), "MemberName", "",true)%>
																		<%}else{%>
																			<input id="MemberName" name="MemberName" value="<%=v.getMemberName()%>"/>
																		<%} %>
                    													</td>
													  				<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberSno" id="MemberSno" maxsize="45" value="<%=v.getMemberSno()%>">
                    													</td>
                    													<td align="right" class="form_label">学历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%-- <input name="Identity" id="Identity"  maxsize="45" value="<%=v.getIdentity()%>"> --%>
                    														<%=HtmlTool.renderSelect(IdentityOptions,v.getIdentity(),"Identity","-1") %>
                    													</td>
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
																		<%=HtmlTool.renderSelect(AcademyNameoptions, v.getMemberAcademy(), "MemberAcademy","","onchange=getmajor()")%>
                    													</td>
                    													<td align="right" class="form_label">专业</td>
														    			<td align="left"  bgcolor="#ffffff">
																		<%=HtmlTool.renderSelect(MajorNameoptions, v.getMemberMajor(), "MemberMajor", "")%>
                    													</td>
													  				
                    													<td align="right" class="form_label">年级</td>
														    			<td align="left"  bgcolor="#ffffff">
																		<%=HtmlTool.renderSelect(GradeNameoptions, v.getMemberGrade(), "MemberGrade", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    												<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
																	   <%=HtmlTool.renderSelect(sexoptions, v.getMemberSex(), "MemberSex", "")%>
                    													</td>
                    													<td align="right" class="form_label">生日</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<input class= "date" name ="MemberBrith" id= "MemberBrith" onfocus="WdatePicker({el:'MemberBrith',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  size= "0" value="<%= v.getMemberBrith()%>"/>
                    													</td>
                    													<td align="right" class="form_label">籍贯</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberBirthplace" id="MemberBirthplace"  maxsize="50" value="<%=v.getMemberBirthplace()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    												<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
																		<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getMemberPolitics(), "MemberPolitics", "")%>
                    													</td>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="MemberEmail" id="MemberEmail" maxsize="45" value="<%=v.getMemberEmail()%>">
                    													</td>
													  				</tr>
                    												<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MemberPhone" id="MemberPhone"  maxsize="45" value="<%=v.getMemberPhone()%>">
                    													</td>
                    													<td align="right" class="form_label">QQ</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Memberqq" id="Memberqq"  maxsize="45" value="<%=v.getMemberqq()%>">
                    													</td>
													  				
                    													<td align="right" class="form_label">微信</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Memberwx" id="Memberwx"  maxsize="45" value="<%=v.getMemberwx()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">个人简介</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea name="MProfile" id="MProfile" cols="40" rows="2" style="width: 100%"><%=v.getMProfile()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社团工作经历</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea name="MExperience" id="MExperience" cols="40" rows="2" style="width: 100%"><%=v.getMExperience()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea name="Remark" id="Remark" cols="40" rows="2" style="width: 100%"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<div id="tabs-2" style="border: 0px;">
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
													  				<td align="right" class="form_label">职责</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%="0".equals(v.getMemberDuty())?"会长<input id='MemberDuty' name='MemberDuty' value='"+v.getMemberDuty()+"' type='hidden'/>":HtmlTool.renderSelect(MemberDutyOptions,v.getMemberDuty(),"MemberDuty","-1") %>
														    			
                    													</td>
                    													<td align="right" class="form_label">是否团长</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=HtmlTool.renderSelect(YesNoOptions,""+v.getIsManager(),"IsManager","-1",true) %>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">开始时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input readonly class="date" onfocus="WdatePicker({el:'StartDate',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  name="StartDate" id="StartDate" size="0" value="<%=Tool.stringOfDate(v.getStartDate()).equals("0001-01-01")?"":Tool.stringOfDate(v.getStartDate())%>">
                    													</td>
													  				
                    													<td align="right" class="form_label">结束时间</td>
														    			<td align="left"  bgcolor="#ffffff" >
                    														<input readonly class="date" onfocus="WdatePicker({el:'StopDate',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  name="StopDate" id="StopDate" size="0" value="<%=Tool.stringOfDate(v.getStopDate()).equals("0001-01-01")?"":Tool.stringOfDate(v.getStopDate())%>">
                    													</td>
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">是否元老</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(YesNoOptions,""+v.getManagerGeneration(),"ManagerGeneration","-1",true) %>
                    													</td>
													  				</tr>
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
