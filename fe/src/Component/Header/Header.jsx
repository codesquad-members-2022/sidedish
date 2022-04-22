import { useState } from "react";
import { MenuDatas } from "../../MockData/MockData";
import StyledHeader from "./Header.styled";
import HeaderRight from "./HeaderRight/HeaderRight";
import HeaderLeft from "./HeaderLeft/HeaderLeft";

const maxSubMenuDataSize = MenuDatas.reduce((maxLength, curMenuData) => {
  const curLength = curMenuData.subMenu.length;
  return curLength > maxLength ? curLength : maxLength;
}, 0);

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  const checkIsOpen = () => {
    return isOpen;
  };

  const handleMouseEvent = () => {
    setIsOpen(!isOpen);
  };

  return (
    <StyledHeader isOpen={isOpen} maxSubMenuDataSize={maxSubMenuDataSize}>
      <HeaderLeft state={{ handleMouseEvent, checkIsOpen }} />
      <HeaderRight />
    </StyledHeader>
  );
};

export default Header;
