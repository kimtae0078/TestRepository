<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/siem/updateScheduler" method="post">
		<input type="hidden" id="idx" name="idx" value="${jdbcVO.idx }"/>
		<input type="hidden" id="jdbcIdx" name="jdbcIdx" value="${jdbcVO.idx }"/>
		<p>dbms</p> : <input type="text" id="dbms" name="dbms" value="${jdbcVO.dbms }"/>
		<p>ip</p> : <input type="text" id="ip" name="ip" value="${jdbcVO.ip }"/>
		<p>port</p> : <input type="text" id="port" name="port" value="${jdbcVO.port }"/>
		<p>username</p> : <input type="text" id="username" name="username" value="${jdbcVO.username }"/>
		<p>password</p> : <input type="text" id="password" name="password" value="${jdbcVO.password }"/>
		<p>table</p> : <input type="text" id="table" name="table" value="${jdbcVO.table }"/>
		<p>is_collect</p> : <input type="text" id="collect" name="collect" value="${jdbcVO.collect }"/>
		<p>interval_time</p> : <input type="text" id="intervalTime" name="intervalTime" value="${jdbcVO.intervalTime }"/>
		<p>database_name</p> : <input type="text" id="databaseName" name="databaseName" value="${jdbcVO.databaseName }"/>
		<p>키등록</p>
		<p>order_col_key1</p> <input type="text" id="orderColKey1" name="orderColKey1" value="${keyVO.orderColKey1 }"/>
		<p>order_col_key2</p> <input type="text" id="orderColKey2" name="orderColKey2" value="${keyVO.orderColKey2 }"/>
		<p>uniq_col_key1</p> <input type="text" id="uniqColKey1" name="uniqColKey1" value="${keyVO.uniqColKey1 }"/>
		<p>uniq_col_key2</p> <input type="text" id="uniqColKey2" name="uniqColKey2" value="${keyVO.uniqColKey2 }"/>
		<p>이전 키 값 초기화</p> <input type="checkbox" id="keyCheckTrue" name="keyCheck" value="true"/>true <input type="checkbox" id="keyCheckFalse" name="keyCheck" value="false"/>false
		
		<br/><br/><br/>
		<input type="submit" value="수정">
	</form>
</body>
</html>