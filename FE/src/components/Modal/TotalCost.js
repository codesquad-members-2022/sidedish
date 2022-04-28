import { useContext } from 'react';
import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import ModalInfoContextStore from '../../stores/ModalInfoStore';
import Text from '../Text';

const TotalCostWrap = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 55%;
`;

const CostWrap = styled.div``;

const TotalCost = () => {
  const ModalInfo = useContext(ModalInfoContextStore);

  return (
    <TotalCostWrap>
      <CostWrap>
        <Text font={FONT.MEDIUM} textColor={colors.greyThree}>
          총 주문금액
        </Text>
      </CostWrap>
      <Text font={FONT.LARGE_BOLD}>
        {(ModalInfo.cardInfo.s_price * ModalInfo.amount).toLocaleString()}원
      </Text>
    </TotalCostWrap>
  );
};

export default TotalCost;
