import React from "react";
import styled from "styled-components";

const MenuTypeList = ({ menuTypeTitle, menuTypes, menuHideState }) => {
  const menuTypeList = menuTypes.map((menuType, ind) => <MenuType key={ind}>{menuType}</MenuType>);

  return (
    <MenuTypeContainer>
      <MenuTypeTitle>{menuTypeTitle}</MenuTypeTitle>
      <MenuTypeListContainer menuHideState={menuHideState}>{menuTypeList}</MenuTypeListContainer>
    </MenuTypeContainer>
  );
};

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
  display: ${(props) => (props.menuHideState ? "none" : "flex")};
  flex-direction: column;
  padding: 4px;
`;

const MenuType = styled.li`
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

export default MenuTypeList;
