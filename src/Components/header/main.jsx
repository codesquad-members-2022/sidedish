import React, { useState } from 'react';
import GNB from './GNB';
import styled from 'styled-components';
import {
  Inner,
  F_basicCenter,
  F_BtweenCenter,
  Color,
} from '../../Assets/CommonStyle';

const HEADER = styled.header`
  padding: 16px 0;
  border-bottom: 1px solid ${Color.black};
  transition: 0.3s;

  &.active {
    padding-bottom: 80px;
  }
`;

const HeaderInner = styled(Inner)`
  ${F_BtweenCenter};
  justify-content: space-between;
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

const GNB_LIST = [
  {
    title: '든든한 메인요리',
    menu: [
      {
        title: '육류 요리',
      },
      {
        title: '해산물 요리',
      },
    ],
  },
  {
    title: '뜨끈한 국물요리',
    menu: [
      {
        title: '국,탕,찌개',
      },
    ],
  },
  {
    title: '정갈한 밑반찬',
    menu: [
      {
        title: '나물/무침',
      },
      {
        title: '조림/볶음',
      },
      {
        title: '절임/장아찌',
      },
    ],
  },
];

export default function Header() {
  const [isHover, setIsHover] = useState(false);

  return (
    <HEADER className={isHover ? 'active' : null}>
      <HeaderInner>
        <Flex>
          <Logo>Ordering</Logo>
          <GNB list={GNB_LIST} isHover={isHover} setIsHover={setIsHover} />
        </Flex>
        <Flex>
          <HeaderIcon>
            <IconImg src="/public_assets/Image/search.svg" alt="검색" />
          </HeaderIcon>
          <HeaderIcon>
            <IconImg src="/public_assets/Image/mypage.svg" alt="마이페이지" />
          </HeaderIcon>
          <HeaderIcon>
            <IconImg
              src="/public_assets/Image/shopping-cart.svg"
              alt="장바구니"
            />
          </HeaderIcon>
        </Flex>
      </HeaderInner>
    </HEADER>
  );
}
