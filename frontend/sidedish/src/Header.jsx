import styled from "styled-components";
import Gnb from "./Gnb";

const HeaderContainer = styled.header`
  display: flex;
  flex-direction: row;
  padding: 16px 80px;
  border-bottom: 1px solid black;
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

const Header = () => {
  return (
    <HeaderContainer>
      <Home>Ordering</Home>
      <Gnb />
      <Blank />
      <Img src="./images/searchIcon.png" alt="돋보기아이콘" />
      <Img src="./images/userIcon.png" alt="사람아이콘" />
      <Img src="./images/cartIcon.png" alt="카트아이콘" />
    </HeaderContainer>
  );
};

export default Header;
