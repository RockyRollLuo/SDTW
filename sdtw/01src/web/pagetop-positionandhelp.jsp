<%@ page language="java"  pageEncoding="GBK"%>

<table class="location-table">
<tr height="35">
	<td class="location-title" >����λ�ã�
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<div id="helpdiv" style="display:none;">
<table 	class="location-help" width="100%" cellpadding="0" cellspacing="0" >
<tr height="20">
	<td align="left">ϵͳ������</td>
   	<td width="30"> 
		<a align="right" href="#" onclick="showorhide_div('helpdiv')"><font face='Webdings' color='#FF0000' style='font- size:32pt'>r</font></a>
	</td>
</tr>
<tr height="20">
	<td align="left"></td>
</tr>
</table>
</div>

<script type="text/javascript">
function showorhide_div(menu){
    $("#"+menu).toggle();
}
</script>
