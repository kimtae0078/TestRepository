<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
				    <tr>
				    	<td>${list.rowNum}</td>
						<td><a href="/jpaUpdateView?idx=${list.idx}">${list.subject}</a></td>
						<td>${list.content}</td>
						<td>${list.date}</td>
				    </tr>
				</c:forEach>			
			</tbody>
		</table>
		<button onclick="location.href='/jpaRegistView'">글 등록</button>
	</body>
</html>



