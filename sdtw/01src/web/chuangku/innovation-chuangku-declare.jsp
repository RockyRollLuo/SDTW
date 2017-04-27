<%@page import="com.xietong.software.sdtw.db.ChuangKu"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.sdtw.db.ChuangkuDeclare"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@ page pageEncoding="utf-8" %>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>


<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script src="../main/js/common.js"></script>
<script type="text/javascript">
<%String cmd = ParamUtils.getParameter(request,"cmd",""); %>
function addItem(){

	openWindow("BaseUserCodeAction.jsp?cmd=list&roles=3&values="+$("#SId").val(),"703,400");


	}
	function setRole(pName,pId){
		$("#teamtable").append(pName);
		$("#SId").val(pId);
	}
	
	function deleteSponsor(trid,id){
		$('#'+trid).remove();
		var files = document.form1.SId.value;
	
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
			document.form1.SId.value = files;
		}
	}


	function form1datacheck(){  
	 	if (document.form1.Cd1.value==""){
	    	alert("项目名称不能为空！");
	    	document.form1.Cd1.focus();
	    	return false;
	  	}
	  	if(document.form1.Cd2.value == ""){
	        alert("项目分类不能为空！");
	        document.form1.Cd2.focus();
	        return false;
	  	}
	  	if(document.form1.Cd3.value == ""){
	        alert("项目分组不能为空！");
	        document.form1.Cd3.focus();
	        return false;
	  	}
	  	if(document.form1.Cd4.value == ""){
	        alert("技术可行性分析不能为空！");
	        document.form1.Cd4.focus();
	        return false;
	  	}
	 	if(document.form1.Cd5.value == ""){
	        alert("市场可行性分析不能为空！");
	        document.form1.Cd5.focus();
	        return false;
	  	}
	 	if(document.form1.Cd6.value == ""){
	        alert("项目推进时间分析不能为空！");
	        document.form1.Cd6.focus();
	        return false;
	  	}
	 	if(document.form1.Cd7.value == ""){
	        alert("项目阶段不能为空！");
	        document.form1.Cd7.focus();
	        return false;
	  	}
	  	var inputs=$("#teamtable").find('input');
	 for(var i=0;i<inputs.length;i++){
	 	 if(inputs[i].value==""){
			 alert("团队成员电话号码不能为空！"); 
			 inputs[i].focus();
			  return false;
		 } 
	 }  

	    
	  return true;
	}

function form99submit(){
	if(form1datacheck()){
		document.form1.submit();
}
}

function form99cancel(){
	window.location.href="innovation-chuangku-list.jsp";
}
function uploadOtherAttatch(){//上传其他附件
	//debugger;
	var name=document.getElementById('OtherAttach').value;
    $("#load1")
    .ajaxStart(function(){
        $(this).show();
    })
    .ajaxComplete(function(){
        $(this).hide();
    });
    $.ajaxFileUpload
    (
        {
            url:'ChuangkuDeclareAction.jsp?cmd=otherattach',
            secureuri:false,
            fileElementId:'OtherAttach',
            type:'post',	
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
                    	//alert(data.ids);
                    	// if(document.postForm.AddFileList.value==""){
                         	var be = data.url.indexOf("=");
                         	var en = data.url.lastIndexOf("/");
                         	document.form1.AddFilelist.value = data.ids;
                        
                        /*  }else{
                         	var be = data.url.indexOf("=");
                         	var en = data.url.lastIndexOf("/");
                         	document.postForm.AddFileList.value += ","+data.ids;
                         }  */
                         
                        var table = document.getElementById('ShowFiles');
                        var num = table.rows.length;
                        var row = table.insertRow(num);
                        var filename = data.url.replace(/.*(\/|\\)/, "");
                        filename = data.name;
                        
                        var cell = row.insertCell(0);
                        <%
                        	if(cmd.equals("update")){
                        %>
		                        row.id = data.ids;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'<%=HeadConst.apache_url %>/main/images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'<%=HeadConst.apache_url %>/main/images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.ids+');\' style="cursor:point;"/>';
                        <%
                        	}else{
                        %>
		                        row.id = data.ids;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'<%=HeadConst.apache_url %>/main/images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'<%=HeadConst.apache_url %>/main/images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.ids+');\' style="cursor:point;"/>';
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

/*
上传文档格式过滤
*/
function checkFileType(){//上传文档格式过滤
	var file=document.getElementById('OtherAttach').value;
	if(file){
		var allowType = {"doc":"", "xls":"", "docx":"", "xlsx":""};
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
function addItem(){

	openWindow("BaseUserCodeAction.jsp?values="+$("#SId").val(),"703,400");


	}
	function setRole(pName,pId){
		$("#teamtable").append(pName);
		$("#SId").val(pId);
	}
function deleteUpdateFile(name,id){//删除修改时上传附件
	if(confirm('是否确定删除？')){
		$.ajax({
			type:"post",			
			url:"club-setup-addsave.jsp?cmd=delAttach&did="+id,
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
        				var row = document.getElementById(id);
        				for(var i=0;i<row.cells.length;i++){
        					row.deleteCell(i);
        				}
        				
        				var files = document.form1.AddFilelist.value;
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
        					document.form1.AddFilelist.value = files;
        				}
                    }
                }
             },
            error: function (data, status, e){
            	$("#load1").hide();
                alert("删除文件失败!");
            }
		});
	}
	return false;
}
</script>
</head>
<%
String ckid=request.getParameter("id");

String useraccount=(String)session.getAttribute("useraccount");

String cd4="①项目简介：项目名称、主要用途等。②项目技术来源：自主开发、产学研合作开发技术、国内其它单位及个人技术、引进技术本企业消化创新。"
+"③国内外相关技术的研究、开发现状的介绍、分析。"
+"④本项目研究开发的内容、主要创新点、涉及的关键技术、所采用的技术路线（图）、技术指标、技术先进性描述等，要有数据分析、对比。"
+"⑤与项目相关的专利情况：专利号码、专利名称、专利权人（名称、性质、与项目单位关系）、进展情况（申请、受理、授权、专利范围（国内专利、国际专利及申请地），简述专利说明书内容。";
String cd5="①行业及市场概述。简要介绍国内外行业状况、市场容量，分析该产品在市场中的增加趋势，要有数据分析、对比。"
+"②该项目产品的市场需求程度。分析该产品市场可接受的容量，国内、外市场在哪，主要市场在哪。"
+"③该项目产品的目标市场。结合产品优势、企业优势，确定该产品的细分市场定位，分析与市场同类产品的竞争优势。";

%>
<body>
<%
String strposition = "创新创业>>山大创库>>";
String strfunction = "申请表";
String strhelpwords = "填写申请表。";
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}


BaseUserCode user=userInfo.getUserCode();
List zhongleiOptions=CEditConst.getCkProjectTypeOptions(userInfo,"");
List chuangyefenzuOptions=CEditConst.getCkProjectGroupOptions(userInfo,"");
List xiangmujieduan=CEditConst.getCkProjectStageOptions(userInfo,"");
ChuangkuDeclare vzd=new ChuangkuDeclare ();
String chuangkuid=request.getParameter("chuangkuid");
ChuangKu ck= new ChuangKu ();
ck=ck.getById(Integer.parseInt(chuangkuid));
%>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %> --%>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>山大创库>><%=ck.getCk1() %>申请表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="command-table">

<tr height="35px">
	<td>
		<a href="innovation-chuangku-list.jsp">返回</a>
	</td>
</tr>    
</table>
<form name="form1" method="post" action="ChuangkuDeclareAction.jsp?cmd=save1">
<table class="content-table">
<tr>
	<th colspan="8" align="left">“山大创库”项目入库申请表</th> 
</tr>


<input name="SId"  id="SId"  type="hidden"/>
<input name="Academy"  id="Academy"  type="hidden" value="<%=user.getDeptId()%>"/>

<input name="AddAccount"  id="AddAccount"  type="hidden" value="<%=user.getId()%>"/>
<tr>
	<td width="27%" align="right">项目名称</td>
	<td align="left" colspan="2"><input type="text" name="Cd1" size="40"/></td>
</tr>
<tr>
	<td align="right">项目分类</td>
	<td align="left" colspan="2">
		<!-- <input type="radio" name="cd2" value="创新类"/>创新类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="cd2" value="创业类"/>创业类 -->
		<%=HtmlTool.renderSelect(zhongleiOptions,  "", "Cd2", "-1")%>
	</td>
</tr>

<tr>
	<td align="right">项目分组</td>
	<td align="left" colspan="2">
		<%=HtmlTool.renderSelect(chuangyefenzuOptions,  "", "Cd3", "-1")%>
<!-- 		<input type="radio" name="cd3" value="制造业"/>制造业&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="cd3" value="信息技术服务"/>信息技术服务<br/>
		<input type="radio" name="cd3" value="商务服务"/>商务服务&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="cd3" value="公共服务"/>公共服务<br/>
		<input type="radio" name="cd3" value="公益创业"/>公益创业&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="cd3" value="现代农业"/>现代农业<br/>
		<input type="radio" name="cd3" value="节能环保"/>节能环保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="cd3" value="新材料"/>新材料<br/>
		<input type="radio" name="cd3" value="生物医药"/>生物医药&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="cd3" value="互联网项目"/>互联网项目<br/> -->
	</td>
</tr>

<tr>

	<td align="right">团队成员<br><a href="#" onclick="addItem();return false;">添加</a></td>
	<td align="left" colspan="2">
		<table class="content-table" id="teamtable">
			
			<tr>
				<td>学号</td><td>姓名</td><td>学院</td><td>手机号</td><td>职责</td><td>操作</td>
			</tr>
	
			
		</table>
		
	</td>
</tr>
<tr>
	<td align="right">技术可行性分析</td>
	<td align="left" colspan="2">
		<textarea name="Cd4" cols="100" rows="10" placeholder="<%=cd4%>"></textarea>
	</td>
</tr>
<tr>

	<td align="right">市场可行性分析</td>
	<td align="left" colspan="2">
		<textarea name="Cd5" cols="100" rows="10" placeholder="<%=cd5%>"></textarea>
	</td>
</tr>
<tr>
	<td align="right">项目推进时间分析</td>
	<td align="left" colspan="2">
		<textarea name="Cd6" cols="100" rows="10" placeholder="提出（分析）项目未来1-3年的定位及发展规划。"></textarea>
	</td>
</tr>
<tr>
	<td align="right">项目阶段</td>
	<td align="left" colspan="2">
		<%=HtmlTool.renderSelect(xiangmujieduan,  "", "Cd7", "-1")%>
<!-- 		<input type="radio" name="cd7" value="已经注册公司"/>已经注册公司<br/>
		<input type="radio" name="cd7" value="公司正在筹备阶段"/>公司正在筹备阶段<br/>
		<input type="radio" name="cd7" value="项目已经开始实施"/>项目已经开始实施<br/>
		<input type="radio" name="cd7" value="项目论证阶段"/>项目论证阶段<br/>
		<input type="radio" name="cd7" value="其他阶段"/>其他阶段<br/> -->
	</td>
</tr>
<tr>
	<td align="right">项目情况</td>
	<td align="left" colspan="2">
		<p>是否有社会资金注入：
			<input type="radio" name="Cd8" value="无"/>无
			<input type="radio" name="Cd8" value="有"/>有  &nbsp;（请注明注资额度为  
		    <input type="number" name="Cd9" value=""/> 万）
		</p>
		<p>计划注册资本金为：
			<input type="number" name="Cd10" value=""/>  万，其中创业团队自有资金
			<input type="number" name="Cd11" value=""/> 万</p>
		<p>团队已经经营该项目时间：
			<input type="number" name="Cd12" value=""/> 个月，盈利情况：
			<input type="number"name="Cd13" value=""/> 万
		</p>
	</td>
</tr>
<input type="hidden" name="CkId" value="<%=chuangkuid%>"/>
<tr>
	<td align="right">备注</td>
	<td align="left" colspan="2">
		<textarea name="Cd14" cols="100" rows="10" placeholder="其他需要说明的情况"></textarea>
	</td>
</tr>
	<tr height="35"><td colspan="4" class="blocktitle">附件上传</td></tr>
<input type="hidden"  name="AddFilelist" id="AddFilelist" value="<%=vzd.getAddFilelist()%>"/>
<input type="hidden" name="Id" id="Id"value="<%=vzd.getId()%>"/>
<tr id="postFormBookedBooths">
	<td class="form_label"  width="14%" >
	<div align="right">相关附件：</div>
	</td>
		<td bgcolor="#FFFFFF" colspan="3" align="left">
		<table width="100%" border="0" cellspacing="0" id="ShowFiles">
			<%
				if(vzd.getId()!=-1){
					ClientAttach ca = new ClientAttach();
					//ca.setDataBase("sdtw");
					String ids = vzd.getAddFilelist();
					if(ids!=null&&ids.trim().length()>0){
						String[] idArray = Tool.split(",",ids);
						for(int i=0;i<idArray.length;i++){
							ClientAttach ca1 = ca.getById(Tool.StrToInt(idArray[i]));
							if(ca1!=null){
								%>
								<tr id="<%=ca1.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca1.getId() %>" target="_blank">
								<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()%>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
								<%	}
								}
							}
						}
					%>
		</table>
		<%if(vzd.getId()==-1){%>
		<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
		<input type="button" value="上传" id="btn_up"  onclick="checkFileType();" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
		<%} %>
		<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    <div style="color:red">请上传doc、docx、xlsx或xls格式文件，文件最大5M</div>
	</td>
</tr>



<%



String filepath = "/datafile/chuangku/";
String filenamecode = useraccount;
String moduleapp = "../role-student/innovation-chuangku-list.jsp";
String mytip="";
%>
<%-- <%@include file="../pubpro/fileupload-form.jsp" %>
 --%>
<tr>
	<th colspan="3">
		<input class="button" type="button" value="提交" name="btn1" onclick="form99submit()">&nbsp;&nbsp;&nbsp;
    	<input class="button" type="button" value="取消" name="btn2" onclick="form99cancel()">&nbsp;&nbsp;&nbsp;
	</th>
</tr>
</table>

</form>

</body>
</html>