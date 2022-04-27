import React, { useState, useEffect } from "react";
import Slide from "./Slide";
import More from "./More";

const Slides = () => {
  const [cardsInfor, setCardInfor] = useState([]);
  const [isDisplayed, setIsDisplayed] = useState(false);
  const myfetch = (url) => {
    return fetch(url).then((res) => res.json());
  };

  useEffect(() => {
    const url = [
      "https://api.codesquad.kr/onban/side",
      "https://api.codesquad.kr/onban/soup",
      "https://api.codesquad.kr/onban/main",
    ];

    const data = Promise.all(
      url.map(async (v) => {
        return await myfetch(v);
      })
    );

    data.then((res) => setCardInfor(res));
  }, []);

  const onChangeSlideDisplay = () => {
    isDisplayed ? setIsDisplayed(false) : setIsDisplayed(true);
  };
  return (
    <>
      {cardsInfor.map((v, i) => (
        <Slide
          cardData={v}
          key={i}
          alwaysDisplayed={i === 0 ? true : false}
          isDisplayed={isDisplayed}
        />
      ))}
      <More onchange={onChangeSlideDisplay} isDisplayed={isDisplayed} />
    </>
  );
};

export default Slides;
