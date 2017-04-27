<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="java.awt.Point"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生素质拓展培养认证单--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.rzd.StudentRzdUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(StudentRzd.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	StudentRzd v = (StudentRzd)request.getAttribute("fromBean");
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
List StudentRzdTypeNameoptions = (List)request.getAttribute("StudentRzdTypeNameoptions");

//
StudentRzdUtil srUtil=new StudentRzdUtil();
Map checkMap=srUtil.getCheckMap();
Map academyNameMap=CEditConst.getAcademyNameMap(userInfo);
// Map rzdTypeMap=CEditConst.getStudentRzdTypeNameMap(userInfo);
Map rzdTypeMap=srUtil.rzdTypeMap;
Map gradeMap=CEditConst.getGradeNameMap(userInfo);
List checkOptions=srUtil.getCheckOptions();

Map genderMap=new HashMap();
genderMap.put("0","男");
genderMap.put("1","女");

String disableflag="";
if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)) disableflag="disabled";


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
			
			function formSubmit(e){
				document.postForm.Checkflag.value=e;
				document.postForm.submit();
// 				window.location.reload();
			}
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">学生素质拓展培养认证单</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("学生素质拓展培养认证单") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StudentRzdAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%if(userInfo.hasFunPower(Power.UserAdminPower)){%>
						<li><a href="javascript:void(0);" onclick="formSubmit(1)">通过</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:formSubmit(0)">不通过</a></li>
						<%}%>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>"/>
				<input type="hidden" name="page" value="<%=currpage%>"/>
				<input type="hidden" name="Id" value="<%=v.getId()%>"/>
				<input type="hidden" name="Stuid" value="<%=v.getStuid()%>"/>
				<input type="hidden" name="ActivityId" value="<%=v.getActivityId()%>"/>
				<input type="hidden" name="Modifyflag" id="Modifyflag" value="<%=v.getModifyflag()%>"/>
				
				<input type="hidden" name="Type" id="Type" value="<%=v.getType()%>"/>
				<input type="hidden" name="Deptid" id="Deptid" value="<%=v.getDeptid()%>"/>
				<input type="hidden" name="Value1" id="Value1" value="<%=v.getValue1()%>"/>
				<input type="hidden" name="Value1" id="Value1" value="<%=v.getValue1()%>"/>
				<input type="hidden" name="Value2" id="Value2" value="<%=v.getValue2()%>"/>
				<input type="hidden" name="Value3" id="Value3" value="<%=v.getValue3()%>"/>
				<input type="hidden" name="Value4" id="Value4" value="<%=v.getValue4()%>"/>
				<%=Tool.join("\n", forms)%>
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<%if(userInfo.hasFunPower(Power.UserAdminPower)){%>
<tr>
     <td align="right" class="form_label">审核</td>
     <td align="left"  bgcolor="#ffffff">
     	<%=checkMap.get(v.getCheckflag())%>
     	<input type="hidden" name="Checkflag" value="<%=v.getCheckflag()%>"/>
<%--           <%=HtmlTool.renderSelect(checkOptions,""+v.getCheckflag(), "Checkflag", "")%> --%>
     </td>
</tr>
<tr>
     <td align="right" class="form_label">审核原因</td>
     <td align="left"  bgcolor="#ffffff">
     <textarea name="Checkreason" id="Checkreason" cols="60" rows="2"><%=v.getCheckreason()%></textarea>
     </td>
</tr>
<%}else{%>
<tr>
     <td align="right" class="form_label">审核</td>
     <td align="left"  bgcolor="#ffffff"><%=checkMap.get(v.getCheckflag())%></td>
</tr>
<tr>
     <td align="right" class="form_label">审核原因</td>
     <td align="left"  bgcolor="#ffffff"><%=v.getCheckreason()%></td>
</tr>
<%}%>
<tr>
     <td align="right" class="form_label">学生基本信息：</td>
     <td align="left"  bgcolor="#ffffff">
     <%
     	BaseUserCode buc=new BaseUserCode();
     	buc=buc.getById(v.getStuid());
     %>
     	姓名：<%=buc.getCnName()%>  学号：<%=buc.getName()%>   性别：<%=genderMap.get(""+buc.getGender())%>  年级：<%=gradeMap.get(buc.getGrade())%>
     </td>
</tr>
<tr>
     <td align="right" class="form_label">学院</td>
     <td align="left"  bgcolor="#ffffff"><%=academyNameMap.get(v.getDeptid())%></td>
</tr>
<tr>
     <td align="right" class="form_label">类别</td>
     <td align="left"  bgcolor="#ffffff"><%=rzdTypeMap.get(v.getType())%></td>
</tr>
<tr>
     <td align="right" class="form_label">组织/活动名称</td>
     <td align="left"  bgcolor="#ffffff"><%=v.getValue1()%></td>
</tr>
<tr>
     <td align="right" class="form_label">主办/主管/接收单位</td>
     <td align="left"  bgcolor="#ffffff"><%=v.getValue2()%></td>
</tr>
<tr>
     <td align="right" class="form_label">起止时间</td>
     <td align="left"  bgcolor="#ffffff"><%=v.getValue3()%></td>
</tr>
<tr>
     <td align="right" class="form_label">成果/经历</td>
     <td align="left"  bgcolor="#ffffff"><%=v.getValue4()%></td>
</tr>
</table>
			</form>
		</div>
	</body>
</html>
