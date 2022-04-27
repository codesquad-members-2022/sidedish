import React from 'react';
import styled from 'styled-components';

import Card from './Card';

const CardBox = ({
  hasButton,
  cardNum,
  slidingSize,
  cardInfos,
  handleModal,
}) => {
  return (
    <StyledCardContainer
      hasBtn={hasButton}
      cardNum={cardNum}
      slidingSize={slidingSize}
    >
      {cardInfos.map((cardInfo, idx) => (
        <StyledCard key={idx} onClick={() => handleModal(cardInfo)}>
          <Card cardInfo={cardInfo} cardNum={cardNum} />
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
