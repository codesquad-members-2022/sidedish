import React from 'react';
import styled from 'styled-components';

import Card from '../components/Card';

const CardContainer = ({ cardInfos, children }) => {
  return (
    <StyledSection>
      {children}
      <StyledCardContainer>
        {cardInfos.map((cardInfo, idx) => (
          <StyledCard key={idx}>
            <Card cardInfo={cardInfo} />
          </StyledCard>
        ))}
      </StyledCardContainer>
    </StyledSection>
  );
};

const StyledSection = styled.section`
  margin-top: 50px;
`;

const StyledCardContainer = styled.ul`
  display: flex;
`;

const StyledCard = styled.li`
  margin-right: 24px;
`;

export default CardContainer;
