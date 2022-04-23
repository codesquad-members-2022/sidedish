import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyles = createGlobalStyle`
    ${reset}
    button {
        background: none;
        border:none;
}
    div {
        font-family: 'Noto Sans KR';
        font-style: normal;
        font-weight: 500;
}
`;

export default GlobalStyles;
