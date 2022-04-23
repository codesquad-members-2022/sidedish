import List from "./List";
import Card from "../UI/Card";
import CardsWrapper from "../UI/CardsWrapper";
import styled from "styled-components";
import React, { useEffect, useState } from "react";

const TabList = styled.ul`
  display: flex;
  margin: 20px 0 20px 40px;
`;

const TabListItem = styled.li`
  margin-right: 30px;
  font-size: 20px;
  font-weight: 500;
  cursor: pointer;
  &.active {
    border-bottom: 1px solid #000;
  }
`;

const Tab = () => {
  const [infor, setInfor] = useState([
    { id: 1, title: "풍성한 고기반찬" },
    { id: 2, title: "편리한 반찬세트" },
    { id: 3, title: "맛있는 제철요리" },
    { id: 4, title: "우리 아이 영향 반찬" },
  ]);

  const [cards, setCards] = useState([]);
  const [activeTab, setActiveTab] = useState(1);

  useEffect(() => {
    setActiveTab("1");
  }, []);

  useEffect(() => {
    fetch("https://api.codesquad.kr/onban/main")
      .then((res) => res.json())
      .then((data) => setCards(data.body[activeTab]));
  }, [activeTab]);

  const onClickHandler = (event) => {
    setActiveTab(event.target.id);
  };

  return (
    <>
      <TabList>
        {infor.map((v) => {
          return (
            <TabListItem
              id={v.id}
              key={v.id}
              className={v.id.toString() === activeTab ? "active" : ""}
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
