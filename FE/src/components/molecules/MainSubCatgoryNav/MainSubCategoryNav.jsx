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
import { navCategory } from "@/constant/constant.js";

export function MainSubCategoryNav({ setIsShown }) {
  const mainSubNav = navCategory.map(createSubCategory);

  return (
    <nav
      className="category-nav"
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainSubNav}
    </nav>
  );
}

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
    );
  });

  return (
<<<<<<< HEAD
    <StyledHeaderMainCategory
      key={`main${mainIndex}`}
      className="category-nav__main"
      mainCategory={mainCategory}
      subCategories={subCategories}
    />
=======
    <li className="category-nav__main" key={id}>
      <span>{mainCategory}</span>
      <ul>{subCategories}</ul>
    </li>
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
  );
}
