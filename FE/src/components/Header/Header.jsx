import { useState } from "react";
import "./Header.scss";
import logo from "@/assets/image/logo.svg";
import cart from "@/assets/image/cart.svg";
import myPage from "@/assets/image/myPage.svg";
import search from "@/assets/image/search.svg";

function Logo() {
  return (
    <figure className="logo">
      <img src={logo} />
    </figure>
  );
}

const navCategory = [
  {
    id: "main1",
    mainCategory: "든든한 메인요리",
    subCategory: ["육류 요리", "해산물 요리"],
  },
  {
    id: "main2",
    mainCategory: "뜨끈한 국물요리",
    subCategory: ["국/탕/찌개"],
  },
  {
    id: "main3",
    mainCategory: "정갈한 밑반찬",
    subCategory: ["나물/무침", "조림/볶음", "절임/장아찌"],
  },
];

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
        <img src={search} />
      </figure>
      <figure>
        <img src={myPage} />
      </figure>
      <figure>
        <img src={cart} />
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
