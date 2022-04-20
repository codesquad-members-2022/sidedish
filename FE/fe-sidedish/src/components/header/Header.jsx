import Categories from "./Categories";
import Menus from "./Menus";
import styles from "../../styles/components/header.scss";

const Header = () => {
  return (
    <header className="header">
      <div className="wrapper">
        <h2 className="header__title">Ordering</h2>
        <Categories />
        <Menus />
      </div>
    </header>
  );
};

export default Header;
