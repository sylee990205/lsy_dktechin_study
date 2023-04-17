# 230414 ServletJSP day4
## 목차
<!-- TOC -->

- [230414 ServletJSP day4](#230414-servletjsp-day4)
  - [목차](#목차)
  - [ServletContext](#servletcontext)
  - [컨테이너 API](#컨테이너-api)
    - [종류](#종류)
    - [구현 방법](#구현-방법)
  - [EL(Expression Language)](#elexpression-language)
    - [사용하는 이유](#사용하는-이유)
    - [EL의 내장 객체](#el의-내장-객체)
      - [param](#param)
      - [pageContext](#pagecontext)
    - [el에서의 변수](#el에서의-변수)
    - [. 연산자](#-연산자)
  - [객체 공유](#객체-공유)
  - [MVC(Model-View-Controller) 패턴](#mvcmodel-view-controller-패턴)
    - [모델](#모델)
  - [Servlet이 GET 방식과 POST 방식이 나뉜다면](#servlet이-get-방식과-post-방식이-나뉜다면)

<!-- /TOC -->
---
## ServletContext
- Context는 실행환경, 실행엔진, 실행컨테이너 등을 일컫는 말
  - 실행 엔진: 만약 자바라면 JVM 위에서 클래스를 실행시키는것
- 컨테이너에게 어떠한 수행 작업을 요청하고자 할 때 사용하는 API가 ServletContext

---

## 컨테이너 API
- 데이터를 보관하는 기능을 제공하는 API들
### 종류
| API                | 유지 기간                                                                                  | 객체 생성                            | scope               |
| ------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------ | ------------------- |
| ServletContext     | 서버가 종료 될 때까지 유지                                                                 | 모든 클라이언트가 하나의 객체를 공유 | application scope   |
| HttpSession        | 브라우저가 기동되어 있는 동안 유지                                                         | 클라이언트 별로 객체 생성            | session scope       |
| HttpServletRequest | 요청될때 객체 생성, 응답 될 때 객체 삭제 (요청동안 유지) : 가장 많이 사용됨 (MVC 패턴에서) | 클라이언트 별로 요청 시에 객체 생성  | request scope scope |

### 구현 방법
- 3개의 API가 어디에 저장할지에 따라 선택하는 것으로 구현 방법은 동일함
```java
setAttribute("이름","객체");
getAttribute("이름","객체");
removeAttribute("이름","객체");
```

---

## EL(Expression Language)
- 특정 스코프 영역에 보관되어 있는 객체를 추출하여 이 객체의 값 또는 속성 값을 추출하여 표현하고자 하는 경우 사용
- 표현식 태그 구현을 보다 간단하게 처리 가능
- `$`와 `{}`으로 구현
```jsp
<% out.print(request.getParameter("addr")); %> 수행문
<%= request.getParameter("addr"); %> 표현식
${ param.addr } EL
```
### 사용하는 이유
1. 어딘가에 저장되어 있는 데이터를 꺼내서 출력
2. 어떤 식의 수행 결과를 출력
- EL만의 내장 객체를 이용해서 표현하고자 하는 구현을 편하게
  - setter는 사용할 수 없음
- EL은 뭔가를 `표현`하는데에만 집중된 언어

### EL의 내장 객체
| 내장 객체        | 설명                                           |
| ---------------- | ---------------------------------------------- |
| pageContext      | PageContext 객체<br>이 객체는 JSP에서만 사용됨 |
| pageScope        | page 스코프에 포함된 객체들                    |
| requestScope     | request 스코프에 포함된 객체들                 |
| sessionScope     | session 스코프에 포함된 객체들                 |
| applicationScope | application 스코프에 포함된 객체들             |
| param            | HTTP의 파라메터들                              |
| paramValues      | 한 파라메터의 값들                             |
| header           | 헤더 정보들                                    |
| headerValues     | 한 헤더의 값들                                 |
| cookie           | 쿠키들                                         |
| initParam        | 컨텍스트의 초기화 파라미터들                   |
#### param
- 만약 해당 parameter 이름의 값이 전달되지않았다면 null 이 return 되는것이 아니라 아무것도 출력되지않는 방식으로 처리
#### pageContext
- JSP에서만 사용
- page scope
### el에서의 변수
- 어딘가에 보관되어있는 객체의 이름

### . 연산자
```java
변수명.xxx
```
1. 변수의 참조 대상이 일반 Java 객체면 getXxx()를 호출한 것
2. 변수의 참조 대상이 Map 객체면 get("xxx")를 호출한 것
---
## 객체 공유
- 객체의 scope: 생성되어 유지되는 기간
- page scope -> request scope -> session scope -> application scope
- paga context 객체는 해당 jsp가 수행될때만
- request는 요청할때 생성 응답할때 삭제
- session은 브라우저가 기동되어 있는 동안
- application은 서버 종료까지
- el에서 객체 생성은 setAttribute를 사용하고 이 때 어떤 scope 에 저장할지 정할 수 있음
- 동일한 이름의 변수를 모든 scope에 설정되었다면 위 순서대로 확인 후 있으면 해당 scope 영역의 값으로 가져옴

---
## MVC(Model-View-Controller) 패턴
- 소프트웨어 공학에서 사용되는 아키텍처 패턴
- 사용자 인터페이스로부터 비즈니스 로직을 분리하여 시각적 요소나 비즈니스 로직을 서로 영향 없이 쉽게 고칠 수 있는 어플리케이션 개발 가능
- M - Model: 어플리케이션의 정보(데이터)
- V - View: 텍스트, 체크박스 항목 등 사용자 인터페이스 요소
- C - Controller: 데이터와 비즈니스 로직 사이의 상호 동작 관리, 어플리케이션 기능 담당
- 항상 3가지가 모두 있어야 하는 것은 아니지만 컨트롤러와 뷰는 기본적으로 있는게 좋고 모델의 필요 여부만 생각하는 것이 대부분

### 모델
- 비즈니스 로직, DB 연동 로직, 처리 결과를 저장하는 기능을 지원하는 Java 객체
- 도메인 모델과 서비스 모델로 구성
  - 도메인 모델 : 데이터 저장
  - 서비스 모델 : 기능

---
## Servlet이 GET 방식과 POST 방식이 나뉜다면
- 하나의 Servlet에 두가지를 작성하는것보단 2개의 Servlet을 작성하는 것이 좋음
