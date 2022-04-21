import styled, { css } from 'styled-components';
import { DiscountBadge } from '../Badge/DiscountBadge';
import Colors from '../Constants/Colors';

const CardWrapper = styled.li`
  display: flex;
  flex-direction: column;
`;

const Image = styled.div`
  width: 411px;
  height: 411px;
  ${({ size }) => {
    return size === 'middle'
      ? css`
          width: 310px;
          height: 310px;
        `
      : size === 'small'
      ? css`
          width: 160px;
          height: 160px;
        `
      : null;
  }};

  img {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;

const Title = styled.span`
  display: block;
  margin-top: 12px;
  padding: 4px 0px;
`;

const Description = styled.span`
  display: block;
  padding: 4px 0px;
  color: ${Colors.GREY};
`;

const Price = styled.span`
  display: block;
  padding: 4px 0px;
`;

const BadgeWrapper = styled.div`
  margin-top: 16px;
`;

const DiscountPrice = styled.div`
  margin-left: 8px;
  color: ${Colors.LIGHT_GREY};
  text-decoration: line-through;
`;

const CheckDiscount = ({
  priceData: { price, discountPolicy, discountRate },
}) => {
  if (!discountPolicy) {
    return <Price>{price.toLocaleString()} 원</Price>;
  }

  let discountPrice;
  discountPolicy
    ? (discountPrice = price - price * discountRate)
    : (discountPrice = null);

  return (
    <>
      <Price>{discountPrice.toLocaleString()} 원</Price>
      <DiscountPrice className="fonts-xs">
        {price.toLocaleString()} 원
      </DiscountPrice>
    </>
  );
};

const PriceWrapper = styled.div`
  display: flex;
  align-items: center;
`;

export const ProductCard = ({
  data: {
    size,
    image,
    title,
    description,
    price,
    discountPolicy,
    discountRate,
  },
}) => {
  return (
    <CardWrapper>
      <Image size={size}>
        <img src={image} />
      </Image>
      <Title className="fonts-md">{title}</Title>
      <Description className="fonts-sm">{description}</Description>
      <PriceWrapper>
        <CheckDiscount
          priceData={{
            price: price,
            discountRate: discountRate,
            discountPolicy: discountPolicy,
          }}
        />
      </PriceWrapper>

      <BadgeWrapper>
        <DiscountBadge type={discountPolicy} />
      </BadgeWrapper>
    </CardWrapper>
  );
};
