import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';
import { maxWidthBody } from '../css/variables';

const Card = ({ cardInfo, showingSlideCardNum }) => {
  const { title, image } = cardInfo;

  return (
    <>
      <Img src={image} alt={title} showingSlideCardNum={showingSlideCardNum} />
      <Infos cardInfo={cardInfo} />
    </>
  );
};

const Img = styled.img`
  width: ${({ showingSlideCardNum }) =>
    Math.floor(maxWidthBody.width / showingSlideCardNum) - 43}px;
  height: ${({ showingSlideCardNum }) =>
    Math.floor(maxWidthBody.width / showingSlideCardNum) - 43}px;
`;

export default Card;
