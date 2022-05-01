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
import { API_URL } from 'constants/api';

const Special = () => {
  const [data, setData] = useState([]);
  const [tabNum, setTabNum] = useState(1);

  useEffect(() => {
    fetchTabData(tabNum);
  }, [tabNum]);

  const handleTabClick = tabNum => {
    setTabNum(tabNum);
  };

  const fetchTabData = async tabNum => {
    const data = await fetchData(`${API_URL}/categories/${tabNum}`);
    setData(data[tabNum]);
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
              <SpecialTab key={i} onClick={() => handleTabClick(v.index)} isSelected={tabNum === v.index}>
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
