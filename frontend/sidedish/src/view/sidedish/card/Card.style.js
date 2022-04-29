import styled from "styled-components";

const CardContainer = styled.li`
    cursor: pointer;
`;
const DishCard = styled.li`
    position: relative;
`;
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

const ClientPrice = styled.span`
    font-weight: 500;
    font-size: 1.6rem;
    line-height: 26px;
    color: #1b1b1b;
    letter-spacing: -0.008em;
`;

const OriginPrice = styled.span`
    font-weight: 400;
    font-size: 1.4rem;
    line-height: 24px;
    letter-spacing: -0.008em;
    text-decoration-line: line-through;
    color: #bcbcbc;
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

const DeliveryBadge = styled.ul`
    position: absolute;
    top: 5%;
    right: 5%;
    border: 1px solid #1b1b1b;
    border-radius: 10px;
    background-color: rgba(248, 247, 247, 0.8);
    display: ${(props) => (props.isVisible ? "flex" : "none")};
    font-weight: 500;
    font-size: 1.4rem;
    padding: 5px 10px;
    flex-direction: column;
    gap: 6px;
`;

export {
    CardContainer,
    DishCard,
    ImgWrapper,
    Img,
    TextContainer,
    Title,
    Description,
    PriceContainer,
    ClientPrice,
    OriginPrice,
    EventBadge,
    DeliveryBadge,
};
