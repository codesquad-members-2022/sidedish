import { CategoryList } from './CategoryList';
import { BestProducts } from './BestProducts';
import styled from 'styled-components';

const MainWrapper = styled.main`
  width: 1440px;
  padding: 0 80px;
  margin: 0 auto;
`;

export const Main = props => {
  return (
    <MainWrapper>
      <BestProducts />
      <CategoryList
        categories={props.categories}
        loadedCategories={props.loadedCategories}
        setLoadedCategories={props.setLoadedCategories}
      />
    </MainWrapper>
  );
};
