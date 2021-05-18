<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.*" %>  
<%@ page import="java.util.*" %>  
<%
List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>목록</h2>
<div>
<table>
<thead>
<tr>
<th>글번호  </th>
<th>제목 </th>
<th>조회수</th>
<th>작성일</th>
</tr>
<thead>
<%if(list.size()==0){%>
	등록된 글이 없습니다<br>
<%}%>
<%for(int i=0; i<list.size();i++){ %>

<tbody>
<td><%=list.get(i).getBoardno() %> </td>
<td><a href="detail.do?boardno=<%=list.get(i).getBoardno()%>"> <%=list.get(i).getTitle() %></a></td> 
<td><%=list.get(i).getReadcnt() %></td>
 <td><%=list.get(i).getRegdate() %><br></td>
<%}%>
</tbody>
</div>
</table>
<a href="write.do">글등록</a>
</body>
</html>