# 230421_Spring_day3
## 목차

---
## IoC 설정 - XML 설정
### autowire
- bean 태그 내에 작성하는 태그
- setter injection property 태그를 생략하고 작성 가능
  - `autowire="byName"` - 이름으로 injection
  - `autowire="byType"` - 타입으로 injection
  - `autowire="constructor"` - 생성자를 통해서 injection
- property 태그를 생략해서 작성할 수는 있지만 세세한 제어는 어렵다는 단점
```java
public class UserShow{
    private User user;
    public UserShow(User user) {
            super();
            this.user = user;
            System.out.println("UserShow 객체 생성(User 객체 전달)");
    }
        
    public void setUser(User user1) {
        System.out.println("UserShow 객체의 setUser() 호출(User 객체 전달)");
        this.user = user1;
    }
}
```
- byName은 setter 메소드 뒤에 붙는 위 경우에서는 setUser중 User와 동일한 이름을 가진 멤버가 있다면 해당 setter를 호출하는 것
- byType은 argument의 type과 동일한 type을 가진 setter를 호출하는 것
- constructor는 생성자 UserShow를 호출
---
## IoC 설정 - ANNOTATION 설정
- 소스 안에 정해진 ANNOTATION 들을 사용
- 작성된 어노테이션이 적용되려면 설정 파일에 다음 내용이 정의되어야함
```xml
<context:component-scan base-package="xxx" />
```
- xxx라는 패키지 내의 파일들이 어노테이션이 적용된 소스이니 스캐닝하라는 의미
- Spring IoC container가 모든 패키지를 스캔할 수는 없기 때문에 반드시 정의해야함
### Annotation 종류
- @Component
  - 클래스에 정의할 수 있는 Annotation
  - bean 태그를 작성한것과 동일함 --> 클래스를 bean 객체로 등록
  - default - singleton
  - @Component만 작성 시 클래스의 맨앞 대문자를 소문자로 변경한 이름으로 bean 객체 생성
  - @Component("xxx") - bean 객체 생성 시 xxx라는 이름으로 생성한다는 의미

- @Scope
  - bean의 범위를 singleton이 아닌 다른 범위로 지정하고자 할 때 사용
  - `@Scope(value="prototype")` 형식으로 사용
  
- @Autowired
  - 의존관계를 자동으로 설정할 때 사용
  - 생성자, 필드, 메소드 세 곳에 적용
    - 생성자 메소드 앞, 멤버 변수 앞, 일반 메소드(Setter를 포함한 다른 메소드 모두) 앞 
  - 타입을 이용한 property 자동 설정 기능 제공
  - xml 설정 중 bean 태그 내 작성한 autowire와 유사
  - byType 형식으로 타입이 동일한 생성자, 필드, 메소드가 있는지 먼저 찾음
  - 만약 동일한 타입에 해당하는 객체가 없으면 예외 발생 -> required=ture가 default로 적용되어있기때문
  - 동일한 타입이 여러개라면 그 타입 중 동일한 이름을 찾아(byName) 적용시킴
  - Component annotation을 반드시 작성해야함


- @Qualifier
  - @Autowired와 함께 사용
  - bean의 타입이 아닌 이름으로 주입하려는 경우 사용
    ```java
    @Autowired
    @Qualifier("mytest") //mytest라는 이름으로
    private Test test;
    ```
- @Resource
  - @Autowired와 동일한 기능, byName을 사용
- @Inject
  - 특정 FW에 종속되지않은 어플리케이션을 구성하고자 할 때 사용

---
## Spring boot