import { useEffect, useState } from 'react';
import styled from 'styled-components';
import COLOR from '../Constants/Colors';
import { ProductCard } from './ProductCard';
import { CategoryBadge } from '../Badge/CategoryBadge';

const BestProductWrapper = styled.li`
  display: flex;
  width: 1440px;
  padding: 0 80px;
  margin: 56px auto 0;
  flex-direction: column;
`;

const TabList = styled.ul`
  display: flex;

  border-bottom: 0.5px solid ${COLOR.LIGHT_GREY};
  margin: 0 -80px;
  padding: 0 80px;

  li {
    cursor: pointer;
    padding: 16px;
    border-bottom: 1.5px solid transparent;
  }

  li.selected {
    border-color: ${COLOR.BLACK};
  }

  li:hover {
    border-color: ${COLOR.BLACK};
  }
`;

const Header = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 8px;
`;

const Main = styled.ul`
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
  const [cardData, setCardData] = useState([]);
  const [selectedTabId, setSelectedTabId] = useState(null);

  useEffect(() => {
    fetch('/events')
      .then(body => body.json())
      .then(data => {
        setTabList(data.content);
        setSelectedTabId(data.content[0].id);
      });
  }, []);

  useEffect(() => {
    if (!selectedTabId) return;
    fetch(`/events/${selectedTabId}`)
      .then(body => body.json())
      .then(data => {
        setCardData(data.content);
        console.log(data.content);
      });
  }, [selectedTabId]);

  const onClickTab = event => {
    const tabId = event.target.dataset.id;
    setSelectedTabId(Number(tabId));
  };

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
      <TabList>
        {tabList.map(tab => (
          <li
            className={`fonts-lg ${selectedTabId === tab.id ? 'selected' : ''}`}
            key={tab.id}
            data-id={tab.id}
            onClick={onClickTab}
          >
            {tab.title}
          </li>
        ))}
      </TabList>
      <Main>
        {cardData.map(data => (
          <ProductCard size={''} data={data} key={data.id} />
        ))}
      </Main>
    </BestProductWrapper>
  );
};
