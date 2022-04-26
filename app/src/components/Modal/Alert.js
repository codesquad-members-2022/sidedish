import {
  OrderComplete,
  OrderTitle,
  ConfirmBtn,
} from "../../styles/Modal/Alert.js";
import { Background } from "../../styles/utils.js";

const Alert = ({ handleOrderBtnClick }) => {
  return (
    <>
      <Background zIndex={3}></Background>
      <OrderComplete>
        <OrderTitle>
          해당 상품을
          <br />
          주문했습니다.
        </OrderTitle>
        <ConfirmBtn as="button" onClick={handleOrderBtnClick}>
          확인
        </ConfirmBtn>
      </OrderComplete>
    </>
  );
};

export default Alert;
