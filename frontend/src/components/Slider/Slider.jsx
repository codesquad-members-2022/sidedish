import React, {useState, useEffect, useRef, useCallback} from "react";
import {fetchData, hasClass} from "utils/utils";
import {serverURL} from "constants/urlPath";
import {prevButtonIcon, nextButtonIcon, goodsBlockWidth} from "constants";
import {GoodsBlock} from "components";
import {PrevButton, NextButton, PrevButtonIcon, NextButtonIcon} from "./Slider.styled";

function Slider({sideDishTitle, openModal}) {
  const [goodsData, setGoodsData] = useState([]);
  const [sliderState, setSliderState] = useState({clickedButton: "", list: ""});
  const [position, setPosition] = useState(0);
  const [firstIndex, setFirstIndex] = useState(1);
  const [lastIndex, setLastIndex] = useState(4);

  const sideDishList = useRef();
  const sliderPrevButton = useRef();
  const sliderNextButton = useRef();

  const fetchAPI = useCallback(async () => {
    const data = await fetchData(`${serverURL}/product/main?category=${sideDishTitle}`);
    setGoodsData(data);
  }, [sideDishTitle]);

  const handleClickedButton = ({target}) => {
    const isNextButton = hasClass(target, "nextButton") || hasClass(target, "nextButtonIcon");

    const calcRest = isNextButton => {
      return isNextButton ? goodsData.length - lastIndex : firstIndex - 1;
    };

    let rest = calcRest(isNextButton);
    if (rest >= 4) rest = 4;

    const first = firstIndex + (isNextButton ? rest : -rest);

    setFirstIndex(first);
    setLastIndex(first + 3);

    setSliderState({
      ...sliderState,
      clickedButton: isNextButton,
      list: sideDishList.current,
    });

    setPosition(isNextButton ? position - rest * goodsBlockWidth : position + rest * goodsBlockWidth);
  };

  useEffect(() => {
    fetchAPI();
  }, [fetchAPI]);

  useEffect(() => {
    if (sliderState.clickedButton === "") return;

    sliderState.list.style.transform = `translateX(${position}px)`;
    sliderState.list.style.transition = "0.2s ease-out";
  }, [sliderState, position]);

  return (
    <div className="event-slider">
      <PrevButton onClick={handleClickedButton} className="prevButton" ref={sliderPrevButton}>
        <PrevButtonIcon
          className="prevButtonIcon"
          src={prevButtonIcon}
          alt="prevButtonIcon"
          position={position}
        ></PrevButtonIcon>
      </PrevButton>
      <NextButton
        onClick={handleClickedButton}
        className="nextButton"
        ref={sliderNextButton}
        position={position}
      >
        <NextButtonIcon
          className="nextButtonIcon"
          src={nextButtonIcon}
          alt="nextButtonIcon"
          lastIndex={lastIndex}
          goodsDataLength={goodsData.length}
        ></NextButtonIcon>
      </NextButton>
      <div className="sideDishContainer">
        <ul className="sideDishList" ref={sideDishList}>
          {goodsData.map(
            ({
              id,
              imageThumbnail,
              productName,
              description,
              price,
              eventBadge,
              earlyDelivery,
              discountRate,
            }) => (
              <li
                key={id}
                onClick={() => {
                  openModal(id);
                }}
              >
                <GoodsBlock
                  thumb={imageThumbnail}
                  name={productName}
                  description={description}
                  price={price}
                  eventBadge={eventBadge}
                  discountRate={discountRate}
                  delivery={earlyDelivery}
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
