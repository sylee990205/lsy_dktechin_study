# 230417_Spring_day1
## 목차
<!-- TOC -->

- [230417\_Spring\_day1](#230417_spring_day1)
  - [목차](#목차)
  - [Spring Framework](#spring-framework)
  - [스프링의 특징과 구조](#스프링의-특징과-구조)
    - [IoC](#ioc)
    - [DI](#di)
    - [DL](#dl)

<!-- /TOC -->
---
## Spring Framework
- 자바 기반의 **애플리케이션 프레임워크**로 **엔터프라이즈급 애플리케이션을 개발** 하기 위한 **다양한 기능을 제공**
- 애플리케이션 개발에 필요한 기반을 제공해서 **개발자가 비즈니스 로직 구현에만 집중**할 수 있게 함
- 기능별로 구분된 약 23개 정도의 모듈로 구성
---
## 스프링의 특징과 구조
- DI와 DL을 통해 IoC 기술을 하는것이 스프링의 base

### IoC
- 제어 역전
- Inversion of Control
- Spring 프로그래밍 전에 반드시 설정해야하는 것
```java
@Controller
public class NoDIController {
    private MyService service = new MyServiceImpl();

    @GetMapping("/xxx")
    public String getHello() {
        return service.getHello();
    }
}
// 객체를 선언하고 해당 객체의 의존성을 생성한 후 객체에서 제공하는 기능을 사용하는 코드
```
- 객체를 생성하고 사용하는 일련의 작업을 개발자가 직접 제어
- IoC를 적용한 환경에서는 사용할 객체를 직접 생성하지 않고 **객체의 생명 주기 관리**를 **'스프링 컨테이너에 위임**
- 제어 역전: 객체의 관리를 컨테이너에 맡겨 제어권이 넘어간 것
- 제어 역전을 통해 DI(의존성주입), AOP(관점지향프로그래밍) 등이 가능

### DI
- 의존성 주입
- Dependency Injection
- IoC의 방법 중 하나
- 사용할 객체를 직접 생성하지 않고 외부 컨테이너가 생성한 객체를 주입받아 사용하는 방식
- 생성자를 통한 의존성 주입
- 필드 객체 선언을 통한 의존성 주입
- setter 메서드를 통한 의존성 주입


### DL
- Dependency Lookup