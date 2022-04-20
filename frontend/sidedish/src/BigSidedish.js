import "./BigSidedish.css";

function BigSidedish() {
    return (
        <div className="big-sidedish">
            <div className="big-sidedish__header">
                <h2 className="big-sidedish__title">
                    한 번 주문하면 두 번 반하는 반찬
                </h2>
                <ul className="big-sidedish__tab-menu">
                    <li className="big-sidedish__menu-item">
                        풍성한 고기 반찬
                    </li>
                    <li className="big-sidedish__menu-item">
                        편리한 반찬 세트
                    </li>
                    <li className="big-sidedish__menu-item">
                        맛있는 제철 요리
                    </li>
                    <li className="big-sidedish__menu-item">
                        우리 아이 영양 반찬
                    </li>
                </ul>
            </div>
            <ul className="big-sidedish__cards">
                <li className="big-sidedish__card">
                    <div className="big-sidedish__card-img-container">
                        <img
                            className="big-sidedish__card-img"
                            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiB2hsfT2WUM3m26kHqcYyAc77UI_JU61u0w&usqp=CAU"
                        />
                    </div>
                    <div className="big-sidedish__card-item">
                        <h3 className="big-sidedish__card-name">
                            오리 주물럭_반조리
                        </h3>
                        <p className="big-sidedish__card-description">
                            감칠맛 나는 매콤한 양념
                        </p>
                        <div className="big-sidedish__card-prices">
                            <span className="big-sidedish__card-price">
                                12,640원
                            </span>
                            <span className="big-sidedish__card-price">
                                15,800원
                            </span>
                        </div>
                        <p className="big-sidedish__card-tag">런칭특가</p>
                    </div>
                </li>
            </ul>
        </div>
    );
}

export default BigSidedish;
