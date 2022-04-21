import React from "react";
import { ReactComponent as CartIcon } from "../../asset/cartIcon.svg";
import { ReactComponent as MyPageIcon } from "../../asset/myPageIcon.svg";
import { ReactComponent as SearchIcon } from "../../asset/searchIcon.svg";

import styled, { css } from "styled-components";

const IconBox = styled.div`
  position: absolute;
  top: 10px;
  right: 80px;
  display: flex;
  align-items: center;
`;

const StyledCartIcon = styled(CartIcon)`
  ${(props) => svgStyles(props)}
`;

const StyledMyPageIcon = styled(MyPageIcon)`
  ${(props) => svgStyles(props)}
`;

const StyledSearchIcon = styled(SearchIcon)`
  ${(props) => svgStyles(props)}
`;

const svgStyles = ({ height, width }) => {
  return css`
    height: ${height};
    width: ${width};
    margin-left: 10px;
  `;
};

const Icons = () => {
  return (
    <IconBox>
      <StyledSearchIcon />
      <StyledMyPageIcon />
      <StyledCartIcon />
    </IconBox>
  );
};

export default Icons;
