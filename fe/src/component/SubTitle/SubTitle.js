import React from "react";
import styled from "styled-components";

const Wrapper = styled.div`
  display: flex;
  align-items: center;
  padding: 40px 40px 0px;
`;
const Text = styled.h2`
  font-size: ${({ theme }) => theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.display};
`;

const Badge = styled.div`
  width: 76px;
  height: 42px;
  border: 2px solid ${({ theme }) => theme.colors.black};
  border-radius: 20px;
  line-height: 42px;
  text-align: center;
  margin-right: 15px;
`;

const SubTitle = () => {
  return (
    <Wrapper>
      <Badge>기획전</Badge>
      <Text>한 번 주문하면 두 번 반하는 반찬</Text>
    </Wrapper>
  );
};

export default SubTitle;
