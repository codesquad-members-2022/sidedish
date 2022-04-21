import React from 'react';

import CardContainer from './container/CardContainer';
import CategoryTitle from './components/CategoryTitle';

const SubCard = ({ mainCardData }) => {
  const mainDatas = mainCardData.slice(0, 3);

  const title = '식탁을 풍성하게 하는 정갈한 밑반찬';

  return (
    <CardContainer cardInfos={mainDatas}>
      <CategoryTitle title={title} />
    </CardContainer>
  );
};

export default SubCard;
