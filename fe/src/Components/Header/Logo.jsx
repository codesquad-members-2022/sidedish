import styled from 'styled-components';

import { Fonts, IconFonts } from '@/Constants';

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

export const Logo = () => {
  return (
    <LogoWrapper href={'/'}>
      <LogoIcon
        className={`${IconFonts.LOGO} ${Fonts.DISPLAY}`}
        aria-label={'로고'}
      />
    </LogoWrapper>
  );
};
