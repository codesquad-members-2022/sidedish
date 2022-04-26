import React from 'react';
import styled from 'styled-components';
import Text from 'components/Text';

export default function SubGNBList({ subVisible, GNB_INFO, gnbIndex }) {
  return (
    <Wrap visible={subVisible}>
      {GNB_INFO[gnbIndex].SUB_GNB.map((subGnbName, index) => (
        <SubGnb key={`${subGnbName}_${index}`}>
          <a href="http://localhost:3000/">
            <Text value={subGnbName} />
          </a>
        </SubGnb>
      ))}
    </Wrap>
  );
}

SubGNBList.defaultProps = {
  visible: false,
  GNB_INFO: {},
  gnbIndex: 0
};

const Wrap = styled.ul({
  maxHeight: ({ visible }) => (visible ? '100%' : 0),
  transition: 'max-height .15s ease-in-out',
  overflow: 'hidden'
});

const SubGnb = styled.li`
  margin-top: 8px;
  line-height: 1.5;
  &:last-child {
    margin-bottom: 24px;
  }
`;
