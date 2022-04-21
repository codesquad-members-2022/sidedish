import { Menu } from './Menu';
import { useState } from 'react';
import styled from 'styled-components';

const MenuListWrapper = styled.ul`
  display: flex;
  cursor: pointer;
`;

const menuDatas = [
  { mainMenu: '든든한 메인요리', subMenuList: ['육류 요리', '해산물 요리'] },
  { mainMenu: '뜨끈한 국물요리', subMenuList: ['국/탕/찌개'] },
  {
    mainMenu: '정갈한 밑반찬',
    subMenuList: ['나물/무침', '조림/볶음', '절임/장아찌'],
  },
];

export const MenuList = () => {
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
      {menuDatas.map((menuData, idx) => (
        <Menu key={idx} menuData={menuData} subMenuOpen={subMenuOpen} />
      ))}
    </MenuListWrapper>
  );
};
