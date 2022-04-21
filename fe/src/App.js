import "./App.css";
import "./reset.css";
import Card from "./component/UI/Card";
import Header from "./component/Header/Header";
import Tab from "./component/Tab/Tab";
import SubTitle from "./component/SubTitle/SubTitle";
function App() {
  return (
    <div className="app">
      <Header />
      <SubTitle />
      <Tab />
      <div className="card-wrapper">
        <Card />
        <Card />
        <Card />
      </div>
    </div>
  );
}

export default App;
