import React, { useState } from 'react';
import styled from 'styled-components';

import CardBox from '../components/CardBox';
import Slider from '../components/Slider';

const CardContainer = ({
  cardInfos,
  children,
  hasButton,
  showingSlideCardNum,
  handleModal,
  isModalVisible,
}) => {
  const [slidingSize, setSlidingSize] = useState(0);
  const [isMoving, setIsMoving] = useState(false);

  const handleTransitionEnd = () => {
    setIsMoving(false);
  };

  const handleClickSlide = (movingSlidingSize) => {
    setIsMoving(true);
    setSlidingSize(slidingSize + movingSlidingSize);
  };

  return (
    <StyledSection>
      {children}
      <Slider
        showingSlideCardNum={showingSlideCardNum}
        handleClickSlide={handleClickSlide}
        cardInfos={cardInfos}
        hasButton={hasButton}
        isModalVisible={isModalVisible}
        isMoving={isMoving}
      />
      <StyledDiv>
        <CardBox
          hasBtn={hasButton}
          showingSlideCardNum={showingSlideCardNum}
          slidingSize={slidingSize}
          cardInfos={cardInfos}
          handleModal={handleModal}
          isModalVisible={isModalVisible}
          handleTransitionEnd={handleTransitionEnd}
        />
      </StyledDiv>
    </StyledSection>
  );
};

const StyledDiv = styled.div`
  margin: 0 40px;
  overflow: hidden;
`;

const StyledSection = styled.section`
  margin-top: 50px;
  position: relative;
`;

export default React.memo(CardContainer);
