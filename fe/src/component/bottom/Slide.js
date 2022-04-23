import React, { useState, useEffect } from "react";
import styled from "styled-components";
import Card from "../UI/Card";
import CardsWrapper from "../UI/CardsWrapper";
import SlideIcon from "./SlideIcon";
const SlideTitle = styled.h5`
  font-size: 24px;
  font-weight: 500l;
  color: #333;
  margin: 40px 0 0 40px;
`;

const Ts = styled.div`
  display: flex;
`;
const Slide = () => {
  const [slideInfo, setSlideInfo] = useState([]);
  useEffect(() => {
    fetch("https://api.codesquad.kr/onban/soup")
      .then((res) => res.json())
      .then((data) => setSlideInfo(data.body));
  }, []);

  return (
    <>
      <SlideTitle>식탁을 풍성하게 하는 정갈한 밑반찬</SlideTitle>;
      <CardsWrapper>
        <SlideIcon />
        <Ts>
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
              />
            );
          })}
        </Ts>
      </CardsWrapper>
    </>
  );
};

export default Slide;
