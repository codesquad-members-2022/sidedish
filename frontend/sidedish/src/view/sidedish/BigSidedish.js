import { useState } from "react";
import "./BigSidedish.css";

function SidedischCard() {
    return (
        <ul className="big-sidedish__cards">
            <li className="big-sidedish__card">
                <div className="big-sidedish__card-img-container">
                    <img
                        className="big-sidedish__card-img"
                        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiB2hsfT2WUM3m26kHqcYyAc77UI_JU61u0w&usqp=CAU"
                    />
                </div>
                <div className="big-sidedish__card-item">
                    <div className="big-sidedish__card-item--text">
                        <h3 className="big-sidedish__card-name">
                            오리 주물럭_반조리
                        </h3>
                        <p className="big-sidedish__card-description">
                            감칠맛 나는 매콤한 양념
                        </p>
                        <div className="big-sidedish__card-prices">
                            <span className="big-sidedish__card-price--default">
                                12,640원
                            </span>
                            <span className="big-sidedish__card-price--option">
                                15,800원
                            </span>
                        </div>
                    </div>
                    <span className="big-sidedish__card-tag--launch">
                        런칭특가
                    </span>
                </div>
            </li>
        </ul>
    );
}

function TabMenu(props) {
    const tabMenu = [
        "풍성한 고기 반찬",
        "편리한 반찬 세트",
        "맛있는 제철 요리",
        "우리 아이 영양 반찬",
    ];

    const tabMenuTemplate = tabMenu.map((menuName, idx) => {
        let tabMenuClassName = "big-sidedish__menu-item";
        if (idx === props.currTab) {
            tabMenuClassName += " current-tab";
        }
        return (
            <li
                className={tabMenuClassName}
                index={idx}
                key={idx}
                onClick={() => {
                    props.onChangeCurrTab(idx);
                }}
            >
                {menuName}
            </li>
        );
    });

    return tabMenuTemplate;
}

function BigSidedish() {
    const [currTab, setTab] = useState(0);
    const changeTab = (index) => {
        setTab(index);
    };

    return (
        <div className="big-sidedish">
            <div className="big-sidedish__header">
                <h2 className="big-sidedish__title">
                    한 번 주문하면 두 번 반하는 반찬
                </h2>
                <ul className="big-sidedish__tab-menu">
                    <TabMenu currTab={currTab} onChangeCurrTab={changeTab} />
                </ul>
            </div>
            <SidedischCard currTab={currTab} />
        </div>
    );
}

export default BigSidedish;
