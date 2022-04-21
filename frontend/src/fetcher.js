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

export const useThemes = (extended) => {
  const [themes, setThemes] = useState();
  useEffect(() => {
    (async () => {
      const json = await (await fetch("/mocks/themes.json")).json();
      setThemes(json.themes);
    })();
  }, [extended]);
  return themes;
};

export const useProducts = (selected) => {
  const [products, setProducts] = useState();
  useEffect(() => {
    (async () => {
      const json = await (await fetch("/mocks/products.json")).json();
      setProducts(json.products);
    })();
  }, [selected]);
  return products;
};
