import iconMenusData from "../../data/iconMenus";
import categoriesData from "../../data/categories";
import HeaderTitle from "./HeaderTitle";
import CategoryItems from "./CategoryItems";
import IconMenuItems from "./IconMenuItems";
import { Container, Wrapper, CategoryList, IconMenuList } from "./Header.style";

const Header = () => {
  return (
    <Container>
      <Wrapper>
        <CategoryList>
          <CategoryItems categoriesData={categoriesData} />
        <HeaderTitle title={"Ordering"} href={"/"} />
        </CategoryList>
        <IconMenuList>
          <IconMenuItems iconMenusData={iconMenusData} />
        </IconMenuList>
      </Wrapper>
    </Container>
  );
};

export default Header;
