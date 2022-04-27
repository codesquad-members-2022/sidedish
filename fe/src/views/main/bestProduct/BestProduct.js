import { useEffect, useState } from 'react';
import { TabMenu } from './tabMenu/tabMenu.js';
import { TabList } from './tabList/tabList.js';
import { BestProductHeader, CategoryBadge, StyledBestProduct, TabBar, TitleWrapper } from './BestProduct.styled';
import { fetchData } from '../../../helper/utils';
import { API } from '../../../helper/constants.js';
import { ExhibitionTitle } from './title/exhibitionTitle';

export function BestProduct() {
  const [exhibitionTitle, setExhibitionTitle] = useState('');
  const [tabMenu, setTabMenu] = useState([]);
  const [tabList, setTabList] = useState([]);
  const [curTab, setCurTab] = useState(0);

  useEffect(() => {
    async function getExhibitionData() {
      const exhibitionData = await fetchData(API.exhibitions);
      const { exhibitionTitle, categoryResponses } = exhibitionData;
      setExhibitionTitle(exhibitionTitle);
      setTabMenu(categoryResponses);

      const firstCategoryId = categoryResponses[0].categoryId;
      setCurTab(firstCategoryId);
    }
    getExhibitionData();
  }, []);

  useEffect(() => {
    if (curTab === 0) {
      return;
    }
    async function getSideDishDataByTabMenu() {
      const { sideDishCardResponses } = await fetchData(API.categoryDishes(curTab));
      setTabList(sideDishCardResponses);
    }
    getSideDishDataByTabMenu();
  }, [curTab]);

  return (
    <StyledBestProduct>
      <BestProductHeader>
        <TitleWrapper flex align="center">
          <CategoryBadge>기획전</CategoryBadge>
          <ExhibitionTitle title={exhibitionTitle} />
        </TitleWrapper>
        <TabBar flex>
          <TabMenu
            menus={tabMenu}
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
