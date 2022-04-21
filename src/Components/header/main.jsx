import React from 'react';
import GNB from './GNB';
import styled from 'styled-components';
import { F_basicCenter, F_BtweenCenter, Color } from '../../Assets/CommonStyle';

const HEADER = styled.header`
  ${F_BtweenCenter}
  padding: 16px 80px;
  border-bottom: 1px solid ${Color.black};
  transition: 0.3s;

  &.active {
    padding-bottom: 80px;
  }
`;

const Logo = styled.h1`
  font-family: 'Outfit';
  font-size: 40px;
  font-weight: 900;
`;

const Flex = styled.div`
  ${F_basicCenter}
`;

const HeaderIcon = styled.button`
  margin-left: 16px;
`;

const IconImg = styled.img`
  display: block;
`;

export default function Header() {
  return (
    <HEADER>
      <Flex>
        <Logo>Ordering</Logo>
        <GNB />
      </Flex>
      <Flex>
        <HeaderIcon>
          <IconImg src="/public_assets/Image/search.png" alt="검색" />
        </HeaderIcon>
        <HeaderIcon>
          <IconImg src="/public_assets/Image/mypage.png" alt="마이페이지" />
        </HeaderIcon>
        <HeaderIcon>
          <IconImg
            src="/public_assets/Image/shopping-cart.png"
            alt="장바구니"
          />
        </HeaderIcon>
      </Flex>
    </HEADER>
  );
}
