<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
//List genderoptions = (List)request.getAttribute("genderoptions");
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	List cdt = new ArrayList();
	cdt.add("flag=1");
List DeptNameoptions = COptionConst.getAcademyNameOptions(userInfo,"-1",cdt);//(List)request.getAttribute("DeptNameoptions");
List OrgNameoptions = CEditConst.getOrgCityNameOptions(userInfo,"-1");//(List)request.getAttribute("OrgNameoptions");
List RoleNameOptions = CEditConst.getRoleNameOptions(userInfo,"-1");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"-1");
cdt.clear();
cdt.add("academy="+ParamUtils.getParameter(request,"_DeptId_","-1"));
List MajorNameOptions = COptionConst.getMajorNameOptions(userInfo,"-1",cdt);
	//CEditConst.getMajorNameOptions(userInfo,"-1");
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css_blue.css"/>
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction.js"></script>
		<jsp:include page="../../main/comjs.jsp" flush="true"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
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
			function excel(){
				  $.messager.confirm('操作提示','是否下载excel模板？',function(r){
	            		if(r){
	            			window.open("<%=HeadConst.apache_url %>/servlet/attach?type=downUsers");
	            		}
	            	});
	            }
			function upload(){  //导入
            	$("#upwindow").window('open');
            }
			function closeUp(wName){   //关闭窗口
            	//$("#upwindow").window('close');
            	$('#'+wName).window('close');
            	$("#upFile").val("");
            	if(wName=='reswindow'){
            		window.location.reload();
            	}
            	//location.reload() ;
            }
			function checkType(){    //检查上传文件类型
            	var file=$("#upFile").val();
            	if(file){
            		var allowType = {"xls":""};
            		var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
            		var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : ''; //jquery获得后缀名
            		if((fileExt+"").toLowerCase() in allowType){
            			ajaxFileUpload();
            		}
            		else{
            			$.messager.alert('操作提示','上传文件格式不符合要求，请重新选择！','error');
            		}
            	}
            	
            	return;
            }
			function ajaxFileUpload(){//上传文件
				$('#img').show();
            	var fileElement;
            	fileElement='upFile';
            	$.ajaxFileUpload
                (
                    {
                        url:'UserCodeAction.jsp?cmd=upLoadFile',
                        secureuri:false,
                        fileElementId:fileElement,
                        dataType: 'json',
                        success: function (data, status)
                        {
                       
                            if(typeof(data.error) != 'undefined')
                            {
                                if(data.error != '')
                                {
                                	$.messager.alert('操作提示',data.error,'error');
                                }else
                                {
                                   // closeUp();
                                    $('#img').hide();
                                    $("#reswindow").window('open');
                                    $("#resArea").html(data.msg+"<br/>"+data.outstr);
                                    closeUp('upwindow');
                                    
                                }
                            }
                            
                        },
                        error: function (data, status, e)
                        {
                        	$.messager.alert('操作提示','上传文件失败，请重新上传！','error');
                        }
                    }
                )
            }
			function setGraduate() {
				 /* var chks = document.getElementsByName("chk1");
				    var chkeds = new Array();
				    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时
				        if (chks[i].checked == true) {
				            chkeds.push(chks[i].value);
				        }
				    }
				    if (chkeds.length > 0) {
				        //if (confirm("确实要设置这些记录为毕业吗?")) {
				            //location = className + "Action.jsp?cmd=deletelist&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
				            
				        	
				            
				       // }
				    } else {
				        alert("未选择记录！");
				    } */
				var url = "<%=HeadConst.apache_url%>/main/base/Graduate.jsp";
				parent.showDialog (url,400,367,'设置毕业人员'
                        ,{ '确定': function(){
                              parent.check();
                        }
              });

			}
			function getmajor() {
				$.ajax({
		            type: "post",
		            url: "<%=HeadConst.apache_url%>/main/base/UserCodeAction.jsp",
		            data: {academy:$('#_DeptId_').val(),cmd:'getmajor'},
		            dataType: "html",
		            async:false,
		            cache: false,
		            success: function(data){
		                       $( '#_Major_').html(data);
		                     },
		                     error : function() { 
		                                 // view("异常！"); 
		                                 alert( "异常！"); 
							}
				});
			}
			function download(className, url_para, page)
			{
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
			        if (confirm("确实要导出这些记录吗?")) {
			            location = className + "Action.jsp?cmd=excelselect&idlist=" + chkeds.join(',') + "&page=" + page + ((url_para.length == 0) ? "" : "&" + url_para);
			        }
			    } else {
			    	if (confirm("确实要导出这些记录吗?")) {
			    	document.query.cmd.value = 'excel'; document.query.submit();
			    	}
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
         											<td width="100"><b class="bt">[人员管理]</b></td>
        											<td>&nbsp;</td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr1.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.cmd.value = 'list';document.query.submit();">查询</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr2.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.cmd.value = 'list';addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr3.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.cmd.value = 'list';deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr3.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.cmd.value = 'list';setGraduate();">设置毕业</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.cmd.value = 'list';excel();">导入模板</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr2.png"></div></td>
        											<td width="55" class="bt"><a href="javascript: document.query.cmd.value = 'list';upload();">批量导入</a></td>
        											<td width="24"><div align="center"><img src="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbjanr5.png"></div></td>
        											<td width="55" class="bt"><a href="javascript:document.query.cmd.value = 'list';download('<%=request.getAttribute("classname")%>', url_para);">导出信息</a></td>
      											</tr>
    										</table>
										</td>
  									</tr>
    								<form action="<%=request.getAttribute("classname")%>Action.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td  class="cxbj">
											<input type="hidden" name="cmd" value="list"/>
											<%=Tool.join("\n", forms)%>
											<table border=0 cellspacing=3 cellpadding=5 width="100%">
												<tr>
													<td>
														<div align="right">城市</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(OrgNameoptions, ParamUtils.getParameter(request,"_OrgId_",""), "_OrgId_", "")%>
													</td>
													<td>
														<div align="right">入学年级</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(GradeNameOptions, ParamUtils.getParameter(request,"_Grade_",""), "_Grade_", "")%>
													</td>
													<td>
														<div align="right">学院</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(DeptNameoptions, ParamUtils.getParameter(request,"_DeptId_",""), "_DeptId_", "","onchange=getmajor()")%>
													</td>
													<td>
														<div align="right">专业</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(MajorNameOptions, ParamUtils.getParameter(request,"_Major_",""), "_Major_", "")%>
													</td>
												</tr>
												<tr>
												<td>
														<div align="right">用户帐号</div>
													</td>
													<td>
														<input name="_Name_" value="<%=ParamUtils.getParameter(request, "_Name_", "")%>"/>
													</td>
													<td>
														<div align="right">用户显示名</div>
													</td>
													<td>
														<input name="_CnName_" value="<%=ParamUtils.getParameter(request, "_CnName_", "")%>"/>
													</td>
													<%-- <td>
														<div align="right">用户编码</div>
													</td>
													<td>
														<input name="_Code_" value="<%=ParamUtils.getParameter(request, "_Code_", "")%>"/>
													</td> --%>
													<td>
														<div align="right">用户角色</div>
													</td>
													<td>
<%=HtmlTool.renderSelect(RoleNameOptions, ParamUtils.getParameter(request,"_Roles_",""), "_Roles_", "")%>
													</td>
													
												</tr>
												<%-- <tr>
													<td>
														<div align="right">用户职务</div>
													</td>
													<td>
														<input name="_Occupation_" value="<%=ParamUtils.getParameter(request, "_Occupation_", "")%>"/>
													</td>
													<td>
														<div align="right">办公电话</div>
													</td>
													<td>
														<input name="_PhoneNum_" value="<%=ParamUtils.getParameter(request, "_PhoneNum_", "")%>"/>
													</td>
													<td>
														<div align="right">手机号码</div>
													</td>
													<td>
														<input name="_MobilePhone_" value="<%=ParamUtils.getParameter(request, "_MobilePhone_", "")%>"/>
													</td>
												</tr> --%>
												<%-- <tr>
													<td>
														<div align="right">电子邮箱</div>
													</td>
													<td>
														<input name="_Email_" value="<%=ParamUtils.getParameter(request, "_Email_", "")%>"/>
													</td>
													<td colspan="4">&nbsp;</td>
												</tr> --%>
											</table>
										</td>
									</tr>
									</form>
									<tr>
    									<td valign="top">
      										<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
        										<tr>
          											<td>
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
											 				<tr>
											    				<td height="3" class="topline"></td>
															</tr>
														</table>
            											<table width="100%" border="0" cellspacing="0" cellpadding="0">
              												<tr><td height="2"></td></tr>
            											</table>
														<div id="list">
														</div>
														<%=(("listall".equals(cmd)))? "": pagecontrol.getControl1((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
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
				<td width="25">&nbsp;</td>
			</tr>
			<tr><td colspan="3" height="13"></td></tr>
		</table>
		<div id="upwindow" class="easyui-window" title="导入学生信息" collapsible="false" minimizable="false" closed="true"
        maximizable="false" icon="icon-save"  style="width: 400px; height: 250px; padding: 5px;
        background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                <tr>
                        <td>上传文件：</td>
                        <td><input id="upFile" name="upFile" type="file" class="txt01" /></td>
                </tr>
                <tr><td></td><td><font color="red">仅限xls格式的文件</font></td></tr>
                <tr id="img" style="display: none;"><td></td><td><font color="red"><img src="../../main/images/loading.gif"/></font></td></tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:checkType();">确定</a>
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:closeUp('upwindow');">取消</a>
            </div>
        </div>
    </div>
    <div id="reswindow" class="easyui-window" title="导入结果" collapsible="false" minimizable="false" closed="true"
        maximizable="false" icon="icon-save"  style="width: 300px;height:300px; padding: 5px;
        background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                <tr>
                        <td id="resArea" align="center" width="250px" align="center"></td>
                </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp1" class="easyui-linkbutton" icon="icon-ok" href="javascript:closeUp('reswindow');">确定</a>
            </div>
        </div>
    </div>
	</body>
</html>
