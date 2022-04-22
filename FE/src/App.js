
import { Header } from "@src/components/Header/Header";
import "./App.scss";
import { Promotion } from "@src/components/Promotion/Promotion";

function App() {
  return (
    <div>
      <Header />
      <main>
        <Promotion />
      </main>
    </div>
  );
import { Header } from "./components/Header/Header";
import "./App.scss";

function App() {
  return <Header />;
}

export default App;
