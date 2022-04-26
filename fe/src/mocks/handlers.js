import { rest } from 'msw';

import { API_URL } from '@/Env';

const GET_CATEGORIES = rest.get(`${API_URL}/categories`, (req, res, ctx) => {
  return res(
    ctx.status(200),
    ctx.delay(1000),
    ctx.json({
      result_code: 200,
      result_message: 'OK',
      result_body: [
        {
          id: 1,
          title: '든든한 메인요리',
          subCategories: [
            {
              id: 1,
              mainCategoryId: 1,
              title: '육류 요리',
            },
            {
              id: 2,
              mainCategoryId: 1,
              title: '해산물 요리',
            },
          ],
        },
        {
          id: 2,
          title: '뜨끈한 국물 요리',
          subCategories: [
            {
              id: 3,
              mainCategoryId: 2,
              title: '국/탕/찌개',
            },
          ],
        },
        {
          id: 3,
          title: '정갈한 밑반찬',
          subCategories: [
            {
              id: 4,
              mainCategoryId: 3,
              title: '나물/무침',
            },
            {
              id: 5,
              mainCategoryId: 3,
              title: '조림/볶음',
            },
            {
              id: 6,
              mainCategoryId: 3,
              title: '절임/장아찌',
            },
          ],
        },
      ],
    })
  );
});

const GET_CATEGORY = [
  rest.get(`${API_URL}/categories/:id/items`, (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.delay(0),
      ctx.json({
        result_code: 200,
        result_message: 'OK',
        result_body: {
          id: req.params.id,
          title: '메뉴' + req.params.id,
          contents: [
            {
              id: 1,
              title: '호두 멸치볶음' + req.params.id,
              description: '개꿀맛',
              mainCategory: '정갈한 밑반찬',
              price: 5800,
              discountPolicy: 'launch',
              discountRate: 0.15,
              morningDelivery: true,
              images: [
                {
                  id: 1,
                  url: '//thumbnail10.coupangcdn.com/thumbnails/remote/492x492ex/image/retail/images/2020/11/12/15/2/d86f6c5e-1241-4e90-9871-1e4d2f75863c.jpg',
                },
                {
                  id: 2,
                  url: '//thumbnail10.coupangcdn.com/thumbnails/remote/492x492ex/image/retail/images/2020/11/12/15/2/d86f6c5e-1241-4e90-9871-1e4d2f75863c.jpg',
                },
              ],
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
              images: [
                {
                  id: 3,
                  url: '//thumbnail6.coupangcdn.com/thumbnails/remote/492x492ex/image/vendor_inventory/ce6a/4c25169c893104ca85c12d95f73865135d4944e7d5c403117d7baa93d8af.jpg',
                },
                {
                  id: 4,
                  url: '//thumbnail6.coupangcdn.com/thumbnails/remote/492x492ex/image/vendor_inventory/ce6a/4c25169c893104ca85c12d95f73865135d4944e7d5c403117d7baa93d8af.jpg',
                },
                {
                  id: 5,
                  url: '//thumbnail6.coupangcdn.com/thumbnails/remote/492x492ex/image/vendor_inventory/ce6a/4c25169c893104ca85c12d95f73865135d4944e7d5c403117d7baa93d8af.jpg',
                },
              ],
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
              images: [
                {
                  id: 6,
                  url: 'https://blog.kakaocdn.net/dn/U27A3/btqAccmhHxG/ManeQ0zJA77PgTnNx02VzK/img.jpg',
                },
                {
                  id: 7,
                  url: 'https://blog.kakaocdn.net/dn/U27A3/btqAccmhHxG/ManeQ0zJA77PgTnNx02VzK/img.jpg',
                },
              ],
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
              images: [
                {
                  id: 8,
                  url: 'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
                },
                {
                  id: 9,
                  url: 'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
                },
                {
                  id: 10,
                  url: 'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
                },
              ],
            },
            {
              id: 5,
              title: '호두 멸치볶음' + req.params.id,
              description: '개꿀맛',
              mainCategory: '정갈한 밑반찬',
              price: 2235050,
              discountPolicy: '',
              discountRate: 0.15,
              morningDelivery: true,
              images: [
                {
                  id: 11,
                  url: 'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
                },
                {
                  id: 12,
                  url: 'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
                },
              ],
            },
            {
              id: 6,
              title: '호두 멸치볶음' + req.params.id,
              description: '개꿀맛',
              mainCategory: '정갈한 밑반찬',
              price: 95050,
              discountPolicy: '',
              discountRate: 0.3,
              morningDelivery: true,
              images: [
                {
                  id: 13,
                  url: 'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
                },
                {
                  id: 14,
                  url: 'https://cdn.pressm.kr/news/photo/202103/41547_31452_2732.jpg',
                },
              ],
            },
          ],
        },
      })
    );
  }),
];

const GET_EVENTS = rest.get('/events', (req, res, ctx) => {
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

const GET_EVENT = [
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
            images: [
              {
                id: 1,
                url: 'https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/12e66f74-ca37-4a97-b19e-8e9231541a4a.jpeg',
              },
              {
                id: 2,
                url: 'https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/12e66f74-ca37-4a97-b19e-8e9231541a4a.jpeg',
              },
            ],
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
            images: [
              {
                id: 3,
                url: 'https://cdn.imweb.me/thumbnail/20190108/5c344b6b9b39a.jpg',
              },
            ],
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
            images: [
              {
                id: 4,
                url: 'https://cdn.mindgil.com/news/photo/202004/69068_2873_1455.jpg',
              },
            ],
          },
        ],
      })
    );
  }),
];

export const handlers = [
  GET_EVENTS,
  ...GET_EVENT,
  GET_CATEGORIES,
  ...GET_CATEGORY,
];
