import { useState, useRef, useEffect } from "react";
import styled from "styled-components";
import CardList from "./CardList.js";

const useFirstRender = () => {
  const firstRender = useRef(true);

  useEffect(() => {
    firstRender.current = false;
  }, []);

  return firstRender.current;
};

const Slider = ({ data, key, cardSize, numOfCards, gap }) => {
  const CARD_SIZE = cardSize.replace(/[a-zA-Z]/g, "") * 10;
  const GAP = gap.replace(/[a-zA-Z]/g, "") * 10;

  const SLIDER_INFO = {
    NUM_OF_PAGE: Math.ceil(data.length / numOfCards),
    CARDLIST_WIDTH: CARD_SIZE * data.length + GAP * (data.length - 1),
    SLIDER_WIDTH: CARD_SIZE * numOfCards + GAP * (numOfCards - 1),
    LAST_PAGE_WIDTH:
      CARD_SIZE * (data.length % numOfCards) +
      GAP * ((data.length % numOfCards) - 1),
  };

  const BASE_MOVE_DISTANCE = SLIDER_INFO.SLIDER_WIDTH + GAP;
  const LAST_MOVE_DISTANCE = SLIDER_INFO.LAST_PAGE_WIDTH + GAP;

  const isFirstRender = useFirstRender();
  const cardList = useRef();
  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    if (!isFirstRender) {
      if (
        currentPage === SLIDER_INFO.NUM_OF_PAGE &&
        !(data.length % numOfCards === 0)
      ) {
        const moveDistance =
          BASE_MOVE_DISTANCE * (currentPage - 2) + LAST_MOVE_DISTANCE;
        cardList.current.style.marginLeft = `-${moveDistance}px`;
      } else {
        const moveDistance = BASE_MOVE_DISTANCE * (currentPage - 1);
        cardList.current.style.marginLeft = `-${moveDistance}px`;
      }
    }
  }, [currentPage]);

  const handleRArrowClick = () => {
    if (currentPage === SLIDER_INFO.NUM_OF_PAGE) return;
    setCurrentPage(currentPage + 1);
  };

  const handleLArrowClick = () => {
    if (currentPage === 1) return;
    setCurrentPage(currentPage - 1);
  };

  return (
    <>
      <LeftArrow
        img={`${process.env.PUBLIC_URL}/images/Arrow.svg`}
        onClick={handleLArrowClick}
      />
      <RightArrow
        img={`${process.env.PUBLIC_URL}/images/Arrow.svg`}
        onClick={handleRArrowClick}
      />
      <Wrapper>
        <CardList
          innerRef={cardList}
          key={key}
          cards={data}
          cardSize={cardSize}
          numOfCards={4}
          gap={gap}
        />
      </Wrapper>
    </>
  );
};

const Wrapper = styled.div`
  width: calc(144rem - 8rem * 2);
  margin: 0 auto;
  overflow: hidden;
`;

const Arrow = styled.button`
  position: absolute;
  width: 1.1rem;
  height: 2rem;
  top: 50%;
  background-image: url(${({ img }) => img});
  background-size: 1.1rem 2rem;
  background-repeat: no-repeat;
  border: none;
  outline: none;
  cursor: pointer;
`;

const LeftArrow = styled(Arrow)`
  left: 3.6rem;
`;

const RightArrow = styled(Arrow)`
  right: 3.6rem;
  transform: scaleX(-1);
`;

export default Slider;
