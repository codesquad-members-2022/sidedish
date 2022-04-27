import styled from "styled-components";

const Container = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 36px;
`;

const CarouselItems = styled.div`
    transition: transform 0.3s;
`;

const Icon = styled.svg`
    width: 24px;
    height: 24px;
    color: #bcbcbc;
    &:active,
    &:hover {
        color: ${(props) => (props.hasNext ? "#1b1b1b" : "#bcbcbc")};
    }
`;

export { Container, CarouselItems, Icon };
