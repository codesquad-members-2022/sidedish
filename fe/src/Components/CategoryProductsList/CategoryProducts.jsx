import { useState, useEffect } from 'react';
import styled from 'styled-components';

import { LoadingSpinner } from "@/Components/LoadingSpinner";
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

const useFetch = url => {
  const [data, setData] = useState([]);
  const [isLoaded, setIsLoaded] = useState(false);
  const [isError, setIsError] = useState(false);

  useEffect(() => {
    fetch(url)
      .then(res => res.json())
      .then(v => {
        setData(v);
        setIsLoaded(true);
      });
  }, [url]);

  return [data, isLoaded];
};

const parse = categoryProductsData => {
  const title = categoryProductsData.content[0].mainCategory;
  return {
    title,
    content: categoryProductsData.content,
  };
};

export const CategoryProducts = props => {
  const categoryId = props.categoryId;
  const [categoryProductsData, isLoaded] = useFetch(`/category/${categoryId}`);

  if (!isLoaded) return <LoadingSpinner />;
  const parsedCategoryProductsData = parse(categoryProductsData);

  return (
    <CategoryProductsWrapper>
      <Header className={'fonts-xl-bold'}>
        {parsedCategoryProductsData.title}
      </Header>
      <ProductCardList>
        {parsedCategoryProductsData.content.map(categoryProductData => (
          <ProductCard
            size={'md'}
            data={categoryProductData}
            key={categoryProductData.id}
          />
        ))}
      </ProductCardList>
    </CategoryProductsWrapper>
  );
};
