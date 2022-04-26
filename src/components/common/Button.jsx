import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';

export default function Button({ value, disabled }) {
  return (
    <Wrap disabled={disabled}>
      <Text size="LARGE" color="WHITE_200" weight="BOLD" value={value} />
    </Wrap>
  );
}

Button.defaultProps = {
  value: '',
  disabled: false
};

const Wrap = styled.button`
  width: 100%;
  max-width: 440px;
  padding: 0 15px;
  background: ${({ theme }) => theme.COLOR.BLACK[100]};
  color: ${({ theme }) => theme.COLOR.WHITE[100]};
  line-height: 58px;
  &:hover {
    background: ${({ theme }) => theme.COLOR.GREY[100]};
  }
  &:disabled {
    background: ${({ theme }) => theme.COLOR.GREY[300]};
    cursor: default;
  }
`;
