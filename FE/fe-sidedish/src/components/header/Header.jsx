import React from "react";
import Categories from "./Categories";
import Menus from "./Menus";

const Header = () => {
  return (
    <header className="header">
      <div className="wrapper-80">
        <h2 className="header__title">Ordering</h2>
        <Categories />
        <Menus />
      </div>
    </header>
  );
};

export default Header;
