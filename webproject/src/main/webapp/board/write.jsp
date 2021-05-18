<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<body>
<h2>글작성</h2>
<form action="insert.do" method="post">
제목 : <input type="text" name="title" ><br>
내용 : <textarea  name="content"></textarea><br>
<div>
<input type="submit" value="등록">
</div>
</form>
</body>
</html>