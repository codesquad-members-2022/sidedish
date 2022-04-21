import Header from './components/Header.js';
import { Reset } from 'styled-reset';
import { BestProduct } from './components/BestProduct.js';

function App() {
  return (
    <div className="App">
      <Reset />
      <Header />
      <BestProduct />
    </div>
  );
}
export default App;
