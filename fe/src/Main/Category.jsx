import styled from 'styled-components';
import { ProductCard } from './ProductCard';

const CategoryWrapper = styled.div`
  width: 1280px;
`;

const Header = styled.header`
  margin-bottom: 40px;
`;

const ProductCardList = styled.ul`
  display: flex;
  justify-content: flex-start;
`;

export const Category = props => {
  return (
    <CategoryWrapper>
      <Header className={'fonts-xl-bold'}>{props.title}</Header>
      <ProductCardList>
        {props.cardData.map(data => (
          <ProductCard size={'md'} data={data} key={data.id} />
        ))}
      </ProductCardList>
    </CategoryWrapper>
  );
};
