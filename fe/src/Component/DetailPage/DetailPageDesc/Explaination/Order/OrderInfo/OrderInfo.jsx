import { useState } from "react";
import DeliveryInfo from "./DeliveryInfo/DeliveryInfo";
import Counter from "./Counter/Counter";
import OrderInfoDiv from "./OrderInfo.styled";
import OrderBtn from "./OrderBtn/OrderBtn";

const OrderInfo = () => {
  const [count, setCount] = useState(1);

  return (
    <OrderInfoDiv>
      <div>
        <DeliveryInfo count={count} />
        <Counter state={{ count, setCount }} />
      </div>
      <OrderBtn />
    </OrderInfoDiv>
  );
};

export default OrderInfo;
