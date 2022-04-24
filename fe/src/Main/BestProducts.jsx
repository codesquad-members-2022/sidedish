import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { ProductCard } from './ProductCard';
import { TabList } from './TabList';

import { CategoryBadge } from '@/Badge/CategoryBadge';
import Colors from '@/Constants/Colors';

const BestProductWrapper = styled.div`
  display: flex;
  padding: 56px 80px;
  margin: 0 -80px;
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

  const onClickTab = event => {
    const tabId = event.target.dataset.id;
    setSelectedTabId(Number(tabId));
  };

  useEffect(() => {
    fetch('/events')
      .then(body => body.json())
      .then(data => {
        setTabList(data.content);
        setSelectedTabId(data.content[0].id);
      });
  }, []);

  useEffect(() => {
    if (!selectedTabId) {
      return;
    }

    fetch(`/events/${selectedTabId}`)
      .then(body => body.json())
      .then(data => {
        setCardData(data.content);
      });
  }, [selectedTabId]);

  return (
    <BestProductWrapper>
      <Header>
        <BadgeWrapper>
          <CategoryBadge />
        </BadgeWrapper>

        <Title className="fonts-display">
          한번 주문하면 두번 주문하는 반찬
        </Title>
      </Header>

      <TabList onClickTab={onClickTab} tabData={tabList} />

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
