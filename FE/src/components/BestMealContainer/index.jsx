import React, { useCallback, useState, useEffect } from "react";
import axios from "axios";
import Loader from "components/Loader";
import MealCard from "components/MealCard";
import { MOCK_SERVER_URL } from "constants";
import { CardContainer, Container, Divider, Header, Nav, Tab } from "./style";

const BEST_TITLE_BADGE = "기획전";
const BEST_TITLE = "한 번 주문하면 두 번 반하는 반찬";

const BEST_TAB_TYPE = [
  { id: 100, title: "풍성한 고기 반찬", apiParams: "meat" },
  { id: 123, title: "편리한 반찬 세트", apiParams: "easy" },
  { id: 313, title: "맛있는 제철 요리", apiParams: "season" },
  { id: 153, title: "우리 아이 영양 반찬", apiParams: "kids" },
];
const DEFAULT_TAB_ID = 100;
const BEST_MEAL_IMAGE_SIZE = 411;

const BestMealContainer = () => {
  const [meals, setMeals] = useState([]);
  const [tabId, setTabId] = useState(DEFAULT_TAB_ID);
  const [activeTab, setActiveTab] = useState({
    id: "",
    apiParams: "",
  });

  const fetchData = useCallback(async () => {
    try {
      const { data } = await axios.get(`${MOCK_SERVER_URL}/products/best?category=${activeTab.apiParams}`, {
        validateStatus: (status) => {
          return status >= 200 && status < 300;
        },
      });
      setMeals(data);
    } catch (error) {
      // BUG: 개발 과정에서 mock server나 api 에러가 났을 때 constant의 mock데이터 사용
      console.error(error);
    }
  }, [tabId]);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  const Tabs = () =>
    BEST_TAB_TYPE.map(({ id, title, apiParams }) => (
      <Tab
        key={id}
        onClick={() =>
          setActiveTab({
            id,
            apiParams,
          })
        }
        isSelected={tabId === id}
      >
        {title}
      </Tab>
    ));

  const BestMealCards = () =>
    meals.map(({ id, ...mealInfo }) => <MealCard key={id} mealInfo={mealInfo} size={BEST_MEAL_IMAGE_SIZE} />);

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
      <CardContainer>{meals.length ? <BestMealCards /> : <Loader />}</CardContainer>
    </Container>
  );
};

export default BestMealContainer;
