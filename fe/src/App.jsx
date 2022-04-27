import { ThemeProvider } from 'styled-components';
import GlobalStyles from 'GlobalStyles';
import theme from 'theme';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from 'Home';
import Callback from 'Callback';

function App() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <GlobalStyles />
        <Router>
          <Routes>
            <Route exact path="/" element={<Home />}></Route>
            <Route path="/callback" element={<Callback />}></Route>
          </Routes>
        </Router>
      </ThemeProvider>
    </>
  );
}

export default App;
