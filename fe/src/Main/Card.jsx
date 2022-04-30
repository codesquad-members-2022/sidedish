import React, { useState } from 'react';
import styled, { css } from 'styled-components';
import { SERVER_URL } from 'constant.js';
import CardDeliveryInfo from 'Main/CardDeliveryInfo';
import Modal from 'Modal';
import { setPrice } from 'util';
import { useFetch } from 'useFetch';
import CardModal from './CardModal';

const CardItem = styled.div`
  ${({ imageSize }) => {
    switch (imageSize) {
      case 'small':
        return `margin-right: 16px;`;
      default:
        return 'margin-right: 24px;';
    }
  }}
`;

const CardImgWrapper = styled.div`
  position: relative;
`;

const CardItemImg = styled.img`
  background: ${({ theme }) => theme.colors.gray3};
  cursor: pointer;

  ${({ imageSize }) => {
    switch (imageSize) {
      case 'large':
        return css`
          ${({ theme }) => theme.cardSize.large}
        `;
      case 'medium':
        return css`
          ${({ theme }) => theme.cardSize.medium}
        `;
      case 'small':
        return css`
          ${({ theme }) => theme.cardSize.small}
        `;
      default:
        return;
    }
  }}
`;

const CardItemInfo = styled.div`
  margin: 16px 0;
  .item__title {
    margin-bottom: 8px;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.mediumBold};
  }

  .item__desc {
    margin-bottom: 8px;
    color: ${({ theme }) => theme.colors.gray2};
    ${({ theme }) => theme.fontStyles.smallRegular};
  }

  .item__default-price {
    margin-right: 8px;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.mediumBold};
  }

  .item__normal-price {
    text-decoration-line: line-through;
    color: ${({ theme }) => theme.colors.gray3};
    ${({ theme }) => theme.fontStyles.smallRegular};
  }
`;

const CardItemTag = styled.p`
  display: inline-block;
  padding: 6px 16px;
  border-radius: 999px;
  color: ${({ theme }) => theme.colors.white};
  background: ${(props) => {
    switch (props.tag) {
      case '런칭특가':
        return css`
          ${({ theme }) => theme.colors.orange}
        `;
      case '이벤트특가':
        return css`
          ${({ theme }) => theme.colors.green}
        `;
      case '정가':
        return css`
          ${({ theme }) => theme.colors.black}
        `;
      default:
        return;
    }
  }};
  ${({ theme }) => theme.fontStyles.smallBold};
`;

const Card = ({ item, imageSize }) => {
  const [hover, setHover] = useState(false);
  const [dishes, setDishes] = useState([]);
  const [dish] = useFetch(`${SERVER_URL}dishes/${item.id}`);

  const onMouseOver = () => setHover(true);

  const onMouseOut = () => setHover(false);

  const [modalVisible, setModalVisible] = useState(false);

  const openModal = (imageSize) => {
    if (imageSize === 'small') return;
    setModalVisible(true);
    setDishes(dish);
  };

  const closeModal = () => {
    setModalVisible(false);
  };

  return (
    item && (
      <CardItem imageSize={imageSize}>
        {modalVisible && (
          <>
            <Modal visible={modalVisible} closable={true} maskClosable={true} onClose={closeModal}>
              <CardModal item={dishes}></CardModal>
            </Modal>
          </>
        )}
        <CardImgWrapper onMouseOver={onMouseOver} onMouseOut={onMouseOut}>
          <CardItemImg
            onClick={() => openModal(imageSize)}
            key={item.id}
            src={item.image}
            imageSize={imageSize}
          ></CardItemImg>
          {imageSize !== 'small' && (
            <CardDeliveryInfo infos={item.deliveryType} hover={hover}></CardDeliveryInfo>
          )}
        </CardImgWrapper>
        <CardItemInfo>
          <p className="item__title">{item.name}</p>
          <p className="item__desc">{item.description}</p>
          {item.discountPrice !== item.normalPrice ? (
            <>
              <span className="item__default-price">{setPrice(item.discountPrice)}원</span>
              <span className="item__normal-price">{setPrice(item.normalPrice)}원</span>
            </>
          ) : (
            <span className="item__default-price">{setPrice(item.normalPrice)}원</span>
          )}
        </CardItemInfo>
        {item.discountPolicy && imageSize !== 'small' && (
          <CardItemTag tag={item.discountPolicy}>{item.discountPolicy}</CardItemTag>
        )}
      </CardItem>
    )
  );
};

export default React.memo(Card);
