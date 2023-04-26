# 230426_Spring_day6
## 목차
<!-- TOC -->

- [_Spring_day6](#_spring_day6)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [Spring MVC 구현 시 사용되는 어노테이션](#spring-mvc-%EA%B5%AC%ED%98%84-%EC%8B%9C-%EC%82%AC%EC%9A%A9%EB%90%98%EB%8A%94-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98)
        - [@PathVariable](#pathvariable)
        - [@RestController](#restcontroller)
    - [스프링 MVC에서 파일 업로드](#%EC%8A%A4%ED%94%84%EB%A7%81-mvc%EC%97%90%EC%84%9C-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C)
        - [MultipartFile의 주요 메소드](#multipartfile%EC%9D%98-%EC%A3%BC%EC%9A%94-%EB%A9%94%EC%86%8C%EB%93%9C)
    - [오늘의 팁](#%EC%98%A4%EB%8A%98%EC%9D%98-%ED%8C%81)
        - [많이 사용되는 Log API](#%EB%A7%8E%EC%9D%B4-%EC%82%AC%EC%9A%A9%EB%90%98%EB%8A%94-log-api)
    - [회고](#%ED%9A%8C%EA%B3%A0)

<!-- /TOC -->
---
## Spring MVC 구현 시 사용되는 어노테이션
### `@PathVariable`
- url 특정 부분을 변수화 하는 기능을 지원
- `@RequestMapping`에서 변수를 {}로 감싸고, 메소드의 파라미터에 `@PathVariable`을 지정하여 메소드에서 파라미터로 활용
```java
@RestController
public class HomeController {
 @RequestMapping("/{name}")
 public String home(@PathVariable String name) {
 return "Hello, " + name;
 }
```
- Mapping 시 들어오는 URL 문자열의 name 부분에 해당하는 값을 home 메소드의 `@PathVariable`을 지정한 name이라는 매개변수에 할당
```java
@RequestMapping(value="/character/detail/{name}/{number}")
	 public String getAllBoards(@PathVariable("number") int num, 
			 		@PathVariable String name, Model model)
```
- @PathVariable의 값을 생략할 수 있는 경우는 URL의 변수화된 특정 부분의 이름과 메소드 파라미터의 이름이 동일한 경우뿐
- number 부분을 받아 int num으로 활용하겠다는 의미고, 생략한다면 name 부분을 받아 동일한 이름을 찾고 그 파라미터를 활용하겠다는 의미임

### `@RestController`
- `@Controller` + `@ResponseBody`
- Restful 웹 서비스 구현 시 응답은 언제나 응답바디에 보내져야함
- 스프링 4.0에서 @RestController 제공
- @RequestMapping 어노테이션을 설정한 method에 각각 @ResponseBody를 다시 설정핧 필요가 없음
- Spring MVC에서 @RespnoseBody를 이용하여 JSON or XML 포맷으로 데이터 넘기기 가능
---
## 스프링 MVC에서 파일 업로드
- 클라이언트에서 업로드 되는 파일은 여러 개의 파트로 구성되어 전달
- multipart/form-data
- 멀티 파트를 argument로 받기 위해서는 컨트롤러 메소드의 매개변수 타입을 세 가지 중 하나로 지정해야함
```
xxx(MultipartFile mfile)
xxx(MultipartFile 타입을 멤버변수로 정의한 VO클래스 vo)
xxx(MultipartFile[] 타입을 멤버변수로 정의한 VO클래스 vo) → 다중 파일일 때
xxx(MultipartRequest mreq) → 다중 파일일 때
```
###  MultipartFile의 주요 메소드
| 메소드                               | 설명                                              |
| ------------------------------------ | ------------------------------------------------- |
| String getName()                     | 파라미터의 이름 리턴                      |
| String getOriginalFilename()         | 업로드 한 파일의 **실제 이름** 리턴          |
| boolean isEmpty()                    | 업로드 한 파일이 존재하지 않으면 true를 리턴 |
| long getSize()                       | 업로드 한 파일의 크기 리턴                 |
| byte[] getBytes() throws IOException | 업로드 한 파일의 데이터를 byte 배열로 리턴     |
| InputStream getInputStream() | InputStream 객체를 리턴      |
| void transferTo(File dest)           | 업로드 한 파일 데이터를 지정한 파일에 저장<br>만약 파일에서 뽑아 수정하는 과정이 없다면 이 방법으로 업로드 하는 것이 가장 간단함  |
- transferTo() 메소드를 사용하지 않는 경우
```java
 File f = new File("c:/uploadtest/"+fileName);
FileOutputStream fos = new FileOutputStream(f);
fos.write(content);
fos.close();	   	
```
--- 
## 오늘의 팁
### 많이 사용되는 Log API
- Log4J -> LogBack -> Log4J2
- Log4J의 보안적 문제 : 제공된 log를 통해 DB에 침투 가능한 경로를 제공함
- LogBack : Spring에서 default로 지원하고 있음
---
## 회고
