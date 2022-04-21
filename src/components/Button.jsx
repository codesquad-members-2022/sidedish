import React from 'react';
import styled from 'styled-components';
import Text from './Text';
import COLOR from '../variable/color';

export default function Button(props) {
  const { value, disabled } = props;
  return (
    <Wrap disabled={disabled}>
      <Text size="LARGE" weight="BOLD" value={value} />
    </Wrap>
  );
}

Button.defaultProps = {
  value: '',
  disabled: false,
};

const Wrap = styled.button`
  width: 100%;
  max-width: 440px;
  padding: 0 15px;
  background: ${COLOR.BLACK};
  color: ${COLOR.WHITE};
  line-height: 58px;
  &:hover {
    background: ${COLOR.GREY1};
  }
  &:disabled {
    background: ${COLOR.GREY3};
  }
`;
