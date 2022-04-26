import { Reset } from 'styled-reset';
import Header from './views/header/Header.js';
import { BestProduct } from './views/main/bestProduct/BestProduct.js';
import { CategoryArea } from './views/main/categoryArea/CategoryArea.js';

function App() {
  return (
    <div className="App">
      <Reset />
      <Header />
      <BestProduct />
      <CategoryArea />
    </div>
  );
}
export default App;
