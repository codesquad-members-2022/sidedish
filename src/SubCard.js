import React from 'react';

import CardContainer from './container/CardContainer';
import CategoryTitle from './components/CategoryTitle';

const SubCard = ({ dishData, title }) => {
  const mainDatas = dishData.slice(0, 9);
  const cardDataLen = dishData.length;
  const cardNum = 2 < cardDataLen && cardDataLen < 4 ? cardDataLen : 4;

  return (
    <CardContainer cardInfos={mainDatas} hasButton={true} cardNum={cardNum}>
      <CategoryTitle title={title} />
    </CardContainer>
  );
};

export default SubCard;
