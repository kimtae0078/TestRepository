<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		table, th, td{
			border: 1px solid black;
		} 	
	</style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Idx</th>
				<th>date</th>
				<th>dbms</th>
				<th>ip</th>
				<th>port</th>
				<th>username</th>
				<th>password</th>
				<th>table</th>
				<th>isCollect</th>
				<th>intervalTime</th>
				<th>databaseName</th>
				<th>삭제</th>
				<th>수정</th>
			</tr>
		</thead>
		<!-- Table Header -->
		<tbody>
			<c:forEach var="jdbcList" items="${jdbcList}">
				<tr>
					<td>${jdbcList.idx}</td>
					<td>${jdbcList.date}</td>
					<td>${jdbcList.dbms}</td>
					<td>${jdbcList.ip}</td>
					<td>${jdbcList.port}</td>
					<td>${jdbcList.username}</td>
					<td>${jdbcList.password}</td>
					<td>${jdbcList.table}</td>
					<td>${jdbcList.collect}</td>
					<td>${jdbcList.intervalTime}</td>
					<td>${jdbcList.databaseName}</td>
					<td><a href="/siem/deleteScheduler?idx=${jdbcList.idx}">삭제</a></td>
					<td><a href="/siem/updateSchedulerPage?idx=${jdbcList.idx}">수정</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/siem/addSchedulerPage">등록</a>

</body>
</html>
