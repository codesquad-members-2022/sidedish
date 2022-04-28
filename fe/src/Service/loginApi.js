import axios from "axios";
import constants from "common/constants";

const baseURL = `${constants.API}/api/`;
const client = axios.create({ baseURL, withCredentials: true });

const loginApi = {
  getLoginInfo: async () => {
    try {
      const response = await client.get(`/`);
      return response;
    } catch (error) {
      return error.response;
    }
  },
};

export default loginApi;
