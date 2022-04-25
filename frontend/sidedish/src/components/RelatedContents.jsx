import styled from "styled-components";

const RelatedContents = ({ relatedListState, setRelatedListState }) => {
  // const list = relatedListState.data.map(() => );
  return (
    <>
      <List>
        <Content>
          <ContentImg src={relatedListState.data[0].image} />
          <ContentTitle />
          <ContentPrice>
            <SalePrice></SalePrice>
            <MenuPrice></MenuPrice>
          </ContentPrice>
        </Content>
      </List>
    </>
  );
};

const List = styled.div``;

const Content = styled.div``;

const ContentImg = styled.img`
  width: 100px;
  height: 100px;
`;

const ContentTitle = styled.div``;

const ContentPrice = styled.div``;

const SalePrice = styled.div``;

const MenuPrice = styled.div``;

export default RelatedContents;
