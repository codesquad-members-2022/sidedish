import { useEffect, useState } from "react";

export const useCategories = (extended) => {
  const [cats, setCats] = useState();
  useEffect(() => {
    (async () => {
      const json = await (await fetch("/mocks/categories.json")).json();
      setCats(json.categories);
    })();
  }, [extended]);
  return cats;
};

export const useSpecialCategories = (extended) => {
  const [specialCategories, setSpecialCategories] = useState();
  useEffect(() => {
    (async () => {
      const json = await (await fetch("/mocks/specialCategories.json")).json();
      setSpecialCategories(json.specialCategories);
    })();
  }, [extended]);
  return specialCategories;
};

export const useFetch = (selected, special) => {
  const [products, setProducts] = useState();
  useEffect(() => {
    let query = special
      ? "/mocks/specialCategoryProducts.json"
      : "/mocks/categoryProducts.json";
    (async () => {
      const json = await (await fetch(query)).json();

      setProducts(json.category);
    })();
  }, [selected]);
  return products;
};
