import React from "react";
import ReactDOM from "react-dom/client";
import App from "./components/App";
import styled, { ThemeProvider } from "styled-components";
import theme from "./styles/theme.js";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      <App />
    </ThemeProvider>
  </React.StrictMode>
);
