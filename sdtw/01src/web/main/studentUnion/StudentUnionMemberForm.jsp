<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生会部门成员--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>

<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(StudentUnionMember.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	StudentUnionMember v = (StudentUnionMember)request.getAttribute("fromBean");
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
	BaseUserCode user= userInfo.getUserCode();
List StuDeptNameoptions = (List)request.getAttribute("StuDeptNameoptions");
List OrgNameoptions = CEditConst.getOrgCityNameOptions(userInfo);
List StuDutyoptions = (List)request.getAttribute("StuDutyoptions");
List studdept=CEditConst.getStuDeptNameOptions(userInfo);

List xynameoptions=CEditConst.getAcademyNameOptions(userInfo,"");

List nianjioptions=CEditConst.getGradeNameOptions(userInfo);
String uniontype=ParamUtils.getParameter(request, "_uniontype_", "");
String    UnionId=ParamUtils.getParameter(request, "_UnionId_", "-1");
String deptid=ParamUtils.getParameter(request, "_deptid_", "-1");
String shuchu="学生会部门成员";
System.out.println(deptid);
if(deptid.equals("-1")){
	shuchu="学生会主席团成员";
}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
					<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
		
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
				<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
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
    			
    			$("#UnionorDept").change(function(){
    				var id=$(this).val();
    				//alert($(this).val())
    				 $.ajax({
    						url:"zhanghaochaxun.jsp?cmd=chaxun&Id="+id,
    						type: "post",
    						dataType:"json",
    						async:false,
    						success:function(data){
    						
    							if(data.msg=="error"){
    								alert("错误");
    								
    								return;
    							}
    							if(data.msg=="ok"){
    						$("#SNo").val(data.name)
    								$("#SNo").val(data.name)     
    							$("#ChargeDept").val(data.deptid)
    								$("#Campus").val(data.opid)
    									$("#Phone").val(data.phone)
    										$("#Remark").val(data.email)
    										$("#SchoolYear").val(data.nianji)
    									
    							}
    							if(data.msg=="no"){
    								alert("222222222222222")
    							} 
    							
    						},
    						error: function (error) {
    				            alert("信息出错！");
    				        }
    						
    					});
    			})	
			}
			function tianjia(){
				openWindow("BaseUserCodeAction2.jsp?values="+$('#UnionorDept').val()+"&_DeptId_="+$('#ChargeDept').val(),"713,430")	
			}
		
		    function setRole(name,id,sno){
	        	 // var id1=$('#UnionorDept').val()+""+id;
	        	  $('#UnionorDept').val(id);
	      
	        	  $('#xingming').val(name);
	        	  $('#SNo').val(sno);
	          }
		    
		</script>
	</head>
	<body onload="init();">
<%-- 		<jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001"><%=shuchu %></div>
				
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StudentUnionMemberAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%if(v.getId()==-1||(user.getDeptId()+"").equals(v.getUnionorDept())){ %>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden" name="Deptid" value="<%=deptid%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
<input  type="hidden" id="UnionorDept" name="UnionorDept" value="<%=v.getUnionorDept()%>">
																	
													  				<tr>
                    												<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%
														    			if(userInfo.hasFunPower(Power.UserAdminPower)){
														    			%>
<%=HtmlTool.renderSelect(xynameoptions, user.getDeptId()+"", "ChargeDept", "",true)%>
				    			<%} %>
														    		<% if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHGZ)){
														    			%>
<%=HtmlTool.renderSelect(xynameoptions, v.getDeptid()+"", "ChargeDept", "")%>
<%} %>

                    													</td>
                    													<td align="right" class="form_label">校区</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(OrgNameoptions, v.getCampus(), "Campus", "")%>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">年级</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    														<%=HtmlTool.renderSelect(nianjioptions, v.getSchoolYear(), "SchoolYear", "")%>
                    													</td>
                    													<td align="right" class="form_label">职位</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
<%=HtmlTool.renderSelect(StuDutyoptions, v.getDuty(), "Duty", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    												<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input  name="xingming" id="xingming" size="0" value="" readonly="readonly">
                    														<a href="javascript:tianjia();">添加</a>	
                    														
                    													</td>
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SNo" id="SNo" size="0" value="<%=v.getSNo()%>">
                    													</td>
                    													
													  				</tr>
                    											
													  				
                    												<tr style="display: none;">
                    												
                    													
                    											
                    												
                    														<td align="right" class="form_label">校级院级学生会id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Unionid" id="Unionid" value="<%=UnionId%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="Phone" id="Phone" size="45" maxsize="45" value="<%=v.getPhone()%>">
                    													</td>
													  				</tr>
                    												
                    												<tr>
                    													<td align="right" class="form_label">邮箱</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<textarea cols="100" rows="2" id="Remark" name="Remark"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    												
                    											</table>
			</form>
		</div>
	</body>
</html>
