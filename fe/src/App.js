import Header from './views/Header.js';
import { Reset } from 'styled-reset';
import { BestProduct } from './views/BestProduct.js';
import { Category } from './views/Category';

function App() {
  return (
    <div className="App">
      <Reset />
      <Header />
      <BestProduct />
      <Category />
    </div>
  );
}
export default App;
