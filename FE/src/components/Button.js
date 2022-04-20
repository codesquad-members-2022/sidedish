import styled from 'styled-components';

import colors from '../constants/colors';

const ButtonWrap = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 16px;
  width: 440px;
  height: 58px;
  ${(props) => {
    if (props.disabled) {
      return `background-color: ${colors.greyThree};`;
    }
    return `
      background-color: ${colors.black};
      cursor:pointer;
      &:hover {
        background-color: ${colors.greyOne};
      }
    `;
  }}
`;

const ButtonText = styled.span`
  font-weight: 700;
  font-size: 18px;
  line-height: 26px;
  color: ${colors.white};
`;

const Button = ({ message, isDisabled }) => (
  <ButtonWrap disabled={isDisabled}>
    <ButtonText>{message}</ButtonText>
  </ButtonWrap>
);

export default Button;
