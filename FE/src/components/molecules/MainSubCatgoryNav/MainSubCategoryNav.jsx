<<<<<<< HEAD
<<<<<<< HEAD
import { navCategory } from "@/constant/constant.js";
import { StyledHeaderMainCategory } from "../../atoms/List/HeaderMainCategory.styled";
import { StyledHeaderSubCategory } from "../../atoms/List/HeaderSubCategory.styled";

export function MainSubCategoryNav({ className, setIsShown }) {
  const mainSubNav = navCategory.map(
    ({ mainCategory, subCategoryList }, mainIndex) => {
      return createSubCategory(mainCategory, subCategoryList, mainIndex);
    }
  );
  return (
    <nav
      className={className}
=======
import "./MainSubCategoryNav.scss";
=======
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
import { navCategory } from "@/constant/constant.js";
import { StyledHeaderMainCategory } from "../../atoms/List/HeaderMainCategory.styled";
import { StyledHeaderSubCategory } from "../../atoms/List/HeaderSubCategory.styled";

export function MainSubCategoryNav({ className, setIsShown }) {
  const mainSubNav = navCategory.map(
    ({ mainCategory, subCategoryList }, mainIndex) => {
      return createSubCategory(mainCategory, subCategoryList, mainIndex);
    }
  );
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
      {mainSubNav}
    </nav>
  );
}

<<<<<<< HEAD
<<<<<<< HEAD
function createSubCategory(mainCategory, subCategoryList, mainIndex) {
  const subCategories = subCategoryList.map((subCategory, subIndex) => {
    return (
      <StyledHeaderSubCategory
        key={`sub${subIndex}`}
        className="category-nav__sub"
        subCategory={subCategory}
      />
=======
function createSubCategory({ mainCategory, subCategoryList, id }) {
  const subCategories = subCategoryList.map((subCategory, index) => {
    return (
      <li className="category-nav__sub" key={`sub${index}`}>
        {subCategory}
      </li>
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
=======
function createSubCategory(mainCategory, subCategoryList, mainIndex) {
  const subCategories = subCategoryList.map((subCategory, subIndex) => {
    return (
      <StyledHeaderSubCategory
        key={`sub${subIndex}`}
        className="category-nav__sub"
        subCategory={subCategory}
      />
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
    );
  });

  return (
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
    <StyledHeaderMainCategory
      key={`main${mainIndex}`}
      className="category-nav__main"
      mainCategory={mainCategory}
      subCategories={subCategories}
    />
<<<<<<< HEAD
=======
    <li className="category-nav__main" key={id}>
      <span>{mainCategory}</span>
      <ul>{subCategories}</ul>
    </li>
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
=======
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
  );
}
