import { useState, useEffect } from "react";
import {
    Container,
    Header,
    Title,
    TabBar,
    Tab,
    CardsContainer,
    CardImgWrapper,
    CardImg,
    CardTextContainer,
    CardTitle,
    CardDescription,
    PriceContainer,
    Price,
    EventBadge,
} from "./BigSidedish.style";
import { API } from "./config";

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
        <li>
            <CardImgWrapper>
                <CardImg alt={title} src={image} />
            </CardImgWrapper>
            <div>
                <CardTextContainer>
                    <CardTitle>{title}</CardTitle>
                    <CardDescription>{description}</CardDescription>
                    <PriceContainer>
                        <>
                            {clientPrice}
                            {originalPrice}
                        </>
                    </PriceContainer>
                </CardTextContainer>
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
    return <CardsContainer>{sidedishCards}</CardsContainer>;
}

function TabMenu({ currTab, tabMenu, onChangeTab }) {
    const tabMenuTemplate = tabMenu.map((tab, idx) => {
        return (
            <Tab
                isCurrTab={idx === currTab}
                key={tab.id}
                onClick={() => onChangeTab(idx)}
            >
                {tab.name}
            </Tab>
        );
    });

    return <TabBar>{tabMenuTemplate}</TabBar>;
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
        <Container>
            <Header>
                <Title>한 번 주문하면 두 번 반하는 반찬</Title>
                <TabMenu
                    currTab={currTab}
                    tabMenu={tabMenu}
                    onChangeTab={changeTab}
                />
            </Header>
            <SidedishCards sidedishData={bigSidedishData[currTab]} />
        </Container>
    );
}

export default BigSidedish;
