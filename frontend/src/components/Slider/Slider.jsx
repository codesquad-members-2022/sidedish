import React, {useState, useEffect, useRef} from "react";
import {fetchData} from "utils/utils";
import {serverURL} from "constants/urlPath";
import {prevButtonIcon, nextButtonIcon} from "constants";
import {GoodsBlock} from "components";
import {PrevButton, NextButton} from "containers/SideDishContents/SideDishContents.styled";

function Slider({sideDishTitle}) {
  const [goodsData, setGoodsData] = useState([]);
  const [sliderState, setSliderState] = useState({clickedButton: "", list: ""});
  const [position, setPosition] = useState(0);
  const [sliderHiddenLeft, setSliderHiddenLeft] = useState(0);
  const [sliderHiddenRight, setSliderHiddenRight] = useState(
    goodsData.length >= 4 ? goodsData.length - 4 : goodsData.length,
  );
  const sideDishList = useRef();
  const sliderPrevButton = useRef();
  const sliderNextButton = useRef();

  const fetchAPI = async () => {
    const data = await fetchData(`${serverURL}/${sideDishTitle}`);
    setGoodsData(data);
  };

  const handleClickedButton = ({target}) => {
    const hasClass = (element, className) => {
      return element.classList.contains(className);
    };

    const current = hasClass(target, "nextButton") || hasClass(target, "nextButtonIcon");

    setSliderState({
      ...sliderState,
      clickedButton: current,
      list: sideDishList.current,
    });

    const goodBlockWidth = 326;
    setPosition(current ? position - 4 * goodBlockWidth : position + 4 * goodBlockWidth);
  };

  useEffect(() => {
    fetchAPI();
  }, []);

  useEffect(() => {
    if (sliderState.clickedButton === "") return;

    sliderState.list.style.transform = `translateX(${position}px)`;
    sliderState.list.style.transition = "0.2s ease-out";
  }, [sliderState, position]);

  return (
    <div className="event-slider">
      <PrevButton onClick={handleClickedButton} className="prevButton" ref={sliderPrevButton}>
        <img className="prevButtonIcon" src={prevButtonIcon} alt="prevButtonIcon"></img>
      </PrevButton>
      <NextButton onClick={handleClickedButton} className="nextButton" ref={sliderNextButton}>
        <img className="nextButtonIcon" src={nextButtonIcon} alt="nextButtonIcon"></img>
      </NextButton>
      <div className="sideDishContainer">
        <ul className="sideDishList" ref={sideDishList}>
          {goodsData.map(
            ({id, image, productName, description, price, eventBadge, early_delivery, discountedRate}) => (
              <li key={id}>
                <GoodsBlock
                  thumb={image}
                  name={productName}
                  description={description}
                  price={price}
                  eventBadge={eventBadge}
                  discountedRate={discountedRate}
                  delivery={early_delivery}
                />
              </li>
            ),
          )}
        </ul>
      </div>
    </div>
  );
}

export {Slider};
