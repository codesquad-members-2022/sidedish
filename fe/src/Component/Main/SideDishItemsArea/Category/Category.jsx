import PropTypes from "prop-types";
import { ImgSliderButtons } from "MockData/MockData";
import { useState, useRef, useEffect } from "react";
import { Wrapper, CategoryWrapper, Title } from "./Category.styled";
import SliderButton from "./ImgSlider/SliderButton";
import ImgSlider from "./ImgSlider/ImgSlider";

const TRANSITION_DURATION = "500ms";
const MAX_CARDS_COUNT_PER_SLIDE = 4;
const INITIAL_INDEX_OF_ITEM = 0;

const CARD_SIZE = {
  width: 302,
  margin: 24,
};

const MOVE_PX_PER_COUNT = CARD_SIZE.width + CARD_SIZE.margin;

const sliderButtonInfo = {
  left: {
    inner: ImgSliderButtons.left,
    type: "left",
  },
  right: {
    inner: ImgSliderButtons.right,
    type: "right",
  },
};

const CategoryTitle = ({ name }) => {
  return <Title>{name}</Title>;
};

const Category = ({ name, sideDishes }) => {
  const TOTAL_DATA_COUNT = sideDishes.length;

  const sideDishSlider = useRef();
  const curPosition = useRef(INITIAL_INDEX_OF_ITEM);

  const [isLeftButtonClickable, setIsLeftButtonClickable] = useState(false);
  const [isRightButtonClickable, setIsRightButtonClickable] = useState(true);

  const moveSlider = () => {
    sideDishSlider.current.style.transition = `transform ${TRANSITION_DURATION}`;
    sideDishSlider.current.style.transform = `translateX(-${
      curPosition.current * MOVE_PX_PER_COUNT
    }px)`;
  };

  const checkCurPosition = {
    left: () => {
      if (curPosition.current <= INITIAL_INDEX_OF_ITEM) {
        curPosition.current = INITIAL_INDEX_OF_ITEM;
        setIsLeftButtonClickable(false);
      }
    },
    right: () => {
      if (curPosition.current + MAX_CARDS_COUNT_PER_SLIDE >= TOTAL_DATA_COUNT) {
        const remainder = Math.floor(
          TOTAL_DATA_COUNT % MAX_CARDS_COUNT_PER_SLIDE
        );
        if (remainder) {
          curPosition.current =
            curPosition.current - MAX_CARDS_COUNT_PER_SLIDE + remainder;
        }
        setIsRightButtonClickable(false);
      }
    },
  };

  const computePosition = (direction) => {
    setIsRightButtonClickable(true);
    setIsLeftButtonClickable(true);

    checkCurPosition[direction]();
  };

  const movePosition = {
    left: () => {
      curPosition.current -= MAX_CARDS_COUNT_PER_SLIDE;
      computePosition("left");
    },
    right: () => {
      curPosition.current += MAX_CARDS_COUNT_PER_SLIDE;
      computePosition("right");
    },
  };

  const handleSlide = {
    left: () => {
      if (!curPosition.current) {
        return;
      }
      movePosition.left();
      moveSlider();
    },
    right: () => {
      if (curPosition.current + MAX_CARDS_COUNT_PER_SLIDE >= TOTAL_DATA_COUNT) {
        return;
      }
      movePosition.right();
      moveSlider();
    },
  };

  useEffect(() => {
    if (TOTAL_DATA_COUNT <= MAX_CARDS_COUNT_PER_SLIDE) {
      setIsRightButtonClickable(false);
    }
  }, []);

  return (
    <Wrapper>
      <SliderButton
        info={sliderButtonInfo.left}
        isClickable={isLeftButtonClickable}
        onClick={handleSlide.left}
      />
      <CategoryWrapper>
        <CategoryTitle name={name} />
        <ImgSlider sideDishes={sideDishes} sliderRef={sideDishSlider} />
      </CategoryWrapper>
      <SliderButton
        info={sliderButtonInfo.right}
        isClickable={isRightButtonClickable}
        onClick={handleSlide.right}
      />
    </Wrapper>
  );
};

CategoryTitle.propTypes = {
  name: PropTypes.string.isRequired,
};

Category.propTypes = {
  name: PropTypes.string.isRequired,
  sideDishes: PropTypes.arrayOf(
    PropTypes.objectOf(
      PropTypes.oneOfType([PropTypes.number, PropTypes.string, PropTypes.bool])
    )
  ).isRequired,
};

export default Category;
