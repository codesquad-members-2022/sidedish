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
`;

export default GlobalStyle;
