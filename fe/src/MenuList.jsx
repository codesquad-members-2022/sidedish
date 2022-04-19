import { Menu } from './Menu';
import { useState } from 'react';
import styled from 'styled-components';

const StyledMenuList = styled.ul`
  display: flex;
  cursor: pointer;
`;

export const MenuList = () => {
  const [menuDatas, setMenuDatas] = useState([
    { mainMenu: '든든한 메인요리', subMenuList: ['육류 요리', '해산물 요리'] },
    { mainMenu: '뜨끈한 국물요리', subMenuList: ['국/탕/찌개'] },
    {
      mainMenu: '정갈한 밑반찬',
      subMenuList: ['나물/무침', '조림/볶음', '절임/장아찌'],
    },
  ]);

  const [isMouseEnter, setIsMouseEnter] = useState(false);

  const handleMouseEnter = () => {
    setIsMouseEnter(true);
  };

  const handleMouseLeave = () => {
    setIsMouseEnter(false);
  };

  return (
    <StyledMenuList
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
    >
      {menuDatas.map((menuData, idx) => (
        <Menu key={idx} menuData={menuData} isMouseEnter={isMouseEnter} />
      ))}
    </StyledMenuList>
  );
};
