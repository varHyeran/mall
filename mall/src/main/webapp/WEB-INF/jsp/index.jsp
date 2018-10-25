<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loginMember != null}">
		${loginMember.memberId}님 반갑습니다.
		<a href="./logout">로그아웃</a>
	</c:if>
	<c:if test="${loginMember == null}">
		<a href="./login">로그인</a>
	</c:if>
</body>
</html>
