import React from 'react';
import styled from 'styled-components';

import Card from './Card';

const CardBox = ({
  hasButton,
  showingSlideCardNum,
  slidingSize,
  cardInfos,
  handleModal,
}) => {
  return (
    <StyledCardContainer
      hasBtn={hasButton}
      showingSlideCardNum={showingSlideCardNum}
      slidingSize={slidingSize}
    >
      {cardInfos.map((cardInfo, idx) => (
        <StyledCard key={idx} onClick={() => handleModal(cardInfo)}>
          <Card cardInfo={cardInfo} showingSlideCardNum={showingSlideCardNum} />
        </StyledCard>
      ))}
    </StyledCardContainer>
  );
};

const StyledCardContainer = styled.ul`
  display: flex;
  transition: transform 1s linear 0s;
  transform: translateX(${({ slidingSize }) => slidingSize}%);
`;

const StyledCard = styled.li`
  margin-right: 24px;
`;

export default CardBox;
