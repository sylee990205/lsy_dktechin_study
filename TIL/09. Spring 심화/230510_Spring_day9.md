# 230510_Spring_day9
## 목차
<!-- TOC -->

- [230510\_Spring\_day9](#230510_spring_day9)
  - [목차](#목차)
  - [DispatcherServlet의 동작 과정](#dispatcherservlet의-동작-과정)
  - [Spring Boot 로깅](#spring-boot-로깅)
    - [SLF4J](#slf4j)
    - [LogBack](#logback)
      - [로그 레벨 단계](#로그-레벨-단계)
    - [logback-spring.xml 설정](#logback-springxml-설정)
      - [appender](#appender)
      - [root와 logger](#root와-logger)
      - [property](#property)
      - [layout과 encoder](#layout과-encoder)
      - [file](#file)
      - [pattern](#pattern)

<!-- /TOC -->
---
## DispatcherServlet의 동작 과정
![](/TIL/image/2023-05-10-16-25-19.png)

---

## Spring Boot 로깅
- 스프링은 Log4J를 default로 제공했으나 보안문제로 인해 LogBack으로 이동함
### SLF4J
- 스프링 부트에 내장된 API
- 로그 기능을 제공
- 개발자가 기술과 관련된 어떠한 이슈에 * 관심을 갖고 파악하려고 하는 자세를 가진다는 의미로 보여질 수 있음
### LogBack
- 로깅을 수행하기 위해 필요한 주요 설정 요소
  - Logger, Appender, Encoder
#### 로그 레벨 단계
```
TRACE < DEBUG < INFO < WARN < ERROR
```
- ERROR: 요청을 처리하는 중 **오류가 발생**
- WARN : 처리 가능한 문제 **향후 시스템 에러의 원인이 될 수 있는 경고**
- INFO : 상태 변경과 같은 **정보성 로그**
- DEBUG : 프로그램을 **디버깅 하기 위한 정보**를 표시
- TRACE : 처리 흐름 추척을 위해 **Debug 보다 훨씬 상세한 정보**를 표시

### logback-spring.xml 설정
- 대소문자를 구별하지 않음
- name attribute 반드시 지정
- appender와 logger 크게 두개로 구분
- Dynamic Reloading 기능 지원
#### appender
- 로그 메시지가 출력될 대상을 결정하는 요소
  - 콘솔 or 파일 등
- class의 종류
1. ch.qos.logback.core.ConsoleAppender
   - 콘솔에 로그를 찍음
   - 로그를 OutputStream에 작성하여 콘솔에 출력
   - layout tag에 담아 사용
    ```xml
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
      <layout class="ch.qos.logback.classic.PatternLayout">
        <pattern>[%d{yyyy-MM-dd HH:mm:ss}][%thread] %-5level %logger{36} - %msg%n</pattern>
      </layout>
    </appender>
    ```
2. ch.qos.logback.core.FileAppender
   - 파일에 로그를 찍음
   - 최대 보관 일 수 등을 지정
   - encoder tag에 담아 사용 
    ```xml
      <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>${LOGS_ABSOLUTE_PATH}/mylogback.log</file>
        <encoder>
          <pattern>[%d{yyyy-MM-dd HH:mm:ss}] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
      </appender>
    ```
3. ch.qos.logback.core.rolling.RollingFileAppender
   - 여러개의 파일을 롤링, 순회하면서 로그를 찍음
     - 지정 용량이 넘어간 Log File을 넘버링 하여 나눠 저장
     - 일별로 로그 파일 생성하여 저장
   - encoder tag에 담아 사용
    ```xml
    <appender name="ROLLINGFILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
      <encoder>
        <pattern>[%d{yyyy-MM-dd HH:mm:ss}:%-3relative][%thread] %-5level %logger{35}
    - %msg%n</pattern>
      </encoder>
      <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <fileNamePattern>${LOGS_ABSOLUTE_PATH}/logback.%d{yyyy-MM-dd}.log</fileNamePattern>
      </rollingPolicy>
    </appender>
    ```
4. ch.qos.logback.classic.net.SMTPAppender
   - 로그를 메일로 보냄
5. ch.qos.logback.classic.db.DBAppender
   - 로그를 DB에 저장

#### root와 logger
- package와 level을 설정하고 appender를 참조하게 정의
- root
  - 전역 로거 설정
  - 항상 마지막에 수행되는 기본 로거
- looger
  - 지역 로거 설정
  - additivity 속성으로 root 설정을 마저 수행할 것인지 여부를 결정 가능
#### property
- 설정파일에서 사용될 변수값 선언
#### layout과 encoder
- layout : 로그의 출력 포맷을 지정
- encoder : Appender에 포함되며 출력될 로그메시지를 원하는 형식으로 변환
  - FileAppender 에서는 encoder를 사용하여 layout 설정
#### file
- 기록할 파일명과 경로를 설정
- rollingPolicy class
  - ch.qos.logback.core.rolling.TimeBaseRollingPolicy - 일자별
  - ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP - 일자별 + 크기별
- fileNamePattern
  - 파일 쓰기가 종료된 log  파일명의 패턴 지정
- maxFileSize
  - 한 파일당 최대파일 용량 지정
  - log 내용의 크기도  IO 성능에 영향을 미침
    - 너무 크지 않은 사이즈로 지정하는 것이 좋음
- maxHistory
  - 최대 파일 생성 갯수
#### pattern
- %logger{length} : Logger name 을 축약할 수 있다. {length}는 최대 자리 수  
- %-5level : 로그 레벨, -5 는 출력의 고정폭 값(5 글자)  
- %msg : - 로그 메시지 (=%message)  
- ${PID:-} : 프로세스 아이디  
- %d : 로그 기록시간  
- %p : 로깅 레벨  
- %F : 로깅이 발생한 프로그램 파일명  
- %M : 로깅일 발생한 메소드의 명  
- %l : 로깅이 발생한 호출지의 정보  
- %L : 로깅이 발생한 호출지의 라인 수  
- %thread : 현재 Thread 명  
- %t : 로깅이 발생한 Thread 명  
- %c : 로깅이 발생한 카테고리  
- %C : 로깅이 발생한 클래스 명  
- %m : 로그 메시지  
- %n : 줄바꿈(new line)  
- %% : %를 출력  
- %r : 애플리케이션 시작 이후부터 로깅이 발생한 시점까지의 시간(ms)  