import React from 'react';

import CardContainer from './container/CardContainer';

const MainCard = ({ mainCardData }) => {
  const mainDatas = mainCardData.slice(0, 3);
  return <CardContainer cardInfos={mainDatas}></CardContainer>;
};

export default MainCard;
