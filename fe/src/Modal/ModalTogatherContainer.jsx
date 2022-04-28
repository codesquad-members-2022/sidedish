import styled from 'styled-components';
import { ReactComponent as LeftArrowIcon } from 'image/leftArrow.svg';
import { ReactComponent as RightArrowIcon } from 'image/rightArrow.svg';
import { FlexDiv } from 'common/FlexDiv';
import { SERVER_URL, DISH_TOGATHER_MAX_COUNT } from 'constant';
import { useFetch } from 'useFetch';
import Card from 'Main/Card';
import Loading from 'common/Loading';
import ErrorComponent from 'common/Error';

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
    stroke: ${({ theme }) => theme.colors.gray3};
  }
`;

const ModalTogatherContainer = () => {
  const [dishes, isLoading, isError] = useFetch(`${SERVER_URL}dishes/1/recommend`);

  const items = dishes
    .map((item) => {
      return <Card key={item.id} item={item} imageSize={'small'}></Card>;
    })
    .slice(0, DISH_TOGATHER_MAX_COUNT);

  if (isError) {
    return <ErrorComponent />;
  }

  return (
    <>
      <Header>
        <FlexDiv row="space-between" column="center">
          <h3>함께하면 더욱 맛있는 상품</h3>
          <PageNav>
            <LeftArrow />
            <span className="page__current">1</span>
            <span className="page__slash">/</span>
            <span className="page__last">1</span>
            <RightArrow />
          </PageNav>
        </FlexDiv>
      </Header>
      {isLoading ? <Loading /> : <FlexDiv>{items}</FlexDiv>}
    </>
  );
};

export default ModalTogatherContainer;
