import { useState } from "react";
import styled from "styled-components";
import ItemCards from "./ItemCards";
import Label from "./Label";
import mockData from "./mockData";
import constants from "./constants";

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
  const lnb = mockData.lnb;
  const [lnbState, setLnbState] = useState(lnb[0]);
  const [dataState, setDataState] = useState(mockData.data);

  const handleLnbState = (event) => {
    setLnbState((lnbState) => (lnbState = event.target.textContent));
    if (event.target.textContent === lnb[0]) {
      setDataState((dataState) => (dataState = mockData.data));
    } else if (event.target.textContent === lnb[1]) {
      setDataState((dataState) => (dataState = mockData.data2));
    } else if (event.target.textContent === lnb[2]) {
      setDataState((dataState) => (dataState = mockData.data3));
    } else {
      setDataState((dataState) => (dataState = mockData.data4));
    }
  };

  const mainLnb = (
    <MainLnbContainer>
      {lnb.map((title, ind) => (
        <MainLnb onClick={handleLnbState} title={title} lnbState={lnbState} key={ind}>
          {title}
        </MainLnb>
      ))}
    </MainLnbContainer>
  );

  return (
    <MainContainer>
      <MainTitleContainer>
        <Label {...constants.EXHIBITION_LABEL_ATTRIBUTES} />
        <Title>한 번 주문하면 두 번 반하는 반찬</Title>
      </MainTitleContainer>
      {mainLnb}
      <ItemCards dataState={dataState} len={constants.BIG_CARD_LENGHT} />
    </MainContainer>
  );
};

export default Main;
