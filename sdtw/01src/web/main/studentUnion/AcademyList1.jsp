<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.StudentClass.StudentClassDutyUtil"%>
<%@page import="com.xietong.software.sdtw.club.CurrentSemester"%>
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
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	if (userInfo.hasFunPower(Power.UserAdminPower)) {
		String nowschoolyear = CurrentSemester.getSchoolYear(new Date());
		out.println("<script>window.location='StudentDutyList.jsp?_academy_="+userInfo.getDeptId()+"&_schoolyear_="+nowschoolyear+"&page=1';</script>");
		return;
	}
	
	StudentClassDutyUtil util = new StudentClassDutyUtil();
	int sid = ParamUtils.getIntParameter(request,"sid",-1);
	int aid = ParamUtils.getIntParameter(request,"aid",-1);
	String subjectcode=ParamUtils.getParameter(request, "subjectcode", "1");
	List cdt = new ArrayList();
	cdt.add("flag=1");
	List AcademyNameOptions = COptionConst.getAcademyNameOptions(userInfo,"-1",cdt);
	
//	Map<String,Object> map = new HashMap<String,Object>();
	//map = util.getShangbaoListAcaMap(sid);
%>
	<head>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
			<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
		<title> <%=request.getAttribute("describe")%> </title>
		<script>
		$(function(){
			$("#aid").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
		})
			function inList(aid,sid){
				location = "StudentDutyList.jsp?_academy_="+sid;
			}
			
		</script>
	</head>
	<body>
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
													          <div class="browsetitle001">班级工作</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell("班级工作")%></div>
												          </div> 
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <%-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li> --%>
														            
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr>    										</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  								
									</form>
									<tr>
    									<td valign="top">
      										<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
        										<tr>
          											<td>
														<div id="list" class="browsetable">
														</div>
														
														<div id="list" class="browsetable">
														<table cellspacing="1" cellpadding="2" border="0"
															width="100%" align="center">
															<tbody>
																<tr>
																<td onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">序号</div>
																	</td>
																	<td onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">学院</div>
																	</td>
																	<td onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">班级列表</div>
																	</td>
																</tr>
																<%
																int tiaoshu=0;
																List list = new ArrayList();
																list = util.getAcademyList(aid);
																if(list.size()>0){
																	String d = "odd";
																	for (int i=0;i<list.size();i++) {
																		if (i%2==0) {
																			d = "even";
																		}else{
																			d = "odd";
																		}
																		Academy v = new Academy();
																		v = (Academy)list.get(i);
																		%>
																
																<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"class="data_bgcolor_<%=d %>" style="cursor: pointer;" onclick="inList(<%=subjectcode%>,<%=v.getId()%>)">
																	<td class="browsetable005" align="center"><%=i+1 %></td>
																	<td class="browsetable005" align="center"><%=v.getAcademyName() %></td>
																	<td class="browsetable005" align="center" style="co">点击查看 </td>
																</tr>
																	<%}
																%>
																<%}
																
																%>
															</tbody>
														</table>
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
