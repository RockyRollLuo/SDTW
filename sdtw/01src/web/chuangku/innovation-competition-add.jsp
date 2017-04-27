<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.sdtw.db.InnovationCompetition"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.db.InnovationCompetitionProject"%>
<%@ page pageEncoding="utf-8" %>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script> 
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>

<script src="../js/tablelist.js"></script>

<script src="../js/personlistorder.js"></script> 
<script src="../main/js/common.js"></script>
<script type="text/javascript">
// 通过form99提交用户输入(同时提取form1数据、form2数据)
function form99submit(){
  // 取form1表单数据,到form99隐藏框
  if(form1datacheck()){
	  document.form1.submit();
  }



}

function form1datacheck(){  
 	
  	if(document.form1.ProductionName.value == ""){
        alert("作品名称不能为空！");
        document.form1.ProductionName.focus();
        return false;
  	}
  	if(document.form1.Academy.value == ""){
        alert("学院全称不能为空！");
        document.form1.Academy.focus();
        return false;
  	}
  	if(document.form1.Declarer.value == ""){
        alert("申报者姓名（集体名称）不能为空！");
        document.form1.Declarer.focus();
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

</script>
</head>
<body>
<%
int proid=ParamUtils.getIntParameter(request, "proid",-1);

InnovationCompetitionProject  icp1= new InnovationCompetitionProject();
icp1= icp1.getById(proid);
%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>创业竞赛>><%=icp1.getProjectName() %>申请
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<%
String strposition = "创新创业管理>>竞赛管理";
String strfunction = "添加竞赛作品";
String strhelpwords = "添加竞赛作品。";
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
List projectOptions=new  ArrayList();
System.out.println( projectOptions);
InnovationCompetitionProject icp= new InnovationCompetitionProject();
List cdt= new  ArrayList();
List list= new ArrayList();
list =icp.query(cdt);
int xuhao=0;
int tiaoshu=list.size();
if(list.size()>0){
	OptionBean ob= new OptionBean("","");
	projectOptions.add(ob);
	for(int i=0;i<list.size();i++){
		icp=(InnovationCompetitionProject)list.get(i);
		ob= new OptionBean(icp.getProjectName(),icp.getId()+"");
		projectOptions.add(ob);
	}
	
}
InnovationCompetition ic= new InnovationCompetition();
List xynamelist=CEditConst.getAcademyNameOptions(userInfo);
List production_typelist=CEditConst.getProductionTypeOptions(userInfo);
%>

<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %>
<%@ include file="../pubpro/search-personwnd.jsp" %> --%>
<form name="form1" method="post" action="InnovationCompetitionAction.jsp?cmd=save1">

<table id="maintable" class="content-table" cellspacing="0" width="97%">
<tr height="45">
  <td class="table_topic" colspan="8" align="left">
    <table width="100%" height="30" border="0"  cellpadding="0" cellspacing="3">
      <tr height="10">
        <td width="800" rowspan="2" class="table_topic_label"> <font color="#FF3401">【添加创业竞赛作品】</font>
        </td>
        <td colspan="3" align="right"><br> <a href="innovation-competition-project-list.jsp"  >返回</a></td>
      </tr>
    </table>
  </td>
</tr>

<!-- <tr height="40">
  <td  align="right" width="25%"><font color="red">*</font>作品编码：</td>
  <td  align="left"><input type="text" name="ProductionCode" size="35" value="" maxlength="20"></td>
</tr>  -->  
<tr height="40">
  <td  align="right"><font color="red">*</font>作品名称：</td>
  <td align="left" ><input type="text" name="ProductionName" size="35" value="" maxlength="100"></td>
</tr>
<tr height="40">
  <td  align="right"><font color="red">*</font>所属项目：</td>
  <td align="left" >
       <%if(proid==-1){ %>
		<%=HtmlTool.renderSelect(projectOptions, proid +"", "ProjectName", "-1")%>
		<% }else{%>
			<%=HtmlTool.renderSelect(projectOptions, proid +"", "ProjectName", "-1",true)%>
		
		<%} %>
  </td>
</tr>
<tr height="40">
  <td  align="right"><font color="red">*</font>学院全称：</td>     
   <td align="left" > 	<%=HtmlTool.renderSelect(xynamelist,  user.getDeptId()+"", "Academy", "-1",true)%></td>
</tr>
<tr height="40">
  <td  align="right"><font color="red">*</font>申报团队名称：</td>     
  <td align="left"" ><input type="text" name="Declarer"  maxlength="45" size="35" value=""></td>
</tr>
<tr height="40">
	<td  align="right"><font color="red">*</font>作品类别：</td>
  	<td align="left"  >
    
    	<%=HtmlTool.renderSelect(production_typelist,  "", "ProductionType", "-1")%>    
  	</td>
</tr > <tr style=" display: none;" height="40">
	<td  align="right"><font color="red">*</font>申报类别：</td>
  	<td align="left" >
    个人申报  
    <input type="hidden" name="DeclarerRole" value="0">
  	</td>
</tr> 
       <input type="hidden" name="AddPerson" value="<%=user.getId()%>">
  <!--
  <tr height="40"> <td  align="right" ><font color="red">*</font>负责人：</td>
	<td align="left">
   			<p>姓名：<input type="text" name="Leader"  value=""></p>
   		
   		   
   		    <p>联系方式：<input type="text" name="LeaderId"  value=""></p>
 </tr>  		
   		</td> -->
    <input  type="hidden" id="SId" name="SId" value="" >
<tr>
	<td align="right">负责人</td>
	<td align="left" colspan="2">
<input type="text" name="Leader"  maxlength="45" size="35" value="">
	</td>
</tr>
<tr>
	<td align="right">负责人联系电话</td>
	<td align="left" colspan="2">
	<input type="text" name="LeaderId"  maxlength="45" size="35" value="">
	</td>
</tr>
<tr>

	<td align="right">团队成员:<br><a href="#" onclick="addItem();return false;">添加</a></td>
	<td align="left" >
		<table  style="width: 888px" class="content-table" id="teamtable">
			
			<tr  >
				<td width="15%" >学号</td><td width="15%" >姓名</td><td width="15%" >学院</td><td width="15%" >手机号</td><td width="15%" >职责</td><td width="15%">  操作</td>
			</tr>
	
			
		</table>
	</td>
</tr>
<tr height="40">     
  <td  align="right">备注：</td>
  <td align="left" >
  <textarea name="Remark" rows="5" cols="90"></textarea>
  </td>
</tr> 
	
<input type="hidden"  name="AddFilelist" id="AddFilelist" value="<%=ic.getAddFilelist()%>"/>
<tr id="postFormBookedBooths">
	<td class="form_label"  width="14%" >
	<div align="right">相关附件：</div>
	</td>
		<td bgcolor="#FFFFFF" colspan="3" align="left">
		<table width="100%" border="0" cellspacing="0" id="ShowFiles">
			<%
				if(ic.getId()!=-1){
					ClientAttach ca = new ClientAttach();
					//ca.setDataBase("sdtw");
					String ids = ic.getAddFilelist();
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
		<%if(ic.getId()==-1){%>
		<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
		<input type="button" value="上传" id="btn_up"  onclick="checkFileType();" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
		<%} %>
		<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    <div style="color:red">请上传doc、docx、xlsx或xls格式文件，文件最大5M</div>
	</td>
</tr>
  <tr height="45">
  <td  colspan="6" align="center">
    <input type="button" value="提交" name="btn1" onclick="form99submit()">&nbsp;&nbsp;&nbsp;
    <input type="button" value="取消" name="btn2" onclick="history.go(-1)">&nbsp;&nbsp;&nbsp;
  </td>
</tr>


<%
String filepath = "/datafile/innovation/";
String filenamecode = "";
String mytip = "（如：申请书等）";
boolean needAcademy = false;
String moduleapp = "../role-student/innovation-competition-list.jsp";
%>
<%-- <%@include file="../pubpro/fileupload-form.jsp" %> --%>


</table>

</form>
</body>
</html>