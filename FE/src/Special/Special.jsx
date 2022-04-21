import React, { useEffect, useState } from 'react';
import Card from '../components/Card';
import { fetchData } from '../utils/utils';
import {
  SpecialContainer,
  SpecialBadge,
  SpecialTitle,
  SpecialTitleBox,
  SpecialTabBar,
  SpecialHeader,
  SpecialTab,
  CardContainer,
} from './Special.style';

const Special = () => {
  const [data, setData] = useState([]);
  const [tabNum, setTabNum] = useState(0);

  useEffect(() => {
    fetchTabData();
  }, []);

  const handleTabClick = tabNum => {
    setTabNum(tabNum);
    fetchTabData();
  };

  const fetchTabData = async () => {
    const TEST_URL = 'http://3.39.42.204/api/dishes';
    const data = await fetchData(TEST_URL);
    setData(data.response.slice(0, 3));
  };

  return (
    <SpecialContainer>
      <SpecialHeader>
        <SpecialTitleBox>
          <SpecialBadge>기획전</SpecialBadge>
          <SpecialTitle>한 번 주문하면 두 번 반하는 반찬</SpecialTitle>
        </SpecialTitleBox>
        <SpecialTabBar>
          <SpecialTab onClick={() => handleTabClick(0)} isSelected={tabNum === 0 ? true : false}>
            풍성한 고기 반찬
          </SpecialTab>
          <SpecialTab onClick={() => handleTabClick(1)} isSelected={tabNum === 1 ? true : false}>
            편리한 반찬 세트
          </SpecialTab>
          <SpecialTab onClick={() => handleTabClick(2)} isSelected={tabNum === 2 ? true : false}>
            맛있는 제철 요리
          </SpecialTab>
          <SpecialTab onClick={() => handleTabClick(3)} isSelected={tabNum === 3 ? true : false}>
            우리 아이 영양 반찬
          </SpecialTab>
        </SpecialTabBar>
      </SpecialHeader>
      <CardContainer>
        {data.map((v, i) => (
          <Card key={i} data={v} />
        ))}
      </CardContainer>
    </SpecialContainer>
  );
};

export default Special;
