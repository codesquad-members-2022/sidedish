import React from 'react';
import styled from 'styled-components';
import TabButton from 'components/MainCategory/Tab/TabButton';

export default function TabBar({ tabNames, selectedTabNum, setSelectedTabNum }) {
  return <Wrap>{tabNames.map(getTabButton)}</Wrap>;

  function getTabButton(tabName, index) {
    const isSelected = index === selectedTabNum;
    return (
      <TabButton
        key={tabName}
        idx={index}
        value={tabName}
        isSelected={isSelected}
        setSelectedTabNum={setSelectedTabNum}
      />
    );
  }
}

TabBar.defaultProps = {
  tabNames: []
};

const Wrap = styled.div({
  display: 'flex',
  gap: '32px'
});
