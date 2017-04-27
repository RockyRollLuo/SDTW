<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.db.BaseRoleCode"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="../js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(BaseUserCode.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	BaseUserCode v = (BaseUserCode)request.getAttribute("fromBean");
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
List genderoptions = (List)request.getAttribute("genderoptions");
List RoleNameoptions = (List)request.getAttribute("RoleNameoptions");
List OrderStyleoptions = (List)request.getAttribute("OrderStyleoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
List DeptNameoptions = CEditConst.getAcademyNameOptions(userInfo,"");
	//(List)request.getAttribute("DeptNameoptions");
List OrgNameoptions = CEditConst.getOrgCityNameOptions(userInfo,"");
List Privilegeoptions = (List)request.getAttribute("Privilegeoptions");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"");
List cdt = new ArrayList();
cdt.add("flag=1");
DeptNameoptions= COptionConst.getAcademyAliasNameOptions(userInfo,"请选择", cdt);
String roles = v.getRoles();
String roleName = "";
BaseRoleCode role = new BaseRoleCode();
if(!roles.equals("")){
	List cdt1 = new ArrayList();
	cdt1.add("id in("+roles+")");
	List<BaseRoleCode> rolelist = role.query(cdt1);
	for(int i=0;i<rolelist.size();i++){
		BaseRoleCode item = rolelist.get(i);
		if(roleName.equals("")){
			roleName = item.getName();
		}else{
			roleName +=","+item.getName();
		}
	}
}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=HeadConst.apache_url%>/main/js/formfunction.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/js/jquery-1.8.3.min.js"></script>
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
			//保存检查
				function checkform(){
			   var name = document.postForm.Name.value;
               var   arg   = /[a-zA-Z0-9]$/; 
			   if(name==""){
			   	   alert("请输入账户！");
			   	   document.postForm.Name.focus();
			   	   return;
			   }else{
			    if(!arg.test(name)){
			   	   	 alert("请用英文字母或数字!");
			   	   	 document.postForm.Name.focus();
			   	   	 return;
			   	 }else if(name.indexOf(" ") >= ""){
					 alert("您的输入不能存有空格！");
					 document.postForm.Name.focus();
					 return;
			   	 }
			   }
			   var cnname = document.postForm.CnName.value;
			   if(cnname==""){
			   	   alert("请输入用户姓名！");
			   	   return;
			   }else{
			    if(cnname.indexOf(" ") >= ""){
					 alert("您的输入不能存有空格！");
					 document.postForm.CnName.focus();
					 return;
			   	 }
			   }
			   document.postForm.submit();
			   return true;
			}
		
			function choice(){
				openWindow("RoleCodeAction.jsp?cmd=select&values="+$("#Roles").val(), "600,400");
			}
			function setRole(reName,reId){
				$("#RoleName").val(reName);
				$("#Roles").val(reId);
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <%@include file="../jqueryui.jsp" %> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr> 
				<td valign="top">
					<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#33577B">
  	 					<tr>
      						<td bgcolor="#FFFFFF" valign="top">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td height="26" background="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbj.png">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="26"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanl.gif"></div></td>
                									<td width="100" colspan="3"><b>[人员管理,新添加的学生用户默认密码为123456]</b></td>
                									<td>&nbsp;</td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                								
                									<td width="55"><a href="javascript:checkform()">保存</a></td>           									
                									
                									<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr4.png"></div></td>
                									<td width="55"><a href="UserCodeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>">返回</a></td>
              									</tr>
            								</table>
										</td>
          							</tr>
          							<tr>
            							<td valign="top"> 
              								<table width="100%" border="0" cellspacing="0" cellpadding="6">
                								<tr>
                  									<td>
														<div id="errorDiv" style="color:red;font-weight:bold"></div>
														<div id="form" style="overflow:auto;height:auto">
															<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
																<input type="hidden" name="cmd" value="<%=cmd%>"/>
																<input type="hidden" name="page" value="<%=currpage%>"/>
																<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      												<tr>
                        												<td height="2"></td>
                      												</tr>
                    											</table>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#D2D2D2">
																<input type="hidden" name="Id" value="<%=v.getId()%>"/>
																<input type="hidden" name="OrgCode" value="<%=v.getOrgCode()%>"/>
																<input type="hidden" name="DeptCode" value="<%=v.getDeptCode()%>"/>
																<%if(cmd.equals("save")){%>
																<input type="hidden" name="Pwd" value="<%=v.getPwd()%>"/>
																<%} %>
																<input type="hidden" name="Enable" value="<%=v.getEnable()%>"/>
																<input type="hidden" name="OperTime" value="<%=v.getOperTime()%>"/>
																<input type="hidden" name="OperUser" value="<%=v.getOperUser()%>"/>
																<input type="hidden" name="LocusCode" value="<%=v.getLocusCode()%>"/>
																<input type="hidden" name="Code" value=""/>
																<input type="hidden" name="Roles" value="3"/>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">校区</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=HtmlTool.renderSelect(OrgNameoptions, "" + v.getOrgId(), "OrgId", "-1")%>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">学院</td>
														    			<td bgcolor="#FFFFFF" align="left">
																		<%=HtmlTool.renderSelect(DeptNameoptions, "" + v.getDeptId(), "DeptId", "-1")%>
                    													</td>                    													
													  				</tr>
																
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">学号</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Name" size="40" maxlength="50" value="<%=v.getName()%>" onblur="javascript:document.postForm.Code.value = document.postForm.Name.value;" />
																			<font color="red">*(请用英文字母或数字)</font>
																			<!-- TODO 验证唯一性、验证合法字符 -->
                    													</td>
                    														<td bgcolor="#FFFFFF" align="right">学生姓名</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="CnName" size="40" maxsize="50" value="<%=v.getCnName()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    														<td bgcolor="#FFFFFF" align="right">年级</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<%=HtmlTool.renderSelect(GradeNameOptions, "" + v.getGrade(), "Grade", "-1")%>
                    														
                    													</td>
                    												
                    													<td bgcolor="#FFFFFF" align="right">性别</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=HtmlTool.renderSelect(genderoptions, "" + v.getGender(), "Gender", "-1")%>
                    													</td>
													  				</tr>
													  			
																
                    											
                    												<tr>
                    																									  				
                    													
                    													<td bgcolor="#FFFFFF" align="right">手机号码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="MobilePhone" size="40" maxsize="50" value="<%=v.getMobilePhone()%>"/>
                    													</td>
                    																								  
                    													<td bgcolor="#FFFFFF" align="right">传真号码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Fax" size="40" maxsize="50" value="<%=v.getFax()%>"/>
                    													</td>
                    															
													  				</tr>
													  				
                    												<tr>
                    														<td bgcolor="#FFFFFF" align="right">家庭地址</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<input name="HomeAddress" size="40" maxsize="50" value="<%=v.getHomeAddress()%>"/>
                    														
                    													</td>
                    													
													  				 				
                    													<td bgcolor="#FFFFFF" align="right">电子邮箱</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Email" size="40" maxsize="50" value="<%=v.getEmail()%>"/>
                    													</td>
                    													</tr>
													  				<%if(v.getId()!=-1){ %>
													  				<tr>
                    													<td bgcolor="#FFFFFF" align="right">学生密码</td>
														    			<td bgcolor="#FFFFFF" align="left" colspan="3">
                    														<input  type="password" name="Pwd" size="40" maxsize="50" value="<%=Tool.decrypt(v.getPwd())%>"/>
                    													</td>
                    												
                    													<%}else{
                    														%>
                    													<td bgcolor="#FFFFFF" align="right">学生密码</td>
														    			<td bgcolor="#FFFFFF" align="left" colspan="3">
                    														<input name="Pwd" size="40" maxsize="50" value="123456"/>
                    													</td>
                    												
                    													
                    													<% }%>
													  				</tr>
                    											

                    												
                    											
													  			
                    											</table>
															</form>
														</div>
													</td>
                								</tr>
              								</table>
					                	</td>
          							</tr>
        						</table> 
							</td>
    					</tr>
  					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
