<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
		

</head>
<body>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
}
List OrgNameoptions=CEditConst.getOrgCityNameOptions(userInfo);
int id= ParamUtils.getIntParameter(request, "id", -1);
BaseUserCode v= new BaseUserCode();
v= v.getById(id);
List xyxdt= new ArrayList();
xyxdt.add("flag=1");
List DeptNameoptions=COptionConst.getAcademyNameOptions(userInfo,"",xyxdt);
List GradeNameOptions= CEditConst.getGradeNameOptions(userInfo);
List genderoptions=CEditConst.getsexOptions(userInfo);
%>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<div class="browsetable" id="form">

<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#D2D2D2">
													              	<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=v.getCnName() %>
                    													</td>
                    												                   													
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">校区</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=HtmlTool.renderSelect(OrgNameoptions, "" + v.getOrgId(), "OrgId", "-1",true)%>
                    													</td>
                    												                   													
													  				</tr>
													  				<tr>
													  					<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff"">
																		<%=HtmlTool.renderSelect(DeptNameoptions, "" + v.getDeptId(), "DeptId", "-1",true)%>
                    													</td> 
																</tr>
                    												<tr>
                    													<td align="right" class="form_label">学号</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Name" size="30" maxlength="30" value="<%=v.getName()%>"  />
																			<font color="red">*(请用英文字母或数字)</font>
																			<!-- TODO 验证唯一性、验证合法字符 -->
													  				</tr>
													  			
                    												<tr>
                    														<td align="right" class="form_label">年级</td>
														    			<td bgcolor="#FFFFFF" align="left">
														    			<%=HtmlTool.renderSelect(GradeNameOptions, "" + v.getGrade(), "Grade", "-1",true)%>
                    														
                    													</td>
                    												
                    													
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label"">性别</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=HtmlTool.renderSelect(genderoptions, "" + v.getGender(), "Gender", "-1",true)%>
                    													</td>
													  				</tr>
													  			
																
                    											
                    												<tr>
                    																									  				
                    													
                    													<td align="right" class="form_label">手机号码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="MobilePhone" size="30" maxsize="30" value="<%=v.getMobilePhone()%>"/>
                    													</td>
                    																								  
                    													
													  				 				
                    													
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">电子邮箱</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Email" size="30" maxsize="30" value="<%=v.getEmail()%>"/>
                    													</td>
													  				
													  				
													  				
													  				
													  				</tr>
													  				
                    											
													  			
                    											

                    												
                    											
													  			
                    											</table>
</div>
</body>
</html>