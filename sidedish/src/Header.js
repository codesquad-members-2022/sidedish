import "./Header.css";

function Header() {
    return (
        <header>
            <h1 class="header__title">Ordering</h1>
            <nav class="header__nav">
                <ul class="header__nav-list">
                    <li class="header__food">
                        <p class="header__food-title">든든한 메인요리</p>
                        <ul class="header__food-list hidden">
                            <li class="header__food-item">육류 요리</li>
                            <li class="header__food-item">해산물 요리</li>
                        </ul>
                    </li>
                    <li class="header__food">
                        <p class="header__food-title">뜨끈한 국물요리</p>
                        <ul class="header__food-list hidden">
                            <li class="header__food-item">국/탕/찌개</li>
                        </ul>
                    </li>
                    <li class="header__food">
                        <p class="header__food-title">정갈한 밑반찬</p>
                        <ul class="header__food-list hidden">
                            <li class="header__food-item">나물/무침</li>
                            <li class="header__food-item">조림/볶음</li>
                            <li class="header__food-item">절임/장아찌</li>
                        </ul>
                    </li>
                </ul>
                <ul class="header__icons">
                    <li class="header__icon-item">
                        <svg
                            class="header__icon-search h-6 w-6"
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke="currentColor"
                            stroke-width="2"
                        >
                            <path
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
                            />
                        </svg>
                    </li>
                    <li class="header__icon-item">
                        <svg
                            class="header__icon-user h-5 w-5"
                            xmlns="http://www.w3.org/2000/svg"
                            viewBox="0 0 20 20"
                            fill="currentColor"
                        >
                            <path
                                fill-rule="evenodd"
                                d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z"
                                clip-rule="evenodd"
                            />
                        </svg>
                    </li>
                    <li class="header__icon-item">
                        <svg
                            class="header__icon-cart h-5 w-5"
                            xmlns="http://www.w3.org/2000/svg"
                            viewBox="0 0 20 20"
                            fill="currentColor"
                        >
                            <path d="M3 1a1 1 0 000 2h1.22l.305 1.222a.997.997 0 00.01.042l1.358 5.43-.893.892C3.74 11.846 4.632 14 6.414 14H15a1 1 0 000-2H6.414l1-1H14a1 1 0 00.894-.553l3-6A1 1 0 0017 3H6.28l-.31-1.243A1 1 0 005 1H3zM16 16.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM6.5 18a1.5 1.5 0 100-3 1.5 1.5 0 000 3z" />
                        </svg>
                    </li>
                </ul>
            </nav>
        </header>
    );
}
