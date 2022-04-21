import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';

const Card = ({ cardInfo }) => {
  const { title, image } = cardInfo;

  return (
    <>
      <Img src={image} alt={title} />
      <Infos cardInfo={cardInfo} />
    </>
  );
};

const Img = styled.img`
  width: 411px;
  height: 411px;
`;

export default Card;
