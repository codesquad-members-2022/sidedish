import "./App.css";
import "./reset.css";

import Header from "./component/Header/Header";
import Tab from "./component/Tab/Tab";
import SubTitle from "./component/SubTitle/SubTitle";
import Slide from "./component/bottom/Slide";

function App() {
  return (
    <div className="app">
      <Header />
      <SubTitle />
      <Tab />
      <Slide />
    </div>
  );
}

export default App;
