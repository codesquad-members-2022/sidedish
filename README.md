# Sidedish

> 17조 BanchanApp

## 팀원

| [alex](https://github.com/SongTaehwan) | [sally](https://github.com/sally4405) |
| -------------------------------------- | ------------------------------------- |

---

## 📙 작업 내역

- 제품 리스트 페이지 UI 구현
  - 재사용 가능한 ProductDetailView 구현
- 제품 상세 페이지 UI 구현
  - CarouselView 구현
- BanchanListViewModel 구현
- ImageManager 객체 구현
  - NSCache 를 활용해 이미지 캐싱
  - 이미지 파일들을 병렬처리해서 한꺼번에 여러개를 셀(Cell)에 표시
  - 한 이미지에 대한 중복 요청을 한번의 요청으로 처리하도록 구현

## ✨ 결과물

| 2022.4.22 - UI 구현                                                                                                             | 2022.4.27 - 이미지 캐싱 & 서버 연동                                                                                             |
| ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| <img width="320" src="https://user-images.githubusercontent.com/42037023/164586202-7120fc59-72ad-41d4-a089-dfb58af86c8f.gif" /> | <img width="320" src="https://user-images.githubusercontent.com/42037023/165467791-1114830f-3168-4791-8651-1354c6994f3b.gif" /> |

---

## 🧐 문제와 해결

### M1 CocoaPod 설치 문제

-> iTerm 정보 가져오기 > `Rosetta를 사용하여 열기` 체크 <br>
-> `brew install cocoapods` or `sudo gem install cocoapods` <br>
-> `sudo arch -x86_64 gem install ffi` <br>
-> Podfile이 있는 프로젝트 directory에서 터미널 연 후, `arch -x86_64 pod install` <br>

---

### CollectionView 오토레이아웃 에러

**문제**

```swift=
let itemSize = NSCollectionLayoutSize(
    widthDimension: NSCollectionLayoutDimension.fractionalWidth(1),
    heightDimension: .estimated(40) // 문제의 원인
)
```

- `NSCollectionLayoutDimension.estimated(40)` 코드가 기본 높이 값을 의미한다고 생각했고 실제 View 의 크기에 따라 가변적으로 변화할 것으로 기대함
- Cell 의 높이를 130dp 로 설정하기 위해 Cell 의 하위 View 의 `HeightAnchor` 를 130 으로 고정

**해결**

- `NSCollectionLayoutDimension.estimated(40)` 보다 실제 사이즈가 더 크면 AutoLayout 에러를 발생하는 것을 발견함
- 실제 사이즈가 estimated 사이즈 범위 이내이면 실제 View 의 크기로 화면에 표시되는 것을 알게 됨

**시도**

1. `NSCollectionLayoutDimension.estimated(40)` 으로 설정하고 Cell 의 Image View 의 `HeightAnchor` 를 `greaterThanEqualTo` 로 설정하니 AutuLayout 에러가 사라지고 원하는 결과를 얻음. 그러나 ImageView 의 image 의 실제 크기에 영향을 받아 실제 Cell 의 크기는 130 보다 커짐
   - `EqualTo` 옵션 사용 시 estimated 값 이하여야 에러가 발생되지 않는다.
   - `greaterThanEqualTo` 사용 시 estimated 값을 초과할 수 있다.
2. 1.의 문제를 해결하기 위해 estimated 값을 130으로 변경하고 Image View 의 `HeightAnchor` 를 `greaterThanEqualTo` 에서 `EqualTo` 로 변경

---

### CollectionViewCell Register 안해서 화면이 안넘어감

**문제**

- 스토리보드에서 cell을 만들고 identifier를 지정해줘서 따로 register를 해주지 않음
- cell을 클릭 했을 때, `didSelectItemAt:` 함수가 불리지 않음

**해결**

```swift=
collectionView.register(ProductDetailCell.self, forCellWithReuseIdentifier: ProductDetailCell.identifier)
```

- view controller에서 cell을 같은 이름으로 register 해주는 것으로 해결

---

### Badge 개수에 따른 크기 조절

```swift
self.adjustsFontSizeToFitWidth = true
self.minimumScaleFactor = 0.5
```

- 공간이 부족하면 폰트의 사이즈를 0.5배까지 줄일 수 있도록 수정하여 해결
  -> 여전히 badge가 너무 많아지거나 화면이 작아지면 폰트가 잘리는 문제가 남아있음

---

## Document

- [기획서](https://www.figma.com/proto/mgYPOFyc7Aj6WI9j9GHcSy/%EB%AA%A8%EB%B0%94%EC%9D%BC_%EC%98%A8%EB%9D%BC%EC%9D%B8-%EC%A3%BC%EB%AC%B8-%EC%84%9C%EB%B9%84%EC%8A%A4?node-id=7140%3A3179&scaling=contain&page-id=9%3A1171)
- [Ground Rule](https://github.com/SongTaehwan/sidedish/wiki/Ground-Rule)
