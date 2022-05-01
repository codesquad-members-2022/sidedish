import react from 'react';
import { useEffect, useState, useRef } from "react";
import 'Carousel.css';

function CarouselItem({ children, width }) {
    return (
        <div className="carousel-item" style={{ width: width }}>
            {children}
        </div>
    );
}

function RecommendCarousel({ children }) {
    const [activeIndex, setActiveIndex] = useState(0);
    const updateIndex = (newIndex) => {
        if (newIndex < 0) {
            newIndex = 0;
        } else if (newIndex >= react.Children.count(children)) {
            newIndex = react.Children.count(children) - 1;
        }

        setActiveIndex(newIndex);
    };
    return (
        <>
            <div className="carousel">
                <div
                    className="inner"
                    style={{ transform: `translateX(-${activeIndex * 100}%)` }}
                >
                    {react.Children.map(children, (child, index) => {
                        return react.cloneElement(child, { width: "100%" });
                    })}
                </div>
            </div>
            <div className="indicators">
                <button
                    onClick={() => {
                        updateIndex(activeIndex - 1);
                    }}
                >
                    Prev
                </button>
                <button
                    onClick={() => {
                        updateIndex(activeIndex + 1);
                    }}
                >
                    Next
                </button>
            </div>
        </>
    );
}

export default {RecommendCarousel, CarouselItem};