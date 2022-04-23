import React from "react";
import styled from "styled-components";

const SubTitleWrapper = styled.div`
  display: flex;
  align-items: center;
  padding: 40px 40px 0px;
`;
const SubTitleText = styled.h2`
  font-size: 40px;
  // fontsize, weight 상수로 관리해서 가져온다면 조금 더 깔끔한 코드
  font-weight: 700;
`;

const SubTitleBadge = styled.div`
  width: 76px;
  height: 42px;
  border: 2px solid #1b1b1b;
  border-radius: 20px;
  line-height: 42px;
  text-align: center;
  margin-right: 15px;
`;

const SubTitle = () => {
  return (
    <SubTitleWrapper>
      <SubTitleBadge>기획전</SubTitleBadge>
      <SubTitleText>한 번 주문하면 두 번 반하는 반찬</SubTitleText>
    </SubTitleWrapper>
  );
};

export default SubTitle;
