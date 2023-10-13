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
</head>
<body>
	<div>
		<h2 class="alert alert-info">${count }개가 조회되었습니다</h2>
	
		
		<button type="button" class="btn btn-outline-info btn-lg" onclick="location.href='addform'">글쓰기</button>
	</div>
	
	<hr>
	
	<table class="table table-bordered" style="width: 800px;">
		<tr>
			<th width="80">번호</th>
			<th width="200">이름</th>
			<th width="160">사진</th>
			<th width="100">운전면허</th>
			<th width="260">주소</th>
			<th width="260">작성일</th>
			<th width="200">편집</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr>
				<td align="center" valign="middle">${i.count }</td>
				<td align="center" valign="middle">${dto.name }</td>
				<td align="center" valign="middle">
					<c:if test="${dto.photo!='no' }">
						<img alt="" src="../photo/${dto.photo }" width="150" height="150" class="img-circle">
					</c:if>
					
					<c:if test="${dto.photo=='no' }">
						<img alt="" src="../photo/noimge.png" width="50" height="50" class="img-circle">
					</c:if>
				</td>
				<td align="center" valign="middle">${dto.driver }</td>
				<td align="center" valign="middle">${dto.addr }</td>
				<td align="center" valign="middle">
					<fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td align="center" valign="middle">
					<button type="button" class="btn btn-warning btn-sm" onclick="location.href='uform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-danger btn-sm" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>