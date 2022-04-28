import { useContext } from 'react';
import styled from 'styled-components';

import { FONT } from '../../constants/fonts';
import ModalInfoContextStore from '../../stores/ModalInfoStore';
import MinusIcon from '../Icons/MinusIcon';
import PlusIcon from '../Icons/PlusIcon';
import Text from '../Text';

const TotalAmountWrap = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

const IconWrap = styled.button`
  background-color: white;
  cursor: pointer;
`;
const TotalAmount = () => {
  const ModalInfo = useContext(ModalInfoContextStore);

  const onMinusBtnClick = () => {
    if (ModalInfo.amount > 0) {
      ModalInfo.setAmount(ModalInfo.amount - 1);
    }
  };

  const onPlusBtnClick = () => {
    ModalInfo.setAmount(ModalInfo.amount + 1);
  };

  return (
    <TotalAmountWrap>
      <IconWrap onClick={onMinusBtnClick}>
        <MinusIcon />
      </IconWrap>
      <Text font={FONT.MEDIUM_BOLD}>{ModalInfo.amount}</Text>
      <IconWrap onClick={onPlusBtnClick}>
        <PlusIcon />
      </IconWrap>
    </TotalAmountWrap>
  );
};

export default TotalAmount;
