import styled, { css } from 'styled-components';

import { PriceTag } from './PriceTag';
import { ProductThumbNail } from './Thumbnail';

import { DiscountBadge } from '@/Components/Badge/DiscountBadge';
import Colors from '@/Constants/Colors';
import Fonts from '@/Constants/Fonts';

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

export const ProductCard = ({
  data: {
    id,
    image,
    title,
    description,
    price,
    discountPolicy,
    discountRate,
    morningDelivery,
  },
  size,
}) => {
  return (
    <ProductCardWrapper data-id={id} size={size}>
      {/* <ProductThumbnail className={'product-thumbnail'}>
        {morningDelivery && <HoverInfo />}
        <Mask className={'mask'} />
        <img className={'productImg'} src={image} alt={'제품사진'} />
      </ProductThumbnail> */}
      <ProductThumbNail imgUrl={image} morningDelivery={morningDelivery} />
      <Title className={Fonts.FONTS_MD}>{title}</Title>
      <Description className={Fonts.FONTS_SM}>{description}</Description>
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
