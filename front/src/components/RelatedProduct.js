import React from 'react';
import styled from 'styled-components';
import nextBlackBtnSrc from '../images/nextBlackBtn.svg';
import prevBlackBtnSrc from '../images/prevBlackBtn.svg';
import Card from './Card';

const RelatedProductWrap = styled.div`
  width: 100%;
  height: 396px;
  box-sizing: border-box;
  padding: 48px;
  display: flex;
  flex-direction: column;
  justify-content: center;
`;
const TitleAndNavButtons = styled.div`
  width: 100%;
  height: 30px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 28px;
`;
const Title = styled.div`
  font-size: 20px;
  line-height: 30px;
`;
const NavButtons = styled.div`
  display: flex;
  gap: 17px;
`;
const PrevButton = styled.img`
  width: 8px;
  height: 16px;
  background-size: cover;
`;
const NextButton = styled(PrevButton)``;
const PageInfo = styled.div`
  display: flex;
  align-items: flex-start;
  gap: 8px;
`;
const AllPage = styled.div`
  font-weight: 400;
  font-size: 14px;
`;
const CurrentPage = styled(AllPage)`
  font-weight: bold;
`;
const Slash = styled(AllPage)``;

const RelatedProductSlide = styled.div`
  display: flex;
  justify-content: space-between;
`;
function RelatedProduct(relatedDishes) {
  return (
    <RelatedProductWrap>
      <TitleAndNavButtons>
        <Title>함께하면 더욱 맛있는 상품</Title>
        <NavButtons>
          <PrevButton src={prevBlackBtnSrc}></PrevButton>
          <PageInfo>
            <CurrentPage>1</CurrentPage>
            <Slash>/</Slash>
            <AllPage>2</AllPage>
          </PageInfo>
          <NextButton src={nextBlackBtnSrc}></NextButton>
        </NavButtons>
      </TitleAndNavButtons>
      <RelatedProductSlide>
        {relatedDishes.dishes.map((dishes, index) => (
          <Card key={index} size={'small'} item={dishes.item}></Card>
        ))}
      </RelatedProductSlide>
    </RelatedProductWrap>
  );
}

export default RelatedProduct;
