import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { Colors, Fonts } from '@/Constants';
import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { Contents } from './Contents';
import { TabList } from './TabList';

import { CategoryBadge } from '@/Components/Badge';
import { LoadingSpinner } from '@/Components/LoadingSpinner';

const BestProductsWrapper = styled.div`
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

const Title = styled.span`
  margin-left: 10px;
`;

const BadgeWrapper = styled.div`
  display: flex;
  align-items: center;
`;

const LS_MARGIN = 10;
const LS_RADIUS = 30;
const LS_BORDER_WIDTH = 10;

export const BestProducts = () => {
  const [tabList, isLoaded] = useFetch(`${API_URL}/events`);
  const [selectedTabId, setSelectedTabId] = useState(null);

  useEffect(() => {
    if (!isLoaded) {
      return;
    }

    const firstTabIndex = 0;
    setSelectedTabId(tabList.result_body[firstTabIndex].id);
  }, [isLoaded]);

  const onClickTab = clickedTabId => () => {
    setSelectedTabId(clickedTabId);
  };

  return (
    <BestProductsWrapper>
      <Header>
        <BadgeWrapper>
          <CategoryBadge />
        </BadgeWrapper>

        <Title className={Fonts.DISPLAY}>
          한번 주문하면 두번 주문하는 반찬
        </Title>
      </Header>

      {!isLoaded ? (
        <LoadingSpinner
          margin={LS_MARGIN}
          radius={LS_RADIUS}
          borderWidth={LS_BORDER_WIDTH}
        />
      ) : (
        <TabList
          tabData={tabList.result_body}
          selectedTabId={selectedTabId}
          onClickTab={onClickTab}
        />
      )}

      {selectedTabId && <Contents bestProductsTabId={selectedTabId} />}
    </BestProductsWrapper>
  );
};
