import { Category, CategoryTitle, CategoryMenuList } from "./Header.style";
import CategoryMenuItems from "./CategoryMenuItems";

const CategoryItems = ({ isOpen, categoriesData }) => {
  return categoriesData.map(_getCategory(isOpen));
};

const _getCategory =
  (isOpen) =>
  ({ id, categoryTitle, categoryMenus }) =>
    (
      <Category key={id}>
        <CategoryTitle>{categoryTitle}</CategoryTitle>
        <CategoryMenuList isOpen={isOpen}>
          {isOpen ? <CategoryMenuItems categoryMenus={categoryMenus} /> : ""}
        </CategoryMenuList>
      </Category>
    );

export default CategoryItems;
