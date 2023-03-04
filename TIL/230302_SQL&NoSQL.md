## Database
### Database 정의
- 한 조직의 **여러 응용 시스템들이 공용**하기 위해 **통합**하고, 저장한 운영 데이터의 집합
- 은행, 대학, 항공사 등 거의 모든 곳에서 사용
### DBMS
 - DBMS
   - Databaste Management System (DBMS), 데이터베이스 관리 시스템
 - DBMS Client Tools
   - MYSQL : Workbench
   - TOAD, Orange, SQL Gate for oracle, SQL Developer
   - 도구 하나를 사용하면 다른 것들에 대한 접근성이 높아짐.
---
## SQL
### MySQL
오픈소스 RDBMS, 현재는 오라클이 관리
1. 특징
   - 가볍다.
   - 사용자 보안 기능과 권한 기능 사용 가능
   - 하나의 테이블에 64개까지의 인데스를 생성할 수 있고, 하나의 인덱스에 16개까지의 컬럼을 지정할 수 있음.
   - 
### SQL
1. ERD (E-R 다이어그램)
   - Entity Relationship
   - Qurey에 역공학을 적용하면 ERD를 확인할 수 있다.
   - 하나하나가 entity이자 table
   - 1:1, 1:N, N:N 관계를 확인할 수 있음.
2. 관계형 모델
    | Key Term         | 설명                          |
    | ---------------- | --------------------------- |
    | 데이터베이스(Database) | Realation의 집합               |
    | 릴레이션 Realation   | Tuple의 집합                   |
    | 튜플(Tuple)        | 테이블의 Row, Record                    |
    | 애트리뷰트(Attribute) | 릴레이션의 특징을 나타내는 단일한 데이터      |
    | 도메인(Domain)      | 특정 Attribute가 가질 수 있는 값의 집합 |
   - Realation
     - 튜플과 애트리뷰트 간 순서가 없다
     - 집합이기에 동일한 튜플이 존재하지 않는다
   - Attribute
     - 원자값이여야한다.
     - 값의 집합 등을 가질 수 없다.
   - Schema
     - db의 구조 정의
   - Null
     - 값이 지정되지 않았음을 의미한다. 0이 아니고 지정되지 않았음. 지정될 수 있다는 것
     - 모든 Domain은 Null값을 포함
     - 어떠한 데이터 타입에도 사용 가능
     - Null을 포함한 산술식의 값은 Null -> 정해지지 않았기 때문에
   - Key
     - 릴레이션에는 동일한 튜플이 존재할 수 없음
     - 하나의 튜플을 다른 튜플과 구별하기 위한 키가 필요
     - 
         | Key             | 뜻   | 설명                                                                                                                                |
         | --------------- | --- | --------------------------------------------------------------------------------------------------------------------------------- |
         | Primary Key     | 기본키 | - 릴레이션에서 튜프릉르 구분하기 위해 사용하는 **기본키**<br>\- 동일한 기본키를 지닌 레코드는 존재할 수 없다.<br>- 두 개의 컬럼이 Primary Key가 될 수 있음                       |
         | Candidate Key   | 후보키 | - 튜플을 식별할 수 있는 최소한의 애트리뷰트의 집합<br>- 유일성과 최소성이 충족되는 키<br>- 기본키의 후보가 되는 키라서 후보키                                                   |
         | Alternative Key | 대체키 | - 후보키 중 기본키가 아닌 속성                                                                                                               |
         | Composite Key   | 복합키 | - 둘 이상의 애트리뷰트가 하나의 Key를 이루는 경우를 의미                                                                                               |
         | Foreign Key     | 외래키 | - 다른 릴레이션의 기본키를 참조하는 키<br>- 다른 릴레이션의 튜플을 저장, 관리<br>- 릴레이션 간의 관계를 나타내기 위하여 사용<br>- 1:N 관계에서 1쪽의 기본키가 N쪽의 컬럼이 된다<br>- Null이 가능 |
3. 실행 순서
   - FROM - WHERE - SELECT - ORDER BY 순서로 실행된다.
   - SQL 작성 시는 select 절부터 작성하지만 실행은 From 절부터 시작된다.
4. SELECT
   ```sql
   select *
   from employees;
   ```
   - from 절에 작성한 테이블을에서 출력할 값을 지정하는 구절
   - '*' 는 전체라는 의미
5. WHERE
   - 조건을 부여한다.
   - 산술, 비교, 논리 연산자 사용 가능

      | 연산자                  | 설명                                                   | 예시                                                                                                                                                                                                                         |
      | -------------------- | ---------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
      | IN                   | list 중 하나<br>조건을 여러개 중에 있다는 식으로 사용하고 싶을 때            | department_id in (10, 20, 30)                                                                                                                                                                                              |
      | BETWEEN a AND b      | a와 b 사이<br>a와 b도 포함                                  | salary 2000 and 3000                                                                                                                                                                                                       |
      | LIKE                 | 문자열 부분 검색<br>% : 모든 문자<br> \_ : 한 글자                 | like '%k%' #앞뒤에 무슨 글자가 오던지 K를 포함한 ROW<br>like '%K' #앞에 무슨 글자가 오던지 K로 끝나는 문자가 있는 ROW<br>lke 'K%' #뒤에 무슨 글자가 오던지 K로 시작하는 문자가 있는 ROW<br>like '_K%' 앞에 한글자 뒤에 K가 있는 ROW<br>like '_K_' K #앞 뒤로 1개의 문자가 있는 ROW<br>like 'K' #K만 가진 ROW |
      | IS NULL, IS NOT NULL | null 인지 null이 아닌지 검색                                 | manager_id is null<br>manager_id is not null                                                                                                                                                                               |
      | AND                  | 둘 다 만족시켜야하는 경우                                       | salary > 1000 and department_id = 20                                                                                                                                                                                       |
      | OR                   | 둘 중 하나만 만족시키면 되는 경우                                  | salary > 1000 or department_id = 20                                                                                                                                                                                        |
      | NOT                  | 만족하지않음                                               | department_id NOT 10                                                                                                                                                                                                       |
      | ANY, ALL             | 집합 중 어느 하나, 집합 중 모든 열                                | department_id = ANY(10,20,30)<br>salary > ALL(300, 400, 900)                                                                                                                                                               |
      | EXISTS               | 존재 유무에 따라<br>서브쿼리를 사용할 때 서브쿼리에 데이터가 존재한다면 TRUE 라는 의미 | where EXISTS (select 1<br>from departments<br>where department_id in (10,20,30))<br>\# 부서번호가 10,20,30 중 하나라도 있다면 True를 반환한다. 그럼 where 절 조건 충족                                                                              |
   - 연산자 우선순위
       - 연산자는 산술-> 비교 -> 논리 순으로 우선 순위를 가진다.
       - 논리 연산자는 NOT -> AND -> OR 순으로 우선 순위를 가진다.
       - 기본적으로 우선 순위를 따르나 먼저 적용하고싶은 연산이 있다면 해당 연산을 ()로 감싸면 된다.
6. ORDER BY
   ```sql
   select *
   from employees
   where (department_id = 70 or department_id = 80) and last_name like 'K%'
   order by 1 desc; #숫자 1은 select 절에 등장하는 컬럼 중 첫번째 컬럼을 의미
   ```
   - 결과를 정렬한다.
   - ASC - 오름차순, DESC - 내림차순
   - 컬럼 이름대신 SELECT 절 상에서의 순서(1,2,3)으로도 사용 가능하다.

7. MYSQL 내장 함수
   - IFNULL
      ```SQL
      select ifnull(department_name,"없음")
      from departments;
      ```
   - 날짜 데이터 타입
      ```sql
      select now(), sysdate();
      ```
    - 날짜 연산
      - 더하기
         ```sql
         select date_add(now(), interval 1 day) #현재 날짜로부터 1일 뒤
         ```
         - date_add와 interval을 사용하며 원하는 숫자와 day, month, year를 선택해 작성한다.
      - 빼기
         ```sql
         select date_sub(now(), interval 1 year) #현재 날짜로부터 1년 전
         ```
8. SQL 문자열 함수
   - 문자열 함수를 간단하게 요약하면 다음과 같다.
      | 문자열함수              | 설명                        |
      | ------------------ | ------------------------- |
      | CONCAT(s1, s2)     | 문자열 결합                    |
      | LOWER(s), UPPER(s) | 대소문자 변경                   |
      | REPLACE(s,p,r)     | s 속 p 문자열을 r로 치환          |
      | SUBSTR(s,m,n)      | s 문자열 속 m부터 길이 n인 문자열을 변환 |
      | LENGTH(s)          | 문자열 길이 반환                 |
9.  SQL 숫자 함수 
      | 숫자 함수      | 설명               |
      | ---------- | ---------------- |
      | ABS(n)     | n의 절대값           |
      | MOD(m,n)   | m/n의 나머지         |
      | POWER(m,n) | m의 n승            |
      | ROUND(m,n) | 소수점 아래 n자리까지 반올림 |
      | TRUNC(m,n) | 소수점 아래 n자리 미만 버림 |
10. 변환 함수
    - 변환 함수가 없어도 어느 정도 자동적으로 변환
    - 변환되지 않는 경우 명시적 변환 함수 사용
    - DATE_FORMAT
      ```sql
      select date_format(now(),'%y-%m-%d');
      ```
       - 2023년일 때 %y면 23만 %Y면 2023으로 출력

11. 집계 함수
    - 여러 행으로부터 하나의 결과 값을 반환한다.
    - AVG, COUNT, MAX, MIN 등이 해당된다.
    - select 절에 집계함수와 grouping 되지 않은 컬럼을 동시에 입력할 수 없다.
    - group by 를 사용해야 가능.
    - 집계 함수를 사용한 조건은 having 절로 가능. where 절에는 집계 함수를 사용한 조건의 사용이 불가능
    - 집계 함수에는 Null 값이 포함되지 않는다.
12. CASE
    ```sql
    select last_name, salary, 
         case when salary < 5000 then 'D'
            when salary < 7000 then 'C'
               when salary < 10000 then 'B'
               when salary < 15000 then 'A'
               else 'S'
         end sal_grade
    from employees;
    ```
    - S,A,B,C,D 라는 값이 들어간 컬럼은 없지만 그렇게 표기하고 싶을 때 사용할 수 있다.
    - SELECT 절 외에도 GROUP BY 절, ORDER BY 절에도 사용 가능하다.
    - 중첩해서 사용 가능하다.
13. Top n Query
    - 입사일자가 가장 빠른 직원 3사람을 출력, 급여가 가장 작은 3명을 출력하는 경우에 사용
14. **JOIN**
    - 둘 이상의 테이블에 흩어져 있는 데이터를 서로 연결하여 하나의 쿼리에서 조회
    - 주로 Foreign Key를 이용하여 참조한다.
      | 종류         | 설명                                                                                                                                                                                                                    |
      | ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
      | Cross Join | 모든 조합 조회                                                                                                                                                                                                              |
      | Inner Join | Join 조건을 만족하는 튜플만, (기본적으로 Inner Join임)                                                                                                                                                                                |
      | Outer Join | Join 조건을 만족하지 않는 튜플도 Null 과 함께 조회<br>Left Outer Join - 왼쪽 테이블의 튜플 중 Join 조건을 만족시키지 못하는 Null도 조회<br>Right Outer Join - 오른쪽 테이블의 Null 을 포함한 모든 튜플 조회<br>Full Outer Join - 양쪽 테이블 내부의 데이터 중 Join 조건을 만족시키지 못하는 모든 ROW 조회 |
      | Self Join  | 자기 자신과 조인한 결과 조회                                                                                                                                                                                                    
15. 서브 쿼리
    - 서브 쿼리로 사용할 query가 여러개의 결과값을 도출할 땐 =을 사용할 수 없다. in을 사용해야함.
    - 
16. 인덱스
    - 어떤 컬럼에 저장되어 있는 값들이 실제 테이블 어느 위치에 있는지 알 수 있다.
    - Primary key 는 자동으로 index가 만들어진다.
    - MYSQL의 경우 참조키도 자동으로 index가 만들어짐
    - 인덱스가 걸려있는 컬럼을 변형하면 인덱스를 사용할 수 없다.
---
## NoSQL
- Big Data의 정의 4개의 V (Volume, Velocity, Variety, Veracity)에 더하여 다섯번째 V로 Value를 제시 
- Non Relational 이라는 의미
- RDB 구조와는 다른형태로 데이터를 저장하여 관리
- SQL이 아니다 라는 의미이지만, Not only SQL이라는 의미를 부여하기도 함.
- 키-밸류, 그래프, 문서 등등
### MongoDB
- 문서 구성
  
    | 구성         | 설명                   |
    | ---------- | -------------------- |
    | Collection | 데이터가 저장되는 장소 (테이블)   |
    | 태그         | 구분자                  |
    | Meta Data  | 구조화된 정보를 다루는 값       |
    | 디렉토리 구조    |                      |
    | 버킷         | 하나의 주소를 갖는 파일 하나의 구역 |
  ```
  > db.emps.insert({emp_id:1, last_name:'King'});
  ```
  - db 안에 여러 Collection(emps)이 있으며 Collection 안에 Document({emp_id:1, last_name:'King'})가 있다.
  - Document는 JSON 형태를 띈다.
