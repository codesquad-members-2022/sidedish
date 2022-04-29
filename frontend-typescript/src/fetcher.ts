import { useEffect, useState } from "react";
import { Queries, requestQuery } from "./convention";

import { Categories, Product, Products, SpecialCategories } from "./types";

export type ResponseType = {
  [Queries.product]: Product;
  [Queries.products]: Products;
  [Queries.specialCategories]: SpecialCategories;
  [Queries.specialProducts]: Products;
  [Queries.categories]: Categories;
};
export const useFetch = <T extends Queries>(
  target: T,
  id: number | undefined = undefined,
  ...deps: any[]
): ResponseType[T] => {
  const [state, setState] = useState<ResponseType[T] | any>({});

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
