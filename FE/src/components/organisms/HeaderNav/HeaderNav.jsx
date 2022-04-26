import { MainCategoryNav } from "@/components/molecules/MainCategoryNav/MainCategoryNav.jsx";
import { MainSubCategoryNav } from "@/components/molecules/MainSubCatgoryNav/MainSubCategoryNav";
import "./HeaderNav.scss";

export function HeaderNav({ isShown, setIsShown }) {
  if (isShown) {
    return <MainSubCategoryNav setIsShown={setIsShown} />;
  }
  return <MainCategoryNav setIsShown={setIsShown} />;
}
