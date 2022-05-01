import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const GlobalStyle = createGlobalStyle`
    ${reset}
    html {
        font-size: 10px;
    }
    body {
        font-family: "Noto Sans KR";
        font-style: normal;
    }
    button {
        border: 0;
        outline: 0;
        background-color: transparent;
    }
    svg {
        color: black;
        &:link,
        &:visited,
        &:hover,
        &:active {
            color: black;
        }
    }
`;

export default GlobalStyle;
