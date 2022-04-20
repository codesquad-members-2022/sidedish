import "./App.css";
import "./reset.css";
import Card from "./component/UI/Card";
import Header from "./component/Header/Header";
import Tab from "./component/Tab/Tab";

function App() {
  return (
    <div className="App">
      <Header />
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
