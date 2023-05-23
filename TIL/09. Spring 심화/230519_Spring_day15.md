# 230519_Spring_day15
## 목차
<!-- TOC -->

- [230519\_Spring\_day15](#230519_spring_day15)
  - [목차](#목차)
  - [REST](#rest)
    - [적용](#적용)
    - [REST가 필요한 이유](#rest가-필요한-이유)
    - [REST 특징](#rest-특징)
    - [application/hal+json](#applicationhaljson)
  - [REST API](#rest-api)
    - [특징](#특징)
    - [설계 기본 규칙](#설계-기본-규칙)
    - [API 디자인 가이드](#api-디자인-가이드)
    - [URI 설계 시 주의할 점](#uri-설계-시-주의할-점)
    - [리소스 간 관계 표현 방법](#리소스-간-관계-표현-방법)
    - [Collection과 Document](#collection과-document)
  - [HTTP 응답 상태코드](#http-응답-상태코드)
  - [Spring Rest API 구현 관련 애노테이션](#spring-rest-api-구현-관련-애노테이션)
  - [`@ResponseBody` 와 `ResponseEntity`](#responsebody-와-responseentity)

<!-- /TOC -->
---
## REST
"REpresentational State Transfer"의 약어
- 왜 REST 기술이 나왔는지 깊이 있게 봐야함
- 하나의 URI가 하나의 고유한 Resorce를 대표하도록 설계된다는 개념 
- **자원을 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것**
- 네트워크 아키텍처 원리의 모음
  - 자원을 정의하고 자원에 대한 주소를 지정하는 방법 전반
- 분산 하이퍼미디어 시스템을 위한 소프트웨어 개발 아케틱처의 한 형식
- HTTP 프로토콜을 그대로 활용
  - 웹의 장점을 최대한 활용
- Client와 Server 사이의 통신 방식 중 하나
### 적용
- **HTTP URI를 통해 자원을 명명**하고 **HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD 작업을 적용**

| CRUD           | Operation        | Method |
| -------------- | ---------------- | ------ |
| Create         | 생성             | POST   |
| Read           | 조회             | GET    |
| Update         | 수정             | PUT    |
| Partial Update | 부분수정         | PATCH  |
| Delete         | 삭제             | DELETE |
| HEAD           | header 정보 조회 | HEAD   |

REST -> 자원의 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든것
### REST가 필요한 이유
- 애플리케이션 분리 및 통합
- Web을 기반으로 하는 C&S 환경의 다양한 프로그램 개발
- 다양한 클라이언트의 등장
![](/TIL/image/2023-05-19-09-18-11.png)
### REST 특징
- 1~4번은 웹 기반이기에 가질 수 밖에 없는 특징
1. Server-Client(서버-클라이언트 구조)
   - 자원이 있는 쪽이 Server, 자원을 요청하는 쪽이 Client
   - REST Server: API 제공, 비즈니스 로직 처리 및 저장
   - Client: 사용자 인증, context 등을 직접 관리, 책임
2. Stateless(무상태)
   - HTTP 프로토콜은 Stateless Protocol이므로 REST 역시 무상태성
   - Client의 context를 Server에 저장하지 않음
     - 세션과 쿠키와 같은 context 정보를 신경쓰지 않아도 됨 -> 구현이 단순
   - Server는 각각의 요청을 완전히 별개의 것으로 인식하고 처리
     - 각 API 서버는 Client의 요청만을 단순 처리
     - 이전 요청이 다음 요청의 처리에 연관되어서는 안됨
     - 이전 요청이 DB를 수정하여 DB에 의해 바뀌는 것은 허용
     - Server의 처리 방식에 일관성 부여, 부담을 줄이고 서비스의 자유도 높힘
3. Cacheable(캐시 처리 기능)
   - HTTP가 가진 캐싱 기능 적용 가능
   - `Last-Modified` 태그 등을 이용해 캐싱 구현 가능
4. Layered System(계층화)
   - Client는 REST API Server만 호출
   - REST Server는 다중 계층으로 구성
     - 앞단: 보안, 로드밸런싱, 암호화, 사용자 인증 등
     - API Server는 순수 비즈니스 로직 수행
     - 로드밸런싱, 공유 캐시 등을 통해 확장성 보안성 향상
   - PROXY, 게이트웨이 등 네트워크 기반 중간 매체 사용 가능
5. Code-On-Demand(optional)
    - Server로부터 스크립트를 받아 Client에서 실행
    - 반드시 충족할 필요 x
6. Uniform Interface(인터페이스 일관성)
   - URI로 지정한 Resource에 대한 조작을 통일되고 한정적인 인터페이스로 수행
   - 서버와 클라이언트의 독립적인 진화를 위해 만족해야함
### application/hal+json
- json 전달 시 상품의 리스트만 보여주는게 아니고 상품의 상세정보를 담고 있는 url도 함께 전달할 때 사용
---
## REST API
- REST 아키텍처 스타일을 따르는 API
- 사용자가 어떠한 요청을 했을 때 HTML을 리턴하지 않고, 사용자가 필요로 하는 결과만을 리턴해주는 방식
- 마이크로 서비스(하나의 큰 애플리케이션을 여러 개의 작은 애플리케이션으로 쪼개어 변경, 조합이 가능하도록 만든 아키텍처)를 제공하는 업체 대부분이 REST API
### 특징
- 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있음
- HTTP를 지원하는 프로그램 언어로 클라이언트 서버를 구현 가능
- Self-decriptive
  - 확장 가능한 커뮤니케이션
  - 서버나 클라이언트가 변경되더라도 오고 가는 메시지가 self descriptive 하여 언제나 해석 가능
- HATEOAS
  - 애플리케이션 상태 전이의 late binding
  - 어떤 상태로 전이가 완료되고 나서야 그 다음 전이될 수 있는 상태가 결정
### 설계 기본 규칙
1. URI는 정보의 자원을 표현해야함
   - resource 동사보다 명사, 대문자보다 소문자
   - resource의 document 이름은 단수명사
   - resource의 collection 이름은 복수명사
   - resource의 store 이름은 복수명사
  ```
  GET /Member/1 x
  GET /mebers/1
  ```
2. 자원에 대한 행위는 HTTP Method로 표현

   - URI에 HTTP 메소드가 들어가면 안됨
   - URI에 행위에 대한 동사 표현이 들어가면 안됨(CRUD에 관한것)
   - 경로 부분 중 변하는 부분은 유일한 값으로 대체(ex id)

### API 디자인 가이드
- URI는 정보의 자원을 표현해야함
- 자원에 대한 행위는 HTTP Method로 표현
   - GET: 조회
   - PUT: 수정
   - POST: 입력
   - DELETE: 삭제
- **URI는 자원을 표현하는 데에 집중하고 행위에 대한 정의는 HTTP METHOD를 통해 하는 것이 REST API 설계의 중심 규칙**
### URI 설계 시 주의할 점
1. `/`는 계층 관계를 나타내는데 사용
``` 
http://restapi.example.com/animals/mammals/whales
```
2. URI 마지막 문자로 `/`를 포함하지않음
3. `-`은 URI 가독성을 높이는데 사용
   - 어쩔 수 없이 긴 URI 경로를 사용하게 될 때 하이픈을 사용
4. `_`은 URI에 사용하지 않음
5. URI 경로에는 소문자
6. 파일 확장자는 URI에 포함시키지않음
   - 대신 Accept 헤더 사용
### 리소스 간 관계 표현 방법
REST 리소스 간에는 연관 관계가 있을 수 있음
```
/리소스명/리소스ID/관계가 있는 다른 리소스명
```
### Collection과 Document
- Document
  - 문서 한 개 또는 한 개의 객체
- Collection
  - 문서들의 집합, 객체들의 집합
- 두개 모두 리소스라고 표현할 수 있음
```
http:// restapi.example.com/sports/soccer
```
- sports라는 collection에 soccer라는 document
---

## HTTP 응답 상태코드
[HTTP 응답 상태코드를 정리한 DOCS](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.html)
| 상태코드 | 설명 |
| ---- | ---- |
| 200 | 정상 수행 |
| 201 | 리소스 생성 요청, 해당 리소스 생성 성공(POST)
| 400 | 클라이언트의 요청 부적절
| 401 | 클라이언트가 인증되지 않은 상태에서 보호된 리소스 요청
| 403 | 인증 상태오 관계 없이 응답하고 싶지 않은 리소스를 요청하면 사용하는 응답코드<br>403보다는 400 혹은 404 사용 권고<br>403은 리소스가 존재한다는 뜻
| 405 | 클라이언트가 요청한 리소스에서 사용 불가능한 Method를 이용
| 301 | 클라이언트가 요청한 리소스에 대한 URI 변경
| 500 | 서버에 문제가 있을 경우 |

---
## Spring Rest API 구현 관련 애노테이션
- `@RestController`
  - Spring4부터 지원하는 어노테이션
  - View를 갖지 않는 REST Data를 반환
- `@ResponseBody`
  - 따로 설명
- `@GetMapping`
  - `@PathVariable`을 이용한 GET
    1. 매개변수와 이름 동일
    ```java
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable)
    ```
    2. 매개변수와 이름 다름
    ```java
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var)
    ```
  - `@RequestParam`을 이용한 GET
    ```java
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization)
    ```
  - Map 객체 활용
    ```java
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param
    ```
- `@PostMapping`
  - RequestBody를 이용한 POST
  - 
- `@PutMapping`
- `@DeleteMapping`
---
## `@ResponseBody` 와 `ResponseEntity`