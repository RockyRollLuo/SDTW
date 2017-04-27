<%@ page contentType="text/html;charset=GBK" %>

<div id="msgdiv" style="position:absolute;width:400px; height:250px;display:none;">
<table width="400" height="250"  border="0" align="center" cellpadding="-2" cellspacing="-2">
<tr>
<td align="center">
<form name="msgform" method="post" action="#">
      <table width="100%" height="100%" bgcolor="#cccccc" border="0" align="center" cellpadding="-2" cellspacing="-2" style="border: #9CA6C6 1px solid">
          <tr height="25" align="center" valign="middle">
            <td colspan="2" background="Images/bg_login.gif"><font color="#505875">=== 留言 ===</font></td>
          </tr>
          
          <tr height="50" style="font-size: 10pt;line-height:150%;">
            <td width="17%" align="right" valign="middle">收信人：</td>
            <td align="left" valign="middle"><input name="personto" type="text" size="41" maxlength="50"></td>
          </tr>
          
          <tr height="27" >
            <td style="font-size: 10pt;line-height:150%;" align="right" valign="middle">主 &nbsp;题：</td>
            <td align="left" valign="middle"><input name="msgtitle" type="text" size="41" maxlength="50"></td>
          </tr>
          <tr>
             <td style="font-size: 10pt;" align="right" valign="top"><br>内 &nbsp;容：</td>
  			 <td align="left"><textarea rows="6" name="msgcontent" cols="40"></textarea></td>
		  </tr>
          <tr align="center" valign="top">
            <td  colspan="2">
            <input type="button" name="B1" value="发送" onClick="tosendmsg(msgform)" onKeyDown="if(event.keyCode==13) sendmsg(msgform)">&nbsp;
            <input type="button" name="B2" value="取消" onClick="javascript:msgdiv.style.display='none';">
            </td>
          </tr>
      </table>
<input type="hidden" name="personfrom" value=""> 
<input type="hidden" name="togroup" value=""> 
<input type="hidden" name="frommodulename" value=""> 
<input type="hidden" name="msgid" value=""> 
</form>
 </td>
</tr>
</table>
</div>

<!--
<a href="#" onClick="openmsgwnd(msgdiv)">用户留言</a>
-->

<script language="javascript">
function openmsgwnd(divID)
{ 
    //根据传递的参数确定显示的层
  divID.style.display='block';
	//divID.style.left=(document.body.clientWidth-240)/2;
	//divID.style.top=(document.body.clientHeight-139)/2;
       //divID.style.top=document.body.clientTop+100;

  divID.style.left=130;
  divID.style.top=70;

  //divID.style.left=(window.screen.availWidth-400)/2;
  //divID.style.top=(window.screen.availHeight-250)/2;
}

/////////////////////////////////////////////////////////////////////////////////
// 使用ajax存储，不耍新页面
// url中的参数值，有空格、中英文问号（?），可以作为参数值传递
// 但是，如果参数值中包含&符号，将被解析为一个“参数=参数值”对的结束
function tosendmsg(msgform)
{

    if (msgform.msgcontent.value == "")
    {
	    alert("留言内容不能为空！");
   	    msgform.msgcontent.focus();
	    return false;
    }

    if (msgform.msgtitle.value == "")
    {
	    alert("主题不能为空！");
   	    msgform.msgtitle.focus();
	    return false;
    }

   //修改内容的换行符
   var temp=msgform.msgcontent.value;
   msgform.msgcontent.value=temp.replace(/\r/g,"<br>");


    // 执行ajax去保存用户输入，将表单数据发送到服务端
    saveurl="../pubpro/message-editsave.jsp?personfrom=" + msgform.personfrom.value +"&personto="+ msgform.personto.value + "&msgtitle=" + msgform.msgtitle.value + "&msgcontent=" + msgform.msgcontent.value+ "&msgid=" + msgform.msgid.value +"&frommodulename="+msgform.frommodulename.value;

    // 如果是对用户组留言，msgform.togroup.value不为空，增加要传送的参数
    if (msgform.togroup.value!="")
        saveurl += "&togroup=" + msgform.togroup.value;

    savethemsg(saveurl);
    // 隐藏图层
    msgdiv.style.display='none';
}

/////////////////////////////////////////////////////////////////////////////////
// 利用Ajax，url为服务器端对应的网址
// 
var http_request = false;
function savethemsg(url) 
{
   //初始化对象并发出XMLHttpRequest请求
   http_request = false;
   if (window.XMLHttpRequest)
   {   // Mozilla或其他除IE以外的浏览器
	http_request = new XMLHttpRequest();
	if (http_request.overrideMimeType) 
       {
	   http_request.overrideMimeType("text/xml");
	}
   }
   else 
     if (window.ActiveXObject)
     {  // IE浏览器
	  try
         {
		http_request = new ActiveXObject("Msxml2.XMLHTTP");
	  } 
         catch (e)
         {
		try
              {
		    http_request = new ActiveXObject("Microsoft.XMLHTTP");
		 }
              catch (e) {}
	  }
      }
    
    if (!http_request) 
    {
	 alert("不能创建XMLHTTP实例!");
	 return false;
     }

     // 指定响应方法,指定Ajax服务端数据的输出进行处理的方法
     http_request.onreadystatechange = ReturnData;   
     // 发出HTTP请求
     http_request.open("GET", url, true);
     http_request.send(null);
}
////////////////////////////////////////////////////////////////////////////////////////
// 处理服务器返回的信息,即jsp页面的输出，
// 设置返回数据要显示的位置，通常是一个div,不能将表格中的tr定义成一个div
//
function ReturnData() 
{
   if (http_request.readyState == 4) 
   {
	if (http_request.status == 200) 
       {
	   eval(document.msgform.msgid.value).innerHTML=convert(http_request.responseText);
	} 
       else
       {
	   alert(http_request.status);
	}
    }
}

/////////////////////////////////////////////////////////////////////////////////////////
// 去除字符串中的空格
//
function trimblank(str)
{
   if (str!="")
   {
       //去除首尾空格
       //re = /(^\s*)|(\s*$)/g;
	//str=str.replace(re,"");

       //去除尾部空格
       //re = /(\s*$)/g;
	//str=str.replace(re,"");

       // 去除全部空格
	str=str.replace(/\s/g,"");
   }
   return str;
}
/////////////////////////////////////////////////////////////////////////////////////////
// 如果输入的文本保存到数据中，
//
function convert(str)
{
   if (str!="")
   {
	str=str.replace(/\r/g,"");
   }
   return str;
}
</script>
