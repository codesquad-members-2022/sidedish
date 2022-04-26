import { useEffect, useState, useRef } from 'react';

import { fetchData } from '@/Utils';

/**
 * @param {string} url
 * @returns {[*[],boolean,boolean,function]}
 * 1. data: fetch 응답을 json()으로 파싱한 값
 * 2. isLoaded: 응답을 성공적으로 받으면 true 값으로 바뀜. 에러 발생시 false 유지
 * 3. isError: 에러 발생시 true 가 되는 값.
 * 4. setRetry: true 값을 인자로 전달하여 호출하면, 동일한 url 로 다시 fetch 를 호출함.
 */
export const useFetch = url => {
  const [data, setData] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [isError, setIsError] = useState(false);
  const [retry, setRetry] = useState(false);

  const abortController = useRef(false);
  const whileFetching = useRef(false);

  useEffect(() => {
    if (whileFetching.current) abortController.current.abort();

    abortController.current = new AbortController();
    whileFetching.current = true;

    setIsLoaded(false);
    fetchData(url, { signal: abortController.current.signal })
      .then(responseData => {
        whileFetching.current = false;

        setData(responseData);
        setIsLoaded(true);
      })
      .catch(err => {
        if (err.name === 'AbortError') {
          console.warn('aborted');
          return;
        }

        console.error(err);
        setIsError(true);
      });
  }, [url]);

  useEffect(() => {
    if (!retry) return;
    setIsError(false);

    fetchData(url)
      .then(responseData => {
        setData(responseData);
        setIsLoaded(true);
      })
      .catch(err => {
        console.error(err);
        setIsError(true);
        setRetry(false);
      });
  }, [retry]);

  return [data, isLoaded, isError, setRetry];
};
