import React from 'react';
import styled from 'styled-components';

import Card from '../components/Card';

// Todo : tab이나 카테고리 제목 태그를 children으로 받기
const CardContainer = ({ cardInfos, children }) => {
  return (
    <>
      {children}
      <StyledCardContainer>
        {cardInfos.map((cardInfo, idx) => (
          <StyledCard key={idx}>
            <Card cardInfo={cardInfo} />
          </StyledCard>
        ))}
      </StyledCardContainer>
    </>
  );
};

const StyledCardContainer = styled.ul`
  display: flex;
`;

const StyledCard = styled.li`
  margin-right: 24px;
`;

export default CardContainer;
