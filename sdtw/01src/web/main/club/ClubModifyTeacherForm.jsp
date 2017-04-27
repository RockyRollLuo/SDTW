<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团变更指导教师--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubModifyTeacher.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubModifyTeacher v = (ClubModifyTeacher)request.getAttribute("fromBean");
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
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
List ClubTypeNameoptions = (List)request.getAttribute("ClubTypeNameoptions");
Club club = new Club();
if("".equals(v.getClubName())){
	List list = new ArrayList();
	List cdt = new ArrayList();
	cdt.add("ClubId='"+userInfo.getName()+"'");
	list = club.query(cdt);
	if(list.size()>0){
		club = (Club)list.get(0);
	}else{
		return;
	}
}else{
	club = club.getById(Tool.StrToInt(v.getClubName()));
}
String ClubId = "";
String flag = "text";
if (userInfo.hasFunPower(Power.STUSER)) {
	ClubId = club.getClubId();
	flag = "hidden";
}
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
		<script type="text/javascript" src="<%=HeadConst.apache_url%>/main/js/jquery.multiselect.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/js/jquery.multiselect.css">
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
    				/* $("#example").multiselect({
    				    header: false,
    				    height: 200,
    				    minWidth: 200,
    					selectedList: 10,//预设值最多显示10被选中项
    					noneSelectedText: '请选择',
    				    close: function(){
    				      var values= $("#example").val();
    					 $("#ClubAcademy").val(values);
    					}
    			 }); */
    				//$("#ClubAcadeMyNew").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
			}
			function submitthis(flag){
				var TeaName = $('#TeaName').val();
				if(TeaName==""){
					alert("请录入新指导教师！");
					$('#TeaName').focus();
					return;
				}
				var TeaSex = $('#TeaSex').val();
				if(TeaSex=="-1"){
					alert("请选择新指导教师性别！");
					$('#TeaSex').focus();
					return;
				}
				var TeaNation = $('#TeaNation').val();
				if(TeaNation=="-1"){
					alert("请选择新指导教师民族！");
					$('#TeaNation').focus();
					return;
				}
				var TeaPolitics = $('#TeaPolitics').val();
				if(TeaPolitics=="-1"){
					alert("请选择新指导教师政治面貌！");
					$('#TeaPolitics').focus();
					return;
				}
				var TeaAcademy = $('#TeaAcademy').val();
				if(TeaAcademy=="-1"){
					alert("请选择新指导教师所在学院！");
					$('#TeaAcademy').focus();
					return;
				}
				var TeaTel = $('#TeaTel').val();
				if(TeaTel==""){
					alert("请选择新指导教师电话！");
					$('#TeaTel').focus();
					return;
				} else {
					var myreg=/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
					if(!myreg.test(TeaTel)){
				    	alert("电话格式不正确！");
				    	$('#TeaTel').focus();
				    	return;
				    } 
				}
				var TeaPhone = $('#TeaPhone').val();
				if(TeaPhone==""){
					alert("请选择新指导教师手机！");
					$('#TeaPhone').focus();
					return;
				} else {
					var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
					var TeaPhone = $('#TeaPhone').val();
					if(!myreg.test(TeaPhone)){
				    	alert("手机格式不正确！");
				    	$('#TeaPhone').focus();
				    	return;
				    } 
				}
				var TeaEmail = $('#TeaEmail').val();
				if(TeaEmail==""){
					alert("请选择新指导教师E-mail！");
					$('#TeaEmail').focus();
					return;
				} else {
					var myreg2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
					var TeaEmail = $('#TeaEmail').val();
					if(!myreg2.test(TeaEmail)){
				    	alert("邮箱格式不正确！");
				    	$('#TeaEmail').focus();
				    	return false;
				    } 
				}
				var TeaAcademic = $('#TeaAcademic').val();
				if(TeaAcademic==""){
					alert("请选择新指导教师个人情况简介！");
					$('#TeaAcademic').focus();
					return;
				}
				$('#CheckFlag').val(flag);
				document.postForm.submit();
				
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团变更指导教师</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团变更指导教师") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubModifyTeacherAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%if(userInfo.hasFunPower(Power.STUSER)&&v.getCheckFlag().equals("")){ %>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(0)">提交</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis('')">保存</a></li>
						<%} %>
						<%if(userInfo.hasFunPower(Power.UserAdminPower)&&v.getCheckFlag().equals("0")){ %>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(2)">审核未通过</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(1)">审核通过</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<div id="tabs">
					<ul>
							<li><a href="#tabs-1">原指导教师信息</a></li>
							<li><a href="#tabs-2">新指导教师信息</a></li>
							<%
							if (!"".equals(v.getCheckFlag())) {%>
								<li><a href="#tabs-3">指导单位审核</a></li>
							<%}
							%>
					</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											<div id="tabs-1" style="border: 0px;">
                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, club.getId()+"", "ClubName", "",true)%>
                    													</td>
                    													<td align="right" class="form_label">社团类别</td>
														    			<td align="left"  bgcolor="#ffffff" >
<%=HtmlTool.renderSelect(ClubTypeNameoptions, club.getClubType(), "ClubType", "",true)%>
                    													</td>
													  				<td align="right" class="form_label">社团账号</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%=ClubId %>
														    			<input type="<%=flag %>" name="ClubId" value="<%=club.getClubId()%>">
                    													</td>
													  				</tr>
                    												<%-- <tr>
                    													<td align="right" class="form_label">原指导教师</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													<select id="example" name="example" multiple="multiple" style="width:400px">
																		<%//=HtmlTool.renderMulSelectOption(UserCnNameOptions,v.getClubAcademy(),""+Tool.join(",",tidsList)) %>
																		</select>
																		<%=Tool.join(",",tidsList) %>
																		<input id="ClubAcademy" name="ClubAcademy" value="<%=Tool.join(",",tidsList) %>" type="hidden"/>
                    													</td>
                    													<td align="right" class="form_label">新指导教师</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													<select id="ClubAcadeMyNew"data-placeholder="请选择" name="ClubAcadeMyNew" multiple="multiple" style="width:400px">
																		<%//=HtmlTool.renderMulSelectOption(UserCnNameOptionsNew,v.getClubAcadeMyNew(),"") %>
																		</select>
																		<input id="ClubAcadeMyNew" name="ClubAcadeMyNew" value="<%=v.getClubAcadeMyNew()%>"/> 
                    													</td>
													  				</tr> --%>
													  				<%
													  				ClubUtil util = new ClubUtil();
													  				Map<String,List>map = new HashMap<String,List>();
													  				List oldList = new ArrayList();
													  				List newList = new ArrayList();
													  				if (v.getId()!=-1) {
													  					map = util.getClubTeacher(club.getId(),v.getClubAcademy(),v.getClubAcadeMyNew());
													  					oldList = map.get("oldList")==null?new ArrayList():map.get("oldList");
													  					newList = map.get("newList")==null?new ArrayList():map.get("newList");
													  				} else {
													  					List teacherList = util.getClubTeacher(club.getId());
													  					if (teacherList.size()>0) {
													  						oldList = teacherList;
													  					}
													  				}
													  				List sexOptions = CEditConst.getsexOptions(userInfo,"-1");
													  				List PoliticsNameOptions = CEditConst.getPoliticsNameOptions(userInfo,"-1");
													  				List NationNameOptions = CEditConst.getNationNameOptions(userInfo,"-1");
													  				if (oldList.size()>0) {
													  					for (int i=0;i<oldList.size();i++) {
													  						ClubTeacher teacher = (ClubTeacher)oldList.get(i);
													  						//if (teacher.getCheckFlag()==1) {%>
																				<tr>
																				<td align="right" class="form_label">指导教师</td>
																				     <td align="left"  bgcolor="#ffffff">
																				      <%=teacher.getTeaName() %>
																				      <input id="ClubAcademy" name="ClubAcademy" value="<%=teacher.getId() %>" type="hidden"/>
																				     </td>
																					<td align="right" class="form_label">性别</td>
																				     <td align="left"  bgcolor="#ffffff">
																				      <%=HtmlTool.renderSelect(sexOptions,""+teacher.getTeaNation(),"","",true) %>
																				     </td>
																				
																					<td align="right" class="form_label">年龄</td>
																				    <td align="left"  bgcolor="#ffffff"><%=teacher.getTeaAge()%></td>
																				</tr>  
																				<tr>
																					<td align="right" class="form_label">民族</td>
																				     <td align="left"  bgcolor="#ffffff">
																				     <%=HtmlTool.renderSelect(NationNameOptions,""+teacher.getTeaNation(),"","",true) %>
																				     </td>
																					<td align="right" class="form_label">政治面貌</td>
																				    <td align="left"  bgcolor="#ffffff">
																				     <%=HtmlTool.renderSelect(PoliticsNameOptions,""+teacher.getTeaPolitics(),"","",true) %>
																				    </td>
																					<td align="right" class="form_label">籍贯</td>
																				     <td align="left"  bgcolor="#ffffff">
																				     <%=teacher.getTeaBirthplace()%>
																				     </td>
																				</tr>   
																				<tr>
																					<td align="right" class="form_label">职务</td>
																				    <td align="left"  bgcolor="#ffffff"><%=teacher.getTeaDuty()%></td>
																					<td align="right" class="form_label">所在学院（部门）</td>
																				     <td align="left"  bgcolor="#ffffff" colspan="3">
																				     <%=HtmlTool.renderSelect(AcademyNameoptions,""+teacher.getTeaAcademy(),"","",true) %>
																				     </td>
																				</tr>   
																				<tr>
																					<td align="right" class="form_label">联系方式</td>
																					<td align="left"  bgcolor="#ffffff">&nbsp;电&nbsp;&nbsp;&nbsp;话
																					<%=teacher.getTeaTel()%>
																					</td>
																					<td align="left"  bgcolor="#ffffff" colspan="2">&nbsp;手&nbsp;&nbsp;&nbsp;机
																					<%=teacher.getTeaPhone()%>
																					</td>
																					<td align="left"  bgcolor="#ffffff" colspan="2">E-mail
																					<%=teacher.getTeaEmail()%>
																					</td>
																				</tr>
																				<tr>
																					<td align="right" class="form_label" >个人情况简介<br/>（社团相关）</td>
																					<td align="left"  bgcolor="#ffffff" colspan="5"><%=teacher.getTeaAcademic() %></td>
																				</tr>
													  							<%}
													  						}
													  					//}
													  				//map.clear();
													  				%>
																
													  				
                    												
<input type="hidden" id="CheckFlag"name="CheckFlag" value="<%=v.getCheckFlag()%>">
<input type="hidden" name="ApplyDate" value="<%=v.getApplyDate()%>">
<input type="hidden" name="AddTime" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
<input type="hidden" name="AddPerson" id="AddPerson" value="<%=("".equals(v.getAddPerson()))?userInfo.getId()+"":v.getAddPerson()%>"/>
<input type="hidden" name="ModiPerson" value="<%=v.getModiPerson()%>">  
<input type="hidden" name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">  
                    											</table>
                    											</div>
                    											<div id="tabs-2" style="border: 0px;">
                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, club.getId()+"", "", "",true)%>
                    													</td>
                    													<td align="right" class="form_label">社团类别</td>
														    			<td align="left"  bgcolor="#ffffff" >
<%=HtmlTool.renderSelect(ClubTypeNameoptions, club.getClubType(), "", "",true)%>
                    													</td>
													  				<td align="right" class="form_label">社团账号</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
														    			<%=ClubId %>
                    													</td>
													  				</tr>
													  				<%
													  				if (v.getId()!=-1) {
													  					map = util.getClubTeacher(club.getId(),v.getClubAcademy(),v.getClubAcadeMyNew());
													  					oldList = map.get("oldList")==null?new ArrayList():map.get("oldList");
													  					newList = map.get("newList")==null?new ArrayList():map.get("newList");
													  				} 
													  				//if (newList.size()>0) {
													  					//for (int i=0;i<newList.size();i++) {
													  						ClubTeacher teacher = new ClubTeacher();
													  						if (newList.size()>0)
													  							teacher = (ClubTeacher)newList.get(0)==null?new ClubTeacher():(ClubTeacher)newList.get(0);
													  						//if (teacher.getCheckFlag()==1) {%>
																				<tr>
																				<td align="right" class="form_label">指导教师</td>
																				     <td align="left"  bgcolor="#ffffff">
																				      <input id="Tid"name="Tid" value="<%=teacher.getId()==-1%>" type="hidden"/>
																				      <input id="TeaName"name="TeaName" value="<%=teacher.getTeaName() %>" />
																				      <input id="ClubAcadeMyNew" name="ClubAcadeMyNew" value="<%=teacher.getId() %>" type="hidden"/>
																				     </td>
																					<td align="right" class="form_label">性别</td>
																				     <td align="left"  bgcolor="#ffffff">
																				      <%=HtmlTool.renderSelect(sexOptions,""+teacher.getTeaSex(),"TeaSex","") %>
																				     </td>
																				
																					<td align="right" class="form_label">年龄</td>
																				    <td align="left"  bgcolor="#ffffff">
																				    <input id="TeaAge" name="TeaAge" value="<%=teacher.getTeaAge()%>"/>
																				    </td>
																				 </tr>  
																				<tr>
																					<td align="right" class="form_label">民族</td>
																				     <td align="left"  bgcolor="#ffffff">
																				     <%=HtmlTool.renderSelect(NationNameOptions,""+teacher.getTeaNation(),"TeaNation","") %>
																				     </td>
																				
																					<td align="right" class="form_label">政治面貌</td>
																				    <td align="left"  bgcolor="#ffffff">
																				     <%=HtmlTool.renderSelect(PoliticsNameOptions,""+teacher.getTeaPolitics(),"TeaPolitics","") %>
																				    </td>
																					<td align="right" class="form_label">籍贯</td>
																				     <td align="left"  bgcolor="#ffffff">
																				     <input id="TeaBirthplace" name="TeaBirthplace" value="<%=teacher.getTeaBirthplace()%>"/>
																				     </td>
																				</tr>   
																				<tr>
																					<td align="right" class="form_label">职务</td>
																				    <td align="left"  bgcolor="#ffffff">
																				    <input id="TeaDuty" name="TeaDuty" value="<%=teacher.getTeaDuty()%>"/>
																				    </td>
																					<td align="right" class="form_label">所在学院（部门）</td>
																				     <td align="left"  bgcolor="#ffffff" colspan="3">
																				     <%=HtmlTool.renderSelect(AcademyNameoptions,""+teacher.getTeaAcademy(),"TeaAcademy","") %>
																				     </td>
																				</tr>   
																				<tr>
																					<td align="right" class="form_label">联系方式</td>
																					<td align="left"  bgcolor="#ffffff" >&nbsp;电&nbsp;&nbsp;&nbsp;话
																					<input id="TeaTel" name="TeaTel" value="<%=teacher.getTeaTel()%>"/>
																					</td>
																					<td align="left"  bgcolor="#ffffff" colspan="2">&nbsp;手&nbsp;&nbsp;&nbsp;机
																					<input id="TeaPhone" name="TeaPhone" value="<%=teacher.getTeaPhone()%>"/>
																					</td>
																					<td align="left"  bgcolor="#ffffff" colspan="2">E-mail
																					<input id="TeaEmail" name="TeaEmail" value="<%=teacher.getTeaEmail()%>"/>
																					</td>
																				</tr>
																				
																				<tr>
																					<td align="right" class="form_label" >个人情况简介<br/>（社团相关）</td>
																					<td align="left"  bgcolor="#ffffff" colspan="5">
																					<textarea rows="3" cols="100" id="TeaAcademic" name="TeaAcademic"><%=teacher.getTeaAcademic() %></textarea>
																					</td>
																				</tr>
													  							<%//}
													  						//}
													  					//}
													  				map.clear();
													  				%>
 
                    											</table>
                    											</div>
                    											<%
                    											if((userInfo.hasFunPower(Power.STUSER)&&!"".equals(v.getCheckFlag()))||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)||userInfo.hasFunPower(Power.UserAdminPower)){
                    											%>
                    											<div id="tabs-3" style="border: 0px;">
                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">指导单位意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="CommentXy" id="CommentXy" cols="40" rows="4" style="width: 100%;"><%=v.getCommentXy()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<%} else {%>
                    												<input type="hidden" id="CommentXy" name="CommentXy" value="<%=v.getCommentXy()%>"/>
                    											<%}%>
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
