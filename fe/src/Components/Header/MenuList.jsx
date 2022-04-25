import { useState } from 'react';
import styled from 'styled-components';

import { Menu } from './Menu';

import Fonts from '@/Constants/Fonts';

const MenuListWrapper = styled.ul`
  display: inline-flex;
  white-space: nowrap;
  overflow-x: auto;
  cursor: pointer;
  padding-top: 12px;
`;

export const MenuList = props => {
  const [subMenuOpen, setSubMenuOpen] = useState(false);

  const handleMouseEnter = () => {
    setSubMenuOpen(true);
  };

  const handleMouseLeave = () => {
    setSubMenuOpen(false);
  };

  return (
    <MenuListWrapper
      className={Fonts.FONTS_MD}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
    >
      {props.categoryList.map(category => (
        <Menu key={category.id} category={category} subMenuOpen={subMenuOpen} />
      ))}
    </MenuListWrapper>
  );
};
