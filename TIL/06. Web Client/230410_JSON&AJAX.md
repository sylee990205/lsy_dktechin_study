# 230410 JSON & AJAX
## 목차
- [230410 JSON \& AJAX](#230410-json--ajax)
  - [목차](#목차)
  - [XML](#xml)
    - [XML 문서](#xml-문서)
  - [JSON](#json)
    - [장점](#장점)
    - [JSON 사용법](#json-사용법)
  - [AJAX](#ajax)
    - [AJAX 동작 과정](#ajax-동작-과정)
    - [XMLHttpRequest 객체](#xmlhttprequest-객체)
      - [property](#property)
      - [method](#method)
      - [GET VS POST](#get-vs-post)
    - [FormData 객체](#formdata-객체)
    - [readyState 값](#readystate-값)
    - [XMLHttpRequest 객체에서 제공되는 이벤트 관련 속성](#xmlhttprequest-객체에서-제공되는-이벤트-관련-속성)
      - [onload](#onload)
    - [open()](#open)
    - [send()](#send)
  - [MIME type](#mime-type)
  - [SOP / CORS](#sop--cors)
    - [SOP](#sop)
    - [CORS](#cors)
---
## XML
- Extensible Markup Language의 약어
- 규격화된 문서를 만드는 언어
```
GML -> SGML -> HTML
            -> XML
```
- XML은 텍스트 형식이라 운영체제에 연관 없이 사용 가능
  - XML을 오픈할 수 없는 운영체제가 없음
- 태그가 정해져있지않음
  - 태그를 목적에 알맞게 직접 설계(DTD, XML Schema)
### XML 문서
- XML 선언부를 제외하고 기존 HTML5의 기본 구조와 사용 방법 거의 유사
- XML 문서 선언부
  - 반드시 맨 앞에 명세, XML 문서 유형을 지정
  - XML 문서 구조를 정의한 DTD(or XML Schema) 선언, 스타일을 정의한 CSS 연결에 대한 선언도 명세
  - 최상위 엘리먼트의 <시작태그>로 시작해서 </종료태그>로 끝남
  - 최상위 엘리먼트를 포함하여 XML 문서의 모든 태그들은 자유롭게 정의
  - 엘리먼트의 시작 태그 안의 속성도 자유롭게 정의

---

## JSON
- JavaScript Object Notation의 약어
- 인터넷에서 자료를 주고 받을 때 그 자료를 표현하는 방법
- 자료 종류에 제한 없음
- 컴퓨터 프로그램 변수값을 표현하는데 적합함
### 장점
- 택스트로 이루어져 있어, 사람과 기계 모두 읽고 쓰기 쉬움
- 프로그래밍 언어와 플랫폼에 독립적
  - 서로 다른 시스템 간에 객체를 교환하기 좋음
- JSON은 개방형 표준, 읽기 및 쓰기가 쉽고 가벼움
### JSON 사용법
![](/TIL/image/2023-04-10-10-32-58.png)
- key 값은 반드시 String

---

## AJAX
- Asynchronous JavaScript and XML의 약어
- 자바스크립트와 XML로 구현하는 비동기통신
- 기존의 웹 통신 방법은 웹페이지 일부분 갱신을 위해 페이지 전체를 다시 로드해야했음
- AJAX는 `재로드` 하지않고 `웹페이지의 일부`만을 갱신하여 웹서버와 데이터를 교환함
  - `빠르게 동적 웹페이지를 생성하는 기술`
### AJAX 동작 과정
![](/TIL/image/2023-04-10-11-27-57.png)
1. 이벤트 발생에 의해 이벤트 핸들러 역할의 JS 함수를 호출
2. 핸들러 함수에서 XMLHttpRequest 객체 생성. 요청 종료 시 처리할 기능을 콜백 함수로 만들어 등록
3. XMLHttpRequest 객체를 통해 서버에 요청
4. 요청을 받은 서버는 요청 결과를 적당한 데이터로 구성 응답
5. XMLHttpRequest 객체에 의해 등록된 콜백함수를 호출하여 응답 결과를 현재 웹 페이지에 반영
### XMLHttpRequest 객체
- 서버측과 비동기 통신을 제어하는 객체
- 이 객체를 이용함으로써 지금까지 브라우저가 실행한 서버와의 통신 부분을 JS가 제어할 수 있음
```javaScript
new XMLHttpRequest()
```
#### property
| 멤버 | 개요 |
| --- | --- |
| onreadystatechange | 통신 상태가 변화된 타이밍에 호출되는 이벤트 핸들러
| readyState | HTTP 통신상태를 취득
| status | HTTP Status 코드를 취득
| responseType |  응답받으려는 컨텐트 타입 "arraybuffer", "blob", "document", "json", and "text"
| responseText | 응답본체를 plaintext로 취득
| responseXML | 응답본체를 XML(XMLDocument 객체)로 취득
| response | 지정된 응답 타입에 따른 응답객체
| upload |  XMLHttpRequestUpload 객체 제공
#### method
| 멤버 | 개요 |
| --- | --- |
|abort() | 현재의 비동기통신을 중단
getAllResponseHeaders() | 수신한 모든 HTTP 응답 헤더를 취득
getResponseHeader(header) | 지정한 HTTP 응답 헤더를 취득
open( ... ) | HTTP 요청을 초기화
setRequestHeader(header, value) | 요청 시에 송신하는 헤더를 추가
send([body]) |  HTTP 요청을 송신(인수 body는 요청본체)

#### GET VS POST
- 웹 클라이언트에서 웹 서버에게 요청을 보낼 때 name=value & name=value로 구성된 데이터를 함께 전달 가능
- GET 방식으로 요청 
  - 쿼리 문자열
    - 요청 대상 URL 문자열 뒤에 ? 기호와 함께 추가해서 전달
    - 길이에 제한이 있음
    - 외부에 보여짐
- POST 방식으로 요청
  - 요청 파라미터
    - 요청 바디 안에 담아서 전달
    - 길이에 제한 없음
    - 외부에 보여지지 않음
    ```javascript
    // POST 방식일 때 Header에 반드시 아래 내용을 지정해줘야함,약속
	setRequestHeader("Content-type", "application/x-www-form-urlencoded"); //MIME type
    ```


### FormData 객체
- FormData 객체는 폼의 각 필드와 값을 나타내는 키/값 쌍들의 집합을 쉽게 구성할 수 있는 방법 제공
- 데이터를 "multipart/form-data" 형식으로 XMLHttpRequest의 send 메소드를 사용하여 쉽게 전송 가능
- HTML form 엘리먼트의 DOM 객체는 폼의 데이터를 FormData 객체로 얻게 해주는 getFormData() 메소드 제공

### readyState 값
| 반환값 | 개요 |
| --- | --- | 
| 0 |  미초기화(open 메서드가호출되지않음)
| 1 | 로드 중(open 메서드는호출됐지만, send 메서드는호출되지않았다)
| 2 | 로드 완료(send 메서드는호출됐지만, 응답스테이터스/헤더는 미취득)
| 3 | 일부 응답을 취득(응답스테이터스/헤더만취득, 본체는미취득)
| 4 | 모든 응답데이터를 취득 완료

### XMLHttpRequest 객체에서 제공되는 이벤트 관련 속성
- onloadstart
- onprogress
- onabort
- onerror
- onload
- ontimeout
- onloadend
- onreadystatechange
#### onload
```javascript
xhr.onload = function () {}
```
- 서버한테 비동기적으로 AJAX 통신을 요청하고 응답을 받아온것
### open()
```javascript
open(HTTP 메소드, URL, [비동기 모드 통신 여부])
```
- HTTP 메소드: 요청 방식(GET, POST, PUT, DELETE)
- URL: AJAX로 요청하려는 서버의 대상 페이지
- 비동기 모드 통신 여부: true(비동기), false(동기)

### send()
```javascript
send([요청 파라미터])
```
- POST의 경우 Query 문자열을 인수로 지정
- ArrayBufferView, Blob, Document, DOMString, FormData, null 등


---
## MIME type
- majortype/minortype --> MIME type
  - text/html
  - text/xml
  - text/plain
  - application/json(text/json)
  - image/gif
  - image/jpg
  - image/png

---
## SOP / CORS 
![](/TIL/image/2023-04-10-16-08-37.png)
### SOP
- Same Origin Policy
- 브라우저에서 보안상의 이슈로 `동일 사이트 자원만 접근`해야한다는 제약
- Origin : 현재 페이지를 내려준 Server
- AJAX는 이 제약에 영향을 받음
  - `Origin 서버가 아니면` AJAX로 요청한 컨텐츠를 수신할 수 없음

### CORS
- Cross Origin Resource Sharing
- 초기 명칭은 Cross Domain
  - 동일 도메인에서 포트만 다른 경우, 로컬 파일인 경우 등으로 인해 Origin으로 용어 통일
- `Origin이 아닌 다른 사이트의 자원을 접근하여 사용한다는 의미`
- HTTP Header에 CORS와 관련된 항목을 추가
```javascipt
response.addHeader("Access-Control-Allow-Origin","*");
```