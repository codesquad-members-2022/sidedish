import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  html {
    box-sizing: border-box;
    font-size: 10px;
    font-family: Noto Sans KR;
    color: #1B1B1B;
  }

  a {
    color: #1B1B1B;
    text-decoration: none;
  }
`;

export default GlobalStyle;
