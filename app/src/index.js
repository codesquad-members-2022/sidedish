import React from "react";
import ReactDOM from "react-dom/client";
import App from "./components/App";
import { ThemeProvider } from "styled-components";
import { Reset } from "styled-reset";
import GlobalStyle from "./styles/global.js";
import theme from "./styles/theme.js";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Reset />
    <GlobalStyle />
    <ThemeProvider theme={theme}>
      <App />
    </ThemeProvider>
  </React.StrictMode>
);
