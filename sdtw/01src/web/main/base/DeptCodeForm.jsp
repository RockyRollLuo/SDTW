<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<%@ page language="java" %>
<%--部门--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.util.*"%>
<%-- <%@ include file="../js/jsheader.jsp"%> --%>
<%
	Log log = LogFactory.getLog(BaseDeptCode.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	BaseDeptCode v = (BaseDeptCode)request.getAttribute("fromBean");
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
	List OrgNameoptions = (List)request.getAttribute("OrgNameoptions");
	List DeptNameoptions = (List)request.getAttribute("DeptNameoptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=HeadConst.apache_url%>/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/js/common.js"></script>
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
			function checkform(){
			   var orgid = document.postForm.OrgId.value;
			   if(orgid=="-1"){
			   	   alert("请选择所属单位！");
			   	   document.postForm.OrgId.focus();
			   	   return;
			   }
			   var name = document.postForm.Name.value;
               var   arg   = /[a-zA-Z0-9]$/; 
			   if(name==""){
			   	   alert("请输入部门名称！");
			   	   document.postForm.Name.focus();
			   	   return;
			   }else{
			    if(name.indexOf(" ") >= ""){
					 alert("您的输入不能存有空格！");
					 document.postForm.Name.focus();
					 return;
			   	 }
			   }
			   var code = document.postForm.Code.value;
			   if(code==""){
			   	   alert("请输入部门编号！");
			   	   document.postForm.Code.focus();
			   	   return;
			   }else{
			    if(code.indexOf(" ") >= ""){
					 alert("您的输入不能存有空格！");
					 document.postForm.Code.focus();
					 return;
			   	 }
			   }
			   document.postForm.submit();
			   return true;
			}
			function choice(name){
		        openWindow("<%=HeadConst.root_url_path%>/common/ChoiceAction.jsp?type=1&id=" + document.postForm.OrgId.value + "&cmd=OrgDeptUser&checked_ids=" + document.postForm.Leaders.value, "600,500");
			}
			//定义当前处理人
			function getDialogReturn(rtn){
			    var getChecked = function(items, id, name) {
			        var ids = [];
			        var names = [];
			        var j = 0;
			        for (var i in items) {
			            if (items[i].checked == "1") {
			                ids[j] = items[i][id];
			                names[j] = items[i][name];
			                j ++;
			            }
			        }
			        return {"ids": ids, "names": names};
			    };
			    if (rtn.name == "OrgDeptUser") {
			        var checkedDic = getChecked(rtn.items, 'id', 'cnname');
			        document.postForm.Leaders.value = checkedDic.ids.join(",");
			        document.getElementById("LeaderNames").value = checkedDic.names.join(",");
			        return;
			    }
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="../jqueryui.jsp" flush="true"/> --%>
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
                									<td width="70"><b  class="bt">部门信息</b></td>
                									<td>&nbsp;</td>
													<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
                									<td width="55" class="bt"><a href="javascript:checkform()">保存</a></td>
													<%
														BaseDeptCode dc=new BaseDeptCode();
												        List cdt1 = new ArrayList();
												        cdt1.add("Pid in (" +  v.getId() + ")");
												        List cdt = new ArrayList();
												        if(dc.query(cdt1).size()>0){
														}else{%>
														<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr3.png"></div></td>
														<td width="55" class="bt"><a href="javascript:deleteThis('<%=request.getAttribute("classname")%>','<%=v.getId()%>','');">删除</a>
													<%}
													 %>
													 </td>
                									<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr4.png"></div></td>
                									<td width="55" class="bt"><a href="DeptCodeAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>">返回</a></td>
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
																<input type="hidden" name="cmd" value="<%=cmd%>">
																<input type="hidden" name="page" value="<%=currpage%>">
																<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      												<tr>
                        												<td height="2"></td>
                      												</tr>
                    											</table>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#D2D2D2">
																		<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">单位</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=HtmlTool.renderSelect(OrgNameoptions, "" + v.getOrgId(), "OrgId", "-1")%><font color=red>*</font>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">上级部门</td>
														    			<td bgcolor="#FFFFFF" align="left">
																			<%=HtmlTool.renderSelect(DeptNameoptions, "" + v.getPid(), "Pid", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">部门名称</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Name" size="30" value="<%=v.getName()%>"><font color=red>*</font>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td bgcolor="#FFFFFF" align="right">部门编码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Code" size="30" maxsize="50" value="<%=v.getCode()%>"><font color=red>*</font>
                    													</td>
													  				</tr>
                    												<tr style="display:none;">
                    													<td bgcolor="#FFFFFF" align="right">部门领导</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input type="hidden" name="Leaders" value="<%=v.getLeaders()%>">
																			<textarea id="LeaderNames" cols="30" rows="1" readonly><%=Tool.join(",", CEditConst.getUserCnNameLabels(request, v.getLeaders()))%></textarea>
																			<img src="<%=HeadConst.apache_url%>/main/images/004.gif" onclick="javascript:choice('Leaders')">
                    													</td>
													  				</tr>
                    												<tr style="display:none;">
                    													<td bgcolor="#FFFFFF" align="right">部门类型</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Style" size="1" maxsize="1" value="<%=v.getStyle()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">排序</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Orderby" value="<%=v.getOrderby()%>">
                    													</td>
													  				</tr>
													  				<tr>
                    													<td bgcolor="#FFFFFF" align="right">邮政编码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="PostCode" size="20" maxsize="50" value="<%=v.getPostCode()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">上级主管部门</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="ReptDept" size="30" maxsize="50" value="<%=v.getReptDept()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">部门电话</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Tel" size="30" maxsize="50" value="<%=v.getTel()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">传真号码</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Fax" size="30" maxsize="50" value="<%=v.getFax()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">部门邮箱</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Email" size="30" maxsize="50" value="<%=v.getEmail()%>">
                    													</td>
													  				</tr>
													  				<tr>
                    													<td bgcolor="#FFFFFF" align="right">部门地址</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Address" size="50" maxsize="80" value="<%=v.getAddress()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">备注</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<textarea name="Remark" cols="40" rows="2"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td bgcolor="#FFFFFF" align="right">是否有效</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<%=HtmlTool.renderSelect(YesNooptions, v.getEnable()+"", "Enable", "1") %>
                    													</td>
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
