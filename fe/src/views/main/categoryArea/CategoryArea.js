import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { API } from '../../../helper/constants';
import { applyFlex, fetchData } from '../../../helper/utils';
import { Category } from './category/category';
import { ExtendBtn } from './category/extendBtn';

export function CategoryArea() {
  const [categoryState, setCategoryState] = useState([]);
  const [activeCategory, setActiveCategory] = useState([]);
  const [buttonState, setButtonState] = useState('보기');

  useEffect(() => {
    async function addSideDishesToCategory(categoryResponses) {
      for (let categoryResponse of categoryResponses) {
        const { categoryId } = categoryResponse;
        const { totalCount, sideDishCardResponses } = await fetchData(API.categoryDishes(categoryId, 0));

        for (let page = 1; page * 4 < totalCount; page++) {
          const { sideDishCardResponses: sideDishes } = await fetchData(API.categoryDishes(categoryId, page));
          sideDishes.forEach(sideDish => {
            sideDishCardResponses.push(sideDish);
          });
        }
        categoryResponse.totalCount = totalCount;
        categoryResponse.sideDishCardResponses = sideDishCardResponses;
      }
    }
    async function getCategoryData() {
      const { categoryResponses } = await fetchData(API.category);
      await addSideDishesToCategory(categoryResponses);
      setCategoryState(categoryResponses);
      setActiveCategory([0]);
    }
    getCategoryData();
  }, []);

  function handleClick() {
    if (buttonState === '보기') {
      setActiveCategory(categoryState.map((_, idx) => idx));
      setButtonState('닫기');
      return;
    }
    setActiveCategory([0]);
    setButtonState('보기');
  }

  return (
    <CategoryContainer flex direction="column">
      {activeCategory.map(idx => (
        <Category
          key={categoryState[idx].categoryId}
          title={categoryState[idx].categoryTitle}
          sideDishCardResponses={categoryState[idx].sideDishCardResponses}
        />
      ))}
      <ExtendBtn buttonState={buttonState} onClick={handleClick}></ExtendBtn>
    </CategoryContainer>
  );
}

const CategoryContainer = styled.div`
  ${({ flex, direction }) => applyFlex({ flex, direction })};
  position: relative;
`;
