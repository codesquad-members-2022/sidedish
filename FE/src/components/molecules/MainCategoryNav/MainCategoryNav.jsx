import "./MainCategoryNav.scss";
import { navCategory } from "@/constant/constant.js";

export function MainCategoryNav({ setIsShown }) {
  const mainNav = navCategory.map(createMainCategory);
  return (
    <nav
      className="category-nav"
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainNav}
    </nav>
  );
}

function createMainCategory({ id, mainCategory }) {
  return (
    <li key={id} className="category-nav__main">
      {mainCategory}
    </li>
  );
}
