import styled from 'styled-components';
import Card from 'Main/Card';
import { ReactComponent as LeftArrowIcon } from 'image/leftArrow.svg';
import { ReactComponent as RightArrowIcon } from 'image/rightArrow.svg';
import { MAIN_ITEMS } from 'MockData/dummyData';

const DishContainerWrapper = styled.div`
  position: relative;
  padding: 34px 0 56px 0;

  h2 {
    margin-bottom: 40px;
    ${({ theme }) => theme.fontStyles.xLargeBold};
  }
`;

const DishCardList = styled.div`
  ${({ theme }) => theme.flexLayout.default};
`;

const LeftArrow = styled(LeftArrowIcon)`
  position: absolute;
  top: 50%;
  left: -42px;

  path {
    stroke: ${({ theme }) => theme.colors.gray3};
  }
`;

const RightArrow = styled(RightArrowIcon)`
  position: absolute;
  top: 50%;
  right: -42px;

  path {
    stroke: ${({ theme }) => theme.colors.black};
  }
`;

const DishContainer = () => {
  const cardList = MAIN_ITEMS.data.map((item) => {
    return <Card key={item.id} item={item} imageSize={'medium'}></Card>;
  });

  return (
    <DishContainerWrapper>
      <h2>{MAIN_ITEMS.title}</h2>
      <DishCardList>{cardList}</DishCardList>
      <LeftArrow />
      <RightArrow />
    </DishContainerWrapper>
  );
};

export default DishContainer;
