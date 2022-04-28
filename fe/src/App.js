import { Reset } from 'styled-reset';
import Header from './components/header/Header.js';
import { Main } from './components/main/main.js';

function App() {
  return (
    <div className="App">
      <Reset />
      <Header />
      <Main></Main>
    </div>
  );
}
export default App;
