import { useState } from "react";
import styled from "styled-components";
import Label from "./Label";
import ItemCard from "./MenuCard";

const MainContainer = styled.main`
  display: flex;
  flex-direction: column;
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

const ItemCardContainer = styled.ul`
  display: flex;
  padding: 34px 56px;
`;

const Main = () => {
  const data = ["풍성한 고기 반찬", "편리한 반찬 세트", "맛있는 제철 요리", "우리 아이 영양 반찬"];
  const [lnbState, setLnbState] = useState(data[0]);
  const data2 = [
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
      title: "오리 주물럭_반조리",
      description: "감칠맛 나는 매콤한 양념",
      n_price: "15,800원",
      s_price: "12,640원",
      badge: ["런칭특가"],
    },
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
      title: "오리 주물럭_반조리",
      description: "감칠맛 나는 매콤한 양념",
      n_price: "15,800원",
      s_price: "12,640원",
      badge: ["런칭특가"],
    },
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
      title: "오리 주물럭_반조리",
      description: "감칠맛 나는 매콤한 양념",
      n_price: "15,800원",
      s_price: "12,640원",
      badge: ["런칭특가"],
    },
  ];

  const data3 = [
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/310_ZIP_P_0012_T.jpg",
      delivery_type: ["새벽배송", "전국택배"],
      title: "잡채",
      description: "탱글한 면발과 맛깔진 고명이 가득",
      n_price: "12,900원",
      s_price: "11,610원",
      badge: ["이벤트특가"],
    },

    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/310_ZIP_P_0012_T.jpg",
      delivery_type: ["새벽배송", "전국택배"],
      title: "잡채",
      description: "탱글한 면발과 맛깔진 고명이 가득",
      n_price: "12,900원",
      s_price: "11,610원",
      badge: ["이벤트특가"],
    },

    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/310_ZIP_P_0012_T.jpg",
      delivery_type: ["새벽배송", "전국택배"],
      title: "잡채",
      description: "탱글한 면발과 맛깔진 고명이 가득",
      n_price: "12,900원",
      s_price: "11,610원",
      badge: ["이벤트특가"],
    },
  ];
  const data4 = [
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg",
      title: "소갈비찜",
      description: "촉촉하게 밴 양념이 일품",
      n_price: "28,900원",
      s_price: "26,010원",
      badge: ["이벤트특가", "런칭특가"],
    },
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg",
      title: "소갈비찜",
      description: "촉촉하게 밴 양념이 일품",
      n_price: "28,900원",
      s_price: "26,010원",
      badge: ["이벤트특가", "런칭특가"],
    },
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg",
      title: "소갈비찜",
      description: "촉촉하게 밴 양념이 일품",
      n_price: "28,900원",
      s_price: "26,010원",
      badge: ["이벤트특가", "런칭특가"],
    },
  ];

  const data5 = [
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg",
      title: "꼬막비빔밥",
      description: "매콤하게 입맛 돋우는",
      s_price: "10,900원",
      badge: ["런칭특가", "이벤트특가", "메인특가"],
    },
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg",
      title: "꼬막비빔밥",
      description: "매콤하게 입맛 돋우는",
      s_price: "10,900원",
      badge: ["런칭특가", "이벤트특가", "메인특가"],
    },
    {
      image: "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg",
      title: "꼬막비빔밥",
      description: "매콤하게 입맛 돋우는",
      s_price: "10,900원",
      badge: ["런칭특가", "이벤트특가", "메인특가"],
    },
  ];

  const [dataState, setDataState] = useState(data2);

  const handleLnbState = (event) => {
    setLnbState((lnbState) => (lnbState = event.target.textContent));
    if (event.target.textContent === data[0]) {
      setDataState((dataState) => (dataState = data2));
    } else if (event.target.textContent === data[1]) {
      setDataState((dataState) => (dataState = data3));
    } else if (event.target.textContent === data[2]) {
      setDataState((dataState) => (dataState = data4));
    } else {
      setDataState((dataState) => (dataState = data5));
    }
  };

  return (
    <MainContainer>
      <MainTitleContainer>
        <Label string="기획전" color="black" fontSize="16px" backgroundColor="white" borderColor="black" padding="12px 12px"></Label>
        <Title>한 번 주문하면 두 번 반하는 반찬</Title>
      </MainTitleContainer>
      <MainLnbContainer>
        {data.map((title, ind) => (
          <MainLnb onClick={handleLnbState} title={title} lnbState={lnbState} key={ind}>
            {title}
          </MainLnb>
        ))}
      </MainLnbContainer>
      <ItemCardContainer>
        {dataState.map(({ image, title, description, n_price, s_price, badge }, ind) => (
          <ItemCard key={ind} image={image} title={title} description={description} n_price={n_price} s_price={s_price} badge={badge}></ItemCard>
        ))}
      </ItemCardContainer>
    </MainContainer>
  );
};

export default Main;
