import { useState } from "react";
import styled from "styled-components";
import ItemCards from "../itemCard/ItemCards";
import Label from "../../core/Label";
import mockData from "../../mockData.json";
import carouselMockData from "../../carouselMockData.json";
import { LABEL_ATTRIBUTES, CARD_LENGHTHS, NUM_OF_CARD_ON_DISPLAY, CARD_MARGIN, CARD_CONTAINER_PADDING } from "../../consts/constants";
import Carousel from "./Carousel";
import DivisionLine from "../../core/Line";
import Popup from "../popup/Popup";
import relatedMockData from "../../relatedListMockData.json";

const Main = () => {
  const lnb = mockData.lnb;
  const [lnbState, setLnbState] = useState(lnb[0]);
  const [dataState, setDataState] = useState(mockData.data);
  // const [carouselState, setCarouselDataState] = useState(carouselMockData);
  const [relatedListState, setRelatedListState] = useState(relatedMockData);
  const [allCategoryVisible, setAllCategoryVisible] = useState(false);

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

  const handleAllCategoryVisible = () => {
    setAllCategoryVisible(true);
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

  const [cardClickState, setCardClickState] = useState(false);
  const [cardInfoState, setCardInfoState] = useState({
    /* ... */
  });

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
          <CarouselTitle>식탁을 풍성하게 하는 정갈한 밑반찬</CarouselTitle>
          <Carousel
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            carouselCards={carouselMockData.carouselCardData}
            cardLength={CARD_LENGHTHS.SMALL}
            cardCount={NUM_OF_CARD_ON_DISPLAY}
            cardMargin={CARD_MARGIN}
          />
        </CarouselContainer>
        <CarouselContainer allCategoryVisible={allCategoryVisible}>
          <CarouselTitle>식탁을 풍성하게 하는 정갈한 밑반찬</CarouselTitle>
          <Carousel
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            carouselCards={carouselMockData.carouselCardData}
            cardLength={CARD_LENGHTHS.SMALL}
            cardCount={NUM_OF_CARD_ON_DISPLAY}
            cardMargin={CARD_MARGIN}
          />
        </CarouselContainer>
        <CarouselContainer allCategoryVisible={allCategoryVisible}>
          <CarouselTitle>식탁을 풍성하게 하는 정갈한 밑반찬</CarouselTitle>
          <Carousel
            cardClickState={cardClickState}
            setCardClickState={setCardClickState}
            carouselCards={carouselMockData.carouselCardData}
            cardLength={CARD_LENGHTHS.SMALL}
            cardCount={NUM_OF_CARD_ON_DISPLAY}
            cardMargin={CARD_MARGIN}
          />
        </CarouselContainer>
        <OpenAllCategoryButton openAllCategoryButtonVisible={!allCategoryVisible} onClick={handleAllCategoryVisible}>
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
