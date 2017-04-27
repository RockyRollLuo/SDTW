<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
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

	YouthhonourUtil yhUtil=new YouthhonourUtil();
	//YouthhonourOptions
	List YouthhonourOptions=yhUtil.getYouthhonourOptions();
	//AcademyNameOptions
// 	List AcademyNameoptions =CEditConst.getAcademyNameOptions(userInfo,"");
	List cdt=new ArrayList();
	cdt.add(" flag=1 OR flag=2 ");
	List AcademyNameoptions =COptionConst.getAcademyNameOptions(userInfo,"",cdt);
	
	//type,noticeid
	int type=ParamUtils.getIntParameter(request, "type", -1);
	int noticeid=ParamUtils.getIntParameter(request, "noticeid", -1);
	
	//youthhonour_notice
	Youthhonour_notice yhNotice=new Youthhonour_notice();
	yhNotice=yhNotice.getById(noticeid);	
	
	//academyid(DeptId)
	int academyid=0;
	if(userInfo.hasFunPower(Power.UserAdminPower)) academyid=userInfo.getDeptId();
	
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
			
			
			//审核
			function modifyList(checkflag,url_para)
			{
			    var chks = document.getElementsByName("chk1");
			    if (!url_para) url_para = "";//不理解
			    page=1;//不理解
			    var chkeds = new Array();
			    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			        }
			    }
			    if (chkeds.length > 0) {
			        if (confirm("确实要通过这些项目的审核吗?")) {
			          location ="YouthHonourAction.jsp?cmd=checkpass&checkflag="+checkflag+"&noticeid=<%=noticeid%>&idlist="+chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
			
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
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
													          <div class="browsetitle001">五四评比表彰申请表</div>
													          <div class="browsetitle002"><%=yhUtil.youthhonourName.get(type)%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
													           	<%if(yhNotice.getTwReport()==SdtwConst.TWREPORT_WGB){//未公布%>
													           		<%if(userInfo.hasFunPower(Power.UserAdminPower)&&yhUtil.getOneXyReportFlag(noticeid,academyid)==SdtwConst.XYREPORT_WSB){%>
														            <li><a href="javascript:modifyList(<%=SdtwConst.XYCHECK_TG%>,url_para);">通过</a></li>
														            <li><a href="javascript:modifyList(<%=SdtwConst.XYCHECK_WTG%>, url_para);">不通过</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li>
														            <%}else if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){%>
														            <li><a href="javascript:modifyList(<%=SdtwConst.TWCHECK_TG%>, url_para)">通过</a></li>
														            <li><a href="javascript:modifyList(<%=SdtwConst.TWCHECK_WTG%>, url_para)">不通过</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <%}%>
														         <%}%>
														            <li><a href="YouthhonourAllList.jsp?noticeid=<%=noticeid%>">返回</a></li>
														            <li><a href="Youthhonour-summary.jsp?noticeid=<%=noticeid%>">汇总表</a></li>
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
											<input type="hidden" name="cmd" value="list"/>
											<input type="hidden" name="noticeid" value="<%=noticeid%>"/>
											<table>
												<tr>
													<%if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){%>
													<td>学院</td>
													<td><%=HtmlTool.renderSelect(AcademyNameoptions,"", "_belongacademy_",ParamUtils.getParameter(request, "_belongacademy_",""))%></td>
													<%}%>
													<td>五四表彰内容</td>
													<td><%=HtmlTool.renderSelect(YouthhonourOptions, type+"", "type",type+"")%></td>
													
													<td>姓名/负责人/名称</td>
													<td><input name="_val1_" value="<%=ParamUtils.getParameter(request, "_val1_","")%>"/></td>
												</tr>
											</table>
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
