# 230407 JavaScript day5
## 목차
<!-- TOC -->

- [230407 JavaScript day5](#230407-javascript-day5)
  - [목차](#목차)
  - [Canvas API](#canvas-api)
    - [HTMLCanvasObject 객체 접근](#htmlcanvasobject-객체-접근)
    - [그리기 기능 메서드들](#그리기-기능-메서드들)
  - [Multimedia API](#multimedia-api)
  - [Drag\&Drop API](#dragdrop-api)
  - [Web Storage API](#web-storage-api)
    - [웹 스토리지란?](#웹-스토리지란)
    - [window.localStorage와 window.sessionStorage의 주요 멤버](#windowlocalstorage와-windowsessionstorage의-주요-멤버)
    - [Web Storage 데이터 관리](#web-storage-데이터-관리)

<!-- /TOC -->
---
## Canvas API
- 웹 페이지에 그림을 그릴 수 있도록 지원하는 HTML5 API
- `<canvas>` 엘리먼트를 사용하여 그림을 그리기 위한 사각형 영역을 정의함
### HTMLCanvasObject 객체 접근
- `<canvas>` 라는 태그를 사용해서 그림을 그릴 수 있는 공간을 준비해야함
### 그리기 기능 메서드들
| 메서드 | 설명 |
| ------ | ---- |
| fillRect(x, y, width, height) | 색이 칠해진 사각형을 그린다.
| strokeRect(x, y, width, height) | 테두리만 있는 사각형을 그린다.
| clearRect(x, y, width, height) | 특정영역을 지우고 완전히 투명하게 만든다.
| beginPath() | 경로를 시작한다.
| closePath() | 경로를 종료한다.
| stroke() | 경로를 따라서 테두리선을 그린다.
| fill() | 설정된 스타일로 도형을채운다.
| moveto(x,y) | (x,y) 위치로 시작점을 옮긴다.
| lineto(x,y) | x에서 y까지 직선을 그린다.
| strokeText(msg, x, y) | (x,y) 위치에 텍스트를 테두리선만 그린다.
| fillText(msg, x, y) | (x,y) 위치에 텍스트를 색을 채워서 그린다.
| measureText(msg) | 측정된 문자열의 길이 정보를 저장한 TextMetrics 객체를 리턴한다.
| arc(x, y, r, startAngle, endAngle, anticlockwise) | (x,y)에서 시작하여 반시계방향 (anticlockwise)으로 반지름(r)만큼의 원을 그린다.
| quardraticCurveTo(cp1x, cp1y, x, y) | 한 개의 조절점(cp1x,cp1y)을 이용해 (x,y)까지의 곡선을 그린다
| bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y) | 두개의 조절점(cp1x,cp1y)와 (cp2x,cp2y)를 이용해 (x,y)까지의 곡선을 그린다.
| drawImage(image, sx, sy)<br>drawImage(image, sx, sy, sWidth, sHeight)<br>drawImage(image, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight) | 이미지 파일을 읽어서 주어진 위치에 주어진 크기로 또는 슬라이스하여 그린다.

---

## Multimedia API
- `<video>`와 `<audio>`태그 관련 API
- controls, autoplay, loop
  - 설정 여부를 조정하는 boolean 타입의 속성
- currentTime
  - 현재의 재생위치를 초단위로 나타내는 속성
- duration
  - 오디오 또는 비디오 파일의 길이를 초단위로 나타내는 속성
- ended/paused
  - 재생의 종료 여부 또는 일시정지 여부를 나타내는 속성
- canPlayType(type)
  - 브라우저가 해당 미디어 타입을 재생할 수 있는지를 나타내는 문자열
- play()
  - 현재 위치에서 재생을 시작
- pause()
  - 오디오가 재생 중일 경우 일시 정지한다.
---
## Drag&Drop API
- 사용자 편의성을 고려한 UI 기능
- 마우스를 사용하여 애플리케이션 간 파일, 데이터를 전달하는 기능
- 화면 상에 나타나는 요소를 옮기거나 외부에 있는 파일을 읽어 페이지에 출력 또는 업로드 용도로 사용
- draggable 속성 값을 true로 지정
- `<img>` 엘리먼트는 true가 default
![](/TIL/image/2023-04-07-12-39-33.png)
- 모든 HTML 태그는 drop이 되지 않도록 기본 이벤트 handler를 내장하고 있음
- drop이 제대로 작동되려면 이벤트 객체에 반드시 e.preventDefault를 해줘야함
---
## Web Storage API
### 웹 스토리지란?
- 웹 브라우저에 자료를 저장하기 위한 기능으로 로컬 스토리지와 세션 스토리지로 나뉨
  - 로컬 스토리지: 영구 보관
  - 세션 스토리지: 브라우저가 종료될 때까지 보관
- 쿠키와 비슷한 기술, 일부 기능에 차이가 있음
- 저장하려는 데이터마다 유일한 이름을 같이 저장
- 저장하려는 데이터의 종류에 제한 없음 저장시에는 `문자열`로 저장

### window.localStorage와 window.sessionStorage의 주요 멤버
- length : 스토리지에 저장된 key/value 쌍의 개수를 추출하는 속성
- key(index) : 숫자형 인덱스에 해당하는 key를 리턴
- getItem(key) : 스토리지로부터 key에 해당하는 value 를 추출
- setItem(key, value) : 스토리지에 key에 해당하는 value 를 저장
- removeItem(string key) : 스토리지에 key에 해당하는 value 를 제거
- clear() : 현재 스토리지의 모든 데이터를 제거
- onstorage : 로컬 스토리지의 내용이 변경될 때마다 발생되는 이벤트로 로컬 스토리지의 변경 사항을 모니터링 하는 것이 가능함. 
  - StorageEvent 객체가 생성 

### Web Storage 데이터 관리
- 저장
```javascript
//local
localStorage.mykey = "myvalue";
localStorage["mykey"] = "myvalue";
localStorage.setItem("mykey", "myvalue");

//session
sessionStorage.mykey = "myvalue";
sessionStorage["mykey"] = "myvalue";
sessionStorage.setItem("mykey", "myvalue"); 
```
- 읽기
```javascript
//local
var mydata = localStorage.mykey;
var mydata = localStorage["mykey"];
var mydata = localStorage.getItem("mykey”);

//session
var mydata = sessionStorage.mykey;
var mydata = sessionStorage["mykey"];
var mydata = sessionStorage.getItem("mykey”);
```
- 삭제
```javascript
//local
delete localStorage.mykey;
delete localStorage["mykey"];
localStorage.removeItem("mykey");

//session
delete sessionStorage.mykey;
delete sessionStorage["mykey"];
sessionStorage.removeItem("mykey");
```