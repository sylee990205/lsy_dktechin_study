# 230424_Spring_day4
## 목차
<!-- TOC -->

- [_Spring_day4](#_spring_day4)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [웹 애플리케이션](#%EC%9B%B9-%EC%95%A0%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98)
        - [구조](#%EA%B5%AC%EC%A1%B0)
            - [티어](#%ED%8B%B0%EC%96%B4)
            - [레이어](#%EB%A0%88%EC%9D%B4%EC%96%B4)
    - [스프링 MVC 처리 흐름](#%EC%8A%A4%ED%94%84%EB%A7%81-mvc-%EC%B2%98%EB%A6%AC-%ED%9D%90%EB%A6%84)
    - [Spring MVC 구현에 사용되는 다양한 어노테이션](#spring-mvc-%EA%B5%AC%ED%98%84%EC%97%90-%EC%82%AC%EC%9A%A9%EB%90%98%EB%8A%94-%EB%8B%A4%EC%96%91%ED%95%9C-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98)
        - [@Controller](#controller)
            - [Controller 메소드의 파라미터 타입](#controller-%EB%A9%94%EC%86%8C%EB%93%9C%EC%9D%98-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0-%ED%83%80%EC%9E%85)
            - [Controller 메소드의 리턴 타입](#controller-%EB%A9%94%EC%86%8C%EB%93%9C%EC%9D%98-%EB%A6%AC%ED%84%B4-%ED%83%80%EC%9E%85)
        - [@RequestMapping](#requestmapping)
            - [상세 속성 정보](#%EC%83%81%EC%84%B8-%EC%86%8D%EC%84%B1-%EC%A0%95%EB%B3%B4)
        - [Spring의 Controller 메서드 매개변수](#spring%EC%9D%98-controller-%EB%A9%94%EC%84%9C%EB%93%9C-%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%98)
        - [@RequestParam](#requestparam)
    - [Thymeleaf](#thymeleaf)
        - [장점](#%EC%9E%A5%EC%A0%90)
        - [표현식](#%ED%91%9C%ED%98%84%EC%8B%9D)
    - [오늘의 Tip](#%EC%98%A4%EB%8A%98%EC%9D%98-tip)
        - [POJO](#pojo)
        - [웹 프로그램](#%EC%9B%B9-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8)
    - [회고](#%ED%9A%8C%EA%B3%A0)

<!-- /TOC -->
---
## 웹 애플리케이션
- 클라이언트와 서버 사이에 HTTP 프로토콜을 이용하여 데이터를 주고 받으며 동작하는 소프트웨어
![](/TIL/image/2023-04-24-09-49-57.png)
- Servlet의 Service 메소드에서 doGet이나 doPost를 작동시키고 DB와 통신
### 구조
#### 티어
  - 어플리케이션의 구조를 물리적으로 나눈것
  - 서버가 여러개
#### 레이어
  - 어플리케이션의 구조를 논리적으로 나눈것
  - 서버가 사실은 하난데 그 안에서 소프트웨어적으로 나뉨
   - 더 많이 사용됨
  - 프레젠테이션 레이어 : 컨트롤러, 뷰
  - 비즈니스 로직 레이어 : 서비스, 도메인
  - 데이터 엑세스 레이어 : DAO
  - 레이어간 의존관계를 줄여야 유지보수성이 좋은 애플리케이션이 됨
---
## 스프링 MVC 처리 흐름
- 프론트 컨트롤러 패턴을 적용함.
- 하나의 핸들러 객체를 통해서 요청을 할당하고 일관된 처리를 작성할 수 있게 하는 개발 패턴
![](/TIL/image/2023-04-24-18-11-33.png)
1. Dispatcher Servlet
   - Spring이 제공하는 FrontController
   - 스프링 FW의 중심
   - 클라이언트의 요청을 가장 먼저 받아들임
   - Controller로 요청을 전달
   - Controller가 반환한 결과값을 View에 전달해 응답
2. HandlerMapping
   - URL mapping 정보 확인
   - 클라이언트 요청 URL 처리할 컨트롤러를 결정해 DispatcherServlet에 반환
   - `@Controller` 어노테이션이 적용된 객체의 `@RequestMapping` 값을 이용해 요청을 처리할 컨트롤러 탐색
3. HandlerAdapter
   - DispatcherServlet의 처리 요청을 변환, 컨트롤러에 전달
   - 컨트롤러의 응답 결과를 DispatcherServlet이 요구하는 형식으로 변환
4. Controller
   - 실제 클라이언트의 요청을 처리하고 결과를 다양한 형태로 반환함
   - GET, POST 방식 등 전송 방식등에 대한 처리를 ANNOTATION으로 처리
   - 반드시 `@Controller`를 반드시 붙여야함
   - 상속이나 Overridng을 할 메소드가 있지는 않음  
5. ViewResolver
   - 컨트롤러의 처리 결과를 보여줄 뷰 결정
---
## Spring MVC 구현에 사용되는 다양한 어노테이션
### `@Controller`
- 등록된 클래스 파일에 대한 Bean 객체를 자동으로 생성
- 해당 어노테이션을 클래스에 지정하면 component-scan으로 자동 등록
- `@ComponentScan`
  - 프로젝트의 main 메소드가 존재하는 클래스에 @ComponentScan 어노테이션과 basePackages 로 값을 주면 component scan을 추가할 수 있음
  - 단 이때 기존의 루트도 함께 작성해야함
#### Controller 메소드의 파라미터 타입

| 파라미터 타입                                             | 설명                                                                                                                                        |
| --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |
| HttpServletRequest<br>HttpServletResponse<br> HttpSession | Servlet API                                                                                                                                 |
| java.util.Locale                                          | 현재 요청에 대한 Locale                                                                                                                     |
| InputStream, Reader                                       | 요청 컨텐츠에 직접 접근할 때 사용                                                                                                           |
| OutputStream, Writer                                      | 응답 컨텐츠를 생성할 때 사용                                                                                                                |
| @PathVariable 어노테이션 적용 파라미터                    | URI 템플릿 변수에 접근할 때 사용                                                                                                            |
| @RequestParam 어노테이션 적용 파라미터                    | HTTP 요청 파라미터를 매핑                                                                                                                   |
| @RequestHeader 어노테이션 적용 파라미터                   | HTTP 요청 헤더를 매핑                                                                                                                       |
| @CookieValue 어노테이션 적용 파라미터                     | HTTP 쿠키 매핑                                                                                                                              |
| @RequestBody 어노테이션 적용 파라미터                     | HTTP 요청의 몸체 내용에 접근할 때 사용<br> HttpMessageConverter를 이용 HTTP 요청 파라미터를 해당 타입으로 변환                              |
| Map, Model, ModelMap                                      | 뷰에 전달할 모델 데이터를 설정할 때 사용                                                                                                    |
| 커맨드 객체                                               | HTTP 요청 파라미터를 저장한 객체. 기본적으로 클래스 이름을 모델명으로 사용<br>@ModelAttribute 어노테이션을 사용하여 모델명을 설정할 수 있음 |
| Errors, BindingResult                                     | HTTP 요청 파라미터를 커맨드 객체에 저장한 결과. <br>커맨드 객체를 위한 파라미터 바로 다음에 위치                                            |
| SessionStatus                                             | 폼 처리를 완료 했음을 처리하기 위해 사용 <br> @SessionAttribute 어노테이션을 명시한 session 속성을 제거하도록 이벤트를 발생시킴             |


#### Controller 메소드의 리턴 타입

| 리턴 타입                     | 설명                                                                                                                                                                                                                    |
| ----------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ModelAndView                  | 뷰 정보 및 모델 정보를 담고 있는 ModelAndView 객체                                                                                                                                                                      |
| Model                         | 뷰에 전달할 객체 정보를 담고 있는 Model을 리턴<br>이때 뷰 이름은 요청 URL로부터 결정(RequestToViewNameTranslator를 통해 뷰 결정)                                                                                |
| Map, ModelMap                 | 뷰에 전달할 객체 정보를 담고 있는 Map 혹은 ModelMap을 리턴<br>이때 뷰이름은 요청 URL로부터 결정(RequestToViewNameTranslator를 통해 뷰 결정)                                                                     |
| String                        | 뷰 이름을 리턴                                                                                                                                                                                               |
| View                          | 객체 View 객체를 직접 리턴.<br>해당 View 객체를 이용해서 뷰를 생성                                                                                                                                                    |
| void                          | 메서드가 ServletResponse나 HttpServletResponse 타입의 파라미터를 갖는 경우 메서드가 직접 응답을 처리한다고 가정<br> 그렇지 않을 경우 요청 URL로부터 결정된 뷰를 보여줌 (RequestToViewNameTranslator를 통해 뷰 결정) |
| @ResponseBody 어노테이션 적용 | 메서드에서 @ResponseBody 어노테이션이 적용된 경우, 리턴 객체를 HTTP 응답으로 전송<br> HttpMessageConverter를 이용해서 객체를 HTTP 응답 스트림으로 변환                                                         |


### `@RequestMapping`
- URL 문자열을 클래스 또는 메서드와 매핑
- 하나의 URL 매핑 시 `@RequestMapping("/url")`을 지정
- GET 또는 POST 방식 등의 옵션을 줄 수 있음
  - 만약 안주면 둘 다 가능한 것
- 메소드 실행 후 return 페이지가 정의되어있지않으면 어노테이션에서 설정한 url로 다시 돌아감
#### 상세 속성 정보
- value: 매핑 URL 값, default 속성으로 value만 정의한다면 `value=` 생략 가능
- method: GET, POST 등의 HTTP Request method 요청 매핑을 처리할 수 있음
- 값을 정의하지 않을 경우 모든 HTTP Request method에 대해 처리

### Spring의 Controller 메서드 매개변수
- 매개변수 유무에 따라 쿼리 문자열의 필수 여부가 달라짐
- 매개변수가 있다는 것은 쿼리 문자열을 받겠다는 의미
```java
@Controller
public class QueryStringController1 {
	@RequestMapping("/querystring1")
	public ModelAndView proc(String name) {
		// name이라는 이름으로 쿼리문자열을 추출하여 처리
		// 매개변수가 오지 않을 때는 null 로 처리되어 String 타입은 error가 발생하지않음
		// 숫자일땐 null을 숫자로 변환하는 과정에서 error 발생
		ModelAndView mav = new ModelAndView();
		// ModelAndView 모델정보와 뷰 정보가 모두 들어가는 객체
		System.out.println("["+name+"]");
		mav.addObject("spring", name);
		// Spring이라는 이름으로 name을 전달함
		mav.setViewName("queryView1");
		// 확장자와 파일 경로를 제외하고 html 파일 명만 view name으로 설정
		return mav;
	}	
}
```
 
### `@RequestParam`
- 요청 파라미터(쿼리문자열)를 메서드의 매개변수로 1:1 대응해서 받음
- 쿼리문자열을 받아올 때의 이름을 지정하거나, default값을 지정할 수 있음
```java
public String getAllBoards(@RequestParam(value="currentPage", required=false,
 defaultValue="1") int currentPage,Model model){ }
```
---
## Thymeleaf
- View Template Engine
- 컨트롤러에서 데이터를 추출해 동적인 페이지를 만들 수 있음
- SSR 방식
- 일반 HTML 문서에 최상위 태그인 HTML 태그에 정해진 네임스페이스를 추가하여 사용 가능
```html
<!DOCTYPE HTML>
<HTML xmlns:th="http://www.Thymeleaf.org">
<head></head>
<body></body>
```
### 장점
- HTML 속성으로 작성되어 기존의 HTML 구조를 건드리지 않음
- Natural Template
- 서버 구동 전 순수 HTML로 구성되는 정적 페이지
- 서버 구동 후 동적 페이지 생성
- 순수 HTML을 유지하기에 내추럴 템플릿이라고도 불림
```html
<p><span th:text="${say}">Hi</span>Thymeleaf</p>
```
- 서버 없이 구동하면 웹 브라우저에 Hi Thymeleaf가 출력
  ```java
  @Controller
  @RequestMapping("/basic")
  public class ThymeleafBasicController {
  @GetMapping("/hithymeleaf")
  public String hiThymeleaf(Model model) {
  model.addAttribute("say", "안녕?");
  return "basic/hithymeleaf";
  }
  ```
  - Spring Boot 서버를 기동시킨 후 정해진 URL로 요청 시 Thymeleaf 템플릿이 서버상에서 처리됨
  - 안녕? Thymeleaf 출력
- HTML 구조를 최대한 유지한다는 예시
  ```html
  <!-- # JSP  -->
  <input type="text" name="userName" value="${user.name}">

  <!-- # Thymeleaf -->
  <input type="text" name="userName" value="unico" th:value="${user.name}">
  ```
  - jsp에서는 전달되는 user.name이 없다면 무시됨
  - thymeleaf에서는 user.name이 없다면 unico 출력

### 표현식
- `${...}` - 변수 표현식
  - `${...}`를 이용해 컨트롤러에서 전달받은 변수에 접근, th:속성명에서만 사용 가능
- `@{...}` - URL 표현식
  - 서버의 contextPath를 추가한 URI로 변경
- `th:if`
  - 만약 if 뒤의 조건이 true면 해당 태그를 실행한다는 의미
---
## 오늘의 Tip
### POJO
- Plain Old Java Object의 약어
### 웹 프로그램
- 내가 요청하는 하나만 생각하면 안됨
- 다양한 클라이언트가 다양하게 요청할 때 객체가 계속 생성되어선 안됨
- 그래서 기본이 Singleton
---
## 회고
확실히 Servlet에 비교하여 Spring이 보다 직관적이고 간편한 것은 맞는 것 같다. <br>아직 모르는게 많다는 것을 나날히 느낀다. 미니 프로젝트 회의를 하면 내가 잘 할 수 있나라는 불안함이 생기지만 그 모든 것을 배우기 위해 진행하는 과정이기에 잘 할 수 있다고 오늘도 다짐하고 열심히 노력하자
