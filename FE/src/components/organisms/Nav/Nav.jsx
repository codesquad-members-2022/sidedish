import { MainCategoryNav } from "@/components/molecules/MainCategoryNav/MainCategoryNav.jsx";
import { MainSubCategoryNav } from "@/components/molecules/MainSubCatgoryNav/MainSubCategoryNav";
// import { MainSubCategoryNav } from "@/components/molecules/MainSubCategoryNav/MainSubCategoryNav.jsx";
import "./Nav.scss";

export function Nav({ isShown, setIsShown }) {
  if (isShown) {
    return <MainSubCategoryNav setIsShown={setIsShown} />;
  }
  return <MainCategoryNav setIsShown={setIsShown} />;
}
