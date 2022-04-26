import { StyledDiv } from './tabList.styled';
import { ProductCard } from '../../../../components/productCard/ProductCard';

export function TabList({ tabList }) {
  if (!tabList) {
    return ``;
  }
  return (
    <StyledDiv flex>
      {tabList.map(product => (
        <ProductCard product={product} key={product.sideDishId} size="large" />
      ))}
    </StyledDiv>
  );
}
