# TODO
- [x] 단건 조회 시 배달비, 배달비 정보 내려주기
- [ ] 현재 페이지, 페이지의 최대 수 내려주기
- [ ] 이미지 추가
- [ ] CORS 터지면 그때 생각하자

# 3차 PR 리뷰 수정사항
- [x] ExceptionAdvice 중복제거
- [x] getItemByDetailType 메서드로 전달되는 parameter의 애매한 이름 변경하기
- [ ] itemController
- [x] 하드코딩보다는 HttpStatus를 사용 (ResultDto)
- [ ] categoryController 중복제거 생각해보기
- [x] buildItems 메서드 매직넘버는 지양하기
- [ ] findItemByDetailType에 인자로 enum 전달히기
- [ ] ResponseAdditionalDto 생성자 고민해보기
- [ ] OrderRequest에서 id를 null로 보낸경우에도 QuantityException가 발생하지 않을까요??
- [x] item 내부에서 자체적으로 남은 수량 계산하기

# 1차 PR 리뷰 수정사항
- [x] categoryService 에서 pageId 받는 부분 수정하기
- [x] schema 처음과 끝 f.k check 설정 제거
- [x] 이미지 주소 저장을 위한 필드 데이터 크기 수정
- [ ] f.k 잡기 위해 category_id로 변경해보기
- [X] controller 테스트 이름 변경하기 (통합 테스트의 의미가 담기도록)
- [x] 테스트 서식지정자 결정하기


## 질문 목록
- [ ] HomeController 에서 반환하는 DTO 규격과 HEATEAOS 추가에 따른 하드 코딩 부분 질문
- 상품 자체가 사라지거나 변경될 경우 코드 자체를 수정해야하게됨. 확장성이 떨어짐
