import styled from "styled-components";

const ImgWrapper = styled.div`
    width: 100%
    height: 100%;
`;

const Img = styled.img`
    width: 100%;
    height: 100%;
    object-fit: cover;
`;

const TextContainer = styled.div`
    display: flex;
    flex-direction: column;
    gap: 8px;
    margin-top: 16px;
    margin-bottom: 22px;
`;

const Title = styled.h3`
    font-weight: 500;
    font-size: 1.6rem;
    line-height: 26px;
    letter-spacing: -0.008em;
    color: #3f3f3f;
`;

const Description = styled.p`
    font-weight: 400;
    font-size: 1.4rem;
    line-height: 24px;
    letter-spacing: -0.008em;
    color: #777;
`;

const PriceContainer = styled.div`
    display: flex;
    gap: 8px;
`;

const Price = styled.span`
    font-weight: ${(props) => (props.isClientPrice ? "500" : "400")};
    font-size: ${(props) => (props.isClientPrice ? "1.6rem" : "1.4rem")};
    line-height: ${(props) => (props.isClientPrice ? "26px" : "24px")};
    letter-spacing: -0.008em;
    text-decoration-line: ${(props) =>
        props.isClientPrice ? "none" : "line-through"};
    color: ${(props) => (props.isClientPrice ? "#1b1b1b" : "#bcbcbc")};
`;

const EventBadge = styled.span`
    font-weight: 500;
    font-size: 1.2rem;
    line-height: 18px;
    letter-spacing: -0.008em;
    color: #fff;
    padding: 6px 8px;
    border-radius: 25px;
    margin-top: 22px;
    margin-right: 8px;
    background-color: ${(props) =>
        props.eventBadgeColor === "orange"
            ? "#ff8e14"
            : "green"
            ? "#6dd028"
            : ""};
`;

export {
    ImgWrapper,
    Img,
    TextContainer,
    Title,
    Description,
    PriceContainer,
    Price,
    EventBadge,
};
