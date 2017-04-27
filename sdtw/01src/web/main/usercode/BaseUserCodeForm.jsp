<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--人员管理--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%@ include file="/main/js/jsheader.jsp"%>
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
List YesNooptions = (List)request.getAttribute("YesNooptions");
List RoleNameoptions = (List)request.getAttribute("RoleNameoptions");
List sexoptions = (List)request.getAttribute("sexoptions");
List LenOfSchooloptions = (List)request.getAttribute("LenOfSchooloptions");
List NationNameoptions = (List)request.getAttribute("NationNameoptions");
List MajorNameoptions = (List)request.getAttribute("MajorNameoptions");
List ClassesNameoptions = (List)request.getAttribute("ClassesNameoptions");
List DeptNameoptions = (List)request.getAttribute("DeptNameoptions");
List OrgNameoptions = (List)request.getAttribute("OrgNameoptions");
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
			function save(){
				var ok=true;
				var name=$("#Name").val();
				var pwd=$("#Pwd").val();
				var cnname=$("#CnName").val();
				if(name==""){
					alert("账号不能为空");
					return;
				}
				if(name.length>30){
					alert("账号长度不能超过30");
					return;
				}
				if(pwd==""){
					alert("密码不能为空");
					return;
				}
				if(pwd.length>30){
					alert("密码长度不能超过30");
					return;
				}
				if(cnname==""){
					alert("姓名不能为空");
					return;
				}
				if(name.length>30){
					alert("姓名长度不能超过30");
					return;
				}
				
				//alert(name);
				 $.ajax({
						url:"userCheck.jsp?cmd=chaxun&user="+name,
						type: "post",
						dataType:"json",
						async:false,
						success:function(data){
							if(data.msg=="no"){
								alert("账户已经存在,请重新输入");
								ok=false;
								
							}
							if(data.msg=="ok"){
								
							     
							
									
							}
							
							
						},
						error: function (error) {
				            alert("信息出错！");
				        }
						
					});
				 
				 $("#Code").val(name+123);
				 if(ok){
				 document.postForm.submit();
				 }
			}
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">人员管理</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("人员管理") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="BaseUserCodeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<li><a href="javascript:void(0);" onclick="save();">保存</a></li>
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
                    													<td align="right" class="form_label">用户帐号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input   name="Name" id="Name" size="50" maxsize="50" value="<%=v.getName()%>">
                    													</td>
                    													<td align="right" class="form_label">用户密码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Pwd" id="Pwd" size="50" maxsize="50" value="<%=Tool.decrypt(v.getPwd())%>">
                    													</td>
                    												
													  				</tr>
<input type="hidden" name="OrgCode" value="<%=v.getOrgCode()%>">

                                                                   	<tr>
                    													<td align="right" class="form_label">用户姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CnName" id="CnName" size="50" maxsize="50" value="<%=v.getCnName()%>">
                    													</td>
                    														<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(sexoptions, "" + v.getGender(), "Gender", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所在校区</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(OrgNameoptions, "" + v.getOrgId(), "OrgId", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">用户角色类型</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(RoleNameoptions, "" + v.getRoles(), "RoleName", "-1")%>
                    													</td>
													  				</tr>
<input type="hidden" name="DeptCode" value="<%=v.getDeptCode()%>">
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Phone" id="Phone" size="50" maxsize="50" value="<%=v.getPhone()%>">
                    													</td>
                    													<td align="right" class="form_label">电子邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email" id="Email" size="50" maxsize="50" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PhoneNum" id="PhoneNum" size="50" maxsize="50" value="<%=v.getPhoneNum()%>">
                    													</td>
                    														<td align="right" class="form_label">用户所属部门</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(DeptNameoptions, "" + v.getDeptId(), "DeptId", "-1")%>
                    													</td>
                    													<input type="hidden" name="Dept"></input>
													  				</tr>
													  				
                    											
                    												<tr style="display: none">
                    													<td align="right" class="form_label">用户编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Code" id="Code" size="50" maxsize="50" value="">
                    													</td>
													  				</tr>
                    											
                    												<tr style="display: none">
                    													<td align="right" class="form_label">用户职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Occupation" id="Occupation" cols="40" rows="2"><%=v.getOccupation()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">用户职称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Grade" id="Grade" cols="40" rows="2"><%=v.getGrade()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    												
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Orderby" id="Orderby" value="<%=v.getOrderby()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">主管领导</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Principal" id="Principal" size="50" maxsize="50" value="<%=v.getPrincipal()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">办公电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PhoneNum" id="PhoneNum" size="50" maxsize="50" value="<%=v.getPhoneNum()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">手机号码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MobilePhone" id="MobilePhone" size="50" maxsize="50" value="<%=v.getMobilePhone()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">传真号码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Fax" id="Fax" size="50" maxsize="50" value="<%=v.getFax()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">用户办公室地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="OfficeAddress" id="OfficeAddress" cols="40" rows="2"><%=v.getOfficeAddress()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">电子邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email" id="Email" size="50" maxsize="50" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="Pwd" value="<%=v.getPwd()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">家庭地址</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="HomeAddress" id="HomeAddress" cols="40" rows="2"><%=v.getHomeAddress()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">住址邮编</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="HomeZipcode" id="HomeZipcode" size="12" maxsize="12" value="<%=v.getHomeZipcode()%>">
                    													</td>
													  				</tr> 
                    												<tr style="display: none">
                    													<td align="right" class="form_label">单位邮编</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DeptZipcode" id="DeptZipcode" size="12" maxsize="12" value="<%=v.getDeptZipcode()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">用户Ip电话(代办改变否)</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UserIpphome" id="UserIpphome" size="50" maxsize="50" value="<%=v.getUserIpphome()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">最后访问时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="LastTime" id="LastTime" size="0" value="<%=Tool.stringOfDateTime(v.getLastTime())%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">皮肤Id号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="SkinId" id="SkinId" cols="40" rows="2"><%=v.getSkinId()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">显示的条数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DispNum" id="DispNum" value="<%=v.getDispNum()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">按字段排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OrderbyField" id="OrderbyField" size="20" maxsize="20" value="<%=v.getOrderbyField()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">排序方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">用户角色</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(RoleNameoptions, v.getRoles(), "Roles", "")%>
                    													</td>
													  				</tr>
<input type="hidden" name="Enable" value="<%=v.getEnable()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">是否初次登录</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="IsFirstLogon" id="IsFirstLogon" value="<%=v.getIsFirstLogon()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="OperTime" value="<%=v.getOperTime()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">操作日志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="OperLog" id="OperLog" cols="40" rows="2"><%=v.getOperLog()%></textarea>
                    													</td>
													  				</tr>
<input type="hidden" name="OperUser" value="<%=v.getOperUser()%>">
<input type="hidden" name="LocusCode" value="<%=v.getLocusCode()%>">
<input type="hidden" name="LogonNum" value="<%=v.getLogonNum()%>">
<input type="hidden" name="CurIp" value="<%=v.getCurIp()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">本次登录时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CurTime" id="CurTime" size="0" value="<%=Tool.stringOfDateTime(v.getCurTime())%>">
                    													</td>
													  				</tr>
<input type="hidden" name="IsEnable" value="<%=v.getIsEnable()%>">
<input type="hidden" name="Ip" value="<%=v.getIp()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">学历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Identity" id="Identity" size="45" maxsize="45" value="<%=v.getIdentity()%>">
                    													</td>
													  				</tr>
                    												<tr >
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(PoliticsNameoptions, v.getMemberPolitics(), "MemberPolitics", "")%>
                    													</td>
                    													<td align="right" class="form_label">专业</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(MajorNameoptions, v.getMajor(), "Major", "")%>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">入校时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeToSchool" id="TimeToSchool" size="0" value="<%=Tool.stringOfDateTime(v.getTimeToSchool())%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">入团时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeToTuan" id="TimeToTuan" size="0" value="<%=Tool.stringOfDateTime(v.getTimeToTuan())%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">生日</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Birthday" id="Birthday" size="0" value="<%=Tool.stringOfDateTime(v.getBirthday())%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">支部</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClassesNameoptions, v.getZhiBu(), "ZhiBu", "")%>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">民族</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(NationNameoptions, v.getNation(), "Nation", "")%>
                    													</td>
													  				</tr>
                    											
                    												<tr style="display: none">
                    													<td align="right" class="form_label">学制</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(LenOfSchooloptions, v.getLenOfSchool(), "LenOfSchool", "")%>
                    													</td>
													  				</tr>
													  				
                    												<tr style="display: none">
                    													<td align="right" class="form_label">籍贯</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="NativePlace" id="NativePlace" size="50" maxsize="50" value="<%=v.getNativePlace()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">身份证号码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="IDNum" id="IDNum" size="50" maxsize="50" value="<%=v.getIDNum()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Phone" id="Phone" size="50" maxsize="50" value="<%=v.getPhone()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Email2" id="Email2" size="50" maxsize="50" value="<%=v.getEmail2()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">附件</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addfilelist" id="Addfilelist" size="50" maxsize="50" value="<%=v.getAddfilelist()%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">学年</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="YearToSchool" id="YearToSchool" cols="40" rows="2"><%=v.getYearToSchool()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">毕业时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="GraduateTime" id="GraduateTime" size="0" value="<%=Tool.stringOfDateTime(v.getGraduateTime())%>">
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">是否青年志愿者</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, v.getVolunteerfFag(), "VolunteerfFag", "")%>
                    													</td>
													  				</tr>
													  				<input type="hidden" name=OrderStyle>
                    											</table>
			</form>
		</div>
	</body>
</html>
