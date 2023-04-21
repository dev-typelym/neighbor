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

![neighbor-erd](https://user-images.githubusercontent.com/122762452/231799781-6b4e9a7b-cfa2-4137-896b-1ff217414e38.png)

----------------------------------------------------------------------------------------------------------------------
  
### 🌟느낀점
<h3>1. 어려웠던 부분</h3><br>

✔ 채팅 테이블과 채팅 수신자 테이블을 따로 만들어서 채팅 테이블 PK를 채팅 수신자 테이블에서 참조하도록 구성했다.<br><br>
📌프로젝트 초반에는 entity와 DTO를 언제 어떻게 구분해서 사용해야 하는지 감이 잘 잡히지 않아서 헷갈렸다. <br>
✔ 프로젝트를 통해 학습과 적용을 반복하다보니 자연스레 언제 사용해야 하는지 알게됐다. 특히, DTO에 내가 필요한 변수를 능숙하게 선언, 사용 할 수 있게 됐다는 점이 큰 수확이었다. <br><br><br><br>


<h3>2. 문제를 해결했던 부분</h3>
<h4>📌WebSocket session 실종사건</h4> <br>
🌩문제 상황🌩<br>
웹소켓의 경우 해당 채팅방에 접속한 모든 참여자의 WebSocketSession을 받아와서 메세지를 보낸다. 메세지를 보내는 메소드는 자바스크립트 메소드인 onMessage()인데, 어찌된 일인지 onMessage 메소드가 실행되질 않았고, 오류문도 나오지 않았다.<br><br>
🚨문제 원인🚨 <br>
채팅이 전송될 때 거치는 모든 메소드와 컨트롤러에 전부 로그를 찍어봤는데, list에 담아둔 WebSocketSession이 중간이 실종된다는 것을 확인했다. 즉, 메세지를 받을 대상이 없었기 때문에 onMessage 메소드가 실행되지 않았던 것이다. <br><br>
🚀해결 방법🚀<br>
WebSocketSesssion을 담아뒀던 list를 static으로 선언해서 해결했다. Java에서 Static 변수는 메모리에 한번 할당되어 프로그램이 종료될 때 해제되는 변수로, 메모리에 한번 할당되므로 여러 객체가 해당 메모리를 공유하게 된다.<br><br><br>


<h3>3. 총평</h3>
<h4>🌟 두려워하지 말자. 나는 내 생각보다 집요한 사람이다. </h4>
웹소켓이라는 기술은 국비 교육 중 배우지 않고 독학해서 프로젝트에 적용한 기술이다. 당연히 주변에 물어볼 수 있는 사람도 없었다. 로직을 이해하는 것도, 오류를 해결하는 것도 너무 막막해서 초반에는 많이 괴로웠다. 특히 채팅 전송이 정상적으로 되지 않을 때 오류문이 나오지 않아서 더 힘들었다. 그러나 결국 나는 해내고야 말았다. 메세지가 거치는 모든 메소드에 값이 들어왔는지 로그를 전부 찍어서 문제의 원인을 발견하고 해결했다. 이 과정에서 나도 나 자신의 집요함과 끈기에 놀랐다. 지금까지 항상 스스로의 한계를 정해두고 새로운 도전을 꺼렸었는데, 이 프로젝트를 계기로 한발짝 도약한 것 같아 행복했다. 

