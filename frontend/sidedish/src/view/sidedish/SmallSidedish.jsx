import { useEffect, useState } from "react";
import { Container, SmallDishTitle } from "./Sidedish.style";
import { API } from "../../config";
import SidedishCards from "./SidedishCards";
import { getData } from "../../utils";
import { Carousel } from "./carousel/Carousel";

function SmallSidedish({ isVisible, category }) {
    const { title, section } = category;

    const [smallSidedishes, setSmallSidedishes] = useState(null);
    const [page, setPage] = useState(1);
    const [lastCachedPage, setLastPage] = useState(0);
    const [hasNext, sethasNextValue] = useState(null);

    useEffect(() => {
        try {
            if (lastCachedPage < page && isVisible) {
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
    }, [isVisible, section, smallSidedishes, page, lastCachedPage]);

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
            return [
                smallSidedishes.length - 5 >= 0
                    ? smallSidedishes[smallSidedishes.length - 5]
                    : null,
                ...smallSidedishes.slice(smallSidedishes.length - 4),
                null,
            ];
        }
        return [
            page <= 1 ? null : smallSidedishes[4 * (page - 1) - 1],
            ...smallSidedishes.slice(4 * (page - 1), 4 * page),
            4 * page >= smallSidedishes.length
                ? null
                : smallSidedishes[4 * page],
        ];
    };

    const currSmallSidedishes = getCurrSmallSidedishes();

    console.log(currSmallSidedishes);
    return (
        <Container>
            <SmallDishTitle>{title}</SmallDishTitle>
            <Carousel
                page={page}
                onUpdatePage={onUpdatePage}
                currDataSize={smallSidedishes.length}
                hasNext={hasNext}
            >
                <SidedishCards dishes={currSmallSidedishes}></SidedishCards>
            </Carousel>
        </Container>
    );
}

export default SmallSidedish;
