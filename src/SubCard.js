import React from 'react';

import CardContainer from './container/CardContainer';
import CategoryTitle from './components/CategoryTitle';

const SubCard = ({ dishData, title, handleModal, isModalVisible }) => {
  const cardDataLen = dishData.length;
  const originalShowingCardNum = 4;
  const specialShowingCardNum = 3;
  const showingSlideCardNum =
    cardDataLen === specialShowingCardNum
      ? cardDataLen
      : originalShowingCardNum;

  return (
    <CardContainer
      cardInfos={dishData}
      hasButton={true}
      showingSlideCardNum={showingSlideCardNum}
      handleModal={handleModal}
      isModalVisible={isModalVisible}
    >
      <CategoryTitle title={title} />
    </CardContainer>
  );
};

export default React.memo(SubCard);
