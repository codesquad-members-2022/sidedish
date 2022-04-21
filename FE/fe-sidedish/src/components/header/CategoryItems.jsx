import { Category, CategoryTitle, CategoryMenuList } from "./Header.style";
import CategoryMenuItems from "./CategoryMenuItems";

const CategoryItems = ({ categoriesData }) => {
  return categoriesData.map(_getCategory);
};

const _getCategory = ({ id, categoryTitle, categoryMenus }) => (
  <Category key={id}>
    <CategoryTitle>{categoryTitle}</CategoryTitle>
    <CategoryMenuList>
      <CategoryMenuItems categoryMenus={categoryMenus} />
    </CategoryMenuList>
  </Category>
);

export default CategoryItems;
