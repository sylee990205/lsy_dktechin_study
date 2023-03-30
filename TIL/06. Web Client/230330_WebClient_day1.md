# 230330 Web Client 1
## 목차
<!-- TOC -->

- [Web Client 1](#web-client-1)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [WWW](#www)
        - [팀 버너스 리](#%ED%8C%80-%EB%B2%84%EB%84%88%EC%8A%A4-%EB%A6%AC)
        - [WWW 역사](#www-%EC%97%AD%EC%82%AC)
    - [웹 표준](#%EC%9B%B9-%ED%91%9C%EC%A4%80)
        - [웹 표준을 지켰을 때의 장점](#%EC%9B%B9-%ED%91%9C%EC%A4%80%EC%9D%84-%EC%A7%80%EC%BC%B0%EC%9D%84-%EB%95%8C%EC%9D%98-%EC%9E%A5%EC%A0%90)
        - [웹 접근성](#%EC%9B%B9-%EC%A0%91%EA%B7%BC%EC%84%B1)
    - [HTML5](#html5)
        - [요소](#%EC%9A%94%EC%86%8C)
        - [태그](#%ED%83%9C%EA%B7%B8)
        - [절대주소 / 상대주소](#%EC%A0%88%EB%8C%80%EC%A3%BC%EC%86%8C--%EC%83%81%EB%8C%80%EC%A3%BC%EC%86%8C)
        - [공백](#%EA%B3%B5%EB%B0%B1)
        - [input](#input)
        - [form](#form)
    - [용어 정리](#%EC%9A%A9%EC%96%B4-%EC%A0%95%EB%A6%AC)

<!-- /TOC -->
---
## WWW
- World Wide Web의 약자
- WWW, W3, Web 이라고도 부름
- 인터넷에 연결된 컴퓨터들을 통해 사람들이 정보를 공유할 수 있는 전 세계적 정보 공간
  - 인터넷을 보다 쉽게 사용할 수 있게 해주는 통신 시스템
- web != internet
- Web Server와 Web Client(Browser), HTTP protocol, HTML
- WWW는 세가지 기능으로 요약 가능
  - 통일된 웹 자원의 위치 지정 방법 - URL
  - 웹 자원 이름에 접근하는 프로토콜 - HTTP
  - 자원들 사이를 쉽게 항해 할 수 있는 언어 - HTML
### 팀 버너스 리
- WWW 창시자
- W3C 라는 WWW을 위한 표준을 개발하고 장려하는 조직의 설립자
### WWW 역사
- 초창기 웹
  - 인터넷을 통한 정보 공유의 목적
  - 네트워크 속도, 서버, PC 사양 등에 따라 제약을 받음
  - 표현 범위 : 텍스트, 이미지
  - 웹 문서를 위한 마크업 언어 수준
- 현재 웹
  - 네트워크 속도, 서버, PC 사양 등의 제약 사항이 완화
  - 표현 범위 : 텍스트, 이미지, 비디오, 음성 등
- HTML5를 사용하면 시장의 요구를 만족시키고 비용 절감의 효과가 있으며, 네이티브 앱 개발 대비 생산성을 증가시킬 수 있음
---

## 웹 표준
![](/TIL/image/2023-03-30-12-24-19.png)
- W3C에서 정한 표준 기술만을 사용하여, 웹 페이지 작성시 문서의 구조와 표현 방법 그리고 상호 동작을 구분하여 구현하는 것을 말함
- 웹 문서의 구조 : HTML
- 표현 (디자인) : CSS3
- 동작(기능처리) : JavaScript
- 3가지 요소가 유기적으로 결합하여 작동시키면 웹 문서가 가벼워짐
- 유지보수 및 수정 시에도 간편하고 빨리 처리 가능
- 웹 표준의 목표
  - Web은 어디서든, 누구나 정보를 함께 공유하고 즐길 수 있어야함
### 웹 표준을 지켰을 때의 장점
- 사용자는 장소와 기기에 상관 없이 쉽게 볼 수 있음
- 웹 개발자와 디자이너는 시간을 절약할 수 있음
- 유지 보수가 쉬움
- 웹 접근성 확보 가능
- 내용과 디자인, 동작을 분리하기 때문에 전체적인 용량이 줄어듬
### 웹 접근성
- 웹은 장애에 구애 없이 모든 사람들이 손쉽게 정보를 공유할 수 있는 공간이어야 한다는 것
- 웹 접근성을 지키기 위한 가장 효과적인 방법 : 웹 표준의 준수

---

## HTML5
- 차세대 마크업 언어 표준
- HTML5 이전 : 태그
- HTML5 : 태그 + **API(JavaScript)**
  - API 설계 이유 : 웹 표준에 기반한 웹페이지 개발을 지원하기 위해
  - 웹 스토리지, 캔바스, 웹소켓, 지오로케이션 등
- 플랫폼 중립적, 특정 디바이스에 종속되지않음
> 시멘틱한 마크업 + 풍부한 웹 어플리케이션 = HTML5
### 요소
- 가장 보편적인 형태는 세 가지 구성 요소를 가짐
  - 시작 태그
  - 종료 태그
  - 문자와 그래픽 정보 콘텐츠

### 태그
- HTML 태그의 컨텐츠 또는 속성의 값에 의한 내용이 브라우저의 도큐먼트 영역에 출력(렌더링)될 때 태그에 따라 블럭스타일 태그와 인라인 스타일 태그로 나뉨
  - 블럭 스타일: 태그의 내용이 랜더링되는 영역이 그 행 끝까지
    - hx, div, header, footer, section, nav, form, table, ul, li, ol, ......
    - 기본 margin이 있음
  - 인라인스타일: 태그의 내용이 렌더링되는 영역이 컨텐트 내용만큼
    - a, img, input, span
    - 개행되지않음
    - 기본 margin이 없음

### 절대주소 / 상대주소
- 절대 주소
  - 도메인 주소를 표시한 주소
- 상대 주소
  - 현재 파일 위치를 기준으로 상대 파일의 위치를 지정

### 공백
```html
abcdef&nbsp;&nbsp;&nbsp;가나다&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;123
```
- &nbsp로 공백
- 여러 공백을 하고싶다면 여러번

### input
- input type = "email" 
  - 이메일 주소 입력 시 사용
  - 서버로 전송 시 이메일 형식 자동 체크
- input type = "url"
  - 웹 사이트 주소 입력시 사용
- input type = "number"
  - 숫자를 스핀 박스를 이용해서 입력 가능
  - min, max, step(간격), value(초기값)
- input type = "range"
  - 슬라이드 막대
- input type = "search"
  - 검색 상자
  - 검색어를 입력하면 오른쪽에 x 표시
  - x를 누르면 입력한 내용 전체 삭제
- input type = "date", input type = "month", input type = "week", input type = "time"
  - 달력에서 날짜를 선택
  - 스핀 박스에서 시간 선택 가능
- input type = "color"
  - 컬러 박스 표시

### form
```html
<form id="myForm"  method="get" action="......">
```
- method - 서버로 데이터 전송 방식

---
## 용어 정리
- edu 폴더(dynamic web project folder)
  - IDE 툴 : 웹 프로젝트 폴더
  - WAS(Web Application Server:Tomcat): 컨텍스트
  - 웹 개발자: edu를 웹 애플리케이션이라 함
- http://localhost:8088/edu/htmlexam/exam0.html --> HTTP URL
  - /edu~ /exam0.html : URI(Uniform Resource Identity)
  - Context path