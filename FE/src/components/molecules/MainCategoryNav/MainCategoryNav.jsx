import { navCategory } from "@/constant/constant.js";
import { StyledHeaderMainCategory } from "@/components/atoms/List/HeaderMainCategory.styled";
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
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainNav}
    </nav>
  );
}
