import styled from "styled-components";
import { useEffect, useState } from "react";
import { CardList } from "./CardList";
import { SIZES } from "../convention";

const Wrapper = styled.div`
  padding: 56px 80px;
`;

const TitleWrapper = styled.div`
  display: flex;
  align-items: center;
`;

const TitleBadge = styled.div`
  border: 2px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 999px;
  background: #f8f7f7;
  margin-right: 16px;
  padding: 8px 16px;
  font-weight: 500;
  line-height: 26px;
`;

const Title = styled.div`
  font-weight: 700;
  font-size: 40px;
  line-height: 58px;
  letter-spacing: -0.004em;
`;

const TabBar = styled.ul`
  margin-top: 24px;
  display: flex;
`;

const TabItem = styled.li`
  margin-right: 32px;
  padding-bottom: 17px;
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  display: flex;
  align-items: center;
  text-align: center;
  letter-spacing: -0.008em;
  ${(props) => props.selected && `border-bottom: 1px solid black;`}
`;

export const BestProduct = ({ themes }) => {
  const [selected, setSelected] = useState(themes[0].id);

  return (
    <Wrapper>
      <TitleWrapper>
        <TitleBadge>기획전</TitleBadge>
        <Title>한 번 주문하면 두 번 반하는 반찬</Title>
      </TitleWrapper>
      <TabBar>
        {themes.map((theme) => (
          <TabItem key={theme.id} selected={selected === theme.id}>
            {theme.name}
          </TabItem>
        ))}
      </TabBar>
      <CardList size={SIZES.large} special={true} id={selected}></CardList>
    </Wrapper>
  );
};
