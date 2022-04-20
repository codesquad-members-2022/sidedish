import styled from 'styled-components';
import Card from '../Card';
import leftArrow from '../../image/leftArrow.svg';
import rightArrow from '../../image/rightArrow.svg';

const DishContainerWrapper = styled.div`
  position: relative;
  padding: 34px 0 56px 0;

  h2 {
    margin-bottom: 40px;
    ${({ theme }) => theme.fontStyles.xLargeBold};
  }
`;

const DishCardList = styled.div`
  display: flex;
`;

const items = {
  id: 1,
  title: '식탁을 풍성하게 하는 정갈한 밑반찬',
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
    {
      id: 4,
      img: 'https://random.imagecdn.app/412/412',
      title: '달콤 오리 주물럭_반조리',
      desc: '감칠맛 나는 달콤한 양념',
      salePrice: 12640,
      normalPrice: 15800,
      tag: '런칭특가',
    },
  ],
};

const LeftArrow = styled.img`
  position: absolute;
  top: 50%;
  left: -42px;
  filter: invert(86%) sepia(34%) saturate(0%) hue-rotate(212deg) brightness(84%) contrast(88%);
`;

const RightArrow = styled.img`
  position: absolute;
  top: 50%;
  right: -42px;
`;

const DishContainer = () => {
  const cardList = items.data.map((item) => {
    return <Card key={item.id} item={item} imageSize={'medium'}></Card>;
  });

  return (
    <DishContainerWrapper>
      <h2>{items.title}</h2>
      <DishCardList>{cardList}</DishCardList>
      <LeftArrow src={leftArrow}></LeftArrow>
      <RightArrow src={rightArrow}></RightArrow>
    </DishContainerWrapper>
  );
};

export default DishContainer;
