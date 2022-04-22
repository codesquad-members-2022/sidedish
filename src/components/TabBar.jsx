import React from 'react';
import styled from 'styled-components';
import TabButton from './TabButton';

export default function TabBar(props) {
  const { tabNames } = props;
  return (
    <Wrap>
      {tabNames.map((tabName, i) => {
        if (i === 0) {
          return <TabButton value={tabName} isSelected />;
        }
        return <TabButton value={tabName} />;
      })}
    </Wrap>
  );
}

TabBar.defaultProps = {
  tabNames: [],
};

const Wrap = styled.div({
  display: 'flex',
  gap: '32px',
});
