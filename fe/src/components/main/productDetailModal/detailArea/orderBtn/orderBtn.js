import styled from 'styled-components';
import { applyFlex } from '../../../../../helper/utils';

export function OrderBtn() {
  return (
    <StyledOrderBtn flex justify="center" align="center">
      주문하기
    </StyledOrderBtn>
  );
}

const StyledOrderBtn = styled.div`
  ${({ flex, justify, align }) => applyFlex({ flex, justify, align })}
  width: 440px;
  height: 58px;
  left: 472px;
  top: 490px;
  color: #fff;
  font-weight: 700;
  font-size: 20px;
  line-height: 26px;
  background: #1b1b1b;
  margin-top: 22px;
  margin-left: 32px;
`;
