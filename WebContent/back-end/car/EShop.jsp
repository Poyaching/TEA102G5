<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<table>
		<form method="POST"
			action="<%=request.getContextPath()%>/Class_info/Class_infoServlet">
			<tr bgcolor="#999999">
				<th width="200">課程名稱</th>
				<th width="100">課程狀態</th>
				<th width="100">定價</th>
				<th width="100">付款金額</th>
				</th>
			</tr>

			<tr>
				<td width="200"><div align="center">紅色死神spring</div></td>
				<td width="200"><div align="center">已開課</div></td>
				<td width="200"><div align="center">20000</div></td>
				<td width="200"><div align="center">3000000</div></td>
				<td><input type="submit" name="Submit" value="放入購物車">
					</div></td>
			</tr>
			<input type="hidden" name="class_name" value="紅色死神spring"> <input
				type="hidden" name="class_status" value="1"> <input
				type="hidden" name="startfund_price" value="2000"> <input
				type="hidden" name="original_price" value="3000000"> <input
				type="hidden" name="action" value="ADD">
		</form>
		<form method="POST"
			action="<%=request.getContextPath()%>/Class_info/Class_infoServlet">
			<tr bgcolor="#999999">
			</tr>
			<tr>
				<td width="200"><div align="center">紅色死神spring1</div></td>
				<td width="200"><div align="center">已開課</div></td>
				<td width="200"><div align="center">2</div></td>
				<td width="200"><div align="center">3</div></td>
				<td><input type="submit" name="Submit" value="放入購物車">
					</div></td>
			</tr>
			<input type="hidden" name="class_name" value="紅色死神spring1"> <input
				type="hidden" name="class_status" value="1"> <input
				type="hidden" name="startfund_price" value="2"> <input
				type="hidden" name="original_price" value="3"> <input
				type="hidden" name="action" value="ADD">
	</table>
</body>
</html>