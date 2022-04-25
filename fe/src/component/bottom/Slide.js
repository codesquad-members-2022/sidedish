import React, { useState, useEffect } from "react";
import styled from "styled-components";
import Card from "../UI/Card";
import CardsWrapper from "../UI/CardsWrapper";
import SlideIcon from "./SlideIcon";
import More from "./More";

const SlideTitle = styled.h5`
  font-size: 24px;
  font-weight: 500;
  color: #333;
  margin: 40px 0 0 40px;
`;

const SlideWrapper = styled.div`
  position: absolute;
  width: 1280px;

  height: 450px;
  overflow: hidden;
  margin-left: 40px;
`;

// 슬라이드 전체를 감싸고 있는 래퍼

const SlideCardsList = styled.div`
  display: flex;
  transform: translateX(${({ currentPlace }) => currentPlace});

  // -310 단위로 오른쪽으로 돌아감
`;

const Slide = () => {
  const [slideInfo, setSlideInfo] = useState([]);
  const [x, setX] = useState(0);
  useEffect(() => {
    fetch("https://api.codesquad.kr/onban/side")
      .then((res) => res.json())
      .then((data) => setSlideInfo(data.body));
    //promise all사용 예정 -> data한번에 받기(안쓰는 data는 display:none)
  }, []);

  const [isrightBtnActive, setIsRightBtnActive] = useState(true);
  const [isleftBtnActive, setIsLeftBtnActive] = useState(true);

  const onClickHandler = () => {
    const all = -(slideInfo.length * 312) + 4 * 312;
    setX((prev) => (prev - 312 >= all ? prev - 312 : prev));
    x - 312 >= all ? setIsRightBtnActive(true) : setIsRightBtnActive(false);
  };

  const onClickHandler2 = () => {
    setX((prev) => (prev + 312 <= 0 ? prev + 312 : prev));
    x === 0 ? setIsLeftBtnActive(false) : setIsLeftBtnActive(true);
  };

  return (
    <>
      <SlideTitle>식탁을 풍성하게 하는 정갈한 밑반찬</SlideTitle>
      <SlideWrapper>
        <SlideCardsList currentPlace={x.toString() + "px"}>
          {slideInfo.map((v) => {
            return (
              <Card
                size={`small`}
                key={v.detail_hash}
                image={v.image}
                alt={v.alt}
                title={v.title}
                description={v.description}
                s_price={v.s_price}
                n_price={v.n_price}
                badge={v.badge}
                delivery={v.delivery_type}
              ></Card>
            );
          })}
        </SlideCardsList>
        <div style={{ margin: "0 auto" }}>
          <More />
        </div>
      </SlideWrapper>
      <SlideIcon
        onSaveClickedDirection={onClickHandler}
        onSaveClickedDirection2={onClickHandler2}
        isright={isrightBtnActive}
        isleft={isleftBtnActive}
      />
    </>
  );
};

export default Slide;

// 슬라이드
// 슬라이드 아이콘 << 여기서 버튼을 전달하고 있음
// 아이콘을 누를때 신호를 -> 슬라이드 전달
