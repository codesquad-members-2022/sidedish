import React from 'react';

import CardContainer from './container/CardContainer';
import CategoryTitle from './components/CategoryTitle';

const SubCard = ({ dishData, title }) => {
  const mainDatas = dishData.slice(0, 4);

  return (
    <CardContainer cardInfos={mainDatas} hasButton={true}>
      <CategoryTitle title={title} />
    </CardContainer>
  );
};

export default SubCard;
