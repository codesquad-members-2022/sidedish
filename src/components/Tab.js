import React from 'react';
import styled from 'styled-components';

import { color } from '../css/variables';

const Tab = ({ onClick }) => {
  const tabs = [
    { id: 0, title: '풍성한 고기 반찬' },
    { id: 1, title: '편리한 반찬 세트' },
    { id: 2, title: '맛있는 제철 요리' },
    { id: 3, title: '우리 아이 영양 반찬' },
  ];

  return (
    <StyledTab>
      {tabs.map(({ id, title }) => (
        <li key={id} id={id} onClick={() => onClick(id)}>
          {title}
        </li>
      ))}
    </StyledTab>
  );
};

const StyledTab = styled.ul`
  display: flex;
  padding: 30px 0 30px 0;
  li {
    cursor: pointer;
    font-size: 18px;
    font-weight: bold;
    margin-right: 50px;
    padding: 20px;
    border: 1px solid ${color.orange};
    border-radius: 5px;
  }
  margin-left: 40px;
`;

export default Tab;
