import React, {useState} from 'react';
import {StyledHeader, InnerHeader, BrandHeader, NavBar} from './Header.styled';
import {pageHeaderIcon, searchIcon, userIcon, myCartIcon} from 'constants';
import {NavIcon, Category} from 'components';

const navIcons = [
  {id: 1, name: 'searchIcon', src: `${searchIcon}`},
  {id: 2, name: 'userIcon', src: `${userIcon}`},
  {id: 3, name: 'myCartIcon', src: `${myCartIcon}`},
];

function Header() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <StyledHeader isOpen={isOpen}>
      <InnerHeader>
        <BrandHeader>
          <img src={pageHeaderIcon} alt="pageHeaderIcon"></img>
        </BrandHeader>
        <Category isOpen={isOpen} setIsOpen={setIsOpen} />
        <NavBar>
          {navIcons.map(({id, name, src}) => (
            <NavIcon key={id} name={name} src={src} />
          ))}
        </NavBar>
      </InnerHeader>
    </StyledHeader>
  );
}

export {Header};
