import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';
import { maxWidthBody } from '../css/variables';

const Card = ({ cardInfo, showingSlideCardNum, isFlex }) => {
  const { title, image } = cardInfo;

  return (
    <StyledDiv isFlex={isFlex}>
      <Img src={image} alt={title} showingSlideCardNum={showingSlideCardNum} />
      <Infos cardInfo={cardInfo} />
    </StyledDiv>
  );
};

const Img = styled.img`
  width: ${({ showingSlideCardNum }) =>
    Math.floor(maxWidthBody.width / showingSlideCardNum) - 43}px;
  height: ${({ showingSlideCardNum }) =>
    Math.floor(maxWidthBody.width / showingSlideCardNum) - 43}px;
`;

const StyledDiv = styled.div`
  display: ${({ isFlex }) => (isFlex ? 'flex' : '')};
`;

export default Card;
