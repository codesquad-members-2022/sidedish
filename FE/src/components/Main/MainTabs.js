import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import Text from '../Text';

const TabsWrap = styled.div`
  border-bottom: 1px solid ${colors.greyFour};
`;
const Tabs = styled.ul`
  display: flex;
  padding: 0px 80px;
`;
const Tab = styled.li`
  margin-right: 32px;
  padding: 5px 0px;
  cursor: pointer;
  border-bottom: ${(props) =>
    props.isSelected ? `2px solid ${colors.black}` : 'none'};
`;

const MainTabs = ({ tabs, selectedTabId, onTabClick }) => (
  <TabsWrap>
    <Tabs>
      {tabs.map((tab) => (
        <Tab
          key={tab.id}
          isSelected={tab.id === selectedTabId}
          onClick={() => {
            onTabClick(tab.id);
          }}
        >
          <Text font={FONT.LARGE_BOLD}>{tab.title}</Text>
        </Tab>
      ))}
    </Tabs>
  </TabsWrap>
);

export default MainTabs;
