import { createGlobalStyle } from "styled-components";

const Normalize = createGlobalStyle`
  h1 {
    font-family: "Outfit", sans-serif;
    font-weight: 900;
    font-size: 40px;
    line-height: 50px;
  }

  button {
    cursor: pointer;
  }
`;

export default Normalize;
