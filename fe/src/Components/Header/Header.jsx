import styled from 'styled-components';

import { IconFonts } from '@/Constants';

import { MenuList } from './MenuList';
import { UserActionButtons } from './UserActionButtons';

import Colors from '@/Constants/Colors';
import Fonts from '@/Constants/Fonts';

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
  font-size: 40px;
`;

const LogoIcon = styled.i`
  &:hover {
    opacity: 0.6;
  }
  &:active {
    opacity: 0.3;
  }
`;

const Logo = () => {
  return (
    <LogoWrapper href={'/'}>
      <LogoIcon
        className={`${IconFonts.LOGO} ${Fonts.FONTS_DISPLAY}`}
        aria-label={'로고'}
      />
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
