import React from 'react';
import styled from 'styled-components';
import COLOR from '../variable/color';
import Text from './Text';

export default function TabButton(props) {
  const { value, isSelected } = props;
  return (
    <Wrap isSelected={isSelected}>
      <Text size="X_LARGE" value={value} />
    </Wrap>
  );
}

TabButton.defaultProps = {
  value: ''
};

const Wrap = styled.button({
  width: 'fit-content',
  height: '48px',
  borderBottom: props => (props.isSelected ? `2px solid ${COLOR.BLACK}` : ''),
  cursor: 'pointer'
});
