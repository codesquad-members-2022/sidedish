import { useState } from "react";
import styled from "styled-components";
import Label from "./Label";

const MainContainer = styled.main`
  display: flex;
  flex-direction: column;
`;

const MainTitleContainer = styled.div`
  padding: 66px 80px 33px 80px;
  display: flex;
  align-items: center;
`;

const Title = styled.h1`
  display: inline-block;
  font-family: "Noto Sans KR";
  font-weight: 700;
  font-size: 40px;
  color: #1b1b1b;
  padding-left: 16px;
`;

const MainLnbContainer = styled.ul`
  display: flex;
  border-bottom: 1px solid #ebebeb;
  padding-left: 48px;
`;
const MainLnb = styled.li`
  font-family: "Noto Sans KR";
  font-style: normal;
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  margin: 0 32px;
  padding-bottom: 17px;
  cursor: pointer;

  border-bottom: ${(props) => (props.title === props.lnbState ? "black solid 1px" : "")};
`;

const Main = () => {
  const data = ["풍성한 고기 반찬", "편리한 반찬 세트", "맛있는 제철 요리", "우리 아이 영양 반찬"];
  const [lnbState, setLnbState] = useState(data[0]);

  const handleLnbState = (event) => {
    setLnbState((lnbState) => (lnbState = event.target.textContent));
  };

  return (
    <MainContainer>
      <MainTitleContainer>
        <Label string="기획전" color="black" fontSize="16px" backgroundColor="white" borderColor="black" padding="12px 12px"></Label>
        <Title>한 번 주문하면 두 번 반하는 반찬</Title>
      </MainTitleContainer>
      <MainLnbContainer>
        {data.map((title, ind) => (
          <MainLnb onClick={handleLnbState} title={title} lnbState={lnbState} key={ind}>
            {title}
          </MainLnb>
        ))}
      </MainLnbContainer>
    </MainContainer>
  );
};

export default Main;
