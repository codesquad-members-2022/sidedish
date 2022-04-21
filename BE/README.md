# BE

### 요구사항

1. 메뉴 조회
   1. 전체 조회
   2. main 조회
   3. soup 조회
   4. side 조회
2. 디테일 조회
3. 상품 주문
4. OAuth 로그인
5. 자동배포

<br>

### DB 설계

[링크](https://docs.google.com/spreadsheets/d/1opVci7IUWq1uetNHIewXkxdeOnB9R_RccBbU6THEJCI/edit#gid=0)

<br>

### URL 설계

|http Method|URL| 역할 |
| -- | -- | -- |
| GET | /menus       | 전체 조회 |
| GET | /menus/main  | 메인 조회 |
| GET | /menus/soup  | 수프 조회 |
| GET | /menus/side  | 반찬 조회 |
| GET | /menus/detail/{id}  | 메뉴 상세 조회 |
| POST | /menus/detail/{id} | 메뉴 주문 |

<br>

### API 설계

홈 조회 시 Response Body Json 형식

![image](https://user-images.githubusercontent.com/81368630/164416950-bf6ad03c-94ce-4c36-a164-b1a55969f1a5.png)

<br>

메뉴 상세 조회 시 Response Body Json 형식

![image](https://user-images.githubusercontent.com/81368630/164416608-1a457c11-fbdc-4d2d-b1db-95cbbff86d42.png)

<br>

주문 시 Request Body Json 형식 (안드로이드에서 백엔드로 보내주는 형식)

!!!! 메뉴 가격은 할인 적용 후의 가격을 보내주셔야 함 !!!!

<img width="287" alt="image" src="https://user-images.githubusercontent.com/81368630/164470457-4ef4fff1-ee0f-4f4b-ad27-3d506b9e8a72.png">
