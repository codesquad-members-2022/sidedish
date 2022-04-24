import { Link } from "react-router-dom";
import { CategoryMenu } from "./Header.style";

const NavigationMenuItems = ({ categoryMenus }) => {
  return categoryMenus.map(_getCategoryMenuItem);
};

const _getCategoryMenuItem = ({ id, menu }) => (
  <CategoryMenu key={id}>
    <Link to="#">{menu}</Link>
  </CategoryMenu>
);

export default NavigationMenuItems;
