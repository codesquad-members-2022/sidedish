import styled from 'styled-components';

import { Colors } from '@/Constants';

const ListPrice = styled.span`
  display: block;
  padding: 4px 0;
`;

const OriginalPrice = styled.div`
  margin-left: 8px;
  color: ${Colors.LIGHT_GREY};
  text-decoration: line-through;
`;

export const PriceTag = ({
  priceData: { price, discountPolicy, discountRate },
}) => {
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
