import React from 'react';
import styled from 'styled-components';
import TabButton from './TabButton';

export default function TabBar(props) {
  const { tabNames } = props;
  return <Wrap>{tabNames.map(getTabButton)}</Wrap>;
}

TabBar.defaultProps = {
  tabNames: []
};

function getTabButton(tabName, i) {
  const isFirstTabButton = i === 0;
  return <TabButton value={tabName} isSelected={isFirstTabButton} />;
}

const Wrap = styled.div({
  display: 'flex',
  gap: '32px'
});
