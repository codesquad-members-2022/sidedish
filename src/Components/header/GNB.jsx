import React, { useState } from 'react';
import styled from 'styled-components';
import { F_basic, Color } from '../../Assets/CommonStyle';
import List from '../List';

const GNB_style = styled.nav`
  margin: 0 40px;

  > ul {
    ${F_basic}

    > li {
      position: relative;
      padding: 0 12px;

      &:hover > a {
        font-weight: 500;
        color: ${Color.orange};
      }

      ul {
        visibility: hidden;
        opacity: 0;
        position: absolute;
        top: 100%;
        left: 0;
        width: 100%;
        padding: 16px 12px;

        > li {
          margin-bottom: 8px;

          &:hover {
            color: ${Color.orange};
            text-decoration: underline;
          }
        }
      }
    }
  }

  &:hover > ul ul {
    transition: 0.3s;
    opacity: 1;
    visibility: visible;
  }

  a {
    display: block;
  }
`;

const mouseHandler = ({ target }) => {
  const header = target.closest('header');

  if (header.classList.contains('active')) {
    header.classList.remove('active');
    return;
  }

  header.classList.add('active');
};

const GNB = () => {
  const GNB_LIST = [
    {
      id: 'main',
      title: '든든한 메인요리',
      menu: [
        {
          id: 'meat',
          title: '육류 요리',
        },
        {
          id: 'seafood',
          title: '해산물 요리',
        },
      ],
    },
    {
      id: 'soup',
      title: '뜨끈한 국물요리',
      menu: [
        {
          id: 'soup1',
          title: '국,탕,찌개',
        },
      ],
    },
    {
      id: 'side',
      title: '정갈한 밑반찬',
      menu: [
        {
          id: 'side1',
          title: '나물/무침',
        },
        {
          id: 'side2',
          title: '조림/볶음',
        },
        {
          id: 'side3',
          title: '절임/장아찌',
        },
      ],
    },
  ];
  const [GNB_MENU, setGNB_MENU] = useState(GNB_LIST);

  return (
    <GNB_style onMouseEnter={mouseHandler} onMouseLeave={mouseHandler}>
      <List menu={GNB_MENU} />
    </GNB_style>
  );
};

export default GNB;
