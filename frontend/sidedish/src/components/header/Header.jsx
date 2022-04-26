import styled from "styled-components";
import Gnb from "./Gnb";
import { ReactComponent as SearchIcon } from "../../asset/searchIcon.svg";
import { ReactComponent as UserIcon } from "../../asset/userIcon.svg";
import { ReactComponent as CartIcon } from "../../asset/cartIcon.svg";

const Header = () => {
  return (
    <HeaderContainer>
      <Home>Ordering</Home>
      <Gnb />
      <Blank />
      <SearchIcon />
      <UserIcon />
      <CartIcon />
    </HeaderContainer>
  );
};

const HeaderContainer = styled.header`
  display: flex;
  flex-direction: row;
  padding: 16px 80px;
  border-bottom: 1px solid black;
  white-space: nowrap;
`;

const Home = styled.h1`
  font-family: "Outfit";
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 50px;
  cursor: pointer;
`;

const Blank = styled.div`
  flex-grow: 1;
`;

const Img = styled.img`
  width: 23px;
  height: 23px;
  padding: 20px 13px;
  cursor: pointer;
`;

export default Header;
