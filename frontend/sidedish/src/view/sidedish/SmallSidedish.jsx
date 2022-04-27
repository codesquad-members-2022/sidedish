import { useEffect, useState } from "react";
import { ThemeProvider } from "styled-components";
import { Container, Title } from "./Sidedish.style";
import { API } from "../../config";
import SidedishCards from "./SidedishCards";
import { getData } from "../../utils";

const theme = {
    size: "small",
};

function SmallSidedish({ isVisible, section, title }) {
    const [items, setItems] = useState(null);

    useEffect(() => {
        try {
            getData(API.DISH_SECTION + section, setItems);
        } catch (error) {
            console.error(error);
        }
    }, [section]);

    if (!isVisible || !items) {
        return;
    }

    return (
        <ThemeProvider theme={theme}>
            <Container>
                <Title>{title}</Title>
                <SidedishCards dishes={items.data}></SidedishCards>
            </Container>
        </ThemeProvider>
    );
}

export default SmallSidedish;
