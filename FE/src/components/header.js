import styled from 'styled-components';

import MainLogoIcon from './Icons/MainLogoIcon';
import MyPageIcon from './Icons/MyPageIcon';
import SearchIcon from './Icons/SearchIcon';
import ShoppingCartIcon from './Icons/ShoppingCartIcon';

const SubMenu = styled.div`
  display: none;
`;
const HeaderBox = styled.div`
  position: absolute;
  width: 100%;
  height: 83px;
  background: #ffffff;
  pointer-events: none;
  border-bottom: 1px solid #1b1b1b;
  &:hover {
    height: 160px;
  }
  &:hover ${SubMenu} {
    display: block;
    background: #ffffff;
  }
`;
const Icons = styled.div`
  display: flex;
  position: absolute;
  width: 150px;
  right: 140px;
  top: 25px;
`;

const Food = styled.div`
  &:hover {
    text-decoration: underline;
    text-decoration-thickness: 3px;
  }
  font-size: 14px;
  line-height: 24px;
`;

function FirstSubMenu() {
  return (
    <SubMenu>
      <Food>육류 요리</Food>
      <Food>해산물 요리</Food>
    </SubMenu>
  );
}
function SecondSubMenu() {
  return (
    <SubMenu>
      <Food>국/탕/찌개</Food>
    </SubMenu>
  );
}
function ThirdSubMenu() {
  return (
    <SubMenu>
      <Food>나물/무침</Food>
      <Food>조림/볶음</Food>
      <Food>절임/짱아찌</Food>
    </SubMenu>
  );
}
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
const MenuList = styled.div`
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 400;
  font-size: 16px;
  line-height: 26px;
  cursor: pointer;
`;
export default function Header() {
  return (
    <HeaderBox>
      <Icons>
        <SearchIcon />
        <MyPageIcon />
        <ShoppingCartIcon />
      </Icons>
      <MenuBar>
        <MenuList>
          든든한 메인요리
          <FirstSubMenu />
        </MenuList>
        <MenuList>
          뜨끈한 국물요리
          <SecondSubMenu />
        </MenuList>
        <MenuList>
          정갈한 밑반찬
          <ThirdSubMenu />
        </MenuList>
      </MenuBar>
      <MainLogoIcon />
    </HeaderBox>
  );
}
