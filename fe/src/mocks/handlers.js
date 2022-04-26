import { rest } from 'msw';

const getEvents = rest.get('/events', (req, res, ctx) => {
  return res(
    ctx.status(200),
    ctx.delay(0),
    ctx.json({
      content: [
        {
          id: 1,
          title: '풍성한 고기반찬',
        },
        {
          id: 2,
          title: '편리한 반찬 세트',
        },
        {
          id: 3,
          title: '맛있는 제철 요리',
        },
        {
          id: 4,
          title: '우리 아이 영양 반찬',
        },
      ],
    })
  );
});
const getEvent = [
  rest.get('/event/:id', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.delay(0),
      ctx.json({
        content: [
          {
            id: 1,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: 'launch',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/12e66f74-ca37-4a97-b19e-8e9231541a4a.jpeg',
          },
          {
            id: 2,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: 'event',
            discountRate: 0.15,
            morningDelivery: false,
            image: 'https://cdn.imweb.me/thumbnail/20190108/5c344b6b9b39a.jpg',
          },
          {
            id: 3,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.mindgil.com/news/photo/202004/69068_2873_1455.jpg',
          },
        ],
      })
    );
  }),
];
const getCategories = rest.get('/categories', (req, res, ctx) => {
  return res(
    ctx.status(200),
    ctx.delay(1000),
    ctx.json({
      result_code: 200,
      result_message: "OK",
      result_body: [
        {
          "id": 1,
          "title": "든든한 메인요리",
          "subCategories": [
            {
              "id": 1,
              "mainCategoryId": 1,
              "title": "육류 요리"
            },
            {
              "id": 2,
              "mainCategoryId": 1,
              "title": "해산물 요리"
            }
          ]
        },
        {
          "id": 2,
          "title": "뜨끈한 국물 요리",
          "subCategories": [
            {
              "id": 3,
              "mainCategoryId": 2,
              "title": "국/탕/찌개"
            }
          ]
        },
        {
          "id": 3,
          "title": "정갈한 밑반찬",
          "subCategories": [
            {
              "id": 4,
              "mainCategoryId": 3,
              "title": "나물/무침"
            },
            {
              "id": 5,
              "mainCategoryId": 3,
              "title": "조림/볶음"
            },
            {
              "id": 6,
              "mainCategoryId": 3,
              "title": "절임/장아찌"
            }
          ]
        }
      ],
    })
  );
});
const getCategory = [
  rest.get('/category/:id', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.delay(0),
      ctx.json({
        content: [
          {
            id: 1,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: 'launch',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              '//thumbnail10.coupangcdn.com/thumbnails/remote/492x492ex/image/retail/images/2020/11/12/15/2/d86f6c5e-1241-4e90-9871-1e4d2f75863c.jpg',
          },
          {
            id: 2,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: 'event',
            discountRate: 0.15,
            morningDelivery: false,
            image:
              '//thumbnail6.coupangcdn.com/thumbnails/remote/492x492ex/image/vendor_inventory/ce6a/4c25169c893104ca85c12d95f73865135d4944e7d5c403117d7baa93d8af.jpg',
          },
          {
            id: 3,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://blog.kakaocdn.net/dn/U27A3/btqAccmhHxG/ManeQ0zJA77PgTnNx02VzK/img.jpg',
          },
          {
            id: 4,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 5,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 6,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 7,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 8,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 9,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 10,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 11,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 12,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
          {
            id: 13,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: '',
            discountRate: 0.15,
            morningDelivery: true,
            image:
              'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
          },
        ],
      })
    );
  }),
];

export const handlers = [
  getEvents,
  ...getEvent,
  getCategories,
  ...getCategory,
];
