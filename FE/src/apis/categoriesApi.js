import { methodFormat } from '../common/utils';
import client from './client';

const PATH = 'categories/';

const categoriesApi = {
  getFoodsByCategory: methodFormat(async ({ type, pageId, pageCount }) => {
    const options = {
      params: {
        pageId: pageId || 1,
        ...(pageCount ? { pageCount } : {}),
      },
    };
    const response = await client.get(`${PATH}${type}`, options);
    return response.data;
  }),
  getRandFoodsByMainTab: methodFormat(async (mainTabTitle) => {
    const parsedTitle = mainTabTitle.replaceAll(' ', '_');
    const response = await client.get(`${PATH}${parsedTitle}/detail`);
    return response.data;
  }),
  getRelatedFoodsByFood: methodFormat(async (itemId) => {
    const response = await client.get(`${PATH}items/${itemId}`);
    return response.data;
  }),
};

export default categoriesApi;
