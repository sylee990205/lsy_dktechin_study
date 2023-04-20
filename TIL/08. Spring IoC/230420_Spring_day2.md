# 230417_Spring_day1
## 목차
<!-- TOC -->

- [230417\_Spring\_day1](#230417_spring_day1)
  - [목차](#목차)
  - [Spring IoC와 DI](#spring-ioc와-di)
    - [Spring DI](#spring-di)
    - [Spring IoC 컨테이너 초기화](#spring-ioc-컨테이너-초기화)
    - [DL의 예](#dl의-예)
    - [DI의 예](#di의-예)
  - [IoC 설정](#ioc-설정)
    - [XML 설정](#xml-설정)
      - [DTD](#dtd)
      - [bean 태그 내 단축형](#bean-태그-내-단축형)
  - [오늘의 Tip](#오늘의-tip)
    - [선언적 프로그래밍](#선언적-프로그래밍)
    - [싱글톤](#싱글톤)

<!-- /TOC -->
---
## Spring IoC와 DI
- 객체를 필요로 하는 곳에 **주입**하는 것, 객체를 찾을 때 **제공**하는 것 모두 Spring FW가 대신 처리
- Spring FW에 의해 관리되는 Java 객체를 **bean**
  - Spring Container가 대신 생성해주는 Java 객체
### Spring DI
  - 객체간의 *결합도를 느슨*하게 하는 스프링 핵심 기술
    ![](/TIL/image/2023-04-20-09-11-58.png)
  - 원래 기본 DI는 Setter injection과 Constructor injection 두가지
### Spring IoC 컨테이너 초기화
```java
ApplicationContext context = new ClassPathXmlApplicationContext("빈 설정 파일");
```
- bean 객체를 만들 때 설정파일과 Annotation에 적용된 기본 설정을 포함해서 생성해달라고 요청하는 것
- 이 때 bean 설정 파일은 xml 형식

### DL의 예
`타입명 bean=(타입명)context.getBean("빈이름");`
- Maven 프로젝트일 때는 bean 설정 파일은 resources에 있어야 적용됨

### DI의 예
1. Construction Injection: 생성자를 통해서 객체 바인딩(의존관계를 연결)
2. Setter Injection: setter 메서드를 이용해서 객체 바인딩(의존관계를 연결)
3. method Injection: 어노테이션을 정의한 메서드를 이용해서 객체 바인딩(의존관계를 연결)
4. field Injection: 어노테이션을 정의한 메서드를 이용해서 객체 바인딩(의존관계를 연결)

---
## IoC 설정
### XML 설정
- 설정 정보를 변경할 때는 XML만 변경하면 도미
- 많은 프레임워크의 라이브러리가 XML 스키마를 이용한 설정의 편리함 지원
- 프로젝트 규모에 따라 XML 문서의 내용이 많아짐
- 코드를 실행해야 설정 정보의 오류 확인 가능
```xml
<bean id="messageBean1" class="sample1.MessageBeanImpl" > <!--  -->
    <constructor-arg> 
        <value>aaa</value> <!-- argument로 value 내의 값이 올 때 호출된다는 의미로 설정 -->
    </constructor-arg> 
    <property name="xxx">  <!-- xxx라는 이름을 가진 변수의 setter method를 -->
        <value>3000</value> <!-- 해당 값으로 초기화 하겠다는 의미 -->
    </property> 
    <property name="xxx"  value="3000" />	<!-- 태그 내 직접 정의 가능 -->
</bean>	
```
- `<bean>`태그
    - Spring IoC 컨테이너가 관리할 Bean 객체(자바 클래스) 설정

    | 속성 | 설명 |
    | --- | --- |
    | id | 주입 받을 곳에서 호출할 이름 |
    | class | 주입할 객체의 클래스 명 | 
    | factory-method | 객체 생성시 사용될 factory 메소드<br>bean으로 등록하고자하는 객체가 추상class의 객체일 때는 생성자를 통하여 객체 생성이 불가능 -> factory 메소드를 사용하여 객체를 생성해야함 -> 이 때 사용할 factory 메소드를 설정하는것<br>*생성자를 통한 객체 생성이 불가능할 때 사용한다고 생각하자!*
    | scope | Bean 객체의 유효 범위 설정<br>default 값은 singleton- singleton 객체는 bean 설정 파일로 IoC 컨테이너 초기화 작업을 할 때 미리 생성<br>만약 객체를 미리 생성하지않고 호출하면서 생성 하고 싶다면 prototype으로 설정
- `<constructor-arg>` 태그
  - `<bean>`의 하위 태그
  -  다른 bean 객체 또는 값을 생성자를 통해 주입하도록 설정
  - argument로 객체를 주입할 때 
    ```xml
    <ref bean = "bean name"/>
     <!-- 이때 bean name은 constructor-arg 태그의 속성 id 값--> 
    ```
  - argument로 문자(String), Primitive data를 주입할 때
    ```xml
    <value>값</value>
    <value type="int(등등등)">값</value>
    <value index="1">값</value><!-- argument가 여러개일 때 몇번째 argument의 값인지 설정하는 것 -->
    ```
- `<property>` 태그:
  - `<bean>`의 하위 태그
  - 다른 bean 객체 또는 값을 setter 메서드를 통해 주입하도록 설정
  - ref 속성과 value 속성이 있으며 사용법은 constructor-arg 태그와 동일
#### DTD
- xml 구조의 유효성 체크를 위해 xml 최상단에 작성하여 xml 문서의 구조를 정의하는 방법
#### bean 태그 내 단축형
- DTD 영역에 `xmlns:p="http://www.springframework.org/schema/p(혹은 c)"` 를 추가 정의하여 bean 태그 내에서 속성을 단축하여 사용할 수 있음
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p" // 추가된 부분!
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
<bean id="f2" class="sample5.DateVo" 
	p:name="Dooly"  p:birth="1983-04-22"/>	
</beans>
```
- property 태그는 p로  consturctor-arg 태그는 c로 단축해서 사용함
- 만약 p나 c에 객체가 들어가야한다면 `c:_0-ref` 혹은 `c:속성명-ref` 형식으로 작성할 수 있음
---
## 오늘의 Tip
### 선언적 프로그래밍
- 정해져있는 규격의 문서를 작성하여 기능을 대신 하는 것
- bean 설정 파일을 통해 객체를 생성하는 것이 이에 해당

### 싱글톤
- 스프링은 기본적으로 싱글톤
- 어떤 객체가 프로그램이 기동되는 동안 한번만 생성된다는 것