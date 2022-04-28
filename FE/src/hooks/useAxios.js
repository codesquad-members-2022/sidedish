import axios from "axios";
import { API_SERVER_URL } from "constants";
import { useCallback, useEffect, useState } from "react";

axios.defaults.baseURL = API_SERVER_URL;

export const useAxios = ({ method, url, params, config }) => {
  const [response, setResponse] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  const fetchData = useCallback(async () => {
    setLoading(true);
    try {
      const res = await axios[method](url, {
        validateStatus: (status) => {
          return status >= 200 && status < 300;
        },
        params,
        ...config,
      });
      setResponse(res.data);
    } catch (err) {
      console.log(err);
      setError(err);
    } finally {
      setLoading(false);
    }
  }, [method, url, params, config]);

  useEffect(() => {
    fetchData();
    // BUG:dependency에 객체를 넣으면 무한 루프
  }, [JSON.stringify(params)]);
  return { response, error, loading };
};
