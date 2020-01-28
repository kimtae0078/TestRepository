<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<script src="resources/js/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="setJdbcTable" action="/siem/addScheduler" method="post">
		<p>dbms</p> : <input type="text" id="dbms" name="dbms" value=""/>
		<p>ip</p> : <input type="text" id="ip" name="ip" value=""/>
		<p>port</p> : <input type="text" id="port" name="port" value=""/>
		<p>username</p> : <input type="text" id="username" name="username" value=""/>
		<p>password</p> : <input type="text" id="password" name="password" value=""/>
		<p>table</p> : <input type="text" id="table" name="table" value=""/>
		<p>is_collect</p> : <input type="text" id="collect" name="collect" value=""/>
		<p>interval_time</p> : <input type="text" id="intervalTime" name="intervalTime" value=""/>
		<p>database_name</p> : <input type="text" id="databaseName" name="databaseName" value=""/>
		
		<button type="button" onclick="fn_tableValidation()">유효성 검사</button>
		
		<p>키등록</p>
		<p>order_col_key1</p> <input type="text" id="orderColKey1" name="orderColKey1" value=""/>
		<p>order_col_key2</p> <input type="text" id="orderColKey2" name="orderColKey2" value=""/>
		<p>uniq_col_key1</p> <input type="text" id="uniqColKey1" name="uniqColKey1" value=""/>
		<p>uniq_col_key2</p> <input type="text" id="uniqColKey2" name="uniqColKey2" value=""/>
		
		<br/><br/><br/>
		<input type="submit" value="등록">
	</form>
</body>

<script type="text/javascript">

	function fn_tableValidation(){
		$.ajax({
			type :"post",
			url :"/siem/validationCheck.ajax",
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			async: false,
			data : JSON.stringify($('#setJdbcTable').serializeObject()),
			error: function(error){
				console.log(error);
			},
			success: function(result){
				console.log("성공");
				console.log(result);
			}
		});

	}
	
	$.fn.serializeObject = function(){
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	    	var name = $.trim(this.name),
	    		value = $.trim(this.value);
	    	
	        if (o[name]) {
	            if (!o[name].push) {
	                o[name] = [o[name]];
	            }
	            o[name].push(value || '');
	        } else {
	            o[name] = value || '';
	        }
	    });
	    return o;
	};

</script>

</html>
