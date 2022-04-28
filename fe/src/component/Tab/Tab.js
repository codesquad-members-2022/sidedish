import Card from "../UI/Card";
import CardsWrapper from "../UI/CardsWrapper";
import styled from "styled-components";
import React, { useEffect, useState } from "react";
import constansts from "../../constants/constansts";
import { myfetch } from "../../utils/utils";

const TabList = styled.ul`
  display: flex;
  margin: 20px 0 20px 40px;
`;

const TabListItem = styled.li`
  margin-right: 30px;
  font-size: ${({ theme }) => theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  cursor: pointer;
  &.active {
    border-bottom: 1px solid ${({ theme }) => theme.colors.black};
  }
`;

const Tab = () => {
  const [cards, setCards] = useState([]);
  const [activeTab, setActiveTab] = useState(0);

  useEffect(() => {
    myfetch(
      `${constansts.MAIN_API_URL + constansts.tapInforList[activeTab].postfix}`
    ).then((cardData) => setCards(cardData.data));
  }, [activeTab]);

  const onClickHandler = ({ target }) => {
    setActiveTab(Number(target.id));
  };

  return (
    <>
      <TabList>
        {constansts.tapInforList.map((v) => {
          return (
            <TabListItem
              id={v.id}
              key={v.id}
              className={v.id === activeTab ? "active" : ""}
              onClick={onClickHandler}
            >
              {v.title}
            </TabListItem>
          );
        })}
      </TabList>

      <CardsWrapper>
        {cards.map((v) => (
          <Card
            id={v.id}
            key={v.id}
            image={v.imgUrl}
            alt={v.name}
            title={v.name}
            description={v.content}
            discountPrice={v.discountPrice}
            originPrice={v.price}
            badge={v.applyEvent}
          />
        ))}
      </CardsWrapper>
    </>
  );
};

export default Tab;
