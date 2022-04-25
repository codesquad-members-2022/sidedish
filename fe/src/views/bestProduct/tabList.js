import { StyledDiv } from './BestProduct.styled';
import { ProductCard } from '../../components/ProductCard';

export function TapList(props) {
  if (!props.tapList) {
    return ``;
  }
  return (
    <StyledDiv flex>
      {props.tapList.map((product, idx) => (
        <ProductCard product={product} key={idx} size="large" />
      ))}
    </StyledDiv>
  );
}
