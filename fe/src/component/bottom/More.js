import React from "react";
import styled from "styled-components";

const ButtonWrapper = styled.div`
  height: 200px;
  width: 1440px;
  display: flex;
  margin-top: 50px;
`;

const StyledBtn = styled.button`
  width: 155px;
  height: 30px;
  border: 1px dotted ${({ theme }) => theme.colors.grey1};
  font-size: ${({ theme }) => theme.fontSize.large};
  margin: 0 auto;
`;

const More = ({ onchange, isDisplayed }) => {
  return (
    <ButtonWrapper>
      <StyledBtn onClick={onchange}>
        {isDisplayed ? "카테고리 닫기" : "모든 카테고리 보기"}
      </StyledBtn>
    </ButtonWrapper>
  );
};

export default More;
