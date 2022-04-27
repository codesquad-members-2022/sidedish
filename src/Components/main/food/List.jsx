import styled from 'styled-components';
import { F_basic } from '../../../Assets/CommonStyle';
import Card from './Card';

const List = styled.div`
  ${F_basic}
  width: calc(100% + 24px);
  margin-left: -12px;

  > div {
    flex-shrink: 0;
    width: calc((100% / ${(props) => props.vieewItemCount}) - 24px);
    margin: 0 12px;
  }
`;

export default function FoodList({ food, vieewItemCount }) {
  const card = food.map((data) => (
    <Card key={data.detail_hash} cardData={data} />
  ));

  return <List vieewItemCount={vieewItemCount}>{card}</List>;
}
