<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%-- page 지시자 태그, 속성명과 속성값으로 여러가지를 설정할 수 있음--%>
    <%-- language default는 java, contentType은 필수--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 테스트</title>
</head>
<body>
<h1>첫 번째 JSP 테스트 예제</h1>
<hr>
<h3>오늘 날짜 : <%= java.time.LocalDate.now() %></h3>
<!-- 표현식 태그 내의 내용만 서버에서 진행하는 것, 나머지는 클라이언트에서 처리하고 해당 내용만 jsp -->
</body>
</html>