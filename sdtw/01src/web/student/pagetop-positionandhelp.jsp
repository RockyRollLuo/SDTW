<%@ page language="java"  pageEncoding="utf-8"%>

<table class="location-table" >
<tr height="35">
	<td class="location-title" >您的位置：<%=strposition %>
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"><%=strfunction %></span>
	</td>
</tr>
</table>

<div id="helpdiv" style="display:none;width:89%;margin:0 auto;">
<table 	class="location-help"  cellpadding="0" cellspacing="0" >
<tr height="20">
	<td align="left">系统帮助：</td>
   	<td width="30"> 
		<a align="right" href="#" onclick="showorhide_div('helpdiv')"><font face='Webdings' color='#FF0000' style='font- size:32pt'>×</font></a>
	</td>
</tr>
<tr height="20">
	<td align="left"><%=strhelpwords %></td>
</tr>
</table>
</div>

<script type="text/javascript">
function showorhide_div(menu){
    $("#"+menu).toggle();
}
</script>
