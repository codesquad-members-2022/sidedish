import { useContext } from "react";
import PropTypes from "prop-types";
import getPriceType from "Util/util";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import DeliveryInfoDiv from "./DeliveryInfo.styled";

const DeliveryInfo = ({ count }) => {
  const { dawnDeliveryFlag, wholeNationDeliveryFlag, discountRate, price } =
    useContext(DetailInfoContext);
  const calcuatedPoint = parseInt((price * count) / 100, 10);
  const pointEarned = getPriceType(calcuatedPoint, discountRate);
  const dawnDelivery = dawnDeliveryFlag ? "서울 경기 새벽 배송" : null;
  const wholeNationDelivery = wholeNationDeliveryFlag ? "전국 택배 배송" : null;
  const deliveryInfo =
    dawnDelivery && wholeNationDelivery
      ? `${dawnDelivery}, ${wholeNationDelivery}`
      : dawnDelivery || wholeNationDelivery;

  return (
    <DeliveryInfoDiv>
      <div>
        <div>적립금</div>
        <div>{pointEarned}</div>
      </div>
      <div>
        <div>배송정보</div>
        <div>{deliveryInfo}</div>
      </div>
      <div>
        <div>배송비</div>
        <div>1,000원 (100,000원 이상 구매 시 무료)</div>
      </div>
    </DeliveryInfoDiv>
  );
};

DeliveryInfo.propTypes = {
  count: PropTypes.number.isRequired,
};

export default DeliveryInfo;
