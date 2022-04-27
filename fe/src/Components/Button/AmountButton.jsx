import styled from 'styled-components';

import { Colors } from '@/Constants';

const AmountButtonWrapper = styled.button`
  color: ${Colors.GREY};
  width: 24px;
  height: 24px;

  i {
    font-size: 20px;
  }
`;

const Icon = styled.i`
  color: ${Colors.GREY};
`;
export const AmountButton = ({ iconSrc, onClickIcon, label }) => {
  return (
    <AmountButtonWrapper onClick={onClickIcon}>
      <Icon className={iconSrc} aria-label={label} />
    </AmountButtonWrapper>
  );
};
