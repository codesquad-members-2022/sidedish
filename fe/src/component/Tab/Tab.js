import Card from "../UI/Card";
import CardsWrapper from "../UI/CardsWrapper";
import styled from "styled-components";
import React, { useEffect, useState } from "react";
import constansts from "../../constants/constansts";

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
    fetch("http://15.165.204.34:8080/api/v1/products/반찬/영양", {
      headers: {
        Origin: "http://15.165.204.34:8080/",
        mode: "no-cors",
        // "Content-Type": "application/json",
        Accept: "application/json",
      },
    })
      .then((r) => r.json())
      .then((r) => console.log(r));

    console.log(1);
  }, []);

  // headers: {
  //   "Content-Type": "application/json",
  //   Accept: "application/json",
  // },

  const onClickHandler = ({ target }) => {
    setActiveTab(+target.id);
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
        <Card
          id={cards.detail_hash}
          key={cards.detail_hash}
          image={cards.image}
          alt={cards.alt}
          title={cards.title}
          description={cards.description}
          s_price={cards.s_price}
          n_price={cards.n_price}
          badge={cards.badge}
          delivery={cards.delivery_type}
        />
      </CardsWrapper>
    </>
  );
};

export default Tab;
