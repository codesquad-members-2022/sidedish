<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import { Header } from "@/components/templates/Header/Header";
import { Promotion } from "@/components/templates/Promotion/Promotion";
=======
import { Header } from "@src/components/Header/Header";
>>>>>>> 159047b (Chore: 깃 충돌 해결 과정에서 꼬인 코드 수정)
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
<<<<<<< HEAD
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
=======
import { Header } from "./components/Header/Header";
=======
import { Header } from "@src/components/Header/Header";
>>>>>>> e0194a0 ([#8] Refactor: import 경로 수정)
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
=======
>>>>>>> 159047b (Chore: 깃 충돌 해결 과정에서 꼬인 코드 수정)
}

>>>>>>> fd015ab ([#8] Feat: Header 구현)
export default App;
