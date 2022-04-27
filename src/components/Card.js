import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';
import { maxWidthBody } from '../css/variables';

const Card = ({ cardInfo, cardNum, isFlex }) => {
  const { title, image } = cardInfo;

  return (
    <StyledDiv isFlex={isFlex}>
      <Img src={image} alt={title} cardNum={cardNum} />
      <Infos cardInfo={cardInfo} />
    </StyledDiv>
  );
};

const Img = styled.img`
  width: ${({ cardNum }) => Math.floor(maxWidthBody.width / cardNum) - 43}px;
  height: ${({ cardNum }) => Math.floor(maxWidthBody.width / cardNum) - 43}px;
`;

const StyledDiv = styled.div`
  display: ${({ isFlex }) => (isFlex ? 'flex' : '')};
`;

export default Card;
