import { Reset } from 'styled-reset';
import Header from './components/header/Header.js';
import { BestProduct } from './components/main/bestProduct/BestProduct.js';
import { CategoryArea } from './components/main/categoryArea/CategoryArea.js';

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
