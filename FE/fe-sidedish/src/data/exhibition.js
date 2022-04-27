const exhibition = {
  exhibitionTitle: '한 번 주문하면 두 번 반하는 반찬',
  categoryNameList: [
    { id: 1, title: '풍성한 고기 반찬' },
    { id: 2, title: '편리한 반찬 세트' },
    { id: 3, title: '맛있는 제철 요리' },
    { id: 4, title: '우리아이 영양 반찬' },
  ],
  specialCategories: {
    categoryId: 1,
    categoryTitle: '풍성한 고기 반찬',
    subCategoryList: [
      {
        menuId: 1,
        menuName: '오리 주물럭_반조리',
        description: '감칠맛 나는 매콤한 양념',
        originalPrice: 15800,
        discountedPrice: 12640,
        image:
          'https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8B%E1%85%A9%E1%84%85%E1%85%B5+%E1%84%8C%E1%85%AE%E1%84%86%E1%85%AE%E1%86%AF%E1%84%85%E1%85%A5%E1%86%A8.png',
        event: ['런칭특가'],
      },
      {
        menuId: 2,
        menuName: '소갈비찜',
        description: '촉촉하게 벤 양념이 일품',
        originalPrice: 28900,
        discountedPrice: 26010,
        image:
          'https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%89%E1%85%A9%E1%84%80%E1%85%A1%E1%86%AF%E1%84%87%E1%85%B5%E1%84%8D%E1%85%B5%E1%86%B7.png',
        event: ['이벤트특가'],
      },
      {
        menuId: 3,
        menuName: '쭈꾸미 한돈 제육볶음_반조리',
        description: '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품',
        originalPrice: 16900,
        discountedPrice: 0,
        image:
          'https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8D%E1%85%AE%E1%84%81%E1%85%AE%E1%84%86%E1%85%B5+%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB.png',
        event: 26010,
      },
    ],
  },
};

export default exhibition;
