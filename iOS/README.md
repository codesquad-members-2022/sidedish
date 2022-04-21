# SideDish - iOS


## Flow
```mermaid
graph LR

B[반찬리스트]-->|Touch|C[반찬상세화면]
```

---


---
## Model

```mermaid
classDiagram
    Dishes *-- Dish
      class Dish{
          -String id
          -String name
          -Int price
          -Int stock
          -String type
          -URL image
          -String description
          -Int? discountPrice
          -String? discountPolicy
      }
      class Dishes{
          -[Dish] dishes
          -String type
      }
```


## View

#### ~ 22.4.20
- 요약 화면
    - 반찬리스트 뷰 구현
    - 반찬리스트 헤더 구현
    - 반찬리스트 셀 구현
- 상세화면 
    - 요리 요약 뷰 구현
    - 배송 정보 뷰 구현

## Network


## 실행화면
<table>
    <tr>
<td><img src="https://user-images.githubusercontent.com/78553659/164155627-4078bf93-daa3-4a54-87b4-bad75dba4d36.png" width=300 height=600 /></td><td><img src="https://user-images.githubusercontent.com/78553659/164155643-68b11430-0b58-4746-83e7-6820f380c070.png" width=300 height=600 /></td>
    </tr>
</table>





