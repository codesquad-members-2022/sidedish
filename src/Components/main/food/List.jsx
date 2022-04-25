import Card from './Card';

export default function FoodList({ food }) {
  const card = food.map((data) => (
    <Card key={data.detail_hash} cardData={data} />
  ));

  return <ul>{card}</ul>;
}
