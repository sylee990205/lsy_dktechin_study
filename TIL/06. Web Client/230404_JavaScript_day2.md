# 230404 JavaScript day2
## 목차
<!-- TOC -->

- [230404 JavaScript day2](#230404-javascript-day2)
  - [목차](#목차)
  - [JavaScript 구문](#javascript-구문)
    - [\< pre\>](#-pre)
  - [JavaScript의 함수](#javascript의-함수)
    - [함수 정의 방법](#함수-정의-방법)
    - [함수의 argument 활용](#함수의-argument-활용)
      - [함수의 호출과 인수](#함수의-호출과-인수)
    - [가변인자](#가변인자)
      - [arguments](#arguments)
    - [함수의 활용](#함수의-활용)
      - [함수()()](#함수)
  - [JavaScript 변수 타입](#javascript-변수-타입)
  - [JavaScript 배열](#javascript-배열)
    - [배열 생성 방법](#배열-생성-방법)
    - [배열의 활용](#배열의-활용)
  - [Date](#date)

<!-- /TOC -->
---
## JavaScript 구문
### < pre>
- 구현 시 행단위 출력을 writeln으로 가능하게 하는 것 (< br> 없이 가능!)

---

## JavaScript의 함수
### 함수 정의 방법
- 함수
  - 하나의 로직을 재실행 할 수 있도록 하는 것
  - 코드의 재사용성을 높임
- 선언적(명시적) 함수 정의 방법
```javascript
function myFunction(인자, 인자...){
    /* 함수의 수행코드 */
}
```
- 표현식(익명) 함수 정의 방법
```javascript
var myFunction = function(인자, 인자...){
    /* 함수의 수행코드 */
}
```
- 명시적 함수와 익명 함수의 차이
  - 사용 방법도 비슷해서 차이가 없을 것 같지만 아님
  - 자바스크립트는 실행시 전역변수 선언과 함수를 먼저 확인함
  - 명시적 함수는 script의 후반부에 함수를 선언해도 사용 시 error 가 없음
  - 익명 함수는 어떤 변수에 익명 함수를 선언하는 것임으로 초반에 사용 시 전역변수가 함수가 아니라는 error가 발생함
```java script
// 명시적 함수 
f1(); // 사용 가능!
f2(10,20);
function f1() {
	document.write('f1() 호출<br>');
}
function f2(p1, p2) {
	document.write('f2() 호출-'+(p1+p2)+'<br>');
}

// 익명함수
f1(); // error!
f2(10,20); // 이 시점에서 f1은 undefined 변수임, 함수가 아직 할당되지않았음!

var f1 = function () { 
	document.write('f1() 호출<br>');
}
var f2 = function (p1, p2) {
	document.write('f2() 호출-'+(p1+p2)+'<br>');
}
```
- return
  - 자바스크립트도 함수에서 어떤 값을 전달하고자할때 return문을 사용
  - 타입에 상관없이 모두 return 가능
  - 타입을 체크해야하는 일이 있다면 직접해줘야함
  - return 값이 없는 함수를 호출하여 return 받겠다고하면 자동으로 그 값이 undefined가 됨

### 함수의 argument 활용
#### 함수의 호출과 인수
- 함수 호출 시 매개변수 사양과 리턴 값의 여부를 파악하여 다양한 형식으로 호출 가능
- 메서드 호출 시 전달되는 argument의 개수와 함수 정의시 선언되어있는 매개변수의 개수를 일치하는지 체크하지 않음
- 함수 호출 시 매개변수에 인수 전달하지 않으면 매개변수 값 undefined
- 선언된 매개변수보다 더 많은 인수가 전달된 경우 매개변수를 통해 모든 인수 추출 불가. 전달된 인수를 모두 추출하려면 **arguments**라는 함수의 내장 변수 사용

### 가변인자
#### arguments
- arguments 라는 함수를 활용하여 함수의 가변인자를 처리할 수 있음
- arguments.length : 가변인자의 갯수(매개변수의 수)
- 가변인자를 다룰 때는 arguments[index]

### 함수의 활용
#### 함수()()
- 어떤 함수가 함수를 return할 때 함수명()()을 사용하면 그 함수가 return하는 함수를 즉시 호출할 수 있음

---
## JavaScript 변수 타입
- var
  - 전역 변수, 지역 변수 모두 지원
  - 같은 영역에 똑같은 이름의 변수가 있을 수 있음
- let
  - 같은 영역에 똑같은 이름의 변수가 두 번 이상 선언될 수 없음
    - block scope 지원
  - let 변수는 계속 수정할 수 있음
- const
  - 한번 설정한 변수의 값을 수정할 수 없음
- 변수 앞에 아무것도 없는 경우
  - 에러가 발생하진 않으나 전역 변수가 되어버림
> 변수 설정 시 반드시 var, let, const 중 무언가를 역할에 맞춰 사용하자!

---

## JavaScript 배열
- 객체로 취급
- 배열을 구성하는 각 데이터들을 요소(element)
- 배열의 요소 개수를 가변적으로 처리 가능
  - 배열 생성 시 크기를 지정해도 배열의 요소 개수를 늘리는 것이 가능
- 배열에 저장할 수 있는 데이터 타입에 제한이 없음
  - 각 요소별로 다른 타입의 데이터를 저장하는 것 가능
- length 속성 사용 가능
- 배열 생성 후 변수에 담아 사용
### 배열 생성 방법
1. 배열 리터럴 사용(자동으로 배열 객체가 됨)
   - ex - [1, 2, 3, 4, 5]
2. Array() 생성자 함수 호출
    ```javascript
    new Array()
    new Array(index)
    new Array(element0, element1, ...)
    ```
    - 숫자 1개가 온 경우만 index로 인식하고 그 외 다른 값이 오거나 여러개의 숫자가 오면 element로 인식

### 배열의 활용
```javascript
var a = [];
a.push(10);
a.push(20);

a[2] = 30;
a[5] = 40; // 배열 6번째에 값 들어감 -> 배열의 크기를 늘림 4번째와 5번째 element는 undefiend
```
- push()
  - 배열의 끝에 element 추가
- sort()
  - 기본적으로 문자열 sort 형식임
  - 맨 앞 글자부터 비교해서 사전 정의로 가장 앞에 있는 것부터 출력
  - 문자열 sort 시에는 상관 없으나 숫자를 sort할 땐
  - 함수를 정의해야함
    ```javascript
    sort(function(a, b){ return a - b;}) //오름차순
    sort(function(a, b){ return b - a;}) // 내림차순
    ```
---
## Date
- 자바스크립트는 일요일이 0
  - 일, 월, 화, 수, 목, 금, 토
- 월을 셀 때도 0부터 시작
  - 0: 1월, 1: 2월 ... 11: 12월