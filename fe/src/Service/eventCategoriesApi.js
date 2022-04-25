import axios from "axios";

const API_END_POINT = ``; // 실제 BE api로 요청시 수정
const baseURL = `${API_END_POINT}/api/event-categories/`;
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
