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
		<style type="text/css">
			table, tr, td{
				border : 2px solid black;
			}
			#num{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<table>
			<thead>
				<tr id="sub">
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
				    <tr>
				    	<td id="num">${list.row_num}</td>
						<td id="sub"><a href="/elasticUpdateView?idx=${list.idx}">${list.subject}</a></td>
						<td>${list.content}</td>
						<td>${list.date}</td>
				    </tr>
				</c:forEach>
			</tbody>
		</table>
			<button onclick="location.href='/elasticRegistView'">글 작성</button>
			<button onclick="location.href='/'">목록 새로고침</button>
		
	</body>
</html>



