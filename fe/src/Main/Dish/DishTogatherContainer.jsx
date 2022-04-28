import styled from 'styled-components';
import { MAIN_ITEMS } from 'MockData/dummyData';
import { ReactComponent as LeftArrowIcon } from 'image/leftArrow.svg';
import { ReactComponent as RightArrowIcon } from 'image/rightArrow.svg';
import { FlexDiv } from 'common/FlexDiv';
import Card from 'Main/Card';
import { DISH_TOGATHER_MAX_COUNT } from 'constant';

const Header = styled.div`
  margin-bottom: 28px;
`;

const PageNav = styled.div`
  display: flex;

  .page__slash {
    margin: 0 8px;
  }
`;

const LeftArrow = styled(LeftArrowIcon)`
  cursor: pointer;
  margin-right: 17px;

  path {
    stroke: ${({ theme }) => theme.colors.gray3};
  }
`;

const RightArrow = styled(RightArrowIcon)`
  cursor: pointer;
  margin-left: 17px;

  path {
    stroke: ${({ theme }) => theme.colors.black};
  }
`;

const DishTogatherContainer = () => {
  const items = MAIN_ITEMS.data
    .map((item) => {
      return <Card key={item.id} item={item} imageSize={'small'}></Card>;
    })
    .slice(0, DISH_TOGATHER_MAX_COUNT);

  return (
    <>
      <Header>
        <FlexDiv row="space-between" column="center">
          <h3>함께하면 더욱 맛있는 상품</h3>
          <PageNav>
            <LeftArrow />
            <span className="page__current">1</span>
            <span className="page__slash">/</span>
            <span className="page__last">2</span>
            <RightArrow />
          </PageNav>
        </FlexDiv>
      </Header>
      <FlexDiv>{items}</FlexDiv>
    </>
  );
};

export default DishTogatherContainer;
