<%@ page contentType="text/html;charset=GBK" %>

<div id="msgdiv" style="position:absolute;width:400px; height:250px;display:none;">
<table width="400" height="250"  border="0" align="center" cellpadding="-2" cellspacing="-2">
<tr>
<td align="center">
<form name="msgform" method="post" action="#">
      <table width="100%" height="100%" bgcolor="#cccccc" border="0" align="center" cellpadding="-2" cellspacing="-2" style="border: #9CA6C6 1px solid">
          <tr height="25" align="center" valign="middle">
            <td colspan="2" background="Images/bg_login.gif"><font color="#505875">=== ���� ===</font></td>
          </tr>
          
          <tr height="50" style="font-size: 10pt;line-height:150%;">
            <td width="17%" align="right" valign="middle">�����ˣ�</td>
            <td align="left" valign="middle"><input name="personto" type="text" size="41" maxlength="50"></td>
          </tr>
          
          <tr height="27" >
            <td style="font-size: 10pt;line-height:150%;" align="right" valign="middle">�� &nbsp;�⣺</td>
            <td align="left" valign="middle"><input name="msgtitle" type="text" size="41" maxlength="50"></td>
          </tr>
          <tr>
             <td style="font-size: 10pt;" align="right" valign="top"><br>�� &nbsp;�ݣ�</td>
  			 <td align="left"><textarea rows="6" name="msgcontent" cols="40"></textarea></td>
		  </tr>
          <tr align="center" valign="top">
            <td  colspan="2">
            <input type="button" name="B1" value="����" onClick="tosendmsg(msgform)" onKeyDown="if(event.keyCode==13) sendmsg(msgform)">&nbsp;
            <input type="button" name="B2" value="ȡ��" onClick="javascript:msgdiv.style.display='none';">
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
<a href="#" onClick="openmsgwnd(msgdiv)">�û�����</a>
-->

<script language="javascript">
function openmsgwnd(divID)
{ 
    //���ݴ��ݵĲ���ȷ����ʾ�Ĳ�
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
// ʹ��ajax�洢����ˣ��ҳ��
// url�еĲ���ֵ���пո���Ӣ���ʺţ�?����������Ϊ����ֵ����
// ���ǣ��������ֵ�а���&���ţ���������Ϊһ��������=����ֵ���ԵĽ���
function tosendmsg(msgform)
{

    if (msgform.msgcontent.value == "")
    {
	    alert("�������ݲ���Ϊ�գ�");
   	    msgform.msgcontent.focus();
	    return false;
    }

    if (msgform.msgtitle.value == "")
    {
	    alert("���ⲻ��Ϊ�գ�");
   	    msgform.msgtitle.focus();
	    return false;
    }

   //�޸����ݵĻ��з�
   var temp=msgform.msgcontent.value;
   msgform.msgcontent.value=temp.replace(/\r/g,"<br>");


    // ִ��ajaxȥ�����û����룬�������ݷ��͵������
    saveurl="../pubpro/message-editsave.jsp?personfrom=" + msgform.personfrom.value +"&personto="+ msgform.personto.value + "&msgtitle=" + msgform.msgtitle.value + "&msgcontent=" + msgform.msgcontent.value+ "&msgid=" + msgform.msgid.value +"&frommodulename="+msgform.frommodulename.value;

    // ����Ƕ��û������ԣ�msgform.togroup.value��Ϊ�գ�����Ҫ���͵Ĳ���
    if (msgform.togroup.value!="")
        saveurl += "&togroup=" + msgform.togroup.value;

    savethemsg(saveurl);
    // ����ͼ��
    msgdiv.style.display='none';
}

/////////////////////////////////////////////////////////////////////////////////
// ����Ajax��urlΪ�������˶�Ӧ����ַ
// 
var http_request = false;
function savethemsg(url) 
{
   //��ʼ�����󲢷���XMLHttpRequest����
   http_request = false;
   if (window.XMLHttpRequest)
   {   // Mozilla��������IE����������
	http_request = new XMLHttpRequest();
	if (http_request.overrideMimeType) 
       {
	   http_request.overrideMimeType("text/xml");
	}
   }
   else 
     if (window.ActiveXObject)
     {  // IE�����
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
	 alert("���ܴ���XMLHTTPʵ��!");
	 return false;
     }

     // ָ����Ӧ����,ָ��Ajax��������ݵ�������д���ķ���
     http_request.onreadystatechange = ReturnData;   
     // ����HTTP����
     http_request.open("GET", url, true);
     http_request.send(null);
}
////////////////////////////////////////////////////////////////////////////////////////
// ������������ص���Ϣ,��jspҳ��������
// ���÷�������Ҫ��ʾ��λ�ã�ͨ����һ��div,���ܽ�����е�tr�����һ��div
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
// ȥ���ַ����еĿո�
//
function trimblank(str)
{
   if (str!="")
   {
       //ȥ����β�ո�
       //re = /(^\s*)|(\s*$)/g;
	//str=str.replace(re,"");

       //ȥ��β���ո�
       //re = /(\s*$)/g;
	//str=str.replace(re,"");

       // ȥ��ȫ���ո�
	str=str.replace(/\s/g,"");
   }
   return str;
}
/////////////////////////////////////////////////////////////////////////////////////////
// ���������ı����浽�����У�
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
