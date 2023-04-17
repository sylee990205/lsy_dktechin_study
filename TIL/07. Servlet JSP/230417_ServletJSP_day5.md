# 230417 ServletJSP day5
## 목차

<!-- TOC -->

- [230417 ServletJSP day5](#230417-servletjsp-day5)
  - [목차](#목차)
  - [SSR vs CSR](#ssr-vs-csr)
  - [Filter](#filter)
    - [구현](#구현)
  - [JUnit](#junit)
    - [어노테이션](#어노테이션)
    - [Assertions](#assertions)
    - [Assumptions](#assumptions)
  - [오늘의 Tip](#오늘의-tip)
    - [import static](#import-static)

<!-- /TOC -->
---
## SSR vs CSR
- SSR : Server Side Rendering
  - Spring MVC
- CSR : Client Side Rendering
  - Spring Rest

---
## Filter
- 웹 클라이언트에서 요청한 웹 자원들이 `수행되기 전` 또는 웹 자원들이 수행된 이후에 수행되는 객체
- 웹 컴포넌트 중 하나
- 클라이언트가 직접적으로 요청할 수 없음
- request 또는 response에 영향을 주거나 특정 처리 가능
- 유지보수 시 정말 유용함
- 어떤 처리가 요청 시점에 일어났으면 좋겠을 때
  - Filter가 없던 시절 Servlet 별로 작성
- 웹 자원이 순서대로 하나 또는 두 개 이상의 Filter 들의 chain에 의해 필터링 되도록 설정 가능
### 구현
- javax.servlet.Filter라는 인터페이스를 상속해야함
- 이전에는 init(), destroy()도 오버라이딩해야했지만 이제는 default method로 doFilter()만 오버라이딩하면 됨
```java
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
 // 웹 자원의 수행 전에 처리할 기능
 chain.doFilter(req, res);
 // 웹 자원의 수행 후에 처리할 기능
}
```
- chain.doFilter에 의해 다음에 실행될 Servlet이 호출되는 것, chain을 안하면 Filter만 응답
  - 이 때의 req와 res는 다음에 실행될 Servlet 혹은 Filter에 대한 응답

---
## JUnit
- Java 언어를 위한 테스트 프레임워크
- 클래스에 구현된 메서드가 주어진 기능을 제대로 수행하는지 단위 테스트 처리

### 어노테이션
| 어노테이션  | 설명                                                     |
| ----------- | -------------------------------------------------------- |
| @Test       | 테스트 메서드를 나타내는 어노테이션 **(필수)**           |
| @BeforeEach | 각 테스트 메서드 시작 전에 실행되는 메서드               |
| @AfterEach  | 각 테스트 메서드 종료 후에 실행되는 메서드               |
| @BeforeAll  | 테스트 시작 전에 실행되는 메서드(static 메서드여야만 함) |
| @AfterAll   | 테스트 종료 후에 실행되는 메서드(static 메서드여야만 함) |
| @Disabled   | 실행되지 않아야 하는 테스트 메서드                       |


### Assertions
- 사전적 의미로 주장이라는 뜻
- 테스트가 원하는 결과를 제대로 리턴하는지 에러는 발생하지 않는지 확인할 때 사용하는 메서드
- 테스트하고 싶은 인자 값을 넣었을 때 예상한 결과가 나오는지 테스트 해볼 경우 사용

| 메서드명                       | 설명                                                                                                              |
| ------------------------------ | ----------------------------------------------------------------------------------------------------------------- |
| fail                           | 무조건 실패 (레거시에 사용하면 좋다.)                                                                             |
| assertTrue                     | 조건이 성공이면 True                                                                                              |
| assertFalse                    | 조건이 실패면 True                                                                                                |
| assertNull                     | 조건이 Null이면 True                                                                                              |
| aseertNotNull                  | 조건이 Not Null이면 True                                                                                          |
| assertEquals(expected, actual) | expected와 actual이 동일하면 True                                                                                 |
| assertArrayEquals              | 두 Array가 동일하면 True                                                                                          |
| assertIterableEquals           | 두 Iterable이 동일하면 True                                                                                       |
| assertLinesMatch               | 두 Stream이 동일하면 True                                                                                         |
| assertNotEquals                | expected와 actual이 다르면 True                                                                                   |
| assertSame                     | 동일한 Object면 True                                                                                              |
| assertNotSame                  | 다른 Object면 True                                                                                                |
| assertAll                      | 여러 Assertion이 True면 True                                                                                      |
| assertThrows                   | 예상한 에러가 발생하면 True                                                                                       |
| assertDoesNotThrow             | 에러가 발생하지 않으면 True                                                                                       |
| assertTimeout                  | - 테스트가 지정한 시간보다 오래 걸리지 않으면 True<br>- 지정한 시간보다 오래 걸려도 테스트가 끝날 때까지 **대기** |
| assertTimeoutPreemptively      | - 테스트가 지정한 시간보다 오래 걸리지 않으면 True<br>- 지정한 시간보다 오래 걸린 경우 바로 테스트 **종료**       |

### Assumptions
- 사전적 의미로 추정이라는 의미
- 메서드별 조건을 만족할 경우 진행시키고 아닌 경우 스킵하는 메서드
- if 문과 비슷한 용도로 사용

| 메서드명                          | 설명                                                                                                                |
| --------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| assumeTrue                        | 테스트가 실패하면 에러 발생                                                                                         |
| assumeFalse                       | 테스트가 성공하면 에러 발생                                                                                         |
| assumingThat(boolean, executable) | - 첫 번째 인자가 True면 두 번째 인자로 들어온 함수 실행<br>- 첫 번째 인자가 false면 두 번째 인자로 들어온 함수 실행 |

---
## 오늘의 Tip
### import static
- 메소드 사용시 클래스명을 붙이지않고 사용할 수 있게하는 구문
```java
//import static 구문을 사용하면
import static java.time.Duration.ofSeconds;
// 이렇게 바로 사용 가능
ofSeconds()

// import가 아니면 이렇게 호출해야했음
Duration.ofSeconds();

```
- import static 구문은 편하지만 가독성이 떨어진다는 단점이 있음