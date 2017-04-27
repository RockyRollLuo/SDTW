<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
			
			//图片
			function deletePic(){
				
				document.postForm.Attachids.value="";
				document.getElementById("FrequencyPic").style.display = "none";
				document.getElementById("deletePic").style.display = "none";
				alert("图片已成功删除");
			}
			
			function ajaxFileUpload(){//上传示意图片 
				var Attachids;//保存上传成功后 图片在服务器上的路径
				var fileElement;//保存本地要上传的文件 的 地址
				var picPath;//在form页  上传后显示示
				Attachids = document.postForm.Attachids.value;
				fileElement='FrequencyInfo';
				picPath='FrequencyPic';
			    $("#load")
			    .ajaxStart(function(){
			        $(this).show();
			    })
			    .ajaxComplete(function(){
			        $(this).hide();
			    });
			    $.ajaxFileUpload
			    (
			        {
			            url:'YouthhonourStudentForm-save.jsp?cmd=upPic&Attachids='+Attachids,
			            secureuri:false,
			            fileElementId:fileElement,
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
			                        var pic = document.getElementById(picPath);
			                        pic.src = '<%=HeadConst.apache_url%>'+data.url+'?time='+new Date();
			                        pic.style.display = '';
			                        	document.postForm.Attachids.value = data.url;    
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
			
			function checkType(){//上传图片格式过滤
				var file=document.getElementById('FrequencyInfo').value;
				if(file){
					var allowType = {"gif":"", "jpg":"", "jpeg":"", "bmp":"", "png":""};
					var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
					var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : ''; //jquery获得后缀名
					if((fileExt+"").toLowerCase() in allowType){
						ajaxFileUpload();
					}
					else{
						alert("上传文件格式不符合要求，请重新选择！");
					}
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

<input type="hidden" name="Text3" id="Text3" value="<%=v.getText3()%>"/>
<input type="hidden" name="Text4" id="Text4" value="<%=v.getText4()%>"/>
<input type="hidden" name="Text5" id="Text5" value="<%=v.getText5()%>"/>
<input type="hidden" name="Text6" id="Text6" value="<%=v.getText6()%>"/>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
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
														    			<%if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){%>
																			<%=HtmlTool.renderSelect(AcademyNameoptions, v.getBelongAcademy(), "BelongAcademy", "")%>
																		<%}else{%>
																			<%=myacademyname%>
																			<input type="hidden" name="BelongAcademy" id="BelongAcademy" disabled="disabled" value="<%=v.getBelongAcademy()%>"/>
																		<%}%>
                    													</td>
													  				</tr>

                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val1" id="Val1" size="45" maxsize="45" value="<%=v.getVal1()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">性别</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val2" id="Val2" size="45" maxsize="45" value="<%=v.getVal2()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">出生年月</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val3" id="Val3" size="45" maxsize="45" value="<%=v.getVal3()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">民族</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val4" id="Val4" size="45" maxsize="45" value="<%=v.getVal4()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">政治面貌</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val5" id="Val5" size="45" maxsize="45" value="<%=v.getVal5()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">联系电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val6" id="Val6" size="45" maxsize="45" value="<%=v.getVal6()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">所在团支部</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val7" id="Val7" size="45" maxsize="45" value="<%=v.getVal7()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val8" id="Val8" size="45" maxsize="45" value="<%=v.getVal8()%>"/>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">主要事迹</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text1" id="Text1" cols="80" rows="6"><%=v.getText1()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">获奖情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text2" id="Text2" cols="80" rows="6"><%=v.getText2()%></textarea>
                    													</td>
													  				</tr>
													  		<!--图片-->
<tr id="postFormAttachIds" >
	<td class="form_label" align="right">上传照片</td>
 	<td bgcolor="#FFFFFF"  align="left">
 		<input type="hidden" name="Attachids" id="Attachids" value="<%=v.getAttachids()%>"/>
	<%
if(cmd.equals("update")||"view".equals(cmd)){
	String cid = v.getAttachids();
	if(!cid.equals("-1")&&!cid.equals("")){%>
	<img id="FrequencyPic" name="FrequencyPic" src="<%=HeadConst.apache_url+cid%>" alt="照片" title="照片" onload="javascript:DrawImage(this,200,200)" height="200" width="200"/>
	<%}else{%>
	<img id="FrequencyPic" name="FrequencyPic" src="" alt="照片" title="照片" style="display:none"  onload="javascript:DrawImage(this,200,200)" height="200" width="200"/>
	<a href="javascript: deletePic();" ><img id="deletePic" name="deletePic" src='../../images/delete.gif' alt='删除' title='删除' border="0" style="display:none"/></a>
<%	}
}else{%>
	<img id="FrequencyPic" name="FrequencyPic" src="" alt="照片" title="照片" style="display:none"  onload="javascript:DrawImage(this,200,200)" height="200" width="200"/>
	<a href="javascript: deletePic();" ><img id="deletePic" name="deletePic" src='../../images/delete.gif' alt='删除' title='删除' border="0" style="display:none"/></a>
<%}
if(myown==1||"save".equals(cmd)){%>
		<br/>
		<input type="file" name="FrequencyInfo" id="FrequencyInfo" size="40"/> 
	    <input type="button" value="上传"  onclick="checkType();"/>
	    <div style="color:red">
	    	支持以下格式的文件：.gif、.jpg、.jpeg、.bmp、.png;文件最大3M。
	    	<img style="display:none" id="load" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    </div>
<%}%>
	</td>
</tr>
<!--end pic-->
                    											</table>
			</form>
		</div>
	</body>
</html>
