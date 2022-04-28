import PropTypes from "prop-types";
import { useContext } from "react";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import OrderPrice from "./OrderPrice/OrderPrice";
import OrderInfo from "./OrderInfo/OrderInfo";
import OrderDiv from "./Order.styled";

const Order = ({ handler }) => {
  const { name } = useContext(DetailInfoContext);

  return (
    <OrderDiv>
      <div className="name">{name}</div>
      <OrderPrice />
      <OrderInfo handler={handler} />
    </OrderDiv>
  );
};

Order.propTypes = {
  handler: PropTypes.objectOf(PropTypes.func).isRequired,
};

export default Order;
