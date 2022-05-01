import React, { useState, useEffect } from "react";
import Slide from "./Slide";
import More from "./More";
import constansts from "../../constants/constansts";
import { myfetch } from "../../utils/utils";

const Slides = () => {
  const [cardsInfor, setCardInfor] = useState([]);
  const [isDisplayed, setIsDisplayed] = useState(false);

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
    setIsDisplayed(!isDisplayed);
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
