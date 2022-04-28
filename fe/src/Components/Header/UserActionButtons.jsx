import styled from 'styled-components';

import { IconFonts } from '@/Constants';
import { LOGIN_URL } from '@/Env';

const UserActionButtonsWrapper = styled.div`
  padding-top: 12px;
  display: flex;
  flex-grow: 1;
  flex-shrink: 0;
  justify-content: flex-end;

  button:not(:last-child) {
    margin-right: 16px;
  }
`;

const Icon = styled.i`
  font-size: 24px;

  &:hover {
    opacity: 0.6;
  }

  &:active {
    opacity: 0.3;
  }
`;

export const UserActionButtons = () => {
  const handleClickLoginButton = () => {
    window.location.href = LOGIN_URL;
  };

  return (
    <UserActionButtonsWrapper>
      <button>
        <Icon className={IconFonts.SEARCH} aria-label={'검색'} />
      </button>
      <button onClick={handleClickLoginButton}>
        <Icon className={IconFonts.MY_PAGE} aria-label={'로그인'} />
      </button>
      <button>
        <Icon className={IconFonts.CART} aria-label={'장바구니'} />
      </button>
    </UserActionButtonsWrapper>
  );
};
