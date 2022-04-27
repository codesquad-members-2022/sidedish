import styled from 'styled-components';

import { Colors } from '@/Constants';

import { Logo } from './Logo';
import { MenuList } from './MenuList';
import { UserActionButtons } from './UserActionButtons';

const HeaderWrapper = styled.header`
  width: 100%;
  padding: 16px 80px;
  border-bottom: 1px solid ${Colors.BLACK};
  display: flex;
  align-items: flex-start;
`;

export const Header = ({ categoryList }) => {
  return (
    <HeaderWrapper>
      <Logo />
      <MenuList categoryList={categoryList} />
      <UserActionButtons />
    </HeaderWrapper>
  );
};
