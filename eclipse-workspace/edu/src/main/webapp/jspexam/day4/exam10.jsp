<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의 내장 객체들</title>
</head>
<body>
<h2>JSP의 내장 객체들 점검</h2>
[ request ]<br>
getMethod() : <%=  request.getMethod()  %><br> <%-- 요청 방식이 무엇인지 추출 --%>
getRequestURI() : <%=  request.getRequestURI()  %><br> <%-- URI가 무엇인지 추출 --%>
getHeader("user-agent") : <%=  request.getHeader("user-agent")  %><br> <%-- user-agent client가 모바일 환경인지 체크하고 싶을 때 --%>
<%-- 외에도 request의 getParameter 등이 있음 --%>
[ application ]<br>
getContextPath() : <%=  application.getContextPath()  %><br> <%-- 하나의 웹 프로젝트 == 하나의 Context --%>
getServletContextName() : <%=  application.getServletContextName()  %><br> <%-- 프로젝트 명 --%>
getServerInfo() : <%=  application.getServerInfo()  %><br> <%-- 서버의 정보 --%>
getMajorVersion() : <%=  application.getMajorVersion()  %><br> <%--  --%>
getSessionTimeout() : <%=  application.getSessionTimeout()  %><br> <%-- 클라이언트가 마지막으로 요청하고나서 어느정도 시간이 지나면 세션객체를 자동삭제하는 시간 기본 30분 --%>
[ session ]<br> <%-- http세션 객체도 내장 객체, 세션객체의 생성 구문이 자동으로 들어감 --%>
getId() : <%=  session.getId()  %><br> <%-- 생성된 세션 객체의 id 추출 --%>
getCreationTime() : <%=  new Date(session.getCreationTime())  %><br> <%-- 세션객체의 생성 시간 --%>
[ response ]<br>
getStatus() : <%=  response.getStatus() %><br> <%-- 현재 상태 --%>
getBufferSize() : <%=  response.getBufferSize() %><br> <%-- client가 사용하는 기본적인 내장 객체의 사이즈 8kb --%>
getContentType() : <%=  response.getContentType() %> 
<H4>Web Application(/edu) 디렉토리의 파일 리스트 </H4>
<% 
java.util.Set<String> list = application.getResourcePaths("/");
if (list != null) {
   Object obj[] = list.toArray();
   for(int i=0; i < obj.length; i++) {
      out.print(obj[i]+", ");
   }
}
%>
</body>
</html>