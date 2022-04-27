import { useState } from "react";
import { MenuDatas } from "MockData/MockData";
import StyledHeader from "Component/Header/Header.styled";
import HeaderRight from "Component/Header/HeaderRight/HeaderRight";
import HeaderLeft from "Component/Header/HeaderLeft/HeaderLeft";

const maxSubMenuDataSize = MenuDatas.reduce((maxLength, curMenuData) => {
  const curLength = curMenuData.subMenu.length;
  return curLength > maxLength ? curLength : maxLength;
}, 0);

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  const handleMouseEvent = () => {
    setIsOpen(!isOpen);
  };

  return (
    <StyledHeader isOpen={isOpen} maxSubMenuDataSize={maxSubMenuDataSize}>
      <HeaderLeft state={{ handleMouseEvent, isOpen }} />
      <HeaderRight />
    </StyledHeader>
  );
};

export default Header;
