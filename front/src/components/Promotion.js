import React, { useState } from 'react';
import styled from 'styled-components';
import Card from './Card';

function Promotion({ title, promotions, showModal }) {
  const [selectedTabIndex, setSelectedTapIndex] = useState(0);
  function selectTab(index) {
    setSelectedTapIndex(index);
  }
  function getRandomItems(array, num) {
    const randomIndexes = [];
    while (randomIndexes.length < num) {
      const randomIndex = Math.floor(Math.random() * num);
      if (!randomIndexes.includes(randomIndex)) {
        randomIndexes.push(randomIndex);
      }
    }
    return randomIndexes.map(index => array[index]);
  }
  return (
    <StyledPromotion>
      <PromotionHeader>
        <PromotionBadge>기획전</PromotionBadge>
        <PromotionTitle>{title}</PromotionTitle>
      </PromotionHeader>
      <nav>
        <TabBar>
          {promotions.map(({ title, id }, index) => (
            <Tab
              key={id}
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
        {getRandomItems(promotions[selectedTabIndex].items, 3).map((item, index) => (
          <Card key={index} size={'large'} item={item} showModal={showModal}></Card>
        ))}
      </CardList>
    </StyledPromotion>
  );
}

const StyledPromotion = styled.div`
  margin: 32px 80px 0 80px;
`;
const PromotionHeader = styled.div`
  display: flex;
  align-items: center;
  margin: 24px 0;
`;
const PromotionBadge = styled.div`
  padding: 8px 16px;
  background: ${({ theme }) => theme.colors.offWhite};

  border: 2px solid ${({ theme }) => theme.colors.black};
  box-sizing: border-box;
  border-radius: 999px;
`;
const PromotionTitle = styled.div`
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
  ${({ theme, selected }) => selected && `border-bottom: 1px solid ${theme.colors.black};`}
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

  background: ${({ theme }) => theme.colors.gray4};
`;
const CardList = styled.div`
  padding: 34px 0 56px 0;
  display: flex;
  justify-content: space-between;
`;

export default Promotion;
