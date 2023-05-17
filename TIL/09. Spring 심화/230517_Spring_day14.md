# 230517_Spring_day14
## 목차
<!-- TOC -->

- [230517\_Spring\_day14](#230517_spring_day14)
  - [목차](#목차)
  - [Spring Data](#spring-data)
  - [Spring Data JPA](#spring-data-jpa)
  - [JpaRepository 주요 메소드](#jparepository-주요-메소드)
  - [쿼리 메소드](#쿼리-메소드)
    - [쿼리 메소드 기능 3가지 방법](#쿼리-메소드-기능-3가지-방법)
      - [메소드 이름 vs @Query](#메소드-이름-vs-query)
  - [`@RequiredArgsConstructor`](#requiredargsconstructor)
  - [PageRequest API](#pagerequest-api)
  - [Spring Boot Application에 설정된 애노테이션](#spring-boot-application에-설정된-애노테이션)
  - [Spring Boot 테스트](#spring-boot-테스트)
    - [애노테이션](#애노테이션)
      - [`@DataJpaTest`](#datajpatest)

<!-- /TOC -->
---
## Spring Data
![](/TIL/image/2023-05-17-09-14-11.png)

---

## Spring Data JPA
- Spring Framework에서 JPA를 편리하게 사용할 수 있도록 지원하는 프로젝트
- CRUD 처리를 위한 공통 인터페이스 제공
- Repository 개발 시 인터페이스만 작성해도 실행 시점에서 Spring Data JPA가 구현 객체를 동적으로 생성해서 주입
- `JpaRepository<T, ID>` 인터페이스를 상속한 Reopository 인터페이스 정의하여 사용
  - `JpaRepository<테이블, 기본키 타입>`
- 기본적인 메서드 이미 장착되어 정의한 상태이고 인터페이스 구현도 필요하지않음
  - 스프링이 알아서 처리
![](/TIL/image/2023-05-17-09-24-26.png)
- 엔티티 객체를 위한 repository 인터페이스를 *엔티티클래스명Repository* 명으로 JpaRepository를 상속하여 개발

---
## JpaRepository 주요 메소드
| 메소드                     | 설명                                                         |
| -------------------------- | ------------------------------------------------------------ |
| `<S extends T> s save(s)`  | 새로운 엔티티 저장, 이미 있는 엔티티 병합                    |
| `delete(T)`                | 엔티티 하나를 삭제                                           |
| `Optional<T> findById(ID)` | ID로 엔티티 하나 조회                                        |
| `List<T> findAll`          | 모든 엔티티를 조회<br>정렬이나 페이징 조건을 파라미터로 제공 |
- findById - return 값 Optional
---
## 쿼리 메소드
- JpaRepository 주요 메소드는 모든 엔티티에 대해 **공통으로 쓰일 수 있는** 메소드를 제공
- 조건을 지정하여 조회, 제거, 저장하려면 기능들을 커스터마이징해야함
- Repository 커스터마이징을 위한 기능 쿼리메소드
### 쿼리 메소드 기능 3가지 방법
1. 메소드 이름으로 쿼리 생성 -> 간단한 쿼리 처리시 좋음 (쿼리 메서드)
   - JPA 이름 생성은 syntext라고 봐야함  
  
   | 쿼리 종류 | 이름 규칙                                  |
   | --------- | ------------------------------------------ |
   | 조회      | find...By, read...By, query...By, get...By |
   | COUNT     | count...By 반환타입 long                   |
   | EXISTS    | exists...By 반환타입 boolean               |
   | 삭제      | delete...By, remove...By                   |
   | DISTINCT  | findDistinct, findMemberDistinctBy         |
   | LIMIT     | findFirst3, findFirst, findTop, findTop3   |
   - 위 규칙에 따라 findById() 와 같이 사용
    `findByMemoContains(String keyword)` 
    - keyword를 포함한 memo를 찾겠다는 의미
    - 그 외 Keyword
    ![](/TIL/image/2023-05-17-19-10-50.png)
2. @Query 안에 JPQL 정의 -> 복잡한 쿼리 처리시 좋음
   - `@Query` 어노테이션의 속성으로 직접 JPQL을 작성하여 정의 (쿼리 직접 실행)
    ```java
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
    ```
3. 메소드 이름으로 JPA NamedQuery 호출 (잘 쓰이지않음)
#### 메소드 이름 vs @Query
- 메소드 이름으로 쿼리를 실행할 때의 단점
  - 조건이 많으면 메소드 이름이 너무 길어짐
  - 조인과 같은 복잡한 기능 사용 불가
- 메소드 이름은 보다 간단한 기능인 경우 매우 유용, 복잡해지면 직접 쿼리를 작성하여 실행하는 것이 좋음
- 메소드 이름으로 쿼리 실행 시 파라미터를 순서대로 입력
- 쿼리 직접 실행 시에는 명시적 바인딩 필요 
  - `@Param("itemName")` 애노테이션 활용
- 둘 다 매우 복잡한 동적 쿼리에는 부족함
  - 이 때는 QueryDSL을 사용
---
## `@RequiredArgsConstructor`
- 의존성 주입의 한 종류로 생성자 주입
- 요구되는 arguments의 생성자를 자동으로 만들어 달라는 것
- 여기서 초기화를 요구하는 멤버변수에게 final을 설정하면 됨
- 이 어노테이션을 사용하면 `@Autowired`를 사용하지않아도 됨
- 대신 멤버 변수를 `final`로 설정해야함
---
## PageRequest API
- Pageable을 상속받는 API
- 페이지네이션 처리를 도와줌
```java
int page; // 현재 페이지의 index, 0부터 시작
int size; // 한 페이지의 게시글 갯수
PageRequest pageRequest = PageRequest.of(page, size); // 일정 조건으로 정렬되지않음  
PageRequest pageRequest = PageRequest.of(page, size, Sort.by("sal").descending()); // 정렬 후 페이징
```
---
## Spring Boot Application에 설정된 애노테이션
```java
@SpringBootApplication
@ComponentScan(basePackages={"com.example.demo","thymeleaf.exam",
"springjpa.exam"})
@EnableJpaRepositories(basePackages = {"springjpa.exam.repository"})
@EntityScan(basePackages = {"springjpa.exam.entity"}) 
```
- `@SpringBootApplication` 스프링 부트의 가장 기본적인 설정을 선언
  - 내부적으로 `@ComponentScan`과 `@EnableAutoConfiguration`을 설정
- `@ComponentScan` 스프링 3.1부터 도입, 스캔 위치 설정
- `@EnableJpaRepositories` JPA Repository들을 활성화하기 위한 애노테이션
- `@EntityScan` 애노테이션은 엔티티 클래스를 스캔할 곳을 지정
---
## Spring Boot 테스트
- 스프링 부트는 spring-boot-starter 의존성을 제공
- 테스트를 위한 spring-boot-starter-test 역시 존재
- JUnit 5: 자바 애플리케이션 단위 테스트를 위한 사실상의 표준 테스트 도구
- Spring Test & Spring Boot Test: 스프링 부터 애플리케이션에 대한 유틸리티 및 통합 테스트 지원
- AssertJ: 유연한 검증 라이브러리
- Hamcrest: 객체 Matcher를 위한 라이브러리
- Mockito: 자바 모킹 프레임워크
- JSONassert: JSON 검증을 위한 도구
- JSONPath: JSON용 XPath
### 애노테이션
spring-boot-starter-test 의존성을 추가해 스프링이 미리 만들어둔 테스트를 위한 다양한 어노테이션을 사용해 편리하게 테스트 작성 가능
```
@SpringBootTest
@WebMvcTest
@DataJpaTest
@RestClientTest
@JsonTest
@JdbcTest
```
#### `@DataJpaTest`
- JPA 레포지토리 테스트를 위해 이용하는 애노테이션
- @Entity가 있는 엔티티 클래스들을 스캔하여 테스트를 위한 TestEntityManager를 사용해 JPA 레포지토리 설정
- 기본적인 동작
  - `@Transactional`이 있으면 테스트 종료 후 자동으로 트랜잭션 롤백
  - 기본적으로 들어가 있어서 모든 테스트 롤백
  - 롤백을 원하지않으면 `@Rollback(false)` 추가
- 내장 데이터베이스가 클래스 패스에 존재할 때
  - 내장 DB 자동 구성
  - Spring-boot-test 의존성에는 기본적으로 H2가 들어가있어 별다른 설정이 없다면 H2로 설정
  - AutoConfigureTestDatabase의 replace 속성을 None
    ```java
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    ```