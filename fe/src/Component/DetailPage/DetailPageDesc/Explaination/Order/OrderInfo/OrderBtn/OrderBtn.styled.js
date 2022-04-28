import styled, { css } from "styled-components";

const OrderBtnStyle = styled.button`
  width: 440px;
  height: 58px;
  margin-top: 22px;
  font-weight: 700;
  font-size: 18px;
  line-height: 26px;
  border-radius: 10px;

  ${({ theme: { colors } }) => css`
    background-color: ${colors.black};
    color: ${colors.white};
  `}
`;

export default OrderBtnStyle;
