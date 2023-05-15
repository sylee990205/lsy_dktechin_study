# 230515_Spring_day12
## 목차
<!-- TOC -->

- [230515\_Spring\_day12](#230515_spring_day12)
  - [목차](#목차)
  - [JPA 개념](#jpa-개념)
    - [Persistence Framework](#persistence-framework)
      - [SQL Mapper](#sql-mapper)
      - [ORM](#orm)
    - [동작 과정](#동작-과정)
    - [JPA 사용 이점](#jpa-사용-이점)
  - [JPA 프로그래밍](#jpa-프로그래밍)
    - [EntityManagerFactory](#entitymanagerfactory)
    - [EntityManager](#entitymanager)
      - [제공되는 메소드](#제공되는-메소드)
    - [Entity](#entity)
    - [Entity 생명주기](#entity-생명주기)
    - [엔티티 생성과 저장](#엔티티-생성과-저장)
    - [엔티티 조회](#엔티티-조회)
    - [엔티티 변경](#엔티티-변경)
    - [엔티티 삭제](#엔티티-삭제)
  - [JPQL 구문](#jpql-구문)
    - [JPQL](#jpql)
    - [기본 문법](#기본-문법)
  - [JPA 기본키 매핑](#jpa-기본키-매핑)
    - [기본키 자동 생성 전략](#기본키-자동-생성-전략)
  - [오늘의 팁](#오늘의-팁)
    - [int와 integer의 null처리](#int와-integer의-null처리)
  - [회고](#회고)

<!-- /TOC -->
---
## JPA 개념
- JPA : Java Persistence API 의 약어
- RDBMS와 OOP 객체 사이의 불일치에서 오는 패러다임을 해결하기 위해 만들어진 ORM 기술
- ORM : Object Relational Mapping
  - 객체-관계 매핑의 줄임말
  - OOP의 **객체 구현 클래스**와 RDBMS에서 사용하는 **테이블**을 자동으로 매핑하는 것
- JPA는 자바 ORM에 대한 표준 명세, 인터페이스의 모음
- 구현체가 없어 ORM 프레임워크 선택 필요
- 가장 대중적인 것은 하이버네이트
### Persistence Framework
- 데이터를 보관하여 유지하는 Framework
- JDBC 프로그래밍의 복잡함, 번거로움 없이 간단한 작업만으로 DB와 연동되는 시스템을 개발 가능
- 크게 두 종류로 나뉨
#### SQL Mapper
- SQL <-> Mapper <-> Object 필드
- 직접 작성한 SQL 문장으로 DB data를 다룸
- Mybatis 등
#### ORM
- DB data <-> ORM <-> Object 필드
- 객체를 통해서 간접적으로 DB의 데이터를 다룸
- 객체와 관계형 DB 데이터를 자동으로 Mapping
- JPA, Hibernate 등
### 동작 과정
![](/TIL/image/2023-05-15-10-29-33.png)
- JPA는 애플리케이션과 JDBC 사이에 동작
- JPA 내부에서 JDBC API를 사용하여 SQL 호출, DB와 통신
- ORM 프레임워크에 저장하면 적절한 INSERT SQL 생성 -> DB에 저장
- SELECT SQL을 생성해 결과를 객체에 매핑, 전달
### JPA 사용 이점
1. 생산성
   - JPA를 사용하면 자바 컬렉션에 저장하듯이 JPA에게 저장할 객체를 전달
2. 유지보수
   - 필드 하나를 추가할 때 SQL과 JDBC 코드를 전부 수행해야 했던 과정을 대신 처리해 개발자가 유지보수해야하는 코드가 줄어듬
3. 패러다임 불일치 해결
   - JPA는 연관된 객체를 사용하는 시점에 SQL을 전달
   - 같은 트랜잭션 내에서 조회할 때 동일성도 보장
   - 다양한 패러다임의 불일치 해결
4. 성능
   - 애플리케이션과 DB 사이에서 성능 최적화 기회를 제공
   - 같은 엔티티를 반환하기 때문에 DB와의 통신 횟수를 줄일 수 있음
   - 트랜잭션을 commit하기 전까지 메모리에 쌓고 한 번에 SQL 전송
5. 데이터 접근 추상화와 벤더 독립성
   - RDB는 같은 기능이라도 벤더마다 사용법이 다름
     - 처음 선택한 DB에 종속되고 변경이 어려움
   - JPA는 애플리케이션과 DB 사이에서 추상화된 data 접근을 제공
---
## JPA 프로그래밍
![](/TIL/image/2023-05-15-10-31-08.png)
1. persistence.xml 파일을 통해 JPA 설정
2. EntityManagerFactory를 생성
3. EntityManager를 생성하여 Entity를 영속성 컨텍스트(Persistence Context)를 통해 관리
### EntityManagerFactory
```java
EntityMangaerFactory factory = Persistence.createEntityManagerFactory("emptest");
```
- DB 상호 작용을 위한 EntityManager 객체를 생성하기 위해 사용되는 객체
- Thread-Safe
  - 여러 스레드에서 동시에 접근해도 안전
- EntityManagerFactory 객체를 통해 생성되는 모든 EntityManager 객체는 동일한 DB에서 접속
### EntityManager
```java
EntityManager em = factory.createEntityManager();
```
- Entity를 관리하는 객체
- DB CRUD 작업은 모두 Persistence context를 사용하는 EntityManager 객체를 통해 이루어짐
- 동시성의 문제가 발생할 수 있어 스레드간 공유 X
- 모든 데이터 변경은 트랜잭션 안에서 이루어져야함 (트랜잭션 시작 후 처리)
  - DB의 논리적인 작업 단위

![](/TIL/image/2023-05-15-11-05-26.png)
#### 제공되는 메소드
- **flush()**
  - Persistence context의 변경 내용을 DB에 반영
  - 일반적으로 flush() 메소드를 직접 사용하지 않고 자바 애플리케이션에서 **커밋 명령**이 들어왔을 때 자동으로 실행
- detach()
  - 특정 Entity를 준영속 상태(영속 컨텍스트의 관리를 받지 않는 상태)로 바꿈
- clear()
  - Persistence Context를 초기화
- close()
  - Persistence Context 종료
- merge()
  - 준영속 상태의 엔티티를 이용해서 새로운 영속 상태의 엔티티를 반환
- **find()**
  - 식별자 값을 통해 Entity를 찾음
  - (DB 테이블의 데이터 또는 행을 찾음)
  - SELECT
  - argument 첫번째 사용할 엔티티 클래스, 두번째 primarykey Object 타입
- **persist()**
  - 생성된 Entity 객체를 영속성 컨텍스트에 저장
- **remove()**
  - 식별자 값을 통해 영속성 컨텍스트에서 Entity 객체를 삭제

### Entity
- Entity란 **DB 테이블에 대응하는 하나의 객체**
- `@Entity` 어노테이션이 붙은 클래스를 JPA에서 Entity
- 영속성 컨텍스트에 담겨 EntityManager에 의해 관리
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment와 동일함
private int id;
```
### Entity 생명주기
1. 비영속(new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 상태
2. 영속(managed) : 영속성 컨텍스트에 저장된 상태
3. 준영속(detached) : 영속성 컨텍스트에 저장되었다가 분리된 상태
4. 삭제(removed) : 삭제된 상태

### 엔티티 생성과 저장
![](/TIL/image/2023-05-15-18-19-08.png)
1. 자바 어플리케이션에서 어떤 Entity 객체를 생성하여 DB에 저장을 부탁
2. 1차적으로 Persistence Context에 저장 (1차 캐시)
   - 저장한 Entity를 DB 저장하기 위한 쿼리문을 생성 -> 쓰기 지연 SQL 저장소에 저장
   - 계속 Entity를 넘기면 Entity들과 쿼리문들은 Persistence Context에 저장
3. commit 명령 -> flush() 호출
4. 변경 내용을 DB와 동기화 (SQL 저장소의 쿼리 실행)
5. DB에게 commit 쿼리문 명령
```java
EntityManager em = factory.createEntityManager(); // EntityManager 객체를 생성하여 Entity 객체 관리
try {
    em.getTransaction().begin(); //데이터 변경은 트랜잭션 안에서 이뤄져야하기에 begin
    em.persist(vo); // 영속성 컨텍스트에 임시 저장
    em.getTransaction().commit(); // flush()호출 DB로 저장
} catch (Exception e) {
    result = false;
}
em.close();
```

### 엔티티 조회
![](/TIL/image/2023-05-15-18-18-44.png)
1. 자바 어플리케이션에서 JPA에게 DB 조회를 부탁 -> 영속성 컨텍스트에서 엔티티를 찾음
2. 있으면 엔티티를 넘김
3. 없는 엔티티 조회를 부탁했으면 쿼리문을 사용해 DB에서 찾아옴
4. 영속성 컨텍스트에 엔티티로 저장하고 넘김
```java
EntityManager em = factory.createEntityManager();
TypedQuery<Visitor> q = em.createQuery("select t from Visitor t", Visitor.class); 
List<Visitor> list = q.getResultList();
em.close();
```

### 엔티티 변경
![](/TIL/image/2023-05-15-18-32-42.png)
1. 자바 어플리케이션에서 커밋 명령 -> Persistence Context에 자동으로 flush() 호출
2. 엔티티와 스냅샷을 비교해 변경된 엔티티를 찾음
   - 스냅샷 : 엔티티를 Persistence Context에 보관할 때 복사해둔 최초의 상태
3. 변경된 엔티티가 있으면 DB에 변경사항을 저장하기 위해 쿼리 생성
4. 변경 내용을 DB와 동기화
5. DB로 commit
```java
EntityManager em = factory.createEntityManager();
try {
    em.getTransaction().begin();
    Visitor oldVo = em.find(Visitor.class, vo.getId()); // 기존의 엔티티를 불러옴
    System.out.println(oldVo.getName());
    oldVo.setName(vo.getName()); // 이름을 변경
    oldVo.setMemo(vo.getMemo()); // 메모를 변경
    em.getTransaction().commit(); // commit
} catch (Exception e) {
    result = false;
}
em.close();
```
- 개발자는 만약 이름을 변경하고싶다면 `setName`만 내용만 변경하고 싶다면 `setMemo`만 실행하면 됨
- 나머지는 JPA가 알아서 처리
- 엔티티의 변경 사항을 DB에 자동으로 반영하는 기능 **변경 감지**

### 엔티티 삭제
1. 자바 어플리케이션에서 엔티티 삭제 명령
2. SQL 저장소에 delete 쿼리 생성
3. 커밋 명령이 들어오면 자동으로 flush() 호출
4. 변경내용을 동기화
5. DB에 commit
```java
EntityManager em = factory.createEntityManager();
try {		
	em.getTransaction().begin();
	Visitor vo = em.find(Visitor.class, id); // id로 visitor entity 찾아옴
	em.remove(vo); // remove 명령
	em.getTransaction().commit(); // commit
} catch (Exception e) {
	result = false;
}
em.close();
```
---

## JPQL 구문
### JPQL
- 엔티티 객체를 조회하는 객체지향 쿼리
- 문법은 SQL과 비슷
- SQL은 DB 테이블 대상으로 JPQL은 엔티티 객체를 대상으로 쿼리
- JPQL은 SQL을 추상화하여 특정 DB에 의존하지 않음
- JPQL은 실행 시 SQL로 변환
- JPQL은 EntityManager의 createQuery() 메소드로 활용
### 기본 문법
```
select_문 :: =
            select_절
            from_절
            [where_절]
            [groupby_절]
            [having_절]
            [orderby_절]
```
1. Query 문
   ```
   select m from Member as m where m.username = 'Hello'
    ```
   - **엔티티와 속성**은 대문자를 구분 JPQL 키워드는 대소문자 구분 x
   - JPQL에서 사용한 Member는 엔티티명
   - 엔티티명은 `@Entity(name="")`로 지정 가능
   - 별칭
     - JPQL은 별칭이 필수
     - as 생략 가능
2. 집합
   - GROUP BY : 통계 데이터 구할 때 특정 그룹끼리 묶음
   - HAVING : GROUP BY와 함께 사용
     - 그룹화한 통계 데이터를 기준으로 필터링
   - 집합 함수
  
        | 집합함수 | 설명 | return type
        | ------- | ---- | --------
        | COUNT | 결과 수를 구함 | Long
        | MAX, MIN | 최대, 최소 값을 구함<br>문자, 숫자, 날짜 등에 사용 |
        | AVG | 평균값을 구함 | Double
        | SUM | 합을 구함, 숫자 타입만 사용 가능
    - null 값은 무시됨
    - DISTINCT를 사용해서 중복된 값 제거 가능
    ```java
    select COUNT(DISTINCT m.age) from Member m GROUP BY m.age;
    ```

3. 정렬
   - ORDER BY : 결과를 정렬할 때 사용
   - ASC : 오름차순
   - DESC : 내림차순
    ```java
    select m from Member m order by m.age DESC, m.username ASC
    ```
4. 서브쿼리
   - JPQL도 SQL처럼 서브쿼리 지원
   - WHERE, HAVING 절에서만 사용 가능
5. 쿼리 객체
   - 작성한 JPQL을 실행하기 위한 쿼리 객체
   - **TypedQuery**
     - 반환할 타입을 명확하게 지정할 수 있을 때 사용
    ```java
    TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
    ```
    - 반환 타입이 Member.class임 명확함 
   - **Query**
     - 반환 타입을 명확하게 지정할 수 없을 때 사용
     - 조회 대상이 둘 이상이면 Object[]를 반환
     - 하나면 Object 반환
    ```java
    Query query = em.createQuery("select m.username, m.age from Member m");
    ```
    - Member 테이블의 usertname과 age만 담고 있는 entity는 없음 -> 타입이 명확하지 않음
    - 2개 이상의 컬럼을 조회하기때문에 Object[]가 리턴
        - 각각의 컬럼이 Object[] 형식으로 리턴되는것
    ```java
    List<Object[]> resultList = query.getResultList()
    ```
    - Object[] 타입의 List에 결과값을 담아 사용
6. 결과 조회 API
    ```java
    query.getResultList()
    ```
    - 결과가 하나 이상 일 때 또는 몇 개일지 예측할 수 없을 때 사용
    - 결과가 없으면 빈 리스트 반환
    ```java
    query.getSingleResult()
    ```
    - 결과가 정확히 하나일 때, 단일 객체 반환
    - 결과가 없으면 javax.persistence.NoResultException
    - 둘 이상이면 javax.persistence.NonUniqueResultException
    ```java
    // TypedQuery
    TypedQuery<Member> query = em.createQuery("select m from Member as m where m.id = 1L", Member.class);
    Member result = query.getSingleResult();
    // Member 타입임을 알고 있으니 Member 객체로 받을 수 있음
    ```
7. 파라미터 바인딩
   - 동적 파라미터
   - 이름 기준, 위치 기준 2가지 파라미터 바인딩 지원
   - 이름 기준
     - 파라미터를 이름으로 구분하는 방법
       - 이름 기준 파라미터 앞에 `:`를 사용
    ```java
    TypedQuery<Member> typedQuery = em.createQuery("select m from Member m where m.username =:username", Member.class)
    typedQuery.setParameger("username", "소영");
    List<Member> list = typedQuery.getResultList();
    ```
    - 위치 기준
      - 파라미터를 위치로 구분하는 방법
      - `?` 다음에 위치 값
      - 위치값은 1부터 시작
    ```java
    TypedQuery<Member> typedQuery = em.createQuery("select m from Member m where m.username =?1", Member.class)
    typedQuery.setParameger(1, "소영");
    List<Member> list = typedQuery.getResultList();
    ```
    - 위치 기준 파라미터 방식 보다는 이름 기준 파라미터 바인딩 방식을 사용하는 것이 더 명확
8. 프로젝션
    - SELECT 절에 조회할 대상을 지정하는 것
    - 엔티티 프로젝션
      - 원하는 객체를 조회한다고 생각
      - 조회한 엔티티는 영속성 컨텍스트에서 관리
    - 여러값 조회
      - 원하는 데이터들만 선택해서 조회 가능
9.  페이징 API
    - JPA에서는 페이징을 두 API로 추상화
    ```java
    setFirstResult(int startPosition) // 조회 시작 위치
    setMaxResult(int maxResult) // 조회할 데이터 수
    ```
---
## JPA 기본키 매핑
- 기본키를 매핑하는 방법은 2가지
- 직접 할당
  - `@Id` 어노테이션만 사용해서 직접 할당
- 자동 생성
  - `@Id`와 `@GeneratiedValue`를 추가하고 원하는 키 생성 전략을 선택
  - MySQL의 AUTO_INCREMENT 같은 기능
### 기본키 자동 생성 전략
- IDENTITY
  - 기본키 생성을 DB에 위임
- SEQUENCE
  - DB 시퀀스를 사용해서 기본키 할당
- TABLE
  - 키 생성 테이블을 사용
- AUTO
  - 선택한 DB에 따라 IDENTITY, SEQUENCE, TABLE 중 하나를 자동으로 선택
---
## 오늘의 팁
### int와 integer의 null처리
- int는 원시유형의 변수라 null 값이 들어갈 수 없음
- integer는 객체라 null 값이 가능
- 만약 DB에서 null을 허용하지않는 컬럼은 int로 처리해도 되지만 만약 null 값이 들어올 수 있다면 integer로 해야함

---
## 회고
오늘 오랜만에 사용자 입력을 받고 실습에서 stream과 forEach를 사용했다. 정확히 사용법을 알고 있다고 생각했는데 막상 코딩해보니 어렴풋이 떠올라 당황스러웠다. 한번 사용하더라도 제대로 사용할 수 있도록 복습을 더 열심히 해보자