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
		<form name = "/elasticRegist" id = "/elasticRegist" action="/elasticRegist" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="subject" name="subject"/>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<input type="text" id="content" name="content"/>
					</td>
				</tr>
				
			</table>
			<div>
				<input type="submit" value="등록"/>
			</div>
		</form>
		
	</body>
</html>