import styled from 'styled-components';
import { F_basic } from '../../../Assets/CommonStyle';
import Card from './Card';

const List = styled.div`
  ${F_basic}
  width: calc(100% + ${(props) => props.itemGap});
  margin-left: calc(-${(props) => props.itemGap} / 2);

  > div {
    flex-shrink: 0;
    width: calc(
      (100% / ${(props) => props.viewItemCount}) - ${(props) => props.itemGap}
    );
    margin: 0 calc(${(props) => props.itemGap} / 2);
  }
`;

export default function FoodList({ food, viewItemCount, itemGap }) {
  const card = food.map((data) => (
    <Card key={data.detail_hash} cardData={data} />
  ));

  return (
    <List viewItemCount={viewItemCount} itemGap={itemGap}>
      {card}
    </List>
  );
}
