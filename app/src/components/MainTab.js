import { useEffect, useState } from "react";
import styled from "styled-components";
import theme from "../styles/theme.js";
import CardList from "./CardList.js";
import { FlexMarginCenter } from "../styles/utils.js";
import { Horizon } from "../styles/utils.js";

const Wrapper = styled.div`
  width: calc(144rem - 8rem * 2);
  margin: 0 auto;
`;

const Header = styled(FlexMarginCenter)`
  box-sizing: border-box;
  width: 144rem;
  gap: 1.6rem;
  padding: 5.6rem 8rem 0;
`;

const Badge = styled.div`
  box-sizing: border-box;
  width: 7.6rem;
  height: 4.2rem;
  text-align: center;
  line-height: 3.6rem;
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  border: 0.2rem solid ${({ theme }) => theme.color.black};
  border-radius: 99.9rem;
`;

const Title = styled.h2`
  font-size: ${({ theme }) => theme.fontSize.display};
  font-weight: ${({ theme }) => theme.fontWeight.display};
`;

const Main = styled.div`
  .tab-item {
    padding-bottom: 1.6rem;
    cursor: pointer;
  }

  .active {
    border-bottom: 1px solid ${({ theme }) => theme.color.black};
  }
`;

const Tab = styled(FlexMarginCenter)`
  box-sizing: border-box;
  width: 144rem;
  display: flex;
  margin-top: 2.4rem;
  gap: 3.2rem;
  font-size: ${({ theme }) => theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  line-height: 3rem;
  padding-left: 8rem;
`;

const TAB_TEXTS = [
  "풍성한 고기 반찬",
  "편리한 반찬 세트",
  "맛있는 제철 요리",
  "우리 아이 영양 반찬",
];
const TAB_KEYS = ["meat", "convenient", "season", "nutrition"];

const MainTab = ({ dish }) => {
  console.log(dish);
  const [tabNumber, setTabNumber] = useState(0);
  const [tabCards, setTabCards] = useState([]);

  useEffect(() => {
    if (dish.length === 0) return;

    const shuffle = selectDish();
    const shuffleCards = ShuffleCards(shuffle);
    setTabCards(shuffleCards);
  }, [dish]);

  const selectDish = () => {
    const seletedDish = [...dish].sort(() => Math.random() - 0.5);
    return seletedDish;
  };

  const ShuffleCards = (shuffle) => {
    const tabCards = [];
    for (let i = 0, count = 0; i < TAB_TEXTS.length; i++) {
      tabCards[i] = shuffle.slice(count, count + 3);
      count += 3;
    }

    return tabCards;
  };

  const handleTabClick = (index) => {
    setTabNumber(index);
  };

  return (
    <>
      <Header>
        <Badge>
          <strong>기획전</strong>
        </Badge>
        <Title>한 번 주문하면 두 번 반하는 반찬</Title>
      </Header>
      <Main>
        <Tab as={"ul"}>
          {TAB_TEXTS.map((text, index) => {
            return (
              <li
                key={index}
                className={`tab-item ${tabNumber === index ? "active" : null}`}
                onClick={() => handleTabClick(index)}
              >
                {text}
              </li>
            );
          })}
        </Tab>
        <Horizon />
        <Wrapper>
          {tabCards.map((cards, index) => (
            <CardList
              key={TAB_KEYS[index]}
              cards={cards}
              tabNumber={tabNumber}
              index={index}
              cardSize={theme.cardSize.large}
              gap={theme.cardSize.gap}
            />
          ))}
        </Wrapper>
        <Horizon />
      </Main>
    </>
  );
};

export default MainTab;
