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
List OrgNameoptions = CEditConst.getOrgCityNameOptions(userInfo,"-1");
List Privilegeoptions = (List)request.getAttribute("Privilegeoptions");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"");
List MajorNameOptions = CEditConst.getMajorNameOptions(userInfo,"");
List ClassesNameOptions = CEditConst.getClassesNameOptions(userInfo,"-1");
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
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=HeadConst.apache_url%>/main/js/formfunction.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
		<%-- <script src="<%=HeadConst.apache_url%>/main/js/jquery-1.8.3.min.js"></script> --%>
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
			function saveform(){
				alert('新添加用户信息的初始密码为"123456"');
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
                									<td width="100"><b>[人员管理]</b></td>
                									<td>&nbsp;</td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                									<%
                									if(cmd.equals("save")){
                									%>
                									<td width="55"><a href="javascript:if (checkform()) saveform()">保存</a></td>  
                									<%}else{
                									%>
                									<td width="55"><a href="javascript:checkform()">保存</a></td>           									
                									<%}
                									 %>
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
														<div id="errorDiv" style="color:red;font-weight:bold">创建时，密码默认为：123456</div>
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
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">城市</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=HtmlTool.renderSelect(OrgNameoptions, "" + v.getOrgId(), "OrgId", "-1")%>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">学院</td>
														    			<td bgcolor="#FFFFFF" align="left">
																		<%=HtmlTool.renderSelect(DeptNameoptions, "" + v.getDeptId(), "DeptId", "-1")%>
                    													</td>                    													
													  				</tr>
																	<%
																	if("update".equals(cmd)){
																	if(userInfo.hasFunPower(Power.ADMINPOWER)){
																	%>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">用户帐号</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Name" size="40" maxlength="50" value="<%=v.getName()%>" onblur="javascript:document.postForm.Code.value = document.postForm.Name.value;" />
																			<font color="red">*(请用英文字母或数字)</font>
																			<!-- TODO 验证唯一性、验证合法字符 -->
                    													</td>
                    														<td bgcolor="#FFFFFF" align="right">用户显示名</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="CnName" size="40" maxsize="50" value="<%=v.getCnName()%>"/>
                    													</td>
													  				</tr>
													  				<% }else {%>
													  					<tr>
                    													<td bgcolor="#FFFFFF" align="right">用户帐号</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Name" size="40" maxlength="50" value="<%=v.getName()%>" onblur="javascript:document.postForm.Code.value = document.postForm.Name.value;" readonly/>
																			<font color="red">*(请用英文字母或数字)</font>
                    													</td>
                    														<td bgcolor="#FFFFFF" align="right">用户显示名</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="CnName" size="40" maxsize="50" value="<%=v.getCnName()%>" readonly/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">用户编码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Code" size="40" maxsize="50" value="<%=v.getCode()%>" readonly/>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">性别</td>
														    			<td bgcolor="#FFFFFF" align="left">
																		<%=HtmlTool.renderSelect(genderoptions, "" + v.getGender(), "Gender", "-1")%>
                    													</td>
													  				
                    													<%-- <td bgcolor="#FFFFFF" align="right">用户职责</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<input name="Occupation" size="40" maxsize="50" value="<%=v.getOccupation()%>" readonly/>
                    														
                    													</td> --%>
					
                    													<td bgcolor="#FFFFFF" align="right">年级</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<%=HtmlTool.renderSelect(GradeNameOptions, "" + v.getGrade(), "Grade", "-1")%>
                    														
                    													</td>
													  				</tr>
													  				
													  				
													  			   <% 
													  			   }
																	}else{
																 %>
																		<tr>
                    													<td bgcolor="#FFFFFF" align="right">用户帐号</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Name" size="40" maxlength="50" value="<%=v.getName()%>" onblur="javascript:document.postForm.Code.value = document.postForm.Name.value;" />
																			<font color="red">*(请用英文字母或数字)</font>
																			<!-- TODO 验证唯一性、验证合法字符 -->
                    													</td>
                    														<td bgcolor="#FFFFFF" align="right">用户显示名</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="CnName" size="40" maxsize="50" value="<%=v.getCnName()%>"/>
                    													</td>
													  				</tr>
                    												
                    											
                    												<%-- <tr>
                    													<td bgcolor="#FFFFFF" align="right">用户职责</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<input name="Occupation" size="40" maxsize="50" value="<%=v.getOccupation()%>"/>
                    														
                    													</td>
					
                    													
													  				</tr> --%>
																<%
																	}
																
																%>		
																<tr>
                    													<%-- <td bgcolor="#FFFFFF" align="right">用户编码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Code" size="40" maxsize="50" value="<%=v.getCode()%>"/>
                    													</td> --%>
                    													 <td bgcolor="#FFFFFF" align="right">性别</td>
														    			<td bgcolor="#FFFFFF" align="left">
																		<%=HtmlTool.renderSelect(genderoptions, "" + v.getGender(), "Gender", "-1")%>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">年级</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<%=HtmlTool.renderSelect(GradeNameOptions, "" + v.getGrade(), "Grade", "-1")%>
                    														
                    													</td>
													  				</tr>
													  				<tr>
                    													 <td bgcolor="#FFFFFF" align="right">专业</td>
														    			<td bgcolor="#FFFFFF" align="left">
																		<%=HtmlTool.renderSelect(MajorNameOptions, "" + v.getMajor(), "Major", "-1")%>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">班级</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<%=HtmlTool.renderSelect(ClassesNameOptions, "" + v.getZhiBu(), "ZhiBu", "-1")%>
                    														
                    													</td>
													  				</tr>
																<tr>
																<td bgcolor="#FFFFFF" align="right">入校时间</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input  class="date" name="TimeToSchool" id="TimeToSchool" onfocus="WdatePicker({el:'TimeToSchool',dateFmt:'yyyy-MM-dd'})"  size="0" value="<%=Tool.stringOfDate(v.getTimeToSchool()).equals("0001-01-01")?"":Tool.stringOfDate(v.getTimeToSchool())%>"/>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">毕业时间</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<input  class="date" name="GraduateTime" id="GraduateTime" onfocus="WdatePicker({el:'GraduateTime',dateFmt:'yyyy-MM-dd'})"  size="0" value="<%=Tool.stringOfDate(v.getGraduateTime()).equals("0001-01-01")?"":Tool.stringOfDate(v.getGraduateTime())%>"/>
                    													</td>
																</tr>
																<tr>
																<td bgcolor="#FFFFFF" align="right">学制</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input id="LenOfSchool"maxsize="5" name="LenOfSchool" value="<%=v.getLenOfSchool()%>" type="number"/>年
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">是否可用</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "1")%><span style="color: red;">*(学生用户毕业后设置为：否)</span>
                    													</td>
																</tr>
                    												<tr>
													  					<%-- <td bgcolor="#FFFFFF" align="right">主管领导</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Principal" size="40" maxsize="50" value="<%=v.getPrincipal()%>"/>
                    													</td> --%>
                    													<td bgcolor="#FFFFFF" align="right">办公电话</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="PhoneNum" size="40" maxsize="50" value="<%=v.getPhoneNum()%>"/>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">用户办公室地址</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<input name="OfficeAddress" size="40" maxsize="50" value="<%=v.getOfficeAddress()%>"/>
                    														
                    													</td>
													  				</tr>
													  				<tr>
													  				<td bgcolor="#FFFFFF" align="right">手机</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Phone" size="40" maxsize="50" value="<%=v.getPhone()%>"/>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">电子邮箱</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Email" size="40" maxsize="50" value="<%=v.getEmail()%>"/>
                    													</td>	
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">微信</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="MobilePhone" size="40" maxsize="50" value="<%=v.getMobilePhone()%>"/>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">QQ</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Email2" size="40" maxsize="50" value="<%=v.getEmail2()%>"/>
                    													</td>											  
                    													<%-- <td bgcolor="#FFFFFF" align="right">传真号码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Fax" size="40" maxsize="50" value="<%=v.getFax()%>"/>
                    													</td> --%>
                    															
													  				</tr>
													  			
													  				
													  				
                    												<tr> 
                    														<td bgcolor="#FFFFFF" align="right">家庭地址</td>
														    			<td bgcolor="#FFFFFF" align="left" colspan="3">
														    			<input name="HomeAddress" size="40" maxsize="50" value="<%=v.getHomeAddress()%>"/>
                    														
                    													</td>
                    																						  			
                    													<%-- <td bgcolor="#FFFFFF" align="right">住址邮编</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="HomeZipcode" size="12" maxsize="12" value="<%=v.getHomeZipcode()%>"/>
                    													</td> --%>
                    															
													  				</tr>

                    												<!-- <tr> -->
													  				
                    													<%-- <td bgcolor="#FFFFFF" align="right">单位邮编</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="DeptZipcode" size="12" maxsize="12" value="<%=v.getDeptZipcode()%>"/>
                    													</td> --%>
													  				
                    													<%-- <td bgcolor="#FFFFFF" align="right">用户Ip电话</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="UserIpphome" size="40" maxsize="50" value="<%=v.getUserIpphome()%>"/>
                    													</td> --%>
													  			<!-- </tr> -->
													  			<input type="hidden" name="DispNum" value="<%=v.getDispNum()%>"/>
													  			<input type="hidden" name="OrderbyField" size="20" maxsize="20" value="<%=v.getOrderbyField()%>"/>
                    												<%-- <tr>
                    												<td bgcolor="#FFFFFF" align="right">显示的条数</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="DispNum" value="<%=v.getDispNum()%>"/>
                    													</td>													  				
                    													<td bgcolor="#FFFFFF" align="right">按字段排序</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="OrderbyField" size="20" maxsize="20" value="<%=v.getOrderbyField()%>"/>
                    													</td>
													  						</tr> --%>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">用户角色</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<textarea name="RoleName" id="RoleName" cols="30",rows="2"><%=roleName %></textarea>
														    			<img src="<%=HeadConst.apache_url %>/main/images/browse.png" width="16" align="absmiddle" style="cursor: pointer;"  onclick="javascript:choice()" />
														    			<input type="hidden" name="Roles" id="Roles" value="<%=v.getRoles() %>" > 
                    													</td>  
                    													<td bgcolor="#FFFFFF" align="right">身份证号码</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<input id="IDNum" name="IDNum" value="<%=v.getIDNum()%>"/>
																			<%-- <%=HtmlTool.renderSelect(OrderStyleoptions, v.getOrderStyle(), "OrderStyle", "")%> --%>
                    													</td>
                    													
													  				</tr>
													  				<%if(cmd.equals("update")&&userInfo.hasFunPower(Power.ADMINPOWER)){
													  					//log.debug("获取密码-------------"+Tool.decrypt(v.getPwd()));
													  				%>
													  					<tr>
                    													<td bgcolor="#FFFFFF" align="right">密码管理</td>
														    			<td bgcolor="#FFFFFF" align="left"><input type="password" name="Pwd"id="Pwd"value="<%=Tool.decrypt(v.getPwd())%>"/>
                    													</td>
                    													<td bgcolor="#FFFFFF" align="right">&nbsp;</td>
														    			<td bgcolor="#FFFFFF" align="left">&nbsp;
                    													</td>
                    													</tr>
													  				<%} %>
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
