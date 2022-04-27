import React from 'react';
import { Category } from './Category';

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
      <Category info={CategoryInfo} />
    </main>
  );
}
