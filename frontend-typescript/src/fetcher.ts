import { useEffect, useState } from "react";
import { Queries, requestQuery } from "./convention";

import { Categories, Product, Products, SpecialCategories } from "./product";

export type ResponseType = {
  [Queries.product]: Product;
  [Queries.products]: Products;
  [Queries.specialCategories]: SpecialCategories;
  [Queries.categories]: Categories;
};
export const useFetch = <T extends Queries>(
  target: T,
  id = undefined,
  ...deps: any[]
): ResponseType => {
  const [state, setState] = useState<ResponseType[T] | undefined>();

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
