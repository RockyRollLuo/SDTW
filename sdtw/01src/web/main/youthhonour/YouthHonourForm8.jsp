<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--五四评比表彰申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@ page import="com.xietong.software.base.SdtwConst"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	
	Log log = LogFactory.getLog(YouthHonour.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	YouthHonour v = (YouthHonour)request.getAttribute("fromBean");
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

	//currentSchoolyear
	Date sdate=new Date();
	String currentSchoolyear=CurrentSemester.getSchoolYear(sdate);
	
	YouthhonourUtil yhUtil=new YouthhonourUtil();
	//noticeid,type
	int noticeid=ParamUtils.getIntParameter(request, "noticeid", -1);
	int type=ParamUtils.getIntParameter(request, "type", -1);
	
	//youthhonour_notice
	Youthhonour_notice yhNotice=new Youthhonour_notice();
	yhNotice=yhNotice.getById(noticeid);
	
	//academyname
	Map academynamemap=CEditConst.getAcademyNameMap(userInfo);
	String myacademyname=(String)academynamemap.get(userInfo.getDeptId()+"");
	
	//checkmap
	Map xyCheckMap=yhUtil.getXyCheckMap();
	Map twCheckMap=yhUtil.getTwCheckMap();
	
	//判断是否是自己添加的
	int myown=0;
	if((userInfo.getId()+"").equals(v.getAddaccount())) myown=1;
	
	
	List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
 			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
 		</script>
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
			
			
			
			/*
			上传文档格式过滤
			*/
			function checkDocType(){//上传文档格式过滤
				var file=document.getElementById('OtherAttach').value;
				if(file){
					var allowType = {"doc":"", "xls":"", "docx":"", "xlsx":"","pdf":""};
					var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
					var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';//jquery获得后缀名
					if((fileExt+"").toLowerCase() in allowType){
						uploadOtherAttatch();
					}
					else{
						alert("上传文件格式不符合要求，请重新选择！");
					}
				}
				return false;
			}
			function checkFile(){//过滤重复上传附件
				var file=document.getElementById('OtherAttach').value;
				if(file){
					var filename = file.replace(/.*(\/|\\)/, "");
					if(document.postForm.AttachIds.value.indexOf(filename)!=-1){
						alert('上传附件名相同，请修改名称后再上传!');
					}
					else{	
						uploadOtherAttatch();
					}
				}
				return false;
			}
			function uploadOtherAttatch(){//上传其他附件
				
			    $("#load1").ajaxStart(function(){
			        $(this).show();
			    }).ajaxComplete(function(){
			        $(this).hide();
			    });
			  	
			    $.ajaxFileUpload
			    (
			        {
			            url:'YouthHonourAction.jsp?cmd=otherattach&type=<%=type%>',
			            secureuri:false,
			            fileElementId:'OtherAttach',
			            dataType: 'json',
			            success: function (data, status)
			            {
			                if(typeof(data.error) != 'undefined')
			                {
			                    if(data.error != '')
			                    {                    
			                        alert(data.error);
			                    }else
			                    {
		                         	var be = data.url.indexOf("=");
		                         	var en = data.url.lastIndexOf("/");
		                        
		                         	document.postForm.Attachids.value= data.ids;
			                        var table = document.getElementById('ShowFiles');
			                        var num = table.rows.length;
			                        var row = table.insertRow(num);
			                        var filename = data.url.replace(/.*(\/|\\)/, "");
			                       
			                        var cell = row.insertCell(0);
			                        <%
			                        	if(cmd.equals("update")){
			                        %>
			                        row.id = data.ids;//修改时以防和之前重名
					                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("tempnew'+filename+'",'+data.url.substring(be+1,en)+');\' style="cursor:point;"/>';
			                        <%
			                        	}else{
			                        %>
			                        row.id = data.ids;//修改时以防和之前重名
					                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.url.substring(be+1,en)+');\' style="cursor:point;"/>';
			                        <%
			                        	}
			                        %>
			                    }
			                }
			            },
			            error: function (data, status, e)
			            {
			                alert("上传文件失败，请重新上传！");
			            }
			        }
			    )
			} 

			function deleteUpdateFile(name,id){//删除修改时上传附件
				if(confirm('是否确定删除？')){
					$.ajax({
						type:"post",			
						url:"YouthHonourAction.jsp?cmd=delAttach&type=<%=type%>&did="+id,
						dataType:"json",
						beforeSend:function(){
							$("#load1").show();
						},
						success:function(data, status, e){
				        	if(typeof(data.error) != 'undefined'){
			                    if(data.error != '')
			                    {
			                        alert(data.error);
			                    }else
			                    {
			                    	$("#load1").hide();
			        				var row = document.getElementById(name);
			        				for(var i=0;i<row.cells.length;i++){
			        					row.deleteCell(i);
			        				}
			        				var files = document.postForm.Attachids.value;
			        				//alert(files+" "+id+" "+files.indexOf(id))
			        				if(files.indexOf(id)!=-1){
			        					//替换删掉的附件id
			        					files = ","+files+",";
			        					files = files.replace(","+id+",",',');
			        					//没有附件的情况
			        					if(files.indexOf(",")==files.lastIndexOf(","))
			        						files = "";
			        					else{
			        						files = files.substring(1,files.length-1);
			        					}
			        					document.postForm.Attachids.value = files;
			        				}
			                    }
			                }							
			             },
			            error: function (data, status, e){
			            	$("#load1").hide();
			                alert("上传文件失败，请重新上传！");
			            }
					});
				}
				return false;
			}
			
			//审核一条YouthHonour
			function checkYh(id,e){
				$.ajax({
					type:"post",			
					url:"YouthHonourAction.jsp?cmd=checkYh&id="+id+"&checkflag="+e,
					dataType:"json",
					success:function(data){
						alert(data.msg);
						window.location.reload();
					},
					error:function(data){
						alert("操作失败");	
					}
				});			
			}
			//审核申请修改
			function checkApplyModify(id){
				$.ajax({
					type:"post",			
					url:"YouthHonourAction.jsp?cmd=checkApplymodify&id="+id,
					dataType:"json",
					success:function(data){
						alert(data.msg);
						window.location.href="YouthHonourAction.jsp?cmd=list&noticeid=<%=noticeid%>&type=<%=type%>&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>";
					},
					error:function(data){
						alert("操作失败");	
					}
				});			
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">五四评比表彰申请表</div>
				<div class="browsetitle002"><%=yhUtil.youthhonourName.get(type)%></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="YouthHonourAction.jsp?cmd=list&noticeid=<%=noticeid%>&type=<%=type%>&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%if((myown==1&&(yhUtil.getOneXyReportFlag(noticeid,userInfo.getDeptId())==SdtwConst.XYREPORT_WSB)&&(yhNotice.getTwReport()==SdtwConst.TWREPORT_WGB))||"save".equals(cmd)){%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
						<%}
						//学院方面，未上报才能审核，团委未公布才能审核
						if(userInfo.hasFunPower(Power.UserAdminPower)){
							if((yhUtil.getOneXyReportFlag(noticeid,userInfo.getDeptId())==SdtwConst.XYREPORT_WSB)&&!"save".equals(cmd)){//学院未上报%>
								<%if(v.getModifyFlag()==SdtwConst.MODIFY_SQXG){%>							
									<li><a href="#" onclick="javascript:checkApplyModify(<%=v.getId()%>);" >同意修改</a></li>
							    <%}%>
								<li><a href="#" onclick="javascript:checkYh(<%=v.getId()%>,'N');" >不通过</a></li>
								<li><a href="#" onclick="javascript:checkYh(<%=v.getId()%>,'Y');" >通过</a></li>
						<%	}
						}else if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
							if((yhNotice.getTwReport()==SdtwConst.TWREPORT_WGB)&&!"save".equals(cmd)){%>
								<li><a href="#" onclick="javascript:checkYh(<%=v.getId()%>,'N');" >不通过</a></li>
								<li><a href="#" onclick="javascript:checkYh(<%=v.getId()%>,'Y');" >通过</a></li>
						<%  }
						}%>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
		
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">参与校园文化活动情况</a></li>
				<li><a href="#tabs-2">学院学生组织开展活动情况</a></li>
				<li><a href="#tabs-3">学院特色活动</a></li>
				<li><a href="#tabs-4">学院参与比赛、活动获奖情况</a></li>
				<li><a href="#tabs-5">相关支撑材料</a></li>
			</ul>
		
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>"/>
				<input type="hidden" name="page" value="<%=currpage%>"/>
				<%=Tool.join("\n", forms)%>
<input type="hidden" name="Id" value="<%=v.getId()%>"/>
<input type="hidden" name="Noticeid" value="<%=v.getNoticeid()%>"/>
<input type="hidden" name="noticeid" value="<%=v.getNoticeid()%>"/>
<input type="hidden" name="Type" value="<%=v.getType()%>"/>
<input type="hidden" name="Addaccount" value="<%=v.getAddaccount()%>"/>
<input type="hidden" name="Addtime" value="<%=v.getAddtime()%>"/>
                    												
<input type="hidden" name="SchoolYear" id="SchoolYear" size="45" maxsize="45" disabled="disabled" value="<%=v.getSchoolYear()%>" />
<input type="hidden" name="ModifyFlag" id="ModifyFlag" value="<%=v.getModifyFlag()%>"/>
<input type="hidden" name="XyReport" id="XyReport" value="<%=v.getXyReport()%>"/>
<input type="hidden" name="TwReport" id="TwReport" value="<%=v.getTwReport()%>"/>
<input type="hidden" name="XyCheckDate" value="<%=v.getXyCheckDate()%>"/>
<input type="hidden" name="TwCheckDate" value="<%=v.getTwCheckDate()%>"/>

<input type="hidden" name="Val9" id="Val9" value="<%=v.getVal9()%>"/>
<input type="hidden" name="Val10" id="Val10" value="<%=v.getVal10()%>"/>
<input type="hidden" name="Val11" id="Val11" value="<%=v.getVal11()%>"/>
<input type="hidden" name="Val12" id="Val12" value="<%=v.getVal12()%>"/>
<input type="hidden" name="Val13" id="Val13" value="<%=v.getVal13()%>"/>
<input type="hidden" name="Val14" id="Val14" value="<%=v.getVal14()%>"/>
<input type="hidden" name="Val15" id="Val15" value="<%=v.getVal15()%>"/>
<input type="hidden" name="Val16" id="Val16" value="<%=v.getVal16()%>"/>
<input type="hidden" name="Val17" id="Val17" value="<%=v.getVal17()%>"/>
<input type="hidden" name="Val18" id="Val18" value="<%=v.getVal18()%>"/>
<input type="hidden" name="Val19" id="Val19" value="<%=v.getVal19()%>"/>
<input type="hidden" name="Val20" id="Val20" value="<%=v.getVal20()%>"/>
<input type="hidden" name="Val21" id="Val21" value="<%=v.getVal21()%>"/>
<input type="hidden" name="Val22" id="Val22" value="<%=v.getVal22()%>"/>

																<div id="tabs-1" style="border: 0px;">
                    											<table width="100%" style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">学院审核结果</td>
														    			<td align="left"  bgcolor="#ffffff">
														    				<%=xyCheckMap.get(v.getAyCheckFlag())%>
                    														<input type="hidden" name="AyCheckFlag" id="AyCheckFlag" value="<%=v.getAyCheckFlag()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委审核结果</td>
														    			<td align="left"  bgcolor="#ffffff">
														    				<%=twCheckMap.get(v.getTwCheckFlag())%>
                    														<input type="hidden" name="TwCheckFlag" id="TwCheckFlag" value="<%=v.getTwCheckFlag()%>"/>
                    													</td>
													  				</tr>

                    												<tr>
                    													<td align="right" class="form_label">所属单位</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)||userInfo.hasFunPower(Power.ZZJS)){%>
																			<%=HtmlTool.renderSelect(AcademyNameoptions, v.getBelongAcademy(), "BelongAcademy", "")%>
																		<%}else{%>
																			<%=myacademyname%>
																			<input type="hidden" name="BelongAcademy" id="BelongAcademy" disabled="disabled" value="<%=v.getBelongAcademy()%>"/>
																		<%}%>
                    													</td>
													  				</tr>

                    												<tr>
                    													<td align="right" class="form_label">指导教师</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val1" id="Val1" size="45" maxsize="45" value="<%=v.getVal1()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">合唱文化艺术节、科技文化艺术节参与人数及获奖情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text1" id="Text1" cols="80" rows="6"><%=v.getText1()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">校级艺术组织、社团组织、文化组织参与人数及获奖情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text2" id="Text2" cols="80" rows="6"><%=v.getText2()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">校外文化活动（市级及以上）参与人数及获奖情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text3" id="Text3" cols="80" rows="6"><%=v.getText3()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text4" id="Text4" cols="80" rows="6"><%=v.getText4()%></textarea>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
													  				
													  				<div id="tabs-2" style="border: 0px;">
                    												<table width="100%" style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">（学生会）参与校级学生组织活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val2" id="Val2" size="45" maxsize="45" value="<%=v.getVal2()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（研究生会）参与校级学生组织活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val3" id="Val3" size="45" maxsize="45" value="<%=v.getVal3()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">（学生会）学院特色活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val4" id="Val4" size="45" maxsize="45" value="<%=v.getVal4()%>"/>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">（研究生会）学院特色活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val5" id="Val5" size="45" maxsize="45" value="<%=v.getVal5()%>"/>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">（学生社团）参与校级学生组织活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val6" id="Val6" size="45" maxsize="45" value="<%=v.getVal6()%>"/>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">（学生社团）学院特色活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val7" id="Val7" size="45" maxsize="45" value="<%=v.getVal7()%>"/>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">（学生艺术团）参与校级学生组织活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val8" id="Val8" size="45" maxsize="45" value="<%=v.getVal8()%>"/>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">（学生会）学院特色活动</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val9" id="Val9" size="45" maxsize="45" value="<%=v.getVal9()%>"/>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
													  				
													  				<div id="tabs-3" style="border: 0px;">
                    												<table width="100%" style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">学院特色做法</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text5" id="Text5" cols="80" rows="6"><%=v.getText5()%></textarea>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
													  				
													  				<div id="tabs-4" style="border: 0px;">
                    												<table width="100%" style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">院级学生科技创新类社团、组织</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text6" id="Text6" cols="80" rows="6"><%=v.getText6()%></textarea>
                    													</td>
													  				</tr>
													  				</table>
													  				</div>
                    												
                    												<div id="tabs-5" style="border: 0px;">
                    												<table width="100%" style="background: #e3e5e8 ;" border="0" align="center" cellpadding="4" cellspacing="1" >
													  				<tr>
           																<input type="hidden" name="Attachids" id="Attachids"/>
                    												<!-- 上传其他附件 -->
                    												<div id="form" class="browsetable">
																	<table width="100%" border="0" cellspacing="0" bgcolor="D2D2D2">
																	<tr id="postFormBookedBooths"><td  class="form_label">
																	<div  align="right" style="color:#ffffff">附件</div>
																	</td>
																	<td bgcolor="#FFFFFF" colspan="3">
																	<table width="100%" border="0" cellspacing="0" bgcolor="D2D2D2" id="ShowFiles">
																	<%
																		if(v.getId()!=-1){
																			ClientAttach ca = new ClientAttach();
																			String ids = v.getAttachids();
																			if(ids!=null&&ids.trim().length()>0){
																				String[] idArray = Tool.split(",",ids);
																				for(int i=0;i<idArray.length;i++){
																				ClientAttach ca1 = ca.getById(Tool.StrToInt(idArray[i]));
																					if(ca1!=null){
																	%>
																					<tr  id="<%=ca1.getUploadName()+ca1.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca1.getId() %>" target="_blank"><img src='../images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;<img src='../images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()+ca1.getId() %>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
																	<%				}//删除无效id
																					else{
																	ids = (","+ids+",").replace(","+idArray[i]+",",",");
																	if(ids.length()==1){
																		ids = "";
																	}else{
																		ids = ids.substring(1,ids.length()-1);
																	}
																	v.setAttachids(ids);
																	v.update();
																}
															}
														}
													}
												%>
															</table>
															<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> <input type="button"  value="上传" onclick="return checkDocType();"/><img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
															<div style="color:red">请上传doc、docx、xls、xlsx或pdf格式文件，文件最大5M</div>
															</td></tr>
														</table>
														
													</div>
													  				</tr>
													  				</table>
													  				</div>
													  				

													  				
			</form>
		</div>
<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', 0); 
	});
	</script>
	</body>
</html>
