import styled from "styled-components";

const Container = styled.div`
    display: flex;
    flex-direction: column;
    border-bottom: 1px solid #ebebeb;
    padding: 56px 0px;
`;

const Header = styled.div`
    border-bottom: 1px solid #ebebeb;
`;

const Title = styled.h2`
    font-size: 4rem;
    font-weight: 700;
    line-height: 58px;
    letter-spacing: -0.004em;
    text-align: left;
    margin: 0 auto;
    width: 1280px;
`;

const TabBar = styled.ul`
    display: flex;
    gap: 32px;
    margin: 24px auto 0;
    width: 1280px;
`;

const Tab = styled.li`
    font-size: 2rem;
    font-weight: 500;
    line-height: 30px;
    letter-spacing: -0.008em;
    text-align: center;
    padding-bottom: 15px;
    cursor: pointer;
    border-bottom: ${(props) => (props.isCurrTab ? "solid 2px black" : "")};
`;

const CardsContainer = styled.ul`
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    margin: 34px auto;
    width: 1280px;
`;

const CardImgWrapper = styled.div`
    width: 300px;
    height: 300px;
`;

const CardImg = styled.img`
    width: 100%;
    height: 100%;
    object-fit: cover;
`;

const CardTextContainer = styled.div`
    display: flex;
    flex-direction: column;
    gap: 8px;
    margin-top: 16px;
    margin-bottom: 22px;
`;

const CardTitle = styled.h3`
    font-weight: 500;
    font-size: 1.6rem;
    line-height: 26px;
    letter-spacing: -0.008em;
    color: #3f3f3f;
`;

const CardDescription = styled.p`
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
    Container,
    Header,
    Title,
    TabBar,
    Tab,
    CardsContainer,
    CardImgWrapper,
    CardImg,
    CardTextContainer,
    CardTitle,
    CardDescription,
    PriceContainer,
    Price,
    EventBadge,
};
