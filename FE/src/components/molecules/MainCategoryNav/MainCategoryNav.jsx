<<<<<<< HEAD
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
=======
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
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
<<<<<<< HEAD
      className="category-nav"
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
=======
      className={className}
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainNav}
    </nav>
  );
}
<<<<<<< HEAD
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
=======
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
