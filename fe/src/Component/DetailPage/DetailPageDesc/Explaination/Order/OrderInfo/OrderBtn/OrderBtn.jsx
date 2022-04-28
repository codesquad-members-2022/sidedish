import PropTypes from "prop-types";
import { useContext } from "react";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import constants from "common/constants";
import orderApi from "Service/orderApi";
import dataTools from "common/dataTools";
import OrderBtnStyle from "./OrderBtn.styled";

const { productDetail } = constants;

const OrderBtn = ({ count, handler }) => {
  const { id, price, discountRate } = useContext(DetailInfoContext);

  const calcedTotalPrice = count * (discountRate / 100) * price;
  const calcedPoint = Math.floor(
    calcedTotalPrice * (productDetail.pointPercent / 100)
  );

  const getDatas = () => {
    return {
      sidedishId: id,
      totalPrice: calcedTotalPrice,
      fee: productDetail.deliveryFee,
      quantity: count,
      point: calcedPoint,
    };
  };

  const postOrder = async () => {
    const response = await orderApi.orderSideDish(getDatas());
    return response;
  };

  const handleOrderButton = async () => {
    const { status, data } = await postOrder();

    dataTools.handleStatus({ handler, status, data });
  };

  return <OrderBtnStyle onClick={handleOrderButton}>주문하기</OrderBtnStyle>;
};

OrderBtn.propTypes = {
  count: PropTypes.number.isRequired,
  handler: PropTypes.objectOf(PropTypes.func).isRequired,
};
export default OrderBtn;
