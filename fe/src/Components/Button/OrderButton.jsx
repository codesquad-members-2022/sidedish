import styled from 'styled-components';

const OrderButtonWrapper = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 16px;
  background-color: black;
  color: white;

  position: absolute;
  width: 440px;
  height: 58px;
  right: 0px;
  bottom: 20px;
`;

export const OrderButton = ({ ContentsText, onClick }) => {
  return (
    <OrderButtonWrapper onClick={onClick}>{ContentsText}</OrderButtonWrapper>
  );
};
