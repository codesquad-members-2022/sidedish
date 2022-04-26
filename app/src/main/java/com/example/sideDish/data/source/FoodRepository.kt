package com.example.sideDish.data.source

import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.FoodDetail
import com.example.sideDish.data.model.Item

class FoodRepository {
    fun getFoodDetail(hash: String): FoodDetail {
        return FoodDetail(
            "2,500원 (40,000원 이상 구매 시 무료)",
            "서울 경기 새벽 배송, 전국 택배 배송",
            listOf(
                "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_D1.jpg",
                "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_D2.jpg",
                "http://public.codesquad.kr/jk/storeapp/data/pakage_regular.jpg"
            ),
            "126원",
            "15,800원",
            "12,640원",
            "오리 주물럭_반조리",
            listOf(
                "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
                "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_S.jpg"
            ),

            "http://public.codesquad.kr/jk/storeapp/data/1155_ZIP_P_0081_T.jpg"
        )
    }

    fun getMainItems(): List<Item> {
        return listOf(
            Item.Section(FoodCategory.MAIN),
            Item.FoodInfo(
                "오리 주물럭_반조리",
                listOf("런칭특가"),
                listOf("새벽배송", "전국택배"),
                "감칠맛 나는 매콤한 양념",
                "HBDEF",
                "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
                "15,800원",
                "12,640원",
                "오리 주물럭_반조리"
            ),
            Item.FoodInfo(
                "잡채",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "탱글한 면발과 맛깔진 고명이 가득",
                "BDF73",
                "http://public.codesquad.kr/jk/storeapp/data/main/310_ZIP_P_0012_T.jpg",
                "12,900원",
                "11,610원",
                "잡채"
            ),
            Item.FoodInfo(
                "소갈비찜",
                listOf("이벤트특가", "메인특가"),
                listOf("새벽배송", "전국택배"),
                "촉촉하게 밴 양념이 일품",
                "HF778",
                "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg",
                "28,900원",
                "26,010원",
                "소갈비찜"
            ),
            Item.FoodInfo(
                "간장 코다리조림",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요",
                "HFB53",
                "http://public.codesquad.kr/jk/storeapp/data/main/371_ZIP_P_0021_T.jpg",
                "",
                "14,900원",
                "간장 코다리조림"
            ),
            Item.FoodInfo(
                "꼬막비빔밥",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "매콤하게 입맛 돋우는",
                "H077F",
                "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg",
                "",
                "10,900원",
                "꼬막비빔밥"
            ),
            Item.FoodInfo(
                "궁중 떡볶이_반조리",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "영양 듬뿍 프리미엄 간장 떡볶이",
                "H4665",
                "http://public.codesquad.kr/jk/storeapp/data/main/675_ZIP_P_0057_T.jpg",
                "",
                "7,800원",
                "궁중 떡볶이_반조리"
            ),
            Item.FoodInfo(
                "초계국수_쿠킹박스",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "건강한 가정 간편식 여름 국수",
                "H1AA9",
                "http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg",
                "",
                "11,800원",
                "초계국수_쿠킹박스"
            ),
            Item.FoodInfo(
                "쭈꾸미 한돈 제육볶음_반조림",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "쫄깃한 쭈꾸미와 고소한 돼지고기가 일품",
                "HEDFB",
                "http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg",
                "",
                "16,900원",
                "쭈꾸미 한돈 제육볶음_반조림"
            )
        )
    }

    fun getSoupItems(): List<Item> {
        return listOf(
            Item.Section(FoodCategory.SOUP),
            Item.FoodInfo(
                "한돈 돼지 김치찌개",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "김치찌개에는 역시 돼지고기",
                "H72C3",
                "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_T.jpg",
                "9,300원",
                "8,370원",
                "한돈 돼지 김치찌개"
            ),
            Item.FoodInfo(
                "된장찌개",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "특별하지 않아서 더 좋은 우리맛",
                "HA6EE",
                "http://public.codesquad.kr/jk/storeapp/data/soup/33_ZIP_P_1004_T.jpg",
                "8,800원",
                "7,920원",
                "된장찌개"
            ),
            Item.FoodInfo(
                "미역오이냉국",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "여름엔 시원한 냉국이 최고",
                "H8CD0",
                "http://public.codesquad.kr/jk/storeapp/data/soup/213_ZIP_P_1008_T.jpg",
                "7,800원",
                "7,020원",
                "미역오이냉국"
            ),
            Item.FoodInfo(
                "동태찌개",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "겨울철 보양식으로 안성맞춤",
                "HE2E9",
                "http://public.codesquad.kr/jk/storeapp/data/soup/266_ZIP_P_1011_T.jpg",
                "",
                "10,900원",
                "동태찌개"
            ),
            Item.FoodInfo(
                "감자국",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "국내산 감자라 더 고소한",
                "HAA47",
                "http://public.codesquad.kr/jk/storeapp/data/soup/484_ZIP_P_1022_T.jpg",
                "",
                "6,900원",
                "감자국"
            ),
            Item.FoodInfo(
                "우리콩 강된장찌개",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "우리콩으로 만들어 안심",
                "H3254",
                "http://public.codesquad.kr/jk/storeapp/data/soup/659_ZIP_P_1029_T.jpg",
                "",
                "5,800원",
                "우리콩 강된장찌개"
            ),
            Item.FoodInfo(
                "순한 오징어무국",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "부드럽고 담백한 국물",
                "H26C7",
                "http://public.codesquad.kr/jk/storeapp/data/soup/818_ZIP_P_1033_T.jpg",
                "",
                "11,900원",
                "순한 오징어무국"
            ),
            Item.FoodInfo(
                "맑은 동태국",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "시원함과 감칠맛은 그대로 담은 맑은 국",
                "HFFF9",
                "http://public.codesquad.kr/jk/storeapp/data/soup/842_ZIP_P_1035_T.jpg",
                "",
                "8,500원",
                "맑은 동태국"
            )
        )
    }

    fun getSideItems(): List<Item> {
        return listOf(
            Item.Section(FoodCategory.SIDE),
            Item.FoodInfo(
                "새콤달콤 오징어무침",
                listOf("런칭특가"),
                listOf("새벽배송", "전국택배"),
                "국내산 오징어를 새콤달콤하게",
                "HBBCC",
                "http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_T.jpg",
                "7,500원",
                "6,000원",
                "새콤달콤 오징어무침"
            ),
            Item.FoodInfo(
                "호두 멸치볶음",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "잔멸치와 호두가 만나 짭쪼름하지만 고소하게!",
                "H1939",
                "http://public.codesquad.kr/jk/storeapp/data/side/17_ZIP_P_6014_T.jpg",
                "5,800원",
                "5,220원",
                "호두 멸치볶음"
            ),
            Item.FoodInfo(
                "한돈 매콤 안심장조림",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "부드러운 한돈 안심살의 매콤함",
                "H8EA5",
                "http://public.codesquad.kr/jk/storeapp/data/side/26_ZIP_P_4001_T.jpg",
                "6,900원",
                "6,210원",
                "한돈 매콤 안심장조림"
            ),
            Item.FoodInfo(
                "야채 어묵볶음",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "첨가물 없는 순수어묵과 야채의 만남",
                "H602F",
                "http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_T.jpg",
                "4,900원",
                "4,410원",
                "야채 어묵볶음"
            ),
            Item.FoodInfo(
                "오이소박이",
                listOf("이벤트특가"),
                listOf("새벽배송", "전국택배"),
                "깔끔하고 개운한 여름 김치",
                "H9F0B",
                "http://public.codesquad.kr/jk/storeapp/data/side/147_ZIP_P_7010_T.jpg",
                "7,300원",
                "6,570원",
                "오이소박이"
            ),
            Item.FoodInfo(
                "두부조림",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "각종 영양이 가득 담긴",
                "H0FC6",
                "http://public.codesquad.kr/jk/storeapp/data/side/268_ZIP_P_4023_T.jpg",
                "",
                "6,900원",
                "두부조림"
            ),
            Item.FoodInfo(
                "미나리무침",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "향긋하고 고소한 봄나물",
                "HCCFE",
                "http://public.codesquad.kr/jk/storeapp/data/side/682_ZIP_P_5055_T.jpg",
                "",
                "4,300원",
                "미나리무침"
            ),
            Item.FoodInfo(
                "참외오이무침",
                listOf(),
                listOf("새벽배송", "전국택배"),
                "시원하고 아삭한 여름 생채 무침",
                "HB9C1",
                "http://public.codesquad.kr/jk/storeapp/data/side/736_ZIP_P_5067_T.jpg",
                "",
                "4,300원",
                "참외오이무침"
            )
        )
    }
}