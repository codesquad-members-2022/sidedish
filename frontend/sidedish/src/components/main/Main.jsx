import { useEffect, useState } from "react";
import styled from "styled-components";
import ItemCards from "../itemCard/ItemCards";
import Label from "../../core/Label";
import {
  LABEL_ATTRIBUTES,
  CARD_LENGHTHS,
  NUM_OF_CARD_ON_DISPLAY,
  CARD_MARGIN,
  CARD_CONTAINER_PADDING,
  URL,
} from "../../consts/constants";
import Carousel from "./Carousel";
import DivisionLine from "../../core/Line";
import Popup from "../popup/Popup";
import relatedMockData from "../../relatedListMockData.json";
import fetchData from "../../util/fetchData.js";

const Main = () => {
  const [lnbStateArr, setLnbStateArr] = useState([]);
  const [lnbState, setLnbState] = useState("");
  const [dataState, setDataState] = useState([]);
  const [carouselData, setCarouselData] = useState();
  const [relatedListState, setRelatedListState] = useState(relatedMockData);
  const [allCategoryVisible, setAllCategoryVisible] = useState(false);
  const [cardClickState, setCardClickState] = useState(false);
  const [cardInfoState, setCardInfoState] = useState({
    /* ... */
  });

  const handleLnbState = (event) => {
    setLnbState((lnbState) => (lnbState = event.target.textContent));
    if (event.target.textContent === lnbStateArr[0].name) {
      fetchCardData("meat");
    } else if (event.target.textContent === lnbStateArr[1].name) {
      fetchCardData("side");
    } else if (event.target.textContent === lnbStateArr[2].name) {
      fetchCardData("season");
    } else {
      fetchCardData("kids");
    }
  };

  const handleAllCategoryVisible = () => {
    setAllCategoryVisible(true);
  };

  const fetchLnb = async () => {
    const lnbData = await fetchData(`${URL}/categorynames`);
    setLnbStateArr(lnbData.categorynames);
    setLnbState(lnbData.categorynames[0].name);
  };

  const fetchCardData = async (foodType) => {
    const cardData = await fetchData(`${URL}?event-tabs=${foodType}`);
    setDataState(cardData.dishes);
  };

  const fetchCarouselData = async () => {
    const carouselDataa = await fetchData("carouselMockData.json");
    setCarouselData(carouselDataa);
  };

  useEffect(() => {
    fetchLnb();
    fetchCardData("meat");
    fetchCarouselData();
  }, []);

  const mainLnb = (
    <MainLnbContainer>
      {lnbStateArr.map(({ name, id }) => (
        <MainLnb onClick={handleLnbState} title={name} lnbState={lnbState} key={id}>
          {name}
        </MainLnb>
      ))}
    </MainLnbContainer>
  );

  return (
    <>
      <MainContainer>
        <MainTitleContainer>
          <Label {...LABEL_ATTRIBUTES.EXHIBITION} />
          <Title>한 번 주문하면 두 번 반하는 반찬</Title>
        </MainTitleContainer>
        {mainLnb}
        <ItemCards
          cardClickState={cardClickState}
          setCardClickState={setCardClickState}
          // cardInfoState={cardInfoState}
          // setCardInfoState={setCardInfoState}
          dataState={dataState}
          cardLength={CARD_LENGHTHS.BIG}
          cardMargin={CARD_MARGIN}
          cardContainerPadding={CARD_CONTAINER_PADDING}
        />
        <DivisionLine height="1px" color="#EBEBEB" />

        <CarouselContainer allCategoryVisible={true}>
          <CarouselTitle>{carouselData?.categories[0]?.categoryName}</CarouselTitle>
          <Carousel
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            carouselCards={carouselData?.categories[0]?.dishes}
            cardLength={CARD_LENGHTHS.SMALL}
            cardCount={NUM_OF_CARD_ON_DISPLAY}
            cardMargin={CARD_MARGIN}
          />
        </CarouselContainer>

        <CarouselContainer allCategoryVisible={allCategoryVisible}>
          <CarouselTitle>{carouselData?.categories[1]?.categoryName}</CarouselTitle>
          <Carousel
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            carouselCards={carouselData?.categories[1]?.dishes}
            cardLength={CARD_LENGHTHS.SMALL}
            cardCount={NUM_OF_CARD_ON_DISPLAY}
            cardMargin={CARD_MARGIN}
          />
        </CarouselContainer>
        <CarouselContainer allCategoryVisible={allCategoryVisible}>
          <CarouselTitle>{carouselData?.categories[2].categoryName}</CarouselTitle>
          <Carousel
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            carouselCards={carouselData?.categories[2]?.dishes}
            cardLength={CARD_LENGHTHS.SMALL}
            cardCount={NUM_OF_CARD_ON_DISPLAY}
            cardMargin={CARD_MARGIN}
          />
        </CarouselContainer>

        <OpenAllCategoryButton
          openAllCategoryButtonVisible={!allCategoryVisible}
          onClick={handleAllCategoryVisible}
        >
          모든 카테고리 보기
        </OpenAllCategoryButton>
        <Popup
          cardClickState={cardClickState}
          setCardClickState={setCardClickState}
          cardInfoState={cardInfoState}
          relatedListState={relatedListState}
          setRelatedListState={setRelatedListState}
        />
      </MainContainer>
    </>
  );
};

const MainContainer = styled.main`
  // display: flex;
  // flex-direction: column;
  white-space: nowrap;
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

const CarouselContainer = styled.div`
  display: ${(props) => (props.allCategoryVisible ? "block" : "none")};
`;

const CarouselTitle = styled.h1`
  font-family: "Noto Sans KR";
  font-weight: 500;
  font-size: 24px;
  color: #333;
  margin-left: 80px;
  padding: 56px 0 40px 0;
`;

const OpenAllCategoryButton = styled.div`
  font-size: 20px;
  padding: 16px 24px;
  line-height: 30px;
  text-align: center;
  width: 155px;
  margin: 55px auto;
  color: #3f3f3f;
  border: 1px solid #ebebeb;
  cursor: pointer;
  display: ${(props) => (props.openAllCategoryButtonVisible ? "block" : "none")};
`;

export default Main;
