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
`;

export const OrderButton = ({ ContentsText, onClick }) => {
  return (
    <OrderButtonWrapper className={'order-button'} onClick={onClick}>
      {ContentsText}
    </OrderButtonWrapper>
  );
};
