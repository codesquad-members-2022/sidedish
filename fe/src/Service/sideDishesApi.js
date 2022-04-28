import axios from "axios";

const baseURL = `http://3.36.89.161/api/sidedishes/`;
const client = axios.create({ baseURL });

const sideDishesApi = {
  getSideDish: async (sideDishId) => {
    const response = await client.get(`/${sideDishId}`);
    return response.data;
  },
};

export default sideDishesApi;
