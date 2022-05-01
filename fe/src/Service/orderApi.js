import axios from "axios";
import constants from "common/constants";

const baseURL = `${constants.API}/api/`;
const client = axios.create({ baseURL });

const orderApi = {
  orderSideDish: async (requestBody) => {
    try {
      const response = await client.post(`/sidedish-order`, requestBody);
      return response;
    } catch (error) {
      return error.response;
    }
  },
};

export default orderApi;
