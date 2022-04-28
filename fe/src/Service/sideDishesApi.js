import axios from "axios";
import constants from "common/constants";

const baseURL = `${constants.API}/api/sidedishes/`;
const client = axios.create({ baseURL });

const sideDishesApi = {
  getSideDish: async (sideDishId) => {
    const response = await client.get(`/${sideDishId}`);
    return response.data;
  },
};

export default sideDishesApi;
