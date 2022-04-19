import { MenuList } from './MenuList';
import styled from 'styled-components';

const StyledHeader = styled.div`
  width: 100%;
  display: flex;
  align-items: flex-start;
`;

const Logo = styled.h1`
  margin-right: 40px;
`;

const TopBarUI = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  width: 100%;
  padding-top: 12px;
`;

const UserButtons = styled.div`
  button:not(:last-child) {
    margin-right: 16px;
  }
`;

const searchIcon = '/Search.svg';
const mypage = '/Mypage.svg';
const cart = '/Shopping-cart.svg';

export const Header = () => {
  return (
    <StyledHeader>
      <Logo>Ordering</Logo>
      <TopBarUI>
        <MenuList />
        <UserButtons>
          <button>
            <img src={searchIcon} alt={""} />
          </button>
          <button>
            <img src={mypage} alt={""} />
          </button>
          <button>
            <img src={cart} alt={""} />
          </button>
        </UserButtons>
      </TopBarUI>
    </StyledHeader>
  );
};
