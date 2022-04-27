import React, { useEffect, useState } from 'react';
import { SliderWrapper, SliderTitle, SliderContainer, SliderList, ArrowLeftIcon, ArrowRightIcon } from './Slider.style';
import Card from 'components/Card/Card';
import { fetchData } from 'utils/utils';
import { TEST_URL } from 'constants/api';

const Slider = () => {
  const VISIBLE_CARD_COUNT = 4;
  const MEDIUM_CARD_WIDTH = 302;
  const MEDIUM_CARD_MARGIN = 24;
  const TOTAL_MEDIUM_CARD_WIDTH = MEDIUM_CARD_WIDTH + MEDIUM_CARD_MARGIN;

  const [data, setData] = useState([]);
  const [isLeftArrowActive, setIsLeftArrowActive] = useState(false);
  const [isRightArrowActive, setIsRightArrowActive] = useState(false);
  const [dataIndex, setDataIndex] = useState(0);
  const [xPosition, setXPosition] = useState(0);

  const fetchTabData = async () => {
    let data = await fetchData(TEST_URL);
    data = data.slice(dataIndex, 14); // Temporarily set 14 data
    setData(data);
    initRightArrowState(data);
  };

  const initRightArrowState = data => {
    if (data.length >= VISIBLE_CARD_COUNT) {
      setIsRightArrowActive(true);
    }
  };

  const changeArrowState = startIndex => {
    const checkLeftArrowActive = startIndex => startIndex > 0;
    const checkRightArrowActive = startIndex => startIndex + VISIBLE_CARD_COUNT < data.length;

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
      const endIndex = dataIndex + VISIBLE_CARD_COUNT * 2;
      return (endIndex > data.length ? data.length : endIndex) - VISIBLE_CARD_COUNT;
    }

    if (direction === 'left') {
      const newStartIndex = dataIndex - VISIBLE_CARD_COUNT;
      return newStartIndex < 0 ? 0 : newStartIndex;
    }
  };

  const calcSliderWidth = dataCount => {
    return MEDIUM_CARD_WIDTH * dataCount + MEDIUM_CARD_MARGIN * (dataCount - 1) + 'px';
  };

  useEffect(() => {
    fetchTabData();
  }, []);

  return (
    <SliderWrapper>
      <SliderTitle>식탁을 풍성하게 하는 정갈한 밑반찬</SliderTitle>
      <SliderContainer>
        <ArrowLeftIcon
          onClick={() => handleArrowClick('left', isLeftArrowActive)}
          active={isLeftArrowActive.toString()}
        />
        <ArrowRightIcon
          onClick={() => handleArrowClick('right', isRightArrowActive)}
          active={isRightArrowActive.toString()}
        />
        <SliderList width={calcSliderWidth(data.length)} xposition={xPosition}>
          {data.map((v, i) => (
            <Card key={i} data={v} size="medium" />
          ))}
        </SliderList>
      </SliderContainer>
    </SliderWrapper>
  );
};

export default Slider;
