<<<<<<< HEAD
import { navCategory } from "@/constant/constant.js";
import { StyledHeaderMainCategory } from "../../atoms/List/HeaderMainCategory.styled";
export function MainCategoryNav({ className, setIsShown }) {
  const mainNav = navCategory.map(({ id, mainCategory }, index) => {
    return (
      <StyledHeaderMainCategory
        key={`main${index}`}
        className="category-nav__main"
        id={id}
        mainCategory={mainCategory}
      />
    );
  });
  return (
    <nav
      className={className}
=======
import "./MainCategoryNav.scss";
import { navCategory } from "@/constant/constant.js";

export function MainCategoryNav({ setIsShown }) {
  const mainNav = navCategory.map(createMainCategory);
  return (
    <nav
      className="category-nav"
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainNav}
    </nav>
  );
}
<<<<<<< HEAD
=======

function createMainCategory({ id, mainCategory }) {
  return (
    <li key={id} className="category-nav__main">
      {mainCategory}
    </li>
  );
}
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
