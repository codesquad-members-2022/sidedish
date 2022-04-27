INSERT INTO category (ID, NAME) values
(1, '모두가 좋아하는 든든한 메인요리'),
(2, '정성이 담긴 뜨끈한 국물요리'),
(3, '식탁을 풍성하게 하는 정갈한 밑반찬');

INSERT INTO item (CATEGORY_ID, NAME, DESCRIPTION, PRICE, STOCK, DISCOUNT_POLICY, DISCOUNT_RATE, MAIN_IMAGE_LINK) values
(1, '오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', 15800, 10, "런칭특가", 20, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(1, '잡채', '탱글한 면발과 맛깔진 고명이 가득', 12900, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(1, '소갈비찜', '촉촉하게 밴 양념이 일품', 28900, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(1, '간장 코다리조림', '쫀득한 코다리를 국내산 간장소스에 조린 깊은 맛', 14900, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(1, '꼬막비빔밥', '매콤하게 입맛 돋우는', 10900, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(1, '궁중 떡볶이_반조리', '영양 듬뿍 프리미엄 간장 떡볶이', 7800, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(1, '초계국수_쿠킹박스', '건강한 가정 간편식 여름 국수', 11800, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(1, '쭈꾸미 한돈 제육볶음_반조림', '쫄깃한 쭈꾸미와 고소한 돼지고기의 만남', 16900, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(2, '한돈 돼지김치찌개', '김치찌개에는 역시 돼지고기', 9300, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(2, '된장찌개', '특별하지 않아서 더 좋은 우리맛', 8800, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(2, '미역오이냉국', '여름엔 시원한 냉국이 최고', 7800, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(2, '동태찌개', '겨울철 보양식으로 안성맞춤', 10900, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(2, '감자국', '국내산 감자라 더 고소한', 6900, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(2, '우리콩 강된장찌개', '우리콩으로 만들어 안심', 5800, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(2, '순한 오징어무국', '부드럽고 담백한 국물', 11900, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(3, '새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', 6000, 10, "런칭특가", 20, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(3, '호두 멸치볶음', '잔멸치와 호두가 만나 짭쪼름하게', 5800, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(3, '한돈 매콤 안심장조림', '부드러운 한돈 안심살의 매콤함', 6900, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(3, '야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', 4900, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(3, '오이소박이', '깔끔하고 개운한 여름 김치', 7300, 10, "이벤트특가", 10, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg"),
(3, '두부조림', '각종 영양이 가득 담긴', 6900, 10, NULL, NULL, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg");

INSERT INTO item_image (ITEM_ID, IMAGE_LINK) values
(1, "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg");
