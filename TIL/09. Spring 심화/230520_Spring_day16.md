# 230520_Spring_day16
## 목차
<!-- TOC -->

- [_Spring_day16](#_spring_day16)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [Spring HATEOAS](#spring-hateoas)
        - [응답할 도메인 객체가 1개 일 때](#%EC%9D%91%EB%8B%B5%ED%95%A0-%EB%8F%84%EB%A9%94%EC%9D%B8-%EA%B0%9D%EC%B2%B4%EA%B0%80-1%EA%B0%9C-%EC%9D%BC-%EB%95%8C)
        - [응답할 도메인 객체가 여러 개일 때](#%EC%9D%91%EB%8B%B5%ED%95%A0-%EB%8F%84%EB%A9%94%EC%9D%B8-%EA%B0%9D%EC%B2%B4%EA%B0%80-%EC%97%AC%EB%9F%AC-%EA%B0%9C%EC%9D%BC-%EB%95%8C)
    - [링크 객체 생성](#%EB%A7%81%ED%81%AC-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1)
        - [컨트롤러 메서드의 호출 URL 정보를 추출하여 Link 객체 생성](#%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%98-%ED%98%B8%EC%B6%9C-url-%EC%A0%95%EB%B3%B4%EB%A5%BC-%EC%B6%94%EC%B6%9C%ED%95%98%EC%97%AC-link-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1)
        - [URL 문자열을 직접 지정해서 Link 객체 생성](#url-%EB%AC%B8%EC%9E%90%EC%97%B4%EC%9D%84-%EC%A7%81%EC%A0%91-%EC%A7%80%EC%A0%95%ED%95%B4%EC%84%9C-link-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1)

<!-- /TOC -->
---
## Spring HATEOAS
### 응답할 도메인 객체가 1개 일 때
- 링크 정보를 포함한 객체를 함께 제공하고자 할 때 EntityModel 객체를 사용

- RepresentationModel을 상속한 커스텀 모델 클래스 생성
  - 도메인정보와 링크가 합쳐진 클래스

### 응답할 도메인 객체가 여러 개일 때
- PresentationModel의 기능을 상속한 도메인 객체의 클래스들을 가진 CollectionModel 객체 사용

---
## 링크 객체 생성
### 컨트롤러 메서드의 호출 URL 정보를 추출하여 Link 객체 생성
WebMvcLinkBuilder의 static 메소드 linkTo()
- 요청 패스를 가지고 클라이언트에서 요청 가능한 컨트롤러 클래스의 메소드에 대한 링크 정보를 담고 있는 WebMvcLinkBuilder 객체 반환
```java
// 현재 클래스를 대상으로 지정할 때는 보통 this.getClass()를 더 많이 사용함
linkTo(methodOn(getClass()).hateoasTest`()).withSelfRel()

// 다른 클래스, 다른 컨트롤러를 사용하고싶을 때 retrieveUser를 사용할 수 있음
// 매개변수로 몇번째인지 지정 가능
linkTo(methodOn(UserController.class).retrieveUser(2)).withRel("test3")
```
### URL 문자열을 직접 지정해서 Link 객체 생성
```
Link.of("정적 URL 문자열", "이름")
```
- 지정된 이름과 URL 문자열을 가지고 Link 객체 생성