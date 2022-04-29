import Modal from 'components/Modal/Modal';
import React, { useState } from 'react';
import Badge from './Badge';
import { CardWrapper, SubTitle, Title, PriceBox, NormalPrice, SalePrice, DescriptionWrapper } from './Card.style';
import Thumbnail from './Thumbnail';
import { discountRate } from 'constants/productInfo';

const Card = ({ data, size, mouseEvent }) => {
  const [modalVisible, setModalVisible] = useState(false);

  const openModal = () => {
    setModalVisible(true);
  };

  const closeModal = () => {
    setModalVisible(false);
  };

  return (
    <>
      <CardWrapper onClick={openModal}>
        <Thumbnail src={data.thumbnail || data.images[0]?.imagePath} size={size} mouseEvent={mouseEvent} />
        <DescriptionWrapper>
          <Title size={size}>{data.name}</Title>
          {size !== 'small' && <SubTitle>{data.description}</SubTitle>}
          <PriceBox>
            <NormalPrice size={size}>
              {Math.floor(data.price * discountRate[data.badge]).toLocaleString('ko-KR')}원
            </NormalPrice>
            <SalePrice>{data.price.toLocaleString('ko-KR')}원</SalePrice>
          </PriceBox>
        </DescriptionWrapper>
        {size !== 'small' && data.badge !== 'NONE' && <Badge type={data.badge} />}
      </CardWrapper>
      {modalVisible && <Modal visible={modalVisible} onClose={closeModal} dataId={data.dishId} />}
    </>
  );
};

export default Card;
