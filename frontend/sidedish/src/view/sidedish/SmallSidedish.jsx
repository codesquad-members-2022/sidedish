import { useEffect, useState } from "react";
import { ThemeProvider } from "styled-components";
import { Container, Title } from "./Sidedish.style";
import { API } from "../../config";
import SidedishCards from "./SidedishCards";
import { getData } from "../../utils";

const theme = {
    size: "small",
};

function SmallSidedish() {
    const [items, setItems] = useState(null);

    useEffect(() => {
        try {
            getData(
                API.FESTIVAL + "한-번-주문하면-두-번-반하는-반찬",
                setItems
            );
        } catch (error) {
            console.error(error);
        }
    }, []);

    if (!items) {
        return;
    }

    return (
        <ThemeProvider theme={theme}>
            <Container>
                <Title>식탁을 풍성하게 하는 정갈한 밑반찬</Title>
                <SidedishCards dishes={items[0].dishes}></SidedishCards>
            </Container>
        </ThemeProvider>
    );
}

export default SmallSidedish;
