import { ThemeProvider } from "styled-components";
import Reset from "Styles/Reset";
import Normalize from "Styles/Normalize";
import Header from "Component/Header/Header";
import Main from "Component/Main/Main";
import theme from "Styles/theme";

const App = () => {
  return (
    <div className="App">
      <ThemeProvider theme={theme}>
        <Reset />
        <Normalize />
        <Header />
        <Main />
      </ThemeProvider>
    </div>
  );
};

export default App;
