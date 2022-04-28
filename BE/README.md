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

AOS에서 서버:8080/login 으로 GET 요청을 보내면 OAuthController에서 요청을 처리하여 Access Token과 매핑 되어있는 JSESSIONID를 쿠키에
담아 응답한다.

<img width="405" alt="image" src="https://user-images.githubusercontent.com/92678400/165826439-45c37bb7-4b0a-4fdf-a401-5b59ea846ff2.png">

A. Header 에 redirect URL을 담아 redirect 요청을 보낸다<br>
URL: `https://github.com/login/oauth/authorize?client_id=클라이언트아이디&redirect_uri=리다이렉트URI`
<br>
클라이언트 id는 github OAuth Apps에서 서비스를 등록하면 발급된다.

![image](https://user-images.githubusercontent.com/92678400/165830510-03b99f99-0c51-4c44-9b37-f53dc8b4556c.png)

```java
@GetMapping("/login")
public ResponseEntity<String> login()throws URISyntaxException{
	HttpHeaders httpHeaders=new HttpHeaders();
	httpHeaders.setLocation(new URI(REDIRECT_GITHUB_URL));
	return new ResponseEntity<>(httpHeaders,HttpStatus.SEE_OTHER);
```

<br>
C. User Github 로그인이 성공하면 Authorization Code가 담긴 redirect 요청이 **A** 에서 지정된 redirect url로 보내진다
(ex: http://localhost:8080/afterlogin?code=@@@@@ )
<br><br>

D. Authorization Code와 CLIENT_ID, CLIENT_SECRET을 Reqeust Body에 담아
`https://github.com/login/oauth/access_token`으로 POST 요청을 보낸다

```java
OauthDto oauthDto=new OauthDto(code,System.getenv("CLIENT_ID"),
	System.getenv("SECRET_CODE"));
	String queryParam=restTemplate.postForObject(GITHUB_ACCESS_TOKEN_URL,oauthDto,
	String.class);
```

E. 돌아오는 응답의 query parameter에 포함된 **Access Token**을 받는다

현재 코드에서는 토큰을 Session에 저장하고 AOS로 전달할 때는 JSESSIONID로 변환하여 Set-Cookie로 내려주도록 하였다 <br>
만약 더 구현을 더 진행한다면

* 세션Id 대신 JWT 토큰으로 변환하여 내려주기
* Token을 이용해 github에 유저정보를 요청하여 현재 로그인된 유저가 누구인지 판별하기

를 해보는게 좋을 것 같다.

---

## 자동 배포
