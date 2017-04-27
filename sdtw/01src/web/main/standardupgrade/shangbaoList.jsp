<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.studentUnion.StudentUnionUtil"%>
<%@page import="java.math.BigDecimal"%>
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
	StandardupGradeUtil util = new StandardupGradeUtil();
	//aid学院id sid团委通知id
	int aid = ParamUtils.getIntParameter(request,"aid",-1);
	int sid = ParamUtils.getIntParameter(request,"sid",-1);
	Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
	StudentUnionUtil stuutil = new StudentUnionUtil();
	List cdt = new ArrayList();
	cdt.add("academy="+aid);
	Map ClassesNameMap = stuutil.getClassesNameMap(cdt);
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
		<title> <%=request.getAttribute("describe")%> </title>
		<script>
		function addItem(id){
			parent.showDialog('<%=HeadConst.apache_url%>/main/standardupgrade/addFile.jsp?aid=<%=userInfo.getUserCode().getDeptId()%>&sid=<%=sid%>&id='+id,400,350,"添加"
					,{"确定":function(){
						parent.addFile();
					}});
		}
		function delFile(id) {
			if (confirm("确实要删除这些记录吗?")) {
				$.ajax({
					type : "post",
					///sdfz/01src/web
					url : "<%=HeadConst.apache_url%>/main/standardupgrade/StandardupGrade_FileAction.jsp?cmd=delFile&Id="+id,
					dataType : "json",
					cache : false,
					success : function(data) {
						if (data.msg=="ok") {
							window.location.reload();
						}
					},
					error : function() {
						// view("异常！"); 
						alert("异常！");
					}
				});
			 }
		}
		function summitItem(flag){
			var aid = <%=aid%>;
			var sid = <%=sid%>;
			var str = "";
			if (flag==0) {
				str = "提交"
			}
			if (flag==1) {
				str = "审核"
			}
			if (confirm("确实要"+str+"这些记录吗?")) {
				$.ajax({
					type : "post",
					///sdfz/01src/web
					url : "<%=HeadConst.apache_url%>/main/standardupgrade/StandardupGrade_FileAction.jsp?cmd=submitFile&aid="+aid+"&sid="+sid+"&ChackFlag="+flag,
					dataType : "json",
					cache : false,
					success : function(data) {
						if (data.msg=="ok") {
							alert("操作成功！");
							window.location.reload();
						}
						if (data.msg=="no") {
							alert("请勿重复审核！");
							return;
						}
					},
					error : function() {
						// view("异常！"); 
						alert("异常！");
					}
				});
			 }
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
													          <div class="browsetitle001"><%=AcademyNameMap.get(aid+"") %>课题资料上报情况</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell((String)AcademyNameMap.get(aid+""))%></div>
												          </div> 
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <%-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li> --%>
														            <%
														            if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)) {%>
															            <li><a href="AcademyList.jsp?aid=<%=aid %>&sid=<%=sid %>" >返回</a></li>
															            <li><a href="javascript:summitItem(1);">审核</a></li> 
														            <%}
														            if(userInfo.hasFunPower(Power.UserAdminPower)) {%>
														            	<li><a href="StandardupGradeAction.jsp?cmd=list&page=<%=currpage%>&sid=<%=sid %>" >返回</a></li>
															            <li><a href="javascript:summitItem(0);">提交</a></li> 
															            <li><a href="javascript:addItem();">添加</a></li> 
														            <%}
														            %>
													            </ul>
												              </div>
												           </div>
											            </div>	                                   
											    </td>
                               			 </tr>    										
                               			</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td>
                               <div class="browsetable2">
											<input type="hidden" name="cmd" value="list">
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
														
														<div id="list" class="browsetable">
														<table cellspacing="1" cellpadding="2" border="0"
															width="100%" align="center">
															<tbody>
																<tr>
																	<td  nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">团支部名称</div>
																	</td>
																	<td  nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">团支部人数</div>
																	</td>
																	<td  nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">申报等级</div>
																	</td>
																		<td  nowrap="" bgcolor="#3992d0" style="width: 8%">
																	<div class="browsetable004">操作</div>
																	</td>
																	<td  nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">占比 </div>
																	</td>
																</tr>
																<%
																Map ApplyLevelTypeMap = CEditConst.getApplyLevelTypeMap(userInfo);
																Map<String,Object> map = new HashMap<String,Object>();
																map = util.getShangbaoListMap(aid,sid,userInfo);
																if (map.size()>0) {
																for (int i=0;i<4;i++) {
																if (map.get(""+i)!=null) {
																	List<StandardupGrade_File> list0 = new ArrayList<StandardupGrade_File> ();
																	list0 = (List)map.get(""+i);
																	System.out.println(list0.size());
																	if (list0.size()>0) {
																		int nums = 0;
																		int level_nums=0;
																		String d = "odd";
																		for (int j=0;j<list0.size();j++) {
																			StandardupGrade_File v = new StandardupGrade_File();
																			v = list0.get(j);
																			nums+=v.getZBNums();
																			level_nums+=j;
																		}
																		for (int j=0;j<list0.size();j++) {
																			StandardupGrade_File v = new StandardupGrade_File();
																			v = list0.get(j);
																			if (i%2==0) {
																				d = "even";
																			}else{
																				d = "odd";
																			}
																			%>
																			<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"class="data_bgcolor_<%=d %>" style="cursor: pointer;">
																	<td  nowrap=""  align="center">
																		<div class="browsetable005"><%=ClassesNameMap.get(v.getZBName()) %></div>
																	</td>
																	<td  nowrap=""  align="center">
																	<div class="browsetable005"><%=v.getZBNums() %></div>
																	</td>
																	<td  nowrap=""  align="center">
																	<div class="browsetable005"><%=ApplyLevelTypeMap.get(v.getApplyLevelType()) %></div>
																	</td>
																	<%
																	if("".equals(v.getChackFlag())) {
																	%>
																	<td  nowrap=""  align="center">
																	<div class="browsetable005">
																	<a href="javascript:addItem(<%=v.getId()%>);">编辑</a>&nbsp;&nbsp;<a href="javascript:delFile(<%=v.getId()%>);">删除</a>
																	</div>
																	</td>
																	<%} else {
																		String flag = "";
																		if("0".equals(v.getChackFlag())) {
																			flag = "已提交";
																		}
																		if ("1".equals(v.getChackFlag())) {
																			flag = "审核通过";
																		}
																	%>
																		<td><%=flag %></td>
																	<%} 
																	%>
																	<%
																	if (j==0) {
																	%>
																	<td  rowspan="<%=j==0?list0.size():1 %>" >
																	<%-- <div class="browsetable005">
																	<%
																	//人数比例
																	double per = (nums*1.0/(Integer)map.get("nums")*100);
																	BigDecimal   b   =   new   BigDecimal(per);  
																	double   percent   =   b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
																	%>
																	<%=percent %>%</div>  --%>
																	<div class="browsetable005">
																	<%
																	//人数比例
																	int levelnum = ((List)map.get(v.getApplyLevelType())).size();
																	int levelnums = (Integer)map.get("levels");
																	double per = (levelnum*1.0/levelnums*100);
																	BigDecimal   b   =   new   BigDecimal(per);  
																	double   percent   =   b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
																	%>
																	<%=percent %>%  </div> 
																	</td>
																	<%} %>
																</tr>
																			<%
																		}
																	}
																}
																}
																} else {
																	%>
																	<tr>
																	<td bgcolor="#ffffff" colspan="5" align="center">没有上传</td>
																	</tr>
																<%}
																map.clear();
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
