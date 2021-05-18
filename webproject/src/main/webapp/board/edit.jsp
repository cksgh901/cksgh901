<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.*" %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
<h2>글 수정</h2>
<form action="update.do" method="post">
제목 : <input type="text" name="title" value="${vo.title }"><br>
내용 : <textarea  name="content">${vo.content }</textarea><br>
<input type="hidden" name="boardno" value="${vo.boardno }">
<div>
<input type="submit" value="수정">
</div>
</form>
</body>
</html>