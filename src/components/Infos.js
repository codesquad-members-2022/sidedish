import React from 'react';
import styled from 'styled-components';

const Infos = ({ cardInfo }) => {
  const { title, description, price, salesPrice, badge } = cardInfo;
  return (
    <StyledInfoContainer>
      <StyledInfo>{title}</StyledInfo>
      <StyledInfo>{description}</StyledInfo>
      <StyledInfo>{price}</StyledInfo>
      <StyledInfo>{salesPrice}</StyledInfo>
      {badge.map((specialBadge, idx) => (
        <StyledInfo key={idx}>{specialBadge}</StyledInfo>
      ))}
    </StyledInfoContainer>
  );
};

const StyledInfoContainer = styled.article``;

const StyledInfo = styled.span`
  display: block;
`;

export default Infos;
