import React, { useState } from "react";
import styled from "styled-components";

const MenuTypeContainer = styled.div`
  display: flex;
  flex-direction: column;
  padding: 0 24px;
`;

const MenuTypeTitle = styled.h3`
  font-family: "Noto Sans KR";
  font-style: normal;
  font-weight: 400;
  font-size: 16px;
  line-height: 26px;
  letter-spacing: -0.008em;
  padding: 8px;
  cursor: default;
`;

const MenuTypeListContainer = styled.ul`
  display: flex;
  flex-direction: column;
  padding: 4px;
`;
const MenuType = styled.li`
  display: ${(props) => (props.menuHideState ? "none" : "block")};
  font-family: "Noto Sans KR";
  font-style: normal;
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  letter-spacing: -0.008em;
  padding: 4px;

  &:hover {
    color: green;
    text-decoration: underline;
    cursor: pointer;
  }
`;

const MenuTypeList = ({ menuTypeTitle, menuTypes }) => {
  const [menuHideState, setMenuHideState] = useState(true);
  const handleMenuHidden = () => {
    setMenuHideState(() => !menuHideState);
  };
  const menuTypeList = menuTypes.map((menuType, ind) => (
    <MenuType menuHideState={menuHideState} key={ind}>
      {menuType}
    </MenuType>
  ));

  return (
    <MenuTypeContainer onMouseLeave={handleMenuHidden} onMouseEnter={handleMenuHidden}>
      <MenuTypeTitle>{menuTypeTitle}</MenuTypeTitle>
      <MenuTypeListContainer>{menuTypeList}</MenuTypeListContainer>
    </MenuTypeContainer>
  );
};

export default MenuTypeList;
