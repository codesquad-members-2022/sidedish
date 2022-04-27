import { rest } from "msw";
import { event, categoryMenus } from "MockData/MockData";

const handlers = [
  rest.get(`/api/event-categories/`, (req, res, ctx) => {
    return res(ctx.status(200), ctx.delay(100), ctx.json(event));
  }),
];

for (let i = 0; i < 10; i += 1) {
  handlers.push(
    rest.get(`/api/event-categories/${i}/sidedishes`, (req, res, ctx) => {
      return res(ctx.status(200), ctx.delay(100), ctx.json(categoryMenus));
    })
  );
}

export default handlers;
