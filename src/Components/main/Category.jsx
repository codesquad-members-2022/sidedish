import styled from 'styled-components';
import FoodList from './food/List';
import { FOOD_DATA } from '../../Store/foodData';
import { Inner } from '../../Assets/CommonStyle';
import Title from '../Title';
import SlideButton from '../SlideButton';
import { useState } from 'react';

const CategoryContainer = styled.section`
  padding-top: 56px;
`;

const CategoryArticle = styled.article`
  margin-bottom: 79px;
`;

const SlideWrapper = styled.div`
  position: relative;
  margin-top: 40px;
`;

const ListContainer = styled.section`
  overflow: hidden;
`;

const CategoryButton = styled.button`
  display: block;
  width: 203px;
  height: 62px;
  margin: 56px auto;
  border: 1px solid ${({ theme }) => theme.Color.gray4};
  font-size: ${({ theme }) => theme.FontSize.Large};
  font-weight: ${({ theme }) => theme.FontWeight.Regular};
  color: ${({ theme }) => theme.Color.gray1};
`;

export function Category({ info }) {
  const [isViewAll, setView] = useState(false);
  const [viewCategory, setViewCategory] = useState([info[0]]);

  const categoryViewHandler = () => {
    setView(true);
    setViewCategory(info);
  };

  const Categories = viewCategory.map((category) => {
    return <CategoryItem category={category} key={category.path} />;
  });

  return (
    <CategoryContainer>
      {Categories}
      {!isViewAll ? (
        <CategoryButton onClick={categoryViewHandler}>
          모든 카테고리 보기
        </CategoryButton>
      ) : null}
    </CategoryContainer>
  );
}

function CategoryItem({ category }) {
  const Food = FOOD_DATA[category.path].body;

  return (
    <CategoryArticle>
      <Inner>
        <Title title={category.title} fontSize="XLarge" fontWeight="Bold" />
        <SlideWrapper>
          <SlideButton direction="prev" />
          <ListContainer>
            <FoodList
              food={Food}
              viewItemCount={category.viewItemCount}
              itemGap="24px"
            />
          </ListContainer>
          <SlideButton direction="next" />
        </SlideWrapper>
      </Inner>
    </CategoryArticle>
  );
}
