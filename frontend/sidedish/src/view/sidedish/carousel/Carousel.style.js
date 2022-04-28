import styled, { keyframes } from "styled-components";

const Container = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 36px;
`;

const Icon = styled.button`
    svg {
        width: 24px;
        height: 24px;
        color: #bcbcbc;
        &:active,
        &:hover {
            color: ${(props) => (props.clickable ? "#1b1b1b" : "#bcbcbc")};
        }
    }
`;

const slideRight2Left = keyframes`
    from {
        margin-left: 326px;
        opacity: 1;
    }
    to {
        margin-left: -326px;
        opacity: 1;
    }
`;

const slideLeft2Right = keyframes`
    from {
        margin-left: -1000px;
        opacity: 1;
    }
    to {
        margin-left: -326px;
        opacity: 1;
    }
`;

const CarouselItem = styled.div`
    margin-left: -326px;
    animation: ${(props) =>
            props.direction === "L"
                ? slideLeft2Right
                : props.direction === "R"
                ? slideRight2Left
                : "none"}
        0.25s ease-out;
`;

const Wrapper = styled.div`
    width: 1280px;
    overflow: hidden;
`;

export { Container, Icon, CarouselItem, Wrapper };
