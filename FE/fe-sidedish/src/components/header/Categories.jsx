import nav from "../../data/nav";
import SubCategories from "./SubCategories";

const Categories = () => {
  return (
    <ul className="header__categories">
      {nav.map(({ category, subCategories }, index) => (
        <li key={index} className="header__category">
          <p className="header__category-name">{category}</p>
          <SubCategories subCategories={subCategories} />
        </li>
      ))}
    </ul>
  );
};

export default Categories;
