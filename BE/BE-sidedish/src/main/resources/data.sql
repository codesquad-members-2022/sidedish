-- 모든 카테고리 내 메뉴 리스트 출력
Select
    menu_id, menu_name, menu_content, menu_price,
    image.image_id, image_name, image_path, image_main,
    category.category_id, category_name, category_event,
    sale.sale_id, sale_name

From menu
     Join category
          On menu.category_id = category.category_id

     Join sale
          On menu.sale_id = sale.sale_id

     Join image
          On menu.image_id = image.image_id

-- 기획전 카테고리 내부 메뉴 출력
Select
    menu_id, menu_name, menu_content, menu_price,
    image.image_id, image_name, image_path, image_main,
    category.category_id, category_name, category_event,
    sale.sale_id, sale_name

From menu
     Join category
          On menu.category_id = category.category_id

     Join sale
          On menu.sale_id = sale.sale_id

     Join image
          On menu.image_id = image.image_id

Where category_event = 0;

-- 기획전 외부 카테고리의 국물 요리 메뉴 출력
Select
    menu_id, menu_name, menu_content, menu_price,
    image.image_id, image_name, image_path, image_main,
    category.category_id, category_name, category_event,
    sale.sale_id, sale_name

From menu
     Join category
          On menu.category_id = category.category_id

     Join sale
          On menu.sale_id = sale.sale_id

     Join image
          On menu.image_id = image.image_id

Where category_event = 0 And category.category_id = 6;

-- category_id
-- 1 : 풍성한 고기 반판
-- 2 : 편리한 반찬 세트
-- 3 : 맛있는 제철 요리
-- 4 : 우리 아이 영양 반찬
-- 5 : 식탁을 풍성하게 하는 정갈한 밑반찬
-- 6 : 정성이 담긴 뜨끈뜨끈 국물 요리
-- 7 : 모두가 좋아하는 든든한 메인 요리

-- category_event
-- 1 : 기획전 내부 카테고리
-- 2 : 기획전 외부 카테고리

-- sale_id
-- 1 : 런칭 특가
-- 2 : 이벤트 특가
-- 3 : 정상 가격

-- image_main
-- 1 : 메인 이미지
-- 2 : 서브 이미지
