import styled from 'styled-components';

import colors from '../constants/colors';
import { FONT } from '../constants/fonts';
import headerMenus from '../mocks/headers';
import MainLogoIcon from './Icons/MainLogoIcon';
import MyPageIcon from './Icons/MyPageIcon';
import SearchIcon from './Icons/SearchIcon';
import ShoppingCartIcon from './Icons/ShoppingCartIcon';
import Text from './Text';

const SubMenuWrap = styled.div`
  display: none;
  flex-direction: column;
`;

const HeaderBox = styled.div`
  position: fixed;
  top: 0;
  width: 100%;
  height: 83px;
  background: ${colors.white};
  pointer-events: none;
  border-bottom: 1px solid ${colors.black};
  z-index: 2;
  &:hover {
    height: 160px;
  }
  &:hover ${SubMenuWrap} {
    display: flex;
    background: ${colors.white};
  }
`;

const Icons = styled.div`
  display: flex;
  position: absolute;
  width: 150px;
  right: 140px;
  top: 25px;
`;

const Food = styled(Text)`
  &:hover {
    text-decoration: underline;
    text-decoration-thickness: 3px;
  }
`;

const MenuBar = styled.div`
  display: flex;
  justify-content: space-between;
  position: absolute;
  width: 380px;
  height: 60px;
  left: 294px;
  top: 28px;
  pointer-events: auto;
`;

const MenuWrap = styled.div`
  cursor: pointer;
`;

const SubMenu = ({ subMenus }) => (
  <SubMenuWrap>
    {subMenus.map((menu, idx) => (
      <Food key={menu + idx} font={FONT.SMALL}>
        {menu}
      </Food>
    ))}
  </SubMenuWrap>
);

export default function Header() {
  return (
    <HeaderBox>
      <Icons>
        <SearchIcon />
        <MyPageIcon />
        <ShoppingCartIcon />
      </Icons>
      <MenuBar>
        {headerMenus.map((menu, idx) => (
          <MenuWrap key={menu + idx}>
            <Text font={FONT.MEDIUM}>{menu.title}</Text>
            <SubMenu subMenus={menu.subMenus} />
          </MenuWrap>
        ))}
      </MenuBar>
      <MainLogoIcon />
    </HeaderBox>
  );
}
