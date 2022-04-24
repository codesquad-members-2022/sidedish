import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
* {
  margin: 0;
  padding: 0;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  box-sizing: border-box;
}

body {
  font-family: 'Noto Sans KR';
}

h1 {
  margin: 0;
}

a {
  color: inherit;
  text-decoration: none;
}

button,
input,
select,
textarea {
  background-color: transparent;
  border: 0;

  &:focus {
    outline: none;
    box-shadow: none;
  }
}

a,
button {
  cursor: pointer;
}

ul,
ol,
li,
menu {
  padding-left: 0;
  list-style: none;
}
`;

export default GlobalStyle;
