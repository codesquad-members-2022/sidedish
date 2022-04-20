import styled from 'styled-components';

const Root = styled.div`
  button:not(:last-child) {
    margin-right: 16px;
  }
`;

const searchIcon = 'Search.svg';
const mypage = 'Mypage.svg';
const cart = 'Shopping-cart.svg';

export const UserButtons = () => {
  return(
    <Root>
      <button><img src={searchIcon} alt="검색"/></button>
      <button><img src={mypage} alt="마이페이지"/></button>
      <button><img src={cart} alt="장바구니"/></button>
    </Root>
  );
}