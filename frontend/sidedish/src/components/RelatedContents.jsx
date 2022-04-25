import styled from "styled-components";
import { makePriceFormat } from "../util/makePriceFormat";

const RelatedContents = ({ relatedListState, setRelatedListState }) => {
  const list = relatedListState.data.map(({ image, title, s_price, n_price }, ind) => {
    return (
      <Content key={ind}>
        <ContentImg src={image} />
        <ContentTitle>{title}</ContentTitle>
        <ContentPrice>
          <SalePrice>{makePriceFormat(s_price)}원</SalePrice>
          <MenuPrice>{makePriceFormat(n_price)}원</MenuPrice>
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
