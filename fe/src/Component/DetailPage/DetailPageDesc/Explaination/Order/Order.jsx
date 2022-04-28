import { useContext } from "react";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import OrderPrice from "./OrderPrice/OrderPrice";
import OrderInfo from "./OrderInfo/OrderInfo";
import OrderDiv from "./Order.styled";

const Order = () => {
  const { name } = useContext(DetailInfoContext);

  return (
    <OrderDiv>
      <div className="name">{name}</div>
      <OrderPrice />
      <OrderInfo />
    </OrderDiv>
  );
};

export default Order;
