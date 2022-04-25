import Card from "../UI/Card";
import CardsWrapper from "../UI/CardsWrapper";
import styled from "styled-components";
import React, { useEffect, useState } from "react";
import tapInforList from "../../constants/TapInforList";

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
  const [activeTab, setActiveTab] = useState(1);

  useEffect(() => {
    fetch("https://api.codesquad.kr/onban/main")
      .then((res) => res.json())
      .then((data) => setCards(data.body[activeTab]));
  }, [activeTab]);

  const onClickHandler = ({ target }) => {
    setActiveTab(+target.id);
  };

  return (
    <>
      <TabList>
        {tapInforList.map((v) => {
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
        <Card
          key={cards.detail_hash}
          image={cards.image}
          alt={cards.alt}
          title={cards.title}
          description={cards.description}
          s_price={cards.s_price}
          n_price={cards.n_price}
          badge={cards.badge}
        />
      </CardsWrapper>
    </>
  );
};

export default Tab;
