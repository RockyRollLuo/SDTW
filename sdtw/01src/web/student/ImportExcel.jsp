<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
	<head>
		<script src="../main/js/listfunction.js"></script>
		<jsp:include page="../main/comjs.jsp" flush="true"/>
		<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
		<script>
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
				$("#img").show();
            	var fileElement;
            	fileElement="upFile";
            	$.ajaxFileUpload
                (
                    {
                        url:"ImportExcelAction.jsp?cmd=upLoadFile",
                        secureuri:false,
                        fileElementId:fileElement,
                        dataType: "json",
                        success: function (data, status)
                        {
                       
                            if(typeof(data.error) != "undefined")
                            {
                                if(data.error != "")
                                {
                                	$.messager.alert("操作提示",data.error,"error");
                                }else
                                {
                                   // closeUp();
                                    $("#img").hide();
                                    $("#reswindow").window("open");
                                    $("#resArea").html(data.msg+"<br/>"+data.outstr);
                                    closeUp("upwindow");
                                    
                                }
                            }
                            
                        },
                        error: function (data, status, e)
                        {
                        	$.messager.alert('操作提示','上传文件失败，jsp页面请重新上传！','error');
                        }
                    }
                )
            }
            
            function dataProcess(){//上传文件
            	$.ajaxFileUpload
                (
                    {
                        url:"ImportExcelAction.jsp?cmd=dataProcess",
                        dataType: "json",
                        success: function (data, status)
                        {
							alert(data);                            
                        },
                        error: function (data, status, e)
                        {
                        	$.messager.alert('操作提示','上传文件失败，jsp页面请重新上传！','error');
                        }
                    }
                )
            }
		</script>
	</head>
	<body onload="init();">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="55" class="bt"><a href="javascript: upload();">批量导入</a></td>
		<td width="55" class="bt"><a href="javascript: dataProcess();">处理数据</a></td>
	</tr>
</table>
										

		<div id="upwindow" class="easyui-window" title="导入学生信息" collapsible="false" minimizable="false" closed="true"
        maximizable="false" icon="icon-save"  style="width: 380px; height: 200px; padding: 5px;
        background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                <tr>
                        <td>上传文件：</td>
                        <td><input id="upFile" name="upFile" type="file" class="txt01" /></td>
                </tr>
                <tr><td></td><td><font color="red">仅限xls格式的文件</font></td></tr>
                <tr id="img" style="display: none;"><td></td><td><font color="red"><img src="../main/images/loading.gif"/></font></td></tr>
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
