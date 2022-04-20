import React, { useState } from "react";

import "./Header.css";

const Header = () => {
  const [isHovered, setIsHovered] = useState(false);

  const onMouseEnterHandler = () => {
    setIsHovered(true);
  };

  const onMouseLeaveHandler = () => {
    setIsHovered(false);
  };

  return (
    <div className={`header-wrapper ${isHovered ? "active" : ""}`}>
      <header
        className="header"
        onMouseEnter={onMouseEnterHandler}
        onMouseLeave={onMouseLeaveHandler}
      >
        <div className="header-left">
          <h1 className="header-title">Ordering</h1>
          <span className="header-nav">
            든든한 메인요리
            <div
              className={`header-menu__extended ${isHovered ? "active" : ""}`}
            >
              <ul>
                <li>육류 요리</li>
                <li>해산물 요리</li>
              </ul>
            </div>
          </span>

          <span className="header-nav">
            뜨끈한 국물요리
            <div
              className={`header-menu__extended ${isHovered ? "active" : ""}`}
            >
              <ul>
                <li>국/탕/찌개</li>
              </ul>
            </div>
          </span>
          <span className="header-nav">
            정갈한 밑반찬
            <div
              className={`header-menu__extended ${isHovered ? "active" : ""}`}
            >
              <ul>
                <li>나물/무침</li>
                <li>조림/볶음</li>
                <li>절임/장아찌</li>
              </ul>
            </div>
          </span>
        </div>
        <div className="header-right">
          <div className="search-icon"></div>
          <div className="mypage-icon"></div>
          <div className="cart-icon"></div>
        </div>
      </header>
    </div>
  );
};

export default Header;
