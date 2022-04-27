import React from "react";
import styled from "styled-components";
import constansts from "../../constants/constansts.js";
import CustomNav from "./CustomNav";
import HeaderIcon from "../icons/HeaderIcon.js";

const HeaderTitle = styled.h1`
  font-size: ${({ theme }) => theme.fontSize.xLarge};
  font-weight: ${({ theme }) => theme.fontWeight.xBold};
`;

const GNBWrapper = styled.div`
  display: flex;
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
      {constansts.GNBLists.map((navInfo, i) => (
        <CustomNav key={i} infor={navInfo} />
      ))}
      <HeaderIcon />
    </GNBWrapper>
  );
};

export default GNB;
