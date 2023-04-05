# 230405 JavaScript day3
## 목차
<!-- TOC -->

- [JavaScript day3](#javascript-day3)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [형변환](#%ED%98%95%EB%B3%80%ED%99%98)
    - [자바스크립트의 객체](#%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EC%9D%98-%EA%B0%9D%EC%B2%B4)
        - [객체란?](#%EA%B0%9D%EC%B2%B4%EB%9E%80)
        - [객체 정의 방법](#%EA%B0%9D%EC%B2%B4-%EC%A0%95%EC%9D%98-%EB%B0%A9%EB%B2%95)
            - [프로토타입](#%ED%94%84%EB%A1%9C%ED%86%A0%ED%83%80%EC%9E%85)
            - [객체 리터럴 방식 vs 생성자 함수 방식](#%EA%B0%9D%EC%B2%B4-%EB%A6%AC%ED%84%B0%EB%9F%B4-%EB%B0%A9%EC%8B%9D-vs-%EC%83%9D%EC%84%B1%EC%9E%90-%ED%95%A8%EC%88%98-%EB%B0%A9%EC%8B%9D)
        - [객체의 속성](#%EA%B0%9D%EC%B2%B4%EC%9D%98-%EC%86%8D%EC%84%B1)
            - [객체의 속성 추가, 삭제](#%EA%B0%9D%EC%B2%B4%EC%9D%98-%EC%86%8D%EC%84%B1-%EC%B6%94%EA%B0%80-%EC%82%AD%EC%A0%9C)
            - [객체 속성 접근 방법](#%EA%B0%9D%EC%B2%B4-%EC%86%8D%EC%84%B1-%EC%A0%91%EA%B7%BC-%EB%B0%A9%EB%B2%95)
        - [표준 내장 객체](#%ED%91%9C%EC%A4%80-%EB%82%B4%EC%9E%A5-%EA%B0%9D%EC%B2%B4)
        - [BOM 객체](#bom-%EA%B0%9D%EC%B2%B4)
            - [객체별 메소드](#%EA%B0%9D%EC%B2%B4%EB%B3%84-%EB%A9%94%EC%86%8C%EB%93%9C)
        - [DOM 객체](#dom-%EA%B0%9D%EC%B2%B4)
        - [DOM 객체 접근 방법](#dom-%EA%B0%9D%EC%B2%B4-%EC%A0%91%EA%B7%BC-%EB%B0%A9%EB%B2%95)
        - [DOM 프로그래밍에서 많이 쓰이는](#dom-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%EC%97%90%EC%84%9C-%EB%A7%8E%EC%9D%B4-%EC%93%B0%EC%9D%B4%EB%8A%94)
    - [오늘의 Tip](#%EC%98%A4%EB%8A%98%EC%9D%98-tip)
        - [개발자 도구](#%EA%B0%9C%EB%B0%9C%EC%9E%90-%EB%8F%84%EA%B5%AC)
        - [숫자가 아닌 값을 찾을때 isNaN vs typeof == "number"](#%EC%88%AB%EC%9E%90%EA%B0%80-%EC%95%84%EB%8B%8C-%EA%B0%92%EC%9D%84-%EC%B0%BE%EC%9D%84%EB%95%8C-isnan-vs-typeof--number)
        - [URL 작성 시](#url-%EC%9E%91%EC%84%B1-%EC%8B%9C)
        - [Parsing](#parsing)

<!-- /TOC -->
---
## 형변환
- 만약 문자열을 숫자로 변경한다고 할 때
1. Number("123.1")
   - 이 경우 123.1으로 변경
2. parseInt("123.1")
   - 문자열을 정수로 변경해줌. 만약 소수점 위에만 필요하다고 하면 이걸 사용해도 됨
   - 123으로 변경
   - parseFloat도 있음
---
## 자바스크립트의 객체
### 객체란?
- 객체: 객체란 이름과 값을 가진 data의 집합 및 data를 조작하기 위한 method가 하나로 묶인 것
  - 이 때 이름과 값을 가진 data를 자바에서는 멤버라고 많이 불렀으나 자바스크립트에서는 속성 Property라고 함
- 객체의 속성과 메서드는 동적으로 추가하거나 삭제 가능
- 상속도 적용됨. JavaScript의 모든 객체는 Object 를 상속받음

### 객체 정의 방법
- 2가지 방법이 있음.
1. 객체 리터럴을 사용하는 방법 *<< 많이 사용되는 방법*
    - 만약 매개변수로 객체를 전달해야 할 일이 있을 때 많이 사용됨
    - 객체의 생성과 사용을 동시에 하는 개념
    - 속성 값으로 method가 올 때 같은 객체 내의 속성으로 접근 시 반드시 this.을 사용해야함 
    ```javascript
    {
        속성명: 속성값, 속성명: 속성값, ...
    }
    ```
2. 생성자 함수를 사용하는 방법
   - 생성자 함수: 객체의 멤버를 초기화 하는 함수.
   - 함수의 명칭 첫글자를 **대문자**로
    ```javascript
    function 함수명([매개변수]){
        this.속성명 = 값;
        this.속성명 = 값;
    }

    new 함수명()
    ```
#### 프로토타입

- 생성자 함수 방식으로 객체를 정의한다면 객체의 속성 중 메소드들은 prototype으로 정의를 해야함
  - 생성자 함수를 통해 새로운 객체가 생성되면 속성과 메소드들이 매번 새롭게 생성됨 --> 메모리 낭비
  - prototype은 객체 생성 시 **한번만 생성**되어 메모리 절약 가능
- 사용 방법은 그냥 정의하는것과 prototype으로 정의하는 것은 동일
![](/TIL/image/2023-04-05-11-34-44.png)
#### 객체 리터럴 방식 vs 생성자 함수 방식
| 객체 리터럴 방식 | 생성자 함수 방식 |
| -------------- | --------------- |
| 하나의 객체만 생성 가능(싱글톤 객체) | 동일한 속성 사양을 갖는 객체 여러개 생성 가능 |
| prototype 속성 사용 불가능 | prototype 속성 사용 가능 |
|   | 정적 멤버 정의 가능 |
|   | OOP 구문 적용하여 객체 생성 가능 |

### 객체의 속성
#### 객체의 속성 추가, 삭제
- 처음 생성 시 함께 정의한 속성이 아니더라도 추후에 정의 가능함
- 객체의 속성명을 지정하여 속성 삭제가 가능함  

#### 객체 속성 접근 방법
- 외부에서 객체의 속성으로 접근하고자 할 때
- 객체.속성명
  - 객체.속성명은 객체에 속성명 이라는 속성을 찾으라는 것
  - 따라서 만약 for문을 사용하여 전체 속성을 확인하고자할 때 부적합
- 객체['속성명']
  - for문 사용 시 반드시 사용해야하는 방법
- 객체.메서드명()
- 위 형식으로 접근 가능

### 표준 내장 객체
- JS가 기본적으로 가지고 있는 객체들
- Object, Function, Array, String, Boolean, Number, Math, Date, RegExp

### BOM 객체
- window : 최상위 객체, 각 탭, iframe별로 하나씩 존재
  - navigator: 브라우저 정보를 보관하는 객체
  - screen: 클라이언트 머신의 화면크기나 해상도 등의 정보를 얻을 수 있는 객체
  - history: 현재의 브라우저가 접근했던 URL 정보를 보관하는 객체
  - location: 현재 보여지고 있는 웹페이지에 대한 URL 정보를 보관하는 객체
  - document: 현재의 문서에 대한 정보를 보관하는 객체
#### 객체별 메소드
- window
  - alert(), prompt(), setInterval(), setTimeout(), onload
  - setTimeout은 단발성, setInterval은 계속
  - onload - 해당 페이지의 로딩이 끝나면 == 랜더링이 끝나면
- navigator
  - geolocation
### DOM 객체
![](/TIL/image/2023-04-05-16-40-20.png)
- 문서 객체 모델(DOM: Document Object Model)은 객체 지향 모델로써 구조화된 문서를 표현하는 형식
- 브라우저는 서버로부터 응답된 웹 컨텐트 내용을 파싱한 후 트리구조로 **각 HTML 태그**마다 DOM 기술을 적용하여 JS 객체를 생성 --> **<span style="color:blue">DOM 객체</span>**
- DOM 객체를 통해 HTML 문서의 내용을 접근 / 읽기 + 내용 수정, 삭제, 추가 등 변경하는 기능 처리
### DOM 객체 접근 방법
| 접근 방법 | 설명 | return 값 |
| ----- | ---- | ---- |
| document.getElementsByTagName("태그명") | 태그명으로 객체를 찾음 | NodeList |
| document.getElementByTagId("태그명") | 찾고자하는 태그의 Id 속성 값(id 속성은 unique, 하나임)으로 객체를 찾음 | Node | 
| document.getElementsByClassName("class속성값") | 태그에 정의된 클래스 속성 값을 찾음 | NodeList |
| document.querySelector("CSS선택자") | 활용력 높음, 태그 선택자, id 선택자 등등 다 줄 수 있음, 무조건 하나만 | Node |
| document.querySelectorAll("CSS선택자") | CSS 선택자에 해당하는것을 다 선택함 | NodeList |
- Node: 없으면 null이 return
- NodeList : 없으면 비어있는 List가 return

### DOM 프로그래밍에서 많이 쓰이는
- 모든 element 들이 갖고 있는 textContent
  - 접근해서 가져오는 값이 text로만 이루어져 있다면 textContent
  - textContent는 값을 모두 String으로만 받음
- innerHTML
  - subTag도 있다면 innerHTML
  - 만약 tag가 tag로 인식되고 HTML로 인식되려면 innerHTML을 사용
---
## 오늘의 Tip
### 개발자 도구
- elements 탭은 자바스크립트의 최종 결과를 보는 것
- sources 탭은 서버가 보내온 original

### 숫자가 아닌 값을 찾을때 isNaN vs typeof == "number"
- 숫자가 아닌 값을 찾으려면 typeof를 사용하는 것이 좋다
- 만약 "123" 이라는 문자열이 들어오면 isNaN은 숫자로만 이루어진 문자열이기에 자동으로 형변환하여 false를 return
- 따라서 typeof 로 거르는 것이 더 정확

### URL 작성 시
- 마지막 /까지 작성하는 것이 성능에 더 좋음

### Parsing
- 위에서부터 소스코드를 한줄 한줄 읽어서 랜더링함 --> 파싱
- 구문 분석을 파싱, 그걸 하는 사람을 파서
