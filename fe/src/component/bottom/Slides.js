import React, { useState, useEffect } from "react";
import Slide from "./Slide";
import More from "./More";
import constansts from "../../constants/constansts";
import Modal from "../modal/Modal";

const Slides = () => {
  const [cardsInfor, setCardInfor] = useState([]);
  const [isDisplayed, setIsDisplayed] = useState(false);
  const myfetch = (url) => {
    return fetch(url).then((res) => res.json());
  };

  useEffect(() => {
    const url = constansts.SlideINfor.map(
      (v) => `${constansts.MAIN_API_URL}${v.postfix}`
    );
    const data = Promise.all(url.map(myfetch));
    data
      .then((res) =>
        constansts.SlideINfor.map((v, i) =>
          Object.assign(v, {
            data: res[i].data,
          })
        )
      )
      .then((data) => setCardInfor(data));
  }, []);

  const onChangeSlideDisplay = () => {
    isDisplayed ? setIsDisplayed(false) : setIsDisplayed(true);
  };

  return (
    <>
      {cardsInfor.map((v, i) => (
        <Slide
          cardData={v.data}
          key={v.id}
          alwaysDisplayed={i === 0}
          isDisplayed={isDisplayed}
          title={v.title}
        />
      ))}
      <More onchange={onChangeSlideDisplay} isDisplayed={isDisplayed} />
    </>
  );
};

export default Slides;
