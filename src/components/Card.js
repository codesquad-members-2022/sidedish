import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';
import { body, modal } from '../css/variables';

const Card = ({ cardInfo, showingSlideCardNum, isOpenModal }) => {
  const { title, image } = cardInfo;

  return (
    <>
      <Img
        src={image}
        alt={title}
        showingSlideCardNum={showingSlideCardNum}
        isOpenModal={isOpenModal}
      />
      <Infos cardInfo={cardInfo} />
    </>
  );
};

const Img = styled.img`
  width: ${({ showingSlideCardNum, isOpenModal }) =>
    isOpenModal
      ? Math.floor(modal.width / showingSlideCardNum) - modal.margin
      : Math.floor(body.width / showingSlideCardNum) - body.margin}px;
  height: ${({ showingSlideCardNum, isOpenModal }) =>
    isOpenModal
      ? Math.floor(modal.width / showingSlideCardNum) - modal.margin
      : Math.floor(body.width / showingSlideCardNum) - body.margin}px;
`;

export default Card;
