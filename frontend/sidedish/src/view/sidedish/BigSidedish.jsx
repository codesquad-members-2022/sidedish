import { useState, useEffect } from "react";
import { Container, Header, Title, CardsContainer } from "./Sidedish.style";
import { API } from "../../config";
import { ThemeProvider } from "styled-components";
import Card from "./card/Card";
import TabMenu from "./tabMenu/TabMenu";

const theme = {
    size: "big",
};

function SidedishCards({ sidedishData }) {
    // 목데이터가 덜 완성돼서 임시로 데이터가 없는 경우를 처리해주었습니다.
    if (!sidedishData.dishes) {
        return <p>{sidedishData.categoryName}</p>;
    }

    const sidedishCards = sidedishData.dishes.map((dish) => {
        return (
            <Card
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
        <ThemeProvider theme={theme}>
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
        </ThemeProvider>
    );
}

export default BigSidedish;
