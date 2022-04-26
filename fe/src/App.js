import { Reset } from 'styled-reset';
import Header from './views/header/Header.js';
import { BestProduct } from './views/main/bestProduct/BestProduct.js';
import { Category } from './views/main/category/Category.js';

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
