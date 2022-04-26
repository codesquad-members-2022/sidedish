import React, { useState } from 'react';
import styled from 'styled-components';
import Card from './Card';

function Event({ title, events, showModal }) {
  const [selectedTabIndex, setSelectedTapIndex] = useState(0);

  function selectTab(index) {
    setSelectedTapIndex(index);
  }
  return (
    <StyledEvent>
      <EventHeader>
        <EventBadge>기획전</EventBadge>
        <EventTitle>{title}</EventTitle>
      </EventHeader>
      <nav>
        <TabBar>
          {events.map(({ title }, index) => (
            <Tab
              key={index}
              selected={index === selectedTabIndex}
              onClick={() => {
                selectTab(index);
              }}
            >
              {title}
            </Tab>
          ))}
        </TabBar>
        <Line></Line>
      </nav>
      <CardList>
        {events[selectedTabIndex].items.map((item, index) => (
          <Card key={index} size={'large'} item={item} showModal={showModal}></Card>
        ))}
      </CardList>
    </StyledEvent>
  );
}

Event.defaultProps = {
  title: '둘이 먹다 하나가 죽어도 모르는 반찬',
  events: [
    {
      title: '풍성한 고기 반찬',
      items: [
        {
          id: 0,
          image:
            'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
          title: '고기반찬 1',
          contents: '스테이크 먹고싶다',
          origin_price: 50000,
          discount_price: 39800,
          early_delivery: true,
          badge_title: ['이벤트특가', '런칭특가'],
          categories: ['메인 요리'],
        },
        {
          id: 1,
          image:
            'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
          title: '고기반찬 2',
          contents: '스테이크 먹고싶다',
          origin_price: 50000,
          discount_price: 39800,
          early_delivery: true,
          badge_title: ['이벤트특가', '런칭특가'],
          categories: ['메인 요리'],
        },
        {
          id: 2,
          image:
            'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
          title: '고기반찬 3',
          contents: '스테이크 먹고싶다',
          origin_price: 50000,
          discount_price: 39800,
          early_delivery: true,
          badge_title: ['이벤트특가', '런칭특가'],
          categories: ['메인 요리'],
        },
      ],
    },
    {
      title: '편리한 반찬 세트',
      items: [
        {
          id: 0,
          image:
            'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
          title: '편리한 반찬 1',
          contents: '스테이크 먹고싶다',
          origin_price: 50000,
          discount_price: 39800,
          early_delivery: true,
          badge_title: ['이벤트특가', '런칭특가'],
          categories: ['메인 요리'],
        },
        {
          id: 1,
          image:
            'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
          title: '편리한 반찬 2',
          contents: '스테이크 먹고싶다',
          origin_price: 50000,
          discount_price: 39800,
          early_delivery: true,
          badge_title: ['이벤트특가', '런칭특가'],
          categories: ['메인 요리'],
        },
        {
          id: 2,
          image:
            'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
          title: '편리한 반찬 3',
          contents: '스테이크 먹고싶다',
          origin_price: 50000,
          discount_price: 39800,
          early_delivery: true,
          badge_title: ['이벤트특가', '런칭특가'],
          categories: ['메인 요리'],
        },
      ],
    },
    {
      title: '맛있는 제철 요리',
      items: [],
    },
    {
      title: '우리 아이 영양 반찬',
      items: [],
    },
  ],
  items: {
    '풍성한 고기 반찬': [],
    '편리한 반찬 세트': [],
    '맛있는 제철 요리': [],
    '우리 아이 영양 반찬': [],
  },
};

const StyledEvent = styled.div`
  margin: 32px 80px 0 80px;
`;
const EventHeader = styled.div`
  display: flex;
  align-items: center;
  margin: 24px 0;
`;
const EventBadge = styled.div`
  padding: 8px 16px;
  background: #f8f7f7;

  border: 2px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 999px;
`;
const EventTitle = styled.div`
  margin-left: 16px;
  font-weight: 700;
  font-size: 40px;
  line-height: 58px;
`;
const TabBar = styled.ul`
  display: flex;
`;
const Tab = styled.li`
  margin-right: 32px;
  ${props => (props.selected ? `border-bottom: 1px solid black;` : '')}
  padding-bottom: 17px;
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
`;
const Line = styled.div`
  position: absolute;
  left: 0;
  width: 100vw;
  height: 1px;

  background: #ebebeb;
`;
const CardList = styled.div`
  padding: 34px 0 56px 0;
  display: flex;
  justify-content: space-between;
`;

export default Event;
