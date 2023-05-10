# 230427_Spring_day7
## 목차
<!-- TOC -->

- [230427\_Spring\_day7](#230427_spring_day7)
  - [목차](#목차)
  - [Spring MVC 구현에서 사용되는 다양한 어노테이션](#spring-mvc-구현에서-사용되는-다양한-어노테이션)
    - [`@Controller`](#controller)
    - [`@Service`](#service)
    - [`@Repository`](#repository)
  - [Mybatis](#mybatis)
    - [Mybatis의 특징](#mybatis의-특징)
    - [SQL 정의 방법](#sql-정의-방법)
    - [Mybatis의 처리 흐름](#mybatis의-처리-흐름)
  - [Mybatis 설치](#mybatis-설치)
  - [Mybatis의 주요 객체](#mybatis의-주요-객체)
    - [SQLSession 객체의 주요 메서드](#sqlsession-객체의-주요-메서드)
      - [SELECT](#select)
      - [INSERT, DELETE, UPDATE](#insert-delete-update)
  - [Mapper 파일 생성과 활용](#mapper-파일-생성과-활용)
    - [생성](#생성)
    - [활용](#활용)
      - [SQL문 작성](#sql문-작성)
  - [typeAliases](#typealiases)
    - [ex](#ex)
  - [오늘의 Tip](#오늘의-tip)
    - [MVC model1과 model2의 차이](#mvc-model1과-model2의-차이)
      - [Model 1](#model-1)
      - [Model 2](#model-2)

<!-- /TOC -->
---
## Spring MVC 구현에서 사용되는 다양한 어노테이션
![](/TIL/image/2023-04-27-09-17-36.png)
### `@Controller`
- 컨트롤러
- 프레젠테이션 레이어, 웹 요청과 응답을 템플릿을 통해 또는 직접 처리
### `@Service`
- 필수 구현 요소는 아님
- Controller 안에 모든 기능을 구현하기에는 처리하는 로직이 자주 사용되는 로직일 때 사용
- 독립된 자바 클래스로 만들어 그 클래스를 활용하게끔 `@Service` 어노테이션을 활용
- `@Service` 어노테이션을 붙이면 Service의 기능을 하는 bean 객체로 등록
- 서비스 레이어, 필요시 내부에서 비즈니스 로직 처리
### `@Repository`
- DB 연동을 전담하는 클래스
- 이 클래스를 bean으로 등록하고 싶을 때 사용
- 주로 DAO 클래스에 구현함
- DB 연동하다가 예외가 발생했을 때 예외처리를 해도되고 안해도되게끔 자동으로 설정 가능
- 퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업 처리

---
## Mybatis
- SQL Mapper 기능을 지원
- JDBC로 처리하는 상당 부분의 코드와 파라미터 설정 및 결과 매핑을 Mybatis 프레임워크가 대신 처리
### Mybatis의 특징
- 간단함
- 생산성
- 자바 객체와 SQL 입출력 값의 투명한 바인딩
- 동적 SQL 조합
- 이식성
- 오픈소스이며 무료임
### SQL 정의 방법
- 매핑 파일
  - 전통적인 지정 방법
  - 마이바티스 기능을 완벽하게 이용 가능
- 어노테이션
  - Mybatis3부터 지원되는 방법
  - 개발의 용이성을 우선시 할 때 효과적
  - SQL 지정은 간단하지만 복잡한 SQL이나 매핑 지정 시에는 적합하지않음
    - 어노테이션의 표현력과 유연성의 제약 탓
  - 매핑 파일에서 표현할 수 있는 모든 것이 지원되는 것은 아님
### Mybatis의 처리 흐름
- SQLSession Factory Builder와 SQLSession Factory는 Mybatis가 제공하는 API
- Mybatis를 사용해 DB 연동을 후 CRUD 하는 건 SQLSession을 사용함

---
## Mybatis 설치
- MyBatis-Spring API 설치 필요
- 스프링 부트 프로젝트를 만들 때 MyBatis Framework를 적용시켜도 됨
- application.properties
```properties
# database
spring.datasource.url: jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF8&serverTimezone=UTC \
spring.datasource.username: 
spring.datasource.password: 
spring.datasource.driver-class-name: com.mysql.cj.jdbc.Driver

# mybatis
# 아래 위치에 있는 모든 xml 파일이 mapper라고 지정하는 것
mybatis.mapper-locations: mybatis/mapper/*.xml
mybatis.type-aliases-package=com.example.springedu.domain
```
---
## Mybatis의 주요 객체
- 스프링 컨테이너가 SqlSessionFactoryBean 객체를 가지고 SqlSession 객체를 생성해서 SqlSession 객체를 필요로 하는 곳에 주입
### SQLSession 객체의 주요 메서드
- SQL 발행이나 트랜잭션 제어용 API를 제공하는 컴포넌트
- 마이바티스를 이용해 DB에 접근할 때 가장 중요한 역할을 함
#### SELECT
- 어떤 도메인 객체에로 전달할지에 따라 방법이 다름
```java
// 1개
// statement는 mapper에서 수행되는 select 명령의 id
// 2번째 parameter는 생략 가능
T SelectOne(String statement, Object parameter); 

//List
List<E> selectList(String statement, Object parameter)

// 제네릭스구문을 활용함 - 리턴값이 정해지지않았다
// mapper에서 resultType을 설정해 리턴값 지정
<T> Cursor<T> selectCursor(String statement, Object parameter)

// Map
Map<K,V> selectMap(String statement, Object parameter, String mapKey)
```

#### INSERT, DELETE, UPDATE
- return 값은 int로 고정
  - 변화된 행의 갯수 return
```java
int insert(String statement, Object parameter)

int delete(String statement, Object parameter)

int update(String statement, Object parameter)
```
---
## Mapper 파일 생성과 활용
### 생성
```xml
<mapper namespace=”……”>
    <select id=”…” resultType=”…” parameterType=”…”>
    <insert id=”…” parameterType=”…”>
    <delete id=”…” parameterType=”…”>
    <update id=”…” parameterType=”…”>
    <sql id=”…”>
</mapper>
```
- namespace : 이 mapper만의 이름
- id : 각 메소드의 id
### 활용
```xml
<mapper namespace="BoardDAO">
    <delete id="deleteBoard">
        delete board where seq=#{seq}
    </delete>
</mapper>
```
```java
public void deleteBoard(BoardVO vo){
    mybatis.delte.("BoardDAO.deleteBoard" vo);
}
```
#### SQL문 작성
- id를 부여한 각 태그 내에 sql문을 작성함
- `# { }` 동적으로 값을 부여하겠다는 의미로 parameterType을 반드시 지정해야함
```xml
 <select id="partEmp" resultType="EmpVO" parameterType="PageDTO" >
    select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, 
    sal from emp order by sal limit #{startNum}, #{countNum}
 </select> 
```
---
## typeAliases
- 타입 별칭
- 자바 타입에 대한 짧은 이름
- XML 설정에서만 사용도미
### ex
| 별칭   | 매핑된 타입 |
| ------ | ----------- |
| _int   | int         |
| int    | Integer     |
| string | String      |
| byte   | Byte        |

---
## 오늘의 Tip
### MVC model1과 model2의 차이
#### Model 1
- jsp 안에 HTML과 Java 코드를 다 넣어 구현했던 시절 -> 유지보수가 어려움
  - View와 Controller를 JSP에서 모두 구현하는 구조
- JSP 안에 구현된 Java 클래스를 밖으로 빼서 따로 구현하기 시작
  - JSP용 Java bean이라고 불림
  - DB 연동하는 Java
#### Model 2
- 사이트가 점점 방대해짐
- Model 1으로 감당하기에 기능이 많아짐
- 요청 받았을 때 처리할 기능과 응답 받았을 때 처리할 기능을 나눠서 구현
- MVC