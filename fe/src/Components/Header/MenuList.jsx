import { useState } from 'react';
import styled from 'styled-components';

import { Fonts } from '@/Constants';

import { Menu } from './Menu';

const MenuListWrapper = styled.ul`
  display: inline-flex;
  white-space: nowrap;
  overflow-x: auto;
  cursor: pointer;
  padding-top: 12px;
`;

export const MenuList = ({ categoryList }) => {
  const [subMenuOpen, setSubMenuOpen] = useState(false);

  const handleMouseEnter = () => {
    setSubMenuOpen(true);
  };

  const handleMouseLeave = () => {
    setSubMenuOpen(false);
  };

  return (
    <MenuListWrapper
      className={Fonts.MD}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
    >
      {categoryList.map(category => (
        <Menu key={category.id} category={category} subMenuOpen={subMenuOpen} />
      ))}
    </MenuListWrapper>
  );
};
