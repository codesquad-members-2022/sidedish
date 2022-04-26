import React, {useState} from 'react';
import {pageHeaderIcon} from '../constants/iconPath.js';
import {category} from '../data/category.js';
import {NavIcon} from './NavIcon.jsx';
import '../../css/Header.css';

function Header() {
  const [isOpen, setIsOpen] = useState(false);

  const categoryList = category.map(element => (
    <li key={element.id} className="mainCategory">
      {element.mainCategory.title}
      <ul className="subCategoryList">
        {element.mainCategory.subCategory.map(element => (
          <li key={element.id} className="subCategory" style={{display: isOpen ? 'flex' : 'none'}}>
            {element.title}
          </li>
        ))}
      </ul>
    </li>
  ));

  return (
    <header className={'header ' + (isOpen ? 'isOpen' : '')}>
      <div className="innerHeader">
        <h1 className="brandHeader">
          <img src={pageHeaderIcon} alt="pageHeaderIcon"></img>
        </h1>
        <div className="category" onMouseOver={() => setIsOpen(true)} onMouseOut={() => setIsOpen(false)}>
          <ul className="categoryList">{categoryList}</ul>
        </div>
        <nav className="navBar">
          <NavIcon />
        </nav>
      </div>
    </header>
  );
}

export {Header};
