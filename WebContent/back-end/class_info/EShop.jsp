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
    <th width="200">�ҵ{�W��</th><th width="100">�ҵ{���A</th><th width="100">�w��</th><th width="100">�I�ڪ��B</th>
    </th>
  </tr>

 <tr>
 	<td width="200"><div align="center">���⦺��spring</div></td>
	<td width="200"><div align="center">�w�}��</div></td>
	<td width="200"><div align="center">200</div></td>
	<td width="200"><div align="center">3000</div></td>
	<td width="120"><div align="center">      <input type="submit" name="Submit" value="��J�ʪ���"></div></td>
</tr>


</table>
</form>
</body>
</html>