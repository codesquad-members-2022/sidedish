import { useState, useEffect } from "react";
import menuCategoriesApi from "Service/menuCategoriesApi";
import Category from "./Category/Category";

const SideDishItemsArea = () => {
  const [sideDishItemsData, setSideDishItemsData] = useState([]);

  const fetchFirstMenuCategory = async () => {
    const { menuCategories } = await menuCategoriesApi.getFirstMenuCategory();

    const menuCategoryDatas = menuCategories.map(
      ({ menuCategoryName, sideDishes }, idx) => {
        return {
          category: { name: menuCategoryName, id: idx },
          sideDishes,
        };
      }
    );

    setSideDishItemsData(menuCategoryDatas);
  };

  useEffect(() => {
    fetchFirstMenuCategory();
  }, []);

  return sideDishItemsData.map(({ category: { name, id }, sideDishes }) => (
    <div key={id}>
      <Category name={name} sideDishes={sideDishes} />
    </div>
  ));
};

export default SideDishItemsArea;
