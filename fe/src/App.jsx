import Reset from "./Styles/Reset";
import Normalize from "./Styles/Normalize";
import Header from "./Component/Header/Header";
import Main from "./Component/Main/Main";

const App = () => {
  return (
    <div className="App">
      <Reset />
      <Normalize />
      {/* TODO: 링크 연결 하드코딩인것 문제 랑.. 해결 */}
      <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&family=Outfit:wght@500&display=swap"
        rel="stylesheet"
      />
      <Header />
      <Main />
    </div>
  );
};

export default App;
