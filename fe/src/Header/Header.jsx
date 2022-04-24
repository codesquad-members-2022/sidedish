import styled from 'styled-components';

import { MenuList } from './MenuList';
import { UserButtons } from './UserButtons';

import Colors from '@/Constants/Colors';

const HeaderWrapper = styled.header`
  width: 1440px;
  padding: 16px 80px;
  border-bottom: 1px solid ${Colors.BLACK};
  margin: 0 auto;
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
  )
}

export const Header = props => {
  return (
    <HeaderWrapper>
      <Logo />
      <MenuList categories={props.categories} />
      <UserButtons />
    </HeaderWrapper>
  );
};
