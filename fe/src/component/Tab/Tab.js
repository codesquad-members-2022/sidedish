import Card from "../UI/Card";
import CardsWrapper from "../UI/CardsWrapper";
import styled from "styled-components";
import React, { useEffect, useState, useContext } from "react";
import constansts from "../../constants/constansts";
import Modal from "../modal/Modal";
import { ModalContext } from "../../store/store";

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

const Tab = (props) => {
  const [cards, setCards] = useState([]);
  const [activeTab, setActiveTab] = useState(0);

  useEffect(() => {
    fetch(
      `${constansts.MAIN_API_URL + constansts.tapInforList[activeTab].postfix}`,
      {
        headers: {
          Origin: "http://15.165.204.34:8080/",
          mode: "no-cors",
          Accept: "application/json",
        },
      }
    )
      .then((res) => res.json())
      .then((cardData) => setCards(cardData.data));
  }, [activeTab]);

  const onClickHandler = ({ target }) => {
    setActiveTab(+target.id);
  };

  // const ctx = useContext(ModalContext);
  // console.log(ctx);
  // const [modalIsDisplayed, setModalIsDisplayed] = useState(false);
  // const [modalId, setModalId] = useState(1);
  // const [modalInfo, setModalInfo] = useState([]);

  // const cardClickHandler = (event) => {
  //   setModalIsDisplayed(true);
  //   setModalId(event.target.id);
  // };

  // useEffect(() => {
  //   fetch(`http://15.165.204.34:8080/api/v1/products/${modalId}/detail`)
  //     .then((res) => res.json())
  //     .then((data) => setModalInfo(data.data));
  // }, [modalId]);
  // const onCloseModalDisplay = () => {
  //   setModalIsDisplayed(false);
  // };

  return (
    <>
      {/* <Modal
        description={modalInfo.content}
        discountPrice={modalInfo.discountPrice}
        originPrice={modalInfo.price}
        title={modalInfo.name}
        isDisplayed={modalIsDisplayed}
        image={modalInfo.imgUrl}
        shipInfo={modalInfo.shippingInfo}
        onSaveCloseisClicked={onCloseModalDisplay}
      /> */}
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
