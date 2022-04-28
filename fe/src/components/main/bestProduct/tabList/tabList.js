import { StyledDiv } from './tabList.styled';
import { ProductCard } from '../../../../common/productCard/ProductCard';

export function TabList({ tabList, setModal }) {
  if (!tabList) {
    return ``;
  }

  return (
    <StyledDiv flex>
      {tabList.map(product => (
        <ProductCard product={product} key={product.sideDishId} size="large" onClick={setModal} />
      ))}
    </StyledDiv>
  );
}
