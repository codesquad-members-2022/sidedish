import React, { useState } from "react";
import Loader from "components/Loader";
import MealCard from "components/MealCard";
import { CardContainer, Container, Divider, Header, Nav, Tab } from "./style";
import { useAxios } from "hooks/useAxios";

const BEST_MEAL_IMAGE_SIZE = 411;

const BEST_TITLE_BADGE = "기획전";
const BEST_TITLE = "한 번 주문하면 두 번 반하는 반찬";
const BEST_TAB_TYPE = [
  { id: 100, title: "풍성한 고기 반찬", apiParams: "meat" },
  { id: 123, title: "편리한 반찬 세트", apiParams: "easy" },
  { id: 313, title: "맛있는 제철 요리", apiParams: "season" },
  { id: 153, title: "우리 아이 영양 반찬", apiParams: "kids" },
];

const BestMealContainer = () => {
  const [activeTab, setActiveTab] = useState(BEST_TAB_TYPE[0]);

  const { response: meals } = useAxios({
    method: "get",
    url: `/products/best`,
    params: { category: activeTab.apiParams },
  });

  const Tabs = () =>
    BEST_TAB_TYPE.map(({ id, title, apiParams }) => (
      <Tab
        key={id}
        onClick={() =>
          setActiveTab({
            id,
            title,
            apiParams,
          })
        }
        isSelected={activeTab.id === id}
      >
        {title}
      </Tab>
    ));

  const BestMealCards = () =>
    meals.map((mealInfo) => <MealCard key={mealInfo.id} mealInfo={mealInfo} size={BEST_MEAL_IMAGE_SIZE} />);

  return (
    <Container>
      <Header>
        <div>{BEST_TITLE_BADGE}</div>
        <h2>{BEST_TITLE}</h2>
      </Header>
      <Nav>
        <Tabs />
      </Nav>
      <Divider />
      <CardContainer>{meals ? <BestMealCards /> : <Loader />}</CardContainer>
    </Container>
  );
};

export default BestMealContainer;
