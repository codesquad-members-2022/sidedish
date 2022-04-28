import styled from "styled-components";

const Container = styled.div`
    display: flex;
    flex-direction: column;
    padding: 56px 0px;
`;

const BigContainer = styled(Container)`
    border-bottom: 1px solid #ebebeb;
`;

const Header = styled.div`
    border-bottom: 1px solid #ebebeb;
`;

const Title = styled.h2`
    line-height: 58px;
    letter-spacing: -0.004em;
    text-align: left;
    margin: 0 auto;
    width: 1280px;
`;

const BigDishTitle = styled(Title)`
    font-size: 4rem;
    font-weight: 700;
`;

const SmallDishTitle = styled(Title)`
    font-size: 2rem;
    font-weight: 500;
`;

const CardsContainer = styled.ul`
    display: grid;
    gap: 24px;
    margin: 34px auto;
    width: 1280px;
`;

const BigCardsContainer = styled(CardsContainer)`
    grid-template-columns: repeat(3, 1fr);
`;

const SmallCardsContainer = styled(CardsContainer)`
    grid-template-columns: repeat(4, 1fr);
`;

export {
    Container,
    BigContainer,
    Header,
    BigDishTitle,
    SmallDishTitle,
    BigCardsContainer,
    SmallCardsContainer,
};
