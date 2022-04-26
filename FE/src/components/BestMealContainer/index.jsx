import React, { useCallback, useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import styled, { css } from "styled-components";
import BestMealCard from "components/BestMealCard";
import Loader from "components/Loader";

import { MOCK_SERVER_URL } from "constants";

function BestMealContainer() {
  const BEST_TITLE_BADGE = "기획전";
  const BEST_TITLE = "한 번 주문하면 두 번 반하는 반찬";
  const BEST_SUBTITLE = ["풍성한 고기 반찬", "편리한 반찬 세트", "맛있는 제철 요리", "우리 아이 영양 반찬"];

  const [meals, setMeals] = useState([]);
  const [tab, setTab] = useState(0);
  console.log(tab);
  // 저기
  const fetchData = useCallback(async () => {
    try {
      const { data } = await axios.get(`${MOCK_SERVER_URL}/api/products/best?category=${tab}`, {
        validateStatus: (status) => {
          return status >= 200 && status < 300;
        },
      });
      setMeals(data);
    } catch (error) {
      console.error(error);
    }
  }, [tab]);

  useEffect(() => {
    // 여기
    // fetchData();
  }, []);

  const BestMealCards = () => meals.map(({ id, ...meal }) => <BestMealCard key={id} meal={meal} />);
  const Tabs = ({ subTitle, index }) => (
    <Li key={subTitle} onClick={() => setTab(index)} isSelected={tab === index}>
      {subTitle}
    </Li>
  );

  return (
    <Container>
      <Header>
        <TitleBadge>{BEST_TITLE_BADGE}</TitleBadge>
        <Title>{BEST_TITLE}</Title>
      </Header>
      <Nav>
        {BEST_SUBTITLE.map((subTitle, index) => (
          <Tabs subTitle={subTitle} index={index} />
        ))}
      </Nav>
      <CardContainer>{meals.length ? <BestMealCards /> : <Loader />}</CardContainer>
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 24px;
`;

const Header = styled.header`
  display: flex;
  align-items: flex-start;
  gap: 16px;
`;

const TitleBadge = styled.div`
  width: 76px;
  height: 42px;
  background: ${({ theme }) => theme.color.offWhite};
  border: 2px solid ${({ theme }) => theme.color.black};
  box-sizing: border-box;
  border-radius: 999px;
  line-height: 42px;
  text-align: center;
`;

const Title = styled.h2`
  font-size: ${({ theme }) => theme.fontSize.biggest};
  font-weight: ${({ theme }) => theme.fontWeight.display};
`;

const Nav = styled.ul`
  display: flex;
  gap: 32px;
  border-bottom: 1px solid ${({ theme }) => theme.color.grey4};
  padding-bottom: 17px;

  li {
    cursor: pointer;
  }
`;

const Li = styled.li`
  cursor: pointer;
  ${({ isSelected }) =>
    isSelected &&
    css`
      color: red;
      background: darkblue;
    `};
  color: ${({ isSelected }) => isSelected && "red"};
`;

const CardContainer = styled.div`
  display: flex;
`;

export default BestMealContainer;
