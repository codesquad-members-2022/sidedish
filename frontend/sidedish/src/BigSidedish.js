import { useState, useEffect } from "react";
import "./BigSidedish.css";
import styled from "styled-components";
import { API } from "./config";

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
        props.eventBadgeColor === "orange"
            ? "#ff8e14"
            : "green"
            ? "#6dd028"
            : ""};
`;

function EventBadges({ eventBadges }) {
    return eventBadges.map((eventBadge) => (
        <EventBadge
            key={eventBadge.eventBadgeId}
            eventBadgeColor={
                eventBadge.eventBadgeName === "런칭특가" ? "orange" : "green"
            }
        >
            {eventBadge.eventBadgeName}
        </EventBadge>
    ));
}

function SidedishCard({ title, image, description, price, eventBadges }) {
    const saledPrice = eventBadges
        ? price * ((100 - eventBadges[0].discount) / 100)
        : 0;
    const clientPrice = (
        <Price isClientPrice>
            {eventBadges ? saledPrice.toLocaleString() : price.toLocaleString()}
            원
        </Price>
    );
    const originalPrice = eventBadges ? (
        <Price isClientPrice={false}>{price.toLocaleString()}원</Price>
    ) : (
        ""
    );
    const eventTags = eventBadges ? (
        <EventBadges eventBadges={eventBadges} />
    ) : (
        ""
    );

    return (
        <li className="big-sidedish__card">
            <div className="big-sidedish__card-img-container">
                <img
                    alt={title}
                    className="big-sidedish__card-img"
                    src={image}
                />
            </div>
            <div className="big-sidedish__card-item">
                <div className="big-sidedish__card-item--text">
                    <h3 className="big-sidedish__card-name">{title}</h3>
                    <p className="big-sidedish__card-description">
                        {description}
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

function SidedishCards({ sidedishData }) {
    // 목데이터가 덜 완성돼서 임시로 데이터가 없는 경우를 처리해주었습니다.
    if (!sidedishData.dishes) {
        return <p>{sidedishData.categoryName}</p>;
    }

    const sidedishCards = sidedishData.dishes.map((dish) => {
        return (
            <SidedishCard
                key={dish.dishId}
                title={dish.title}
                image={dish.imagePath}
                description={dish.description}
                price={dish.price}
                eventBadges={dish.eventBadges}
            />
        );
    });
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

function TabMenu({ currTab, tabMenu, onChangeTab }) {
    const tabMenuTemplate = tabMenu.map((tab, idx) => {
        return (
            <MenuItem
                isCurrTab={idx === currTab}
                key={tab.id}
                onClick={() => onChangeTab(idx)}
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

        getData(API.FESTIVAL + "한-번-주문하면-두-번-반하는-반찬");
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
