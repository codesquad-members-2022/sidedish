import React from 'react';

import Header from './components/Header';
import Main from './components/Main/Main';
import GlobalStyles from './globalStyles';

function App() {
  return (
    <div className="App">
      <GlobalStyles />
      <Header />
      <Main />
    </div>
  );
}

export default App;
