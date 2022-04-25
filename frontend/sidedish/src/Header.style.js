import styled from "styled-components";

const HeaderContainer = styled.header`
    border-bottom: 1px solid black;
`;

const HeaderInnerContainer = styled.div`
    display: flex;
    margin: 25px auto;
    width: 1280px;
`;

const HeaderTitle = styled.h1`
    font-family: "Outfit";
    font-weight: 900;
    font-size: 4rem;
    line-height: 50px;
    color: #1b1b1b;
`;

const HeaderNav = styled.nav`
    display: flex;
    width: 100%;
    margin-left: 40px;
`;

const HeaderNavList = styled.ul`
    display: flex;
    gap: 24px;
    margin-top: 23px;
    align-items: flex-start;
    padding-bottom: 10px;
`;

const HeaderIcons = styled.ul`
    display: flex;
    gap: 25px;
    margin-top: 23px;
    margin-left: auto;
    align-items: flex-start;
`;

const HeaderIcon = styled.li`
    width: 24px;
    height: 24px;
    cursor: pointer;
`;

const HeaderFoodList = styled.ul`
    display: ${(props) => (props.isVisible ? "flex" : "none")};
    flex-direction: column;
    gap: 8px;
`;

const HeaderFoodTitle = styled.p`
    font-weight: 400;
    font-size: 1.6rem;
    line-height: 26px;
    letter-spacing: -0.008em;
    color: #1b1b1b;
    margin-bottom: 8px;
    cursor: pointer;
`;

const HeaderFoodItem = styled.li`
    font-weight: 400;
    font-size: 1.4rem;
    line-height: 24px;
    letter-spacing: -0.008em;
    cursor: pointer;
    &:hover {
        color: #777;
        text-decoration: underline;
    }
`;

export {
    HeaderContainer,
    HeaderInnerContainer,
    HeaderTitle,
    HeaderNav,
    HeaderNavList,
    HeaderIcons,
    HeaderIcon,
    HeaderFoodList,
    HeaderFoodTitle,
    HeaderFoodItem,
};
