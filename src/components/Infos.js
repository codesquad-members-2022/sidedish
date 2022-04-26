import React from 'react';
import styled from 'styled-components';
import PropTypes from 'prop-types';

const Infos = ({ cardInfo }) => {
  const { title, description, price, discountedPrice, badge } = cardInfo;
  return (
    <StyledInfoContainer>
      <StyledInfo>{title}</StyledInfo>
      <StyledInfo>{description}</StyledInfo>
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
