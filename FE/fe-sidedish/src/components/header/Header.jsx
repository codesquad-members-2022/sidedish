import iconMenusData from "../../data/iconMenus";
import categoriesData from "../../data/categories";
import {
  Container,
  Wrapper,
  Title,
  CategoryList,
  IconMenuList,
} from "./Header.style";
import CategoryItems from "./CategoryItems";
import IconMenuItems from "./IconMenuItems";

const Header = () => {
  return (
    <Container>
      <Wrapper>
        <Title>Ordering</Title>
        <CategoryList>
          <CategoryItems categoriesData={categoriesData} />
        </CategoryList>
        <IconMenuList>
          <IconMenuItems iconMenusData={iconMenusData} />
        </IconMenuList>
      </Wrapper>
    </Container>
  );
};

export default Header;
