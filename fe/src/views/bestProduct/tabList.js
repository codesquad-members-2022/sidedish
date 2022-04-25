import { StyledDiv } from './BestProduct.styled';
import { ProductCard } from '../../components/ProductCard';

export function TabList({ tabList }) {
  if (!tabList) {
    return ``;
  }
  return (
    <StyledDiv flex>
      {tabList.map((product, idx) => (
        <ProductCard product={product} key={`${product}-${idx}`} size="large" />
      ))}
    </StyledDiv>
  );
}
