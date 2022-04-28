import React from "react";
import { useState } from "react";
import { Container, Icon, CarouselItem, Wrapper } from "./Carousel.style";

const isClickable = (direction, params) => {
    if (direction === "R") {
        const { hasNext, page, currDataSize } = params;
        return hasNext || 4 * page < currDataSize;
    }
    return params.page > 1;
};

function Carousel({ page, onUpdatePage, currDataSize, hasNext, children }) {
    const [direction, setDirection] = useState(null);

    const onClick = (direction) => {
        switch (direction) {
            case "L": {
                if (isClickable("L", { page })) {
                    onUpdatePage(page - 1);
                    setDirection("L");
                }
                break;
            }
            case "R": {
                if (isClickable("R", { hasNext, page, currDataSize })) {
                    onUpdatePage(page + 1);
                    setDirection("R");
                }
                break;
            }
            default:
        }
    };

    return (
        <Container>
            <Icon
                onClick={() => onClick("L")}
                clickable={isClickable("L", { page })}
                className="icon"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                strokeWidth="2"
            >
                <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M15 19l-7-7 7-7"
                />
            </Icon>
            <Wrapper>
                <CarouselItem direction={direction}>{children}</CarouselItem>
            </Wrapper>
            <Icon
                onClick={() => onClick("R")}
                clickable={isClickable("R", { hasNext, page, currDataSize })}
                className="icon"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                strokeWidth="2"
            >
                <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M9 5l7 7-7 7"
                />
            </Icon>
        </Container>
    );
}

export { Carousel };
