import axios from 'axios';
import { useEffect, useState, useCallback } from 'react';

export const useFetch = (URL) => {
  const [dishes, setDishes] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [isError, setIsError] = useState(false);

  const fetchData = useCallback(async () => {
    try {
      const { data } = await axios.get(URL);
      setIsLoading(true);

      if (data) {
        setDishes(data);
        setIsLoading(false);
      }
    } catch (error) {
      console.error('에러');
      setIsLoading(false);
      setIsError(true);
    }
  }, [URL]);

  useEffect(() => {
    setIsLoading(true);
    setIsError(false);
    fetchData();
  }, [fetchData]);

  return [dishes, isLoading, isError];
};
