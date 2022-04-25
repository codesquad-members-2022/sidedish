import React from 'react';
import styled from 'styled-components';

import Button from '../components/Button';
import Card from '../components/Card';
import { slideBtn } from '../css/variables';

const CardContainer = ({ cardInfos, children, hasButton }) => {
  return (
    <StyledSection>
      {children}
      <StyledCardContainer hasBtn={hasButton}>
        {hasButton && <Button icon={'◀'} />}
        {cardInfos.map((cardInfo, idx) => (
          <StyledCard key={idx}>
            <Card cardInfo={cardInfo} length={cardInfos.length} />
          </StyledCard>
        ))}
        {hasButton && <Button icon={'▶'} />}
      </StyledCardContainer>
    </StyledSection>
  );
};

const StyledSection = styled.section`
  margin-top: 50px;
`;

const StyledCardContainer = styled.ul`
  display: flex;

  margin-left: ${(props) =>
    props.hasBtn ? 0 : slideBtn.size + slideBtn.margin}px;
`;

const StyledCard = styled.li`
  margin-right: 24px;
`;

export default CardContainer;
