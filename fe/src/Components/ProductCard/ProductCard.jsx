import { useContext } from 'react';
import styled, { css } from 'styled-components';

import { Colors, Fonts } from '@/Constants';

import { PriceTag } from './PriceTag';
import { ProductThumbnail } from './ProductThumbnail';

import { DiscountBadge } from '@/Components/Badge';
import { ModalContext } from '@/Components/OrderModal';

const ProductCardWrapper = styled.li`
  display: flex;
  flex-direction: column;
  cursor: pointer;

  &:not(:last-child) {
    margin-right: 24px;
  }

  ${({ size }) => {
    return size === 'md'
      ? css`
          .product-thumbnail {
            width: 302px;
            height: 302px;
          }
        `
      : size === 'sm'
      ? css`
          &:not(:last-child) {
            margin-right: 16px;
          }

          .product-thumbnail {
            width: 160px;
            height: 160px;
          }
        `
      : null;
  }};
`;

const Title = styled.span`
  display: block;
  margin-top: 12px;
  padding: 4px 0;
`;

const Description = styled.span`
  display: block;
  padding: 4px 0;
  color: ${Colors.GREY};
`;

const BadgeWrapper = styled.div`
  margin-top: 16px;
`;

const PriceWrapper = styled.div`
  display: flex;
  align-items: center;
`;

const PolicyBadge = ({ priceData: discountPolicy }) => {
  if (!discountPolicy) {
    return;
  }

  return (
    <BadgeWrapper>
      <DiscountBadge type={discountPolicy} />
    </BadgeWrapper>
  );
};

// TODO: dataset property 지우기
export const ProductCard = ({
  data: {
    id,
    title,
    description,
    price,
    quantity,
    accumulate,
    discountPolicy,
    discountRate,
    morningDelivery,
    images,
  },
  size,
}) => {
  const modalContext = ModalContext;

  const { setModalDisplay, setProductID, setTotalCost, productPrice } =
    useContext(modalContext);

  const onClickThumbnail = () => {
    setProductID(id);
    setModalDisplay(true);
    setTotalCost(productPrice);
  };
  const productImage = images[0];

  return (
    <ProductCardWrapper size={size} onClick={onClickThumbnail}>
      <ProductThumbnail
        imgUrl={productImage.url}
        morningDelivery={morningDelivery}
        onClickThumbnail={onClickThumbnail}
      />
      <Title className={Fonts.MD}>{title}</Title>
      <Description className={Fonts.SM}>{description}</Description>
      <PriceWrapper>
        <PriceTag
          priceData={{
            price,
            discountRate,
            discountPolicy,
          }}
        />
      </PriceWrapper>
      <PolicyBadge priceData={discountPolicy} />
    </ProductCardWrapper>
  );
};
