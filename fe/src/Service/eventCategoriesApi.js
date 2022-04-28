import axios from "axios";
import constants from "common/constants";

const baseURL = `${constants.API}/api/event-categories/`;
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
