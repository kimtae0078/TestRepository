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
			#sub, #num{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h1>${option } - '${keyword }'의 검색결과</h1>
		<form action="/boardSearch" method="post">
			<select name="option">
				<option value="subject" ${option eq "subject" ? "selected":"" }>제목</option>
				<option value="content" ${option eq "content" ? "selected":"" }>내용</option>
			</select>
			<input type="text" name="keyword" placeholder="키워드 입력해주세요" >
			<input id="search" name="search" value="검색" type="submit">
		</form>
		
		<table>
			<thead>
				<tr id="sub">
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>등록일</th>
				</tr>
			</thead>
			<c:if test="${empty list}">
				<tr>
					<td colspan="3">'${keyword }'의 검색결과가 없습니다</td>
				</tr>
			</c:if>
			<tbody>
				<c:forEach items="${list}" var="list">
				    <tr>
				    	<td id="num">${list.rowNum}</td>
						<td id="sub"><a href="/solrUpdateView?idx=${list.idx}">${list.subject}</a></td>
						<td>${list.content}</td>
						<td>${list.date}</td>
				    </tr>
				</c:forEach>
			</tbody>
		</table>
			<button onclick="location.href='/solrRegistView'">글 작성</button>
			<button onclick="location.href='/'">목록 새로고침</button>
		
	</body>
</html>



