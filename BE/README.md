# BE

## 요구사항

1. 메뉴 조회
    1. main 조회
    2. soup 조회
    3. side 조회
2. 디테일 조회
3. 상품 주문
4. OAuth 로그인
5. 자동배포

<br>

## DB 설계

[링크](https://docs.google.com/spreadsheets/d/1opVci7IUWq1uetNHIewXkxdeOnB9R_RccBbU6THEJCI/edit#gid=0)

<br>

## URL 설계

|http Method|URL| 역할 | | -- | -- | -- | | GET | /menus | 전체 조회 | | GET | /menus?type=main | 메인 조회 |
| GET | /menus?type=soup | 수프 조회 | | GET | /menus?type=side | 반찬 조회 | | GET | /menus/detail/{id} |
메뉴 상세 조회 | | POST | /menus/detail/{id} | 메뉴 주문 |

<br>

## API 설계

### 메뉴 조회 시 Response Body

![image](https://user-images.githubusercontent.com/81368630/164416950-bf6ad03c-94ce-4c36-a164-b1a55969f1a5.png)

<br>

### 메뉴 상세 조회 시 Response Body

![image](https://user-images.githubusercontent.com/81368630/164416608-1a457c11-fbdc-4d2d-b1db-95cbbff86d42.png)

<br>

### 메뉴 주문

<br>
주문 시 Request Body (주문 메뉴는 path variable로 주어짐)

![image](https://user-images.githubusercontent.com/92678400/165826746-65e54262-bced-40c1-a40c-9e54f2360b6c.png)

Response Body

![image](https://user-images.githubusercontent.com/92678400/165826777-da427796-5634-4625-abb3-775fd85e0d46.png)



---

## OAuth

간단! 로그인

AOS에서 서버:8080/login 으로 GET 요청을 보내면 OAuthController에서 요청을 처리하여 인증 성공 시 <br>
Access Token과 세션Id를 매핑하여 JSESSIONID를 쿠키에 담아 응답한다.

<img width="448" alt="image" src="https://user-images.githubusercontent.com/92678400/165870867-602c160c-cb86-44a2-89d9-c0e47a287d5b.png"> <br><br>

![image](https://user-images.githubusercontent.com/92678400/165830510-03b99f99-0c51-4c44-9b37-f53dc8b4556c.png) <br><br>

#### A. Header 에 client ID와 redirect URL을 담아 요청을 보낸다<br>

URL: `https://github.com/login/oauth/authorize?client_id=클라이언트아이디&redirect_uri=리다이렉트URI`
<br>
클라이언트 id는 github OAuth Apps에서 서비스를 등록하면 발급된다.

```java
@GetMapping("/login")
public ResponseEntity<String> login()throws URISyntaxException{
	HttpHeaders httpHeaders=new HttpHeaders();
	httpHeaders.setLocation(new URI(REDIRECT_GITHUB_URL));
	return new ResponseEntity<>(httpHeaders,HttpStatus.SEE_OTHER);
```

#### B. 유저 로그인

#### C. User Github 로그인이 성공하면 Authorization Code가 담긴 redirect 요청이 **A** 에서 지정된 redirect url로 보내진다

(ex: `http://localhost:8080/afterlogin?code=@@@@@` )
<br><br>

#### D. Authorization Code와 CLIENT_ID, CLIENT_SECRET을 Reqeust Body에 담아 github에 POST 요청

`https://github.com/login/oauth/access_token` 으로 POST 요청을 보낸다

```java
OauthDto oauthDto=new OauthDto(code,System.getenv("CLIENT_ID"),
	System.getenv("SECRET_CODE"));
	String queryParam=restTemplate.postForObject(GITHUB_ACCESS_TOKEN_URL,oauthDto,
	String.class);
```

#### E. 돌아오는 응답에 포함된 **Access Token**을 받는다

현재 코드에서는 토큰을 Session에 저장하고 AOS로 전달할 때는 JSESSIONID로 변환하여 Set-Cookie로 내려주도록 하였다 <br>

### 개선할 점

* Token을 이용해 github에 유저정보를 요청하여 현재 로그인된 유저 정보 저장하기
* 유효한 Token인지 검증하는 로직 추가(현재는 Access Token이 유효하지 않은 것이더라도 가지고만 있으면 통과시켜준다)
* 세션Id 대신 JWT 토큰으로 변환하여 내려주기

---

## 자동 배포

#### FLOW

1. 자동으로 배포할 원격저장소를 clone


2. 서버에서 빌드가 가능하도록 Swap 메모리 할당<br>


3. 배포 스크립트 작성


4. 정해진 시간마다 스크립트가 실행되도록 Crontab 사용

### 배포 스크립트

```shell
#!/bin/bash

export profile= deploy
export DB_URL= DB 주소
export USER_NAME= DB id
export USER_PASSWORD= DB pw
export CLIENT_ID= 깃헙 OAuth App에서 발급 받은 id
export SECRET_CODE= 깃헙 OAuth App에서 발급 받은 secret code
export SERVER_IP= 배포서버 IP

cd sidedish/BE

git fetch
remote=`git rev-parse origin/deploy`
present=`git rev-parse HEAD`

if [[ $remote == $present ]]; then
echo "No need to deploy" 
exit 0
else
echo "Start deploy..." 
fi

git merge origin/deploy

sidedish=`jps | grep jbc | cut -d' ' -f1`
kill -9 $sidedish

rm -rf build
./gradlew bootJar

nohup java -jar build/libs/jbc-0.0.*-SNAPSHOT.jar &
```

* crontab으로 실행 시 환경변수가 읽히지 않아 스크립트에 포함시켰다
* 스크립트 파일에도 실행 권한을 부여한다: `chmod +x 스크립트파일`

### 개선할 점

* 브랜치를 잘못 관리하여 deploy 브랜치와 origin/deploy 브랜치가 분기되더라도 origin의 deploy브랜치에 항상<br>
  merge가 되도록 스크립트 개선하기

### Thanks to

@나단이 정리해준 글 덕분에 수월하게 진행할 수 있었습니다. (감사합니다 나단!!)


--- 

## 미션 전체적으로 개선할 점

### 예외 처리 <br>

에러만 던지거나 메시지 없이 400번대 응답만 보냄

### 테스트 코드<br>

JK가 수업 때 그렇게 강조하셨으나.. 미션 요구사항 충족에만 집중하느라 테스트 코드를 작성하지 못함
