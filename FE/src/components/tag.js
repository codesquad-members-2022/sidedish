import styled from 'styled-components';

import colors from '../constants/colors';
import { FONT } from '../constants/fonts';
import Text from './Text';

const TagWrap = styled.div`
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  padding: 6px 16px;
  width: fit-content;
  height: 30px;
  border-radius: 100px;
  margin-right: 4px;
  background-color: ${({ badge }) => (badge === '이벤트특가' ? colors.green : colors.orange)};
`;

const Tag = ({ badge }) => (
  <TagWrap badge={badge}>
    <Text font={FONT.XSMALL_BOLD} textColor={colors.white}>
      {badge}
    </Text>
  </TagWrap>
);

export default Tag;
