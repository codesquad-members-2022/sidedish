import { useEffect, useState } from "react";

export const useCategories = () => {
  const [cats, setCats] = useState();
  useEffect(() => {
    (async () => {
      const json = await (await fetch("categories.json")).json();
      setCats(json.categories);
    })();
  }, []);
  return cats;
};
export const useThemes = () => {
  const [themes, setThemes] = useState();
  useEffect(() => {
    (async () => {
      const json = await (await fetch("categories.json")).json();
      setThemes(json.themes);
    })();
  }, []);
  return themes;
};
