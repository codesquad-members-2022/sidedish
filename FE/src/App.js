import Header from './components/Header';
import Main from './components/Main/Main';
import FoodModal from './components/Modal/FoodModal';
import Modal from './components/Modal/Modal';
import CardInfoContext from './context/ModalCardInfoContext';
import GlobalStyles from './globalStyles';

function App() {
  return (
    <CardInfoContext>
      <div className="App">
        <GlobalStyles />
        <Header />
        <Main />
        <Modal ModalDetail={<FoodModal />} />
      </div>
    </CardInfoContext>
  );
}

export default App;
