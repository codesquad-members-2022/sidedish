import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';

export default function TabButton({ value, idx, isSelected, setSelectedTabNum }) {
  return (
    <Wrap onClick={() => setSelectedTabNum(idx)} isSelected={isSelected}>
      <Text size="X_LARGE" value={value} />
    </Wrap>
  );
}

TabButton.defaultProps = {
  value: ''
};

const Wrap = styled.button({
  boxSizing: 'content-box',
  width: 'fit-content',
  height: '48px',
  borderBottom: ({ isSelected, theme }) => (isSelected ? `2px solid ${theme.COLOR.BLACK[100]}` : '0'),
  cursor: 'pointer'
});
