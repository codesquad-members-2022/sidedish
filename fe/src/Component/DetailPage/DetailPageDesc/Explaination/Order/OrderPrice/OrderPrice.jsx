import { useContext } from "react";
import getPriceType from "Util/util";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import { OrderPriceDiv, DiscountTypeDiv } from "./OrderPrice.styled";

const OrderPrice = () => {
  const { price, discountType, discountRate } = useContext(DetailInfoContext);

  return (
    <>
      <OrderPriceDiv discountType={discountType} className="price">
        {getPriceType(price)}
      </OrderPriceDiv>
      {discountType && (
        <>
          <DiscountTypeDiv discountType={discountType}>
            {discountType}
          </DiscountTypeDiv>
          <span>{getPriceType(price, discountRate)}</span>
        </>
      )}
    </>
  );
};

export default OrderPrice;
