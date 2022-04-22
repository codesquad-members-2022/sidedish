import Header from './components/Header';
import Modal from './components/Modal';
import GlobalStyles from './GlobalStyles';

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
  badge_title: '한정특가',
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
      related_name: '한돈 매콤 안심장조림',
      related_image: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
      related_price: 6900,
      related_discount_price: 6210,
    },
    {
      related_name: '한돈 매콤 안심장조림',
      related_image: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
      related_price: 6900,
      related_discount_price: 6210,
    },
    {
      related_name: '한돈 매콤 안심장조림',
      related_image: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
      related_price: 6900,
      related_discount_price: 6210,
    },
    {
      related_name: '한돈 매콤 안심장조림',
      related_image: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
      related_price: 6900,
      related_discount_price: 6210,
    },
    {
      related_name: '한돈 매콤 안심장조림',
      related_image: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
      related_price: 6900,
      related_discount_price: 6210,
    },
  ],
};
function App() {
  return (
    <div className="App">
      <GlobalStyles></GlobalStyles>
      <Modal dishes={dishes}></Modal>
      <Header categories={categories}></Header>
    </div>
  );
}

export default App;
