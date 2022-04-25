import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';
import { maxWidthBody } from '../css/variables';

const Card = ({ cardInfo, cardNum }) => {
  const { title, image } = cardInfo;

  return (
    <>
      <Img src={image} alt={title} cardNum={cardNum} />
      <Infos cardInfo={cardInfo} />
    </>
  );
};

const Img = styled.img`
  width: ${({ cardNum }) => Math.floor(maxWidthBody.width / cardNum) - 43}px;
  height: ${({ cardNum }) => Math.floor(maxWidthBody.width / cardNum) - 43}px;
`;

export default Card;
