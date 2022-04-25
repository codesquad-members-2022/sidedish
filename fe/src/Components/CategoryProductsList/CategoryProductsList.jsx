import { useState, useEffect } from 'react';
import styled from 'styled-components';

import { CategoryProducts } from './CategoryProducts';

import Colors from '@/Constants/Colors';
import { fetchData } from '@/Utils/Utils';

const CategoryProductsListWrapper = styled.ul`
  padding: 0 80px;
`;

const MoreButton = styled.button`
  display: block;
  padding: 16px 24px;
  margin: 56px auto;
  border: 1px solid ${Colors.PALE_GREY};
  color: ${Colors.DARK_GREY};
  transition: all 200ms;

  &:hover {
    background-color: ${Colors.DARK_GREY};
    color: ${Colors.WHITE};
  }

  &:active {
    opacity: 0.5;
  }
`;

const LoadingErrorMessage = styled.span`
  display: block;
  margin-top: 100px;
  text-align: center;
`;

export const CategoryProductsList = props => {
  const [moreButtonClicked, setMoreButtonClicked] = useState(false);
  const [retry, setRetry] = useState(false);

  const handleClickMoreButton = () => {
    setMoreButtonClicked(true);
  };

  useEffect(() => {
    if (!moreButtonClicked) return;
    // Promise.all 로 남은 카테고리 모두 가져온 뒤 update
    // TODO: 실패한 데이터만 다시 불러올 수 있도록 고치기
    const categoryIds = props.categoryList.map(category => category.id);
    const loadedCategoryId = props.categoryProductsList[0].id;
    const unloadedCategoryIds = categoryIds.filter(
      id => id !== loadedCategoryId
    );
    const requests = unloadedCategoryIds.map(id =>
      fetchData(`/category/${id}`)
    );

    Promise.all(requests)
      .then(categoryProductsListData => {
        const categoryProductsList = categoryProductsListData.map(
          (categoryProductsData, idx) => ({
            id: unloadedCategoryIds[idx],
            title: categoryProductsData.content[0].mainCategory,
            content: categoryProductsData.content,
          })
        );
        props.setCategoryProductsList([
          ...props.categoryProductsList,
          ...categoryProductsList,
        ]);
      })
      .catch(() => {
        setMoreButtonClicked(false);
        setRetry(true);
      });
  }, [moreButtonClicked]);

  return (
    <CategoryProductsListWrapper>
      {props.categoryProductsList.map(categoryProducts => (
        <CategoryProducts
          key={categoryProducts.id}
          title={categoryProducts.title}
          categoryProductsData={categoryProducts.content}
        />
      ))}
      {!moreButtonClicked && (
        <li>
          {retry && (
            <LoadingErrorMessage className={'fonts-lg'}>
              데이터를 불러오는데 오류가 발생했습니다.
            </LoadingErrorMessage>
          )}
          {props.isInitialDataLoaded && (
            <MoreButton onClick={handleClickMoreButton} className={'fonts-lg'}>
              모든 카테고리 보기
            </MoreButton>
          )}
        </li>
      )}
    </CategoryProductsListWrapper>
  );
};