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
	<button type="button" class="btn btn-outline-info" onclick="location.href='list?currentPage=${currentPage}'">목록으로 이동</button>
	
	<table class="table table-bordered" style="width: 1000px; margin: 70px 50px;">
		<caption align="top"><b>내용보기</b></caption>
		<tr align="center">
			<th width="60">번호</th>
			<th width="200">제목</th>
			<th width="300">내용</th>
			<th width="250">작성일</th>
			<th width="100">조회수</th>
		</tr>
		
		<tr align="center" valign="middle">
			<td>${dto.num }</td>
			<td>${dto.subject }</td>
			<td>
				<c:if test="${dto.photo!='no' }">
					<c:forTokens var="pho" items="${dto.photo }" delims=",">
						<a href="../upload/${pho }">
							<img alt="" src="../upload/${pho }" style="width: 100px;" height="100px;">
						</a>
					</c:forTokens>
				</c:if><br>
				
				<c:if test="${dto.photo=='no' }">
						<img alt="" src="../photo/noimg.png" style="width: 100px;" height="100px;">
				</c:if>
				${dto.content }
			</td>
			<td><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/></td>
			<td>${dto.readcount }</td>
		</tr>
		
		<tr>
			<td align="right" colspan="5">
				<button class="btn btn-outline-success" onclick="location.href='writeform'">글쓰기</button>
				<button class="btn btn-outline-success" onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup }&restep=${dto.restep }&relevel=${dto.relevel }'">답글</button>
				<button class="btn btn-outline-success" onclick="location.href='updatepassform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
				<button class="btn btn-outline-success" onclick="location.href='deletepassform?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
				<button class="btn btn-outline-success" onclick="location.href='list?currentPage=${currentPage}'">목록</button>
			</td>
		</tr>
	</table>
	
</body>
</html>