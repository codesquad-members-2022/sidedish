import React from 'react';
import styled from 'styled-components';

import Infos from './Infos';
import { body, modal } from '../css/variables';

const Card = ({ cardInfo, showingSlideCardNum, isOpenModal }) => {
  const { title, image } = cardInfo;

  return (
    <Div showingSlideCardNum={showingSlideCardNum}>
      <Img
        src={image}
        alt={title}
        showingSlideCardNum={showingSlideCardNum}
        isOpenModal={isOpenModal}
      />
      <Infos cardInfo={cardInfo} />
    </Div>
  );
};

const Div = styled.div`
  width: ${({ showingSlideCardNum }) =>
    Math.floor(body.width / showingSlideCardNum) - body.margin}px;
`;

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

export default React.memo(Card);
