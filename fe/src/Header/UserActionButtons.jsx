import styled from 'styled-components';

const UserActionButtonsWrapper = styled.div`
  padding-top: 12px;
  flex-shrink: 0;
  
  button:not(:last-child) {
    margin-right: 16px;
  }
  
  img {
    display: block;
    
    &:hover {
      opacity: 0.6;
    }
    
    &:active {
      opacity: 0.3;
    }
  }
`;

const SEARCH_ICON = 'Search.svg';
const MYPAGE_ICON = 'Mypage.svg';
const CART_ICON = 'Shopping-cart.svg';

export const UserActionButtons = () => {
  return (
    <UserActionButtonsWrapper>
      <button>
        <img src={SEARCH_ICON} alt="검색" />
      </button>
      <button>
        <img src={MYPAGE_ICON} alt="마이페이지" />
      </button>
      <button>
        <img src={CART_ICON} alt="장바구니" />
      </button>
    </UserActionButtonsWrapper>
  );
};
