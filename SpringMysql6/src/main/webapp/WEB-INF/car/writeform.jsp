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
	<div style="margin: 100px 50px">
		<form action="write" method="post">
			<table class="table table-bordered" style="width: 350px;">
				<tr>
					<th>자동차명</th>
					<td>
						<input type="text" name="carname" required="required" class="form-control">
					</td>
				</tr>
				
				<tr>
					<th>자동차가격</th>
					<td>
						<input type="text" name="carprice" required="required" class="form-control">
					</td>
				</tr>
				
				<tr>
					<th>자동차색상</th>
					<td>
						<input type="color" name="carcolor" required="required" class="form-control">
					</td>
				</tr>
				
				<tr>
					<th>구입일</th>
					<td>
						<input type="date" name="carguip" required="required" class="form-control">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-info">DB저장</button>
						<button type="button" class="btn btn-success" onclick="location.href='list'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>