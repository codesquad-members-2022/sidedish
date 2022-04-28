import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import Text from '../Text';

const OrderButtonWrap = styled.div`
  background-color: ${colors.black};
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 28%;
  height: 10%;
`;

const OrderButton = () => (
  <OrderButtonWrap>
    <Text font={FONT.SMALL_TITLE} textColor={colors.white}>
      주문하기
    </Text>
  </OrderButtonWrap>
);

export default OrderButton;
