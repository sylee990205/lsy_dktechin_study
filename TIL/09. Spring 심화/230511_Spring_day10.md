# 230511_Spring_day10
## 목차
<!-- TOC -->

- [_Spring_day10](#_spring_day10)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [Spring SchedulingTASK](#spring-schedulingtask)
        - [Task 기능의 메서드 정의](#task-%EA%B8%B0%EB%8A%A5%EC%9D%98-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%A0%95%EC%9D%98)
    - [필터와 인터셉터](#%ED%95%84%ED%84%B0%EC%99%80-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0)
        - [필터](#%ED%95%84%ED%84%B0)
            - [필터의 메소드](#%ED%95%84%ED%84%B0%EC%9D%98-%EB%A9%94%EC%86%8C%EB%93%9C)
        - [인터셉터Interceptor](#%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0interceptor)
            - [인터셉터의 메서드](#%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%9D%98-%EB%A9%94%EC%84%9C%EB%93%9C)
        - [Filter vs Interceptor](#filter-vs-interceptor)
    - [오류처리](#%EC%98%A4%EB%A5%98%EC%B2%98%EB%A6%AC)
    - [웹 소켓 프로그래밍](#%EC%9B%B9-%EC%86%8C%EC%BC%93-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)
        - [웹 소켓의 통신 방식](#%EC%9B%B9-%EC%86%8C%EC%BC%93%EC%9D%98-%ED%86%B5%EC%8B%A0-%EB%B0%A9%EC%8B%9D)
        - [웹 소켓의 동작 방식](#%EC%9B%B9-%EC%86%8C%EC%BC%93%EC%9D%98-%EB%8F%99%EC%9E%91-%EB%B0%A9%EC%8B%9D)
        - [웹 소켓 통신의 구현](#%EC%9B%B9-%EC%86%8C%EC%BC%93-%ED%86%B5%EC%8B%A0%EC%9D%98-%EA%B5%AC%ED%98%84)
        - [웹 소켓 서버 구현](#%EC%9B%B9-%EC%86%8C%EC%BC%93-%EC%84%9C%EB%B2%84-%EA%B5%AC%ED%98%84)
            - [웹 소켓에 관한 환경 설정 파일](#%EC%9B%B9-%EC%86%8C%EC%BC%93%EC%97%90-%EA%B4%80%ED%95%9C-%ED%99%98%EA%B2%BD-%EC%84%A4%EC%A0%95-%ED%8C%8C%EC%9D%BC)

<!-- /TOC -->
---
## Spring Scheduling(TASK)
- 스프링에서는 **특정 시간에 반복적으로 처리**되는 코드를 스케줄링 할 수 있음
- 이 때 반복적으로 수행되는 코드를 **Task**라고 함
### Task 기능의 메서드 정의
- 설정된 주기에 맞춰서 호출되는 Task 메서드 앞에 `@Scheduled` 라는 어노테이션을 다음에 제시한 속성 중 하나를 정의하여 추가
- cron : (cron = "10 30 12 * * 5") 초, 분, 시, 일, 월, 요일(0:일요일) 
  - `*` : 모든
- fixedDelay : 이전에 실행된 **Task의 종료 시간으로부터** 정의된 시간만큼 지난 후 Task를 실행
- fixedRate: 이전에 실행된 **Task의 시작시간으로부터** 정의된 시간만큼 지난 후 실행
  
---

## 필터와 인터셉터
- 공통적인 여러 작업을 대신 처리하며 개발 시 중복된 코드를 제거할 수 있도록 지원하는 기능
### 필터
- DispatcherServlet에 요청이 전달되기 전/후에 url 패턴에 맞는 모든 요청에 대해 부가작업을 처리할 수 있는 기능 제공
- 스프링 범위 밖에서 처리 (웹 컨테이너에 의해 관리)
  - DispatcherServlet이 스프링의 가장 앞단
  - 필터는 Servlet에 요청 전달 전에 처리하는 기능이기 때문
![](/TIL/image/2023-05-11-10-43-41.png)
#### 필터의 메소드
- 필터를 추가하기 위해서는 javax.servlet의 Filter 인터페이스를 구현해야함
```java
public interface Filter {
 public default void init(FilterConfig filterConfig) throws ServletException {}
 public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {}
 public default void destroy() {}
}
```
- init과 destroy 메소드는 `default`가 붙어 꼭 오버라이딩하지않아도됨
- `init`
  - 필터 객체 초기화 및 서비스에 추가하기 위한 메소드
- `doFilter`
  - url-pattern에 맞는 모든 HTTP 요청이 DispatcherServlet으로 전달되기 전에 웹 컨테이너에 의해 실행되는 메서드
- `destroy`
  - 필터 객체를 서비스에서 제거하고 사용하는 자원을 반환하기 위한 메소드


### 인터셉터(Interceptor)
- Spring이 제공하는 기술
- DispatcherServlet이 컨트롤러를 호출하기 전과 후에 요청과 응답을 참조하거나 가공할 수 있는 기능을 제공
- 스프링 컨텍스트에서 동작
- DispatcherServlet은 핸들러 매핑을 통해 적절한 컨트롤러를 찾도록 요청
  - 결과로 실행 체인을 리턴
- 실행 체인
  - 1개 이상의 인터셉터가 등록되어 있다면 순차적으로 인터셉터들을 거쳐 컨트롤러가 실행
  - 인터셉트가 없다면 바로 컨트롤러 실행
 - 인터셉터는 스프링 컨테이너 내에서 동작하므로 필터 -> DispatcherServlet이 요청을 받은 이후 동작
![](/TIL/image/2023-05-11-11-16-27.png)


#### 인터셉터의 메서드
- 인터셉터를 추가하려면 org.springframework.web.servlet의 HandlerInterceptor 인터페이스를
구현해야함
```java
public interface HandlerInterceptor {
  default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 return true;
 }
  default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
 }
  default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
 }
}
```
- `preHandle()`
  - 컨트롤러 호출되기 전에 실행
  - 컨트롤러 이전에 처리해야하는 전처리 작업이나 요청 정보를 가공, 추가하는 경우 사용
  - `Object handler` 핸들러 매핑이 찾아준 컨트롤러 빈에 매핑되는 HandlerMethod라는 새로운 타입의 객체
  - 반환값이 true면 다음 단계로 진행
  - false면 작업을 중단하여 이후의 작업이 진행되지않음
- `postHandel()`
  - 컨트롤러가 호출된 후에 실행
  - 컨트롤러 이후에 처리해야하는 후처리 작업이 있을때 사용
  - 컨트롤러 하위 계층에서 작업을 진행하다가 중간에 예외가 발생하면 postHandle이 호출되지않음
- `afterCompletion()`
  - 모든 뷰에서 최종 결과를 생성하는 일을 포함해 모든 작업이 완료된 후 실행
  - 사용한 리소스를 반환할 때 사용
  - 하위 계층에서 작업을 진행하다가 중간에 예외가 발생하더라도 반드시 호출
### Filter vs Interceptor
| Filter                                                                           | Interceptor                                                                                          |
| -------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| J2EE 표준 스펙                                                                   | Spring이 제공하는 기술                                                                               |
| Dispatcher Servlet에 요청이 전달되기 전과 후 <br>Spring 밖에서 동작(웹 컨테이너) | Dispatcher Servelt이 컨트롤러를 호출하기 전과 후<br>Controller 안에서 동작(스프링 컨텍스트에서 동작) |
| 서블릿 컨테이너에서 관리                                                         | 스프링 컨테이너에서 관리                                                                             |
| 스프링 예외 처리 X                                                               | 스프링 예외 처리 O                                                                                   |
| Request, Response 객체 조작 가능                                                 | Request, Response 객체 조작 불가능                                                                   |


---
## 오류처리
`@ExceiptionHandler`와 `@ControllerAdvice`
- `@ExceiptionHandler`
  - 스프링 MVC에서 에러와 예외를 처리하기위해 제공하는 방법
  - Controller에서 정의한 메소드에서 예외가 발생하면 자동으로 받아냄
  - 발생된 예외를 View단으로 보내서 처리
  - 지역적인 방법 
    - 지역적인 방법이 우선 순위가 더 높음
- `@ControllerAdvice`
  - @Controller나 @RestController에서 발생하는 예외 등을 catch
  - 클래스 위에 `@ControllerAdvice`를 붙이고 어떤 예외를 잡아낼 것인지 내부 메소드 선언
  - 메소드 상단에 `@ExceptionHandler(예외클래스명.css)`
  - 전역적인 방법
---
## 웹 소켓 프로그래밍
- HTML5 표준 기술
- HTTP 환경에서 클라이언트와 서버 사이에 하나의 TCP 연결을 통해 실시간으로 전이중 통신을 가능하게 하는 프로토콜
  - 전이중통신: 일방적인 송신, 수신만이 가능한 단방향 통신과 달리 양방향으로 송신과 수신이 가능한 것
### 웹 소켓의 통신 방식
- 웹 소켓은 연속적인 데이터 전송의 신뢰성을 보장하기 위해 Handshake 과정을 진행
- TCP layer에서 Handshake를 통해 연결을 수립하지 않고 HTTP 요청 기반으로 Handshake 과정을 거쳐 연결을 수립
### 웹 소켓의 동작 방식
![](/TIL/image/2023-05-11-17-37-08.png)
### 웹 소켓 통신의 구현
- 서버 연결
  - HTML5가 제공하는 WebSocket 객체를 통해 서버 연결 수행
  ```js
  let ws = new WebScoket("웹 소켓 URL 문자열");
  // 웹 소켓 URL 문자열 : ws://서버주소.웹 소켓 서버 프로그램의 매핑명
  ```
- 데이터 송신
  - WebSocket 객체의 send() 메서드로 데이터를 서버로 송신 
  ```java
  ws.send("전송하려는 메시지");
  ```
- 데이터 수신
  ```js
  ws.onmessage = function(e) {
    e.data로 추출하여 수신받은 메시지 처리
  }
  ```
- 웹 소켓 관련 이벤트
  - open : 서버와 접속이 일어나면 발생하는 이벤트
  - close : 서버와 접속이 해제되면 발생되는 이벤트
  - message : 웹 소켓 서버로부터 메시지가 수신되면 발생되는 이벤트
  - error : 웹 소켓 오류가 생기면 발생되는 이벤트
### 웹 소켓 서버 구현
- WebSocket을 사용하기 위한 `@ServerEndpoint` 어노테이션이 선언되어 있는 클래스와 `웹 소켓에 관련된 환경 설정 파일`로 구현
#### 웹 소켓에 관한 환경 설정 파일
- @ServerEndpoint 클래스는 WebSocket이 생성될 때마다 인스턴스가 생성되고 관리됨
  - @Autowired가 설정된 멤버들이 초기화 되지 않음
- 웹 소켓 접속이 요청될 때 마다 @ServerEndpoint 클래스의 객체를 생성해줄 초기화 클래스의 빈 등록이 필요