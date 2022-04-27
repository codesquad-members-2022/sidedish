import { MainCategoryNav } from "@/components/molecules/MainCategoryNav/MainCategoryNav.jsx";
import { MainSubCategoryNav } from "@/components/molecules/MainSubCatgoryNav/MainSubCategoryNav";
import "./HeaderNav.scss";

export function HeaderNav({ isShown, setIsShown }) {
  if (isShown) {
<<<<<<< HEAD
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
=======
    return (
      <MainSubCategoryNav className="category-nav" setIsShown={setIsShown} />
    );
  }
  return <MainCategoryNav className="category-nav" setIsShown={setIsShown} />;
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
}
