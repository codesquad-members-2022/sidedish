import { Header } from "@/components/templates/Header/Header";
import { Promotion } from "@/components/Promotion/Promotion";
import "./App.scss";

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
