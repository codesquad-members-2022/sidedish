import React from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../../style/theme.js";
import GNBLists from "../../constants/GNBLists.js";
import CustomNav from "./CustomNav";
import Icons from "./Icons";

const HeaderTitle = styled.h1`
  font-size: ${({ theme }) => theme.fontSize.xLarge};
  font-weight: ${({ theme }) => theme.fontWeight.xBold};
`;

const GNBWrapper = styled.div`
  display: flex;
  // align-items: center;
  position: relative;
  height: 70px;
  padding: 0 40px;
  border-bottom: 1px solid ${({ theme }) => theme.colors.grey1};
  &:hover {
    height: 140px;
    .nav-List {
      display: block;
    }
  }
`;

const GNB = () => {
  return (
    <GNBWrapper>
      <HeaderTitle>Ordering</HeaderTitle>
      {GNBLists.map((navInfo, i) => (
        <CustomNav key={i} infor={navInfo} />
      ))}
      <Icons />
    </GNBWrapper>
  );
};

export default GNB;
