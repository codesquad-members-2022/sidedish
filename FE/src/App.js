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
}

export default App;
