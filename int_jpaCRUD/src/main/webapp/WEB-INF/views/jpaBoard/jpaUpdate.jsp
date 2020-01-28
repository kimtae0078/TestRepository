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
		<form id="jpaUpdate" action="/update" method="post">
			<input type="hidden" id="rowNum" name="rowNum" value="${view.rowNum }">
			<input type="hidden" id="idx" name="idx" value="${view.idx }">
			<table>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="subject" name="subject" value="${view.subject }"/>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<input type="text" id="content" name="content" value="${view.content }"/>
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>
						<input type="text" value="${view.date }" readonly/>
					</td>
				</tr>
			</table>
		</form>
		<div>
			<button id="jpaUpbtn" name="jpaUpbtn" onclick="update()">수정</button>
			<button id="jpaDelbtn" name="jpaDelbtn" onclick="jpaDelete()">삭제</button>
		</div>
	<script>
		function update() {
		 	var jpaUp = confirm('정말 수정하시겠습니까?'); 
			if(jpaUp) { 
				$('#jpaUpdate').submit();
			} 	 
		} 
		
		function jpaDelete() {
			var jpaDel = confirm('정말 삭제하시겠습니까?'); 
			if(jpaDel) { 
				location.href="/jpaDelete?idx=${view.idx}";
			} 	
		}
		
		
	</script>	
	</body>
</html>