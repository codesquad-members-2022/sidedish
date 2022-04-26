import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';
import { Color } from './Assets/CommonStyle';
const GlobalStyles = createGlobalStyle` 
  ${reset}

    body {
      line-height: 1.2;
      color: ${Color.black};
    }

    a{
        text-decoration: none;
        color: inherit;
    }
    *{
        box-sizing: border-box;
    }
    input, textarea { 
      -moz-user-select: auto;
      -webkit-user-select: auto;
      -ms-user-select: auto;
      user-select: auto;
    }
    input:focus {
      outline: none;
    }

    button {
      border: none;
      background: none;
      padding: 0;
      cursor: pointer;
    }
`;

export default GlobalStyles;
