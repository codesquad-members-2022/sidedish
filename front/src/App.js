import { useState } from 'react';
import Header from './components/Header';
import Modal from './components/Modal';
import Promotion from './components/Promotion';
import GlobalStyles from './GlobalStyles';
import Alert from './components/Alert';
import Main from './components/Main';
import styled from 'styled-components';

const categories = [
  {
    id: 1,
    name: '메인요리',
    children: [
      { id: 1, name: '육류' },
      { id: 2, name: '해산물' },
    ],
  },
  { id: 2, name: '국물요리', children: [{ id: 5, name: '국/탕찌개' }] },
  {
    id: 3,
    name: '밑반찬',
    children: [
      { id: 3, name: '나물/무침' },
      { id: 4, name: '조림/볶음' },
      { id: 6, name: '절임/장아찌' },
    ],
  },
];
const dishes = {
  id: 1,
  main_category_id: 11,
  sub_category_id: 111,
  name: '오리 주물럭_반조리',
  content: '칠맛 나는 매콤한 양념',
  badge_title: ['이벤트특가', '런칭특가'],
  price: 15000,
  discount_price: 12600,
  mileage_ratio: 0.01,
  early_delivery: true,
  delivery_price: 2500,
  delevery_free_price: 40000,
  stock: 100,
  images: [
    'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    'http://public.codesquad.kr/jk/storeapp/data/side/17_ZIP_P_6014_T.jpg',
    'http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_T.jpg',
  ],
  related_dishes: [
    {
      id: 1,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '스테이크1',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 2,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '스테이크2',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 3,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '스테이크3',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 4,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '스테이크4',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 5,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '스테이크5',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 6,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '스테이크6',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 7,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '스테이크7',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
  ],
};
const MainCategories = [
  {
    id: 1,
    name: '든든한 메인요리',
    children: [
      { id: 2, name: '육류 요리', children: null },
      { id: 3, name: '해산물 요리', children: null },
    ],
  },
  {
    id: 4,
    name: '뜨끈한 국물요리',
    children: [{ id: 5, name: '국/탕/찌개', children: null }],
  },
  {
    id: 7,
    name: '정갈한 밑반찬',
    children: [{ id: 6, name: '국/탕/찌개', children: null }],
  },
];

function App() {
  const [alert, setAlert] = useState({ show: false, message: '' });
  const [modal, setModal] = useState({ show: false, cardId: null });
  function showAlert(message) {
    setAlert({ show: true, message });
  }
  function hideAlert() {
    setAlert({ show: false, message: '' });
    hideModal();
  }
  function showModal(cardId) {
    setModal({ show: true, cardId });
  }
  function hideModal() {
    setModal({ show: false, cardId: null });
  }
  return (
    <AppWrap>
      <GlobalStyles></GlobalStyles>
      {modal.show && (
        <Modal
          dishes={dishes}
          cardId={modal.cardId}
          hideModal={hideModal}
          showModal={showModal}
          showAlert={showAlert}
        ></Modal>
      )}
      <Header categories={categories}></Header>
      <Promotion showModal={showModal}></Promotion>
      <Main categories={MainCategories} showModal={showModal}></Main>
      {alert.show && <Alert message={alert.message} hideAlert={hideAlert}></Alert>}
    </AppWrap>
  );
}

const AppWrap = styled.div`
  min-width: 1400px;
`;

export default App;
