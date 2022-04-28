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
  const arr = [
    {
      detail_hash: "HBDEF",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
      alt: "오리 주물럭_반조리",
      delivery_type: ["새벽배송", "전국택배"],
      title: "오리 주물럭_반조리",
      description: "감칠맛 나는 매콤한 양념",
      n_price: "15,800원",
      s_price: "12,640원",
      badge: ["런칭특가"],
    },
    {
      detail_hash: "HDF73",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/310_ZIP_P_0012_T.jpg",
      alt: "잡채",
      delivery_type: ["새벽배송", "전국택배"],
      title: "잡채",
      description: "탱글한 면발과 맛깔진 고명이 가득",
      n_price: "12,900원",
      s_price: "11,610원",
      badge: ["이벤트특가"],
    },
    {
      detail_hash: "HF778",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg",
      alt: "소갈비찜",
      delivery_type: ["새벽배송", "전국택배"],
      title: "소갈비찜",
      description: "촉촉하게 밴 양념이 일품",
      n_price: "28,900원",
      s_price: "26,010원",
      badge: ["이벤트특가", "메인특가"],
    },
    {
      detail_hash: "HFB53",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/371_ZIP_P_0021_T.jpg",
      alt: "간장 코다리조림",
      delivery_type: ["새벽배송", "전국택배"],
      title: "간장 코다리조림",
      description: "쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요",
      s_price: "14,900원",
    },
    {
      detail_hash: "H077F",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg",
      alt: "꼬막비빔밥",
      delivery_type: ["새벽배송", "전국택배"],
      title: "꼬막비빔밥",
      description: "매콤하게 입맛 돋우는",
      s_price: "10,900원",
      badge: ["런칭특가", "이벤트특가", "메인특가"],
    },
    {
      detail_hash: "H4665",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/675_ZIP_P_0057_T.jpg",
      alt: "궁중 떡볶이_반조리",
      delivery_type: ["새벽배송", "전국택배"],
      title: "궁중 떡볶이_반조리",
      description: "영양 듬뿍 프리미엄 간장 떡볶이",
      s_price: "7,800원",
    },
    {
      detail_hash: "H1AA9",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg",
      alt: "초계국수_쿠킹박스",
      delivery_type: ["새벽배송", "전국택배"],
      title: "초계국수_쿠킹박스",
      description: "건강한 가정 간편식 여름 국수",
      s_price: "11,800원",
    },
    {
      detail_hash: "HEDFB",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg",
      alt: "쭈꾸미 한돈 제육볶음_반조림",
      delivery_type: ["새벽배송", "전국택배"],
      title: "쭈꾸미 한돈 제육볶음_반조림",
      description: "쫄깃한 쭈꾸미와 고소한 돼지고기가 일품",
      s_price: "16,900원",
    },
    {
      detail_hash: "H077F2",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg",
      alt: "꼬막비빔밥",
      delivery_type: ["새벽배송", "전국택배"],
      title: "꼬막비빔밥",
      description: "매콤하게 입맛 돋우는",
      s_price: "10,900원",
      badge: ["런칭특가", "이벤트특가", "메인특가"],
    },
    {
      detail_hash: "H46653",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/675_ZIP_P_0057_T.jpg",
      alt: "궁중 떡볶이_반조리",
      delivery_type: ["새벽배송", "전국택배"],
      title: "궁중 떡볶이_반조리",
      description: "영양 듬뿍 프리미엄 간장 떡볶이",
      s_price: "7,800원",
    },
    {
      detail_hash: "H1AA94",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg",
      alt: "초계국수_쿠킹박스",
      delivery_type: ["새벽배송", "전국택배"],
      title: "초계국수_쿠킹박스",
      description: "건강한 가정 간편식 여름 국수",
      s_price: "11,800원",
    },
    {
      detail_hash: "HEDFB5",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg",
      alt: "쭈꾸미 한돈 제육볶음_반조림",
      delivery_type: ["새벽배송", "전국택배"],
      title: "쭈꾸미 한돈 제육볶음_반조림",
      description: "쫄깃한 쭈꾸미와 고소한 돼지고기가 일품",
      s_price: "16,900원",
    },
    {
      detail_hash: "H466533",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/675_ZIP_P_0057_T.jpg",
      alt: "궁중 떡볶이_반조리",
      delivery_type: ["새벽배송", "전국택배"],
      title: "궁중 떡볶이_반조리",
      description: "영양 듬뿍 프리미엄 간장 떡볶이",
      s_price: "7,800원",
    },
    {
      detail_hash: "H1AA942",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg",
      alt: "초계국수_쿠킹박스",
      delivery_type: ["새벽배송", "전국택배"],
      title: "초계국수_쿠킹박스",
      description: "건강한 가정 간편식 여름 국수",
      s_price: "11,800원",
    },
    {
      detail_hash: "HEDFB51",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg",
      alt: "쭈꾸미 한돈 제육볶음_반조림",
      delivery_type: ["새벽배송", "전국택배"],
      title: "쭈꾸미 한돈 제육볶음_반조림",
      description: "쫄깃한 쭈꾸미와 고소한 돼지고기가 일품",
      s_price: "16,900원",
    },
    {
      detail_hash: "H466533c",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/675_ZIP_P_0057_T.jpg",
      alt: "궁중 떡볶이_반조리",
      delivery_type: ["새벽배송", "전국택배"],
      title: "궁중 떡볶이_반조리",
      description: "영양 듬뿍 프리미엄 간장 떡볶이",
      s_price: "7,800원",
    },
    {
      detail_hash: "H1AA942x",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg",
      alt: "초계국수_쿠킹박스",
      delivery_type: ["새벽배송", "전국택배"],
      title: "초계국수_쿠킹박스",
      description: "건강한 가정 간편식 여름 국수",
      s_price: "11,800원",
    },
    {
      detail_hash: "HEDFB51a",
      image:
        "http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg",
      alt: "쭈꾸미 한돈 제육볶음_반조림",
      delivery_type: ["새벽배송", "전국택배"],
      title: "쭈꾸미 한돈 제육볶음_반조림",
      description: "쫄깃한 쭈꾸미와 고소한 돼지고기가 일품",
      s_price: "16,900원",
    },
  ];
  const CARD_VISIBLE = 5;
  const CARD_GAP = 16;
  const CARD_SIZE = 160;
  const CARD_COUNT = arr.length;

  const [currentCarouselCount, setCurrentCarouselCount] = useState(1);
  const totalCarouselCount =
    CARD_COUNT % CARD_VISIBLE === 0
      ? parseInt(CARD_COUNT / CARD_VISIBLE)
      : parseInt(CARD_COUNT / CARD_VISIBLE) + 1;
  const carouselRef = useRef();
  const carouselBtnRef = useRef(true);
  const carouselPosRef = useRef(0);
  const carouselBeforePosRef = useRef(0);

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
      const cardRemain = CARD_COUNT - CARD_VISIBLE - carouselPosRef.current;

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
    <Container>
      <Header>
        <Title>함께하면 더욱 맛있는 상품</Title>
        <Counter>
          <LeftBtn
            src={`${process.env.PUBLIC_URL}/images/ModalCarouselLeft.svg`}
            onClick={handleLeftBtnClick}
          ></LeftBtn>
          <CurrentPage>{currentCarouselCount}</CurrentPage>
          <DividePage>/</DividePage>
          <TotalPage>{totalCarouselCount}</TotalPage>
          <RightBtn
            src={`${process.env.PUBLIC_URL}/images/ModalCarouselRight.svg`}
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
          {arr.map((e) => {
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
  );
};

export default Carousel;
