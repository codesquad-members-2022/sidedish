import React, { useState } from 'react';
import ListItem from './ListItem';
import styled from 'styled-components';

const GnbList = styled.ul`
  display: flex;
  margin-left: 40px;
`;

function Gnb() {
  const categoryList = {
    '든든한 메인요리': ['육류 요리', '해산물 요리'],
    '뜨끈한 국물요리': ['국,탕,찌개'],
    '정갈한 밑반찬': ['나물/무침', '조림/볶음', '절임/장아찌'],
  };
  const [category, setCategory] = useState(categoryList);
  const template = [];

  for (let key in category) {
    template.push(
      <li key={key}>
        <span>{key}</span>
        {ListItem(category[key])}
      </li>
    );
  }

  return (
    <nav>
      <GnbList>{template}</GnbList>
    </nav>
  );
}

export default Gnb;
