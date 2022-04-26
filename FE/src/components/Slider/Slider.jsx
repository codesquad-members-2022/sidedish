import React, { useEffect, useState } from 'react';
import { SliderWrapper, SliderTitle, SliderContainer, SliderList, ArrowLeftIcon, ArrowRightIcon } from './Slider.style';
import Card from 'components/Card/Card';
import { fetchData } from 'utils/utils';
import { TEST_URL } from 'constants/api';

const Slider = () => {
  const VISIBLE_CARD_COUNT = 4;

  const [data, setData] = useState([]);
  const [isLeftArrowActive, setIsLeftArrowActive] = useState(false);
  const [isRightArrowActive, setIsRightArrowActive] = useState(false);
  const [visibleData, setVisibleData] = useState([]);
  const [dataIndex, setDataIndex] = useState(0);

  const fetchTabData = async () => {
    let data = await fetchData(TEST_URL);
    data = data.slice(dataIndex, 6); // Temporarily set 6 data
    setData(data);
    setVisibleData(data.slice(dataIndex, VISIBLE_CARD_COUNT));
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
    if (direction === 'right' && !isRightArrowActive) {
      return;
    }

    if (direction === 'left' && !isLeftArrowActive) {
      return;
    }

    let visibleData;
    let startIndex;

    if (direction === 'right') {
      let endIndex = dataIndex + VISIBLE_CARD_COUNT * 2;

      if (endIndex > data.length) {
        endIndex = data.length;
      }

      startIndex = endIndex - VISIBLE_CARD_COUNT;
      visibleData = data.slice(endIndex - VISIBLE_CARD_COUNT, endIndex);
    }

    if (direction === 'left') {
      startIndex = dataIndex - VISIBLE_CARD_COUNT;

      if (startIndex < 0) {
        startIndex = 0;
      }

      visibleData = data.slice(startIndex, startIndex + VISIBLE_CARD_COUNT);
    }

    setDataIndex(startIndex);
    setVisibleData(visibleData);
    changeArrowState(startIndex);
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
        <SliderList>
          {visibleData.map((v, i) => (
            <Card key={i} data={v} size="medium" />
          ))}
        </SliderList>
      </SliderContainer>
    </SliderWrapper>
  );
};

export default Slider;
