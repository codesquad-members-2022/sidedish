import React, { useState } from 'react';
import { Navbar, Menu, Icons, MenuBox, MainMenu, SubMenuList, SubMenu } from './Header.style.js';
import { ReactComponent as Logo } from 'assets/logo.svg';
import { ReactComponent as Search } from 'assets/search.svg';
import { ReactComponent as Cart } from 'assets/cart.svg';
import menuData from 'data/headerMenu.js';
import Login from 'OAuth/Login.jsx';

const Header = () => {
  const [isNavbarOpen, setIsNavbarOpen] = useState(false);

  const handleNavbarOpen = () => {
    setIsNavbarOpen(true);
  };

  const handleNavbarClose = () => {
    setIsNavbarOpen(false);
  };

  return (
    <Navbar>
      <Logo />
      <Menu>
        {menuData.map((v, i) => {
          return (
            <MenuBox key={i} onMouseEnter={handleNavbarOpen} onMouseLeave={handleNavbarClose}>
              <MainMenu>{v.main}</MainMenu>
              <SubMenuList isOpen={isNavbarOpen}>
                {v.sub.map((name, i) => {
                  return <SubMenu key={i}>{name}</SubMenu>;
                })}
              </SubMenuList>
            </MenuBox>
          );
        })}
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
