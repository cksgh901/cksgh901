<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> memberlist</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>memberno</th>
			<th>id</th>
			<th>name</th>
			<th>regdate</th>
		</tr>
	</thead>
	<tbody>
<c:forEach var="member" items="${ list}">
		<tr>
			<td>${member.memberno }</td>
			<td> ${member.id }</td>
			<td> ${member.name }</td>
			<td>${member.regdate }<br></td>
		</tr>
</c:forEach>
	</tbody>
</table>
</body>
</html>