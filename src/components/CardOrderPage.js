import React from 'react';

import Card from './Card';
import Order from './Order';
import ShoppingInfo from './ShoppingInfo';

const CardOrderPage = ({ selectedCardInfo }) => {
  const { image, title, price, discountedPrice, badge } = selectedCardInfo;
  const cardInfo = { image, title, price, discountedPrice, badge };

  const curPrice = discountedPrice ? discountedPrice : price;
  const str2NumPrice = Number(
    curPrice
      .slice(0, price.length - 1)
      .split(',')
      .join('')
  );
  return (
    <>
      <Card cardInfo={cardInfo} cardNum={3} isFlex={true} />;
      <ShoppingInfo price={str2NumPrice} />
      <Order price={str2NumPrice} />
    </>
  );
};

export default CardOrderPage;
