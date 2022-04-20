import Header from './components/Header';
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

function App() {
  return (
    <div className="App">
      <GlobalStyles></GlobalStyles>
      <Header categories={categories}></Header>
    </div>
  );
}

export default App;
