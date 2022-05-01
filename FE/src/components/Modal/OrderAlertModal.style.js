import styled from 'styled-components';

const OrderAlertModalStyle = styled.div`
  width: 270px;
  height: 129px;
  border: 1px solid ${({ theme: { colors } }) => colors.black};
  position: absolute;
  top: 36%;
  left: 57%;
`;

const OrderContent = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 85px;
  color: ${({ theme: { colors } }) => colors.black};
  background-color: ${({ theme: { colors } }) => colors.white};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  white-space: pre-line;
  text-align: center;
`;

const CheckBtn = styled.div`
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 44px;
  color: ${({ theme: { colors } }) => colors.white};
  background-color: ${({ theme: { colors } }) => colors.black};
`;

export { OrderAlertModalStyle, OrderContent, CheckBtn };
