import styled from "styled-components";
import { Label } from "./Label";

const MainContainer = styled.main`
  display: flex;
  flex-direction: column;
`;

const MainTitleContainer = styled.div`
  padding: 66px 80px;
  display: flex;
  align-items: center;
`;

const Title = styled.h1`
  display: inline-block;
  font-family: "Noto Sans KR";
  font-weight: 700;
  font-size: 40px;
  color: #1b1b1b;
  padding: 0 0 0 16px;
`;

const Main = () => {
  return (
    <MainContainer>
      <MainTitleContainer>
        <Label string="기획전" color="black" fontSize="16px" backgroundColor="white" borderColor="black" padding="12px 12px"></Label>
        <Title>한 번 주문하면 두 번 반하는 반찬</Title>
      </MainTitleContainer>
    </MainContainer>
  );
};

export default Main;
