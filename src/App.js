import React, { useEffect, useState } from 'react';
import { ThemeProvider } from 'styled-components';
import Header from './Components/header/main';
import Main from './Components/main/main';
import { setfoodData } from './Store/foodData';
import { theme } from './Assets/theme';

function App() {
  const [hasData, setHasData] = useState(false);
  useEffect(() => {
    async function setData() {
      await setfoodData();
      setHasData(true);
    }
    setData();
  }, []);
  return (
    <ThemeProvider theme={theme}>
      <div className="App">
        <Header />
        <Main hasData={hasData} />
      </div>
    </ThemeProvider>
  );
}

export default App;
