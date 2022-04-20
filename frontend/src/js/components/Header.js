import React, { useState } from "react";
import { pageHeaderIcon, searchIcon, userIcon, myCartIcon } from "../constants/iconPath.js";
import { category } from "../data/category.js";
import "../../css/Header.css";

function Header() {
  const [isOpen, setIsOpen] = useState(false);

  const categoryList = category.map((element) => (
    <li key={element.id} className="mainCategory">
      {element.mainCategory.title}
      <ul className="subCategoryList">
        {element.mainCategory.subCategory.map((element) => (
          <li key={element.id} className="subCategory" style={{ display: isOpen ? "flex" : "none" }}>
            {element.title}
          </li>
        ))}
      </ul>
    </li>
  ));

  return (
    <header className={"header " + (isOpen ? "isOpen" : "")}>
      <h1 className="brandHeader">
        <img src={pageHeaderIcon} alt="pageHeaderIcon"></img>
      </h1>
      <div className="category" onMouseOver={() => setIsOpen(true)} onMouseOut={() => setIsOpen(false)}>
        <ul className="categoryList">{categoryList}</ul>
      </div>
      <div className="navRightBar">
        <a href="#!" className="search">
          <img className="searchIcon" src={searchIcon} alt="searchIcon"></img>
        </a>
        <a href="#!" className="user">
          <img className="userIcon" src={userIcon} alt="userIcon"></img>
        </a>
        <a href="#!" className="myCart">
          <img className="myCartIcon" src={myCartIcon} alt="myCartIcon"></img>
        </a>
      </div>
    </header>
  );
}

export { Header };
