import axios from "axios";

const baseURL = `http://3.36.89.161/api/event-categories/`;
const client = axios.create({ baseURL });

const eventCategoriesApi = {
  getEventCategories: async () => {
    const response = await client.get();
    return response.data;
  },
  getSideDishes: async (eventCategoryId) => {
    const response = await client.get(`/${eventCategoryId}/sidedishes`);
    return response.data;
  },
};

export default eventCategoriesApi;
