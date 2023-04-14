# 230413 ServletJSP day3
## 목차
<!-- TOC -->

- [230413 ServletJSP day3](#230413-servletjsp-day3)
  - [목차](#목차)
  - [JSP](#jsp)
    - [JSP 태그의 종류](#jsp-태그의-종류)
      - [지시자 태그 - include](#지시자-태그---include)
    - [JSP의 내장 객체](#jsp의-내장-객체)
  - [500 error](#500-error)

<!-- /TOC -->
---
## JSP
> JSP 한마디 요약 :  Servlet의 수행상의 장점을 그대로 가져갈 수 있으면서 구현은 Servlet보다 훨씬 쉽다.
- 작성 후 최초 요청 시 Servlet으로 변경
  - Tomcat이 알아서 바꿈
  - Tomcat 내 Converter 역할을 하는 jasper가 있음
- 서버 단에서 수행할 기능이 없다면 JSP를 사용할 이유가 없음
- 요청 방식을 구분하지않음(GET, POST)
### JSP 태그의 종류
| 태그 | 이름 | 설명 |
| :----: | ---- | ---- |
| <%--      --%> | 주석문 태그 | jsp 내에 주석을 작성할 때 사용<br>jsp 주석문은 Servlet 전환 시 무시된다 |
| <%@         %> | 지시자 태그 | 서버의 초기 설정을 지정하는 용도 (`contentType 지정, import` 등)<br>errorPage 속성 : jsp가 처리되다가 실행 오류가 발생되면 errorPage 속성 내의 페이지로 대신 응답하라는 것  |
| <%          %> | 수행문 태그 | 서버 단에서 수행할 내용을 작성하는 용도<br>`가장 많이 사용됨`<br>자바의 for문 등의 연산을 해당 태그 내에서 작성해야함 |
| <%!         %> | 선언문 태그 | 멤버변수, 메서드 등을 정의하는 용도<br>JSP에서는 멤버변수나 메서드를 선언할 일이 별로 없음 => 사용 빈도 낮음 |
| <%=         %> | 표현식 태그 | java 코드를 실행하는 용도<br>Servlet 변환 시 out.print()로 변환 => _system.out.println의 argument로 딱 하나만 줄 수 있는 것을 생각하면 이해하기 쉬움!_<br>표현식 내부에는 자바의 `식`만 올 수 있음(; 사용하면 error!) |
- 선언문 태그 내에 변수를 선언하면 멤버 변수, 수행문 태그 내에 변수를 선언하면 지역변수
#### 지시자 태그 - include
```jsp
<%@  include  file="part1.jspf"  %>
```
- 확장자명을 jspf : Java Server Page Fragment, JSP의 파편, 코드의 일부분
- 해당 파일을 포함한 jsp를 포함한다는 의미
### JSP의 내장 객체
![](/TIL/image/2023-04-13-16-36-58.png)
- JSP에서는 내장 객체를 사용하여 servlet 클래스의 기능을 사용할 수 있음
```JSP
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
```
---

## 500 error
- 서버에서 기능을 처리하다가 예외가 발생했다는 의미