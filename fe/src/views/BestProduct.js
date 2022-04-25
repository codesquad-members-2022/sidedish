import { useEffect, useState } from 'react';
import { TabMenu } from './bestProduct/tabMenu.js';
import { TabList } from './bestProduct/tabList';
import {
  BestProductHeader,
  CategoryBadge,
  StyledBestProduct,
  TabBar,
  TitleWrapper,
} from './bestProduct/BestProduct.styled';
import { fetchData } from '../helper/utils';
import { API } from '../helper/constants';
import { ExhibitionTitle } from './bestProduct/exhibitionTitle';

export function BestProduct() {
  const [exhibitionTitle, setExhibitionTitle] = useState(null);
  const [bestProductTab, setBestProductTab] = useState(null);
  const [tabList, setTabList] = useState(null);
  const [curTab, setCurTab] = useState(null);
  const [sideDishCardDatas, setSideDishCardDatas] = useState([]);
  useEffect(() => {
    async function getExhibitionData() {
      const exhibitionData = await fetchData(API.exhibitions);
      const { exhibitionTitle, categoryResponses } = exhibitionData;
      setExhibitionTitle(exhibitionTitle);
      setBestProductTab(categoryResponses);
      setSideDishCardDatas(
        categoryResponses.reduce((sideDishCardDatas, category) => {
          sideDishCardDatas[category.categoryId] = category.sideDishCardResponses;
          return sideDishCardDatas;
        }, {})
      );
      const firstCategoryId = categoryResponses[0].categoryId;
      setCurTab(firstCategoryId);
    }
    getExhibitionData();
  }, []);

  useEffect(() => {
    if (curTab === null) {
      return;
    }
    setTabList(sideDishCardDatas[curTab]);
  }, [sideDishCardDatas, curTab]);

  return (
    <StyledBestProduct>
      <BestProductHeader>
        <TitleWrapper flex align="center">
          <CategoryBadge>기획전</CategoryBadge>
          <ExhibitionTitle title={exhibitionTitle}></ExhibitionTitle>
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
