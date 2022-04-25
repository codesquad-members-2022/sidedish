import styled from 'styled-components';

import { ProductCard } from '@/Components/ProductCard';

const CategoryProductsWrapper = styled.li`
  width: 1280px;
  margin-top: 56px;

  &:last-child {
    margin-bottom: 80px;
  }
`;

const Header = styled.header`
  margin-bottom: 40px;
`;

const ProductCardList = styled.ul`
  display: flex;
  justify-content: flex-start;
`;

export const CategoryProducts = props => {
  return (
    <CategoryProductsWrapper>
      <Header className={'fonts-xl-bold'}>{props.title}</Header>
      <ProductCardList>
        {props.categoryProductsData.map(categoryProductData => (
          <ProductCard size={'md'} data={categoryProductData} key={categoryProductData.id} />
        ))}
      </ProductCardList>
    </CategoryProductsWrapper>
  );
};
