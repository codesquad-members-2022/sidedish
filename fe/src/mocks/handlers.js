import { rest } from 'msw';

const getRoot = rest.get('/', (req, res, ctx) => {
  return res(
    ctx.status(200),
    ctx.json({})
  )
})
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
  rest.get('/events/:id', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.delay(200),
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
            image: 'https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/12e66f74-ca37-4a97-b19e-8e9231541a4a.jpeg',
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
            image: 'https://cdn.mindgil.com/news/photo/202004/69068_2873_1455.jpg',
          },
        ],
      })
    );
  }),
];

export const handlers = [getEvents, ...getEvent, getRoot];
