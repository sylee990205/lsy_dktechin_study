# 230406 JavaScript day4
## 목차
<!-- TOC -->

- [JavaScript day4](#javascript-day4)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [JavaScript의 이벤트모델](#javascript%EC%9D%98-%EC%9D%B4%EB%B2%A4%ED%8A%B8%EB%AA%A8%EB%8D%B8)
        - [inline event model인라인이벤트모델](#inline-event-model%EC%9D%B8%EB%9D%BC%EC%9D%B8%EC%9D%B4%EB%B2%A4%ED%8A%B8%EB%AA%A8%EB%8D%B8)
        - [고전 이벤트모델](#%EA%B3%A0%EC%A0%84-%EC%9D%B4%EB%B2%A4%ED%8A%B8%EB%AA%A8%EB%8D%B8)
        - [표준 이벤트 모델](#%ED%91%9C%EC%A4%80-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EB%AA%A8%EB%8D%B8)
        - [고전 이벤트 모델과 표준 이벤트 모델의 차이점](#%EA%B3%A0%EC%A0%84-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EB%AA%A8%EB%8D%B8%EA%B3%BC-%ED%91%9C%EC%A4%80-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EB%AA%A8%EB%8D%B8%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90)
        - [이벤트 handler 에서 this](#%EC%9D%B4%EB%B2%A4%ED%8A%B8-handler-%EC%97%90%EC%84%9C-this)
    - [output 태그](#output-%ED%83%9C%EA%B7%B8)
    - [clearInterval, clearTimeout](#clearinterval-cleartimeout)
    - [load 이벤트](#load-%EC%9D%B4%EB%B2%A4%ED%8A%B8)
    - [자바스크립트 <-> JSON](#%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8---json)
    - [이벤트 버블링, 이벤트 캡처링](#%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EB%B2%84%EB%B8%94%EB%A7%81-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%BA%A1%EC%B2%98%EB%A7%81)
        - [이벤트 버블링](#%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EB%B2%84%EB%B8%94%EB%A7%81)
    - [오늘의 Tip](#%EC%98%A4%EB%8A%98%EC%9D%98-tip)
        - [자바 배포판](#%EC%9E%90%EB%B0%94-%EB%B0%B0%ED%8F%AC%ED%8C%90)

<!-- /TOC -->
---
## JavaScript의 이벤트모델
- 이벤트모델: 웹페이지내에서 수행되는 동작을 구현하는 것
### inline event model(인라인이벤트모델)
- 지역적
- 이벤트를 태그 안에 작성하는 것
```javascript
<태그명 on이벤트명="처리코드">

<태그명 on이벤트명="처리코드;return false"> // + default event 핸들러에 대한 처리
```
- onClick, onMouseover 등 --> 대소문자 상관 없음
- default event handler : 태그가 가진 기본 이벤트핸들러, ex) a herf -> 하이퍼링크
- 등록한 이벤트 핸들러를 해제할 방법이 없음
- 
### 고전 이벤트모델
- 전역적
- 태그의 DOM 객체를 찾아옴
- 찾은 DOM 객체의 event handler에 해당하는 함수를 등록해야함
  - 해당 DOM 객체의 event handler에 관련된 속성에!
```javascript
DOM객체.on이벤트명 = 함수 //이벤트명은 반드시 소문자로 줘야함
DOM객체.on이벤트명 = 함수(return false) // 기본 이벤트핸들러 해제
DOM객체.on이벤트명 = null //이벤트 핸들러 해제
```

### 표준 이벤트 모델
- 전역적
- 태그의 DOM 객체를 찾아옴
```javascript
DOM객체.addEventListener("이벤트명", 함수);
이벤트객체.preventDefault(); // 기본 이벤트핸들러 해제
DOM객체.removeEventListener("이벤트명", 함수); // 해당 이벤트 핸들러 해제
```
### 고전 이벤트 모델과 표준 이벤트 모델의 차이점
- 고전 이벤트 모델과 표준 이벤트 모델은 작성하는 방법만 다르지 않음
- 고전 이벤트 모델은 해당 이벤트명과 함수를 = 로 연산함 -> 찾은 DOM 객체의 event handler에 해당하는 함수를 할당
- 만약 기능을 추가하고 싶어서 함수 여러개를 등록해 처리하겠다고 2번 할당하면 그냥 연산이 바뀔뿐 두개가 적용되지않음
- 표준 이벤트 모델은 EventListener 메소드를 사용하여 해당 이벤트 명 리스트에 그 함수를 `추가`하는 것
- 따라서 여러개의 이벤트를 동시에 처리할 수 있음
```javascript
// 고전
const doms = document.getElementsByTagName("button"); // NodeList가 return되니까
doms[0].onclick = updateTitle //이렇게 가능!
doms[1].onclick = updateColor
doms[2].onclick = updateImage
doms[2].onclick = updateColor // index 2의 dom 객체 onclick 이벤트 발생 시 색상만 변경됨

// 표준
const doms = document.getElementsByTagName("button");
doms[0].addEventListener("click", updateTitle)
doms[1].addEventListener("click", updateColor)
doms[2].addEventListener("click", updateImage)
doms[2].addEventListener("click", updateColor) // index 2의 dom 객체에 click 이벤트가 발생 시 이미지와 색상 모두 변경
```
### 이벤트 handler 에서 this
- this는 현재 진행되는 event의 dom 객체를 가르킴
- e.target과 동일함

---
## output 태그
- output 태그는 HTML5에서 추가됨
- 자바스크립트의 수행 결과를 출력하는 용도
- 꼭 사용해야하는 것은 아님
---
## clearInterval, clearTimeout
- window.setInterval 이나 setTimeout은 등록하는 메소드임
- 이 등록하는 job에 대한 id를 return함
- 이 return된 id는 job을 clear하는데 사용됨
```javascript
interval_id = window.setInterval(function () { 
        	// setInterval과 setTimeout은 등록하는것 , 이 등록하는 Job대한 ID를 return 함
        	// 이 ID는 등록된 것을 해제하고 싶을 때 사용함 --> clearIntervals
	        target.innerHTML = "<h2>"+new Date().toLocaleString()+"</h2>";
	    }, 1000);
	

function stopTime() {
	target.innerHTML = "";
	window.clearInterval(interval_id)
}
```
---
## load 이벤트
- load 이벤트는 인라인 이벤트 모델로 처리한다고 하면 body 태그에 줘야함
- body가 load될 때
---
## 자바스크립트 <-> JSON
- 자바스크립트 객체 -> JSON 문자열
```javaScript
var jsonStr = JSON.stringify(obj);
```
- JSON 문자열 -> 자바스크립트 객체
```javaScript
var copy = JSON.parse(jsonStr);
``` 
---
## 이벤트 버블링, 이벤트 캡처링
![](/TIL/image/2023-04-06-16-25-41.png)
### 이벤트 버블링
 ```
1. 만약 td에서 어떤 이벤트가 발생
2. td의 handler가 제일 먼저 수행
3. 이후 조상 태그로 넘어감
4. 조상 태그에도 해당 event 에 대한 handler가 저장되어있었다면 그 handler도 수행
5. 계속됨
6. 대부분 body 태그까지 진행됨
```
- 고전 이벤트 모델에서는 버블링이 자동으로 수행되지 않음
- 표준 이벤트 모델에서 이벤트 버블링은 자동으로 수행됨
  - 이벤트 버블링을 수행하지 않는 방법 e.stopPropagation();
- 이벤트 핸들러에서 currentTarget을 수행하면 이벤트핸들러의 target은 이벤트 핸들러 수행을 위임받은 target
- this는 currentTarget의 dom 객체를 가르키게 됨

---
## 오늘의 Tip
### 자바 배포판
- Java SE : Standard Editon
- Java EE 
  - Java EE 기술과 관련된 모든 설정 파일은 XML
- Java ME
