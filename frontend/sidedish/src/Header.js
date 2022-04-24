import { useState } from "react";
import "./Header.css";
import styled from "styled-components";

const HeaderFoodList = styled.ul`
    display: ${(props) => (props.isVisible ? "flex" : "none")};
    flex-direction: column;
    gap: 8px;
`;

function NavItem(props) {
    const items = props.navItem.items.map((item) => (
        <li key={item.id} className="header__food-item">
            {item.title}
        </li>
    ));

    return (
        <li key={props.navItem.id} className="header__food">
            <p className="header__food-title">{props.navItem.title}</p>
            <HeaderFoodList isVisible={props.isVisible}>{items}</HeaderFoodList>
        </li>
    );
}

function Header() {
    const [isVisible, setVisibility] = useState(false);
    const showMenu = () => setVisibility(true);
    const hideMenu = () => setVisibility(false);
    const headerList = [
        {
            id: 0,
            title: "든든한 메인요리",
            items: [
                { id: 0, title: "육류 요리" },
                { id: 1, title: "해산물 요리" },
            ],
        },
        {
            id: 1,
            title: "뜨끈한 국물요리",
            items: [{ id: 0, title: "국/탕/찌개" }],
        },
        {
            id: 2,
            title: "정갈한 밑반찬",
            items: [
                { id: 0, title: "나물/무침" },
                { id: 1, title: "조림/볶음" },
                { id: 2, title: "절임/장아찌" },
            ],
        },
    ];

    const navList = headerList.map((navItem) => (
        <NavItem
            key={navItem.id}
            className="header__food"
            navItem={navItem}
            isVisible={isVisible}
        />
    ));

    return (
        <header>
            <div className="header">
                <h1 className="header__title">Ordering</h1>
                <nav className="header__nav">
                    <ul
                        className="header__nav-list"
                        onMouseOver={showMenu}
                        onMouseOut={hideMenu}
                    >
                        {navList}
                    </ul>
                    <ul className="header__icons">
                        <li className="header__icon-item">
                            <svg
                                className="header__icon-search h-6 w-6"
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                                strokeWidth="2"
                            >
                                <path
                                    strokeLinecap="round"
                                    strokeLinejoin="round"
                                    d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
                                />
                            </svg>
                        </li>
                        <li className="header__icon-item">
                            <a href="/">
                                <svg
                                    className="header__icon-user h-5 w-5"
                                    xmlns="http://www.w3.org/2000/svg"
                                    viewBox="0 0 20 20"
                                    fill="currentColor"
                                >
                                    <path
                                        fillRule="evenodd"
                                        d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z"
                                        clipRule="evenodd"
                                    />
                                </svg>
                            </a>
                        </li>
                        <li className="header__icon-item">
                            <svg
                                className="header__icon-cart h-5 w-5"
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 20 20"
                                fill="currentColor"
                            >
                                <path d="M3 1a1 1 0 000 2h1.22l.305 1.222a.997.997 0 00.01.042l1.358 5.43-.893.892C3.74 11.846 4.632 14 6.414 14H15a1 1 0 000-2H6.414l1-1H14a1 1 0 00.894-.553l3-6A1 1 0 0017 3H6.28l-.31-1.243A1 1 0 005 1H3zM16 16.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM6.5 18a1.5 1.5 0 100-3 1.5 1.5 0 000 3z" />
                            </svg>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
    );
}

export default Header;
