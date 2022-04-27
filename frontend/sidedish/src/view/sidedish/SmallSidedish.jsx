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
    const [smallSidedishes, setSmallSidedishes] = useState(null);
    const [page, setPage] = useState(1);
    const [lastCachedPage, setLastPage] = useState(0);
    const [hasNext, sethasNextValue] = useState(null);

    useEffect(() => {
        try {
            if (lastCachedPage < page) {
                getData(API.DISH_SECTION + section + "&page=" + page).then(
                    (data) => {
                        if (page === 1) {
                            setSmallSidedishes(data.data);
                        } else {
                            setSmallSidedishes([
                                ...smallSidedishes,
                                ...data.data,
                            ]);
                        }
                        setLastPage(page);
                        sethasNextValue(data.hasNext);
                    }
                );
            }
        } catch (error) {
            console.error(error);
        }
    }, [section, smallSidedishes, page, lastCachedPage]);

    if (!isVisible) {
        return;
    }

    if (!smallSidedishes) {
        return;
    }

    const onUpdatePage = (newPage) => {
        setPage(newPage);
    };

    const getCurrSmallSidedishes = () => {
        if (4 * page >= smallSidedishes.length) {
            return smallSidedishes.slice(smallSidedishes.length - 4);
        }
        return smallSidedishes.slice(4 * (page - 1), 4 * page);
    };

    const currSmallSidedishes = getCurrSmallSidedishes();

    return (
        <ThemeProvider theme={theme}>
            <Container>
                <Title>{title}</Title>
                <Carousel
                    page={page}
                    onUpdatePage={onUpdatePage}
                    currDataSize={smallSidedishes.length}
                    hasNext={hasNext}
                >
                    <SidedishCards dishes={currSmallSidedishes}></SidedishCards>
                </Carousel>
            </Container>
        </ThemeProvider>
    );
}

export default SmallSidedish;
