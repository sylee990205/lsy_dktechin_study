# 230403 JavaScript day1
## 목차
<!-- TOC -->

- [JavaScript day1](#javascript-day1)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [배우게 될 내용](#%EB%B0%B0%EC%9A%B0%EA%B2%8C-%EB%90%A0-%EB%82%B4%EC%9A%A9)
    - [JavaScript 정의](#javascript-%EC%A0%95%EC%9D%98)
        - [JavaScript란](#javascript%EB%9E%80)
        - [ECMAScript](#ecmascript)
        - [활용 범위](#%ED%99%9C%EC%9A%A9-%EB%B2%94%EC%9C%84)
            - [웹 클라이언트 개발](#%EC%9B%B9-%ED%81%B4%EB%9D%BC%EC%9D%B4%EC%96%B8%ED%8A%B8-%EA%B0%9C%EB%B0%9C)
            - [웹 서버 개발](#%EC%9B%B9-%EC%84%9C%EB%B2%84-%EA%B0%9C%EB%B0%9C)
            - [어플리케이션 개발](#%EC%96%B4%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98-%EA%B0%9C%EB%B0%9C)
        - [DOM, BOM 정의](#dom-bom-%EC%A0%95%EC%9D%98)
    - [JavaScript 구문](#javascript-%EA%B5%AC%EB%AC%B8)
        - [JavaScript 정의 방법](#javascript-%EC%A0%95%EC%9D%98-%EB%B0%A9%EB%B2%95)
        - [출력방법](#%EC%B6%9C%EB%A0%A5%EB%B0%A9%EB%B2%95)
            - [입출력](#%EC%9E%85%EC%B6%9C%EB%A0%A5)
        - [데이터 타입](#%EB%8D%B0%EC%9D%B4%ED%84%B0-%ED%83%80%EC%9E%85)
        - [변수 선언](#%EB%B3%80%EC%88%98-%EC%84%A0%EC%96%B8)
        - [주요 연산자](#%EC%A3%BC%EC%9A%94-%EC%97%B0%EC%82%B0%EC%9E%90)
            - [논리 연산자의 다른 활용](#%EB%85%BC%EB%A6%AC-%EC%97%B0%EC%82%B0%EC%9E%90%EC%9D%98-%EB%8B%A4%EB%A5%B8-%ED%99%9C%EC%9A%A9)
        - [제어문](#%EC%A0%9C%EC%96%B4%EB%AC%B8)
        - [script 태그 내 오류 발생 시](#script-%ED%83%9C%EA%B7%B8-%EB%82%B4-%EC%98%A4%EB%A5%98-%EB%B0%9C%EC%83%9D-%EC%8B%9C)
        - [리터럴](#%EB%A6%AC%ED%84%B0%EB%9F%B4)
        - [isNaN](#isnan)

<!-- /TOC -->
---

## 배우게 될 내용
1. 구문
2. 기본 API : 표준 API, BOM, DOM
3. Map API : KaKao API, Google API
4. HTML5 API : Drag & Drop, Storage
5. Ajax 프로그래밍
6. EcmaScript6 에서 추가된 구문
---

## JavaScript 정의

### JavaScript란
- 객체 기반의 스크립트 프로그래밍 언어
- 웹브라우저 내에서 주로 사용
- 리치 콘텐츠를 작성할 수 있는 AJAX의 등장으로 가치가 재검토됨
- HTML5의 API로 JavaScript가 공식 채택됨

### ECMAScript
- ECMA에서 착실하게 언어의 표준화를 진행시켜 언어로서의 완성도를 높힘
- 현재 대부분의 브라우저들이 지원하는 JavaScript는 ECMAScript 6 표준을 따르고 있음

### 활용 범위

#### 웹 클라이언트 개발
- 웹 클라이언트에서 처리하려는 기능들을 표준적인 방법으로 구현할 수 있게 지원하는 API를 JavaScript로 제공

#### 웹 서버 개발
- Node.js의 출현으로 JavaScript를 활용한 서버 개발이 가능
- 보다 쉽게 JS로 서버를 개발할 수 있는 환경 제공

#### 어플리케이션 개발
- 웹이 하나의 플랫폼으로 진화하면서 웹 OS를 표방한 여러 가지 프로젝트가 진행되고 있음

### DOM, BOM 정의
- DOM : Document Object Model 문서 객체 모델
- BOM : Browser Object Model 브라우저 객체
---

## JavaScript 구문

### JavaScript 정의 방법
- HTML 내의 어느 부분에 삽입해도 가능하나 주로 필요에 따라 < head>나 < body> 태그에 삽입
- 헤더 부분에 위치한 JS 코드는 컨텐트 내용의 랜더링 이전에 브라우저에 의해 먼저 해석되어 랜더링 지연의 결과가 될 수 있음
- 이벤트 핸들러 기능의 **JavaScript 코드**는 가급적 < body> 태그의 마지막 부분 즉, **< /body> 태그의 바로 위에 삽입**

### 출력방법
```html
<script>
window.alert("(1) 어디에 출력될까?"); // 알람창
console.log("(2) 어디에 출력될까?"); // 개발자도구-console 탭
document.write("(3) 어디에 출력될까?"); // 웹페이지 Document 내
</script>
```

#### 입출력
- window.alert() : 경고창(메시지 서브창)을 통해서 메시지를 알리는 역할
- window.prompt() : 필요한 데이터를 입력받는 역할의 서브창 출력
  - return 값 String
  - 입력없이 확인 버튼 클릭되면 ----> **
  - 취소버튼 클릭되면 -------------> null
  - 반복문 내에서 실행되면 우선 입력을 다 받음. (for문의 경우)
- window.confirm() : 양자 택일을 선택할 수 있는 역할의 서브창 출력

### 데이터 타입
- number, string, boolean, null 그리고 undefined로 구분되는 기본형 타입과 객체 타입으로 나뉨
- 변수에 어떤 값을 넣는가에 따라 변수의 타입이 정해짐
- 문자형이 없음
- number
  - 100, 3.14
- 문자열 타입
  - "가나다", 'abc'
  - == 으로 비교 가능
- 논리 타입
  - true: false
  - 0, null, undefined, "" 은 모두 false로 취급
- 객체 타입
  - Key Value 쌍의 딕셔너리 같은 것
    ```javascript
    var v1 = new Object();
    document.write("<li>"+ v1 +"</li>");		// [object Object] --> v1.toString()의 결과
    document.write("<li>"+ typeof v1 +"</li>");	// object
    document.write("<li>"+ (v1+10) +"</li>");	// [object Object]10
    ```

### 변수 선언
- var
  - var로 변수를 선언하면 어떤 값을 넣는가에 따라 변수의 타입이 정해짐
  - 같은 이름의 변수 여러번 선언 가능
  - 지역 변수는 지원하지만 블럭 scope를 지원하지않음
    - for문 내에서 사용한 변수가 밖에서도 사용 가능하다는 뜻
- let
  - 블럭 scope를 가짐
  - 같은 이름의 변수를 두번 이상 선언할 수 없음
  - for문에서는 가급적이면 let을 사용하는 것이 좋음

### 주요 연산자
- 수치 연산자
  - 덧셈(+) 연산자를 제외한 나머지는 숫자 문자열 데이터가 들어오면 알아서 숫자로 변환 후 변환함
  - 덧셈 연산자는 문자열 결합됨
    - 숫자로 변환 필요
    ```javascript
    console.log("abc">"ABC"); // true --> ASCII 코드를 비교함, 처음 자리부터 시작해서 같으면 그 다음 같으면 또 그 다음을 비교함
    ```
- 비교 연산자
  - ==, !=
    - type이 다르면 형변환해서 비교함
    - true == 1은 true (!=면 false)
  - ===, !==
    - type도 동일해야 같은 것으로 간주함
- 조건 연산자
- 대입 연산자
- 비트연산자
- 타입 점검 연산자
  - typeof
    - 현재 변수가 어떤 타입인지 확인하는 연산자
    ```javascript
    document.write("<h2>"+ typeof null +"</h2>");	// object, null이 아님! --> 자바스크립트의 버그, null을 체크하는 항목이 누락되어서 그럼
    ```
- 삭제 연산자
  - delete
    - 객체의 멤버, 배열의 element가 필요하지않으면 지울 수 있음

#### 논리 연산자의 다른 활용
  - &&
    - a && b
    - 조건식(boolean이 return되는 식) && 조건식이 참일때 수행하려는 식
    - b 위치에는 뭐가 오든 상관 없음
  - ||
    - a || b
    - 조건식 || 조건식이 거짓일 때 수행하려는 식
    - 위와 동일
  - &&는 둘 다 참이면 -> a가 참이면 b를 확인하지만 a가 거짓이면 b를 확인하지 않는 것을 이용
  - ||는 둘 중 하나라도 참이면 -> a가 거짓이면 b를 확인하지만 a가 참이면 b를 확인하지 않는 것을 이용

### 제어문
- 조건 제어문 if, 다중 분기문 switch
  - switch 문에 사용되는 비교식에 데이터 타입의 제한이 없음
- 반복 제어문 for, while, do-while
  - for...in 반복문 사용 가능 (for-each문)
    - 지정된 배열이나 객체 내의 요소/멤버에 대해 선두부터 마지막까지 순서대로 반복 문장 수행
    - 자바스크립트의 foreach문은 자바의 foreach문과 다름
    - 자바스크립트의 foreach문에 사용되는 멤버 변수는 element가 아닌 index
    ```javascript
    for(var i in array){
      // sum += i  // 이렇게 하면 인덱스값만 더해짐
      sum += array[i];
    }
    ```
- 분기 제어문 break, continue
- 예외처리 구문 지원
  - 가급적이면 try-catch-finally를 사용하지않고 예외가 일어나지않게끔 구현하는 것이 좋음
  - 예외처리 비용이 큼

### script 태그 내 오류 발생 시
```html
<script>
	document.writeln(123);
	document.writeln(v1+"<br>");	// 오류 발생
	document.writeln(456);			// 같은 script 태그 내의 내용은 더이상 처리하지않고 넘어감
</script>
<hr> <!-- 그 다음 태그부터는 계속 처리함 -->
<script> 
var v1;
document.writeln(v1+"<br>");
```

### 리터럴
- NaN
  - Not a Number 의 약자
  - 숫자가 아닌 변수에 숫자 연산을 시도하면 나오는 리터럴
    ```javascript
    console.log("자바스크립트"*10); // NaN
    ```
- Infinity
  - 양의 수를 넘는 무한대를 나타내는 값

### isNaN()
- 입력된 내용이 숫자가 될 수 있는 값인지 체크
- is Not a Number?
- Number가 될 수 없는 값이면 true
- Number가 될 수 있으면 false