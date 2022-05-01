import React, { useState } from 'react';
import styled from 'styled-components';

import Button from './Button';
import CardContainer from '../container/CardContainer';
import CategoryTitle from './CategoryTitle';
import ModalInfo from './ModalInfo';
import { flexCenter } from '../css/mixins';
import { color } from '../css/variables';

const CardOrderPage = ({
  selectedCardInfo,
  onClick,
  cardInfos,
  slideTitle,
  isModalVisible,
}) => {
  const { image, title, price, discountedPrice, badge } = selectedCardInfo;
  const cardInfo = { image, title, price, discountedPrice, badge };
  const advertiseCardInfo = cardInfos.map(
    ({ image, title, price, discountedPrice }) => {
      return { image, title, price, discountedPrice };
    }
  );
  const [orderNum, setOrderNum] = useState(1);

  const handleClickDecreaseQuantity = () => {
    setOrderNum(orderNum === 1 ? 1 : orderNum - 1);
  };

  const handleClickIncreaseQuantity = () => {
    setOrderNum(orderNum + 1);
  };

  const curPrice = discountedPrice ? discountedPrice : price;
  const str2NumPrice = Number(
    curPrice
      .slice(0, curPrice.length - 1)
      .split(',')
      .join('')
  );

  return (
    <>
      <CloseButton icon={'닫기'} onClick={onClick}></CloseButton>
      <ModalContainer>
        <StyledImg src={image} alt={title} />
        <ModalInfo
          cardInfo={cardInfo}
          price={str2NumPrice}
          orderNum={orderNum}
          title={title}
          handleClickDecreaseQuantity={handleClickDecreaseQuantity}
          handleClickIncreaseQuantity={handleClickIncreaseQuantity}
          closeModal={onClick}
        />
      </ModalContainer>
      {/* error 발생 */}
      <CardContainer
        cardInfos={advertiseCardInfo}
        hasButton={true}
        showingSlideCardNum={5}
        isModalVisible={isModalVisible}
      >
        <CategoryTitle title={slideTitle} />
      </CardContainer>
    </>
  );
};

const CloseButton = styled(Button)`
  padding: 10px;
  font-size: 16px;
  border: 1px solid ${color.black};
  border-radius: 5px;
  position: absolute;
  top: 10px;
  right: 10px;
`;

const ModalContainer = styled.div`
  ${flexCenter}
  margin-top: 43px;
`;

const StyledImg = styled.img`
  width: 440px;
  height: 440px;
`;

export default CardOrderPage;
