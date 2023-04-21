# 🔥이웃집 반찬 중개 커뮤니티 프로젝트 - '이웃집 반찬'

### 📆개발 기간

🕓 23.03.07 ~ 23.04.07


### 💡기획 배경
<div dir="auto" style="display: flex;">
<img width="1180" alt="스크린샷 2022-12-27 오전 12 09 34" src="https://user-images.githubusercontent.com/122762472/233271052-0c5c7132-5d41-460f-99fa-cef79298b72f.png" style = "width: 45%; height : 45%">
</div>


### ✨기대 효과
<img width="1161" alt="스크린샷 2022-12-27 오전 12 20 31" src="https://user-images.githubusercontent.com/122762472/233271146-a61e54a2-2d8b-4e3b-bad4-fb17ba64e077.png" style = "width: 45%; height : 45%">


### 🛠️프로젝트 사용 툴
<img width="1160" alt="스크린샷 2022-12-27 오전 12 23 33" src="https://user-images.githubusercontent.com/122762472/233268915-f125e920-4367-400e-9c12-60b88cba41b6.png" style = "width: 45%; height : 45%">

----------------------------------------------------------------------------------------------------------------------

### 🏆프로젝트 전체적인 타임라인<br>
|일자|내용|구체적인 활동|
|:---------:|:--------:|:-------:|
|3월 9일 ~ 3월 10일|주제 선정|주제 선정 및 메뉴트리 작성, ERD 설계 |
|3월 10일 ~ 3월 10일 | 역할 분담 | 퍼블리싱 역할 분담 |
|3월 10일 ~ 3월 25일| 퍼블리싱 작업 및 DB| 퍼블리싱 작업 시작, DB 작업 |
|3월 25일 ~ 3월 25일 |설계| 백엔드 사전 설계 작업 |
|3월 20일 ~ 4월 7일|Back 작업|백엔드 역할 분담 및 백 작업|

----------------------------------------------------------------------------------------------------------------------

### 🏆나의 프로젝트 타임라인<br>
|일자|담당 파트|작업 내용|
|:---------:|:---------:|:-----------:|
|3월 10일 ~ 3월 25일|Front-end| 웹 퍼블리싱 작업 완료 |
|3월 25일 ~ 3월 28일|Back-end| 회원가입 (정규식) 완료 |
|3월 26일 ~ 4월 2일|Back-end| 회원가입 (중복검사, DB저장) 완료 |
|3월 29일 ~ 4월 2일|Back-end| 로그인 (아이디 저장, 로그인 구현) 완료 |
|4월 2일 ~ 4월 3일|Back-end| 로그인 (간편로그인 - 카카오, 간편로그인 - 네이버) 완료 |
|3월 26일 ~ 4월 4일|Back-end| 메인페이지 (지역별 최근 게시물, 별점 인기순) |
|4월 3일 ~ 4월 4일|Back-end| 메인페이지 (랜덤 추천 게시물) |
|4월 5일 ~ 4월 6일|Back-end | 마무리 작업 |

----------------------------------------------------------------------------------------------------------------------

### 🏷️담당 업무
Front-end<br>
  마이페이지

Back-end<br>
1. 로그인
  - 로그인 기능 구현
  - 쿠키를 사용한 아이디 저장 
  - OAuth를 활용한 카카오 간편 로그인
  - OAuth를 활용한 네이버 간편 로그인
  
2. 회원가입
  - 회원가입 기능 구현
  - 필수사항 및 형식 입력 검사
  - 중복 검사

3. 아이디/비밀번호 찾기 
  - 계정 검사
  - 형식 입력 검사
  - 구글 mail API를 활용한 메일 전송
  - 비밀번호 변경


4. 메인페이지
  - 지역별 최신 게시물
  - 별점 인기순
  - 랜덤 추천 게시물

----------------------------------------------------------------------------------------------------------------------

### DB - ERD



----------------------------------------------------------------------------------------------------------------------
  
### 🌟느낀점
<h3>5-1. 어려웠던 부분</h3>
📌그룹 채팅 DB를 설계할 때, 하나의 메세지에 대해 채팅 수신자가 여러명인 점을 어떻게 반영해야할지 고민이 많이 됐다. <br>
✔ 채팅 테이블과 채팅 수신자 테이블을 따로 만들어서 채팅 테이블 PK를 채팅 수신자 테이블에서 참조하도록 구성했다.<br><br>
📌프로젝트 초반에는 entity와 DTO를 언제 어떻게 구분해서 사용해야 하는지 감이 잘 잡히지 않아서 헷갈렸다. <br>
✔ 프로젝트를 통해 학습과 적용을 반복하다보니 자연스레 언제 사용해야 하는지 알게됐다. 특히, DTO에 내가 필요한 변수를 능숙하게 선언, 사용 할 수 있게 됐다는 점이 큰 수확이었다. <br><br><br><br>


<h3>5-2. 문제를 해결했던 부분</h3>
<h4>📌WebSocket session 실종사건</h4> <br>
🌩문제 상황🌩<br>
웹소켓의 경우 해당 채팅방에 접속한 모든 참여자의 WebSocketSession을 받아와서 메세지를 보낸다. 메세지를 보내는 메소드는 자바스크립트 메소드인 onMessage()인데, 어찌된 일인지 onMessage 메소드가 실행되질 않았고, 오류문도 나오지 않았다.<br><br>
🚨문제 원인🚨 <br>
채팅이 전송될 때 거치는 모든 메소드와 컨트롤러에 전부 로그를 찍어봤는데, list에 담아둔 WebSocketSession이 중간이 실종된다는 것을 확인했다. 즉, 메세지를 받을 대상이 없었기 때문에 onMessage 메소드가 실행되지 않았던 것이다. <br><br>
🚀해결 방법🚀<br>
WebSocketSesssion을 담아뒀던 list를 static으로 선언해서 해결했다. Java에서 Static 변수는 메모리에 한번 할당되어 프로그램이 종료될 때 해제되는 변수로, 메모리에 한번 할당되므로 여러 객체가 해당 메모리를 공유하게 된다.<br><br><br>



<h4>📌채팅방 확성기 기능 사건</h4> <br>
🌩문제 상황🌩<br>
A사용자가 a채팅방에 보낸 메세지가 B사용자가 접속중인 b채팅방에도 전송되는 현상이 발생했다. 이 현상이 마치 게임 메이플스토리의 캐시템 중 하나인 확성기 같았기에 채팅방 확성기 기능 사건이라 명명했다.<br><br>
🚨문제 원인🚨 <br>
위에서 접속자들의 WebSocketSession을 static list에 담았다고 적은 바 있다. 다른 채팅방에 접속 중인 사용자의 세션 또한 동일한 list에 담겨있었기 때문에 메세지를 받게된 것이다. 그렇다고 static을 지우자니 다시 메세지 전송이 되질 않았다. <br><br>
🚀해결 방법🚀<br>
메세지를 전송하는 메소드에서 발신자의 채팅방과 수신자의 채팅방이 일치하는 세션들에만 메세지를 전송하도록 만들었다. 이를 위해 우선 채팅방을 클릭했을 때 이동하는 컨트롤러에서 HttpSession에 채팅방 아이디를 추가하도록 만들었다. 즉, 채팅방을 클릭할때마다 HttpSession에 저장된 채팅방 정보가 바뀌는 것이다.<br>다음으로, WebSocketConfig 파일에 .addInterceptors(new HttpSessionHandshakeInterceptor()) 를 추가했다. 이를 통해 HttpSession에 저장돼있던 값들을 WebSocketSession에도 저장할 수 있게했다. 이 두가지 작업을 통해 현재 사용자 어떤 채팅방에 접속한 것인지 확인할 수 있었고, 확성기 오류 또한 해결할 수 있었다.<br><br><br>



<h4>📌메세지가 여러번 출력되는 오류</h4> <br>
🌩문제 상황🌩<br>
A 사용자가 a채팅방 입장 → b채팅방 입장 → 다시 a채팅방 입장 이런식으로 동일한 채팅방에 여러번 입장, 퇴장을 반복할 경우 해당 사용자가 보내는 메세지가 화면에 여러번 출력됐다.<br><br>
🚨문제 원인🚨 <br>
위에서 접속자들의 WebSocketSession을 static list에 담았다고 적은 바 있다. 동일한 유저가 동일한 채팅방에 여러번 입장했더라도 해당 유저의 WebSocketSession은 list에 하나만 담겨있어야 한다. 그러나 입장을 할 때 마다 해당 유저의 WebSocketSession이 list에 추가되면서 메세지가 입장한 횟수만큼 전송된 것이다. <br><br>
🚀해결 방법🚀<br>
WebSocketSession을 list에 담지 않고, map의 value 값으로 담았다. map의 key 값은 HttpSession에서 가져온 유저의 아이디로 설정했다(중복 방지). 이를 통해 채팅방에 입장할 때 해당 유저의 아이디가 map에 key값으로 존재한다면 그 key의 value 값을 갱신하고, 존재하지 않는다면 key값과 value 값을 map에 추가하는 방식으로 구성했다. 따라서 동일한 유저의 webSocketSession이 여러번 저장되지 않았고, 중복 출력 또한 해결됐다.




<h3>5-4. 총평</h3>
<h4>🌟 두려워하지 말자. 나는 내 생각보다 집요한 사람이다. </h4>



웹소켓이라는 기술은 국비 교육 중 배우지 않고 독학해서 프로젝트에 적용한 기술이다. 당연히 주변에 물어볼 수 있는 사람도 없었다. 로직을 이해하는 것도, 오류를 해결하는 것도 너무 막막해서 초반에는 많이 괴로웠다. 특히 채팅 전송이 정상적으로 되지 않을 때 오류문이 나오지 않아서 더 힘들었다. 그러나 결국 나는 해내고야 말았다. 메세지가 거치는 모든 메소드에 값이 들어왔는지 로그를 전부 찍어서 문제의 원인을 발견하고 해결했다. 이 과정에서 나도 나 자신의 집요함과 끈기에 놀랐다. 지금까지 항상 스스로의 한계를 정해두고 새로운 도전을 꺼렸었는데, 이 프로젝트를 계기로 한발짝 도약한 것 같아 행복했다. 



<h4>🌟 내가 마주한 오류와 해결방안을 구체적으로 기록해두자. </h4>
