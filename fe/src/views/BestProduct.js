import { useEffect, useState } from 'react';
import { bestProductTabDatas } from '../helper/mock';
import { TabMenu } from './bestProduct/tabMenu.js';
import { TabList } from './bestProduct/tabList';
import {
  BestProductHeader,
  CategoryBadge,
  StyledBestProduct,
  TabBar,
  Title,
  TitleWrapper,
} from './bestProduct/BestProduct.styled';

export function BestProduct() {
  const [bestProductTab, setBestProductTab] = useState(null);
  const [tabList, setTabList] = useState(null);
  const [curTab, setCurTab] = useState(null);
  useEffect(() => {
    const tabMenus = [
      { title: '풍성한 고기반찬', id: 0 },
      { title: '편리한 반찬 세트', id: 1 },
      { title: '맛있는 제철 요리', id: 2 },
      { title: '우리 아이 영양 반찬', id: 3 },
    ];
    setBestProductTab(tabMenus);
    setCurTab(0);
  }, []);

  useEffect(() => {
    if (curTab === null) {
      return;
    }
    setTabList(bestProductTabDatas[curTab]);
  }, [curTab]);

  return (
    <StyledBestProduct>
      <BestProductHeader>
        <TitleWrapper flex align="center">
          <CategoryBadge>기획전</CategoryBadge>
          <Title>한 번 주문하면 두 번 반하는 반찬</Title>
        </TitleWrapper>
        <TabBar flex>
          <TabMenu
            menus={bestProductTab}
            onMouseEnter={handleTabMouseEnter}
            onMouseLeave={handleTabMouseLeave}
            onClick={handleTabClick}
            curTab={curTab}
            setCurTab={setCurTab}
          />
        </TabBar>
      </BestProductHeader>
      <TabList tabList={tabList} />
    </StyledBestProduct>
  );
}

function handleTabMouseEnter(e) {
  e.target.style.borderColor = 'black';
}
function handleTabMouseLeave(e) {
  e.target.style.borderColor = 'white';
}

function handleTabClick(e, setCurTab) {
  setCurTab(Number(e.target.dataset.menuId));
}
