import { useEffect, useRef, useState } from "react";
import styled from "styled-components";

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
    carouselRef.current.style.transform = `translateX(${
      (CARD_SIZE + CARD_GAP) * carouselPosRef.current * -1
    }px)`;
  };

  const checkActiveBtn = (count) => {
    carouselBtnRef.current = false;
    setCurrentCarouselCount(count);
  };

  const handleClickLeftBtn = () => {
    if (carouselBtnRef.current && currentCarouselCount > 1) {
      if (carouselBeforePosRef.current !== CARD_VISIBLE)
        carouselPosRef.current -= carouselBeforePosRef.current;
      else carouselPosRef.current -= CARD_VISIBLE;

      carouselBeforePosRef.current = CARD_VISIBLE;

      moveCarouselPos();
      checkActiveBtn(currentCarouselCount - 1);
    }
  };

  const handleClickRightBtn = () => {
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

  const handleTransitionEndBtn = () => {
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
                src={`${process.env.PUBLIC_URL}/images/${
                  currentCarouselCount === 1
                    ? "ModalCarouselLeftDisable.svg"
                    : "ModalCarouselLeft.svg"
                }`}
                onClick={handleClickLeftBtn}
              ></LeftBtn>
              <CurrentPage>{currentCarouselCount}</CurrentPage>
              <DividePage>/</DividePage>
              <TotalPage>{totalCarouselCount}</TotalPage>
              <RightBtn
                src={`${process.env.PUBLIC_URL}/images/${
                  currentCarouselCount === totalCarouselCount
                    ? "ModalCarouselRightDisable.svg"
                    : "ModalCarouselRight.svg"
                }`}
                onClick={handleClickRightBtn}
              ></RightBtn>
            </Counter>
          </Header>
          <CardCarousel>
            <CardCarouselInner
              ref={carouselRef}
              onTransitionEnd={handleTransitionEndBtn}
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

const Container = styled.div`
  padding: 4.8rem 4.8rem 0 4.8rem;
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Title = styled.h3`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
`;

const Counter = styled.div`
  display: flex;
  gap: 0.8rem;
`;

const Btn = styled.button`
  background-repeat: no-repeat;
  background-position: center;
  width: 2.4rem;
  border: none;
  background-color: ${({ theme }) => theme.color.white};
  cursor: pointer;
`;

const LeftBtn = styled(Btn)`
  background-image: url(${({ src }) => src});
`;

const RightBtn = styled(Btn)`
  background-image: url(${({ src }) => src});
`;

const PageText = styled.div`
  font-size: ${({ theme }) => theme.fontSize.small};
  line-height: 2.4rem;
`;

const CurrentPage = styled(PageText)`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
`;

const DividePage = styled(PageText)`
  font-weight: ${({ theme }) => theme.fontWeight.regular};
`;

const TotalPage = styled(DividePage)`
  font-weight: ${({ theme }) => theme.fontWeight.regular};
`;

const CardCarousel = styled.div`
  overflow: hidden;
  width: 86.4rem;
  height: 23.6rem;
  margin-top: 2.8rem;
`;

const CardCarouselInner = styled.div`
  display: flex;
  flex-wrap: nowrap;
  gap: ${({ gap }) => `${gap / 10}rem`};
  transition: all 1s;
`;

const Card = styled.div`
  flex-shrink: 0;
  flex-basis: ${({ size }) => `${size / 10}rem`};
  cursor: pointer;
`;

const CardImg = styled.img`
  width: 100%;
`;

const CardTitle = styled.h3`
  margin-top: 0.8rem;
  line-height: 2.4rem;
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.small};
  color: ${({ theme }) => theme.color.grey1};
`;

const CardPrices = styled.div`
  display: flex;
  gap: 0.8rem;
`;

const SPrice = styled.div`
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
`;

const NPrice = styled.div`
  font-size: ${({ theme }) => theme.fontSize.small};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  color: ${({ theme }) => theme.color.grey3};
  text-decoration: line-through;
`;

export default Carousel;
