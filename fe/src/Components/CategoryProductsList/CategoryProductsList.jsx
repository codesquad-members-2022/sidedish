import { useState, useEffect } from 'react';
import styled from 'styled-components';

import {Colors} from '@/Constants';

import { CategoryProducts } from './CategoryProducts';


const CategoryProductsListWrapper = styled.ul`
  padding: 0 80px;
`;

const MoreButton = styled.button`
  display: block;
  padding: 16px 24px;
  margin: 80px auto 150px;
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

export const CategoryProductsList = props => {
  const [moreButtonClicked, setMoreButtonClicked] = useState(false);
  const [loadedCategoryProductsIdList, setLoadedCategoryProductsIdList] =
    useState([]);

  const handleClickMoreButton = () => {
    setMoreButtonClicked(true);
    const allCategoryProductsIdList = props.categoryList.map(
      category => category.id
    );
    const unloadedCategoryProductsIdList = allCategoryProductsIdList.filter(
      id => !loadedCategoryProductsIdList.includes(id)
    );
    setLoadedCategoryProductsIdList([
      ...loadedCategoryProductsIdList,
      ...unloadedCategoryProductsIdList,
    ]);
  };

  useEffect(() => {
    if (!props.categoryList.length) return;
    const firstCategoryIdx = 0;
    const firstCategoryId = props.categoryList[firstCategoryIdx].id;
    setLoadedCategoryProductsIdList([firstCategoryId]);
  }, [props.categoryList]);

  return (
    <CategoryProductsListWrapper>
      {loadedCategoryProductsIdList.map(categoryId => (
        <CategoryProducts key={categoryId} categoryId={categoryId} />
      ))}
      {!moreButtonClicked && (
        <MoreButton onClick={handleClickMoreButton} className={'fonts-lg'}>
          모든 카테고리 보기
        </MoreButton>
      )}
    </CategoryProductsListWrapper>
  );
};
