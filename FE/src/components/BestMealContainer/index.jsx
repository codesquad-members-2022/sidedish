import React, { useCallback, useState, useEffect } from "react";
import axios from "axios";
import Loader from "components/Loader";
import MealCard from "components/MealCard";
import { MOCK_BEST_MEAT, MOCK_SERVER_URL } from "constants";
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

  const findTargetTab = useCallback((id) => {
    const targetTab = BEST_TAB_TYPE.find((tabObj) => tabObj.id === id);
    if (!targetTab) {
      return Error("해당 탭 정보가 없습니다.");
    }
    const categoryType = targetTab.apiParams;
    return categoryType;
  }, []);

  const fetchData = useCallback(async () => {
    try {
      const categoryType = findTargetTab(tabId);
      const { data } = await axios.get(`${MOCK_SERVER_URL}/api/products/best?category=${categoryType}`, {
        validateStatus: (status) => {

          return status >= 200 && status < 300;
        },
      });
      setMeals(data);
    } catch (error) {
      // BUG: 개발 과정에서 mock server나 api 에러가 났을 때 constant의 mock데이터 사용
      console.error(error);
      setMeals(MOCK_BEST_MEAT);
    }
  }, [findTargetTab, tabId]);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  const Tabs = () =>
    BEST_TAB_TYPE.map(({ id, title }) => (
      <Tab key={id} onClick={() => setTabId(id)} isSelected={tabId === id}>
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
