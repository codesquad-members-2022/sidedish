import React from "react";
import { useState } from "react";
import { Container, CarouselItems, Icon } from "./Carousel.style";

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

    return (
        <Container>
            <Icon
                onClick={() => {
                    if (page - 1 !== 0) {
                        updateIndex(activeIndex - 1);
                        onUpdatePage(page - 1);
                    }
                }}
                clickable={page > 1}
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
            <CarouselItems
                style={{ transform: `translateX(-${activeIndex * 100}%)` }}
            >
                {React.Children.map(children, (child) => {
                    return React.cloneElement(child, { width: "100%" });
                })}
            </CarouselItems>
            <Icon
                onClick={() => {
                    if (hasNext || 4 * page < currDataSize) {
                        updateIndex(activeIndex + 1);
                        onUpdatePage(page + 1);
                    }
                }}
                clickable={hasNext || 4 * page < currDataSize}
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
