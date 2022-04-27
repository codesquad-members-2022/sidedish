import { useState, useEffect } from 'react';
import Header from './components/Header';
import Modal from './components/Modal';
import Promotion from './components/Promotion';
import GlobalStyles from './GlobalStyles';
import Alert from './components/Alert';
import Main from './components/Main';
import styled from 'styled-components';
import { fetchCategories, fetchDishes, fetchEventCategories } from './api';

function App() {
  const [alert, setAlert] = useState({ show: false, message: '' });
  const [modal, setModal] = useState({ show: false, dishId: null });
  const [categories, setCategories] = useState(null);
  const [promotions, setPromotions] = useState(null);
  const [categoryItems, setCategoryItems] = useState(null);

  function showAlert(message) {
    setAlert({ show: true, message });
  }
  function hideAlert() {
    setAlert({ show: false, message: '' });
  }
  function showModal(dishId) {
    setModal({ show: true, dishId });
  }
  function hideModal() {
    setModal({ show: false, dishId: null });
  }
  useEffect(() => {
    async function initFetchAndSet() {
      const categories = await fetchCategories();
      const eventCategories = await fetchEventCategories();
      const dishes = await fetchDishes();

      const promotions = eventCategories.map(({ id, name }) => ({ id, title: name, items: [] }));
      dishes.eventItems.forEach(dish => {
        promotions.forEach(promotion => {
          if (dish.categories.includes(promotion.id)) {
            promotion.items.push(dish);
          }
        });
      });
      const categoryItems = categories.map(({ id, name }) => ({ id, name, items: [] }));
      dishes.items.forEach(dish => {
        categoryItems.forEach(category => {
          if (dish.categories.includes(category.id)) {
            category.items.push(dish);
          }
        });
      });
      setCategories(categories);
      setPromotions(promotions);
      setCategoryItems(categoryItems);
    }
    initFetchAndSet();
  }, []);
  return (
    <AppWrap>
      <GlobalStyles></GlobalStyles>
      {modal.show && <Modal dishId={modal.dishId} hideModal={hideModal} showModal={showModal}></Modal>}
      {alert.show && <Alert message={alert.message} hideAlert={hideAlert}></Alert>}
      {categories && promotions && (
        <>
          <Header categories={categories}></Header>
          <Promotion
            title={'둘이 먹다 하나가 죽어도 모르는 반찬'}
            promotions={promotions}
            showModal={showModal}
          ></Promotion>
          <Main categories={categoryItems} showModal={showModal}></Main>
        </>
      )}
    </AppWrap>
  );
}

const AppWrap = styled.div`
  min-width: 1400px;
`;

export default App;
