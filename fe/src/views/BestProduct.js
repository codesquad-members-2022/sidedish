import { useEffect, useState } from 'react';
import { bestProductTapDatas } from '../helper/mock';
import { TapMenu } from './bestProduct/tabMenu.js';
import { TapList } from './bestProduct/tabList';
import {
  BestProductHeader,
  CategoryBadge,
  StyledBestProduct,
  TapBar,
  Title,
  TitleWrapper,
} from './bestProduct/BestProduct.styled';

export function BestProduct() {
  const [bestProductTap, setBestProductTap] = useState(null);
  const [tapList, setTapList] = useState(null);
  const [curTap, setCurTap] = useState(null);
  useEffect(() => {
    const tapMenus = [
      { title: '풍성한 고기반찬', id: 0 },
      { title: '편리한 반찬 세트', id: 1 },
      { title: '맛있는 제철 요리', id: 2 },
      { title: '우리 아이 영양 반찬', id: 3 },
    ];
    setBestProductTap(tapMenus);
    setCurTap(0);
  }, []);

  useEffect(() => {
    if (!bestProductTap) return;
    setTapList(bestProductTapDatas[curTap]);
  }, [bestProductTap, curTap]);

  return (
    <StyledBestProduct>
      <BestProductHeader>
        <TitleWrapper flex align="center">
          <CategoryBadge>기획전</CategoryBadge>
          <Title>한 번 주문하면 두 번 반하는 반찬</Title>
        </TitleWrapper>
        <TapBar flex>
          <TapMenu
            menus={bestProductTap}
            onMouseEnter={handleTapMouseEnter}
            onMouseLeave={handleTapMouseLeave}
            onClick={handleTapClick}
            curTap={curTap}
            setCurTap={setCurTap}
          />
        </TapBar>
      </BestProductHeader>
      <TapList tapList={tapList} />
    </StyledBestProduct>
  );
}

function handleTapMouseEnter(e) {
  e.target.style.borderColor = 'black';
}
function handleTapMouseLeave(e) {
  e.target.style.borderColor = 'white';
}

function handleTapClick(e, setCurTap) {
  setCurTap(Number(e.target.dataset.menuId));
}
