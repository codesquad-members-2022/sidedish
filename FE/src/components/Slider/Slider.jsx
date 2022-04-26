import React, { useEffect, useState } from 'react';
import { SliderWrapper, SliderTitle, SliderContainer, SliderList, ArrowLeftIcon, ArrowRightIcon } from './Slider.style';
import Card from 'components/Card/Card';
import { fetchData } from 'utils/utils';

const Slider = () => {
  const [data, setData] = useState([]);
  const [isLeftArrowActive, setIsLeftArrowActive] = useState(false);
  const [isRightArrowActive, setIsRightArrowActive] = useState(false);
  const fetchTabData = async () => {
    const TEST_URL = `http://3.39.42.204:8080/api/dishes`;
    const data = await fetchData(TEST_URL);
    setData(data.slice(0, 4)); // Temporarily sliced 4 data
  };

  useEffect(() => {
    fetchTabData();
  }, []);

  return (
    <SliderWrapper>
      <SliderTitle>식탁을 풍성하게 하는 정갈한 밑반찬</SliderTitle>
      <SliderContainer>
        <ArrowLeftIcon
          active={isLeftArrowActive.toString()}
        />
        <ArrowRightIcon
          active={isRightArrowActive.toString()}
        />
        <SliderList>
          {data.map((v, i) => (
            <Card key={i} data={v} size="medium" />
          ))}
        </SliderList>
      </SliderContainer>
    </SliderWrapper>
  );
};

export default Slider;
