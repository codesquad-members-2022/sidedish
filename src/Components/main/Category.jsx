import FoodList from './food/List';
import { FOOD_DATA } from '../../Store/foodData';

export function Category({ info }) {
  const CATEGORIES = info.map((category) => {
    return <CategoryItem category={category} key={category.path} />;
  });

  return <section className="category_container">{CATEGORIES}</section>;
}

function CategoryItem({ category }) {
  const Food = FOOD_DATA[category.path].body;

  return (
    <article>
      <h2>{category.title}</h2>
      <FoodList food={Food} />
    </article>
  );
}
