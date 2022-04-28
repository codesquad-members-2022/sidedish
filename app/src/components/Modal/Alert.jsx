import styled from "styled-components";
import { Background, FlexCenter } from "../../styled-components/utils.js";

const Alert = ({ handleOrderClickBtn }) => {
  return (
    <>
      <Background zIndex={3}></Background>
      <OrderComplete>
        <OrderTitle>
          해당 상품을
          <br />
          주문했습니다.
        </OrderTitle>
        <ConfirmBtn as="button" onClick={handleOrderClickBtn}>
          확인
        </ConfirmBtn>
      </OrderComplete>
    </>
  );
};

const OrderComplete = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 27rem;
  height: 12.9rem;
  box-sizing: border-box;
  border: 1px solid ${({ theme }) => theme.color.black};
  background-color: ${({ theme }) => theme.color.white};
  z-index: 4;
`;

const OrderTitle = styled(FlexCenter)`
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  line-height: 2.6rem;
  padding: 1.6rem;
  text-align: center;
`;

const ConfirmBtn = styled(FlexCenter)`
  width: 100%;
  height: 4.4rem;
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  background-color: ${({ theme }) => theme.color.black};
  color: ${({ theme }) => theme.color.white};
`;

export default Alert;
