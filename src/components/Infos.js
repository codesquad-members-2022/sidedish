import React from 'react';
import styled from 'styled-components';

import { fontSize } from '../css/variables';

const Infos = ({ cardInfo }) => {
  const { title, price, discountedPrice, badge } = cardInfo;
  return (
    <StyledInfoContainer>
      <StyledInfo>{title}</StyledInfo>
      <StyledInfo>{cardInfo?.description}</StyledInfo>
      <StyledInfo hasDiscountedPrice={discountedPrice}>{price}</StyledInfo>
      {discountedPrice && <StyledInfo>{discountedPrice}</StyledInfo>}
      {cardInfo?.badge &&
        badge.map((specialBadge, idx) => (
          <StyledInfo key={`${specialBadge}-${idx}`}>{specialBadge}</StyledInfo>
        ))}
    </StyledInfoContainer>
  );
};

const StyledInfoContainer = styled.article``;

const StyledInfo = styled.span`
  display: block;
  margin-top: 10px;
  font-size: ${fontSize.l};
`;

export default Infos;
