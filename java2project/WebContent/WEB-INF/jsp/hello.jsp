<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Animals Data Maintenance</title>
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<h1>動物資料查詢與維護</h1>
<br/>
	<form:form id="main">
		<table class="frame">
			<tr>
				<td>No</td>
				<td><input type="text" name="no" class="txt" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category" class="txt" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender" class="txt"/></td>
			</tr>
		</table>
		<button type="submit" formaction="${pageContext.request.contextPath}/insert" formmethod="get">新增</button>
		<button type="submit" formaction="${pageContext.request.contextPath}/query" formmethod="get">查詢</button>
		<button type="reset">清除</button>
	</form:form>
</body>
</html>