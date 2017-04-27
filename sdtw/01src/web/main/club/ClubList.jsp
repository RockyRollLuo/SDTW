<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%!
	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);
%>
<%
	log.debug("List");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "list");
	StringBuffer str = new StringBuffer();
	List rows = (List)request.getAttribute("List");
	if (rows == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	String url = Tool.join("&", urls);
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	if (pagecontrol == null) {
    		pagecontrol = new PageControl(0, 1, 1);
	}
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	List ClubTypeNameOptions = CEditConst.getClubTypeNameOptions(userInfo,"-1");
	List OrgCityNameOptions = CEditConst.getOrgCityNameOptions(userInfo,"-1");
	List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo,"-1");
	Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
	Map OrgCityNameMap = CEditConst.getOrgCityNameMap(userInfo);
	String _flag_ = ParamUtils.getParameter(request,"_flag_","");
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
		<script>
			var curr_orderby = ["<%=HttpTool.getString(extMaps, "orderfield", "")%>", "<%=HttpTool.getString(extMaps, "ordertype", "")%>"];
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var queryfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("queryfields"))%>"];
			var queryvalues = ["<%=Tool.join("\", \"", (List)request.getAttribute("queryvalues"))%>"];
			var rows = [<%=Tool.join(", ", rows)%>];
			var hidefields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("hidefields"))%>"];
			function init() {
    				showList("<%=request.getAttribute("classname")%>", <%=pagecontrol.getCurrPage()%>, url_para);
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr> 
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
  									<tr>
    									<td height="26">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                               <tr>
                                   <td>
											            <div class="browsetitle title_css">
											            <%//if("".equals(_flag_)){ %>
												            
												          <%//} %>
												         <%
												         String describe = ParamUtils.getAttribute(request,"describe","");
												         %>
												         <div class="browsetitleleft">
													          <div class="browsetitle001"><%=describe %></div>
													          <div class="browsetitle002"><%=XtUtil.getSpell(describe)%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <!-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li> -->
														            <%-- <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li> --%>
														            <li><a href="javascript:document.query.submit();">查询</a></li>
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr>    										</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td>
                               <div class="browsetable2">
											<input type="hidden" name="cmd" value="list">
											<input type="hidden" id="_flag_" name="_flag_" value="<%=_flag_%>"/>
											<%-- <%=Tool.join("\n", forms)%> --%>
											<%
											if(!"".equals(_flag_)){
											%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
													<td>
														<div align="right">社团名称</div>
													</td>
													<td>
														<input name="_ClubName_" value="<%=ParamUtils.getParameter(request, "_ClubName_", "")%>"/>
													</td>
													<td>
														<div align="right">社团类别</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(ClubTypeNameOptions, ParamUtils.getParameter(request,"_ClubType_",""), "_ClubType_", "")%>
													</td>
													<td>
														<div align="right">所在校区</div>
													</td>
													<td>
													<%
													if(userInfo.hasFunPower(Power.UserAdminPower)){%>
													<%=OrgCityNameMap.get(userInfo.getOrgId()+"") %>
													<%}else{%>
<%=HtmlTool.renderSelect(OrgCityNameOptions, ParamUtils.getParameter(request,"_City_",""), "_City_", "")%>
													<%} %>
													</td>
													<%-- <td>
														<div align="right">负责人姓名</div>
													</td>
													<td>
													<input name="_Chairman_" value="<%=ParamUtils.getParameter(request, "_Chairman_", "")%>"/>
													</td> --%>
													<td>
														<div align="right">指导单位</div>
													</td>
													<td>
													<%
													if(userInfo.hasFunPower(Power.UserAdminPower)){%>
													<%=AcademyNameMap.get(userInfo.getDeptId()+"") %>
													<%}else{%>
<%=HtmlTool.renderSelect(AcademyNameOptions, ParamUtils.getParameter(request,"_Academy_",""), "_Academy_", "")%>
													<%}
													%>
													</td>
													<td colspan="2">&nbsp;</td>
												</tr>
											</table>
											<%} %>
                               </div>
										</td>
									</tr>
									</form>
									<tr>
    									<td valign="top">
      										<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
        										<tr>
          											<td>
														<div id="list" class="browsetable">
														</div>
														<%=(("listall".equals(cmd)))? "": pagecontrol.getControl_win8((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
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