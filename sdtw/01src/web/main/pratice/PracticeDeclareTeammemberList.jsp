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
	int ReportId = ParamUtils.getIntParameter(request,"_ReportId_",-1);//结题id
	//int type = ParamUtils.getIntParameter(request,"_Type_",-1);//类别6集体5个人    对应honor表
	PracticeReport report = new PracticeReport();
	if (ReportId!=-1&& report.getById(ReportId)!=null) {
		report = report.getById(ReportId);
	}
	int declareId = report.getDeclareId();//结题书（Practice表）id
	Practice p = new Practice();
	if (declareId!=-1&&p.getById(declareId)!=null) {
		p = p.getById(declareId);
	}
	
%>
	<head>
		
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/campus/js/campushonor.js"></script>
		
		<link type="text/css" href="../../main/js/jquery-ui-1.10.2/themes/bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />

		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		 <script src="../../main/js/index.js" type="text/javascript"></script>
		
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
			//ActivityId  Practice表id
			function getOptions(HonorType,ActivityId,ReportId){
		    	var msg = new Array();
					$.ajax({
	                    type: "get",
	                    async:false,
	                    url: "PracticeDeclareTeammemberAction.jsp",
	                    data: {cmd:'HonorOptions',HonorType:HonorType,ActivityId:ActivityId,ReportId:ReportId},
	                    dataType: "json",
	                    cache: false,
	                    success: function(data){
	                            msg= data;
	                             },
	                             error : function() { 
	                                         // view("异常！");
	                                         alert( "异常！"); 
								}
	                });
				return msg;
			}
			
			function AuditHonor (className, url_para, page,ReportId) {
			    var val = new Array();
			    var ids = new Array();
			    var objs=document.getElementsByTagName( "select") 
			    for(var i=0;i <objs.length;i++) 
			    { 
				    if(objs[i].value!=""){
				    val.push(objs[i].value);
				    ids.push(objs[i].id);
				    }
			    }
			    
			   if (val.length > 0) {
			        if (confirm("确实要提交这些记录吗?")) {
			            var url = className + "Action.jsp?cmd=audithonor&val=" + val.join(',') +"&ids="+ids.join(',')+"&ReportId="+ReportId;
			        	$.ajax({
		                    type: "post",
		                    async:false,
		                    url: url,
		                    dataType: "json",
		                    cache: false,
		                    success: function(data){
		                              if (data.msg=='no') {
		                            	  alert("请按照说明分配奖项");
		                            	  return;
		                              } 
		                              if (data.msg=="ok") {
		                            	  alert("分配奖项成功");
		                            	  return;
		                              }
		                             },
		                             error : function() { 
		                                         // view("异常！");
		                                         alert( "异常！"); 
									}
		                });
			            
			        }
			    } else {
			        alert("未选择记录！");
			    } 
		}
			
			function CheckHonor (className, url_para, page,flag) {
				var chks = document.getElementsByName("chk1");
			    if (!url_para)
			        url_para = "";
			    var chkeds = new Array();
			    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
			        if (chks[i].checked == true) {
			            chkeds.push(chks[i].value);
			        }
			    }
			    if (chkeds.length > 0) {
			        if (confirm("确实要审核这些记录吗?")) {
			            location = className + "Action.jsp?cmd=checklistreport&Remark="+flag+"&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			    } else {
			        alert("未选择记录！");
			    }
			}
			function CheckHonorJt (className, url_para, page,TeamId,flag) {
				
			        if (confirm("确实要审核这些记录吗?")) {
			        	//alert(className)
			            location = className + "Action.jsp?cmd=checklistTeamreport&Remark="+flag+"&idlist=" + TeamId + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			}
			
			//Id 团队id
			function AuditHonorJt(className, url_para, page,Id,DeclareId) {
				var url="PracticeDeclareTeamEnter.jsp?Id="+Id+"&DeclareId="+DeclareId;
				parent.showDialog (url,400,267,'设置集体荣誉'
                        ,{ '确定': function(){
                              parent.check();
                        }
              });


			}
			function showList1(className, currpage, url_para, aHasCheckbox, cmd, haveSelect,curId,showEdit) {
				var options = new Array();
				options = getOptions(5,<%=report.getDeclareId()%>,<%=ReportId%>);
			    var getRow = function (str, field) {
			        if (str == "" || str == "null") {
			            str = "&nbsp;";
			        }
			        var desc = ["string", "", "0", "text", ""];
			        if (field != undefined) {
			            desc = dic[field];
			        }
			        var dalign = desc[0] || "control";
			        return "<td  align='" + data_align[dalign] + "' class=\"browsetable005\">" + str + "</td>\n";
			    };
			    var getRow1 = function (str, field) {
			        if (str == "" || str == "null") {
			            str = "&nbsp;";
			        }
			        var desc = ["string", "", "0", "text", ""];
			        if (field != undefined) {
			            desc = dic[field];
			        }
			        var dalign = desc[0] || "control";
			        return "<td align='" + data_align[dalign] + "' class=\"browsetable005\">" + str + "</td>\n";
			    };
			    var hasCheckbox = (aHasCheckbox == undefined) ? true: aHasCheckbox;
			    var showfields = new Array();
			    var showhidefields = new Array();
			    var keyindex = getFieldIndex(keyfield);
			    // var str = showQuery(className, currpage, url_para);
			    var str = "";
			    if (typeof(curId) == "undefined") {var curId = "";}
			    if (typeof(isSelect) == "undefined") var isSelect=0;
			    
			    var titlecolor = (isSelect == "1") ? "data_bgcolor_odd" : "title_bgcolor";
			    str = str + "<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\">\n";
			    
			    if (hasCheckbox) {
			        str = str + "<td bgcolor=\"#3992d0\"><div class=\"browsetable004\"><input type=\"checkbox\" onclick=\"selectAll(this);\" onchange=\"selectAll(this);\"></div></td>\n";
			    }
			    /*
				 * if(showEdit == "1"){ str = str + "<td bgcolor=\"#3992d0\" nowrap><div
				 * class=\"browsetable004\">编辑</div></td>\n"; }
				 */
			    for (var i = 0; i < fields.length; i ++) {
			        var title = dic[fields[i]][1];
			        title = title.replace(/\(.*\)/, "");
			        if (title == "") title = "&nbsp;";
			        str = str + "<td bgcolor=\"#3992d0\" onclick=\"javascript:setOrderBy('" + fields[i] + "', '" + url_para + "')\" nowrap><div class=\"browsetable004\">" + title;
			        if (curr_orderby != undefined) {
			            if (curr_orderby[0] == fields[i]) {
			                str = str + "<img src=\"" + order_image[curr_orderby[1]] + "\">";
			            }
			        }
			        str = str + "</div></td>\n";
			        showfields[i] = getFieldIndex(fields[i]);
			    }
			    for (var i = 0; i < hidefields.length; i ++) {
			        showhidefields[i] = getFieldIndex(hidefields[i]);
			    }    
			  /*
				 * if(showEdit == "1"){ str = str + "<td bgcolor=\"#3992d0\" nowrap><div
				 * class=\"browsetable004\">编辑</div></td>\n"; }
				 */
			    str = str + "</tr>\n";
			    if (rows.length == 0) {
			        str = str + "<tr><td colspan=" + (showfields.length + 2) + " bgcolor=\"#FFFFFF\" ><div class=\"browsetable006\">没有记录！</div></td></tr>\n";
			    } 
			    else {
			        for (i = 0; i < rows.length; i ++) {
			            var color = (i % 2 != 0) ? "data_bgcolor_odd" : "data_bgcolor_even";
			            if (rows[i][keyindex] == curId){
			            	str = str + "<tr onMouseOver=\"addClass(this,'data_bgcolor_over');\"  onMouseOut=\"removeClass(this,'data_bgcolor_over');\" class='"+color+"'>\n";
			            }else{
			            	str = str + "<tr onMouseOver=\"addClass(this,'data_bgcolor_over');\"  onMouseOut=\"removeClass(this,'data_bgcolor_over');\" class='"+color+"'>\n";
			            }
			            if (hasCheckbox) {
			            	if (haveSelect == "1" ){
			            		var selectRowsIdsStr = (selectRowsIds == undefined) ? "" : selectRowsIds;
			                	if (selectRowsIdsStr.indexOf(rows[i][keyindex])>-1){
			                		str = str + "<td class=\"browsetable001\"><input type=checkbox name=chk1 checked value=" + rows[i][keyindex] + " /></td>";
			                	}else{
			                		str = str + "<td class=\"browsetable001\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
			                	}
			                }else{
			                	str = str + "<td class=\"browsetable001\"><input type=checkbox name=chk1 value=" + rows[i][keyindex] + " /></td>";
			                }
			            }
			            /*
						 * if(showEdit == "1"){ str = str + "<td class=\"xxybgx2\"  onclick=\"javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "')\">&nbsp;</td>"; }
						 */
			             var atitle = "";
			            // alert(rows[i][8])
			            for (var j = 0; j < fields.length; j ++) {
			                var k = showfields[j];
			                if(allfields[k]=="Id" ||allfields[k]=="OrderNo" ||allfields[k]=="Name" || allfields[k]=="Subject" || allfields[k] == "Email"|| allfields[k] == "Title"){
			                	for (m = 0; m < showhidefields.length; m++){
			                		var n = showhidefields[m];
			                	    atitle = atitle + dic[hidefields[m]][1] + ":" + rows[i][n] + " || ";
			                	}
			                	if (rows[i][k] == "" || rows[i][k] == "null") {
			                		rows[i][k] = "&nbsp;";
			                    }
			                    if(j==0)
			                		str = str + getRow1("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
			                	else{
			                		str = str + getRow("<a class=visit style='cursor:hand' href=javascript:modifyRecord1('" + className + "','" + rows[i][keyindex] + "','" + currpage + "','" + url_para + "','" + cmd + "'); title='" + atitle + "'>"+rows[i][k]+"</a>", fields[j]);
			                	}
			                }else{
			                	if(j==0)
			                		str = str + getRow1(rows[i][k], fields[j]);
			                	else{
			                		if(k!=20){
			                			str = str + getRow(rows[i][k], fields[j]);
			                		} else {
			                			// alert(options[i])
			                			var select = "<select id=\""+rows[i][0]+"\" name=\""+rows[i][0]+"\">"+options[i]+"</select>";
			                			str = str + getRow(select, fields[j]);
			                		}
			                	}
			                }                
			            }        
			            str = str + "</tr>\n";
			        }
			    }
			    str = str + '</table>';
			    document.getElementById("list").innerHTML = str;
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
													          	结题名称：<%=p.getPracticeName() %>
													          &nbsp;课题名称：<%=report.getReport3() %>
													          <%
												        	  List honorNameList = new ArrayList();
													          if (report.getType()==1) {//集体
													        	  int termId = Tool.StrToInt(report.getTeamId());
													        	  PracticeDeclareTeam term = new PracticeDeclareTeam();
													        	  term = term.getById(termId);
													        	  String honors = term.getHonor();
													        	  Honor h = new Honor();
													        	  List cdt = new ArrayList();
													        	  List list = new ArrayList();
													        	  cdt.add("id in("+honors+")");
													        	  list = h.query(cdt);
													        	  if (list.size()>0) {
														        	  for (int i=0;i<list.size();i++ ){
														        		  h = (Honor)list.get(i);
														        		  honorNameList.add(h.getHonorName());
														        	  }
														        	  if("1".equals(term.getRemark())) {
														        		  honorNameList.add("<span style='color:red;'>审核通过</span>");
														        	  }
														        	  if("2".equals(term.getRemark())) {
														        		  honorNameList.add("<span style='color:red;'>审核不通过</span>");
														        	  }
														        	 }
													          }%>
													          </div>
													          <%-- <div class="browsetitle002"><%=XtUtil.getSpell(report.getReport3()+"成员")%></div> --%>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <%-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li>
														            <li><a href="javascript:document.query.submit();">查询</a></li> --%>
														            <%if (userInfo.hasFunPower(Power.UserAdminPower)&&report.getTwCheckFlag()!=1) {%>
														            	<%
														            	if (report.getType() ==1) {%>
															            	<li class="browsetitle_lang"><a href="javascript:AuditHonorJt('<%=request.getAttribute("classname")%>', '<%=url %>',<%=currpage%>,<%=report.getTeamId()%>,<%=report.getDeclareId()%>);">设置集体荣誉</a></li>
														            	<%}
														            	%>
															            	<li class="browsetitle_lang"><a href="javascript:AuditHonor('<%=request.getAttribute("classname")%>', '<%=url %>',<%=currpage%>,<%=ReportId%>);">提交个人荣誉</a></li>
														            <%} %>
														            <%
														            if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHSJ)) {%>
														            	<li class="browsetitle_lang"><a href="javascript:CheckHonor('<%=request.getAttribute("classname")%>', '<%=url %>',<%=currpage%>,2);">个人审核不通过</a></li>
														            	<li class="browsetitle_lang"><a href="javascript:CheckHonor('<%=request.getAttribute("classname")%>', '<%=url %>',<%=currpage%>,1);">个人审核通过</a></li>
														            <%}
														            %>
														             <li><a href="javascript:document.query.submit();">查询</a></li>
													            </ul>
												              </div>
												           </div>
											            </div>	
											            <%
													          if (honorNameList.size()>0) {%>
													         <div>集体荣誉：<%=Tool.join(",",honorNameList) %></div>
													         <%
													         if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHSJ)) {
													         %>
														     <button onclick="CheckHonorJt('<%=request.getAttribute("classname")%>', '<%=url %>',<%=currpage%>,<%=report.getTeamId()%>,1)">集体审核通过</button>
													         <button onclick="CheckHonorJt('<%=request.getAttribute("classname")%>', '<%=url %>',<%=currpage%>,<%=report.getTeamId()%>,2)">集体审核不通过</button>
													          <%}
													          }
													          %>                                   
											            </td>
                                </tr>    										
                                </table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
    								<input id="_ReportId_"name="_ReportId_" value="<%=ReportId%>" type="hidden"/>
  									<tr>
    									<td>
                               <div class="browsetable2">
											<input type="hidden" name="cmd" value="list">
											<%-- <%=Tool.join("\n", forms)%> --%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
													<td>
														<div align="right">学号</div>
													</td>
													<td>
														<input name="_Sno_" value="<%=ParamUtils.getParameter(request, "_Sno_", "")%>">
													</td>
													<%-- <td>
														<div align="right">姓名</div>
													</td>
													<td>
														<input name="_SName_" value="<%=ParamUtils.getParameter(request, "_SName_", "")%>">
													</td>
													<td colspan="2">&nbsp;</td> --%>
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
		<div id="top_dialog"></div>
	</body>
</html>
