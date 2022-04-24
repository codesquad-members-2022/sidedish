import { Category, CategoryTitle, CategoryMenuList } from "./Header.style";
import NavigationMenuItems from "./NavigationMenuItems";

const NavigationItems = ({ isOpen, categoriesData }) => {
  return categoriesData.map(_getCategory(isOpen));
};

const _getCategory =
  (isOpen) =>
  ({ id, categoryTitle, categoryMenus }) =>
    (
      <Category key={id}>
        <CategoryTitle>{categoryTitle}</CategoryTitle>
        <CategoryMenuList isOpen={isOpen}>
          {isOpen ? <NavigationMenuItems categoryMenus={categoryMenus} /> : ""}
        </CategoryMenuList>
      </Category>
    );

export default NavigationItems;
