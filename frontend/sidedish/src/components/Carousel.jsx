import { useState } from "react";
import styled from "styled-components";
import LeftArrowBtn from "../core/LeftArrowBtn";
import RightArrowBtn from "../core/RightArrowBtn";
import ItemCards from "./ItemCards";

const Carousel = ({ cardClickState, setCardClickState, carouselCards, cardLength, cardCount, cardMargin }) => {
  const [positionState, setPositionState] = useState(-cardMargin);
  const carouselWidth = (+cardLength + cardMargin * 2) * cardCount;
  const currentPage = Math.abs(positionState + cardMargin) / carouselWidth;

  const calLengthToMove = (numOfRestCard) => {
    return numOfRestCard < cardCount ? (+cardLength + cardMargin * 2) * numOfRestCard : carouselWidth;
  };

  const handleClickLeftBtn = () => {
    if (positionState < -cardMargin) {
      const numOfRestCard = currentPage * cardCount;
      const lengthToMove = calLengthToMove(numOfRestCard);
      setPositionState(positionState + lengthToMove);
    }
  };

  const handleClickRightBtn = () => {
    if (positionState > -cardMargin - carouselCards.length * cardLength) {
      const numOfRestCard = carouselCards.length - (currentPage + 1) * cardCount;
      const lengthToMove = calLengthToMove(numOfRestCard);
      setPositionState(positionState - lengthToMove);
    }
  };

  return (
    <CarouselContainer>
      <LeftArrowBtnSpan onClick={handleClickLeftBtn}>
        <LeftArrowBtn isLast={currentPage === 0} />
      </LeftArrowBtnSpan>

      <CarouselView>
        <CarouselItems position={positionState}>
          <ItemCards
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            dataState={[...carouselCards]}
            cardLength={cardLength}
            cardMargin={cardMargin}
          />
        </CarouselItems>
      </CarouselView>

      <RightArrowBtnSpan onClick={handleClickRightBtn}>
        <RightArrowBtn isLast={(currentPage + 1) * cardCount === carouselCards.length} />
      </RightArrowBtnSpan>
    </CarouselContainer>
  );
};

const CarouselContainer = styled.div`
  display: flex;
  justify-content: left;
  align-items: center;
  padding-bottom: 24px;
`;

const LeftArrowBtnSpan = styled.span`
  margin: 29px;
`;

const RightArrowBtnSpan = styled.span`
  margin: 29px;
`;

const CarouselView = styled.div`
  overflow: hidden;
  width: 1424px;
  min-width: 1424px;
`;

const CarouselItems = styled.div`
  transform: translateX(${(props) => props.position}px);
  transition: 0.5s;
`;

export default Carousel;
