import Header from './views/Header.js';
import { Reset } from 'styled-reset';
import { BestProduct } from './views/BestProduct.js';

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
