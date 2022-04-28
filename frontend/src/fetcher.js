import { useEffect, useState } from "react";
import { requestQuery } from "./convention";

export const useFetch = (target, id = undefined, ...deps) => {
  const [state, setState] = useState({});

  useEffect(() => {
    try {
      (async () => {
        const json = await (
          await fetch(requestQuery.makeQuery(target, id))
        ).json();
        setState(json);
      })();
    } catch (e) {
      throw e;
    }
  }, deps);
  return state;
};
