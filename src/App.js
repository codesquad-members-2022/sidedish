import React, { useEffect, useState } from 'react';
import Header from './Components/header/main';
import Main from './Components/main/main';
import { setfoodData } from './Store/foodData';

function App() {
  const [hasData, setHasData] = useState(false);
  useEffect(() => {
    async function setData() {
      await setfoodData();
      setHasData(true);
    }
    setData();
  }, [hasData]);
  return (
    <div className="App">
      <Header />
      <Main hasData={hasData} />
    </div>
  );
}

export default App;
