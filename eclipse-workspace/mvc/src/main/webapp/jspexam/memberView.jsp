<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.domain.MemberVO" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
</head>
<body>
<h2>회원 정보</h2>
<hr>
<%
  MemberVO vo =(MemberVO)request.getAttribute("mem");
%>
<ul>
<li>회원 이름 : <%= vo.getName() %>
<li>회원 계정 : <%= vo.getId() %>
<li>회원 암호 : <%= vo.getPwd() %>
<li>회원 전화번호 : <%= vo.getPhone() %>
</ul>
<hr>
<ul>
<li>회원 이름 : ${requestScope.mem.name} <%-- requestScope의 내장 객체를 사용 --%>
<li>회원 계정 : ${requestScope.mem.id}	<%-- name, id 등의 첫글자 소문자로 변경 get 대신  --%>
<li>회원 암호 : ${requestScope.mem.pwd} <%-- 이때 mem이 정확히 뭘까..? --%>
<li>회원 전화번호 : ${requestScope.mem.phone}
</ul>
<hr>
<ul>
<li>회원 이름 : ${mem.name}
<li>회원 계정 : ${mem.id}
<li>회원 암호 : ${mem.pwd}
<li>회원 전화번호 : ${mem.phone}
</ul>
<hr>
<a href='<%= request.getHeader("referer") %>' style='text-decoration:none'>입력폼으로</a>
</body>
</html>



