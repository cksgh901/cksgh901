<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글상세</h2>
글번호:${vo.boardno }
제목:${vo.title }
조회수:${vo.readcnt }<br>
내용:${vo.content }<br>
등록일${vo.regdate }
<a href="edit.do?boardno=${vo.boardno }">수정</a>
<a href="delete.do?boardno=${vo.boardno }">삭제</a>
</body>
</html>