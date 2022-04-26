import styled from 'styled-components';

import { RetryButton } from '@/Components/Button';
import { LoadingSpinner } from '@/Components/LoadingSpinner';
import { ProductCard } from '@/Components/ProductCard';
import { useFetch } from '@/Hooks/useFetch';

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

const parse = categoryProductsData => {
  const title = categoryProductsData.content[0].mainCategory;
  return {
    title,
    content: categoryProductsData.content,
  };
};

export const CategoryProducts = props => {
  const categoryId = props.categoryId;
  const [categoryProductsData, isLoaded, isError, setRetry] = useFetch(
    `/category/${categoryId}`
  );

  const handleClickRetryButton = () => {
    setRetry(true);
  };

  if (isError) return <RetryButton onClick={handleClickRetryButton} />;
  if (!isLoaded) return <LoadingSpinner />;

  /* 임시: API 나오면 아마 삭제될 것 같습니다 */
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

