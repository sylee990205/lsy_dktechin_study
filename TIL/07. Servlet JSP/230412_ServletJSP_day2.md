# 230412 ServletJSP day2
## 목차
<!-- TOC -->

- [ServletJSP day2](#servletjsp-day2)
    - [목차](#%EB%AA%A9%EC%B0%A8)
    - [상태정보 유지 기술](#%EC%83%81%ED%83%9C%EC%A0%95%EB%B3%B4-%EC%9C%A0%EC%A7%80-%EA%B8%B0%EC%88%A0)
        - [상태 정보 유지 방법](#%EC%83%81%ED%83%9C-%EC%A0%95%EB%B3%B4-%EC%9C%A0%EC%A7%80-%EB%B0%A9%EB%B2%95)
        - [HttpSession 객체를 이용한 방법](#httpsession-%EA%B0%9D%EC%B2%B4%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%B0%A9%EB%B2%95)
            - [구현 방법](#%EA%B5%AC%ED%98%84-%EB%B0%A9%EB%B2%95)
        - [HttpSession의 기타 주요 메서드](#httpsession%EC%9D%98-%EA%B8%B0%ED%83%80-%EC%A3%BC%EC%9A%94-%EB%A9%94%EC%84%9C%EB%93%9C)
        - [servlet 이미지 형식](#servlet-%EC%9D%B4%EB%AF%B8%EC%A7%80-%ED%98%95%EC%8B%9D)

<!-- /TOC -->
---
## 상태정보 유지 기술
- 상태정보 유지
  - 웹 브라우저에서 웹 서버에 정보를 요청할 때 이전 접속시의 결과물(상태정보)을 일정시간동안 유지하는 것
- Http 프로토콜의 통신 방식때문에 해당 기능이 필요
### 상태 정보 유지 방법 
- Cookie를 이용한 방법 
    ![](/TIL/image/2023-04-12-12-20-00.png)
  - 클라이언트에 저장하는 기술 (브라우저에)
  - 저장 시는 반드시 name:value로
  - 응답 헤더에 쿠키 정보를 넣어서 활용
  - 장점
    - 서버에 오버헤드 되지 않음
    - 유효시간을 설정할 수 있음
  - 단점
    - 보안적으로 약함 : 중요한 정보를 쿠키로 저장해선 안됨
- URL 문자열 뒤에 추가하는 방법
- `<form>` 태그의 hidden 타입을 사용하는 방법
  - 클라이언트가 어떤 클라이언트인지 살짝 심어놓고 서버로 전달하고싶을 때 사용
  - 클라이언트한테 응답할 내용이 입력폼이면 hidden type의 input 태그를 사용하여 클라이언트에 심어둠
### HttpSession 객체를 이용한 방법
    ![](/TIL/image/2023-04-12-12-26-13.png)
  - 클라이언트의 상태 정보를 서버가 전부 가지는 방법
  - 필요할 때 우리가 만들어 사용
 
#### 구현 방법
1. HttpSession 객체를 생성하거나 추출한다.
   - `request.getSession()`
   - argument로 아무것도 안주면 true를 주는것과 동일
   - argument로 false를 주면 HttpSession 객체를 추출하여 리턴, 없으면 null 리턴
   - getSession은 생성보다는 준비시킨다고 표현하는 것이 더 맞는 표현
2. HttpSession 객체에 상태정보를 보관할 객체를 등록한다. (한번만 등록하면 된다.)
   - `session.setAttribute("xxx", new Data())`
   - 보관하려는 정보를 객체로 만들어 Http 객체에 저장
   - xxx 라는 이름으로 객체의 참조 값을 보관
3. HttpSession 객체에 등록되어 있는 상태정보 객체의 참조 값을 얻어서 사용한다.(읽기, 변경)
   - `session.getAttribute(“xxx”)`
   - xxx로 보관된 객체에 대한 참조 값을 리턴
4. HttpSession 객체에 등록되어 있는 상태정보 객체가 더 이상 필요 없으면 삭제할 수도 있다.
   - `session.removeAttribute(“xxx”)`
   - "xxx"라는 이름으로 보관된 객체에 대한 참조값을 삭제
   - `session.invalidate()`
   - HttpSession 객첼르 강제로 삭제
```java
1. HttpSession session = request.getSession(); 
2. session.setAttribute(“xxx”, new Data());
3. Data ref = (Data)session.getAttribute(“xxx”);
4. Session.removeAttribute(“xxx”);
```

- Http 세션 객체는 웹 클라이언트 별로 하나씩 만들어짐
- Session 객체 생성 시 세션 ID 부여
- 응답 시 Session ID를 쿠키 기술을 활용해 클라이언트에 저장
- 요청 시 cookie에 Session ID를 담아 체크
- 브라우저에 저장되는 세션 ID에 대한 쿠키의 최대 유지 시간 == 브라우저가 살아있는 동안
- 마지막 요청 후 `30분 이상` 요청하지 않으면 Session 객체 자동 삭제
  - Session 객체를 서버가 계속 유지할 수는 없기 때문

### HttpSession의 기타 주요 메서드
| 메소드 | 기능 |
| ----- | ---- |
| public Enumeration getAttributeNames() | 세션에 등록된 객체들의 이름을 열거 | 
| public long getCreationTime() | 1970. 1.1 GMT 부터 세션이 만들어졌을 때까지의 시간을 밀리초의 단위로 리턴 |
| public String getId() | 세션에 지정된 세션 ID를 리턴 |
| public long getLastAccessedTime() | 클라이언트 요청이 마지막으로 시도된 시간을 밀리초로 리턴 |
| public int getMaxInactiveInterval() | 클라이언트의 요구가 없을 때 서버가 현재의 세션을 언제까지 유지할지를 초시간 단위로 리턴<br>이때 디폴트 세션마감시간은 30분으로 지정
| public boolean isNew() | 서버측에서 새로운 세션을 생성한 경우에는 true를 리턴<br>기존의 세션이 유지되고 있는 경우라면 false를 리턴 |
| public void setMaxInactiveInterval(int seconds) | 세션 유지 시간 설정<br>이 시간이 지나면 세션은 자동 종료(HttpSession객체 삭제) | 

### servlet 이미지 형식
Servlet이 이미지형식인 경우에 한해서 img 태그의 src 속성에 http://localhost:8088/edu/getImages와 같이 서블릿 매핑명을 줄 수 있음