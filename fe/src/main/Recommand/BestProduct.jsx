import { useState } from 'react';
import styled from 'styled-components';
import COLOR from '../Constants/Colors';
import { ProductCard } from './ProductCard';
import { CategoryBadge } from '../Badge/CategoryBadge';
const BestProductWrapper = styled.li`
  display: flex;
  width: 1440px;
  padding: 0 80px;
  margin: 0 auto;
  margin-top: 56px;
  flex-direction: column;
`;

const BP__tab = styled.ul`
  display: flex;

  border-bottom: 0.5px solid ${COLOR.LIGHT_GREY};
  margin: 0 -80px;
  padding: 0 80px;

  li {
    cursor: pointer;
    padding: 16px;
    border-bottom: 1.5px solid transparent;
  }

  li:hover {
    border-color: ${COLOR.BLACK};
  }
`;

const BP__top = styled.div`
  display: flex;
  align-item: center;
`;

const BP__main = styled.ul`
  display: flex;
  margin-top: 34px;

  li: not(: last-child) {
    margin-right: 24px;
  } ;
`;

const Title = styled.span`
  margin-left: 10px;
`;

const tabItem = [
  '풍성한 고기 반찬',
  '편리한 반찬 세트',
  '맛있는 제철 요리',
  '우리 아이 영양 반찬',
];

const BadgeWrapper = styled.div`
  display: flex;
  align-items: center;
`;

export const BestProducts = () => {
  // 추후 상태값 props.cardData로 변경??
  const [cardData, setCardData] = useState([
    {
      title: '오리 주물럭',
      image:
        'https://www.chuksannews.co.kr/data/photos/20210937/art_16316674227272_0aee8d.jpg',
      description: '감칠맛 나는 매운 양념',
      price: 12500,
      size: 'big',
      discountPolicy: 'launch',
      discountRate: 0.15,
    },
    {
      title: '오리 주물럭2',
      image:
        'https://www.chuksannews.co.kr/data/photos/20210937/art_16316674227272_0aee8d.jpg',
      description: '감칠맛 나는 매운 양념',
      price: 12500,
      size: 'big',
      discountPolicy: 'launch',
      discountRate: 0.15,
    },
    {
      title: '오리 주물럭',
      image:
        'https://www.chuksannews.co.kr/data/photos/20210937/art_16316674227272_0aee8d.jpg',
      description: '감칠맛 나는 매운 양념',
      price: 12500,
      size: 'big',
      discountPolicy: 'launch',
      discountRate: 0.15,
    },
  ]);
  return (
    <BestProductWrapper>
      <BP__top>
        <BadgeWrapper>
          <CategoryBadge />
        </BadgeWrapper>

        <Title className="fonts-display">
          한번 주문하면 두번 주문하는 반찬
        </Title>
      </BP__top>
      <BP__tab>
        {tabItem.map((item, idx) => (
          <li className="fonts-lg" key={idx}>
            {item}
          </li>
        ))}
      </BP__tab>
      <BP__main>
        {cardData.map((data, idx) => (
          <ProductCard data={data} key={idx} />
        ))}
      </BP__main>
    </BestProductWrapper>
  );
};
