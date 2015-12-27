<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet" type="text/css">
<title>動物資料瀏覽</title>
  <script type="application/javascript">

        function ready() {            
			document.getElementById("no").value = getQueryString("no");
			document.getElementById("no").value = getQueryString("no");
			document.getElementById("category").value = getQueryString("category");
        }
        
        function getQueryString(name){

           return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
           // [?|&]: ? or & 
           // ([^&;]+?): +? 表示 [^&;] 出現一次以上，而[^&;]表示除了 "&", ";" 以外的字元
           // (&|#|;|$): 表示出現"&" or "#" or ";" or "$"
           // /\+/g: /../ 中間是 Reqular expression \+ 表示 "+", g 表示所有符合 RE 的字串，此例是 "+""
           
        }
	</script>	
</head>
<body onload="ready()">
	<form:form id="form"  modelAttribute="animals">
		<table class="frame">
			<tr>
				<td>No</td>
				<td><input type="text" id="no" name="no" class="txt"
					 /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" id="category" name="category" class="txt"  /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" id="gender" name="gender" class="txt"
					 /></td>
			</tr>
		</table>
		<button type="submit" formaction="${pageContext.request.contextPath}/insert" formmethod="get">新增</button>
		<button type="submit" formaction="${pageContext.request.contextPath}/query"  formmethod="get">查詢</button>
		<button type="reset">清除</button>

		
		<table class="frame">
			<tr>
				<th></th>
				<th></th>
				<th>No</th>
				<th>Category</th>
				<th>gender</th>
				<th>Findregion</th>
			</tr>
			<c:forEach var="no" items="${no}">
				<tr>
					<c:url var="updateURL" value="update">
						<c:param name="no" value="${animals.no}" />
						<c:param name="category" value="${category}" />
						<c:param name="gender" value="${gender}" />
						<c:param name="findregion" value="${findregion}" />
					</c:url>
					<td><a href="${updateURL}"/>修改</a></td>
					<c:url var="deletionURL" value="delete">
						<c:param name="no" value="${animals.no}" />
						<c:param name="category" value="${category}" />
						<c:param name="gender" value="${gender}" />
						<c:param name="findregion" value="${findregion}" />
					</c:url>
					<td><a href="${deletionURL}"  onclick="return doDeletion()"/>刪除</a></td>
					<td>${animals.no}</td>
					<td>${animals.category}</td>
					<td>${animals.gender}</td>
					<td>${animals.findregion}</td>
				</tr>
			</c:forEach>
		</table>

		<button type="submit" formaction="${pageContext.request.contextPath}/insert" formmethod="get">新增</button>
		<button type="submit" formaction="${pageContext.request.contextPath}/query"  formmethod="get">查詢</button>
		<button type="reset">清除</button>
	</form:form>
	<script>

		function doDeletion() {
			return confirm("確定刪除嗎 ?");
		}
	</script>

</body>
</html>