import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { Colors, Fonts } from '@/Constants';

import { TabList } from './TabList';

import { CategoryBadge } from '@/Components/Badge/CategoryBadge';
import { ProductCard } from '@/Components/ProductCard';
import { fetchData } from '@/Utils/Utils';

const BestProductWrapper = styled.div`
  display: flex;
  padding: 56px 80px;
  border-bottom: 1px solid ${Colors.LIGHT_GREY};
  flex-direction: column;
`;

const Header = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 8px;
`;

const ProductCardList = styled.ul`
  display: flex;
  margin-top: 34px;
`;

const Title = styled.span`
  margin-left: 10px;
`;

const BadgeWrapper = styled.div`
  display: flex;
  align-items: center;
`;

export const BestProducts = () => {
  const [tabList, setTabList] = useState([]);
  const [selectedTabId, setSelectedTabId] = useState(null);
  const [cardData, setCardData] = useState([]);

  useEffect(() => {
    fetchData('/events')
      .then(tabListData => {
        setTabList(tabListData.content);
        setSelectedTabId(tabListData.content[0].id);
      })
      .catch(err => {
        //TODO: 에러 핸들링
        console.error(err);
      });
  }, []);

  useEffect(() => {
    if (!selectedTabId) {
      return;
    }

    fetchData(`/event/${selectedTabId}`)
      .then(selectedTabProductsData => {
        setCardData(selectedTabProductsData.content);
      })
      .catch(err => {
        console.error(err);
      });
  }, [selectedTabId]);

  const onClickTab = clickedTabId => () => {
    setSelectedTabId(clickedTabId);
  };

  return (
    <BestProductWrapper>
      <Header>
        <BadgeWrapper>
          <CategoryBadge />
        </BadgeWrapper>

        <Title className={Fonts.DISPLAY}>
          한번 주문하면 두번 주문하는 반찬
        </Title>
      </Header>

      <TabList
        tabData={tabList}
        selectedTabId={selectedTabId}
        onClickTab={onClickTab}
      />

      <ProductCardList>
        {cardData.map(productCardData => (
          <ProductCard
            size={''}
            data={productCardData}
            key={productCardData.id}
          />
        ))}
      </ProductCardList>
    </BestProductWrapper>
  );
};
