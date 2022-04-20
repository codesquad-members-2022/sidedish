# 반찬 주문 앱
by Eddy, Kai

## 우리의 중점 학습 목표

1. 네트워킹
   - 재사용할 수 있는 네트워킹 모듈 설계
   - 이미지 다운로드/캐싱
   - OAuth
2. 코드 품질: 
   - 테스터블한 코드 작성
   - 단위 테스트 자동화
   - 예외 처리 및 에러 메시지 작성
3. 설계
   - MVVM
   - 객체 간 커뮤니케이션 패턴

## Ground Rules

### Branch 전략

- upstream/team-18: 코드 리뷰 PR
- origin/dev: 팀 최종 브랜치
- origin/feat-eddy, origin/feat-kai: 각자 작업용 브랜치

- feat에 push한 후, dev로 PR 후 팀원끼리 리뷰. 
- PR 시 github action에서 자동 build & test 통과해야만 merge 가능.
- 코드 리뷰 시 dev에서 team-18로 PR

## Commit / Issue 전략
- 기능 추가 시 Issue에 추가 후 넘버링
- 1분 이상 해결 못하는 에러 발생 시 Issue에 추가 후 넘버링
- Commit에 Issue number 표기.
ex. `[#4] Fix: something` 

### 설계 공유

- [draw.io](https://drive.google.com/file/d/1ImYzNZKLs4mymOJdw64jbN_v6EGrE8OM/view) 문서

![diagram](https://user-images.githubusercontent.com/17468015/164175553-ccf2a861-a0e6-4136-9a95-347da002cc28.png)

## 회의 시간 
- 매일 10:00 AM