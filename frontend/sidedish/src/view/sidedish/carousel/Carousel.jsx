import React from "react";
import { useState } from "react";
import { Container, Icon } from "./Carousel.style";

const isClickable = (direction, params) => {
    if (direction === "R") {
        const { hasNext, page, currDataSize } = params;
        return hasNext || 4 * page < currDataSize;
    }
    return params.page > 1;
};

function Carousel({ page, onUpdatePage, currDataSize, hasNext, children }) {
    const [activeIndex, setActiveIndex] = useState(0);
    const updateIndex = (newIndex) => {
        if (newIndex < 0) {
            newIndex = 0;
        } else if (newIndex >= React.Children.count(children)) {
            newIndex = React.Children.count(children) - 1;
        }

        setActiveIndex(newIndex);
    };

    const onClick = (direction) => {
        switch (direction) {
            case "L": {
                if (isClickable("L", { page })) {
                    updateIndex(activeIndex - 1);
                    onUpdatePage(page - 1);
                }
                break;
            }
            case "R": {
                if (isClickable("R", { hasNext, page, currDataSize })) {
                    updateIndex(activeIndex + 1);
                    onUpdatePage(page + 1);
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
            <div>{children}</div>
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
