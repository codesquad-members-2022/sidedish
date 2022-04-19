import styled, { ThemeProvider } from "styled-components";
import { Reset } from "styled-reset";
import theme from "../styles/theme.js";
import Header from "./Header.js";

const Container = styled.div`
  font-size: 10px;
`;

function App() {
  return (
    <Container>
      <ThemeProvider theme={theme}>
        <Header />
        <Reset />
      </ThemeProvider>
    </Container>
  );
}

export default App;
