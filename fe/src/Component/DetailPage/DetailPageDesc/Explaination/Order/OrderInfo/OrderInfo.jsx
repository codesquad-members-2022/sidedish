import PropTypes from "prop-types";
import { useState } from "react";
import DeliveryInfo from "./DeliveryInfo/DeliveryInfo";
import Counter from "./Counter/Counter";
import OrderInfoDiv from "./OrderInfo.styled";
import OrderBtn from "./OrderBtn/OrderBtn";

const OrderInfo = ({ handler }) => {
  const [count, setCount] = useState(1);

  return (
    <OrderInfoDiv>
      <div>
        <DeliveryInfo count={count} />
        <Counter state={{ count, setCount }} />
      </div>
      <OrderBtn count={count} handler={handler} />
    </OrderInfoDiv>
  );
};

OrderInfo.propTypes = {
  handler: PropTypes.objectOf(PropTypes.func).isRequired,
};

export default OrderInfo;
