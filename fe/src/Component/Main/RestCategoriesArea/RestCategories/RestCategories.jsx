import Category from "Component/Main/SideDishItemsArea/Category/Category";
import { useEffect, useState } from "react";
import dataTools from "common/dataTools";
import menuCategoriesApi from "Service/menuCategoriesApi";

const RestCategories = () => {
  const [restCategoriesData, setRestCategoriesData] = useState([]);
  const fetchRestMenuCategories = async () => {
    const { menuCategories } = await menuCategoriesApi.getRestMenuCategories();

    const menuCategoryDatas = dataTools.addIdToMenuCategoryData(menuCategories);

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
