<%@ page language="java"  pageEncoding="GBK"%>

<table class="content-table" id="table3">
<tr height=40>
	<th width="100%" colspan="15" align="center">
		��<%=pagenum %>ҳ&nbsp;&nbsp;&nbsp;��<%=pagecount %>ҳ&nbsp;&nbsp;&nbsp;
		<%if(pagenum>1){%>
   		<a href="#" onclick="fgopage(1)">��һҳ</a>&nbsp;&nbsp;&nbsp;
		<a href="#" onclick="fgopage(<%=pagenum-1%>)">��һҳ</a>  &nbsp;&nbsp;&nbsp;
		<%}if(pagenum<pagecount){%>
		<a href="#" onclick="fgopage(<%=pagenum+1%>)">��һҳ</a>&nbsp;&nbsp;&nbsp;
    	<a href="#" onclick="fgopage(<%=pagecount%>)">���һҳ</a>&nbsp;&nbsp;&nbsp;
		<%}%>
		<input type="text" name="gopage" value="0" style="height:17px;width:40px;" data-rule="digits">
		<input type="hidden" name="page" value="0" >
		<input type="submit" value="ת��" class="button" />
	</th>
</tr>
</table>

<script type="text/javascript">
function fgopage(pagenum){
	  document.mygo.page.value = pagenum;
	  document.mygo.submit();
}
</script>