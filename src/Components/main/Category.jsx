import styled from 'styled-components';
import FoodList from './food/List';
import { FOOD_DATA } from '../../Store/foodData';
import { Inner } from '../../Assets/CommonStyle';
import Title from '../Title';
import SlideButton from '../SlideButton';

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

export function Category({ info }) {
  const CATEGORIES = info.map((category) => {
    return <CategoryItem category={category} key={category.path} />;
  });

  return <CategoryContainer>{CATEGORIES}</CategoryContainer>;
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
            <FoodList food={Food} vieewItemCount={category.viewItemCount} />
          </ListContainer>
          <SlideButton direction="next" />
        </SlideWrapper>
      </Inner>
    </CategoryArticle>
  );
}
