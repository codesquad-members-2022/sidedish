import { useState } from "react";
import styled from "styled-components";
import PopupImageContents from "./PopupImageContents";
import PopupOrderContents from "./PopupOrderContents";

const PopupDetail = ({ cardClickState, setCardClickState, cardInfoState }) => {
  const [wantedNumber, setWantedNumber] = useState(1);
  const closePopup = () => {
    setCardClickState(!cardClickState);
    setWantedNumber(1);
  };

  const findMaxDiscount = (eventBadgeArr) => {
    return eventBadgeArr.length
      ? (100 - Math.max(...eventBadgeArr.map(({ discount }) => discount))) / 100
      : 1;
  };

  return (
    <>
      <Contents>
        <CloseButton onClick={closePopup}>닫기</CloseButton>
        <ContentsDetailContainer>
          <PopupImageContents
            images={cardInfoState.images.map(({ url }) => url)}
          ></PopupImageContents>
          <PopupOrderContents
            deliveryArea={cardInfoState.deliveryArea}
            deliveryMorning={cardInfoState.deliveryMorning}
            deliveryPrice={cardInfoState.deliveryPrice}
            title={cardInfoState.title}
            normalPrice={cardInfoState.eventBadge.length ? cardInfoState.price : null}
            salePrice={cardInfoState.price * findMaxDiscount(cardInfoState.eventBadge)}
            badge={cardInfoState.eventBadge.map(({ eventName }) => eventName)}
            point={cardInfoState.point}
            stockQuantity={cardInfoState.stockQuantity}
            wantedNumber={wantedNumber}
            setWantedNumber={setWantedNumber}
          />
        </ContentsDetailContainer>
      </Contents>
    </>
  );
};

const Contents = styled.div`
  box-sizing: border-box;
  height: 596px;
  padding: 32px 48px;
  border-bottom: 1px solid #777;
`;

const CloseButton = styled.div`
  text-align: right;
  color: #777777;
  padding-bottom: 18px;
  cursor: pointer;
`;

const ContentsDetailContainer = styled.div`
  display: flex;
`;

export default PopupDetail;
