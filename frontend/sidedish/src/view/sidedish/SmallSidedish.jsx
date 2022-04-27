import { useEffect, useState } from "react";
import { ThemeProvider } from "styled-components";
import { Container, Title } from "./Sidedish.style";
import { API } from "../../config";
import SidedishCards from "./SidedishCards";
import { getData } from "../../utils";
import { Carousel } from "./carousel/Carousel";

const theme = {
    size: "small",
};

function SmallSidedish({ isVisible, section, title }) {
    const [items, setItems] = useState(null);
    const [page, setPage] = useState(1);

    useEffect(() => {
        try {
            getData(API.DISH_SECTION + section + "&page=" + page, setItems);
        } catch (error) {
            console.error(error);
        }
    }, [section, page]);

    if (!isVisible) {
        return;
    }

    if (!items) {
        return;
    }

    const onUpdatePage = (newPage) => {
        setPage(newPage);
    };

    return (
        <ThemeProvider theme={theme}>
            <Container>
                <Title>{title}</Title>
                <Carousel
                    page={page}
                    onUpdatePage={onUpdatePage}
                    hasNext={items.hasNext}
                >
                    <SidedishCards dishes={items.data}></SidedishCards>
                </Carousel>
            </Container>
        </ThemeProvider>
    );
}

export default SmallSidedish;
