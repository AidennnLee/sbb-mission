## 스프링부트 게시판(SBB) 미션

### 구조

Controller는 Service에 엔티티 객체 처리를 맡긴다. Service에서는 Repository에 데이터를 요청한다.

#### MainController

- @GetMapping("/") : /question/list로 리다이렉트
- @GetMapping("/sbb") : 환영 페이지

#### QuestionController

- @GetMapping("/question/list") : question_list 템플릿 반환
- @GetMapping("/question/detail/{id}") : question_detail 템플릿 반환 (id에 따른 질문 상세 페이지)

#### AnswerController

- @PostMapping("/create/{id}") : /question/detail/{id}로 리다이렉트

### 패키지

#### question

- Question : 질문 엔티티
- QuestionController : 질문 관련 컨트롤러
- QuestionRepository : 질문 리포지토리
- QuestionService : 질문 서비스
- QuestionForm : 질문 등록 시 입력값 검증

#### answer

- Answer : 답변 객체
- AnswerController : 답변 관련 컨트롤러
- AnswerRepository : 답변 리포지토리
- AnswerService : 답변 서비스
- AnswerForm : 답변 등록 시 입력값 검증

#### user
- SiteUser : 회원 객체
- UserController : 회원가입 컨트롤러
- UserRepository : 회원 리포지토리(JpaRepository<SiteUser, Long>를 상속 받은 인터페이스)
- UserService : 회원 서비스
- UserForm : 회원가입 폼
- UserRole : 회원에게 부여할 권한
- UserSecurityService : 스프링 시큐리티 로그인 처리

### 엔티티

#### 질문(Question) 엔티티

|속성명|	설명|
|---|---|
|id|	질문의 고유 번호|
|subject|	질문의 제목|
|content|	질문의 내용|
|create_date|	질문을 작성한 일시|
|author_id|질문 작성자|

#### 답변(Answer) 엔티티

|속성명| 	설명                  |
|---|----------------------|
|id| 	답변의 고유 번호           |
|question| 	질문 (어떤 질문에 대한 답변인지) |
|content| 	답변의 내용              |
|create_date| 	답변을 작성한 일시          |
|author_id| 답변 작성자               |

#### 회원(SiteUser) 엔티티

|속성명| 	설명       |
|---|-----------|
|id| 회원의 고유 번호 |
|username|	사용자 이름 (사용자 ID)|
|password|	비밀번호|
|email|	이메일|

### 템플릿

#### question_list

질문 목록

#### question_detail

질문 상세 페이지

#### question_form

질문 등록 페이지

#### signup_form

회원가입 페이지

#### login_form

로그인 페이지

#### layout

모든 페이지에 공통적으로 적용되는 레이아웃

#### form_errors

공통적인 오류 메세지를 위한 템플릿

#### navbar

모든 페이지에 공통적으로 적용되는 네비게이션 바

### Exception

- DataNotFoundException : id 값에 해당하는 Question 데이터가 없는 경우