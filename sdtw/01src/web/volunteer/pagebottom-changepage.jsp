<%@ page language="java"  pageEncoding="utf-8"%>

<table class="content-table" id="table3">
<tr height=40>
	<th width="100%" colspan="15" align="center">
		第页&nbsp;&nbsp;&nbsp;共页&nbsp;&nbsp;&nbsp;
		
   		<a href="#" onclick="fgopage(1)">第一页</a>&nbsp;&nbsp;&nbsp;
		<a href="#" onclick="fgopage()">上一页</a>  &nbsp;&nbsp;&nbsp;
		
		<a href="#" onclick="fgopage()">下一页</a>&nbsp;&nbsp;&nbsp;
    	<a href="#" onclick="fgopage()">最后一页</a>&nbsp;&nbsp;&nbsp;
		
	</th>
</tr>
</table>

<script type="text/javascript">
function fgopage(pagenum){
	  document.mygo.page.value = pagenum;
	  document.mygo.submit();
}
</script>