import React from "react";
import styled from "styled-components";

const StyledNav = styled.nav`
  margin-top: 18px;
  margin-left: 15px;
`;

const StyledLi = styled.li`
  margin-top: 10px;
  font-size: 14px;
  &:hover {
    text-decoration: underline;
    cursor: pointer;
  }
`;

const StyledUl = styled.ul`
  display: none;
`;

const CustomNav = (props) => {
  return (
    <StyledNav>
      {props.infor.navTitle}
      <StyledUl className="nav-List">
        {props.infor.navList.map((v, i) => (
          <StyledLi key={i}>{v}</StyledLi>
        ))}
      </StyledUl>
    </StyledNav>
  );
};

export default CustomNav;
