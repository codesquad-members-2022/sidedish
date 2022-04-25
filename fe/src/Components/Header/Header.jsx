import styled from 'styled-components';

import { MenuList } from './MenuList';
import { UserActionButtons } from './UserActionButtons';

import Colors from '@/Constants/Colors';

const HeaderWrapper = styled.header`
  width: 100%;
  padding: 16px 80px;
  border-bottom: 1px solid ${Colors.BLACK};
  display: flex;
  align-items: flex-start;
`;

const LogoWrapper = styled.a`
  display: block;
  margin-right: 40px;

  img {
    display: block;
    height: 100%;
  }
`;

const Logo = () => {
  return (
    <LogoWrapper href={'/'}>
      <img src={'logo.svg'} alt="로고" />
    </LogoWrapper>
  );
};

export const Header = props => {
  if (!props.categoryList.length) return null;

  return (
    <HeaderWrapper>
      <Logo />
      <MenuList categoryList={props.categoryList} />
      <UserActionButtons />
    </HeaderWrapper>
  );
};
