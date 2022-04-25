import React from 'react';
import styled from 'styled-components';
import TabButton from './TabButton';

export default function TabBar({ tabNames }) {
  return <Wrap>{tabNames.map(getTabButton)}</Wrap>;
}

TabBar.defaultProps = {
  tabNames: []
};

function getTabButton(tabName, index) {
  const isFirstTabButton = index === 0;
  return <TabButton key={`${tabName}_${index}`} value={tabName} isSelected={isFirstTabButton} />;
}

const Wrap = styled.div({
  display: 'flex',
  gap: '32px'
});
