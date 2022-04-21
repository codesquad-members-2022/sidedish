import React from 'react';
import {
  SpecialContainer,
  SpecialBadge,
  SpecialTitle,
  SpecialTitleBox,
  SpecialTabBar,
  SpecialHeader,
  SpecialTab,
} from './Special.style';

const Special = () => {
  return (
    <SpecialContainer>
      <SpecialHeader>
        <SpecialTitleBox>
          <SpecialBadge>기획전</SpecialBadge>
          <SpecialTitle>한 번 주문하면 두 번 반하는 반찬</SpecialTitle>
        </SpecialTitleBox>
        <SpecialTabBar>
          <SpecialTab>풍성한 고기 반찬</SpecialTab>
          <SpecialTab>편리한 반찬 세트</SpecialTab>
          <SpecialTab>맛있는 제철 요리</SpecialTab>
          <SpecialTab>우리 아이 영양 반찬</SpecialTab>
        </SpecialTabBar>
      </SpecialHeader>
    </SpecialContainer>
  );
};

export default Special;
