import { useState } from "react";
import styled from "styled-components";
import LeftArrowBtn from "../core/LeftArrowBtn";
import RightArrowBtn from "../core/RightArrowBtn";
import ItemCards from "./ItemCards";

const Carousel = ({
  cardClickState,
  setCardClickState,
  carouselCards,
  cardLength,
  cardCount,
  cardPadding,
}) => {
  const [positionState, setPositionState] = useState(-cardPadding);
  const carouselWidth = (+cardLength + cardPadding * 2) * cardCount;
  let currentPage = Math.abs(positionState + cardPadding) / carouselWidth;

  function calLengthToMove(numOfLeftCard) {
    return numOfLeftCard < cardCount
      ? (+cardLength + cardPadding * 2) * numOfLeftCard
      : carouselWidth;
  }

  const handleClickLeftBtn = () => {
    if (positionState >= -cardPadding) return;
    const numOfLeftCard = currentPage * cardCount;
    const lengthToMove = calLengthToMove(numOfLeftCard);
    setPositionState(positionState + lengthToMove);
  };

  const handleClickRightBtn = () => {
    if (positionState <= -cardPadding - carouselCards.length * cardLength) return;
    const numOfLeftCard = carouselCards.length - (currentPage + 1) * cardCount;
    const lengthToMove = calLengthToMove(numOfLeftCard);
    setPositionState(positionState - lengthToMove);
  };

  return (
    <CarouselContainer>
      <LeftArrowBtnSpan onClick={handleClickLeftBtn}>
        <LeftArrowBtn />
      </LeftArrowBtnSpan>

      <CarouselView>
        <CarouselItems position={positionState}>
          <ItemCards
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            dataState={[...carouselCards]}
            cardLength={cardLength}
            cardPadding={cardPadding}
          />
        </CarouselItems>
      </CarouselView>

      <RightArrowBtnSpan onClick={handleClickRightBtn}>
        <RightArrowBtn />
      </RightArrowBtnSpan>
    </CarouselContainer>
  );
};

const CarouselContainer = styled.div`
  display: flex;
  justify-content: left;
  align-items: center;
`;

const LeftArrowBtnSpan = styled.span`
  cursor: pointer;
  margin: 29px;
`;

const RightArrowBtnSpan = styled.span`
  cursor: pointer;
  margin: 29px;
`;

const CarouselView = styled.div`
  overflow: hidden;
  width: 1424px;
`;

const CarouselItems = styled.div`
  transform: translateX(${(props) => props.position}px);
  transition: 0.5s;
`;

export default Carousel;
