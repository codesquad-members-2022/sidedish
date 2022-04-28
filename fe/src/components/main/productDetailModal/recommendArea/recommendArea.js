import { useEffect, useState } from 'react';
import { ProductCard } from '../../../../common/productCard/ProductCard';
import { API, buttonIcons } from '../../../../helper/constants';
import { fetchData, getUrlWithIdPage } from '../../../../helper/utils';
import { Btn, Header, HeaderContent, Main, RecommendContainer, SliderArea, Title } from './recommend.styled';

export function RecommendArea() {
  const [sideDishCardResponses, setSideDishCardResponses] = useState(null);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPage, setTotalPage] = useState(0);

  useEffect(() => {
    async function getRecommendData() {
      const URL = getUrlWithIdPage({ url: API.categoryDishes, id: 1, page: currentPage - 1 });
      const data = await fetchData(URL);
      const { sideDishCardResponses, totalCount } = data;
      setSideDishCardResponses(sideDishCardResponses);
      setTotalPage(Math.ceil(totalCount / 4));
    }
    getRecommendData();
  }, [currentPage]);

  function handleRightBtnClick() {
    if (totalPage === currentPage) {
      return;
    }
    setCurrentPage(currentPage + 1);
  }

  function handleLeftBtnClick() {
    if (currentPage === 1) {
      return;
    }
    setCurrentPage(currentPage - 1);
  }

  return (
    <RecommendContainer>
      <Header flex justify="space-between">
        <Title>함께하면 더욱 맛있는 상품</Title>
        <SliderArea flex align="center">
          <Btn onClick={handleLeftBtnClick}>{buttonIcons.left}</Btn>
          <HeaderContent>{totalPage === 0 ? '' : `${currentPage} / ${totalPage}`}</HeaderContent>
          <Btn onClick={handleRightBtnClick}>{buttonIcons.right}</Btn>
        </SliderArea>
      </Header>
      <Main flex>
        {!sideDishCardResponses
          ? ''
          : sideDishCardResponses.map(product => {
              return <ProductCard key={product.sideDishId} product={product} size="small"></ProductCard>;
            })}
      </Main>
    </RecommendContainer>
  );
}
