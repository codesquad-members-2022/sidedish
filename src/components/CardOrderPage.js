import React, { useState } from 'react';

import Card from './Card';
import Order from './Order';
import ShoppingInfo from './ShoppingInfo';
import Button from './Button';

const CardOrderPage = ({ selectedCardInfo, onClick }) => {
  const { image, title, price, discountedPrice, badge } = selectedCardInfo;
  const cardInfo = { image, title, price, discountedPrice, badge };
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
      .slice(0, price.length - 1)
      .split(',')
      .join('')
  );

  return (
    <>
      <Button icon={'닫기'} onClick={onClick}></Button>
      <Card cardInfo={cardInfo} showingSlideCardNum={3} isFlex={true} />
      <ShoppingInfo price={str2NumPrice} orderNum={orderNum} />
      <Order
        price={str2NumPrice}
        orderNum={orderNum}
        title={title}
        handleClickDecreaseQuantity={handleClickDecreaseQuantity}
        handleClickIncreaseQuantity={handleClickIncreaseQuantity}
        closeModal={onClick}
      />
    </>
  );
};

export default CardOrderPage;
