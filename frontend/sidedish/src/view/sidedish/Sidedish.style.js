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
    font-size: ${(props) =>
        props.theme.size === "big" ? "4rem" : "small" ? "2rem" : ""};
    font-weight: ${(props) =>
        props.theme.size === "big" ? 700 : "small" ? 500 : 0};
    line-height: 58px;
    letter-spacing: -0.004em;
    text-align: left;
    margin: 0 auto;
    width: 1280px;
`;

const CardsContainer = styled.ul`
    display: grid;
    grid-template-columns: repeat(
        ${(props) => (props.theme.size === "big" ? 3 : "small" ? 4 : 0)},
        1fr
    );
    gap: 24px;
    margin: 34px auto;
    width: 1280px;
`;

export { Container, Header, Title, CardsContainer };
