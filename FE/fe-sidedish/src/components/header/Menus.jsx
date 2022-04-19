import { Link } from "react-router-dom";
import iconMenus from "../../data/iconMenus";

const Menus = () => {
  return (
    <div className="header__menus">
      <Link to="#" className="header__login">
        로그인
      </Link>
      <ul className="header__icon-menus">
        {iconMenus.map(({ name, className }, index) => (
          <li
            key={index}
            className={`header__icon-menu header__icon-menu--${className}`}
          >
            {name}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Menus;
