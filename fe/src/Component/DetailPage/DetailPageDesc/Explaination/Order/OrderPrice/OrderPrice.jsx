import { useContext } from "react";
import getPriceType from "Util/util";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import {
  OrderPriceDiv,
  OriginPriceDiv,
  DiscountTypeDiv,
} from "./OrderPrice.styled";

const OrderPrice = () => {
  const { price, discountType, discountRate } = useContext(DetailInfoContext);

  return (
    <OrderPriceDiv>
      <OriginPriceDiv discountType={discountType} className="price">
        {getPriceType(price)}
      </OriginPriceDiv>
      {discountType && (
        <>
          <DiscountTypeDiv discountType={discountType}>
            {discountType}
          </DiscountTypeDiv>
          <span>{getPriceType(price, discountRate)}</span>
        </>
      )}
    </OrderPriceDiv>
  );
};

export default OrderPrice;
