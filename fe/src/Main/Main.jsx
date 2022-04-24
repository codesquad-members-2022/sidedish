import styled from 'styled-components';

import { BestProducts } from './BestProducts';
import { CategoryList } from './CategoryList';

const MainWrapper = styled.main`
  width: 1440px;
  padding: 0 80px;
  margin: 0 auto;
`;

export const Main = props => {
  if (!props.categoryProductList.length) return null;

  return (
    <MainWrapper>
      <BestProducts />
      <CategoryList
        categoryList={props.categoryList}
        categoryProductList={props.categoryProductList}
        setCategoryProductList={props.setCategoryProductList}
      />
    </MainWrapper>
  );
};
