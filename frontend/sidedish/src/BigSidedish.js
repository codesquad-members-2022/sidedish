import { useState, useEffect } from "react";
import "./BigSidedish.css";

function SidedishCard(props) {
    const dishData = props.dishData;
    const event = dishData.event_badge;

    return (
        <li className="big-sidedish__card" key={dishData.dish_id}>
            <div className="big-sidedish__card-img-container">
                <img
                    className="big-sidedish__card-img"
                    src={dishData.image_url}
                />
            </div>
            <div className="big-sidedish__card-item">
                <div className="big-sidedish__card-item--text">
                    <h3 className="big-sidedish__card-name">
                        {dishData.title}
                    </h3>
                    <p className="big-sidedish__card-description">
                        {dishData.description}
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
                <span className="big-sidedish__card-tag--launch">런칭특가</span>
            </div>
        </li>
    );
}

function SidedishCards() {
    const [sidedishCards, setSidedishCards] = useState([]);
    useEffect(() => {
        const getData = async (url) => {
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw Error(response.statusText);
                }
                const dishesData = await response.json();
                const dishes = dishesData.data.dishes;
                console.log(dishes);

                const sidedischCards = dishes.map((dish) => (
                    <SidedishCard dishData={dish} />
                ));

                setSidedishCards(sidedischCards);
            } catch (error) {
                console.error(error);
            }
        };
        getData(
            "https://273b4433-0674-40c4-9d88-6ab939cd01f8.mock.pstmn.io/api/dish?festival=%ED%92%8D%EC%84%B1%ED%95%9C-%EA%B3%A0%EA%B8%B0-%EB%B0%98%EC%B0%AC&page=1"
        );
    }, []);

    return <ul className="big-sidedish__cards">{sidedishCards}</ul>;
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
                key={idx}
                onClick={() => props.onChangeTab(idx)}
            >
                {menuName}
            </li>
        );
    });

    return <ul className="big-sidedish__tab-menu">{tabMenuTemplate}</ul>;
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
                <TabMenu currTab={currTab} onChangeTab={changeTab} />
            </div>
            <SidedishCards currTab={currTab} />
        </div>
    );
}

export default BigSidedish;
