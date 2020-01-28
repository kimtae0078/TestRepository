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
			#date{
				background-color: silver;
			}
		</style>
		<script type="text/javascript">
		$(function(){
			//수정버튼
			$("#btnUpdate").click(function(){
				$("#boardform").attr("action","<c:url value='/solrUpdate' />");
				$("#boardform").submit();
			})
			//삭제버튼
			$("#btnDelete").click(function(){
				$("#boardform").attr("action","<c:url value='/solrDelete' />");
				$("#boardform").submit();
			})
		})
		</script>
	</head>
	<body>
		<div>
			<form id="boardform">
				<c:forEach items="${view}" var="view">
					<input type="hidden" id="row_num" name="row_num" value="${view.rowNum }">
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
								<input type="text" id="date" name="date" value="${view.date }" readonly/>
							</td>
						</tr>
					</table>
				</c:forEach>
			</form>
			<div>
				<button type="button" id="btnList" name="btnList" onclick="location.href='/'">목록</button>
				<button id="btnUpdate" name="btnUpdate">수정</button>
				<button id="btnDelete" name="btnDelete">삭제</button>
			</div>
		</div>
	</body>
</html>