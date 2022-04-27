import React from 'react';
import styled from 'styled-components';

const Infos = ({ cardInfo }) => {
  const { title, price, discountedPrice, badge } = cardInfo;
  return (
    <StyledInfoContainer>
      <StyledInfo>{title}</StyledInfo>
      <StyledInfo>{cardInfo?.description}</StyledInfo>
      <StyledInfo>{price}</StyledInfo>
      {discountedPrice && <StyledInfo>{discountedPrice}</StyledInfo>}
      {badge &&
        badge.map((specialBadge, idx) => (
          <StyledInfo key={`${specialBadge}-${idx}`}>{specialBadge}</StyledInfo>
        ))}
    </StyledInfoContainer>
  );
};

const StyledInfoContainer = styled.article``;

const StyledInfo = styled.span`
  display: block;
`;

export default Infos;
