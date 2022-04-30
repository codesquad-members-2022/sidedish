import React from 'react';
import BestProduct from './BestProduct';
import { Category } from './Category';

const BestProductInfo = {
  titleTag: '기획전',
  title: '한 번 주문하면 두 번 반하는 반찬',
  viewItemCount: 3,
  menu: [
    {
      title: '풍성한 고기 반찬',
    },
    {
      title: '편리한 반찬 세트',
    },
    {
      title: '맛있는 제철 요리',
    },
    {
      title: '우리 아이 영양 반찬',
    },
  ],
};

const CategoryInfo = [
  {
    path: 'side',
    title: '식탁을 풍성하게 하는 정갈한 밑반찬',
    viewItemCount: 4,
  },
  {
    path: 'soup',
    title: '정성이 담긴 뜨끈뜨끈 국물 요리',
    viewItemCount: 4,
  },
  {
    path: 'main',
    title: '모두가 좋아하는 든든한 메인 요리',
    viewItemCount: 4,
  },
];

export default function Main({ hasData }) {
  if (!hasData) return;
  return (
    <main className="main">
      <BestProduct info={BestProductInfo} />
      <Category info={CategoryInfo} />
    </main>
  );
}
