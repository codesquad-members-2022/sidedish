<<<<<<< HEAD
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

=======
import React from "react";

const App = () => {
  return (
    <div className="App">
      <h1>Hello React World!</h1>
    </div>
  );
};
>>>>>>> ccf5e4b ([#6] Chore: CRA 없이 React 빌드 환경 구축)
export default App;
