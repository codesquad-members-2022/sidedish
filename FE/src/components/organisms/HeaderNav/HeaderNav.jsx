import { MainCategoryNav } from "@/components/molecules/MainCategoryNav/MainCategoryNav.jsx";
import { MainSubCategoryNav } from "@/components/molecules/MainSubCatgoryNav/MainSubCategoryNav";
import "./HeaderNav.scss";

export function HeaderNav({ isShown, setIsShown }) {
  if (isShown) {
<<<<<<< HEAD
    return (
      <MainSubCategoryNav className="category-nav" setIsShown={setIsShown} />
    );
  }
  return <MainCategoryNav className="category-nav" setIsShown={setIsShown} />;
=======
    return <MainSubCategoryNav setIsShown={setIsShown} />;
  }
  return <MainCategoryNav setIsShown={setIsShown} />;
>>>>>>> 514d651 ([#31] Rename: Nav를 HeaderNav로 이름 변경)
}
