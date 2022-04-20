import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyles = createGlobalStyle`
    ${reset}
    * {
      box-sizing: border-box;
    }
    button{
      border:none;
    }
    body {
      font-family: "Noto Sans KR", sans-serif;
      letter-spacing: -0.008em;
    }
`;

export default GlobalStyles;
