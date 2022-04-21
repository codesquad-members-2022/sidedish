import { Menu } from './Menu';
import { useState } from 'react';
import styled from 'styled-components';

const MenuListWrapper = styled.ul`
  display: flex;
  cursor: pointer;
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
