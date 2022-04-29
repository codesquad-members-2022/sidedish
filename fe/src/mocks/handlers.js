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
      ctx.delay(1000),
      ctx.json({
        result_code: 200,
        result_message: 'OK',
        result_body: {
          id: 3,
          title: '정갈한 밑반찬',
          contents: [
            {
              id: 16,
              title: '새콤달콤 오징어무침',
              description: '국내산 오징어를 새콤달콤하게',
              price: 7500,
              quantity: 7,
              accumulate: 75,
              discountPolicy: 'lunch',
              discountRate: 0.1,
              morningDelivery: true,
              images: [
                {
                  id: 31,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side1-1.png',
                },
                {
                  id: 32,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side1-2.png',
                },
              ],
            },
            {
              id: 17,
              title: '호두 멸치볶음',
              description: '잔멸치와 호두가 만나 짭쪼름하지만 고소하게',
              price: 5800,
              quantity: 10,
              accumulate: 58,
              discountPolicy: 'event',
              discountRate: 0.2,
              morningDelivery: true,
              images: [
                {
                  id: 33,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side2-1.png',
                },
                {
                  id: 34,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side2-2.png',
                },
              ],
            },
            {
              id: 18,
              title: '한돈 매콤 안심장조림',
              description: '부드러운 한돈 안심살의 매콤함',
              price: 6900,
              quantity: 3,
              accumulate: 69,
              discountPolicy: 'lunch',
              discountRate: 0.1,
              morningDelivery: true,
              images: [
                {
                  id: 35,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side3-1.png',
                },
                {
                  id: 36,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side3-2.png',
                },
              ],
            },
            {
              id: 19,
              title: '야채 어묵볶음',
              description: '첨가물 없는 순수어묵과 야채의 만남',
              price: 4900,
              quantity: 2,
              accumulate: 49,
              discountPolicy: 'event',
              discountRate: 0.2,
              morningDelivery: false,
              images: [
                {
                  id: 37,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side4-1.png',
                },
                {
                  id: 38,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side4-2.png',
                },
              ],
            },
            {
              id: 20,
              title: '미니새송이버섯조림',
              description: '동글동글 한 입에 쏙',
              price: 3500,
              quantity: 10,
              accumulate: 35,
              discountPolicy: 'lunch',
              discountRate: 0.1,
              morningDelivery: false,
              images: [
                {
                  id: 39,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side5-1.png',
                },
                {
                  id: 40,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side5-2.png',
                },
              ],
            },
            {
              id: 21,
              title: '마늘쫑 간장조림',
              description: '단짠단짠 입맛 돋우는 우리집 단골 반찬',
              price: 4900,
              quantity: 7,
              accumulate: 49,
              discountPolicy: 'event',
              discountRate: 0.2,
              morningDelivery: true,
              images: [
                {
                  id: 41,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side6-1.png',
                },
                {
                  id: 42,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side6-2.png',
                },
              ],
            },
            {
              id: 22,
              title: '표고버섯조림',
              description: '국내산 표고버섯이라 더 맛있어요',
              price: 5300,
              quantity: 8,
              accumulate: 53,
              discountPolicy: 'lunch',
              discountRate: 0.1,
              morningDelivery: true,
              images: [
                {
                  id: 43,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side7-1.png',
                },
                {
                  id: 44,
                  url: 'https://sidedish-06.s3.ap-northeast-2.amazonaws.com/images/side/side7-2.png',
                },
              ],
            },
          ],
        },
      })
    );
  }),
];

const GET_EVENTS = rest.get(`${API_URL}/events`, (req, res, ctx) => {
  return res(
    ctx.status(200),
    ctx.delay(0),
    ctx.json({
      result_code: 200,
      result_message: 'OK',
      result_body: [
        {
          id: 1,
          title: '풍성한 고기반찬',
        },
        {
          id: 2,
          title: '편리한 반찬세트',
        },
        {
          id: 3,
          title: '맛있는 제철요리',
        },
        {
          id: 4,
          title: '우리아이 영양 반찬쓰',
        },
      ],
    })
  );
});

const GET_EVENT = [
  rest.get(`${API_URL}/events/:id/items`, (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.delay(1000),
      ctx.json({
        result_code: 200,
        result_message: 'OK',
        result_body: [
          {
            id: 1,
            title: '호두 멸치볶음' + req.params.id,
            description: '개꿀맛',
            mainCategory: '정갈한 밑반찬',
            price: 5800,
            discountPolicy: 'lunch',
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

const getProductDetail = rest.get(`${API_URL}/items/:id`, (req, res, ctx) => {
  return res(
    ctx.status(200),
    ctx.delay(0),
    ctx.json({
      result_code: 200,
      result_message: 'OK',
      result_body: {
        id: 1,
        title: '오리주물럭',
        description: '감칠맛나는 매콤한 양념',
        price: 15800,
        quantity: 5,
        accumulate: 158,
        discountPolicy: 'lunch',
        discountRate: 0.1,
        morningDelivery: false,
        images: [
          {
            id: 1,
            url: 'https://img.insight.co.kr/static/2019/06/26/700/f31l48lhp1v2tuq7ce8o.jpg',
          },
          {
            id: 2,
            url: 'https://cdn.mindgil.com/news/photo/202004/69068_2873_1455.jpg',
          },
        ],
      },
    })
  );
});

export const handlers = [
  GET_EVENTS,
  ...GET_EVENT,
  GET_CATEGORIES,
  ...GET_CATEGORY,
  getProductDetail,
];
