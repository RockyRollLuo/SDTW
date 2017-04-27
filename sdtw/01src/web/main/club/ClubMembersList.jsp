<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<%@page import="javax.swing.text.html.HTMLDocument.HTMLReader"%>
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
	List AuditOptions = CEditConst.getAuditOptions(userInfo,"-1");
	String MemberClubname = ParamUtils.getParameter(request,"MemberClubname","");
	String _MemberClubname_ = ParamUtils.getParameter(request,"_MemberClubname_","");
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<title> <%=request.getAttribute("describe")%> </title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
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
			//flag  0本科生  1研究生
			function addNewWinOp(flag)
			{
				var url = "";
				var title = "";
				if (flag=="0") {
					title = "本科生";
					url = "<%=HeadConst.apache_url%>/main/club/ClubMemberBk.jsp?Identity=0";
				}
				if (flag=="1") {
					title = "研究生";
					url = "<%=HeadConst.apache_url%>/main/club/ClubMemberYjs.jsp?Identity=1";
				}
			   /*  if (!url_para)
			        url_para = "";
			    location = className + "Action.jsp?flag="+flag+"&cmd=" + cmd + ((url_para.length == 0) ? "" : "&" + url_para); */
		    	parent.showDialog (url,1200,590,title
		                ,{ '确定': function(){
		                      parent.submitthis();
		                }
		      });
			}
		</script>
	</head>
	<body onload="init();">
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
												            <div class="browsetitleleft">
													          <div class="browsetitle001">
													          <%
																String describe = ParamUtils.getAttribute(request,"describe","");
																%>
																<%=describe %>
													          </div>
													          <div class="browsetitle002"><%=XtUtil.getSpell(describe)%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
													           <%
													           if(userInfo.hasFunPower(Power.STUSER)){
													           %>
														            <!-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li> -->
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <%
														            String flag = ParamUtils.getParameter(request,"_flag_","");
														            if("cy".equals(flag)) {
														            %>
														            <li><a href="javascript:addNewWinOp(1);">研究生增加</a></li>
														            <li><a href="javascript:addNewWinOp(0);">本科生增加</a></li>
														            <%} %>
														            <!-- <li><a href="javascript:document.query.submit();">查询</a></li> -->
														           <%} %>
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr>    										</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
    								<input type="hidden" id="MemberClubname" name="MemberClubname" value="<%=MemberClubname%>"/>
    								<input type="hidden" id="_MemberClubname_" name="_MemberClubname_" value="<%=_MemberClubname_%>"/>
    								<input type="hidden" id="_flag_" name="_flag_" value="<%=ParamUtils.getParameter(request,"_flag_","")%>"/>
  									<tr>
    									<td>
                               <div class="browsetable2">
											<%-- <input type="hidden" name="cmd" value="list">
											<%=Tool.join("\n", forms)%> --%>
											<%
											String flag = ParamUtils.getParameter(request,"_flag_","");
											if("check".equals(flag)){%>
												<table>
												<tr>
												<td>审核状态</td>
												<td><%=HtmlTool.renderSelect(AuditOptions,ParamUtils.getParameter(request,"_CheckFlag_","-1"),"_CheckFlag_","0") %></td>
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
