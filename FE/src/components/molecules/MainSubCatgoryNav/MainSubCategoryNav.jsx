import "./MainSubCategoryNav.scss";
import { navCategory } from "@/constant/constant.js";

export function MainSubCategoryNav({ setIsShown }) {
  const mainSubNav = navCategory.map(createSubCategory);

  return (
    <nav
      className="category-nav"
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainSubNav}
    </nav>
  );
}

function createSubCategory({ mainCategory, subCategoryList, id }) {
  const subCategories = subCategoryList.map((subCategory, index) => {
    return (
      <li className="category-nav__sub" key={`sub${index}`}>
        {subCategory}
      </li>
    );
  });

  return (
    <li className="category-nav__main" key={id}>
      <span>{mainCategory}</span>
      <ul>{subCategories}</ul>
    </li>
  );
}
