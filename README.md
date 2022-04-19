# SideMenu-Team23(진솔)

## 🐳 Member

| 🍎iOS | [Damagucci-juice](https://github.com/Damagucci-Juice) | [Sol](https://github.com/Hansolkkim) |
| ---- | ----------------------------------------------------- | ------------------------------------ |
| MBTI | ESTP - 수완 좋은 사업가 형 | ISFJ - 용감한 수호자, **실용적인 조력가**|



## 🎃 GroundRule

1. 하기로 했던 일은 해오기다 못해도 최소한 성의는 보이자
2. 지칠 수도 있다 생각하고 서로 이해해주는 팀 프로젝트 진행하기
3. 스크럼/ 회의에 `지각`하지 말기
4. `1일1머지`로 서로 Conflict 예방하기
5. `일일회고` 작성하기 -->  [ios회고판](https://docs.google.com/spreadsheets/d/1Vs06jNSBcz5s-Rhb29VR825VpOBJWcloxQF3MLnZ6_8/edit#gid=1299106843)
6. 코어 타임 이후엔 줌(iOS) or slack DM
7. 한 주마다 마무리하는 리드미 작성 (- 데모 발표 자료로 사용, 단 작성자와 발표자는 다르다.)


## 🧶 Git-Flow 전략

![GitFlow](https://user-images.githubusercontent.com/50472122/163747266-12451ab4-7827-4138-80b6-b6d114de2de8.png)

```
CodeSquad Repo(Upstream)
└── JinSol (Origin, Remote Repo? branch?)
   └── dev (Branch)
        ├── feature-UI(Branch)		// 예시
        └── feature-login
        └── feature-network
```

- 참조 : [Semantic Commit Convention](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)


## 🙋‍♂️ 이번 프로젝트에서 도입하고 싶은 분야

###  동시성 
	- Download Task
### login 
	-  AppleId
### 이슈관리 
	-  깃 issue, project
	
### Network
```
- slack API 끌어와서 쓰는 것을 [1 순위]
- Server Mock API [2 순위]
- Core Data(인터넷 연결안될때) [2 순위]
  - 서버와 Core Data 동기화 문제 [3 순위]
```
* 참조 : [MockServer](https://medium.com/@jamesjunsungkim/how-to-create-a-network-mockup-in-swift-cab5b73da4e1) 

### UI
	- 다양한 iPhone 디바이스에 대응하기 위해 `UIScreen.main.bounds` 등 전략 모색
	- 디바이스 회전에 대응하는 전략 모색

