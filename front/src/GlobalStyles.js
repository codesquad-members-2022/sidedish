import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyles = createGlobalStyle`
    ${reset}
    button {
        background: none;
        border:none;
}
`;

export default GlobalStyles;
