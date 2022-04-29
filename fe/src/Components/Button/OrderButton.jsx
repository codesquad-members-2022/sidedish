import styled from 'styled-components';

const OrderButtonWrapper = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 16px;
  background-color: black;
  color: white;
  width: 440px;
  height: 58px;

  &:hover {
    opacity: 0.8;
  }

  &:active {
    opacity: 0.4;
  }
  
  &:disabled {
    cursor: default;
    opacity: 0.3;
  }
`;

export const OrderButton = ({ ContentsText = '주문하기', onClick, disabled }) => {
  const outOfStockMessage = 'OUT OF STOCK'
  return (
    <OrderButtonWrapper disabled={disabled} className={'order-button'} onClick={onClick}>
      { disabled ? outOfStockMessage : ContentsText }
    </OrderButtonWrapper>
  );
};
