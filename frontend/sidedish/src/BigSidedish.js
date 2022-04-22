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
    margin-right: 8px;
    background-color: ${(props) =>
        props.eventName === "런칭특가" ? "#ff8e14" : "#6dd028"};
`;

function SidedishCard(props) {
    const dishData = props.dishData;
    const eventBadges = dishData.eventBadges;

    let clientPrice;
    let originalPrice;
    let eventTags;

    if (eventBadges) {
        const saledPrice =
            dishData.price * ((100 - eventBadges[0].discount) / 100);

        clientPrice = <Price isClientPrice={true}>{saledPrice}원</Price>;
        originalPrice = <Price isClientPrice={false}>{dishData.price}원</Price>;
        eventTags = eventBadges.map((eventBadge) => (
            <EventBadge
                key={eventBadge.eventBadgeId}
                eventName={eventBadge.eventBadgeName}
            >
                {eventBadge.eventBadgeName}
            </EventBadge>
        ));
    } else {
        clientPrice = <Price isClientPrice={true}>{dishData.price}원</Price>;
    }

    return (
        <li className="big-sidedish__card">
            <div className="big-sidedish__card-img-container">
                <img
                    alt={dishData.title}
                    className="big-sidedish__card-img"
                    src={dishData.imagePath}
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
                {eventTags}
            </div>
        </li>
    );
}

function SidedishCards(props) {
    // 목데이터가 덜 완성돼서 임시로 데이터가 없는 경우를 처리해주었습니다.
    if (!props.sidedishData.dishes) {
        return <p>{props.sidedishData.categoryName}</p>;
    }

    const sidedishCards = props.sidedishData.dishes.map((dish) => (
        <SidedishCard key={dish.dishId} dishData={dish} />
    ));
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
    const tabMenuTemplate = props.tabMenu.map((tab, idx) => {
        return (
            <MenuItem
                isCurrTab={idx === props.currTab}
                key={tab.id}
                onClick={() => props.onChangeTab(idx)}
            >
                {tab.name}
            </MenuItem>
        );
    });

    return <ul className="big-sidedish__tab-menu">{tabMenuTemplate}</ul>;
}

function BigSidedish() {
    const [currTab, setTab] = useState(0);
    const [bigSidedishData, setBigSidedishData] = useState(null);
    const changeTab = (index) => {
        setTab(index);
    };

    useEffect(() => {
        const getData = async (url) => {
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw Error(response.statusText);
                }

                const data = await response.json();
                setBigSidedishData(data);
            } catch (error) {
                console.error(error);
            }
        };
        getData(
            "https://273b4433-0674-40c4-9d88-6ab939cd01f8.mock.pstmn.io/api/categories?festival=한-번-주문하면-두-번-반하는-반찬"
        );
    }, []);

    if (!bigSidedishData) {
        return;
    }

    const tabMenu = bigSidedishData.map((sidedish) => {
        return {
            id: sidedish.categoryId,
            name: sidedish.categoryName,
        };
    });

    return (
        <div className="big-sidedish">
            <div className="big-sidedish__header">
                <h2 className="big-sidedish__title">
                    한 번 주문하면 두 번 반하는 반찬
                </h2>
                <TabMenu
                    currTab={currTab}
                    tabMenu={tabMenu}
                    onChangeTab={changeTab}
                />
            </div>
            <SidedishCards sidedishData={bigSidedishData[currTab]} />
        </div>
    );
}

export default BigSidedish;
