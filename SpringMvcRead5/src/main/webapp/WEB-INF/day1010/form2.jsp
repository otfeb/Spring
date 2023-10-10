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
<form action="read2" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="sang" class="form-control">
				</td>
			</tr>
			
			<tr>
				<th>색상</th>
				<td>
					<input type="color" name="color" value="#ff0000">
				</td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td>
					<input type="text" name="price" class="form-control">
				</td>
			</tr>
			
			<tr>
				<th>이미지</th>
				<td>
					<select name="image" class="form-control">
						<option value="shop1">사진1</option>
						<option value="shop2">사진2</option>
						<option value="shop3">사진3</option>
						<option value="shop4">사진4</option>
						<option value="shop5">사진5</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-warning">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>