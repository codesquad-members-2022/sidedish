import React, { useEffect, useState } from 'react';
import Card from 'components/Card/Card';
import { fetchData } from 'utils/utils';
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
import tabData from 'data/specialTab.js';

const Special = () => {
  const [data, setData] = useState([]);
  const [tabNum, setTabNum] = useState(0);

  useEffect(() => {
    fetchTabData(tabNum);
  }, [tabNum]);

  const handleTabClick = tabNum => {
    setTabNum(tabNum);
    // fetchTabData(tabNum);
  };

  const fetchTabData = async tabNum => {
    // const TEST_URL = `http://3.39.42.204/api/dishes/${tabNum}`;
    const TEST_URL = `http://3.39.42.204/api/dishes`;
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
          {tabData.map((v, i) => {
            return (
              <SpecialTab
                key={i}
                onClick={() => handleTabClick(v.index)}
                isSelected={tabNum === v.index ? true : false}
              >
                {v.name}
              </SpecialTab>
            );
          })}
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
