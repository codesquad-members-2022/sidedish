import styled from "styled-components";
import { makePriceFormat } from "../../util/makePriceFormat";

const RelatedContents = ({ relatedListState }) => {
  const list = relatedListState.dishes.map(({ dishId, mainImage, title, price, n_price }) => {
    return (
      <Content key={dishId}>
        <ContentImg src={mainImage} />
        <ContentTitle>{title}</ContentTitle>
        <ContentPrice>
          <SalePrice>{makePriceFormat(price)}</SalePrice>
          <MenuPrice>{makePriceFormat(n_price)}</MenuPrice>
        </ContentPrice>
      </Content>
    );
  });
  return (
    <>
      <List>{list}</List>
    </>
  );
};

const List = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Content = styled.div`
  display: flex;
  flex-direction: column;
`;

const ContentImg = styled.img`
  width: 160px;
  height: 160px;
  padding-bottom: 8px;
`;

const ContentTitle = styled.div`
  font-size: 14px;
  padding-bottom: 8px;
  color: #3f3f3f;
`;

const ContentPrice = styled.div`
  display: flex;
`;

const SalePrice = styled.div`
  font-weight: 500;
  padding-right: 8px;
`;

const MenuPrice = styled.div`
  font-size: 14px;
  color: #bcbcbc;
  text-decoration: line-through;
`;

export default RelatedContents;
