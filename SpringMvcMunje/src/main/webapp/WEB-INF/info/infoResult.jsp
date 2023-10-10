<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
   href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu:wght@700&family=Nanum+Pen+Script&family=Single+Day&display=swap"
   rel="stylesheet">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
   rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	#color{
		width: 20px;
		height: 20px;
		display: inline-block;
	}
</style>
</head>
<body>
	<h2 class="alert alert-info">결과출력</h2>
	<div>
		이름: ${dto.name }<br>
		좋아하는 색: <div style="background-color: ${dto.color}" id="color"></div><br>
		취미: <%-- ${dto.hobby==null?"없음":dto.hobby } --%>
			<c:if test="${empty dto.hobby }">취미없음</c:if>
			<c:if test="${!empty dto.hobby }">
				<c:forEach var="h" items="${dto.hobby }">
					[${h }]
				</c:forEach>
			</c:if>
			<br>
		가장 좋아하는 언어: ${dto.language }<br>
	</div>
</body>
</html>