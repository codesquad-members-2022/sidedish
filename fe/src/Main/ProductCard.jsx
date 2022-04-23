import styled, { css } from 'styled-components';

import { DiscountBadge } from '@/Badge/DiscountBadge';
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

const Image = styled.div`
  position: relative;
  width: 411px;
  height: 411px;

  img {
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

const ListPrice = styled.span`
  display: block;
  padding: 4px 0;
`;

const BadgeWrapper = styled.div`
  margin-top: 16px;
`;

const OriginalPrice = styled.div`
  margin-left: 8px;
  color: ${Colors.LIGHT_GREY};
  text-decoration: line-through;
`;

const PriceWrapper = styled.div`
  display: flex;
  align-items: center;
`;

const HoverInfoWrapper = styled.div`
  position: absolute;
  top: 20px;
  right: 20px;
  border: 1px solid black;
  padding: 40px 42px;
  border-radius: 999px;
  background-color: ${Colors.OFF_WHITE};
  opacity: 0;
  z-index: 2;
  transition: opacity 150ms;

  div {
    border-bottom: 1px solid ${Colors.BLACK};
    margin: 8px 0;
  }
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

const Price = ({ priceData: { price, discountPolicy, discountRate } }) => {
  if (!discountPolicy) {
    return <ListPrice>{price.toLocaleString()} 원</ListPrice>;
  }

  const discountPrice = discountPolicy ? price - price * discountRate : null;

  return (
    <>
      {<ListPrice>{discountPrice.toLocaleString()} 원</ListPrice>}
      <OriginalPrice className="fonts-xs">
        {price.toLocaleString()} 원
      </OriginalPrice>
    </>
  );
};

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

const HoverInfo = () => {
  return (
    <HoverInfoWrapper className={'fonts-md-bold hover-info'}>
      <p>새벽 배송</p>
      <div />
      <p>전국 택배</p>
    </HoverInfoWrapper>
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
      <Image className={'image'}>
        {morningDelivery && size !== 'sm' && <HoverInfo />}
        <Mask className={'mask'} />
        <img src={image} alt={'제품사진'} />
      </Image>
      <Title className="fonts-md">{title}</Title>
      <Description className="fonts-sm">{description}</Description>
      <PriceWrapper>
        <Price
          priceData={{
            price: price,
            discountRate: discountRate,
            discountPolicy: discountPolicy,
          }}
        />
      </PriceWrapper>
      <PolicyBadge priceData={discountPolicy} />
    </CardWrapper>
  );
};
