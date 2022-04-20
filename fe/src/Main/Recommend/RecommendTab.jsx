import { useState } from 'react';
import styled, { css } from 'styled-components';
import RecommendTabList from './RecommendTabList';

const RecommendTabBar = styled.ul`
  display: flex;
  list-style: none;
`;

const RecommendTabBarItem = styled.li`
  margin-right: 32px;
  padding-bottom: 17px;
  text-align: center;
  cursor: pointer;
  ${(props) =>
    props.focus === props.id &&
    css`
      border-bottom: 2px solid #1b1b1b;
    `}
  ${({ theme }) => theme.fontStyles.largeBold};
`;

const items = [
  {
    id: 1,
    title: '풍성한 고기 반찬',
    data: [
      {
        id: 1,
        img: 'https://random.imagecdn.app/412/412',
        title: '오리 주물럭_반조리',
        desc: '감칠맛 나는 매콤한 양념',
        salePrice: 12640,
        normalPrice: 15800,
        tag: '런칭특가',
      },
      {
        id: 2,
        img: 'https://random.imagecdn.app/412/412',
        title: '돼지 주물럭_반조리',
        desc: '감칠맛 나는 매콤한 양념',
        salePrice: 12640,
        normalPrice: 15800,
        tag: '이벤트특가',
      },
      {
        id: 3,
        img: 'https://random.imagecdn.app/412/412',
        title: '달콤 오리 주물럭_반조리',
        desc: '감칠맛 나는 달콤한 양념',
        salePrice: 12640,
        normalPrice: 15800,
        tag: '런칭특가',
      },
    ],
  },
  {
    id: 2,
    title: '편리한 반찬 세트',
    data: [
      {
        id: 1,
        img: 'https://random.imagecdn.app/412/412',
        title: '간장 소갈비찜',
        desc: '촉촉하게 벤 양념이 일품',
        salePrice: 26010,
        normalPrice: 28900,
        tag: '이벤트특가',
      },
      {
        id: 2,
        img: 'https://random.imagecdn.app/412/412',
        title: '매운 소갈비찜',
        desc: '촉촉하게 벤 양념이 일품',
        salePrice: 26010,
        normalPrice: 28900,
        tag: '런칭특가',
      },
      {
        id: 3,
        img: 'https://random.imagecdn.app/412/412',
        title: '마라 소갈비찜',
        desc: '촉촉하게 벤 양념이 일품',
        salePrice: 26010,
        normalPrice: 28900,
        tag: '이벤트특가',
      },
    ],
  },
  {
    id: 3,
    title: '맛있는 제철 요리',
    data: [
      {
        id: 1,
        img: 'https://random.imagecdn.app/412/412',
        title: '간장 쭈꾸미',
        desc: '쫄낏한 쭈구미',
        // salePrice: 16900,
        normalPrice: 16900,
        tag: '이벤트특가',
      },
      {
        id: 2,
        img: 'https://random.imagecdn.app/412/412',
        title: '매콤 쭈꾸미',
        desc: '쫄낏한 쭈구미',
        // salePrice: 16900,
        normalPrice: 16900,
        tag: '이벤트특가',
      },
      {
        id: 3,
        img: 'https://random.imagecdn.app/412/412',
        title: '쭈꾸미',
        desc: '쫄낏한 쭈구미',
        // salePrice: 16900,
        normalPrice: 16900,
        tag: '이벤트특가',
      },
    ],
  },
  {
    id: 4,
    title: '우리 아이 영양 반찬',
    data: [
      {
        id: 1,
        img: 'https://random.imagecdn.app/412/412',
        title: '새콤달콤 오징어무침',
        desc: '국내산 오징어를 새콤달콤하게',
        salePrice: 6000,
        normalPrice: 7500,
        tag: '런칭특가',
      },
      {
        id: 2,
        img: 'https://random.imagecdn.app/412/412',
        title: '새콤달콤 오징어무침',
        desc: '국내산 오징어를 새콤달콤하게',
        salePrice: 6000,
        normalPrice: 7500,
        tag: '런칭특가',
      },
      {
        id: 3,
        img: 'https://random.imagecdn.app/412/412',
        title: '새콤달콤 오징어무침',
        desc: '국내산 오징어를 새콤달콤하게',
        salePrice: 6000,
        normalPrice: 7500,
        tag: '런칭특가',
      },
    ],
  },
];

const RecommendTab = () => {
  const [focus, setFocus] = useState(1);
  const onClick = (e) => {
    const id = e.currentTarget.id;
    setFocus(Number(id));
  };
  const tabBarList = items.map((item) => {
    return (
      <RecommendTabBarItem key={item.id} id={item.id} onClick={onClick} focus={focus}>
        <p>{item.title}</p>
      </RecommendTabBarItem>
    );
  });

  return (
    <>
      <RecommendTabBar>{tabBarList}</RecommendTabBar>
      <RecommendTabList items={items[focus - 1]}></RecommendTabList>
    </>
  );
};

export default RecommendTab;
