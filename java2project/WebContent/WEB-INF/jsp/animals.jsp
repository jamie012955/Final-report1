<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet" type="text/css">
</head>
<body>
		<table class="frame">	
			<form:input type="hidden" name="" path="no" />
			<tr>
				<td>*No</td>
				<td><form:input type="text" path="no"/></td>
			</tr>
			<tr>
				<td>*Category</td>
				<td><form:input type="text" path="category"/></td>
			</tr>
			<tr>
				<td>*Gender</td>
				<td><form:input type="text" name="gender" class="txt" path="gender"/></td>
			</tr>
			<tr>
				<td>*findregion</td>
				<td><form:input type="text" name="findregion" class="txt" path="findregion"/></td>
			</tr>
			<tr>
				<td>*age</td>
				<td><form:input type="text" name="age" class="txt" path="age"/></td>
			</tr>
			<tr>
				<td>color</td>
				<td><form:input type="text" name="color" class="txt" path="color"/></td>
			</tr>
			<tr>
				<td>address</td>
				<td><form:input type="text" name="addres" class="txt" path="addres"/></td>
			</tr>
		</table>
</body>
</html>