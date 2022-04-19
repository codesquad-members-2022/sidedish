import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

export const colors = {
  bgColor: "#F7F9FA",
  fontWhite: "red",
};

export const GlobalStyles = createGlobalStyle`
    ${reset}
    body{
        background-color: lightcyan;
    }
`;
