import { Header } from "@/components/templates/Header/Header";
import { Promotion } from "@/components/templates/Promotion/Promotion";
import "./App.scss";

function App() {
  return (
    <div>
      <Header />
      <main>
        <Promotion dataID="1" />
      </main>
    </div>
  );
}

export default App;
