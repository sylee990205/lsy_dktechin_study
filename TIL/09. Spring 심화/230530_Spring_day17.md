# 230530_Spring_day17
## 목차
<!-- TOC -->

- [230530\_Spring\_day17](#230530_spring_day17)
  - [목차](#목차)
  - [Spring SECURITY](#spring-security)
    - [securityConfig](#securityconfig)
    - [기본적인 formLogin 인증 API 구조](#기본적인-formlogin-인증-api-구조)
  - [Login Form 인증 절차](#login-form-인증-절차)
      - [Spring 에서 제공하는 암호화](#spring-에서-제공하는-암호화)
  - [Cookie / Session / Token 인증 방식](#cookie--session--token-인증-방식)
    - [Cookie](#cookie)
      - [단점](#단점)
    - [Session](#session)
      - [단점](#단점-1)
    - [Token](#token)
  - [JWT (JSON Web Token)](#jwt-json-web-token)
    - [JWT의 형식](#jwt의-형식)
    - [인증 타입(알고리즘)](#인증-타입알고리즘)

<!-- /TOC -->
---
> 이 파트에서 가장 중요한 개념은 가장 중요한 개념은 **filter** 다.
## Spring SECURITY
- Spring 기반의 어플리케이션 보안을 담당하는 스프링 하위 프레임워크
![](/TIL/image/2023-05-29-16-16-21.png)
- Spring 에서 정한 내용
- Dispatcher Servlet이 수행되기 전에 각종 filter를 거침
- Spring 에서는 그 때 보안에 관한 내용을 처리하게끔 정함

- Spring Security는 여러가지 필터로 이루어져 있고 필터들이 순서대로 동작함
  - 인증과 권한에 관한 부분을 Filter에 흐름에 따라 처리

### securityConfig
- 이전에는 WebSecurityConfigurerAdapter를 상속받아 구현했음
- WebSecurityConfigurerAdapter가 Deprecated 됨
- SecurityFilterChain을 bean으로 등록해서 사용 필요
  - 두 방법 모두 가능, 구현 방법이 비슷함
```
authorizeRequest() (보안 절차를 거치고)
anyRequest() (어떠한 request라도)
authenticated() (인증을 받아야 함)
formLogin() (그 방식은 폼 로그인)
```
- 형식으로 설정 클래스 처리
- 최종적으로 SecurityFilterChain 타입으로 값을 빌드하여 return
```java
public class SecurityConfig {
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 http
 .authorizeRequests()
 .anyRequest().authenticated()
 .formLogin();

 return http.build();
}
```

### 기본적인 formLogin 인증 API 구조
```java
http.formLogin()
 .login("/login")
 .defaultSuccessUrl("/home")
 .failureUrl("/login")
 .usernameParameter("username")
 .passwordParameter("password")
 .loginProcessingUrl("/login")
 .successHandler(loginSuccessHandler())
 .failereHandler(loginFailureHander())
```

| 이름 | 설명 |
| ---- | ---- |
| login | 사용자가 정의한 로그인 페이지 |
| defaultSuccessUrl | 로그인 성공 후 이동하는 페이지
| failureUrl | 로그인 실패 후 이동하는 페이지 |
| usernameParameter | 폼 태그에 사용되는 아이디 파라미터명
| passwordParameter | 폼 태그에 사용되는 비밀번호 파라미터명 |
| loginProcessingUrl | 폼 태그에 사용되는 url
| successHandler | 로그인 성공 후 실행되는 handler
| failereHandler | 로그인 실패 후 실행되는 handler

- Spring Security는 dispatcherServlet 이전에 필터링 하는 역할을 수행함을 잊지 말자
- 이 때의 핸들러는 Security에 내장된 혹은 사용자가 정의한 핸들러임

---

## Login Form 인증 절차
![](/TIL/image/2023-05-29-16-34-30.png)
1. Http Request가 들어옴
2. `AuthenticationFilter`가 요청을 낚아챔
   - AuthenticationFilter에서 Request의 Username, password를 이용하여 `UsernamePasswordAuthenticationToken`을 생성한다.
3. 토큰을 `AuthenticationManager`가 받는다.
4. AuthenticationManager는 토큰을 `AuthenticationProvider`에게 토큰을 넘긴다.
5. AuthenticationProvider는 `UserDetailsService`로 토큰의 사용자 아이디(username)을 전달하여 DB에 존재하는지 확인한다.
   - UserDetailService 부분을 구현하는 것
6. UserDetailsService는 DB의 회원정보를 `UserDetails` 라는 객체로 반환한다.  
7. ~ 10. `AuthenticationProvider`는 반환받은 UserDetails 객체와 실제 사용자의 입력정보를 비교한다. 비교가 완료되면 사용자 정보를 가진 `Authentication` 객체를 `SecurityContextHolder에 담은 이후 AuthenticationSuccessHandle`를 실행한다. 
<br>(실패시 AuthenticationFailureHandler를 실행한다.)

#### Spring 에서 제공하는 암호화
```
String encPassword = bCryptPasswordEncoder.encode(rawPassword)
```
- 패스워드는 반드시 인코딩 되어야함

--- 

## Cookie / Session / Token 인증 방식 
- 서버가 클라이언트 인증을 확인하는 대표적 3가지 방식
### Cookie
- 쿠키는 Key-Value 형식의 문자열 덩어리
- 클라이언트가 어떠한 웹 사이트를 방문할 경우 클라이언트의 브라우저에 설치되는 작은 기록 정보 파일
- 각 사용자마다 브라우저에 정보를 저장
- 고유 정보 식별 가능

![](/TIL/image/2023-05-29-17-17-54.png)
1. 브라우저가 서버로 요청
2. 클라이언트 요청에 대한 응답 작성 시 클라이언트 측에 저장하고 싶은 정보를 응답 헤더의 Set-Cookie에 담아 보냄
3. 클라이언트는 요청을 보낼 때마다, 저장된 쿠키를 요청 헤더의 Cookie에 담아 보냄
4. 서버는 쿠키에 담긴 정보를 바탕으로 해당 요청 클라이언트의 식별, 정보를 바탕으로 추천 광고 등을 수행

#### 단점
- 보안에 취약
- 요청 시 쿠키의 값을 그대로 보내 유출 및 조작 당할 위험 존재
- 용량 제한이 있어 많은 정보 담을 수 없음
- 브라우저별 쿠키에 대한 지원 형태가 달라 브라우저간 공유 불가능
- 쿠키의 사이즈가 커질수록 네트워크 부하가 심해짐


### Session 
- 비밀번호 등 클라이언트의 민감한 인증 정보를 브라우저가 아닌 서버 측에 저장하고 관리
- 서버의 메모리, 로컬 파이르 DB 등
- 민감한 정보는 클라이언트에 보내지 않고 서버에서 모두 관리
- SESSION ID(key)와 Value 쌍으로 구성되어 있음
  - Value 세션 생성 시간, 마지막 접근 시간, User가 저장한 속성

![](/TIL/image/2023-05-29-17-22-27.png)
1. 유저가 웹사이트 로그인 시 세션이 서버에 저장.
   - 세션 식별을 위해 Session id 기준으로 정보 저장
2. 서버에서 브라우저에 쿠키에 Session Id 저장
3. 브라우저가 해당 사이트에 대한 모든 Request에 Session Id를 쿠키에 담아 전송
4. 서버는 클라이언트가 보낸 Session Id와 서버 메모리로 관리하고 있는 Session Id를 비교하여 인증을 수행

#### 단점
- 해커가 세션 ID 자체를 탈취하여 클라이언트인척 위장할 수 있다는 한계가 존재
- 세션 저장소를 사용하므로 요청이 많아지면 서버에 부하가 심해짐


### Token
- 클라이언트가 서버에 접속을 하면 서버에서 해당 클라이언트에게 인증되었다는 의미로 **토큰**을 부여
- 토큰은 유일함
- 토큰을 발급받은 클라이언트는 서버에 요청을 보낼 때 요청 헤더에 토큰을 심어 보냄
- 서버는 받은 토큰을 서버에서 제공한 토큰과의 일치 여부를 체크하여 인증 과정 처리

- 서버가 아닌 클라이언트에 저장되기 때문에 세션을 관리했던 서버의 부담을 덜 수 있음
- 토큰 자체에 데이터가 들어 있어 토큰 의 위조 판별만 진행하면 됨
- 웹에는 쿠키와 세션이 있지만 앱에서는 없어 앱에서 가장 많이 사용됨


---

## JWT (JSON Web Token)
- 인증에 필요한 정보들을 암호화시킨 JSON 토큰
- JWT 토큰을 HTTP 헤더에 실어 서버가 클라이언트를 식별하는 방식 
- JSON 데이터를 `Base64 URL-safe Encode`를 통해 인코딩하여 직렬화한 것
- 위변조 방지를 위해 개인키를 통한 전자서명이 들어있음
- JWT 를 서버로 전송하면 서버는 서명을 검증하는 과정을 거침
- 검증이 완료되면 요청한 응답을 돌려줌

### JWT의 형식
![](/TIL/image/2023-05-29-17-33-12.png)
- Header
  - 서명 암호화 알고리즘(해시 알고리즘의 종류) : alg
  - 토큰 유형(사용할 타입) ㅣ typ
- Payload
  - 토큰에서 사용할 정보의 조각들인 Claim이 담겨있음
    - Claim : key-value 형식으로 이루어진 한 쌍의 정보
  - 서버에서 첨부한 사용자 권한 정보
  - 데이터
  - 정해진 데이터 타입은 없으나 대표적으로 세개로 나뉨
  - Registered claims
    - 미리 정의된 클레임
  - Public claims
    - 사용자가 정의할 수 있는 클레임
    - 공개용 정보 전달을 위해 사용
  - Private claims
    - 해당 당사자들 간에 정보 공유를 위해 만들어진 사용자 지정 클레임

- Signature
  - Header, Payload를 Base64 URL-safe Encode를 한 이후 Header에 명시된 **해시 함수를 적용하고 개인키로 서명**한 전자 서명
  - 서버에서 관리하는 **비밀키**가 유출되지 않는 이상 복호화 불가
  - Signature는 토크의 위변조 여부를 확인함

### 인증 타입(알고리즘)
