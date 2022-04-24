import { useState, useEffect } from 'react';
import styled from 'styled-components';

import { Category } from './Category';

import Colors from '@/Constants/Colors';

const CategoryListWrapper = styled.ul``;

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

export const CategoryList = props => {
  const [moreButtonClicked, setMoreButtonClicked] = useState(false);
  const [retry, setRetry] = useState(false);

  const handleClickMoreButton = () => {
    setMoreButtonClicked(true);
  };

  useEffect(() => {
    if (!moreButtonClicked) return;
    // Promise.all 로 남은 카테고리 모두 가져온 뒤 update
    // TODO: 실패한 데이터만 다시 불러올 수 있도록 고치기
    const categoryIds = props.categories.map(category => category.id);
    const loadedCategoryId = props.loadedCategories[0].id;
    const unloadedCategoryIds = categoryIds.filter(
      id => id !== loadedCategoryId
    );
    const requests = unloadedCategoryIds.map(id => fetch(`/category/${id}`));

    Promise.all(requests)
      .then(responses => {
        return Promise.all(responses.map(response => response.json()));
      })
      .then(dataArr => {
        const parsedData = dataArr.map((categoryData, idx) => ({
          id: unloadedCategoryIds[idx],
          title: dataArr[idx].content[0].mainCategory,
          content: dataArr[idx].content,
        }));
        props.setLoadedCategories([...props.loadedCategories, ...parsedData]);
      })
      .catch(() => {
        setMoreButtonClicked(false);
        setRetry(true);
      });
  }, [moreButtonClicked]);

  return (
    <CategoryListWrapper>
      {props.loadedCategories.map(category => {
        return (
          <Category
            key={category.id}
            title={category.title}
            cardData={category.content}
          />
        );
      })}
      {!moreButtonClicked && (
        <li>
          {retry && (
            <LoadingErrorMessage className={'fonts-lg'}>
              데이터를 불러오는데 오류가 발생했습니다.
            </LoadingErrorMessage>
          )}
          <MoreButton onClick={handleClickMoreButton} className={'fonts-lg'}>
            모든 카테고리 보기
          </MoreButton>
        </li>
      )}
    </CategoryListWrapper>
  );
};
