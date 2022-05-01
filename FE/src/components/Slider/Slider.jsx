import React, { useEffect, useState } from 'react';
import {
  SliderWrapper,
  SliderHeader,
  SliderTitle,
  SliderContainer,
  SliderList,
  ArrowLeftIcon,
  ArrowRightIcon,
  SliderPageIndex,
} from './Slider.style';
import Card from 'components/Card/Card';
import { fetchData } from 'utils/utils';
import { API_URL } from 'constants/api';
import {
  VISIBLE_CARD_COUNT,
  MEDIUM_CARD_WIDTH,
  MEDIUM_CARD_MARGIN,
  CARD_SIZE,
  Slider_WIDTH,
} from 'constants/sliderSpec';

const Slider = ({ title, id, display, type = 'default', thumbEvent = true }) => {
  const TOTAL_MEDIUM_CARD_WIDTH = MEDIUM_CARD_WIDTH[type] + MEDIUM_CARD_MARGIN[type];

  const [data, setData] = useState([]);
  const [isLeftArrowActive, setIsLeftArrowActive] = useState(false);
  const [isRightArrowActive, setIsRightArrowActive] = useState(false);
  const [dataIndex, setDataIndex] = useState(0);
  const [xPosition, setXPosition] = useState(0);
  const [pageNum, setPageNum] = useState(0);

  const fetchTabData = async () => {
    const categoryData = await fetchData(`${API_URL}/categories`);
    const parsingData = categoryData[id];
    setData(parsingData);
    initRightArrowState(parsingData);
    setPageNum(1);
  };

  const initRightArrowState = data => {
    if (data.length >= VISIBLE_CARD_COUNT[type]) {
      setIsRightArrowActive(true);
    }
  };

  const changeArrowState = startIndex => {
    const checkLeftArrowActive = startIndex => startIndex > 0;
    const checkRightArrowActive = startIndex => startIndex + VISIBLE_CARD_COUNT[type] < data.length;

    checkLeftArrowActive(startIndex) ? setIsLeftArrowActive(true) : setIsLeftArrowActive(false);
    checkRightArrowActive(startIndex) ? setIsRightArrowActive(true) : setIsRightArrowActive(false);
  };

  const handleArrowClick = direction => {
    if (!checkArrowActive(direction)) {
      return;
    }

    const newStartIndex = calcNewStartIndex(direction);

    setDataIndex(newStartIndex);
    changeArrowState(newStartIndex);
    setXPosition(-(TOTAL_MEDIUM_CARD_WIDTH * newStartIndex));
  };

  const checkArrowActive = direction => {
    if (direction === 'right' && !isRightArrowActive) {
      return false;
    }

    if (direction === 'left' && !isLeftArrowActive) {
      return false;
    }

    return true;
  };

  const calcNewStartIndex = direction => {
    if (direction === 'right') {
      const endIndex = dataIndex + VISIBLE_CARD_COUNT[type] * 2;
      setPageNum(pageNum + 1);
      return (endIndex > data.length ? data.length : endIndex) - VISIBLE_CARD_COUNT[type];
    }

    if (direction === 'left') {
      const newStartIndex = dataIndex - VISIBLE_CARD_COUNT[type];
      setPageNum(pageNum - 1);
      return newStartIndex < 0 ? 0 : newStartIndex;
    }
  };

  const calcSliderWidth = dataCount => {
    return MEDIUM_CARD_WIDTH[type] * dataCount + MEDIUM_CARD_MARGIN[type] * (dataCount - 1) + 'px';
  };

  const calcMaxPageNum = () => {
    return Math.ceil(data.length / VISIBLE_CARD_COUNT[type]);
  };

  useEffect(() => {
    fetchTabData();
  }, []);

  return (
    <SliderWrapper display={display} type={type}>
      <SliderHeader>
        <SliderTitle type={type}>{title}</SliderTitle>
        {type === 'small' && (
          <SliderPageIndex>
            {pageNum} / {calcMaxPageNum()}
          </SliderPageIndex>
        )}
      </SliderHeader>
      <SliderContainer type={type} width={Slider_WIDTH[type]}>
        <ArrowLeftIcon
          type={type}
          onClick={() => handleArrowClick('left', isLeftArrowActive)}
          active={isLeftArrowActive.toString()}
        />
        <ArrowRightIcon
          type={type}
          onClick={() => handleArrowClick('right', isRightArrowActive)}
          active={isRightArrowActive.toString()}
        />
        <SliderList width={calcSliderWidth(data.length)} xposition={xPosition}>
          {data.map((v, i) => (
            <Card key={i} data={v} size={CARD_SIZE[type]} mouseEvent={thumbEvent} />
          ))}
        </SliderList>
      </SliderContainer>
    </SliderWrapper>
  );
};

export default Slider;
