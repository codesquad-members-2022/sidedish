import React from 'react';
import { Navbar, Menu, Icons, MenuBox, MainMenu, SubMenuList, SubMenu } from './Header.style.js';
import { ReactComponent as Logo } from './assets/logo.svg';
import { ReactComponent as Search } from './assets/search.svg';
import { ReactComponent as Login } from './assets/login.svg';
import { ReactComponent as Cart } from './assets/cart.svg';

const Header = () => {
  return (
    <Navbar>
      <Logo />
      <Menu>
        <MenuBox>
          <MainMenu>든든한 메인요리</MainMenu>
          <SubMenuList>
            <SubMenu>육류 요리</SubMenu>
            <SubMenu>해산물 요리</SubMenu>
          </SubMenuList>
        </MenuBox>
        <MenuBox>
          <MainMenu>뜨끈한 국물요리</MainMenu>
          <SubMenuList>
            <SubMenu>국/탕/찌개</SubMenu>
          </SubMenuList>
        </MenuBox>
        <MenuBox>
          <MainMenu>정갈한 밑반찬</MainMenu>
          <SubMenuList>
            <SubMenu>나물/무침</SubMenu>
            <SubMenu>조림/볶음</SubMenu>
            <SubMenu>절임/장아찌</SubMenu>
          </SubMenuList>
        </MenuBox>
      </Menu>
      <Icons>
        <Search />
        <Login />
        <Cart />
      </Icons>
    </Navbar>
  );
};

export default Header;
