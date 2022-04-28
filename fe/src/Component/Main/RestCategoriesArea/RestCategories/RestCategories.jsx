import Category from "Component/Main/SideDishItemsArea/Category/Category";
import { useEffect, useState } from "react";
import menuCategoriesApi from "Service/menuCategoriesApi";

const RestCategories = () => {
  const [restCategoriesData, setRestCategoriesData] = useState([]);
  const fetchRestMenuCategories = async () => {
    const { menuCategories } = await menuCategoriesApi.getRestMenuCategories();

    const menuCategoryDatas = menuCategories.map(
      ({ menuCategoryName, sideDishes }, idx) => {
        return {
          category: { name: menuCategoryName, id: idx },
          sideDishes,
        };
      }
    );

    setRestCategoriesData(menuCategoryDatas);
  };

  useEffect(() => {
    fetchRestMenuCategories();
  }, []);

  return restCategoriesData.map(({ category: { name, id }, sideDishes }) => (
    <div key={id}>
      <Category name={name} sideDishes={sideDishes} />
    </div>
  ));
};

export default RestCategories;
