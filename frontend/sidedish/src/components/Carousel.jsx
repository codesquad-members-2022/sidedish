import { useState } from "react";
import styled from "styled-components";
import LeftArrowBtn from "../core/LeftArrowBtn";
import RightArrowBtn from "../core/RightArrowBtn";
import ItemCards from "./ItemCards";

const Carousel = ({ carouselState, len }) => {
  const [positionState, setPositionState] = useState("-80");
  const handleClickLeftBtn = () => {
    setPositionState(Number(positionState) + 1475);
  };
  const handleClickRightBtn = () => {
    setPositionState(positionState - 1475);
  };
  return (
    <CarouselContainer>
      <LeftArrowBtnSpan onClick={handleClickLeftBtn}>
        <LeftArrowBtn />
      </LeftArrowBtnSpan>
      <RightArrowBtnSpan onClick={handleClickRightBtn}>
        <RightArrowBtn />
      </RightArrowBtnSpan>
      <CarouselView>
        <CarouselItems position={positionState}>
          <ItemCards dataState={[...carouselState.prev, ...carouselState.curr, ...carouselState.next]} len={len} />
        </CarouselItems>
      </CarouselView>
    </CarouselContainer>
  );
};

const CarouselContainer = styled.div`
  position: relative;
`;
const LeftArrowBtnSpan = styled.span`
  position: absolute;
  cursor: pointer;
  left: 30px;
  top: 150px;
  z-index: 1;
`;

const RightArrowBtnSpan = styled.span`
  position: absolute;
  cursor: pointer;
  left: 1545px;
  top: 150px;
  z-index: 1;
`;

const CarouselView = styled.div`
  overflow: hidden;
  margin-left: 80px;
  width: 1420px;
`;

const CarouselItems = styled.div`
  transform: translateX(${(props) => props.position}px);
  transition: 1s;
`;

export default Carousel;
