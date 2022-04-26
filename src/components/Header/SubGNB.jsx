import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';

export default function SubGNB({ subVisible, GNB_INFO, gnbIndex }) {
  return (
    <Wrap visible={subVisible}>
      {GNB_INFO[gnbIndex].SUB_GNB.map((subGnbName, index) => (
        <SubGNBItem key={`${subGnbName}_${index}`}>
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
