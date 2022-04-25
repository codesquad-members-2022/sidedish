import React from "react";
import styled from "styled-components";

const StyledBtn = styled.button`
  width: 155px;
  height: 30px;
  border: 1px dotted ${({ theme }) => theme.colors.grey1};
  font-size: ${({ theme }) => theme.fontSize.large};
  margin: 0 auto;
  z-index: 99;
`;

const More = () => {
  return <StyledBtn>모든 카테고리 보기</StyledBtn>;
};

export default More;
