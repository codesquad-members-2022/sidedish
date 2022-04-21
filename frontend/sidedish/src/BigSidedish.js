import { useState, useEffect } from "react";
import "./BigSidedish.css";
import styled from "styled-components";

const Price = styled.span`
    font-weight: ${(props) => (props.isClientPrice ? "500" : "400")};
    font-size: ${(props) => (props.isClientPrice ? "1.6rem" : "1.4rem")};
    line-height: ${(props) => (props.isClientPrice ? "26px" : "24px")};
    letter-spacing: -0.008em;
    text-decoration-line: ${(props) =>
        props.isClientPrice ? "none" : "line-through"};
    color: ${(props) => (props.isClientPrice ? "#1b1b1b" : "#bcbcbc")};
`;

const EventBadge = styled.span`
    font-weight: 500;
    font-size: 1.2rem;
    line-height: 18px;
    letter-spacing: -0.008em;
    color: #fff;
    padding: 6px 8px;
    border-radius: 25px;
    margin-top: 22px;
    background-color: ${(props) =>
        props.eventName === "런칭특가" ? "#ff8e14" : "#6dd028"};
`;

function SidedishCard(props) {
    const dishData = props.dishData;
    const eventBadge = dishData.event_badge;

    let clientPrice;
    let originalPrice;
    let eventTag;

    if (Object.keys(eventBadge).length) {
        const saledPrice = (dishData.price * (100 - eventBadge.discount)) / 100;

        clientPrice = <Price isClientPrice={true}>{saledPrice}원</Price>;
        originalPrice = <Price isClientPrice={false}>{dishData.price}원</Price>;
        eventTag = (
            <EventBadge eventName={eventBadge.event_name}>
                {eventBadge.event_name}
            </EventBadge>
        );
    } else {
        clientPrice = <Price isClientPrice={true}>{dishData.price}원</Price>;
    }

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
                        <>
                            {clientPrice}
                            {originalPrice}
                        </>
                    </div>
                </div>
                {eventTag}
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

const MenuItem = styled.li`
    font-size: 2rem;
    font-weight: 500;
    line-height: 30px;
    letter-spacing: -0.008em;
    text-align: center;
    padding-bottom: 15px;
    cursor: pointer;
    border-bottom: ${(props) => (props.isCurrTab ? "solid 2px black" : "")};
`;

function TabMenu(props) {
    const tabMenu = [
        "풍성한 고기 반찬",
        "편리한 반찬 세트",
        "맛있는 제철 요리",
        "우리 아이 영양 반찬",
    ];

    const tabMenuTemplate = tabMenu.map((menuName, idx) => {
        return (
            <MenuItem
                isCurrTab={idx === props.currTab}
                key={idx}
                onClick={() => props.onChangeTab(idx)}
            >
                {menuName}
            </MenuItem>
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
            <SidedishCards />
        </div>
    );
}

export default BigSidedish;
