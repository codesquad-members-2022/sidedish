import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';
import { maxWidthBody } from '../css/variables';

const Card = ({ cardInfo, length }) => {
  const { title, image } = cardInfo;

  return (
    <>
      <Img src={image} alt={title} length={length} />
      <Infos cardInfo={cardInfo} />
    </>
  );
};

const Img = styled.img`
  width: ${(props) => maxWidthBody.width / props.length - 50}px;
  height: ${(props) => maxWidthBody.width / props.length - 50}px;
`;

export default Card;
