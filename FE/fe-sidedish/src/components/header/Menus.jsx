import { Link } from "react-router-dom";
import iconMenus from "../../data/iconMenus";
import IconMenu from "./IconMenu";

const Menus = () => {
  return (
    <div className="header__menus">
      <Link to="#" className="header__login">
        로그인
      </Link>
      <ul className="header__icon-menus">
        {iconMenus.map(({ name, className }, index) => (
          <IconMenu name={name} className={className} key={index} />
        ))}
      </ul>
    </div>
  );
};

export default Menus;
