import React from 'react';
import styled from 'styled-components';

const Infos = ({ cardInfo }) => {
  const { title, description, price, discountedPrice, badge } = cardInfo;

  return (
    <StyledInfoContainer>
      {title && <StyledInfo>{title}</StyledInfo>}
      {description && <StyledInfo>{description}</StyledInfo>}
      {price && <StyledInfo>{price}</StyledInfo>}
      {discountedPrice && <StyledInfo>{discountedPrice}</StyledInfo>}
      {badge &&
        badge.map((specialBadge, idx) => (
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
