import React, {useState} from 'react';
import {pageHeaderIcon, searchIcon, userIcon, myCartIcon} from 'constants';
import {category} from 'data';
import {NavIcon} from 'components';
import './Header.css';

function Header() {
  const [isOpen, setIsOpen] = useState(false);

  const navIcons = [
    {name: 'searchIcon', src: `${searchIcon}`},
    {name: 'userIcon', src: `${userIcon}`},
    {name: 'myCartIcon', src: `${myCartIcon}`},
  ];

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
          {navIcons.map(nav => (
            <NavIcon name={nav.name} src={nav.src} />
          ))}
        </nav>
      </div>
    </header>
  );
}

export {Header};
