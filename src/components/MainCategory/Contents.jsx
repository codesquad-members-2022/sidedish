/* eslint-disable camelcase */
import React from 'react';
import styled from 'styled-components';
import Card from 'components/common/Card/Card';

// TODO: 데이터 fetch 해오기
const SIDE_DISHES = [
  {
    detail_hash: 'HBDEF',
    image: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    alt: '오리 주물럭_반조리',
    delivery_type: ['새벽배송', '전국택배'],
    title: '오리 주물럭_반조리',
    description: '감칠맛 나는 매콤한 양념',
    n_price: '15,800원',
    s_price: '12,640원',
    badge: ['런칭특가']
  },
  {
    detail_hash: 'HDF73',
    image: 'http://public.codesquad.kr/jk/storeapp/data/main/310_ZIP_P_0012_T.jpg',
    alt: '잡채',
    delivery_type: ['새벽배송', '전국택배'],
    title: '잡채',
    description: '탱글한 면발과 맛깔진 고명이 가득',
    n_price: '12,900원',
    s_price: '11,610원',
    badge: ['이벤트특가']
  },
  {
    detail_hash: 'HF778',
    image: 'http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg',
    alt: '소갈비찜',
    delivery_type: ['새벽배송', '전국택배'],
    title: '소갈비찜',
    description: '촉촉하게 밴 양념이 일품',
    n_price: '28,900원',
    s_price: '26,010원',
    badge: ['이벤트특가', '메인특가']
  }
];

export default function MainCategory() {
  return (
    <Wrap>
      {SIDE_DISHES.map(({ image, title, description, s_price, n_price, badge }) => (
        <Card
          key={title}
          size="LARGE"
          imageURL={image}
          title={title}
          desc={description}
          sellingPrice={s_price}
          normalPrice={n_price}
          tags={badge}
        />
      ))}
    </Wrap>
  );
}

const Wrap = styled.div({
  display: 'flex',
  gap: '24px',
  paddingTop: '34px'
});
