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
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainSubNav}
    </nav>
  );
}

function createSubCategory(mainCategory, subCategoryList, mainIndex) {
  const subCategories = subCategoryList.map((subCategory, subIndex) => {
    return (
      <StyledHeaderSubCategory
        key={`sub${subIndex}`}
        className="category-nav__sub"
        subCategory={subCategory}
      />
    );
  });

  return (
    <StyledHeaderMainCategory
      key={`main${mainIndex}`}
      className="category-nav__main"
      mainCategory={mainCategory}
      subCategories={subCategories}
    />
  );
}
