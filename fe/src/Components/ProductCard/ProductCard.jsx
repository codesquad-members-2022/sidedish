import styled, { css } from 'styled-components';

import { HoverInfo } from './HoverInfo';
import { PriceTag } from './PriceTag';

import { DiscountBadge } from '@/Components/Badge/DiscountBadge';
import Colors from '@/Constants/Colors';

const CardWrapper = styled.li`
  display: flex;
  flex-direction: column;
  cursor: pointer;

  &:not(:last-child) {
    margin-right: 24px;
  }

  ${({ size }) => {
    return size === 'md'
      ? css`
          .image {
            width: 302px;
            height: 302px;
          }
        `
      : size === 'sm'
      ? css`
          &:not(:last-child) {
            margin-right: 16px;
          }

          .image {
            width: 160px;
            height: 160px;
          }
        `
      : null;
  }};
`;

const CardImgContainer = styled.div`
  position: relative;
  width: 411px;
  height: 411px;

  .productCardImg {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  &:hover {
    .hover-info {
      opacity: 0.8;
    }

    .mask {
      opacity: 1;
    }
  }
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

const Mask = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  bottom: 0;
  z-index: 1;
  opacity: 0;
  background-color: rgba(0, 0, 0, 0.2);
  transition: opacity 150ms;
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
    <CardWrapper data-id={id} size={size}>
      <CardImgContainer className={'image'}>
        {morningDelivery && <HoverInfo />}
        <Mask className={'mask'} />
        <img className={'productCardImg'} src={image} alt={'제품사진'} />
      </CardImgContainer>
      <Title className="fonts-md">{title}</Title>
      <Description className="fonts-sm">{description}</Description>
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
    </CardWrapper>
  );
};
