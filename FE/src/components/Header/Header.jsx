import { useState } from "react";
import "./Header.scss";
import logo from "@/assets/image/logo.svg";
import cart from "@/assets/image/cart.svg";
import myPage from "@/assets/image/myPage.svg";
import search from "@/assets/image/search.svg";
import { navCategory } from "@/constant/constant";

function Logo() {
  return (
    <figure className="logo">
      <img src={logo} alt="logo" />
    </figure>
  );
}

function MainCategoryNav({ setIsShown }) {
  const mainNav = navCategory.map((nav) => (
    <li key={nav.id} className="category-nav__main">
      {nav.mainCategory}
    </li>
  ));
  return (
    <nav
      className="category-nav"
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainNav}
    </nav>
  );
}

function MainSubCategoryNav({ setIsShown }) {
  //TODO: 컴포넌트 분리하게되면 서브 카테고리 생성 메서드 분리하기
  const mainSubNav = navCategory.map((category) => {
    const subCategory = category.subCategory.map((subCategory, index) => {
      return (
        <li className="category-nav__sub" key={`sub${index}`}>
          {subCategory}
        </li>
      );
    });

    return (
      <li className="category-nav__main" key={category.id}>
        <span>{category.mainCategory}</span>
        <ul>{subCategory}</ul>
      </li>
    );
  });

  return (
    <nav
      className="category-nav"
      onMouseEnter={() => {
        setIsShown(true);
      }}
    >
      {mainSubNav}
    </nav>
  );
}

function Nav({ isShown, setIsShown }) {
  if (isShown) {
    return <MainSubCategoryNav setIsShown={setIsShown} />;
  }
  return <MainCategoryNav setIsShown={setIsShown} />;
}

function Info() {
  return (
    <div className="info-container">
      <figure>
        <img src={search} alt="search" />
      </figure>
      <figure>
        <img src={myPage} alt="myPage" />
      </figure>
      <figure>
        <img src={cart} alt="cart" />
      </figure>
    </div>
  );
}

export function Header() {
  const [isShown, setIsShown] = useState(false);
  return (
    <header
      onMouseLeave={() => {
        setIsShown(false);
      }}
    >
      <Logo />
      <Nav isShown={isShown} setIsShown={setIsShown} />
      <Info />
    </header>
  );
}
