import { useState } from 'react';
import styled from 'styled-components';

import { Menu } from './Menu';

const MenuListWrapper = styled.ul`
  display: inline-flex;
  white-space: nowrap;
  overflow-x: auto;
  cursor: pointer;
  flex-grow: 1;
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
      className={'fonts-md'}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
    >
      {props.categories.map(category => (
        <Menu key={category.id} category={category} subMenuOpen={subMenuOpen} />
      ))}
    </MenuListWrapper>
  );
};
