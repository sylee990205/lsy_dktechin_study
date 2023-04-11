# 230411 ServletJSP
## 목차
<!-- TOC -->

- [ServletJSP](#servletjsp)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [웹 프로그래밍](#%EC%9B%B9-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)
        - [웹의 처리 구조](#%EC%9B%B9%EC%9D%98-%EC%B2%98%EB%A6%AC-%EA%B5%AC%EC%A1%B0)
            - [HTTP에서 지원되는 요청 방식](#http%EC%97%90%EC%84%9C-%EC%A7%80%EC%9B%90%EB%90%98%EB%8A%94-%EC%9A%94%EC%B2%AD-%EB%B0%A9%EC%8B%9D)
            - [HTTP 동작 방식](#http-%EB%8F%99%EC%9E%91-%EB%B0%A9%EC%8B%9D)
        - [Java EE 기반의 웹 어플리케이션](#java-ee-%EA%B8%B0%EB%B0%98%EC%9D%98-%EC%9B%B9-%EC%96%B4%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98)
            - [Servlet](#servlet)
            - [JSP](#jsp)
    - [Servlet 프로그래밍](#servlet-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)
        - [구현 방법](#%EA%B5%AC%ED%98%84-%EB%B0%A9%EB%B2%95)
        - [Servlet 등록과 매핑](#servlet-%EB%93%B1%EB%A1%9D%EA%B3%BC-%EB%A7%A4%ED%95%91)
        - [요청 및 응답 객체 생성](#%EC%9A%94%EC%B2%AD-%EB%B0%8F-%EC%9D%91%EB%8B%B5-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1)
        - [Servlet 객체 생성과 객체 해제](#servlet-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1%EA%B3%BC-%EA%B0%9D%EC%B2%B4-%ED%95%B4%EC%A0%9C)
        - [Servlet 실행](#servlet-%EC%8B%A4%ED%96%89)
            - [FORM 태그](#form-%ED%83%9C%EA%B7%B8)
        - [Query 문자열](#query-%EB%AC%B8%EC%9E%90%EC%97%B4)
            - [추출](#%EC%B6%94%EC%B6%9C)
        - [요청 재지정](#%EC%9A%94%EC%B2%AD-%EC%9E%AC%EC%A7%80%EC%A0%95)
            - [Forward](#forward)
            - [Redirect](#redirect)

<!-- /TOC -->
---
## 웹 프로그래밍
### 웹의 처리 구조
- 웹 통신에 사용되는 표준 통신 프로토콜 `HTTP(HyperText Transfer Protocol)`
- HTTP는 웹 클라이언트와 웹 서버 사이에 이루어지는 요청과 응답(request/response)에 대한 프로토콜
- 웹 브라우저가 HTTP를 통하여 서버로부터 웹페이지 정보를 요청 -> 서버는 요청에 응답하여 필요한 정보를 해당 사용자에게 전달
- HTTP 프로토콜은 `Connection Oriented와 Stateless` 방식으로 동작하는 프로토콜
- 신뢰성 있는 통신을 하면서도 처리 효율이라는 부분을 강조
- 인터넷 환경에 가장 적합한 통신구조로 인정

#### HTTP에서 지원되는 요청 방식
| 요청방식 | 설명 |
| ---------- | ---- |
| GET | URI에 지정된 파일을 얻고자 할 때 사용되는 요청 방식, Default 방식<br>name=value로 구성되는 간단한 데이터(Query 문자열)를 URI 뒤에 추가하여 전달<br>요청하고자 하는 경우에도 사용
| POST | 원하는 방식으로 인코딩 된 데이터를 요청 바디에 포함하여 전송하면서 파일을 요청하고자 하는 경우 사용<br>Query 문자열 전달시의 GET 방식을 보완한 요청 방식<br>비밀번호 등은 반드시 POST로 전달

#### HTTP 동작 방식
1. 클라이언트가 서버에 연결
2. 클라이언트가 서버로 HTTP 요청(Request)을 보냄.
   - 이 때의 HTTP 요청은 요청 헤더 (Request Header)라고 하는 요청에 관련된 정보를 함께 전송.
   - 몇몇 정보는 요청 바디(Request Body)에 넣는 경우도 있음 
3. 서버가 클라이언트에게 HTTP 응답(Response)을 보냄. 
   - 응답과 관련된 정보는 응답 헤더(Response Header)에 들어 있음
   - 서버가 보내준 데이터는 응답 바디(Response Body)에 들어 있음
![](/TIL/image/2023-04-11-11-19-31.png)

### Java EE 기반의 웹 어플리케이션
- Servlet과 JSP는 Java의 Enterprise Edition에 속하는 웹 어플리케이션 기술
- 웹 클라이언트의 요청에 의해 웹 서버에서 수행, 그 수행 결과가 클라이언트에 응답
- Java EE 환경에서 Servlet과 JSP는 웹 컨테이너(엔진)에 의해 관리, 수행되는 웹 컴포넌트
- 여러 웹 컴포넌트 -> 하나의 웹 어플리케이션 구성
![](/TIL/image/2023-04-11-11-24-53.png)
#### Servlet 
- Servlet 기술은 프로그래밍 성격이 강함
- Servlet은 상속 구문과 메서드 오버라이딩 구문을 적용한 Java로 구현된 프로그램
- 수행 결과를 HTML로 응답하도록 구현하는 기술  
![](/TIL/image/2023-04-11-11-23-19.png)
#### JSP 
- JSP는 프리젠테이션 성격이 강함
- JSP는 HTML 문서 안에 JSP 태그와 동적인 처리를 담당하는 Java 코드를 삽입하여 구현  
![](/TIL/image/2023-04-11-11-23-32.png)

---
## Servlet 프로그래밍
- Java를 사용하여 웹 페이지를 동적으로 생성하는 서버 측 프로그램으로서 Java EE 사양의 일부분
- 이전 CGI라는 요청이 있을 때 마다 새로운 프로세스가 생성되어 응답하는 기술
- Java Servlet 
  - 프로세스보다 가벼운 스레드 기반으로 응답
  - 가볍게 클라이언트 요청 처리 가능
  - Java로 구현되어 다양한 플랫폼에서 동작 가능
  - Servlet 객체는 수행이 종료되어 응답된 후에도 객체 상태를 계속 유지
  - 다음 요청에 대하여 바로 수행될 수 있는 상태 유지
  - 하나의 Servlet을 여러 클라이언트가 동시 요청 시 하나의 Servlet 객체를 공유하여 다중 스레드 기반에서 처리 --> 응답 성능 향상

### 구현 방법
- Servlet은 HttpServlet이라는 클래스를 상속하여 구현
- 어떤 요청 방식을 지원하는 Servlet인가에 따라 doGet() 또는 doPost() 메서드를 오버라이딩하여 구현
![](/TIL/image/2023-04-11-12-38-09.png)
- 컴파일 시 Tomcat 서버에서 reload 수행
![](/TIL/image/2023-04-11-12-11-44.png)
- 잘못된 MIME type 전달 시 브라우저는 제대로 처리할 수 없음

### Servlet 등록과 매핑
- Servlet 클래스는 서버에서 Servlet 프로그램으로 인식되어 처리되도록 등록과 매핑이라는 설정을 web.xml에 작성했어야함
- Servlet 3.0부터 Annotation으로 대체
  
| Annotation | 기능 |
| ---------- | ---- |
| @WebServlet | Servlet 프로그램 등록과 매핑을 정의 |
| @WebInitParam | Servlet 프로그램에 전달할 초기 파라미터를 정의 | 
| @WebListener | 리스너를 정의 |
| @WebFilter | 필터를 정의 |
| @MultipartConfig |  Servlet 프로그램에서 다중 파티션으로 전달되는 파일 업로드를 처리할 수 있음을 정의 | 

### 요청 및 응답 객체 생성
- 웹 클라이언트로부터 Servlet 수행 요청이 전달되면, Servlet 컨테이너는 클라이언트로부터 전달된 요청 정보를 가지고 `HttpServletRequest` 객체와 `HttpServletResponse` 객체를 생성하여 Servlet의 doGet() 또는 doPost() 메소드 호출 시 아규먼트로 전달
```java
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet 실행.....");
		//ContentType을 지정, 생략 시 html 태그는 html 태그로 처리되나 charset은 utf-8이 아님. 한글이 깨짐
		response.setContentType("text/html; charset=utf-8");
		//getWriter로 사용자에게 전달 가능
		PrintWriter out = response.getWriter(); 
		out.print("<h1>안녕? Servlet!</h1>");
		out.close();
	}
}
```
- HttpServletRequest 객체
  - 클라이언트에서 전달되는 다양한 요청 정보를 Servlet에 전달하는 기능으로 사용
  - 웹 클라이언트에서 전송되는 요청 정보 추출
    ![](/TIL/image/2023-04-11-14-08-02.png)
- HttpServletResponse 객체
  - 클라이언트로의 응답에 사용되는 객체 
  ![](/TIL/image/2023-04-11-14-08-12.png)

### Servlet 객체 생성과 객체 해제
- HttpServletRequest 와 HttpServletResponse 객체를 생성한 후 Servlet 컨테이너는 요청된 Servlet의 객체가 생성된 상태인지 검사
- Servlet 객체가 생성되어 있는 상태라면 바로 수행
- 객체가 생성되어 있지 않으면 Servlet의 클래스 파일을 찾아서 로딩한 후 객체를 생성하여 수행
- Servlet 객체는 서버 정료 시 까지 또는 웹 어플리케이션이 자동 리로드 될 때까지 객체 상태를 계속 유지
```java
@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int local_v = 0;
		member_v++;
		local_v++;
		out.print("<h2>member_v(멤버변수) : " + member_v + "</h2>");
		out.print("<h2>local_v(지역변수) : " + local_v + "</h2>");
		out.close();
	}
}
```
![](/TIL/image/2023-04-11-12-29-57.png)
- memver 변수의 값은 계속 증가하고 local 변수의 값은 항상 1로 고정됨을 확인할 수 있음

### Servlet 실행
- Servlet은 HttpServlet 클래스를 상속받아 어떠한 요청 방식을 지원하는 Servlet인가에 따라 doGet(), doPost() 메소드를 재정의하여 구현
- Servlet이 요청된 방식에 따라 각 메소드가 Servlet 컨테이너에 의해 호출되어 Servlet의 기능을 처리
- 하이퍼링크 텍스트(`<a>`태그)를 클릭하여 요청 -> GET
- URL을 주소 필드에 입력하여 직접 요청 -> GET
- `<IMG>`태그로 요청 -> GET
- `<FORM>`태그로 요청 -> method 속성의 값에 따라 GET 또는 POST
- `<IFRAME>`태그로 요청 -> GET 방식

#### FORM 태그
- HTML 문서에서 사용자의 입력을 서버로 전달하는 기능 `<FORM>`태그를 이용해 구현
  - action : 사용자의 입력 데이터를 처리할 `CGI 프로그램의 URL` 주소
  - method : 사용자 데이터를 넘겨주는 방식을 지정, `GET과 POST`
    - GET: 입력 내용을 요청 URL 뒤에 붙여서 전송
    - POST: 입력 내용을 요청 바디에 담아서 전송
  - enctype: 서버로 보내지는 데이터의 형식을 지정
    - application/x-www-form-urlencoded : 디폴트값, 서버로 전송되기전에 url-encode 된다는 뜻
    - multipart/form-data : 파일 받으면서 설정해준 값, 이미지나 파일을 서버로 전송하는 경우 사용
    - text/plain : 인코딩하지않은 문자 그대로의 상태를 전송
- 웹 브라우저 화면에 사용자 정보 입력 형식을 표시할 때 `<input>`, `<textarea>`, `<select>`태그 이용
  
### Query 문자열
- 웹 클라이언트에서 웹 서버에 요청을 보낼 때 추가로 전달하는 name과 value로 구성되는 문자열
- `요청 파라미터`라고도 함
- 전달 방식은 GET, POST가 있음
```
name1=value1&name2=value2&name3=value3
```
- GET 방식
  - 전달되는 Query 문자열 길이에 제한이 있음
  - 내용이 브라우저의 주소 필드에 보여짐
  - `<Form>` 태그를 사용해도 되고 요청 URL에 ? 기호와 함께 직접 Query 문자열을 붙여 전달도 가능
- POST 방식
  - 전달되는 Query 문자열 길이에 제한이 없음
  - 내용이 브라우저의 주소 필드에 보이지않음
  - 전달 내용이 요청 바디에 담겨져서 전달
  - `<Form>`태그를 사용하여 요청할 때만 사용 가능

#### 추출
- name으로 하나의 value 값이 전달될 때
  - String address = re
- name으로 여러개의  value 값들이 전달될 때

### 요청 재지정
- 클라이언트에서 요청한 페이지 대신 다른 페이지를 클라이언트가 보게 되는 기능
- redirect 방법과 forward 방법으로 나뉨
- redirect : HttpServletResponse의 sendRedirect() 메서드를 사용
- forward: RequestDispatcher의 forward() 메서드를 사용
#### Forward
![](/TIL/image/2023-04-11-17-38-53.png)
- 동일한 요청상에서 다른 자원에 요청을 넘겨서 대신 응답하게 함
- 동일한 서버의 동일 웹 어플리케이션에 존재하는 대상만 가능
  - context path를 무조건 부여하는 방법을 사용함
- 브라우저의 주소필드의 URL 이 바뀌지 않음
- 두 자원이 HttpServletRequest 객체 공유

#### Redirect
![](/TIL/image/2023-04-11-17-39-01.png)
- 다른 자원을 다시 요청하여 응답하게 함
- Web 상의 모든 페이지로 요청재지정 가능
- 브라우저의 주소필드의 URL 이 바뀜
- 재지정 대상에 대한 요청 자체를 브라우저가 하게 됨
- 두 자원이 HttpServletRequest 객체를 공유하지 않음