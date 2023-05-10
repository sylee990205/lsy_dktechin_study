# 230425_Spring_day5
## 목차
<!-- TOC -->

- [230425\_Spring\_day5](#230425_spring_day5)
  - [목차](#목차)
  - [Thymeleaf 문법](#thymeleaf-문법)
  - [Spring MVC 구현 시 사용되는 어노테이션](#spring-mvc-구현-시-사용되는-어노테이션)
    - [`@ModelAttribute`](#modelattribute)
    - [`@SessionAttributes`](#sessionattributes)
    - [`@RequestBody`, `@ResponseBody`](#requestbody-responsebody)
      - [`@RequestBody`](#requestbody)
      - [`@ResponseBody`](#responsebody)
  - [StringBuffer, StringBuilder](#stringbuffer-stringbuilder)
    - [StringBuffer](#stringbuffer)
    - [String Builder](#string-builder)
  - [오늘의 Tip](#오늘의-tip)
    - [VO vs DTO](#vo-vs-dto)
  - [회고](#회고)

<!-- /TOC -->
---
## Thymeleaf 문법
- Spring EL
  - Spring Expression Language
  - 런타임 시 메소드 호출 및 기본 문자열 템플릿 등의 기능 제공
1. ${...}
   - 변수 표현식
   - 컨트롤러에서 전달받은 변수에 접근 가능
   - th:속성명에서만 사용 가능
2. @{...}
   - URL 표현식
   - 서버의 contextPath를 추가한 URI로 변경
    ```
    @{/} -> "/contextPath/"
    @{/images/1.png} -> "/contextPath/images/1.png"
    ```
3. 문자 합치기
   - 합치고 싶은 문자열을 `|`로 감싸거나 + 연산자를 이용해 문자를 합칠 수 있음.
    ```html
    <div th:text="|My name is ${info.name} !! |"></div>
    <div th:text="'My name is' + ${info.name} + '!!'"></div>
    ```
4. 비교 연산자
   - 기존의 비교 연산자 그대로 사용 가능
    ```html
    <!-- 이항 연산자 -->
    <div th:text="${info.name != 'kim'}"></div>
    <!-- name이 kim이면 true가 출력 -->
    <div th:text="${info.age >= 30}"></div>

    <!-- 삼항 연산자 -->
    <div th:text="${info.name == 'kim' ? 'ok' : 'no'}"></div>
    ```
    - 삼항 연산자가 자주 사용됨
5. HTML 태그의 컨텐트 설정 
   - `th:text`
    ```html
     <div th:text="${info.name}">유니코</div>
    ```
    - name 값이 전달되면 그 값이, 아니면 유니코가 출력
6. HTML 태그의 value 속성의 값 설정
   - `th:value`
    ```html
    <input type='text' th:value="${info.name}" value="둘리" >
    ```
7. `th:if`, `th:unless`
   - if~else 구문과 비슷함
   - 조건이 참이면 th:if를 거짓이면 th:unless를 출력
    ```html
    <p th:if="${info.age > 18}">입장 가능</p>
    <p th:unless="${info.age <= 18}">입장 가능</p>
    ```
8. block 태그
   - th 내에 몇 개 없는 태그 종류 중 하나
   - 여러 태그를 묶어 렌더링 여부를 결정하겠다고 할때 여러 태그를 하나의 블럭 태그로 묶음
    ```html
    <th:block th:if="${info.age > 18}"><hr><p>입장 가능</p><hr></th:block>
    ```
9. `th:switch`, `th:case`
    - switch 구문과 비슷함
    - `th:case` 속성에 지정된 값과 동일한 서브 태그 표현
    ```html
    <th:block th:switch="${info.name}">
        <div th:case="올라프">겨울왕국</div>
        <div th:case="또치">아기공룡둘리</div>
    </th:block>
    ```
10. `th:each`
    - for 반복문과 비슷함
    - block 태그로 묶어 block 태그 내 서브태그가 몇번 반복되어 수행될지 정하는 방법으로 사용하는게 대다수
      - 꼭 block 태그와 함께 작성해야하는것은 아님  
    ```html
    <th:block th:each="data:${datas}">
        <h1 th:text="${data}"></h1>
    </th:block>
    ```
    - 변수명 앞에 status 변수를 추가해 row에 대한 추가정보를 얻을 수 있음
    ```html
    <th:block th:each="data,status:${datas}">
    <h1 th:text="|${status.count} ${data}|"></h1>
    </th:block> 
    ```
---
## Spring MVC 구현 시 사용되는 어노테이션
### `@ModelAttribute`
- 도메인 오브젝트나 DTO 또는 VO의 property에 요청 파라미터를 바인딩해서 한번에 받는 것
- 하나의 오브젝트에 클라이언트의 요청 정보를 담아서 한번에 전달
- 커맨드 오브젝트라고도 불림
```java
@RequestMapping(value="/user/add", method=RequestMethod.POST)
 public String add(@ModelAttribute User user) {
 :
 }
```
- request scope
  - 사용자 요청이 있을때마다 객체 생성됨
- 또 다른 기능으로 컨트롤러가 리턴하는 모델의 파라미터로 전달한 오브젝트를 자동으로 추가하는 것
- 모델의 이름은 기본적으로 파라미터의 이름을 따르지만 ModelAttribute를 사용하여 이름 설정이 가능
```java
public String update(@ModelAttribute("currentUser") User user) {
 ...
 }

@ModelAttribute("v1")
	// 컨트롤러 메소드 외 일반 메소드에도 적용할 수 있음
	// 단, 이 메소드가 모델을 return해주는 메소드여야함
	// ModelAttribute가 붙은 메소드를 handler 메소드 호출 전 먼저 호출하고
	// 각 메소드를 ModelAttribute에서 설정한 이름으로 request 객체에 저장함
	public String createString() {
		System.out.println("객체 생성 자동호출1");
		return "테스트!!";
	}
```
- 미리 생성한 커맨드 객체를 컨트롤러 메소드에서 활용 가능
```java
@ModelAttribute("data1")
public int createModel1() {	
		System.out.println("createModel1() 호출");
		return 100;
}

@RequestMapping(value="/modeltest2")
	//컨트롤러 메소드에서 커맨드 메소드 객체를 사용할 수 있음
	//@ModelAttribute가 아니었으면 vo1이라는 쿼리문자열로 클라이언트가 전달한 값이 들어가지만
	//보관시 사용한 이름 - @ModelAttribute로 지정한 이름으로 vo1의 값이 data1 객체로 처리
public String handle(@ModelAttribute("data1") int vo1,
			      @ModelAttribute("data2") int vo2) {		
		System.out.println("handle 에서 출력 : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
}	

```
### `@SessionAttributes`
- 클래스 위에 SessionAttributes 어노테이션을 사용하여 세션 scope를 지정할 객체의 이름을 선언
- 무조건 클래스 위에! -> 컨트롤러 메소드 수행 전에 이루어져야함

### `@RequestBody`, `@ResponseBody`
- 웹 서비스와 REST 방식이 시스템 주요 구성 요소
- 웹 시스템간 XML, JSON 등의 형식으로 데이터를 주고 받는 경우가 증가
- 스프링 MVC도 클라이언트에서 전송한 XML 데이터, JSON 데이터, 기타 데이터를 컨트롤러에서 DOM 객체, Java 객체로 변환해서 받을 수 있음
- 전송도 가능
#### `@RequestBody`
- Spring은 클라이언트가 전달한 데이터를 적당한 형식에 맞춰 변경하여 전달함
- `@RequestBody`는 HTTP request body를 **전달 형식 그대로** 또는 자바 객체로 변환하여 전달받는데 사용
- GET 방식과는 연관이 없음
- POST 요청 방식에서만 가능
  - POST는 클라이언트가 전달하는 데이터를 요청 Body 내에 저장하여 전달하기 때문

```java
String test2(@RequestBody String param)
PersonVO test3(@RequestBody PersonVO vo)
Map test4(@RequestBody Map<String,String> map)
```
#### `@ResponseBody`
- 자바 객체를 HTTP respnose body로 전송
- view를 거치지 않고 컨트롤러가 직접 응답함
  - 응답 형식 설정 필요
```java
@RequestMapping(value = "/body/json/{id}", produces = "application/json; charset=utf-8")
@ResponseBody

@RequestMapping(value = "/body/xml/{id}", produces = "text/xml; charset=utf-8")
@ResponseBody
```
- RequestMapping 어노테이션의 produces응답 형식을 설정할 수 있음
- json, xml, html 등등
---
## StringBuffer, StringBuilder
- 문자열 편집 시 사용
- API 사용 방법(메소드 등)이 거의 동일함
### StringBuffer
- thread safe
  - 다중 스레드에 대하여 대비되어있음

### String Builder
- thread not safe
  
---
## 오늘의 Tip
### VO vs DTO
- VO와 DTO에 대한 개념을 다시 정리하고 가자
- 객체가 한번만 생성되고 이후 값이 변할 일이 없다면 -> Setter가 필요 없다면 -> VO
- 객체 생성 이후 값이 변경된다면 -> Setter가 필요하다면 -> DTO
---
## 회고
 세션을 사용하는 실습을 진행할 때 count가 증가되지않아 고민했는데, 그 이유가 다른것도 아니고 이름때문이었다는게 충격이었다. 스프링에서 처리할 때 헷갈리지 않도록 이름을 겹치지않게끔 잘 설정해야겠다.
 외에도 세션에는 객체를 줘야한다는 것을 기억해야겠다. 