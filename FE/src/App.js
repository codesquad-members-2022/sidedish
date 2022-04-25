import { Header } from "@/components/Header/Header";
import "./App.scss";
import { Promotion } from "@/components/Promotion/Promotion";

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
