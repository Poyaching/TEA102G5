<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>

<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<table>
<form method="POST" action="<%=request.getContextPath()%>/Class_info/Class_infoServlet">
<tr bgcolor="#999999"> 
    <th width="200">課程名稱</th><th width="100">課程狀態</th><th width="100">定價</th><th width="100">付款金額</th>
    </th>
  </tr>

 <tr>
 	<td width="200"><div align="center">紅色死神spring</div></td>
	<td width="200"><div align="center">已開課</div></td>
	<td width="200"><div align="center">200</div></td>
	<td width="200"><div align="center">3000</div></td>
	<td width="120"><div align="center">      <input type="submit" name="Submit" value="放入購物車"></div></td>
</tr>


</table>
</form>
</body>
</html>