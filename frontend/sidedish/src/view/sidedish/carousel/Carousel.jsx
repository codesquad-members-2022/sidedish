import React from "react";
import { useState } from "react";
import { Container, CarouselItems, Icon } from "./Carousel.style";

function Carousel({ children }) {
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
                    updateIndex(activeIndex - 1);
                }}
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
                    updateIndex(activeIndex + 1);
                }}
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

function CarouselItem({ children }) {
    return (
        <div className="carousel-item" style={{ width: "100%" }}>
            {children}
        </div>
    );
}

export { Carousel, CarouselItem };
