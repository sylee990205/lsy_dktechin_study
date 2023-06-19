# 230609 Docker Day 1
## 목차
<!-- TOC -->

- [Docker Day 1](#docker-day-1)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [YAML](#yaml)
        - [.yaml과 .yml의 차이점](#yaml%EA%B3%BC-yml%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90)
        - [YAML 문법](#yaml-%EB%AC%B8%EB%B2%95)
    - [도커](#%EB%8F%84%EC%BB%A4)
        - [가상 머신 vs 도커 컨테이너](#%EA%B0%80%EC%83%81-%EB%A8%B8%EC%8B%A0-vs-%EB%8F%84%EC%BB%A4-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88)
    - [마운트](#%EB%A7%88%EC%9A%B4%ED%8A%B8)
        - [마운트의 종류](#%EB%A7%88%EC%9A%B4%ED%8A%B8%EC%9D%98-%EC%A2%85%EB%A5%98)
        - [이미지 만드는 방법](#%EC%9D%B4%EB%AF%B8%EC%A7%80-%EB%A7%8C%EB%93%9C%EB%8A%94-%EB%B0%A9%EB%B2%95)

<!-- /TOC -->
---
## YAML
- 서로 다른 시스템 간에 데이터를 주고 받을 필요가 있을 때 데이터 연동과 호환성을 위해 포맷에 대한 규칙이 필요
- CSV, XML, JSON, Properties 등
  - 웹 : XML, JSON
  - 자바 : properties
- 가독성이 좋지 않고 주석을 달 수 없다는 단점
- 새로 제안된 포매팅 방식 YAML / YML
- 주로 Docker Compose, Kubernetes, Flutter, Spring boot 프로젝트에서 설정파일을 정의할 때 자주 애용
- 웹에서의 데이터 통신을 위해 JSON을 많이 사용
- reference 정의 시 복잡한 object 구조를 표현하기 위해 yaml을 사용

### `.yaml`과 `.yml`의 차이점
- yaml과 yml 파일 확장자는 모두 해석 및 구문이 동일
- 옛날 windows에서 파일 확장자가 3자로 제한되는 특성이 있어 yml로 사용되는 것
- 단순하게 yaml 사용해도 됨

### YAML 문법
- Key: Value 표기
  - key, value를 콜론을 기준으로 구분
  - value 작성 시 반드시 콜론(`:`) 뒤에 띄어쓰기를 한 번 해줘야함
  - 콜론 뒤에 공백이 없으면 하나의 String으로 인식
- 콤마 표기 안함
  - 여러 개의 데이터가 있어도 콤마 없이 바로 개행
  ```yaml
  name: 둘리
  age: 10
  major: 컴퓨터공학
  ```
- 들여쓰기
  - 계층 구조로 표현하기에 들여쓰기 유무가 매우 중요
  - 기본적으로 2칸 혹은 4칸을 지원
  ```yaml
  student:
    name: 둘리
    age: 10
    major: 컴퓨터공학
  ```
- "따옴표" 표현
  - 따옴표가 없이 자동으로 숫자와 문자열로 인식
  - 만약 콜론이 들어간 문자열은 따옴표를 사용해야 제대로 인식
  - 큰 따옴표: escape sequence 처리를 해줌 (ex: \t, \n)
  - 작은 따옴표: 그대로 문자열 처리
- 배열 & 리스트
  - 단순 배열
    - 배열 표현 시 하이픈(`-`)으로 시작하는 하위 엘리먼트로 표현 가능
    - 반드시 하이픈 뒤에 띄어쓰기를 해야 리스트로 인식
    - 하이픈 대신 대괄호로 리스트를 한줄 표현도 가능
    ```yaml
    members:
      - 둘리
      - 또치
      - 도우너
    
    members: [둘리, 또치, 도우너]
    ```
  - 객체 배열
    - 하이픈과 key: value 구조를 이용하여 객체 배열 표현
    ```yaml
    students:
      - name: 둘리
        major: 국어
        age: 10
      - name: 또치
        major: 영어
        age: 11
    ```
- Boolean 표현
  - yaml의 boolean 표현은 총 4가지
  - `yes, no, true, false`
  - 대소문자 구분 없음
- 주석 표현
  - `#`으로 주석 표기 가능
- 텍스트 Multi Line
  - 크게 두가지 방법 존재
  1. `>` 기호를 쓰는 방법 (folded block scalar)
      - `>` 기호는 개행 문자를 스페이스로 치환
      - 빈 줄 하나가 단독으로 있는 경우만 줄바꿈
      - 맨 끝은 원래 자동으로 개행처리를 해주지만 `>` 기호 옆에 `-`를 붙이면 맨 끝은 줄바꿈 문자를 포함시키지않음
  2. `|` 기호를 쓰는 방법
      - 개행 문자 그대로 줄을 바꿔줌
      - 기호 옆에 `-`를 붙이면 맨 끝의 줄바꿈 문자를 포함시키지않음
- Multiple Documents
  - 두 파일의 데이터를 하나의 파일로 포함시켜 표현
  - `---`을 이용하여 두 프로퍼티 파일의 내용을 하나의 파일에 포함시켜 한꺼번에 정의 가능
  ```yaml
  spring:
    profiles: dev
    datasource:
      url: jdbc:mysql://
      hikari:
        minimum-idle: 1
        maximum-pool-size: 3
    management:
      endpoints:
        web:
          base-path: /
    ---
  spring:
    profiles: prod
    datasource:
      url: jdbc:mysql://
      hikari:
      minimum-idle: 5
      maximum-pool-size: 10
    management:
      endpoints:
        web:
          base-path: /
    ```

### 사용 분야
다양한 사용 분야가 있지만 우리 교육 과정에서 사용되는 기능 위주로 정리했다.
- GitHub Aciton: 설정 파일이 .github/workflows/<워크플로 이름>.yml로 yaml 형식 사용
- Docker: compose파일을 yaml로 작성하고 배포
- 쿠버네티스: 지금껏 어떤 프레임워크보다 yaml을 광범위하게 사용하는 프레임워크 중 하나
- 스프링부트: yaml 방식의 설정 파일 사용 가능
  - application.yaml
  - 일반 스프링에서도 별도로 설정할 수 있다면 적용 가능

---
## 도커
- **데이터 또는 프로그램을 각각 독립된 환경에 격리시키는 기능**을 제공하는 소프트웨어
- 주로 서버에서 사용
### 가상 머신 vs 도커 컨테이너
- 가상 머신 
  - 가상 머신은 OS와 하드웨어 드라이버를 유저 단에 띄워 가상화를 구현
  - 가상화를 통해 Application을 사용하려고 운영체제를 매번 따로 설치하는 것은 너무 큰 부담
- 도커
  - 도커 엔진을 이용하여 컨테이너를 띄움
  - 컨테이너는 Application을 사용할 수 있는 가상 환경
  - 별도의 운영체제가 필요하지 않음
  - Application도 사용 가능하고 host 환경에 부담도 적음
---
## 마운트
- 볼륨 : 스토리지의 한 영역을 분할한 것
- 마운트 : 연결하다 의 의미
### 마운트의 종류
- 볼륨 마운트
  - 도커 엔진이 관리하는 영역 내에 만들어진 볼륨을 컨테이너에 디스크 형태로 마운트하여 사용 
- 바인드 마운트
  - 도커 엔진에서 관리하지 않는 영역의 디렉터리를 컨테이너에 마운트하는 방식
### 이미지 만드는 방법
- commit 명령으로 만들기
- DockerFile 스크립트로 만들기

```docker
#<Dockerfile 스크립트의 예>
#FROM 이미지_이름
#COPY 원본_경로 대상_경로
#RUN 리눅스_명령어

FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/springedu3.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
