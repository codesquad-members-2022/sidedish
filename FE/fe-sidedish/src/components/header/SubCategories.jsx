import { Link } from "react-router-dom";

const SubCategories = ({ subCategories }) => {
  return (
    <ul className="header__sub-categories">
      {subCategories.map((subCategory, index) => (
        <li key={index} className="header__sub-category">
          <Link to="#">{subCategory}</Link>
        </li>
      ))}
    </ul>
  );
};

export default SubCategories;
