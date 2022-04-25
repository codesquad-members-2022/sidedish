import React from 'react';
import styled from 'styled-components';
import Text from 'components/Text';

export default function TabButton({ value, isSelected }) {
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
  borderBottom: ({ isSelected, theme }) => (isSelected ? `2px solid ${theme.COLOR.BLACK[100]}` : '0'),
  cursor: 'pointer'
});
