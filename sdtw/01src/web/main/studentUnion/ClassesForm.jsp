<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--�꼶--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<%
	Log log = LogFactory.getLog(Classes.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Classes v = (Classes)request.getAttribute("fromBean");
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
	BaseUserCode buc= userInfo.getUserCode();
List GradeNameoptions = (List)request.getAttribute("GradeNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
List  orgnameoptions=CEditConst.getOrgNameOptions(userInfo);
List cdt = new ArrayList();
cdt.add("roles="+3);
cdt.add("deptid ="+buc.getDeptId());
List UserCnNameoptions= COptionConst.getUserCnNameOptions(userInfo,"请选择", cdt);

%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
							<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
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
				$("#banzhang").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				$("#tuanzhishu").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				$("#banwei1").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				$("#banwei2").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				$("#banwei3").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				$("#banwei4").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				$("#banwei5").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
				$("#banwei6").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
			}
		</script>
	</head>
	<body onload="init();">
		
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">班委添加表</div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClassesAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
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
                    												<td align="right" class="form_label">班级名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Name" id="Name" size="50" maxsize="50" value="<%=v.getName()%>">
                    													</td>
                    												<%if(v.getId()==-1){ %>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, "" + buc.getDeptId(), "Academy", "-1",true)%>
<%}else{ %>
<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, "" + v.getAcademy(), "Academy", "-1",true)%>
<%} %>
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">年级</td>
														    			<td  colspan="3" align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(GradeNameoptions, "" + v.getGid(), "Gid", "-1")%>
                    													</td>
                    												
													  				</tr>
													  		<%
													  		
													  	    List banzhang=new ArrayList();
													        List   tuanzhishu=new ArrayList();
													         List  banwei=new ArrayList();
													        List cdt1= new ArrayList();
													        List list1= new ArrayList();
													        StudentClassDuty scd= new  StudentClassDuty();
													        cdt1.add("classname="+v.getId());
													      String banzhangid="-1";
													      String tuanzhishuid="-1";
													        list1=scd.query(cdt1);
													        if(list1.size()>0){
													     	   for(int  i=0;i<list1.size();i++){
													     		   scd=(StudentClassDuty)list1.get(i);
													     		   if(scd.getDuty().equals("班长")){
													     			   banzhang.add(scd.getSno());
													     		   }
													     		   if(scd.getDuty().equals("团支书")){
													     			   tuanzhishu.add(scd.getSno());
													     		   }
													     		   if(scd.getDuty().equals("班委")){
													     			   banwei.add(scd.getSno());
													     		   }
													     	   }
													        }
													  		if(banzhang.size()>0){
													  			 banzhangid=(String)banzhang.get(0);
													  		}
													  		if(tuanzhishu.size()>0){
													  			tuanzhishuid=(String)tuanzhishu.get(0);
													  		}
													  		
													  		
													  		%>		
                    											
													  				
                    												<tr>
                    													<td align="right" class="form_label">班长</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" +  banzhangid, "banzhang", "-1")%>
                    													</td>
                    												<td align="right" class="form_label">团支书</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" + tuanzhishuid, "tuanzhishu", "-1")%>
                    													</td>
													  				</tr>
													  				
                    												<tr>
                    										<input type="hidden" name="OpName"/>		
                    													
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他班委</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" + v.getGid(), "banwei1", "-1")%>
                    													</td>
                    												<td align="right" class="form_label">其他班委</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" + v.getGid(), "banwei2", "-1")%>
                    													</td>
													  				</tr>
													  				
													  						<tr>
                    													<td align="right" class="form_label">其他班委</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" + v.getGid(), "banwei3", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">其他班委</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" + v.getGid(), "banwei4", "-1")%>
                    													</td>
													  				</tr>
													  								<tr>
                    													<td align="right" class="form_label">其他班委</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" + v.getGid(), "banwei5", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">其他班委</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserCnNameoptions, "" + v.getGid(), "banwei6", "-1")%>
                    													</td>
													  				</tr>
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">��ע</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Beizhu" id="Beizhu" cols="40" rows="2"><%=v.getBeizhu()%></textarea>
                    													</td>
													  				</tr>
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">�Ƿ����</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "-1")%>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
