import { useEffect, useState } from "react";
import { ThemeProvider } from "styled-components";
import { Container, Header, Title, CardsContainer } from "./Sidedish.style";
import { API } from "../../config";
import Card from "./card/Card";

const theme = {
    size: "small",
};

function SmallSidedishCard() {
    const [error, setError] = useState("null");
    const [isLoaded, setIsLoaded] = useState("false");
    const [items, setItems] = useState([]);

    useEffect(() => {
        fetch(API.DISH_SECTION + "정갈한-밑반찬")
            .then((res) => res.json())
            .then(
                (result) => {
                    setItems(result);
                    setIsLoaded(true);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            );
    }, []);

    if (isLoaded === true) {
        return (
            <>
                {items.data.map((dish) => (
                    <Card
                        key={dish.dishId}
                        title={dish.title}
                        image={dish.imagePath}
                        description={dish.description}
                        price={dish.price}
                    />
                ))}
            </>
        );
    }
}

function SmallSidedish() {
    return (
        <ThemeProvider theme={theme}>
            <Container>
                <Header>
                    <Title>식탁을 풍성하게 하는 정갈한 밑반찬</Title>
                </Header>
                <CardsContainer>
                    <SmallSidedishCard />
                </CardsContainer>
            </Container>
        </ThemeProvider>
    );
}

export default SmallSidedish;
