import styled from "styled-components";
import Card from "../UI/Card";
import { useState, useEffect } from "react";
import { LeftIcon, RightIcon } from "../icons/SlideIcon";

const ModalSlideWrppaer = styled.div`
  height: 313px;
  padding-top: 30px;
`;

const SlideNav = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const SlideTitle = styled.span`
  font-size: 20px;
  margin-bottom: 20px;
`;

const SlideIconBox = styled.span`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const SlidePageText = styled.span`
  padding: 0 10px;
  font-size: 14px;
  line-height: 5px;
`;

const SlideCardWrapper = styled.div`
  position: absolute;
  width: 895px;
  height: 250px;
  margin-top: 10px;
  overflow: hidden;
`;

const SlideCardsList = styled.div`
  display: flex;
  transform: translateX(${({ currentTranslateX }) => currentTranslateX});
`;

const ModalSlider = () => {
  const [cards, setCards] = useState([]);
  const [cardListTranslateX, setCardListTranslateX] = useState(0);
  const [pageNum, setPageNum] = useState(1);
  useEffect(() => {
    fetch("https://api.codesquad.kr/onban/side")
      .then((res) => res.json())
      .then((res) => setCards(res.body));
  }, []);

  const max = -920;
  const maxPage = Math.ceil((166 * cards.length) / 895);

  const leftIconClickHandler = () => {
    setCardListTranslateX((prev) => prev <= 0 && 0);
    setPageNum((prev) => (prev >= maxPage ? prev - 1 : prev));
  };

  const rightIconClickHandler = () => {
    setCardListTranslateX((prev) => prev >= max && max);
    setPageNum((prev) => (prev < maxPage ? prev + 1 : prev));
  };

  return (
    <ModalSlideWrppaer>
      <SlideNav>
        <SlideTitle>함께하면 더욱 맛있는 상품</SlideTitle>
        <SlideIconBox>
          <LeftIcon
            onClick={leftIconClickHandler}
            current={cardListTranslateX}
            min={0}
          />
          <SlidePageText>{pageNum}</SlidePageText>
          <SlidePageText> /</SlidePageText>
          <SlidePageText> 2</SlidePageText>
          <RightIcon
            onClick={rightIconClickHandler}
            current={cardListTranslateX}
            max={max}
          />
        </SlideIconBox>
      </SlideNav>

      <SlideCardWrapper>
        <SlideCardsList
          currentTranslateX={cardListTranslateX.toString() + "px"}
        >
          {cards.map((v) => (
            <Card
              size="xSmall"
              key={v.detail_hash}
              image={v.image}
              alt={v.alt}
              title={v.title}
              s_price={v.s_price}
              n_price={v.n_price}
            />
          ))}
        </SlideCardsList>
      </SlideCardWrapper>
    </ModalSlideWrppaer>
  );
};

export default ModalSlider;
