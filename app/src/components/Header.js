import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";

const Logo = styled.div`
  font-family: "Outfit";
  font-size: ${({ theme }) => theme.fontSize.display};
  font-weight: ${({ theme }) => theme.fontWeight.logo};
  margin-left: 8rem;
  margin-right: 4rem;
  line-height: 5rem;
`;

const Gnb = styled.nav`
  .gnb {
    display: flex;
    justify-content: space-between;
    margin-top: 1.2rem; 
    width: 35.2rem;
  }
  
  .gnb:hover {
    margin-bottom: 4.1rem;
  }
  
  .gnb:hover .lnb {
    display: block;
  }
  
  .gnb-item {
    font-size: ${({ theme }) => theme.fontSize.medium};
    font-weight: ${({ theme }) => theme.fontWeight.regular};
    line-height: 2.6rem;
  }
  
  .lnb {
    display: none;
    font-size: ${({ theme }) => theme.fontSize.small};
    margin-top: 1.6rem;
  }

  .lnb-item {
    margin-top 0.8rem;
  }
`;

const HeaderContainer = styled.div`
  display: flex;
  box-sizing: border-box;
  padding-top: 1.6rem;
  max-height: 19rem;
  min-height: 8.3rem;
  border-bottom: 1px solid ${({ theme }) => theme.color.black};
`;

const GNB = () => {
  return (
    <Gnb>
      <ul className="gnb">
        <li className="gnb-item">
          <span>
            <a href="#">든든한 메인요리</a>
          </span>
          <ul className="lnb">
            <li className="lnb-item">
              <a href="#">육류 요리</a>
            </li>
            <li className="lnb-item">
              <a href="#">해산물 요리</a>
            </li>
          </ul>
        </li>
        <li className="gnb-item">
          <span>
            <a href="#">뜨끈한 국물요리</a>
          </span>
          <ul className="lnb">
            <li className="lnb-item">
              <a href="#">국/탕/찌개</a>
            </li>
          </ul>
        </li>
        <li className="gnb-item">
          <span>
            <a href="#">정갈한 밑반찬</a>
          </span>
          <ul className="lnb">
            <li className="lnb-item">
              <a href="#">나물/무침</a>
            </li>
            <li className="lnb-item">
              <a href="#">조림/볶음</a>
            </li>
            <li className="lnb-item">
              <a href="#">절임/장아찌</a>
            </li>
          </ul>
        </li>
      </ul>
    </Gnb>
  );
};

const Icons = styled.ul`
  display: flex;
  margin: 1.2rem 8.5rem 0 auto;
  gap: 2.6rem;
  height: 2.8rem;
  align-items: center;
`;

const IconMenu = () => {
  return (
    <Icons>
      <li className="search">
        <a href="#">
          <img src="../images/Search.svg" alt="검색" />
        </a>
      </li>
      <li className="my-page">
        <a href="#">
          <img src="../images/MyPage.svg" alt="마이페이지" />
        </a>
      </li>
      <li className="cart">
        <a href="#">
          <img src="../images/Cart.svg" alt="장바구니" />
        </a>
      </li>
    </Icons>
  );
};

const Header = () => {
  return (
    <ThemeProvider theme={theme}>
      <HeaderContainer>
        <Logo>
          <a href="#">Ordering</a>
        </Logo>
        <GNB />
        <IconMenu />
      </HeaderContainer>
    </ThemeProvider>
  );
};

export default Header;
