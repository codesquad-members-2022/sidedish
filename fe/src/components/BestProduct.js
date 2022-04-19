import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { applyFlex } from '../helper/utils';

const CategoryBadge = styled.div`
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  padding: 8px 8px;
  width: 76px;
  height: 42px;
  background: #f8f7f7;
  text-align: center;
  border: 2px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 999px;
`;

const TitleWrapper = styled.div`
  ${props => applyFlex(props)}
`;

const StyledBestProduct = styled.div`
  margin-top: 56px;
`;

const BestProductHeader = styled.div`
  padding: 0 80px;
  border-bottom: 1px solid #ebebeb;
`;

const Title = styled.h1`
  margin-left: 16px;
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  line-height: 58px;
`;

const TabBar = styled.ul`
  ${props => applyFlex(props)};
  margin-top: 24px;
  li {
    margin-right: 32px;
    padding-bottom: 17px;
    font-family: 'Noto Sans KR';
    font-style: normal;
    font-weight: 500;
    font-size: 20px;
    line-height: 30px;

    &:hover {
      border-bottom: 1px solid black;
    }
  }
`;

function TabMenu(props) {
  if (!props.menus) {
    return ``;
  }
  return props.menus.map(menu => menu.title).map((menu, idx) => <li key={idx}>{menu}</li>);
}

export function BestProduct() {
  const [bestProductTab, setBestProductTab] = useState(null);
  useEffect(() => {
    const tabMenus = [
      { title: '풍성한 고기반찬', api: 'http:??' },
      { title: '편리한 반찬 세트', api: 'http:??' },
      { title: '맛있는 제철 요리', api: 'http:??' },
      { title: '우리 아이 영양 반찬', api: 'http:??' },
    ];
    setBestProductTab(tabMenus);
  }, []);

  useEffect(() => {
    console.log(document.querySelectorAll('li'));
  }, [bestProductTab]);

  return (
    <StyledBestProduct>
      <BestProductHeader>
        <TitleWrapper flex align="center">
          <CategoryBadge>기획전</CategoryBadge>
          <Title>한 번 주문하면 두 번 반하는 반찬</Title>
        </TitleWrapper>

        <TabBar flex>
          <TabMenu menus={bestProductTab}></TabMenu>
        </TabBar>
      </BestProductHeader>
    </StyledBestProduct>
  );
}

// bestProductTab : {"title":"풍성한 고기반찬", "api":"http:bangdler.com/"}
