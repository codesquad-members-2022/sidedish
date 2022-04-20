import "./App.css";
import Header from "./Header";

function BigSidedish() {
    return (
        <div class="big-sidedish">
            <div class="big-sidedish__header">
                <h2 class="big-sidedish__title">
                    한 번 주문하면 두 번 반하는 반찬
                </h2>
                <ul class="big-sidedish__tab-menu">
                    <li class="big-sidedish__menu-item">풍성한 고기 반찬</li>
                    <li class="big-sidedish__menu-item">편리한 반찬 세트</li>
                    <li class="big-sidedish__menu-item">맛있는 제철 요리</li>
                    <li class="big-sidedish__menu-item">우리 아이 영양 반찬</li>
                </ul>
            </div>
            <ul class="big-sidedish__cards">
                <li class="sidedish__card">
                    <div class="sidedish__card-img-container">
                        <img class="sidedish__card-img" />
                    </div>
                    <div class="sidedish__card-item">
                        <h3 class="sidedish__card-name">오리 주물럭_반조리</h3>
                        <p class="sidedish__card-description">
                            감칠맛 나는 매콤한 양념
                        </p>
                        <div class="sidedish__card-prices">
                            <span class="sidedish__card-price">12,640원</span>
                            <span class="sidedish__card-price">15,800원</span>
                        </div>
                        <p class="sidedish__card-tag">런칭특가</p>
                    </div>
                </li>
            </ul>
        </div>
    );
}

function App() {
    return (
        <>
            <Header />
            <BigSidedish />
        </>
    );
}

export default App;
