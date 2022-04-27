import React from "react";
import styled from "styled-components";

const InforNav = styled.nav`
  margin-top: 18px;
  margin-left: 15px;
`;

const NavLi = styled.li`
  margin-top: 10px;
  font-size: ${(props) => props.theme.fontSize.small};
  &:hover {
    text-decoration: underline;
    cursor: pointer;
  }
`;

const NavUl = styled.ul`
  display: none;
`;

const CustomNav = (props) => {
  return (
    <InforNav>
      {props.infor.navTitle}
      <NavUl className="nav-List">
        {props.infor.navList.map((v, i) => (
          <NavLi key={i}>{v}</NavLi>
        ))}
      </NavUl>
    </InforNav>
  );
};

export default CustomNav;
