import { Link } from "react-router-dom";

const IconMenu = ({ name, className, index }) => {
  return (
    <li
      key={index}
      className={`header__icon-menu header__icon-menu--${className}`}
    >
      <Link to="#">{name}</Link>
    </li>
  );
};

export default IconMenu;
