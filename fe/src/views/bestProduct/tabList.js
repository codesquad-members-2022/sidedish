import { StyledDiv } from './BestProduct.styled';
import { Card } from '../../components/Card';

export function TapList(props) {
  if (!props.tapList) {
    return ``;
  }
  return (
    <StyledDiv flex>
      {props.tapList.map((product, idx) => (
        <Card product={product} key={idx} />
      ))}
    </StyledDiv>
  );
}
