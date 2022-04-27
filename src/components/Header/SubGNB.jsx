import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';

export default function SubGNB({ visible, SUB_GNB_INFO }) {
  return (
    <Wrap visible={visible}>
      {SUB_GNB_INFO.SUB_GNB.map(subGnbName => (
        <SubGNBItem key={subGnbName}>
          <a href="http://localhost:3000/">
            <Text value={subGnbName} />
          </a>
        </SubGNBItem>
      ))}
    </Wrap>
  );
}

SubGNB.defaultProps = {
  visible: false,
  GNB_INFO: {},
  gnbIndex: 0
};

const Wrap = styled.ul({
  maxHeight: ({ visible }) => (visible ? '100%' : 0),
  transition: 'max-height .15s ease-in-out',
  overflow: 'hidden'
});

const SubGNBItem = styled.li`
  margin-top: 8px;
  line-height: 1.5;
  &:last-child {
    margin-bottom: 24px;
  }
`;
