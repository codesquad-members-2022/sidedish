import React from 'react';
import Exhibition from '../exhibition/Exhibition';
import Category from '../category/Category';
import { dish10 } from '../../data/dishes';
import { CARD_SIZE } from '../../constants/card';
import exhibitionData from '../../data/exhibition';

const Main = () => {
  return (
    <>
      <Exhibition {...exhibitionData} />
      <Category cardSize={CARD_SIZE.MEDIUM} {...dish10} />
    </>
  );
};

export default Main;
