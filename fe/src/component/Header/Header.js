import React, { useState } from "react";

import GNB from "./GNB";
import styled from "styled-components";

const StyledHeader = styled.header`
  margin-top: 20px;
`;

const Header = () => {
  return (
    <StyledHeader>
      <GNB />
    </StyledHeader>
  );
};

export default Header;
