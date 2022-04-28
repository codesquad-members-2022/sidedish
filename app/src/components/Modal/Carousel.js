import { useEffect, useRef, useState } from "react";
import {
  Container,
  Header,
  Title,
  Counter,
  LeftBtn,
  RightBtn,
  CurrentPage,
  DividePage,
  TotalPage,
  CardCarousel,
  CardCarouselInner,
  Card,
  CardImg,
  CardTitle,
  CardPrices,
  SPrice,
  NPrice,
} from "../../styles/Modal/Carousel.js";

const Carousel = () => {
  const CARD_VISIBLE = 5;
  const CARD_GAP = 16;
  const CARD_SIZE = 160;

  const [cardCount, setCardCount] = useState();
  const [carouselDish, setCarouselDish] = useState();
  const [currentCarouselCount, setCurrentCarouselCount] = useState(1);
  const totalCarouselCount =
    cardCount % CARD_VISIBLE === 0
      ? parseInt(cardCount / CARD_VISIBLE)
      : parseInt(cardCount / CARD_VISIBLE) + 1;
  const carouselRef = useRef();
  const carouselBtnRef = useRef(true);
  const carouselPosRef = useRef(0);
  const carouselBeforePosRef = useRef(0);

  useEffect(() => {
    (async () => {
      const res = await fetch("https://api.codesquad.kr/onban/main");
      const data = await res.json();
      setCarouselDish(data.body);
      setCardCount(data.body.length);
    })();
  }, []);

  const moveCarouselPos = () => {
    // eslint-disable-next-line prettier/prettier
    carouselRef.current.style.transform = `translateX(${(CARD_SIZE + CARD_GAP) * carouselPosRef.current * -1
      // eslint-disable-next-line prettier/prettier
      }px)`;
  };

  const checkActiveBtn = (count) => {
    carouselBtnRef.current = false;
    setCurrentCarouselCount(count);
  };

  const handleLeftBtnClick = () => {
    if (carouselBtnRef.current && currentCarouselCount > 1) {
      if (carouselBeforePosRef.current !== CARD_VISIBLE)
        carouselPosRef.current -= carouselBeforePosRef.current;
      else carouselPosRef.current -= CARD_VISIBLE;

      carouselBeforePosRef.current = CARD_VISIBLE;

      moveCarouselPos();
      checkActiveBtn(currentCarouselCount - 1);
    }
  };

  const handleRightBtnClick = () => {
    if (carouselBtnRef.current && currentCarouselCount < totalCarouselCount) {
      const cardRemain = cardCount - CARD_VISIBLE - carouselPosRef.current;

      if (cardRemain > CARD_VISIBLE) {
        carouselPosRef.current += CARD_VISIBLE;
        carouselBeforePosRef.current = CARD_VISIBLE;
      } else {
        carouselPosRef.current += cardRemain;
        carouselBeforePosRef.current = cardRemain;
      }

      moveCarouselPos();
      checkActiveBtn(currentCarouselCount + 1);
    }
  };

  const handleBtnTransitionEnd = () => {
    carouselBtnRef.current = true;
  };

  return (
    <>
      {carouselDish && (
        <Container>
          <Header>
            <Title>함께하면 더욱 맛있는 상품</Title>
            <Counter>
              <LeftBtn
                // eslint-disable-next-line prettier/prettier
                src={`${process.env.PUBLIC_URL}/images/${currentCarouselCount === 1 ? "ModalCarouselLeftDisable.svg" : "ModalCarouselLeft.svg"
                  // eslint-disable-next-line prettier/prettier
                  }`}
                onClick={handleLeftBtnClick}
              ></LeftBtn>
              <CurrentPage>{currentCarouselCount}</CurrentPage>
              <DividePage>/</DividePage>
              <TotalPage>{totalCarouselCount}</TotalPage>
              <RightBtn
                // eslint-disable-next-line prettier/prettier
                src={`${process.env.PUBLIC_URL}/images/${currentCarouselCount === totalCarouselCount ? "ModalCarouselRightDisable.svg" : "ModalCarouselRight.svg"
                  // eslint-disable-next-line prettier/prettier
                  }`}
                onClick={handleRightBtnClick}
              ></RightBtn>
            </Counter>
          </Header>
          <CardCarousel>
            <CardCarouselInner
              ref={carouselRef}
              onTransitionEnd={handleBtnTransitionEnd}
              gap={CARD_GAP}
            >
              {carouselDish.map((e) => {
                return (
                  <Card key={e.detail_hash} size={CARD_SIZE}>
                    <CardImg src={e.image} />
                    <CardTitle>{e.title}</CardTitle>
                    {e.n_price ? (
                      <CardPrices>
                        <SPrice>{e.s_price}</SPrice>
                        <NPrice>{e.n_price}</NPrice>
                      </CardPrices>
                    ) : (
                      <CardPrices>
                        <SPrice>{e.s_price}</SPrice>
                      </CardPrices>
                    )}
                  </Card>
                );
              })}
            </CardCarouselInner>
          </CardCarousel>
        </Container>
      )}
    </>
  );
};

export default Carousel;
