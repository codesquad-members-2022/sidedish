async function fetchCategories() {
  // fetch GET /categories?isEvent=false 데이터로 변경 예정

  const categories = [
    {
      id: 1,
      name: '메인요리',
      children: [
        { id: 1, name: '육류' },
        { id: 2, name: '해산물' },
      ],
    },
    { id: 2, name: '국물요리', children: [{ id: 5, name: '국/탕찌개' }] },
    {
      id: 3,
      name: '밑반찬',
      children: [
        { id: 3, name: '나물/무침' },
        { id: 4, name: '조림/볶음' },
        { id: 6, name: '절임/장아찌' },
      ],
    },
  ];
  return categories;
}
async function fetchEventCategories() {
  // fetch GET /categories?isEvent=true 데이터로 변경 예정
  const eventCategories = [
    {
      id: 4,
      name: '풍성한 고기반찬',
      children: [],
    },
    {
      id: 5,
      name: '편리한 반찬세트',
      children: [],
    },
    {
      id: 6,
      name: '맛있는 제철 요리',
      children: [],
    },
    {
      id: 7,
      name: '우리 아이 영양 반찬',
      children: [],
    },
  ];
  return eventCategories;
}

async function fetchDishes() {
  const dishes = {
    eventItems: [
      {
        id: 0,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 1',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [4],
      },
      {
        id: 1,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 2',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [4],
      },
      {
        id: 2,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 3',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [4],
      },
      {
        id: 3,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 3',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [5],
      },
      {
        id: 4,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 3',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [5],
      },
      {
        id: 5,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 3',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [5],
      },
    ],
    items: [
      {
        id: 0,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 1',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [1],
      },
      {
        id: 1,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 2',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [1],
      },
      {
        id: 2,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 3',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [1],
      },
      {
        id: 3,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 3',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [1],
      },
      {
        id: 4,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 1',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [2],
      },
      {
        id: 5,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 2',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [2],
      },
      {
        id: 6,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 3',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [2],
      },
      {
        id: 7,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 4',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [2],
      },
      {
        id: 8,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 5',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [2],
      },
      {
        id: 9,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 6',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [2],
      },
      {
        id: 10,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '고기반찬 7',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: [2],
      },
    ],
  };
  return dishes;
}

async function fetchDishItem(dishId) {
  // fetch GET /dishes/{dishId} 데이터로 변경 예정
  const dishItem = {
    id: 1,
    main_category_id: 11,
    sub_category_id: 111,
    name: '오리 주물럭_반조리',
    content: '칠맛 나는 매콤한 양념',
    badge_title: ['이벤트특가', '런칭특가'],
    price: 15000,
    discount_price: 12600,
    mileage_ratio: 0.01,
    early_delivery: true,
    delivery_price: 2500,
    delevery_free_price: 40000,
    stock: 100,
    images: [
      'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
      'http://public.codesquad.kr/jk/storeapp/data/side/17_ZIP_P_6014_T.jpg',
      'http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_T.jpg',
    ],
    related_dishes: [
      {
        id: 1,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '스테이크',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: ['메인 요리'],
      },
      {
        id: 2,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '스테이크',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: ['메인 요리'],
      },
      {
        id: 3,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '스테이크',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: ['메인 요리'],
      },
      {
        id: 4,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '스테이크',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: ['메인 요리'],
      },
      {
        id: 5,
        image:
          'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
        title: '스테이크',
        contents: '스테이크 먹고싶다',
        origin_price: 50000,
        discount_price: 39800,
        early_delivery: true,
        badge_title: ['이벤트특가', '런칭특가'],
        categories: ['메인 요리'],
      },
    ],
  };
  return dishItem;
}

export { fetchCategories, fetchEventCategories, fetchDishes, fetchDishItem };
