import React from 'react';
import styled from 'styled-components';
import { basicText } from '../css/mixins';

import { color, fontSize } from '../css/variables';

const Infos = ({ cardInfo }) => {
  const { title, price, discountedPrice, badge } = cardInfo;
  return (
    <StyledInfoContainer>
      <InfoTitle>{title}</InfoTitle>
      <InfoDescription>{cardInfo?.description}</InfoDescription>
      {discountedPrice && (
        <InfoDiscountedPrice>{discountedPrice}</InfoDiscountedPrice>
      )}
      <InfoPrice>{price}</InfoPrice>
      <StyledBadge>
        {cardInfo?.badge &&
          badge.map((specialBadge, idx) => (
            <InfoBadge
              key={`${specialBadge}-${idx}`}
              specialBadge={specialBadge}
            >
              {specialBadge}
            </InfoBadge>
          ))}
      </StyledBadge>
    </StyledInfoContainer>
  );
};

const StyledInfoContainer = styled.article``;

const InfoTitle = styled.span`
  ${basicText}
  font-weight: bold;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

const InfoDescription = styled.span`
  ${basicText}
  margin-bottom: 10px;
  color: ${color.greyTwo};
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

const InfoPrice = styled.span`
  font-size: ${fontSize.l};
  color: ${color.greyThree};
  text-decoration: line-through;
`;

const InfoDiscountedPrice = styled.span`
  font-size: ${fontSize.l};
  font-weight: bold;
  margin-right: 5px;
`;

const StyledBadge = styled.div`
  display: flex;
  margin-top: 10px;
`;

const InfoBadge = styled.span`
  margin-right: 5px;
  background-color: ${({ specialBadge }) =>
    specialBadge === '이벤트특가' ? color.green : color.orange};
  color: ${color.white};
  padding: 10px;
  font-size: ${fontSize.s};
  border-radius: 10px;
`;
export default React.memo(Infos);
