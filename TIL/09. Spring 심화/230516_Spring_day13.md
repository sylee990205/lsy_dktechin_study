# 230516_Spring_day13
## 목차
<!-- TOC -->

- [_Spring_day13](#_spring_day13)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [JPA 연관관계 매핑 기초](#jpa-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84-%EB%A7%A4%ED%95%91-%EA%B8%B0%EC%B4%88)
        - [객체 연관 관계](#%EA%B0%9D%EC%B2%B4-%EC%97%B0%EA%B4%80-%EA%B4%80%EA%B3%84)
        - [테이블 연관 관계](#%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%97%B0%EA%B4%80-%EA%B4%80%EA%B3%84)
        - [차이점](#%EC%B0%A8%EC%9D%B4%EC%A0%90)
        - [단방향 연관관계 매핑](#%EB%8B%A8%EB%B0%A9%ED%96%A5-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84-%EB%A7%A4%ED%95%91)
        - [@ManyToOne](#manytoone)
        - [@JoinColumn](#joincolumn)
    - [Persistence.xml](#persistencexml)
    - [회고](#%ED%9A%8C%EA%B3%A0)

<!-- /TOC -->
---
## JPA 연관관계 매핑 기초
- 연관 관계는 단방향과 양방향이 있음 
```
 A -> B A는 B를 참조함
 B -> A B는 A를 참조함
```
- 하나만 성립하는 경우 단방향
- 관계 모두 서로 참조하면 양방향
### 객체 연관 관계
- 단방향 연관 관계
- 참조(주소)로 연관 관계를 맺음
### 테이블 연관 관계
- 다대일(N:1) 단방향 연관 관계
- 외래키로 연관관계를 맺음
- 양방향 관계 가능
### 차이점
- 참조를 통한 객체 연관관계는 언제나 단방향
- 객체 간 연관관계를 양방향으로 하려면 반대쪽에도 필드를 추가하여 참조 보관 필요
  - 단방향 관계를 반대쪽에서도 만듬
### 단방향 연관관계 매핑
- JPA를 사용해서 객체 연관관계와 테이블 연관관계를 매핑
### `@ManyToOne`
- 다대일 관계를 매핑하는 정보
- 속성
  - optional : false로 설정하면 연관된 entity가 항상 있어야함
### `@JoinColumn`
- 외래키 매핑 시 사용
- 속성
  - name
    - 매핑할 외래키 이름 지정
    - 생략 가능
    - 생략 시 외래키를 찾을 때 기본 전략을 사용
    - 기본 전략 : 필드명_참조테이블의컬럼명
---
## Persistence.xml
- `<propert name = "hibernate.hbm2ddl.auto" value="none"/>`
- 이 때의 value 값
  - create : 기존 테이블 삭제 후 다시 생성 DROP + CREATE
  - create-drop : create와 같지만 종료 시점에 테이블 DROP
  - update : 변경분만 반영, 추가만 가능
  - validate : 엔티티와 테이블이 정상 매핑 되는지 확인
  - none : 사용하지않음
---
## 회고
> EntityManager가 Thread-safe 해야 한다는 개념을 머리에 넣어 두었으나 정확하게 이해를 하지 못했었다.<br>EntityManager로 데이터를 변경할 때는 트랜잭션 상에서 진행해야하는데, 각각의 메소드에서 트랜잭션을 항상 begin 하면서 다른 트랜잭션이 생성됨<br>
>> 스레드 1과 스레드 2가 각각 사용하는 트랜잭션이 다르기 때문에 같은 메서드를 호출하더라도 스레드 1은 스레드 1의 영속성 컨텍스트에 접근, 스레드 2는 스레드2의 영속성 컨텍스트에 접근
