import "./App.css";
import "./reset.css";
import Card from "./component/Card";
import Header from "./component/Header/Header";

function App() {
  return (
    <div className="App">
      <Header />
      <div className="card-wrapper">
        <Card />
        <Card />
        <Card />
      </div>
    </div>
  );
}

export default App;
