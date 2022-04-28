import React, { useState } from 'react';
import Badge from './Badge';
import {
  CardWrapper,
  SubTitle,
  Title,
  Thumbnail,
  PriceBox,
  SalePrice,
  DescriptionWrapper,
  DeliveryIcon,
} from './Card.style';

const Card = ({ data, size }) => {
  const [isMouseEnter, setIsMouseEnter] = useState(false);

  const handleThumbnailMouseEnter = () => {
    setIsMouseEnter(true);
  };

  const handleThumbnailMouseLeave = () => {
    setIsMouseEnter(false);
  };

  return (
    <>
      <CardWrapper>
        <Thumbnail
          src={data.thumbnail || data.thumb_images[0]}
          size={size}
          onMouseEnter={handleThumbnailMouseEnter}
          onMouseLeave={handleThumbnailMouseLeave}
        >
          {isMouseEnter && <DeliveryIcon />}
        </Thumbnail>
        <DescriptionWrapper>
          <Title size={size}>{data.name}</Title>
          {size !== 'small' && <SubTitle>{data.description}</SubTitle>}
          <PriceBox>
            <Title>{data.price.toLocaleString('ko-KR')}원</Title>
            <SalePrice>{(data.price * 0.9).toLocaleString('ko-KR')}원</SalePrice>
          </PriceBox>
        </DescriptionWrapper>
        {size !== 'small' && data.badge !== 'NONE' && <Badge type={data.badge} />}
      </CardWrapper>
    </>
  );
};

export default Card;
