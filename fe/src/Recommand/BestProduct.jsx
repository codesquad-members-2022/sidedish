import { useState } from 'react';
import styled from 'styled-components';
import COLOR from '../Constants/Colors';
import { ProductCard } from './ProductCard';

const Root = styled.div`
  display: flex;
  flex-direction: column;
`;

const BP__tab = styled.ul`
  display: flex;
  border-bottom: 0.5px solid ${COLOR.LIGHT_GREY};
`;

const BP__top = styled.div`
  display: flex;
`;

const BP__main = styled.div`
  display: flex;
`;

const Badge = styled.div`
  border-radius: 0.5;
  border: 0.5px solid ${COLOR.BLACK};
  background-color: ${COLOR.OFF_WHITE};
`;

//TODO: 폰트사이즈
const Title = styled.span`
  height: 100%;
  margin-left: 10px;
  font-size: 40px;

  :hover {
    border-bottom: 1px solid ${COLOR.BLACK};
  }
`;

const tabItem = [
  '풍성한 고기 반찬',
  '편리한 반찬 세트',
  '맛있는 제철 요리',
  '우리 아이 영양 반찬',
];

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
    },
  ]);
  return (
    <Root>
      <BP__top>
        <Badge>기획전</Badge>
        <Title>한번 주문하면 두번 주문하는 반찬</Title>
      </BP__top>
      <BP__tab>
        {tabItem.map((item, idx) => (
          <li key={idx}>{item}</li>
        ))}
      </BP__tab>
      <BP__main>
        {cardData.map((data, idx) => (
          <ProductCard data={data} key={idx} />
        ))}
      </BP__main>
    </Root>
  );
};
