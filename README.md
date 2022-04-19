# sidedish
코드스쿼드 두번째 그룹 프로젝트

## ⭐️ 팀원 소개
#### Phil 
> phil so gooood
#### Hanse
> 싸우지 말고 재밌게 소통하면서 해보자!
#### dotori
> 열코즐코합시다~~  
    ( ՞ਊ ՞ )　  
   ＿(_つ/￣￣/＿  
　 ＼/＿＿/            
#### 메이브
> 즐겁게 2주동안 해보자!


## 🛠 브랜치 전략
- team-02 : 메인 배포 브랜치
- dev-BE : BE 브랜치
- dev-FE : FE 브랜치
- `feat-fe/{feature_issue_number}`: 프론트엔드 기능별 브랜치
- `feat-be/{feature_issue_number}`: 백엔드 기능별 브랜치
  - feature branch를 통한 개발이 끝나면 PR을 통해 develop branch에 merge한다.
  - PR merge 후 해당 브랜치는 삭제한다.
  - PR merge
    - feature->develop은 클래스 별로 리뷰/확인했다는 comment(LGTM) 남겨주고 서로 merge
    - develop->main은 이번 배포 주기에 대한 기능을 PR하고 동작 확인 후 merge
    - 주차별 개발 목표 설정 후, 개발이 완료된 기능에 대해 배포 진행

## 🔥 그라운드 롤
- 10:00 ~ 10:30 데일리 스크럼 진행
- 활동 시간은 유동적으로 그 날의 진행도에 따라 변경
- 주요 기능은 함께 논의하며 구현
- 기능 구현 후 PR 제출 하면 상대방이 확인 후 Merge 해주기
- PR 은 4시까지
 ※ 이외 변경사항은 팀원과 협의하여 탄력적으로 조정
- 오후 5시에 팀 주간 회고 진행
- 미션 진행 중 질문은 zoom에서 자유롭게 소통

## 🖥 Commit Rule
+ feat : 새로운 기능 추가
+ fix : 버그 수정
+ refactor : 코드 리팩토링
+ style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
+ test : 테스트 코드
+ docs : 문서 수정
+ chore : 빌드 업무 수정, 패키지 매니저 수정
+ design : CSS 등 사용자 UI 디자인 변경
+ rename: 디렉토리 및 파일명 변경 
