import { useState } from "react";
import iconMenusData from "../../data/iconMenus";
import categoriesData from "../../data/categories";
import HeaderTitle from "./HeaderTitle";
import NavigationItems from "./NavigationItems";
import IconMenuItems from "./IconMenuItems";
import { Container, Wrapper, CategoryList, IconMenuList } from "./Header.style";

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  const handleMouseEnter = () => {
    setIsOpen(true);
  };
  const handleMouseLeave = () => {
    setIsOpen(false);
  };

  return (
    <Container isOpen={isOpen}>
      <Wrapper>
        <HeaderTitle title={"Ordering"} href={"/"} />
        <CategoryList
          onMouseEnter={handleMouseEnter}
          onMouseLeave={handleMouseLeave}
        >
          <NavigationItems isOpen={isOpen} categoriesData={categoriesData} />
        </CategoryList>
        <IconMenuList>
          <IconMenuItems iconMenusData={iconMenusData} />
        </IconMenuList>
      </Wrapper>
    </Container>
  );
};

export default Header;
