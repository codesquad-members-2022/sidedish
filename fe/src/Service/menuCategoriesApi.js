import axios from "axios";
import constants from "common/constants";

const baseURL = `${constants.API}/api/`;
const client = axios.create({ baseURL });

const menuCategoriesApi = {
  getFirstMenuCategory: async () => {
    const response = await client.get(`/first-menu-category`);
    return response.data;
  },
  getRestMenuCategories: async () => {
    const response = await client.get(`/rest-menu-categories`);
    return response.data;
  },
};

export default menuCategoriesApi;
