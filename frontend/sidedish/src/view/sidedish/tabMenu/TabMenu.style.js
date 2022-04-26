import styled from "styled-components";

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

export { TabBar, Tab };
