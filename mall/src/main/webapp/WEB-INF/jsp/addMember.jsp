<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>addMember</h2>
	<form action="<%= request.getContextPath()%>/addMember" method="post">
		<table>
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="pw"></td>
				<td><input type="submit" value="����"></td>
			</tr>
		</table>
	</form>
</body>
</html>