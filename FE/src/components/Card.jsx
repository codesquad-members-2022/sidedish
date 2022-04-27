import React from 'react';
import { CardWrapper, SubTitle, Title, Thumbnail, PriceBox, SalePrice, Badge, DescriptionWrapper } from './Card.syle';

const Card = ({ data }) => {
  return (
    <CardWrapper>
      <Thumbnail src={data.thumbnail} />
      <DescriptionWrapper>
        <Title>{data.name}</Title>
        <SubTitle>{data.description}</SubTitle>
        <PriceBox>
          <Title>{data.normalPrice.toLocaleString('ko-KR')}원</Title>
          <SalePrice>{data.salePrice.toLocaleString('ko-KR')}원</SalePrice>
        </PriceBox>
      </DescriptionWrapper>
      <Badge>런칭특가</Badge>
    </CardWrapper>
  );
};

export default Card;
